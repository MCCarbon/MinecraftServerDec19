package net.minecraft.server;

import com.google.common.base.Predicate;

public class class_ug extends class_uf {
	private class_ro g;

	public class_ug(class_ro var1, Class var2, boolean var3, Predicate var4) {
		super(var1, var2, 10, var3, false, var4);
		g = var1;
	}

	@Override
	public boolean a() {
		return !g.cE() && super.a();
	}
}
