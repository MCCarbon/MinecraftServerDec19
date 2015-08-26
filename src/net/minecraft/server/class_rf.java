package net.minecraft.server;


public enum class_rf {
	a(new class_fb("options.mainHand.left", new Object[0])),
	b(new class_fb("options.mainHand.right", new Object[0]));

	private final IChatBaseComponent c;

	private class_rf(IChatBaseComponent var3) {
		c = var3;
	}

	@Override
	public String toString() {
		return c.c();
	}
}
