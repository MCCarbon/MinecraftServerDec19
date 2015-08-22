package net.minecraft.server;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;

public class class_aup {
	private static final Logger a = LogManager.getLogger();
	private static Map b = Maps.newHashMap();
	private static Map c = Maps.newHashMap();
	private static Map d = Maps.newHashMap();
	private static Map e = Maps.newHashMap();

	private static void b(Class var0, String var1) {
		b.put(var1, var0);
		c.put(var0, var1);
	}

	static void a(Class var0, String var1) {
		d.put(var1, var0);
		e.put(var0, var1);
	}

	public static String a(class_aus var0) {
		return (String) c.get(var0.getClass());
	}

	public static String a(class_aur var0) {
		return (String) e.get(var0.getClass());
	}

	public static class_aus a(class_dn var0, class_ago var1) {
		class_aus var2 = null;

		try {
			Class var3 = (Class) b.get(var0.l("id"));
			if (var3 != null) {
				var2 = (class_aus) var3.newInstance();
			}
		} catch (Exception var4) {
			a.warn("Failed Start with id " + var0.l("id"));
			var4.printStackTrace();
		}

		if (var2 != null) {
			var2.a(var1, var0);
		} else {
			a.warn("Skipping Structure with id " + var0.l("id"));
		}

		return var2;
	}

	public static class_aur b(class_dn var0, class_ago var1) {
		class_aur var2 = null;

		try {
			Class var3 = (Class) d.get(var0.l("id"));
			if (var3 != null) {
				var2 = (class_aur) var3.newInstance();
			}
		} catch (Exception var4) {
			a.warn("Failed Piece with id " + var0.l("id"));
			var4.printStackTrace();
		}

		if (var2 != null) {
			var2.a(var1, var0);
		} else {
			a.warn("Skipping Piece with id " + var0.l("id"));
		}

		return var2;
	}

	static {
		b(class_auf.class, "Mineshaft");
		b(class_auu.class_a_in_class_auu.class, "Village");
		b(class_aug.class_a_in_class_aug.class, "Fortress");
		b(class_aum.class_a_in_class_aum.class, "Stronghold");
		b(class_auk.class_a_in_class_auk.class, "Temple");
		b(class_aui.class_a_in_class_aui.class, "Monument");
		b(class_aub.class_a_in_class_aub.class, "EndCity");
		class_aue.a();
		class_auv.a();
		class_auh.a();
		class_aun.a();
		class_aul.a();
		class_auj.a();
		class_auc.a();
	}
}
