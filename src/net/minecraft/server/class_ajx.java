package net.minecraft.server;

import java.util.Random;

public class class_ajx extends class_aif {
	public static final class_apz a;

	protected class_ajx() {
		super(class_avq.e);
		this.j(M.b().a(a, class_cq.c));
		this.a(class_abp.c);
		this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
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
	public int b() {
		return 2;
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Item.a(Blocks.OBSIDIAN);
	}

	@Override
	public int a(Random var1) {
		return 8;
	}

	@Override
	protected boolean K() {
		return true;
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S().a(a, var8.aV().d());
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
		var1.a(var2, var3.a(a, var4.aV().d()), 2);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		class_aap var11 = var4.cw();
		TileEntity var12 = var1.s(var2);
		if ((var11 != null) && (var12 instanceof class_aor)) {
			if (var1.p(var2.a()).c().x()) {
				return true;
			} else if (var1.D) {
				return true;
			} else {
				var11.a((class_aor) var12);
				var4.a(var11);
				var4.b(class_nh.W);
				return true;
			}
		} else {
			return true;
		}
	}

	@Override
	public TileEntity a(class_ago var1, int var2) {
		return new class_aor();
	}

	@Override
	public class_apn a(int var1) {
		class_cq var2 = class_cq.a(var1);
		if (var2.k() == class_cq.class_a_in_class_cq.b) {
			var2 = class_cq.c;
		}

		return S().a(a, var2);
	}

	@Override
	public int c(class_apn var1) {
		return ((class_cq) var1.b(a)).a();
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(a, var2.a((class_cq) var1.b(a)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(a)));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	static {
		a = class_akx.O;
	}
}
