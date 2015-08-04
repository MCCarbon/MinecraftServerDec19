package net.minecraft.server;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

public class ChatTypeAdapterFactory implements TypeAdapterFactory {

	@SuppressWarnings("unchecked")
	public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
		Class<? super T> clazz = type.getRawType();
		if (!clazz.isEnum()) {
			return null;
		} else {
			final HashMap<String, T> map = Maps.newHashMap();

			for (Object obj : clazz.getEnumConstants()) {
				map.put(this.getObjName(obj), (T) obj);
			}

			return new TypeAdapter<T>() {
				public void write(JsonWriter writer, T t) throws IOException {
					if (t == null) {
						writer.nullValue();
					} else {
						writer.value(ChatTypeAdapterFactory.this.getObjName(t));
					}
				}

				public T read(JsonReader reader) throws IOException {
					if (reader.peek() == JsonToken.NULL) {
						reader.nextNull();
						return null;
					} else {
						return map.get(reader.nextString());
					}
				}
			};
		}
	}

	private String getObjName(Object obj) {
		return obj instanceof Enum ? ((Enum<?>) obj).name().toLowerCase(Locale.US) : obj.toString().toLowerCase(Locale.US);
	}

}
