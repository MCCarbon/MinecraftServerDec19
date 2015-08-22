package net.minecraft.server;


public class class_aob extends class_aig {
	public static final class_aqb a = class_aqb.a("power", 0, 15);
	private final int b;

	protected class_aob(class_avq var1, int var2) {
		this(var1, var2, var1.r());
	}

	protected class_aob(class_avq var1, int var2, class_avr var3) {
		super(var1, var3);
		this.j(M.b().a(a, Integer.valueOf(0)));
		b = var2;
	}

	@Override
	protected int e(class_ago var1, class_cj var2) {
		int var3 = Math.min(var1.a(class_qx.class, this.a(var2)).size(), b);
		if (var3 > 0) {
			float var4 = (float) Math.min(b, var3) / (float) b;
			return class_oa.f(var4 * 15.0F);
		} else {
			return 0;
		}
	}

	@Override
	protected int e(class_apn var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	@Override
	protected class_apn a(class_apn var1, int var2) {
		return var1.a(a, Integer.valueOf(var2));
	}

	@Override
	public int a(class_ago var1) {
		return 10;
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, Integer.valueOf(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}
}
