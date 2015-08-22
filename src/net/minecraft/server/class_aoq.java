package net.minecraft.server;

import java.util.Random;

public class class_aoq extends TileEntity implements class_ks, class_pv {
	public int a;
	public float f;
	public float g;
	public float h;
	public float i;
	public float j;
	public float k;
	public float l;
	public float m;
	public float n;
	private static Random o = new Random();
	private String p;

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		if (k_()) {
			var1.a("CustomName", p);
		}

	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		if (var1.b("CustomName", 8)) {
			p = var1.l("CustomName");
		}

	}

	@Override
	public void c() {
		k = j;
		m = l;
		class_yu var1 = b.a(c.n() + 0.5F, c.o() + 0.5F, c.p() + 0.5F, 3.0D);
		if (var1 != null) {
			double var2 = var1.s - (c.n() + 0.5F);
			double var4 = var1.u - (c.p() + 0.5F);
			n = (float) class_oa.b(var4, var2);
			j += 0.1F;
			if ((j < 0.5F) || (o.nextInt(40) == 0)) {
				float var6 = h;

				do {
					h += o.nextInt(4) - o.nextInt(4);
				} while (var6 == h);
			}
		} else {
			n += 0.02F;
			j -= 0.1F;
		}

		while (l >= 3.1415927F) {
			l -= 6.2831855F;
		}

		while (l < -3.1415927F) {
			l += 6.2831855F;
		}

		while (n >= 3.1415927F) {
			n -= 6.2831855F;
		}

		while (n < -3.1415927F) {
			n += 6.2831855F;
		}

		float var7;
		for (var7 = n - l; var7 >= 3.1415927F; var7 -= 6.2831855F) {
			;
		}

		while (var7 < -3.1415927F) {
			var7 += 6.2831855F;
		}

		l += var7 * 0.4F;
		j = class_oa.a(j, 0.0F, 1.0F);
		++a;
		g = f;
		float var3 = (h - f) * 0.4F;
		float var8 = 0.2F;
		var3 = class_oa.a(var3, -var8, var8);
		i += (var3 - i) * 0.9F;
		f += i;
	}

	@Override
	public String e_() {
		return k_() ? p : "container.enchant";
	}

	@Override
	public boolean k_() {
		return (p != null) && !p.isEmpty();
	}

	public void a(String var1) {
		p = var1;
	}

	@Override
	public class_eu f_() {
		return k_() ? new class_fa(e_()) : new class_fb(e_(), new Object[0]);
	}

	@Override
	public class_zu a(class_yt var1, class_yu var2) {
		return new class_aae(var1, b, c);
	}

	@Override
	public String k() {
		return "minecraft:enchanting_table";
	}
}
