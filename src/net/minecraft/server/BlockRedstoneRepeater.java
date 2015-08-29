package net.minecraft.server;

import java.util.Random;

public class BlockRedstoneRepeater extends class_ajj {
	public static final class_apy a = class_apy.a("locked");
	public static final class_aqb b = class_aqb.a("delay", 1, 4);

	protected BlockRedstoneRepeater(boolean var1) {
		super(var1);
		this.j(M.b().a(O, class_cq.c).a(b, Integer.valueOf(1)).a(a, Boolean.valueOf(false)));
	}

	@Override
	public String f() {
		return class_di.a("item.diode.name");
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		return var1.a(a, Boolean.valueOf(this.b(var2, var3, var1)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(O, var2.a((class_cq) var1.b(O)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(O)));
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (!var4.bI.e) {
			return false;
		} else {
			var1.a(var2, var3.a(b), 3);
			return true;
		}
	}

	@Override
	protected int d(class_apn var1) {
		return ((Integer) var1.b(b)).intValue() * 2;
	}

	@Override
	protected class_apn e(class_apn var1) {
		Integer var2 = (Integer) var1.b(b);
		Boolean var3 = (Boolean) var1.b(a);
		class_cq var4 = (class_cq) var1.b(O);
		return Blocks.POWERED_REPEATER.getBlockData().a(O, var4).a(b, var2).a(a, var3);
	}

	@Override
	protected class_apn k(class_apn var1) {
		Integer var2 = (Integer) var1.b(b);
		Boolean var3 = (Boolean) var1.b(a);
		class_cq var4 = (class_cq) var1.b(O);
		return Blocks.UNPOWERED_REPEATER.getBlockData().a(O, var4).a(b, var2).a(a, var3);
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Items.bd;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Items.bd);
	}

	@Override
	public boolean b(class_ags var1, class_cj var2, class_apn var3) {
		return this.c(var1, var2, var3) > 0;
	}

	@Override
	protected boolean c(Block var1) {
		return d(var1);
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		super.c(var1, var2, var3);
		this.i(var1, var2, var3);
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(O, class_cq.b(var1)).a(a, Boolean.valueOf(false)).a(b, Integer.valueOf(1 + (var1 >> 2)));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(O)).b();
		var3 |= (((Integer) var1.b(b)).intValue() - 1) << 2;
		return var3;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { O, b, a });
	}
}
