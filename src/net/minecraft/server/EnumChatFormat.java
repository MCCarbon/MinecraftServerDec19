package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public enum EnumChatFormat {

	BLACK("BLACK", '0', 0),
	DARK_BLUE("DARK_BLUE", '1', 1),
	DARK_GREEN("DARK_GREEN", '2', 2),
	DARK_AQUA("DARK_AQUA", '3', 3),
	DARK_RED("DARK_RED", '4', 4),
	DARK_PURPLE("DARK_PURPLE", '5', 5),
	GOLD("GOLD", '6', 6),
	GRAY("GRAY", '7', 7),
	DARK_GRAY("DARK_GRAY", '8', 8),
	BLUE("BLUE", '9', 9),
	GREEN("GREEN", 'a', 10),
	AQUA("AQUA", 'b', 11),
	RED("RED", 'c', 12),
	LIGHT_PURPLE("LIGHT_PURPLE", 'd', 13),
	YELLOW("YELLOW", 'e', 14),
	WHITE("WHITE", 'f', 15),
	OBFUSCATED("OBFUSCATED", 'k', true),
	BOLD("BOLD", 'l', true),
	STRIKETHROUGH("STRIKETHROUGH", 'm', true),
	UNDERLINE("UNDERLINE", 'n', true),
	ITALIC("ITALIC", 'o', true),
	RESET("RESET", 'r', -1);

	private static final Map<String, EnumChatFormat> BY_CHAR;
	private static final Pattern pattern;
	private final String y;
	private final boolean isFormat;
	private final String B;
	private final int C;

	private static String c(String var0) {
		return var0.toLowerCase().replaceAll("[^a-z]", "");
	}

	private EnumChatFormat(String var3, char var4, int var5) {
		this(var3, var4, false, var5);
	}

	private EnumChatFormat(String var3, char var4, boolean var5) {
		this(var3, var4, var5, -1);
	}

	private EnumChatFormat(String var3, char var4, boolean var5, int var6) {
		y = var3;
		isFormat = var5;
		C = var6;
		B = "§" + var4;
	}

	public int getId() {
		return C;
	}

	public boolean isFormat() {
		return isFormat;
	}

	public boolean d() {
		return !isFormat && (this != RESET);
	}

	public String e() {
		return name().toLowerCase();
	}

	@Override
	public String toString() {
		return B;
	}

	public static String stripFormat(String var0) {
		return var0 == null ? null : pattern.matcher(var0).replaceAll("");
	}

	public static EnumChatFormat getByName(String var0) {
		return var0 == null ? null : (EnumChatFormat) BY_CHAR.get(c(var0));
	}

	public static EnumChatFormat getById(int id) {
		if (id < 0) {
			return RESET;
		} else {
			EnumChatFormat[] var1 = values();
			int var2 = var1.length;

			for (int var3 = 0; var3 < var2; ++var3) {
				EnumChatFormat var4 = var1[var3];
				if (var4.getId() == id) {
					return var4;
				}
			}

			return null;
		}
	}

	public static Collection<String> a(boolean var0, boolean var1) {
		ArrayList<String> var2 = Lists.newArrayList();
		EnumChatFormat[] var3 = values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			EnumChatFormat var6 = var3[var5];
			if ((!var6.d() || var0) && (!var6.isFormat() || var1)) {
				var2.add(var6.e());
			}
		}

		return var2;
	}

	static {
		BY_CHAR = Maps.newHashMap();
		pattern = Pattern.compile("(?i)" + String.valueOf('§') + "[0-9A-FK-OR]");
		EnumChatFormat[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			EnumChatFormat var3 = var0[var2];
			BY_CHAR.put(c(var3.y), var3);
		}

	}
}
