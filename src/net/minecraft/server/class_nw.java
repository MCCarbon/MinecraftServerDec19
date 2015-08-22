package net.minecraft.server;

public abstract class class_nw {
	private Object a;
	private boolean b = false;

	public Object c() {
		if (!b) {
			b = true;
			a = b();
		}

		return a;
	}

	protected abstract Object b();
}
