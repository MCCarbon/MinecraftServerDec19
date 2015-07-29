package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.server.class_a;
import net.minecraft.server.class_awq;
import net.minecraft.server.class_awr;
import net.minecraft.server.class_aws;

public interface class_awt {
	Map a = Maps.newHashMap();
	class_awt b = new class_awr("dummy");
	class_awt c = new class_awr("trigger");
	class_awt d = new class_awr("deathCount");
	class_awt e = new class_awr("playerKillCount");
	class_awt f = new class_awr("totalKillCount");
	class_awt g = new class_aws("health");
	class_awt[] h = new class_awt[] { new class_awq("teamkill.", class_a.a), new class_awq("teamkill.", class_a.b), new class_awq("teamkill.", class_a.c), new class_awq("teamkill.", class_a.d), new class_awq("teamkill.", class_a.e), new class_awq("teamkill.", class_a.f), new class_awq("teamkill.", class_a.g), new class_awq("teamkill.", class_a.h), new class_awq("teamkill.", class_a.i), new class_awq("teamkill.", class_a.j), new class_awq("teamkill.", class_a.k),
			new class_awq("teamkill.", class_a.l), new class_awq("teamkill.", class_a.m), new class_awq("teamkill.", class_a.n), new class_awq("teamkill.", class_a.o), new class_awq("teamkill.", class_a.p) };

	class_awt[] i = new class_awt[] { new class_awq("killedByTeam.", class_a.a), new class_awq("killedByTeam.", class_a.b), new class_awq("killedByTeam.", class_a.c), new class_awq("killedByTeam.", class_a.d), new class_awq("killedByTeam.", class_a.e), new class_awq("killedByTeam.", class_a.f), new class_awq("killedByTeam.", class_a.g), new class_awq("killedByTeam.", class_a.h), new class_awq("killedByTeam.", class_a.i), new class_awq("killedByTeam.", class_a.j),
			new class_awq("killedByTeam.", class_a.k), new class_awq("killedByTeam.", class_a.l), new class_awq("killedByTeam.", class_a.m), new class_awq("killedByTeam.", class_a.n), new class_awq("killedByTeam.", class_a.o), new class_awq("killedByTeam.", class_a.p) };

	String a();

	int a(List var1);

	boolean b();

	class_awt.class_a_in_class_awt c();

	public static enum class_a_in_class_awt {
		a("integer"), b("hearts");

		private static final Map c;
		private final String d;

		private class_a_in_class_awt(String var3) {
			this.d = var3;
		}

		public String a() {
			return this.d;
		}

		public static class_awt.class_a_in_class_awt a(String var0) {
			class_awt.class_a_in_class_awt var1 = (class_awt.class_a_in_class_awt) c.get(var0);
			return var1 == null ? a : var1;
		}

		static {
			c = Maps.newHashMap();
			class_awt.class_a_in_class_awt[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_awt.class_a_in_class_awt var3 = var0[var2];
				c.put(var3.a(), var3);
			}

		}
	}
}
