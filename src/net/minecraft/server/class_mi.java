package net.minecraft.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class class_mi {
	protected static final Logger a = LogManager.getLogger();
	protected final Gson b;
	private final File c;
	private final Map d = Maps.newHashMap();
	private boolean e = true;
	private static final ParameterizedType f = new ParameterizedType() {
		@Override
		public Type[] getActualTypeArguments() {
			return new Type[] { class_mh.class };
		}

		@Override
		public Type getRawType() {
			return List.class;
		}

		@Override
		public Type getOwnerType() {
			return null;
		}
	};

	public class_mi(File var1) {
		c = var1;
		GsonBuilder var2 = (new GsonBuilder()).setPrettyPrinting();
		var2.registerTypeHierarchyAdapter(class_mh.class, new class_mi.class_a_in_class_mi(null));
		b = var2.create();
	}

	public boolean b() {
		return e;
	}

	public void a(boolean var1) {
		e = var1;
	}

	public File c() {
		return c;
	}

	public void a(class_mh var1) {
		d.put(this.a(var1.f()), var1);

		try {
			f();
		} catch (IOException var3) {
			a.warn("Could not save the list after adding a user.", var3);
		}

	}

	public class_mh b(Object var1) {
		h();
		return (class_mh) d.get(this.a(var1));
	}

	public void c(Object var1) {
		d.remove(this.a(var1));

		try {
			f();
		} catch (IOException var3) {
			a.warn("Could not save the list after removing a user.", var3);
		}

	}

	public String[] a() {
		return (String[]) d.keySet().toArray(new String[d.size()]);
	}

	public boolean d() {
		return d.size() < 1;
	}

	protected String a(Object var1) {
		return var1.toString();
	}

	protected boolean d(Object var1) {
		return d.containsKey(this.a(var1));
	}

	private void h() {
		ArrayList var1 = Lists.newArrayList();
		Iterator var2 = d.values().iterator();

		while (var2.hasNext()) {
			class_mh var3 = (class_mh) var2.next();
			if (var3.e()) {
				var1.add(var3.f());
			}
		}

		var2 = var1.iterator();

		while (var2.hasNext()) {
			Object var4 = var2.next();
			d.remove(var4);
		}

	}

	protected class_mh a(JsonObject var1) {
		return new class_mh((Object) null, var1);
	}

	protected Map e() {
		return d;
	}

	public void f() throws IOException {
		Collection var1 = d.values();
		String var2 = b.toJson(var1);
		BufferedWriter var3 = null;

		try {
			var3 = Files.newWriter(c, Charsets.UTF_8);
			var3.write(var2);
		} finally {
			IOUtils.closeQuietly(var3);
		}

	}

	public void g() throws FileNotFoundException {
		Collection var1 = null;
		BufferedReader var2 = null;

		try {
			var2 = Files.newReader(c, Charsets.UTF_8);
			var1 = (Collection) b.fromJson((Reader) var2, (Type) f);
		} finally {
			IOUtils.closeQuietly(var2);
		}

		if (var1 != null) {
			d.clear();
			Iterator var3 = var1.iterator();

			while (var3.hasNext()) {
				class_mh var4 = (class_mh) var3.next();
				if (var4.f() != null) {
					d.put(this.a(var4.f()), var4);
				}
			}
		}

	}

	class class_a_in_class_mi implements JsonDeserializer, JsonSerializer {
		private class_a_in_class_mi() {
		}

		public JsonElement a(class_mh var1, Type var2, JsonSerializationContext var3) {
			JsonObject var4 = new JsonObject();
			var1.a(var4);
			return var4;
		}

		public class_mh a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
			if (var1.isJsonObject()) {
				JsonObject var4 = var1.getAsJsonObject();
				class_mh var5 = class_mi.this.a(var4);
				return var5;
			} else {
				return null;
			}
		}

		// $FF: synthetic method
		@Override
		public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
			return this.a((class_mh) var1, var2, var3);
		}

		// $FF: synthetic method
		@Override
		public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
			return this.a(var1, var2, var3);
		}

		// $FF: synthetic method
		class_a_in_class_mi(Object var2) {
			this();
		}
	}
}
