package net.minecraft.server;

import org.apache.commons.lang3.Validate;

import com.google.common.base.Predicate;

public abstract class class_wt extends Entity {
	private static final Predicate c = new Predicate() {
		public boolean a(Entity var1) {
			return var1 instanceof class_wt;
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((Entity) var1);
		}
	};
	private int d;
	protected class_cj a;
	public class_cq b;

	public class_wt(class_ago var1) {
		super(var1);
		this.a(0.5F, 0.5F);
	}

	public class_wt(class_ago var1, class_cj var2) {
		this(var1);
		a = var2;
	}

	@Override
	protected void h() {
	}

	protected void a(class_cq var1) {
		Validate.notNull(var1);
		Validate.isTrue(var1.k().c());
		b = var1;
		A = y = b.b() * 90;
		this.n();
	}

	private void n() {
		if (b != null) {
			double var1 = a.n() + 0.5D;
			double var3 = a.o() + 0.5D;
			double var5 = a.p() + 0.5D;
			double var7 = 0.46875D;
			double var9 = this.a(this.j());
			double var11 = this.a(this.k());
			var1 -= b.g() * 0.46875D;
			var5 -= b.i() * 0.46875D;
			var3 += var11;
			class_cq var13 = b.f();
			var1 += var9 * var13.g();
			var5 += var9 * var13.i();
			s = var1;
			t = var3;
			u = var5;
			double var14 = this.j();
			double var16 = this.k();
			double var18 = this.j();
			if (b.k() == class_cq.class_a_in_class_cq.c) {
				var18 = 1.0D;
			} else {
				var14 = 1.0D;
			}

			var14 /= 32.0D;
			var16 /= 32.0D;
			var18 /= 32.0D;
			this.a((new class_ayk(var1 - var14, var3 - var16, var5 - var18, var1 + var14, var3 + var16, var5 + var18)));
		}
	}

	private double a(int var1) {
		return (var1 % 32) == 0 ? 0.5D : 0.0D;
	}

	@Override
	public void r_() {
		p = s;
		q = t;
		r = u;
		if ((d++ == 100) && !o.D) {
			d = 0;
			if (!I && !this.i()) {
				L();
				this.b((Entity) null);
			}
		}

	}

	public boolean i() {
		if (!o.a(this, aX()).isEmpty()) {
			return false;
		} else {
			int var1 = Math.max(1, this.j() / 16);
			int var2 = Math.max(1, this.k() / 16);
			class_cj var3 = a.a(b.d());
			class_cq var4 = b.f();

			for (int var5 = 0; var5 < var1; ++var5) {
				for (int var6 = 0; var6 < var2; ++var6) {
					class_cj var7 = var3.a(var4, var5).b(var6);
					Block var8 = o.p(var7).c();
					if (!var8.v().a() && !class_ajj.d(var8)) {
						return false;
					}
				}
			}

			return o.a(this, aX(), c).isEmpty();
		}
	}

	@Override
	public boolean ag() {
		return true;
	}

	@Override
	public boolean m(Entity var1) {
		return var1 instanceof class_yu ? this.a(class_qi.a((class_yu) var1), 0.0F) : false;
	}

	@Override
	public class_cq aV() {
		return b;
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			if (!I && !o.D) {
				L();
				af();
				this.b(var1.j());
			}

			return true;
		}
	}

	@Override
	public void d(double var1, double var3, double var5) {
		if (!o.D && !I && (((var1 * var1) + (var3 * var3) + (var5 * var5)) > 0.0D)) {
			L();
			this.b((Entity) null);
		}

	}

	@Override
	public void g(double var1, double var3, double var5) {
		if (!o.D && !I && (((var1 * var1) + (var3 * var3) + (var5 * var5)) > 0.0D)) {
			L();
			this.b((Entity) null);
		}

	}

	@Override
	public void b(class_dn var1) {
		var1.a("Facing", (byte) b.b());
		class_cj var2 = this.m();
		var1.a("TileX", var2.n());
		var1.a("TileY", var2.o());
		var1.a("TileZ", var2.p());
	}

	@Override
	public void a(class_dn var1) {
		a = new class_cj(var1.h("TileX"), var1.h("TileY"), var1.h("TileZ"));
		this.a(class_cq.b(var1.f("Facing")));
	}

	public abstract int j();

	public abstract int k();

	public abstract void b(Entity var1);

	@Override
	protected boolean ai() {
		return false;
	}

	@Override
	public void b(double var1, double var3, double var5) {
		s = var1;
		t = var3;
		u = var5;
		class_cj var7 = a;
		a = new class_cj(var1, var3, var5);
		if (!a.equals(var7)) {
			this.n();
			ai = true;
		}

	}

	public class_cj m() {
		return a;
	}

	@Override
	public float a(Block.class_c_in_class_ail var1) {
		if (b.k() != class_cq.class_a_in_class_cq.b) {
			switch (class_wt.SyntheticClass_1.a[var1.ordinal()]) {
				case 1:
					b = b.d();
					break;
				case 2:
					b = b.f();
					break;
				case 3:
					b = b.e();
			}
		}

		return super.a(var1);
	}

	@Override
	public float a(Block.class_a_in_class_ail var1) {
		return this.a(var1.a(b));
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[Block.class_c_in_class_ail.values().length];

		static {
			try {
				a[Block.class_c_in_class_ail.c.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.d.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.b.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
