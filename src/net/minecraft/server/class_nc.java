package net.minecraft.server;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

public class class_nc extends class_ni {
	private static final Logger b = LogManager.getLogger();
	private final MinecraftServer c;
	private final File d;
	private final Set e = Sets.newHashSet();
	private int f = -300;
	private boolean g = false;

	public class_nc(MinecraftServer var1, File var2) {
		c = var1;
		d = var2;
	}

	public void a() {
		if (d.isFile()) {
			try {
				a.clear();
				a.putAll(this.a(FileUtils.readFileToString(d)));
			} catch (IOException var2) {
				b.error("Couldn\'t read statistics file " + d, var2);
			} catch (JsonParseException var3) {
				b.error("Couldn\'t parse statistics file " + d, var3);
			}
		}

	}

	public void b() {
		try {
			FileUtils.writeStringToFile(d, a(a));
		} catch (IOException var2) {
			b.error("Couldn\'t save stats", var2);
		}

	}

	@Override
	public void a(class_yu var1, class_nd var2, int var3) {
		int var4 = var2.d() ? this.a(var2) : 0;
		super.a(var1, var2, var3);
		e.add(var2);
		if (var2.d() && (var4 == 0) && (var3 > 0)) {
			g = true;
			if (c.aD()) {
				c.ar().a((new class_fb("chat.type.achievement", new Object[] { var1.f_(), var2.j() })));
			}
		}

		if (var2.d() && (var4 > 0) && (var3 == 0)) {
			g = true;
			if (c.aD()) {
				c.ar().a((new class_fb("chat.type.achievement.taken", new Object[] { var1.f_(), var2.j() })));
			}
		}

	}

	public Set c() {
		HashSet var1 = Sets.newHashSet((Iterable) e);
		e.clear();
		g = false;
		return var1;
	}

	public Map a(String var1) {
		JsonElement var2 = (new JsonParser()).parse(var1);
		if (!var2.isJsonObject()) {
			return Maps.newHashMap();
		} else {
			JsonObject var3 = var2.getAsJsonObject();
			HashMap var4 = Maps.newHashMap();
			Iterator var5 = var3.entrySet().iterator();

			while (true) {
				while (var5.hasNext()) {
					Entry var6 = (Entry) var5.next();
					class_nd var7 = class_nh.a((String) var6.getKey());
					if (var7 != null) {
						class_nf var8 = new class_nf();
						if (((JsonElement) var6.getValue()).isJsonPrimitive() && ((JsonElement) var6.getValue()).getAsJsonPrimitive().isNumber()) {
							var8.a(((JsonElement) var6.getValue()).getAsInt());
						} else if (((JsonElement) var6.getValue()).isJsonObject()) {
							JsonObject var9 = ((JsonElement) var6.getValue()).getAsJsonObject();
							if (var9.has("value") && var9.get("value").isJsonPrimitive() && var9.get("value").getAsJsonPrimitive().isNumber()) {
								var8.a(var9.getAsJsonPrimitive("value").getAsInt());
							}

							if (var9.has("progress") && (var7.l() != null)) {
								try {
									Constructor var10 = var7.l().getConstructor(new Class[0]);
									class_ng var11 = (class_ng) var10.newInstance(new Object[0]);
									var11.a(var9.get("progress"));
									var8.a(var11);
								} catch (Throwable var12) {
									b.warn("Invalid statistic progress in " + d, var12);
								}
							}
						}

						var4.put(var7, var8);
					} else {
						b.warn("Invalid statistic in " + d + ": Don\'t know what " + (String) var6.getKey() + " is");
					}
				}

				return var4;
			}
		}
	}

	public static String a(Map var0) {
		JsonObject var1 = new JsonObject();
		Iterator var2 = var0.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			if (((class_nf) var3.getValue()).b() != null) {
				JsonObject var4 = new JsonObject();
				var4.addProperty("value", Integer.valueOf(((class_nf) var3.getValue()).a()));

				try {
					var4.add("progress", ((class_nf) var3.getValue()).b().a());
				} catch (Throwable var6) {
					b.warn("Couldn\'t save statistic " + ((class_nd) var3.getKey()).e() + ": error serializing progress", var6);
				}

				var1.add(((class_nd) var3.getKey()).e, var4);
			} else {
				var1.addProperty(((class_nd) var3.getKey()).e, Integer.valueOf(((class_nf) var3.getValue()).a()));
			}
		}

		return var1.toString();
	}

	public void d() {
		Iterator var1 = a.keySet().iterator();

		while (var1.hasNext()) {
			class_nd var2 = (class_nd) var1.next();
			e.add(var2);
		}

	}

	public void a(class_lm var1) {
		int var2 = c.av();
		HashMap var3 = Maps.newHashMap();
		if (g || ((var2 - f) > 300)) {
			f = var2;
			Iterator var4 = c().iterator();

			while (var4.hasNext()) {
				class_nd var5 = (class_nd) var4.next();
				var3.put(var5, Integer.valueOf(this.a(var5)));
			}
		}

		var1.a.a((new class_fr(var3)));
	}

	public void b(class_lm var1) {
		HashMap var2 = Maps.newHashMap();
		Iterator var3 = class_my.e.iterator();

		while (var3.hasNext()) {
			class_mx var4 = (class_mx) var3.next();
			if (this.a(var4)) {
				var2.put(var4, Integer.valueOf(this.a((class_nd) var4)));
				e.remove(var4);
			}
		}

		var1.a.a((new class_fr(var2)));
	}

	public boolean e() {
		return g;
	}
}
