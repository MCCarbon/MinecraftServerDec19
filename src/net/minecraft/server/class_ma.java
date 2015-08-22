package net.minecraft.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.IOUtils;

import com.google.common.base.Charsets;
import com.google.common.collect.Iterators;
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
import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;

public class class_ma {
	public static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
	private final Map c = Maps.newHashMap();
	private final Map d = Maps.newHashMap();
	private final LinkedList e = Lists.newLinkedList();
	private final MinecraftServer f;
	protected final Gson b;
	private final File g;
	private static final ParameterizedType h = new ParameterizedType() {
		@Override
		public Type[] getActualTypeArguments() {
			return new Type[] { class_ma.class_a_in_class_ma.class };
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

	public class_ma(MinecraftServer var1, File var2) {
		f = var1;
		g = var2;
		GsonBuilder var3 = new GsonBuilder();
		var3.registerTypeHierarchyAdapter(class_ma.class_a_in_class_ma.class, new class_ma.class_b_in_class_ma(null));
		b = var3.create();
		this.b();
	}

	private static GameProfile a(MinecraftServer var0, String var1) {
		final GameProfile[] var2 = new GameProfile[1];
		ProfileLookupCallback var3 = new ProfileLookupCallback() {
			@Override
			public void onProfileLookupSucceeded(GameProfile var1) {
				var2[0] = var1;
			}

			@Override
			public void onProfileLookupFailed(GameProfile var1, Exception var2x) {
				var2[0] = null;
			}
		};
		var0.aG().findProfilesByNames(new String[] { var1 }, Agent.MINECRAFT, var3);
		if (!var0.ah() && (var2[0] == null)) {
			UUID var4 = class_yu.a(new GameProfile((UUID) null, var1));
			GameProfile var5 = new GameProfile(var4, var1);
			var3.onProfileLookupSucceeded(var5);
		}

		return var2[0];
	}

	public void a(GameProfile var1) {
		this.a(var1, (Date) null);
	}

	private void a(GameProfile var1, Date var2) {
		UUID var3 = var1.getId();
		if (var2 == null) {
			Calendar var4 = Calendar.getInstance();
			var4.setTime(new Date());
			var4.add(2, 1);
			var2 = var4.getTime();
		}

		String var7 = var1.getName().toLowerCase(Locale.ROOT);
		class_ma.class_a_in_class_ma var5 = new class_ma.class_a_in_class_ma(var1, var2);
		if (d.containsKey(var3)) {
			class_ma.class_a_in_class_ma var6 = (class_ma.class_a_in_class_ma) d.get(var3);
			c.remove(var6.a().getName().toLowerCase(Locale.ROOT));
			e.remove(var1);
		}

		c.put(var1.getName().toLowerCase(Locale.ROOT), var5);
		d.put(var3, var5);
		e.addFirst(var1);
		c();
	}

	public GameProfile a(String var1) {
		String var2 = var1.toLowerCase(Locale.ROOT);
		class_ma.class_a_in_class_ma var3 = (class_ma.class_a_in_class_ma) c.get(var2);
		if ((var3 != null) && ((new Date()).getTime() >= var3.c.getTime())) {
			d.remove(var3.a().getId());
			c.remove(var3.a().getName().toLowerCase(Locale.ROOT));
			e.remove(var3.a());
			var3 = null;
		}

		GameProfile var4;
		if (var3 != null) {
			var4 = var3.a();
			e.remove(var4);
			e.addFirst(var4);
		} else {
			var4 = a(f, var2);
			if (var4 != null) {
				this.a(var4);
				var3 = (class_ma.class_a_in_class_ma) c.get(var2);
			}
		}

		c();
		return var3 == null ? null : var3.a();
	}

	public String[] a() {
		ArrayList var1 = Lists.newArrayList((Iterable) c.keySet());
		return (String[]) var1.toArray(new String[var1.size()]);
	}

	public GameProfile a(UUID var1) {
		class_ma.class_a_in_class_ma var2 = (class_ma.class_a_in_class_ma) d.get(var1);
		return var2 == null ? null : var2.a();
	}

	private class_ma.class_a_in_class_ma b(UUID var1) {
		class_ma.class_a_in_class_ma var2 = (class_ma.class_a_in_class_ma) d.get(var1);
		if (var2 != null) {
			GameProfile var3 = var2.a();
			e.remove(var3);
			e.addFirst(var3);
		}

		return var2;
	}

	public void b() {
		BufferedReader var1 = null;

		try {
			var1 = Files.newReader(g, Charsets.UTF_8);
			List var2 = (List) b.fromJson((Reader) var1, (Type) h);
			c.clear();
			d.clear();
			e.clear();
			Iterator var3 = Lists.reverse(var2).iterator();

			while (var3.hasNext()) {
				class_ma.class_a_in_class_ma var4 = (class_ma.class_a_in_class_ma) var3.next();
				if (var4 != null) {
					this.a(var4.a(), var4.b());
				}
			}
		} catch (FileNotFoundException var9) {
			;
		} catch (JsonParseException var10) {
			;
		} finally {
			IOUtils.closeQuietly(var1);
		}

	}

	public void c() {
		String var1 = b.toJson(this.a(1000));
		BufferedWriter var2 = null;

		try {
			var2 = Files.newWriter(g, Charsets.UTF_8);
			var2.write(var1);
			return;
		} catch (FileNotFoundException var8) {
			return;
		} catch (IOException var9) {
			;
		} finally {
			IOUtils.closeQuietly(var2);
		}

	}

	private List a(int var1) {
		ArrayList var2 = Lists.newArrayList();
		ArrayList var3 = Lists.newArrayList(Iterators.limit(e.iterator(), var1));
		Iterator var4 = var3.iterator();

		while (var4.hasNext()) {
			GameProfile var5 = (GameProfile) var4.next();
			class_ma.class_a_in_class_ma var6 = this.b(var5.getId());
			if (var6 != null) {
				var2.add(var6);
			}
		}

		return var2;
	}

	class class_a_in_class_ma {
		private final GameProfile b;
		private final Date c;

		private class_a_in_class_ma(GameProfile var2, Date var3) {
			b = var2;
			c = var3;
		}

		public GameProfile a() {
			return b;
		}

		public Date b() {
			return c;
		}

	}

	class class_b_in_class_ma implements JsonDeserializer, JsonSerializer {
		private class_b_in_class_ma() {
		}

		public JsonElement a(class_ma.class_a_in_class_ma var1, Type var2, JsonSerializationContext var3) {
			JsonObject var4 = new JsonObject();
			var4.addProperty("name", var1.a().getName());
			UUID var5 = var1.a().getId();
			var4.addProperty("uuid", var5 == null ? "" : var5.toString());
			var4.addProperty("expiresOn", class_ma.a.format(var1.b()));
			return var4;
		}

		public class_ma.class_a_in_class_ma a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
			if (var1.isJsonObject()) {
				JsonObject var4 = var1.getAsJsonObject();
				JsonElement var5 = var4.get("name");
				JsonElement var6 = var4.get("uuid");
				JsonElement var7 = var4.get("expiresOn");
				if ((var5 != null) && (var6 != null)) {
					String var8 = var6.getAsString();
					String var9 = var5.getAsString();
					Date var10 = null;
					if (var7 != null) {
						try {
							var10 = class_ma.a.parse(var7.getAsString());
						} catch (ParseException var14) {
							var10 = null;
						}
					}

					if ((var9 != null) && (var8 != null)) {
						UUID var11;
						try {
							var11 = UUID.fromString(var8);
						} catch (Throwable var13) {
							return null;
						}

						class_ma.class_a_in_class_ma var12 = class_ma.this.new class_a_in_class_ma(new GameProfile(var11, var9), var10);
						return var12;
					} else {
						return null;
					}
				} else {
					return null;
				}
			} else {
				return null;
			}
		}

		// $FF: synthetic method
		@Override
		public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
			return this.a((class_ma.class_a_in_class_ma) var1, var2, var3);
		}

		// $FF: synthetic method
		@Override
		public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
			return this.a(var1, var2, var3);
		}

		// $FF: synthetic method
		class_b_in_class_ma(Object var2) {
			this();
		}
	}
}
