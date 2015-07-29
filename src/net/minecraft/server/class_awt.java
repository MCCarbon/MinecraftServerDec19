package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.server.EnumChatFormat;
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
	class_awt[] h = new class_awt[] { new class_awq("teamkill.", EnumChatFormat.BLACK), new class_awq("teamkill.", EnumChatFormat.DARK_BLUE), new class_awq("teamkill.", EnumChatFormat.DARK_GREEN), new class_awq("teamkill.", EnumChatFormat.DARK_AQUA), new class_awq("teamkill.", EnumChatFormat.DARK_RED), new class_awq("teamkill.", EnumChatFormat.DARK_PURPLE), new class_awq("teamkill.", EnumChatFormat.GOLD), new class_awq("teamkill.", EnumChatFormat.GRAY), new class_awq("teamkill.", EnumChatFormat.DARK_GRAY), new class_awq("teamkill.", EnumChatFormat.BLUE), new class_awq("teamkill.", EnumChatFormat.GREEN),
			new class_awq("teamkill.", EnumChatFormat.AQUA), new class_awq("teamkill.", EnumChatFormat.RED), new class_awq("teamkill.", EnumChatFormat.LIGHT_PURPLE), new class_awq("teamkill.", EnumChatFormat.YELLOW), new class_awq("teamkill.", EnumChatFormat.WHITE) };

	class_awt[] i = new class_awt[] { new class_awq("killedByTeam.", EnumChatFormat.BLACK), new class_awq("killedByTeam.", EnumChatFormat.DARK_BLUE), new class_awq("killedByTeam.", EnumChatFormat.DARK_GREEN), new class_awq("killedByTeam.", EnumChatFormat.DARK_AQUA), new class_awq("killedByTeam.", EnumChatFormat.DARK_RED), new class_awq("killedByTeam.", EnumChatFormat.DARK_PURPLE), new class_awq("killedByTeam.", EnumChatFormat.GOLD), new class_awq("killedByTeam.", EnumChatFormat.GRAY), new class_awq("killedByTeam.", EnumChatFormat.DARK_GRAY), new class_awq("killedByTeam.", EnumChatFormat.BLUE),
			new class_awq("killedByTeam.", EnumChatFormat.GREEN), new class_awq("killedByTeam.", EnumChatFormat.AQUA), new class_awq("killedByTeam.", EnumChatFormat.RED), new class_awq("killedByTeam.", EnumChatFormat.LIGHT_PURPLE), new class_awq("killedByTeam.", EnumChatFormat.YELLOW), new class_awq("killedByTeam.", EnumChatFormat.WHITE) };

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
