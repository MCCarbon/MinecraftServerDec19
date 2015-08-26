package net.minecraft.server;


public abstract class class_yc extends class_rn implements class_xx {
	public class_yc(class_ago var1) {
		super(var1);
		b_ = 5;
	}

	@Override
	public void m() {
		bD();
		float var1 = this.f(1.0F);
		if (var1 > 0.5F) {
			aU += 2;
		}

		super.m();
	}

	@Override
	public void r_() {
		super.r_();
		if (!o.D && (o.ac() == class_ps.a)) {
			L();
		}

	}

	@Override
	protected String R() {
		return "game.hostile.swim";
	}

	@Override
	protected String ad() {
		return "game.hostile.swim.splash";
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (super.a(var1, var2)) {
			Entity var3 = var1.j();
			return (l != var3) && (m != var3) ? true : true;
		} else {
			return false;
		}
	}

	@Override
	protected String bv() {
		return "game.hostile.hurt";
	}

	@Override
	protected String bw() {
		return "game.hostile.die";
	}

	@Override
	protected String i(int var1) {
		return var1 > 4 ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small";
	}

	@Override
	public boolean r(Entity var1) {
		float var2 = (float) this.a(class_yf.e).e();
		int var3 = 0;
		if (var1 instanceof class_rg) {
			var2 += class_afl.a(bG(), ((class_rg) var1).bF());
			var3 += class_afl.a(this);
		}

		boolean var4 = var1.a(class_qi.a(this), var2);
		if (var4) {
			if (var3 > 0) {
				var1.g(-MathHelper.a((y * 3.1415927F) / 180.0F) * var3 * 0.5F, 0.1D, MathHelper.b((y * 3.1415927F) / 180.0F) * var3 * 0.5F);
				v *= 0.6D;
				x *= 0.6D;
			}

			int var5 = class_afl.b(this);
			if (var5 > 0) {
				var1.e(var5 * 4);
			}

			if (var1 instanceof class_yu) {
				class_yu var6 = (class_yu) var1;
				class_aco var7 = bG();
				class_aco var8 = var6.bX() ? var6.ca() : null;
				if ((var7 != null) && (var8 != null) && (var7.b() instanceof class_aay) && (var8.b() == Items.cK)) {
					float var9 = 0.25F + (class_afl.e(this) * 0.05F);
					if (V.nextFloat() < var9) {
						var6.cB().a(Items.cK, 100);
						o.a(var6, (byte) 30);
					}
				}
			}

			this.a(this, var1);
		}

		return var4;
	}

	@Override
	public float a(class_cj var1) {
		return 0.5F - o.o(var1);
	}

	protected boolean m_() {
		class_cj var1 = new class_cj(s, aX().b, u);
		if (o.b(class_agu.a, var1) > V.nextInt(32)) {
			return false;
		} else {
			int var2 = o.l(var1);
			if (o.T()) {
				int var3 = o.ad();
				o.c(10);
				var2 = o.l(var1);
				o.c(var3);
			}

			return var2 <= V.nextInt(8);
		}
	}

	@Override
	public boolean cj() {
		return (o.ac() != class_ps.a) && m_() && super.cj();
	}

	@Override
	protected void be() {
		super.be();
		bE().b(class_yf.e);
	}

	@Override
	protected boolean bh() {
		return true;
	}
}
