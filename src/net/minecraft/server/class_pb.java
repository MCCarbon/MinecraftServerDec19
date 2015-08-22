package net.minecraft.server;

import java.lang.reflect.Type;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class class_pb implements class_ok {
	public static final Gson a = (new GsonBuilder()).registerTypeAdapter(class_eu.class, new JsonDeserializer() {
		public class_eu a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
			if (var1.isJsonPrimitive()) {
				return new class_fa(var1.getAsString());
			} else if (var1.isJsonArray()) {
				JsonArray var4 = var1.getAsJsonArray();
				class_eu var5 = null;
				Iterator var6 = var4.iterator();

				while (var6.hasNext()) {
					JsonElement var7 = (JsonElement) var6.next();
					class_eu var8 = this.a(var7, var7.getClass(), var3);
					if (var5 == null) {
						var5 = var8;
					} else {
						var5.a(var8);
					}
				}

				return var5;
			} else {
				throw new JsonParseException("Don\'t know how to turn " + var1.toString() + " into a Component");
			}
		}

		// $FF: synthetic method
		@Override
		public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
			return this.a(var1, var2, var3);
		}
	}).create();

	@Override
	public int a() {
		return 101;
	}

	@Override
	public class_dn a(class_dn var1) {
		if ("Sign".equals(var1.l("id"))) {
			this.a(var1, "Text1");
			this.a(var1, "Text2");
			this.a(var1, "Text3");
			this.a(var1, "Text4");
		}

		return var1;
	}

	private void a(class_dn var1, String var2) {
		String var3 = var1.l(var2);
		Object var4 = null;

		try {
			var4 = a.fromJson(var3, class_eu.class);
			if (var4 == null) {
				var4 = new class_fa("");
			}
		} catch (JsonParseException var8) {
			;
		}

		if (var4 == null) {
			try {
				var4 = class_eu.class_a_in_class_eu.a(var3);
			} catch (JsonParseException var7) {
				;
			}
		}

		if (var4 == null) {
			try {
				var4 = class_eu.class_a_in_class_eu.b(var3);
			} catch (JsonParseException var6) {
				;
			}
		}

		if (var4 == null) {
			var4 = new class_fa(var3);
		}

		var1.a(var2, class_eu.class_a_in_class_eu.a((class_eu) var4));
	}
}
