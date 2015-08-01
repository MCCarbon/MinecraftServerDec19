package net.minecraft.server;

import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatMessage;

public enum EnumMainHandOption {

	LEFT(new ChatMessage("options.mainHand.left")),
	RIGHT(new ChatMessage("options.mainHand.right"));

	private final IChatBaseComponent message;

	private EnumMainHandOption(IChatBaseComponent message) {
		this.message = message;
	}

	public String toString() {
		return this.message.c();
	}

}
