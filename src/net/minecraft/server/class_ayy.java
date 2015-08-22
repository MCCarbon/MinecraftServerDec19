package net.minecraft.server;

import java.util.Map;

import com.google.common.collect.Maps;

public interface class_ayy {
	Map a = Maps.newHashMap();
	class_ayy b = new class_ayw("dummy");
	class_ayy c = new class_ayw("trigger");
	class_ayy d = new class_ayw("deathCount");
	class_ayy e = new class_ayw("playerKillCount");
	class_ayy f = new class_ayw("totalKillCount");
	class_ayy g = new class_ayx("health");
	class_ayy h = new class_ayz("food");
	class_ayy i = new class_ayz("air");
	class_ayy j = new class_ayz("armor");
	class_ayy k = new class_ayz("xp");
	class_ayy l = new class_ayz("level");
	class_ayy[] m = new class_ayy[] { new class_ayv("teamkill.", EnumChatFormat.BLACK), new class_ayv("teamkill.", EnumChatFormat.DARK_BLUE), new class_ayv("teamkill.", EnumChatFormat.DARK_GREEN), new class_ayv("teamkill.", EnumChatFormat.DARK_AQUA), new class_ayv("teamkill.", EnumChatFormat.DARK_RED), new class_ayv("teamkill.", EnumChatFormat.DARK_PURPLE), new class_ayv("teamkill.", EnumChatFormat.GOLD), new class_ayv("teamkill.", EnumChatFormat.GRAY),
			new class_ayv("teamkill.", EnumChatFormat.DARK_GRAY), new class_ayv("teamkill.", EnumChatFormat.BLUE), new class_ayv("teamkill.", EnumChatFormat.GREEN), new class_ayv("teamkill.", EnumChatFormat.AQUA), new class_ayv("teamkill.", EnumChatFormat.RED), new class_ayv("teamkill.", EnumChatFormat.LIGHT_PURPLE), new class_ayv("teamkill.", EnumChatFormat.YELLOW), new class_ayv("teamkill.", EnumChatFormat.WHITE) };
	class_ayy[] n = new class_ayy[] { new class_ayv("killedByTeam.", EnumChatFormat.BLACK), new class_ayv("killedByTeam.", EnumChatFormat.DARK_BLUE), new class_ayv("killedByTeam.", EnumChatFormat.DARK_GREEN), new class_ayv("killedByTeam.", EnumChatFormat.DARK_AQUA), new class_ayv("killedByTeam.", EnumChatFormat.DARK_RED), new class_ayv("killedByTeam.", EnumChatFormat.DARK_PURPLE), new class_ayv("killedByTeam.", EnumChatFormat.GOLD), new class_ayv("killedByTeam.", EnumChatFormat.GRAY),
			new class_ayv("killedByTeam.", EnumChatFormat.DARK_GRAY), new class_ayv("killedByTeam.", EnumChatFormat.BLUE), new class_ayv("killedByTeam.", EnumChatFormat.GREEN), new class_ayv("killedByTeam.", EnumChatFormat.AQUA), new class_ayv("killedByTeam.", EnumChatFormat.RED), new class_ayv("killedByTeam.", EnumChatFormat.LIGHT_PURPLE), new class_ayv("killedByTeam.", EnumChatFormat.YELLOW), new class_ayv("killedByTeam.", EnumChatFormat.WHITE) };

	String a();

	boolean b();

	class_ayy.class_a_in_class_ayy c();

	public static enum class_a_in_class_ayy {
		a("integer"),
		b("hearts");

		private static final Map c;
		private final String d;

		private class_a_in_class_ayy(String var3) {
			d = var3;
		}

		public String a() {
			return d;
		}

		public static class_ayy.class_a_in_class_ayy a(String var0) {
			class_ayy.class_a_in_class_ayy var1 = (class_ayy.class_a_in_class_ayy) c.get(var0);
			return var1 == null ? a : var1;
		}

		static {
			c = Maps.newHashMap();
			class_ayy.class_a_in_class_ayy[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_ayy.class_a_in_class_ayy var3 = var0[var2];
				c.put(var3.a(), var3);
			}

		}
	}
}
