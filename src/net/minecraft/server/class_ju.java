package net.minecraft.server;

import java.lang.reflect.Type;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.authlib.GameProfile;

public class class_ju {
	private IChatBaseComponent a;
	private class_ju.class_a_in_class_ju b;
	private class_ju.class_c_in_class_ju c;
	private String d;

	public IChatBaseComponent a() {
		return a;
	}

	public void a(IChatBaseComponent var1) {
		a = var1;
	}

	public class_ju.class_a_in_class_ju b() {
		return b;
	}

	public void a(class_ju.class_a_in_class_ju var1) {
		b = var1;
	}

	public class_ju.class_c_in_class_ju c() {
		return c;
	}

	public void a(class_ju.class_c_in_class_ju var1) {
		c = var1;
	}

	public void a(String var1) {
		d = var1;
	}

	public String d() {
		return d;
	}

	public static class class_b_in_class_ju implements JsonDeserializer, JsonSerializer {
		public class_ju a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
			JsonObject var4 = class_nq.l(var1, "status");
			class_ju var5 = new class_ju();
			if (var4.has("description")) {
				var5.a((IChatBaseComponent) var3.deserialize(var4.get("description"), IChatBaseComponent.class));
			}

			if (var4.has("players")) {
				var5.a((class_ju.class_a_in_class_ju) var3.deserialize(var4.get("players"), class_ju.class_a_in_class_ju.class));
			}

			if (var4.has("version")) {
				var5.a((class_ju.class_c_in_class_ju) var3.deserialize(var4.get("version"), class_ju.class_c_in_class_ju.class));
			}

			if (var4.has("favicon")) {
				var5.a(class_nq.h(var4, "favicon"));
			}

			return var5;
		}

		public JsonElement a(class_ju var1, Type var2, JsonSerializationContext var3) {
			JsonObject var4 = new JsonObject();
			if (var1.a() != null) {
				var4.add("description", var3.serialize(var1.a()));
			}

			if (var1.b() != null) {
				var4.add("players", var3.serialize(var1.b()));
			}

			if (var1.c() != null) {
				var4.add("version", var3.serialize(var1.c()));
			}

			if (var1.d() != null) {
				var4.addProperty("favicon", var1.d());
			}

			return var4;
		}

		// $FF: synthetic method
		@Override
		public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
			return this.a((class_ju) var1, var2, var3);
		}

		// $FF: synthetic method
		@Override
		public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
			return this.a(var1, var2, var3);
		}
	}

	public static class class_c_in_class_ju {
		private final String a;
		private final int b;

		public class_c_in_class_ju(String var1, int var2) {
			a = var1;
			b = var2;
		}

		public String a() {
			return a;
		}

		public int b() {
			return b;
		}

		public static class class_c_in_class_ju$class_a_in_class_c_in_class_ju implements JsonDeserializer, JsonSerializer {
			public class_ju.class_c_in_class_ju a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
				JsonObject var4 = class_nq.l(var1, "version");
				return new class_ju.class_c_in_class_ju(class_nq.h(var4, "name"), class_nq.m(var4, "protocol"));
			}

			public JsonElement a(class_ju.class_c_in_class_ju var1, Type var2, JsonSerializationContext var3) {
				JsonObject var4 = new JsonObject();
				var4.addProperty("name", var1.a());
				var4.addProperty("protocol", Integer.valueOf(var1.b()));
				return var4;
			}

			// $FF: synthetic method
			@Override
			public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
				return this.a((class_ju.class_c_in_class_ju) var1, var2, var3);
			}

			// $FF: synthetic method
			@Override
			public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
				return this.a(var1, var2, var3);
			}
		}
	}

	public static class class_a_in_class_ju {
		private final int a;
		private final int b;
		private GameProfile[] c;

		public class_a_in_class_ju(int var1, int var2) {
			a = var1;
			b = var2;
		}

		public int a() {
			return a;
		}

		public int b() {
			return b;
		}

		public GameProfile[] c() {
			return c;
		}

		public void a(GameProfile[] var1) {
			c = var1;
		}

		public static class class_a_in_class_ju$class_a_in_class_a_in_class_ju implements JsonDeserializer, JsonSerializer {
			public class_ju.class_a_in_class_ju a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
				JsonObject var4 = class_nq.l(var1, "players");
				class_ju.class_a_in_class_ju var5 = new class_ju.class_a_in_class_ju(class_nq.m(var4, "max"), class_nq.m(var4, "online"));
				if (class_nq.d(var4, "sample")) {
					JsonArray var6 = class_nq.t(var4, "sample");
					if (var6.size() > 0) {
						GameProfile[] var7 = new GameProfile[var6.size()];

						for (int var8 = 0; var8 < var7.length; ++var8) {
							JsonObject var9 = class_nq.l(var6.get(var8), "player[" + var8 + "]");
							String var10 = class_nq.h(var9, "id");
							var7[var8] = new GameProfile(UUID.fromString(var10), class_nq.h(var9, "name"));
						}

						var5.a(var7);
					}
				}

				return var5;
			}

			public JsonElement a(class_ju.class_a_in_class_ju var1, Type var2, JsonSerializationContext var3) {
				JsonObject var4 = new JsonObject();
				var4.addProperty("max", Integer.valueOf(var1.a()));
				var4.addProperty("online", Integer.valueOf(var1.b()));
				if ((var1.c() != null) && (var1.c().length > 0)) {
					JsonArray var5 = new JsonArray();

					for (int var6 = 0; var6 < var1.c().length; ++var6) {
						JsonObject var7 = new JsonObject();
						UUID var8 = var1.c()[var6].getId();
						var7.addProperty("id", var8 == null ? "" : var8.toString());
						var7.addProperty("name", var1.c()[var6].getName());
						var5.add(var7);
					}

					var4.add("sample", var5);
				}

				return var4;
			}

			// $FF: synthetic method
			@Override
			public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
				return this.a((class_ju.class_a_in_class_ju) var1, var2, var3);
			}

			// $FF: synthetic method
			@Override
			public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
				return this.a(var1, var2, var3);
			}
		}
	}
}
