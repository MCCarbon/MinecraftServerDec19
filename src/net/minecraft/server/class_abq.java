package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Multimap;

public class class_abq extends Item {
	private Set c;
	protected float a = 4.0F;
	private float d;
	private float l;
	protected Item.class_a_in_class_acm b;

	protected class_abq(float var1, float var2, Item.class_a_in_class_acm var3, Set var4) {
		b = var3;
		c = var4;
		i = 1;
		this.e(var3.a());
		a = var3.b();
		d = var1 + var3.c();
		l = var2;
		this.a(class_abp.i);
	}

	@Override
	public float a(class_aco var1, Block var2) {
		return c.contains(var2) ? a : 1.0F;
	}

	@Override
	public boolean a(class_aco var1, EntityLiving var2, EntityLiving var3) {
		var1.a(2, var3);
		return true;
	}

	@Override
	public boolean a(class_aco var1, class_ago var2, Block var3, class_cj var4, EntityLiving var5) {
		if (var3.f(var2, var4) != 0.0D) {
			var1.a(1, var5);
		}

		return true;
	}

	public Item.class_a_in_class_acm g() {
		return b;
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
			var2.put(class_yf.e.a(), new class_rr(f, "Tool modifier", d, 0));
			var2.put(class_yf.f.a(), new class_rr(g, "Tool modifier", l, 0));
		}

		return var2;
	}
}
