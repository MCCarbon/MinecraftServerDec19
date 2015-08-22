package net.minecraft.server;


public enum class_adc {
	a("COMMON", 0, EnumChatFormat.WHITE, "Common"),
	b("UNCOMMON", 1, EnumChatFormat.YELLOW, "Uncommon"),
	c("RARE", 2, EnumChatFormat.AQUA, "Rare"),
	d("EPIC", 3, EnumChatFormat.LIGHT_PURPLE, "Epic");

	public final EnumChatFormat e;
	public final String f;

	private class_adc(String name, int ordinal, EnumChatFormat var3, String var4) {
		this(var3, var4);
	}

	private class_adc(EnumChatFormat var3, String var4) {
		e = var3;
		f = var4;
	}

}
