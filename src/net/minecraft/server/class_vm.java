package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;

public class class_vm extends class_vg implements class_xx {
	protected static final class_jz a;
	protected static final class_jz b;
	protected static final class_jz c;
	private float bt;
	private float bu;
	private class_cj bv;
	private int bw;

	public class_vm(class_ago var1) {
		super(var1);
		this.a(1.0F, 1.0F);
		aN = 180.0F;
		aM = 180.0F;
		ab = true;
		bv = null;
		i.a(1, new class_sw(this, class_yu.class, 8.0F));
		i.a(4, new class_vm.class_a_in_class_vm());
		i.a(7, new class_vm.class_e_in_class_vm((class_vm.SyntheticClass_1) null));
		i.a(8, new class_tm(this));
		bo.a(1, new class_uc(this, true, new Class[0]));
		bo.a(2, new class_vm.class_d_in_class_vm(this));
		bo.a(3, new class_vm.class_c_in_class_vm(this));
	}

	@Override
	protected void h() {
		super.h();
		ac.a(a, class_cq.a);
		ac.a(b, Optional.absent());
		ac.a(c, Byte.valueOf((byte) 0));
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(30.0D);
	}

	@Override
	protected class_sa p() {
		return new class_vm.class_b_in_class_vm(this);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		ac.b(a, class_cq.a(var1.f("AttachFace")));
		ac.b(c, Byte.valueOf(var1.f("Peek")));
		if (var1.e("APX")) {
			int var2 = var1.h("APX");
			int var3 = var1.h("APY");
			int var4 = var1.h("APZ");
			ac.b(b, Optional.of(new class_cj(var2, var3, var4)));
		} else {
			ac.b(b, Optional.absent());
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("AttachFace", (byte) ((class_cq) ac.a(a)).a());
		var1.a("Peek", ((Byte) ac.a(c)).byteValue());
		class_cj var2 = cF();
		if (var2 != null) {
			var1.a("APX", var2.n());
			var1.a("APY", var2.o());
			var1.a("APZ", var2.p());
		}

	}

	@Override
	public void r_() {
		super.r_();
		class_cj var1 = (class_cj) ((Optional) ac.a(b)).orNull();
		if ((var1 == null) && !o.D) {
			var1 = new class_cj(this);
			ac.b(b, Optional.of(var1));
		}

		if (!az()) {
			if (!o.D) {
				class_apn var2 = o.p(var1);
				if (var2.c() != Blocks.a) {
					class_cq var3;
					if (var2.c() == Blocks.M) {
						var3 = (class_cq) var2.b(class_ajk.b);
						var1 = var1.a(var3);
						ac.b(b, Optional.of(var1));
					} else if (var2.c() == Blocks.K) {
						var3 = (class_cq) var2.b(class_ajk.b);
						var1 = var1.a(var3);
						ac.b(b, Optional.of(var1));
					} else {
						this.n();
					}
				}
			}

			if (!o.D) {
				class_cj var15 = var1.a(cE());
				if (!o.d(var15, false)) {
					boolean var17 = false;
					class_cq[] var4 = class_cq.values();
					int var5 = var4.length;

					for (int var6 = 0; var6 < var5; ++var6) {
						class_cq var7 = var4[var6];
						var15 = var1.a(var7);
						if (o.d(var15, false)) {
							ac.b(a, var7);
							var17 = true;
							break;
						}
					}

					if (!var17) {
						this.n();
					}
				}
			}
		} else {
			var1 = null;
			bw = 0;
		}

		float var16 = cG() * 0.01F;
		bt = bu;
		if (bu > var16) {
			bu = class_oa.a(bu - 0.05F, var16, 1.0F);
		} else if (bu < var16) {
			bu = class_oa.a(bu + 0.05F, 0.0F, var16);
		}

		if (var1 != null) {
			double var18 = bu - bt;
			double var19 = 0.0D;
			double var20 = 0.0D;
			double var9 = 0.0D;
			if (o.D) {
				if ((bw > 0) && (bv != null)) {
					--bw;
				} else {
					bv = var1;
				}
			}

			P = p = s = var1.n() + 0.5D;
			Q = q = t = var1.o();
			R = r = u = var1.p() + 0.5D;
			class_cq var11 = cE();
			switch (class_vm.SyntheticClass_1.a[var11.ordinal()]) {
				case 1:
				default:
					this.a((new class_ayk(s - 0.5D, t, u - 0.5D, s + 0.5D, t + 1.0D + bu, u + 0.5D)));
					var20 = var18;
					break;
				case 2:
					this.a((new class_ayk(s - 0.5D, t - bu, u - 0.5D, s + 0.5D, t + 1.0D, u + 0.5D)));
					var20 = -var18;
					break;
				case 3:
					this.a((new class_ayk(s - 0.5D, t, u - 0.5D, s + 0.5D, t + 1.0D, u + 0.5D + bu)));
					var9 = var18;
					break;
				case 4:
					this.a((new class_ayk(s - 0.5D, t, u - 0.5D - bu, s + 0.5D, t + 1.0D, u + 0.5D)));
					var9 = -var18;
					break;
				case 5:
					this.a((new class_ayk(s - 0.5D, t, u - 0.5D, s + 0.5D + bu, t + 1.0D, u + 0.5D)));
					var19 = var18;
					break;
				case 6:
					this.a((new class_ayk(s - 0.5D - bu, t, u - 0.5D, s + 0.5D, t + 1.0D, u + 0.5D)));
					var19 = -var18;
			}

			if (var18 > 0.0D) {
				List var12 = o.b(this, aX());
				if (!var12.isEmpty()) {
					Iterator var13 = var12.iterator();

					while (var13.hasNext()) {
						Entity var14 = (Entity) var13.next();
						if (!(var14 instanceof class_vm) && !var14.T) {
							var14.d(var19, var20, var9);
						}
					}
				}
			}
		}

	}

	@Override
	public void b(double var1, double var3, double var5) {
		super.b(var1, var3, var5);
		if ((ac != null) && (W != 0)) {
			Optional var7 = (Optional) ac.a(b);
			Optional var8 = Optional.of(new class_cj(var1, var3, var5));
			if (!var8.equals(var7)) {
				ac.b(b, var8);
				ac.b(c, Byte.valueOf((byte) 0));
				ai = true;
			}

		}
	}

	protected boolean n() {
		if (cw()) {
			return true;
		} else {
			class_cj var1 = new class_cj(this);

			for (int var2 = 0; var2 < 5; ++var2) {
				class_cj var3 = var1.a(8 - V.nextInt(17), 8 - V.nextInt(17), 8 - V.nextInt(17));
				if ((var3.o() > 0) && o.d(var3) && o.a(o.ah(), this)) {
					boolean var4 = false;
					class_cq[] var5 = class_cq.values();
					int var6 = var5.length;

					for (int var7 = 0; var7 < var6; ++var7) {
						class_cq var8 = var5[var7];
						if (o.d(var3.a(var8), false)) {
							ac.b(a, var8);
							var4 = true;
							break;
						}
					}

					if (var4) {
						this.a("mob.endermen.portal", 1.0F, 1.0F);
						ac.b(b, Optional.of(var3));
						ac.b(c, Byte.valueOf((byte) 0));
						this.c((class_rg) null);
						return true;
					}
				}
			}

			return false;
		}
	}

	@Override
	public void m() {
		super.m();
		v = 0.0D;
		w = 0.0D;
		x = 0.0D;
		aN = 180.0F;
		aM = 180.0F;
		y = 180.0F;
	}

	@Override
	public void a(class_jz var1) {
		if ((var1 == b) && o.D && !az()) {
			class_cj var2 = cF();
			if (var2 != null) {
				if (bv == null) {
					bv = var2;
				} else {
					bw = 6;
				}

				P = p = s = var2.n() + 0.5D;
				Q = q = t = var2.o();
				R = r = u = var2.p() + 0.5D;
			}
		}

		super.a(var1);
	}

	@Override
	public int by() {
		return cG() == 0 ? 20 : super.by();
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (cG() == 0) {
			Entity var3 = var1.i();
			if (var3 instanceof class_yx) {
				return false;
			}
		}

		if (super.a(var1, var2)) {
			if ((bu() < (bB() * 0.5D)) && (V.nextInt(4) == 0)) {
				this.n();
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public class_ayk V() {
		return al() ? aX() : null;
	}

	public class_cq cE() {
		return (class_cq) ac.a(a);
	}

	public class_cj cF() {
		return (class_cj) ((Optional) ac.a(b)).orNull();
	}

	public void f(class_cj var1) {
		ac.b(b, Optional.fromNullable(var1));
	}

	public int cG() {
		return ((Byte) ac.a(c)).byteValue();
	}

	public void a(int var1) {
		ac.b(c, Byte.valueOf((byte) var1));
	}

	@Override
	public float aY() {
		return 0.5F;
	}

	@Override
	public int ch() {
		return 180;
	}

	@Override
	public int ci() {
		return 180;
	}

	@Override
	public void i(Entity var1) {
	}

	static {
		a = class_kc.a(class_vm.class, class_kb.k);
		b = class_kc.a(class_vm.class, class_kb.j);
		c = class_kc.a(class_vm.class, class_kb.a);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.a.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_cq.b.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_cq.c.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 5;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.f.ordinal()] = 6;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	static class class_c_in_class_vm extends class_uf {
		public class_c_in_class_vm(class_vm var1) {
			super(var1, class_rg.class, 10, true, false, new Predicate() {
				public boolean a(class_rg var1) {
					return var1 instanceof class_xx;
				}

				// $FF: synthetic method
				@Override
				public boolean apply(Object var1) {
					return this.a((class_rg) var1);
				}
			});
		}

		@Override
		public boolean a() {
			return e.aE() == null ? false : super.a();
		}

		@Override
		protected class_ayk a(double var1) {
			class_cq var3 = ((class_vm) e).cE();
			return var3.k() == class_cq.class_a_in_class_cq.a ? e.aX().b(4.0D, var1, var1) : (var3.k() == class_cq.class_a_in_class_cq.c ? e.aX().b(var1, var1, 4.0D) : e.aX().b(var1, 4.0D, var1));
		}
	}

	static class class_d_in_class_vm extends class_uf {
		public class_d_in_class_vm(class_vm var1) {
			super(var1, class_yu.class, true);
		}

		@Override
		protected class_ayk a(double var1) {
			class_cq var3 = ((class_vm) e).cE();
			return var3.k() == class_cq.class_a_in_class_cq.a ? e.aX().b(4.0D, var1, var1) : (var3.k() == class_cq.class_a_in_class_cq.c ? e.aX().b(var1, var1, 4.0D) : e.aX().b(var1, 4.0D, var1));
		}
	}

	class class_a_in_class_vm extends class_sr {
		private int b;

		public class_a_in_class_vm() {
			this.a(3);
		}

		@Override
		public boolean a() {
			class_rg var1 = w();
			return (var1 != null) && var1.al();
		}

		@Override
		public void c() {
			b = 20;
			class_vm.this.a(100);
		}

		@Override
		public void d() {
			class_vm.this.a(0);
		}

		@Override
		public void e() {
			--b;
			class_rg var1 = w();
			class_vm.this.q().a(var1, 180.0F, 180.0F);
			double var2 = class_vm.this.h(var1);
			if (var2 < 400.0D) {
				if (b <= 0) {
					b = 20 + ((class_vm.this.V.nextInt(10) * 20) / 2);
					class_zf var4 = new class_zf(class_vm.this.o, class_vm.this, var1, cE().k());
					class_vm.this.o.a(var4);
					class_vm.this.a("mob.ghast.fireball", 2.0F, ((class_vm.this.V.nextFloat() - class_vm.this.V.nextFloat()) * 0.2F) + 1.0F);
				}
			} else {
				class_vm.this.c((class_rg) null);
			}

			super.e();
		}
	}

	class class_e_in_class_vm extends class_sr {
		private int b;

		private class_e_in_class_vm() {
		}

		@Override
		public boolean a() {
			return (w() == null) && (class_vm.this.V.nextInt(40) == 0);
		}

		@Override
		public boolean b() {
			return (w() == null) && (b > 0);
		}

		@Override
		public void c() {
			b = 20 * (1 + class_vm.this.V.nextInt(3));
			class_vm.this.a(30);
		}

		@Override
		public void d() {
			if (w() == null) {
				class_vm.this.a(0);
			}

		}

		@Override
		public void e() {
			--b;
		}

		// $FF: synthetic method
		class_e_in_class_vm(class_vm.SyntheticClass_1 var2) {
			this();
		}
	}

	class class_b_in_class_vm extends class_sa {
		public class_b_in_class_vm(class_rg var2) {
			super(var2);
		}

		@Override
		public void a() {
		}
	}
}
