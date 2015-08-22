package net.minecraft.server;


public class class_aci extends class_acm {
	public final int a;
	private final int b;
	private final float c;
	private final boolean d;
	private boolean l;
	private class_qr m;
	private float n;

	public class_aci(int var1, float var2, boolean var3) {
		a = 32;
		b = var1;
		d = var3;
		c = var2;
		this.a(class_abp.h);
	}

	public class_aci(int var1, boolean var2) {
		this(var1, 0.6F, var2);
	}

	@Override
	public class_aco a(class_aco var1, class_ago var2, class_rg var3) {
		--var1.b;
		if (var3 instanceof class_yu) {
			class_yu var4 = (class_yu) var3;
			var4.ct().a(this, var1);
			var2.a((class_qx) var4, "random.burp", 0.5F, (var2.s.nextFloat() * 0.1F) + 0.9F);
			this.a(var1, var2, var4);
			var4.b(class_nh.c(class_acm.b(this)));
		}

		return var1;
	}

	protected void a(class_aco var1, class_ago var2, class_yu var3) {
		if (!var2.D && (m != null) && (var2.s.nextFloat() < n)) {
			var3.c(new class_qr(m));
		}

	}

	@Override
	public int e(class_aco var1) {
		return 32;
	}

	@Override
	public class_ady f(class_aco var1) {
		return class_ady.b;
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		if (var3.j(l)) {
			var3.c(var4);
			return new class_px(class_pw.a, var1);
		} else {
			return new class_px(class_pw.c, var1);
		}
	}

	public int h(class_aco var1) {
		return b;
	}

	public float i(class_aco var1) {
		return c;
	}

	public boolean g() {
		return d;
	}

	public class_aci a(class_qr var1, float var2) {
		m = var1;
		n = var2;
		return this;
	}

	public class_aci h() {
		l = true;
		return this;
	}
}
