package net.minecraft.server;

import java.util.Random;

import org.apache.commons.lang3.Validate;

public class class_co extends class_cx {
	private final Object d;
	private Object e;

	public class_co(Object var1) {
		d = var1;
	}

	@Override
	public void a(int var1, Object var2, Object var3) {
		if (d.equals(var2)) {
			e = var3;
		}

		super.a(var1, var2, var3);
	}

	public void a() {
		Validate.notNull(e, "Missing default of DefaultedMappedRegistry: " + d, new Object[0]);
	}

	@Override
	public int a(Object var1) {
		int var2 = super.a(var1);
		return var2 == -1 ? super.a(e) : var2;
	}

	@Override
	public Object b(Object var1) {
		Object var2 = super.b(var1);
		return var2 == null ? d : var2;
	}

	@Override
	public Object c(Object var1) {
		Object var2 = super.c(var1);
		return var2 == null ? e : var2;
	}

	@Override
	public Object a(int var1) {
		Object var2 = super.a(var1);
		return var2 == null ? e : var2;
	}

	@Override
	public Object a(Random var1) {
		Object var2 = super.a(var1);
		return var2 == null ? e : var2;
	}
}
