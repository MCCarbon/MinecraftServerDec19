package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

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

	private static final Map<String, EnumChatFormat> BY_NAME = Maps.newHashMap();
	private static final Pattern x = Pattern.compile("(?i)" + String.valueOf('§') + "[0-9A-FK-OR]");

	static {
		for (EnumChatFormat format : values()) {
			BY_NAME.put(toName(format.name), format);
		}
	}
		
	private static String toName(String name) {
		return name.toLowerCase().replaceAll("[^a-z]", "");
	}

	private final String name;
	private final boolean isFormatting;
	private final String asString;
	private final int id;

	private EnumChatFormat(String name, char c, int id) {
		this(name, c, false, id);
	}

	private EnumChatFormat(String name, char c, boolean isFormatting) {
		this(name, c, isFormatting, -1);
	}

	private EnumChatFormat(String name, char c, boolean isFormatting, int id) {
		this.name = name;
		this.isFormatting = isFormatting;
		this.id = id;
		this.asString = "§" + c;
	}

	public int getId() {
		return this.id;
	}

	public boolean isFormatting() {
		return this.isFormatting;
	}

	public boolean isColor() {
		return !this.isFormatting && this != RESET;
	}

	public String getName() {
		return this.name().toLowerCase();
	}

	@Override
	public String toString() {
		return this.asString;
	}

	public static String stripFormatting(String string) {
		return string == null ? null : x.matcher(string).replaceAll("");
	}

	public static EnumChatFormat getByName(String name) {
		return name == null ? null : BY_NAME.get(toName(name));
	}

	public static EnumChatFormat getById(int id) {
		if (id < 0) {
			return RESET;
		} else {
			for (EnumChatFormat format : values()) {
				if (format.getId() == id) {
					return format;
				}
			}
			return null;
		}
	}

	public static Collection<String> getNames(boolean includeColors, boolean includeFormatting) {
		ArrayList<String> names = Lists.newArrayList();
		for (EnumChatFormat format : values()) {
			if ((!format.isColor() || includeColors) && (!format.isFormatting() || includeFormatting)) {
				names.add(format.getName());
			}
		}
		return names;
	}

}
