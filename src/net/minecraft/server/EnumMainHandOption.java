package net.minecraft.server;

import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fb;

public enum EnumMainHandOption {

	LEFT(new class_fb("options.mainHand.left")),
	RIGHT(new class_fb("options.mainHand.right"));

	private final IChatBaseComponent message;

	private EnumMainHandOption(IChatBaseComponent message) {
		this.message = message;
	}

	public String toString() {
		return this.message.c();
	}

}
