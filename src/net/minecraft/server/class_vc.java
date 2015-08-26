package net.minecraft.server;


public abstract class class_vc extends class_qu implements class_qw {
	protected Block bw;
	private int bt;
	private class_yu bu;

	public class_vc(class_ago var1) {
		super(var1);
		bw = Blocks.GRASS;
	}

	@Override
	protected void cg() {
		if (this.k() != 0) {
			bt = 0;
		}

		super.cg();
	}

	@Override
	public void m() {
		super.m();
		if (this.k() != 0) {
			bt = 0;
		}

		if (bt > 0) {
			--bt;
			if ((bt % 10) == 0) {
				double var1 = V.nextGaussian() * 0.02D;
				double var3 = V.nextGaussian() * 0.02D;
				double var5 = V.nextGaussian() * 0.02D;
				o.a(class_cy.I, (s + V.nextFloat() * J * 2.0F) - J, t + 0.5D + V.nextFloat() * K, (u + V.nextFloat() * J * 2.0F) - J, var1, var3, var5, new int[0]);
			}
		}

	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			bt = 0;
			return super.a(var1, var2);
		}
	}

	@Override
	public float a(class_cj var1) {
		return o.p(var1.b()).c() == Blocks.GRASS ? 10.0F : o.o(var1) - 0.5F;
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("InLove", bt);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		bt = var1.h("InLove");
	}

	@Override
	public boolean cj() {
		int var1 = MathHelper.c(s);
		int var2 = MathHelper.c(aX().b);
		int var3 = MathHelper.c(u);
		class_cj var4 = new class_cj(var1, var2, var3);
		return (o.p(var4.b()).c() == bw) && (o.k(var4) > 8) && super.cj();
	}

	@Override
	public int y() {
		return 120;
	}

	@Override
	protected boolean E() {
		return false;
	}

	@Override
	protected int b(class_yu var1) {
		return 1 + o.s.nextInt(3);
	}

	public boolean d(class_aco var1) {
		return var1 == null ? false : var1.b() == Items.Q;
	}

	@Override
	public boolean a(class_yu var1, class_pu var2, class_aco var3) {
		if (var3 != null) {
			if (this.d(var3) && (this.k() == 0) && (bt <= 0)) {
				this.a(var1, var3);
				this.a(var1);
				return true;
			}

			if (i_() && this.d(var3)) {
				this.a(var1, var3);
				this.a((int) (-this.k() / 20 * 0.1F), true);
				return true;
			}
		}

		return super.a(var1, var2, var3);
	}

	protected void a(class_yu var1, class_aco var2) {
		if (!var1.bI.d) {
			--var2.b;
		}

	}

	public void a(class_yu var1) {
		bt = 600;
		bu = var1;
		o.a(this, (byte) 18);
	}

	public class_yu cJ() {
		return bu;
	}

	public boolean cK() {
		return bt > 0;
	}

	public void cL() {
		bt = 0;
	}

	public boolean a(class_vc var1) {
		return var1 == this ? false : (var1.getClass() != this.getClass() ? false : cK() && var1.cK());
	}
}
