package net.minecraft.server;


public class class_aoe extends class_ail {
	public static final class_aqa a = class_aqa.a("color", class_abt.class);

	protected class_aoe() {
		super(class_avq.r);
		this.j(M.b().a(a, class_abt.a));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
		this.a(true);
		this.a(class_abp.c);
		l();
	}

	@Override
	public class_avr g(class_apn var1) {
		return ((class_abt) var1.b(a)).e();
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public void j() {
		l();
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		l();
	}

	protected void l() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return super.c(var1, var2) && this.d(var1, var2);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		this.f(var1, var2, var3);
	}

	private boolean f(class_ago var1, class_cj var2, class_apn var3) {
		if (!this.d(var1, var2)) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			return false;
		} else {
			return true;
		}
	}

	private boolean d(class_ago var1, class_cj var2) {
		return !var1.d(var2.b());
	}

	@Override
	public int a(class_apn var1) {
		return ((class_abt) var1.b(a)).a();
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_abt.b(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_abt) var1.b(a)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}
}
