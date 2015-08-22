package net.minecraft.server;


public class class_aks extends Block {
	private boolean a;

	protected class_aks(class_avq var1, boolean var2) {
		this(var1, var2, var1.r());
	}

	protected class_aks(class_avq var1, boolean var2, class_avr var3) {
		super(var1, var3);
		a = var2;
	}

	@Override
	public boolean c() {
		return false;
	}
}
