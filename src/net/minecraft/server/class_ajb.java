package net.minecraft.server;


public class class_ajb extends Block {
	public static final class_aqa a = class_aqa.a("color", class_abt.class);

	public class_ajb(class_avq var1) {
		super(var1);
		this.j(M.b().a(a, class_abt.a));
		this.a(class_abp.b);
	}

	@Override
	public int a(class_apn var1) {
		return ((class_abt) var1.b(a)).a();
	}

	@Override
	public class_avr g(class_apn var1) {
		return ((class_abt) var1.b(a)).e();
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(a, class_abt.b(var1));
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
