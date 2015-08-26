package net.minecraft.server;

import com.google.common.base.Predicate;

public class class_vp extends class_vg {
	protected static final class_jz a;
	private int c;
	class_uv b;
	private int bt;
	private int bu;

	public class_vp(class_ago var1) {
		super(var1);
		this.a(1.4F, 2.9F);
		((class_ul) u()).a(true);
		i.a(1, new class_sz(this, 1.0D, true));
		i.a(2, new class_te(this, 0.9D, 32.0F));
		i.a(3, new class_tb(this, 0.6D, true));
		i.a(4, new class_td(this, 1.0D));
		i.a(5, new class_th(this));
		i.a(6, new class_tn(this, 0.6D));
		i.a(7, new class_sw(this, class_yu.class, 6.0F));
		i.a(8, new class_tm(this));
		bo.a(1, new class_ub(this));
		bo.a(2, new class_uc(this, false, new Class[0]));
		bo.a(3, new class_vp.class_a_in_class_vp(this, class_rh.class, 10, false, true, class_xx.e));
	}

	@Override
	protected void h() {
		super.h();
		ac.a(a, Byte.valueOf((byte) 0));
	}

	@Override
	protected void cg() {
		if (--c <= 0) {
			c = 70 + V.nextInt(50);
			b = o.ag().a(new class_cj(this), 32);
			if (b == null) {
				cC();
			} else {
				class_cj var1 = b.a();
				this.a(var1, (int) (b.b() * 0.6F));
			}
		}

		super.cg();
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(100.0D);
		this.a(class_yf.d).a(0.25D);
	}

	@Override
	protected int c(int var1) {
		return var1;
	}

	@Override
	protected void s(Entity var1) {
		if ((var1 instanceof class_xx) && !(var1 instanceof class_xu) && (bj().nextInt(20) == 0)) {
			this.c((class_rg) var1);
		}

		super.s(var1);
	}

	@Override
	public void m() {
		super.m();
		if (bt > 0) {
			--bt;
		}

		if (bu > 0) {
			--bu;
		}

		if ((((v * v) + (x * x)) > 2.500000277905201E-7D) && (V.nextInt(5) == 0)) {
			int var1 = class_oa.c(s);
			int var2 = class_oa.c(t - 0.20000000298023224D);
			int var3 = class_oa.c(u);
			class_apn var4 = o.p(new class_cj(var1, var2, var3));
			Block var5 = var4.c();
			if (var5.v() != class_avq.a) {
				o.a(class_cy.L, s + ((V.nextFloat() - 0.5D) * J), aX().b + 0.1D, u + ((V.nextFloat() - 0.5D) * J), 4.0D * (V.nextFloat() - 0.5D), 0.5D, (V.nextFloat() - 0.5D) * 4.0D, new int[] { Block.f(var4) });
			}
		}

	}

	@Override
	public boolean a(Class var1) {
		return cG() && class_yu.class.isAssignableFrom(var1) ? false : (var1 == class_xu.class ? false : super.a(var1));
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("PlayerCreated", cG());
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		this.m(var1.p("PlayerCreated"));
	}

	@Override
	public boolean r(Entity var1) {
		bt = 10;
		o.a(this, (byte) 4);
		boolean var2 = var1.a(class_qi.a(this), 7 + V.nextInt(15));
		if (var2) {
			var1.w += 0.4000000059604645D;
			this.a(this, var1);
		}

		this.a("mob.irongolem.throw", 1.0F, 1.0F);
		return var2;
	}

	public class_uv n() {
		return b;
	}

	public void a(boolean var1) {
		bu = var1 ? 400 : 0;
		o.a(this, (byte) 11);
	}

	@Override
	protected String bv() {
		return "mob.irongolem.hit";
	}

	@Override
	protected String bw() {
		return "mob.irongolem.death";
	}

	@Override
	protected void a(class_cj var1, Block var2) {
		this.a("mob.irongolem.walk", 1.0F, 1.0F);
	}

	@Override
	protected void b(boolean var1, int var2) {
		int var3 = V.nextInt(3);

		int var4;
		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Item.a(Blocks.RED_FLOWER), 1, BlockFlowers.class_a_in_class_ake.b.b());
		}

		var4 = 3 + V.nextInt(3);

		for (int var5 = 0; var5 < var4; ++var5) {
			this.a(Items.l, 1);
		}

	}

	public int cF() {
		return bu;
	}

	public boolean cG() {
		return (((Byte) ac.a(a)).byteValue() & 1) != 0;
	}

	public void m(boolean var1) {
		byte var2 = ((Byte) ac.a(a)).byteValue();
		if (var1) {
			ac.b(a, Byte.valueOf((byte) (var2 | 1)));
		} else {
			ac.b(a, Byte.valueOf((byte) (var2 & -2)));
		}

	}

	@Override
	public void a(class_qi var1) {
		if (!cG() && (aR != null) && (b != null)) {
			b.a(aR.e_(), -5);
		}

		super.a(var1);
	}

	static {
		a = class_kc.a(class_vp.class, class_kb.a);
	}

	static class class_a_in_class_vp extends class_uf {
		public class_a_in_class_vp(final class_rn var1, Class var2, int var3, boolean var4, boolean var5, final Predicate var6) {
			super(var1, var2, var3, var4, var5, var6);
			c = new Predicate() {
				public boolean a(class_rg var1x) {
					if ((var6 != null) && !var6.apply(var1x)) {
						return false;
					} else if (var1x instanceof class_xu) {
						return false;
					} else {
						if (var1x instanceof class_yu) {
							double var2 = class_a_in_class_vp.this.f();
							if (var1x.aA()) {
								var2 *= 0.800000011920929D;
							}

							if (var1x.aD()) {
								float var4 = ((class_yu) var1x).ch();
								if (var4 < 0.1F) {
									var4 = 0.1F;
								}

								var2 *= 0.7F * var4;
							}

							if (var1x.g(var1) > var2) {
								return false;
							}
						}

						return class_a_in_class_vp.this.a(var1x, false);
					}
				}

				// $FF: synthetic method
				@Override
				public boolean apply(Object var1x) {
					return this.a((class_rg) var1x);
				}
			};
		}
	}
}
