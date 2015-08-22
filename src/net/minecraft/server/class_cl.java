package net.minecraft.server;


public class class_cl implements class_ck {
	private final class_ago a;
	private final class_cj b;

	public class_cl(class_ago var1, class_cj var2) {
		a = var1;
		b = var2;
	}

	@Override
	public class_ago i() {
		return a;
	}

	@Override
	public double a() {
		return b.n() + 0.5D;
	}

	@Override
	public double b() {
		return b.o() + 0.5D;
	}

	@Override
	public double c() {
		return b.p() + 0.5D;
	}

	@Override
	public class_cj d() {
		return b;
	}

	@Override
	public int f() {
		class_apn var1 = a.p(b);
		return var1.c().c(var1);
	}

	@Override
	public class_aoi h() {
		return a.s(b);
	}
}
