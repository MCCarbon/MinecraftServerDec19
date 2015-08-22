package net.minecraft.server;

import java.util.Random;

public class class_ann extends class_aif {
	public static final class_aqa a = class_aqa.a("mode", class_apb.class_a_in_class_apb.class);

	public class_ann() {
		super(class_avq.f, class_avr.x);
		this.j(M.b());
	}

	@Override
	public TileEntity a(class_ago var1, int var2) {
		return new class_apb();
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		return false;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	@Override
	public int b() {
		return 3;
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S().a(a, class_apb.class_a_in_class_apb.d);
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_apb.class_a_in_class_apb.a(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_apb.class_a_in_class_apb) var1.b(a)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}
}
