package net.minecraft.server;


public class class_aar extends class_aas {
	private final class_aab a;
	private final class_yu b;
	private int c;

	public class_aar(class_yu var1, class_aab var2, class_pp var3, int var4, int var5, int var6) {
		super(var3, var4, var5, var6);
		b = var1;
		a = var2;
	}

	@Override
	public boolean a(class_aco var1) {
		return false;
	}

	@Override
	public class_aco a(int var1) {
		if (e()) {
			c += Math.min(var1, this.d().b);
		}

		return super.a(var1);
	}

	@Override
	protected void a(class_aco var1, int var2) {
		c += var2;
		c(var1);
	}

	@Override
	protected void c(class_aco var1) {
		if (c > 0) {
			var1.a(b.o, b, c);
		}

		c = 0;
		if (var1.b() == Item.a(Blocks.CRAFTING_TABLE)) {
			b.b(class_my.h);
		}

		if (var1.b() instanceof class_acz) {
			b.b(class_my.i);
		}

		if (var1.b() == Item.a(Blocks.FURNACE)) {
			b.b(class_my.j);
		}

		if (var1.b() instanceof class_acl) {
			b.b(class_my.l);
		}

		if (var1.b() == Items.R) {
			b.b(class_my.m);
		}

		if (var1.b() == Items.bb) {
			b.b(class_my.n);
		}

		if ((var1.b() instanceof class_acz) && (((class_acz) var1.b()).g() != Item.class_a_in_class_acm.a)) {
			b.b(class_my.o);
		}

		if (var1.b() instanceof class_adv) {
			b.b(class_my.r);
		}

		if (var1.b() == Item.a(Blocks.ENCHANTING_TABLE)) {
			b.b(class_my.E);
		}

		if (var1.b() == Item.a(Blocks.BOOKSHELF)) {
			b.b(class_my.G);
		}

		if ((var1.b() == Items.aq) && (var1.i() == 1)) {
			b.b(class_my.M);
		}

	}

	@Override
	public void a(class_yu var1, class_aco var2) {
		c(var2);
		class_aco[] var3 = class_aet.a().b(a, var1.o);

		for (int var4 = 0; var4 < var3.length; ++var4) {
			class_aco var5 = a.a(var4);
			class_aco var6 = var3[var4];
			if (var5 != null) {
				a.a(var4, 1);
			}

			if (var6 != null) {
				if (a.a(var4) == null) {
					a.a(var4, var6);
				} else if (!b.bq.a(var6)) {
					b.a(var6, false);
				}
			}
		}

	}
}
