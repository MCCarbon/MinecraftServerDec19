package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public abstract class class_aut extends class_aur {
	private static final class_auz d = new class_auz();
	protected class_ava a;
	protected class_auz b;
	protected class_cj c;

	public class_aut() {
		b = d.a(true).a(Blocks.a);
	}

	public class_aut(int var1) {
		super(var1);
		b = d.a(true).a(Blocks.a);
	}

	protected void a(class_ava var1, class_cj var2, class_auz var3) {
		a = var1;
		this.a(class_cq.c);
		c = var2;
		b = var3;
		h();
	}

	@Override
	protected void a(class_dn var1) {
		var1.a("TPX", c.n());
		var1.a("TPY", c.o());
		var1.a("TPZ", c.p());
	}

	@Override
	protected void b(class_dn var1) {
		c = new class_cj(var1.h("TPX"), var1.h("TPY"), var1.h("TPZ"));
	}

	@Override
	public boolean a(class_ago var1, Random var2, class_aua var3) {
		b.a(var3);
		a.b(var1, c, b);
		Map var4 = a.a(c, b);
		Iterator var5 = var4.keySet().iterator();

		while (var5.hasNext()) {
			class_cj var6 = (class_cj) var5.next();
			String var7 = (String) var4.get(var6);
			this.a(var7, var6, var1, var2, var3);
		}

		return true;
	}

	protected abstract void a(String var1, class_cj var2, class_ago var3, Random var4, class_aua var5);

	private void h() {
		Block.class_c_in_class_ail var1 = b.c();
		class_cj var2 = a.a(var1);
		l = new class_aua(0, 0, 0, var2.n(), var2.o() - 1, var2.p());
		switch (class_aut.SyntheticClass_1.a[var1.ordinal()]) {
			case 1:
			default:
				break;
			case 2:
				l.a(-var2.n(), 0, 0);
				break;
			case 3:
				l.a(0, 0, -var2.p());
				break;
			case 4:
				l.a(-var2.n(), 0, -var2.p());
		}

		l.a(c.n(), c.o(), c.p());
	}

	@Override
	public void a(int var1, int var2, int var3) {
		super.a(var1, var2, var3);
		c = c.a(var1, var2, var3);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[Block.class_c_in_class_ail.values().length];

		static {
			try {
				a[Block.class_c_in_class_ail.a.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.b.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.d.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.c.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
