package net.minecraft.server;

import java.util.Calendar;

public class class_va extends class_uz {
	private static final class_jz a;
	private class_cj b;

	public class_va(class_ago var1) {
		super(var1);
		this.a(0.5F, 0.9F);
		this.a(true);
	}

	@Override
	protected void h() {
		super.h();
		ac.a(a, Byte.valueOf((byte) 0));
	}

	@Override
	protected float bI() {
		return 0.1F;
	}

	@Override
	protected float bJ() {
		return super.bJ() * 0.95F;
	}

	@Override
	protected String B() {
		return this.n() && (V.nextInt(4) != 0) ? null : "mob.bat.idle";
	}

	@Override
	protected String bv() {
		return "mob.bat.hurt";
	}

	@Override
	protected String bw() {
		return "mob.bat.death";
	}

	@Override
	public boolean ah() {
		return false;
	}

	@Override
	protected void s(Entity var1) {
	}

	@Override
	protected void bS() {
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(6.0D);
	}

	public boolean n() {
		return (((Byte) ac.a(a)).byteValue() & 1) != 0;
	}

	public void a(boolean var1) {
		byte var2 = ((Byte) ac.a(a)).byteValue();
		if (var1) {
			ac.b(a, Byte.valueOf((byte) (var2 | 1)));
		} else {
			ac.b(a, Byte.valueOf((byte) (var2 & -2)));
		}

	}

	@Override
	public void r_() {
		super.r_();
		if (this.n()) {
			v = w = x = 0.0D;
			t = (MathHelper.c(t) + 1.0D) - K;
		} else {
			w *= 0.6000000238418579D;
		}

	}

	@Override
	protected void cg() {
		super.cg();
		class_cj var1 = new class_cj(this);
		class_cj var2 = var1.a();
		if (this.n()) {
			if (!o.p(var2).c().x()) {
				this.a(false);
				o.a((class_yu) null, 1015, var1, 0);
			} else {
				if (V.nextInt(200) == 0) {
					aO = V.nextInt(360);
				}

				if (o.a(this, 4.0D) != null) {
					this.a(false);
					o.a((class_yu) null, 1015, var1, 0);
				}
			}
		} else {
			if ((b != null) && (!o.d(b) || (b.o() < 1))) {
				b = null;
			}

			if ((b == null) || (V.nextInt(30) == 0) || (b.c(((int) s), ((int) t), ((int) u)) < 4.0D)) {
				b = new class_cj(((int) s + V.nextInt(7)) - V.nextInt(7), ((int) t + V.nextInt(6)) - 2, ((int) u + V.nextInt(7)) - V.nextInt(7));
			}

			double var3 = (b.n() + 0.5D) - s;
			double var5 = (b.o() + 0.1D) - t;
			double var7 = (b.p() + 0.5D) - u;
			v += ((Math.signum(var3) * 0.5D) - v) * 0.10000000149011612D;
			w += ((Math.signum(var5) * 0.699999988079071D) - w) * 0.10000000149011612D;
			x += ((Math.signum(var7) * 0.5D) - x) * 0.10000000149011612D;
			float var9 = (float) ((MathHelper.b(x, v) * 180.0D) / 3.1415927410125732D) - 90.0F;
			float var10 = MathHelper.g(var9 - y);
			be = 0.5F;
			y += var10;
			if ((V.nextInt(100) == 0) && o.p(var2).c().x()) {
				this.a(true);
			}
		}

	}

	@Override
	protected boolean U() {
		return false;
	}

	@Override
	public void e(float var1, float var2) {
	}

	@Override
	protected void a(double var1, boolean var3, Block var4, class_cj var5) {
	}

	@Override
	public boolean aO() {
		return true;
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			if (!o.D && this.n()) {
				this.a(false);
			}

			return super.a(var1, var2);
		}
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		ac.b(a, Byte.valueOf(var1.f("BatFlags")));
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("BatFlags", ((Byte) ac.a(a)).byteValue());
	}

	@Override
	public boolean cj() {
		class_cj var1 = new class_cj(s, aX().b, u);
		if (var1.o() >= o.H()) {
			return false;
		} else {
			int var2 = o.l(var1);
			byte var3 = 4;
			if (this.a(o.aa())) {
				var3 = 7;
			} else if (V.nextBoolean()) {
				return false;
			}

			return var2 > V.nextInt(var3) ? false : super.cj();
		}
	}

	private boolean a(Calendar var1) {
		return (((var1.get(2) + 1) == 10) && (var1.get(5) >= 20)) || (((var1.get(2) + 1) == 11) && (var1.get(5) <= 3));
	}

	@Override
	public float aY() {
		return K / 2.0F;
	}

	static {
		a = class_kc.a(class_va.class, class_kb.a);
	}
}
