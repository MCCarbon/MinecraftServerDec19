package net.minecraft.server;


public class class_ang extends class_amw {
	public static final class_aqb a = class_aqb.a("rotation", 0, 15);

	public class_ang() {
		this.j(M.b().a(a, Integer.valueOf(0)));
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!var1.p(var2.b()).c().v().a()) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

		super.a(var1, var2, var3, var4);
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
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(a, Integer.valueOf(var2.a(((Integer) var1.b(a)).intValue(), 16)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(a, Integer.valueOf(var2.a(((Integer) var1.b(a)).intValue(), 16)));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}
}
