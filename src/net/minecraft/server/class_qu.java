package net.minecraft.server;


public abstract class class_qu extends class_rn {
	private static final class_jz bt;
	protected int a;
	protected int b;
	protected int c;
	private float bu = -1.0F;
	private float bv;

	public class_qu(class_ago var1) {
		super(var1);
	}

	public abstract class_qu a(class_qu var1);

	@Override
	public boolean a(class_yu var1, class_pu var2, class_aco var3) {
		if ((var3 != null) && (var3.b() == class_acq.bO)) {
			if (!o.D) {
				Class var4 = class_qz.a(var3.i());
				if ((var4 != null) && (this.getClass() == var4)) {
					class_qu var5 = this.a(this);
					if (var5 != null) {
						var5.b(-24000);
						var5.b(s, t, u, 0.0F, 0.0F);
						o.a(var5);
						if (var3.s()) {
							var5.c(var3.q());
						}

						if (!var1.bI.d) {
							--var3.b;
						}
					}
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void h() {
		super.h();
		ac.a(bt, Boolean.valueOf(false));
	}

	public int k() {
		return o.D ? (((Boolean) ac.a(bt)).booleanValue() ? -1 : 1) : a;
	}

	public void a(int var1, boolean var2) {
		int var3 = this.k();
		int var4 = var3;
		var3 += var1 * 20;
		if (var3 > 0) {
			var3 = 0;
			if (var4 < 0) {
				this.n();
			}
		}

		int var5 = var3 - var4;
		this.b(var3);
		if (var2) {
			b += var5;
			if (c == 0) {
				c = 40;
			}
		}

		if (this.k() == 0) {
			this.b(b);
		}

	}

	public void a(int var1) {
		this.a(var1, false);
	}

	public void b(int var1) {
		ac.b(bt, Boolean.valueOf(var1 < 0));
		a = var1;
		this.a(i_());
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("Age", this.k());
		var1.a("ForcedAge", b);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		this.b(var1.h("Age"));
		b = var1.h("ForcedAge");
	}

	@Override
	public void a(class_jz var1) {
		if (var1 == bt) {
			this.a(i_());
		}

		super.a(var1);
	}

	@Override
	public void m() {
		super.m();
		if (o.D) {
			if (c > 0) {
				if ((c % 4) == 0) {
					o.a(class_cy.v, (s + V.nextFloat() * J * 2.0F) - J, t + 0.5D + V.nextFloat() * K, (u + V.nextFloat() * J * 2.0F) - J, 0.0D, 0.0D, 0.0D, new int[0]);
				}

				--c;
			}
		} else {
			int var1 = this.k();
			if (var1 < 0) {
				++var1;
				this.b(var1);
				if (var1 == 0) {
					this.n();
				}
			} else if (var1 > 0) {
				--var1;
				this.b(var1);
			}
		}

	}

	protected void n() {
	}

	@Override
	public boolean i_() {
		return this.k() < 0;
	}

	public void a(boolean var1) {
		this.a(var1 ? 0.5F : 1.0F);
	}

	@Override
	protected final void a(float var1, float var2) {
		boolean var3 = bu > 0.0F;
		bu = var1;
		bv = var2;
		if (!var3) {
			this.a(1.0F);
		}

	}

	protected final void a(float var1) {
		super.a(bu * var1, bv * var1);
	}

	static {
		bt = class_kc.a(class_qu.class, class_kb.g);
	}
}
