package net.minecraft.server;

import com.google.common.collect.Multimap;

public class class_adv extends Item {
	private final float a;
	private final Item.class_a_in_class_acm b;

	public class_adv(Item.class_a_in_class_acm var1) {
		b = var1;
		i = 1;
		this.e(var1.a());
		this.a(class_abp.j);
		a = 3.0F + var1.c();
	}

	public float g() {
		return b.c();
	}

	@Override
	public float a(class_aco var1, Block var2) {
		if (var2 == Blocks.WEB) {
			return 15.0F;
		} else {
			class_avq var3 = var2.v();
			return (var3 != class_avq.k) && (var3 != class_avq.l) && (var3 != class_avq.v) && (var3 != class_avq.j) && (var3 != class_avq.C) ? 1.0F : 1.5F;
		}
	}

	@Override
	public boolean a(class_aco var1, EntityLiving var2, EntityLiving var3) {
		var1.a(1, var3);
		return true;
	}

	@Override
	public boolean a(class_aco var1, class_ago var2, Block var3, class_cj var4, EntityLiving var5) {
		if (var3.f(var2, var4) != 0.0D) {
			var1.a(2, var5);
		}

		return true;
	}

	@Override
	public boolean b(Block var1) {
		return var1 == Blocks.WEB;
	}

	@Override
	public int c() {
		return b.e();
	}

	public String h() {
		return b.toString();
	}

	@Override
	public boolean a(class_aco var1, class_aco var2) {
		return b.f() == var2.b() ? true : super.a(var1, var2);
	}

	@Override
	public Multimap a(class_rc var1) {
		Multimap var2 = super.a(var1);
		if (var1 == class_rc.a) {
			var2.put(class_yf.e.a(), new class_rr(f, "Weapon modifier", a, 0));
			var2.put(class_yf.f.a(), new class_rr(g, "Weapon modifier", -2.549999952316284D, 0));
		}

		return var2;
	}
}
