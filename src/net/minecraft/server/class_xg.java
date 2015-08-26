package net.minecraft.server;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Optional;

public class class_xg extends Entity {
	private static final Logger b = LogManager.getLogger();
	private static final class_jz c;
	private int d;
	private int e;
	private int f;
	private String g;
	private String h;
	public float a;

	public class_xg(class_ago var1, double var2, double var4, double var6) {
		super(var1);
		f = 5;
		a = (float) (Math.random() * 3.141592653589793D * 2.0D);
		this.a(0.25F, 0.25F);
		this.b(var2, var4, var6);
		y = (float) (Math.random() * 360.0D);
		v = ((float) ((Math.random() * 0.20000000298023224D) - 0.10000000149011612D));
		w = 0.20000000298023224D;
		x = ((float) ((Math.random() * 0.20000000298023224D) - 0.10000000149011612D));
	}

	public class_xg(class_ago var1, double var2, double var4, double var6, class_aco var8) {
		this(var1, var2, var4, var6);
		this.a(var8);
	}

	@Override
	protected boolean U() {
		return false;
	}

	public class_xg(class_ago var1) {
		super(var1);
		f = 5;
		a = (float) (Math.random() * 3.141592653589793D * 2.0D);
		this.a(0.25F, 0.25F);
		this.a(new class_aco(Blocks.AIR, 0));
	}

	@Override
	protected void h() {
		J().a(c, Optional.absent());
	}

	@Override
	public void r_() {
		if (this.j() == null) {
			L();
		} else {
			super.r_();
			if ((e > 0) && (e != 32767)) {
				--e;
			}

			p = s;
			q = t;
			r = u;
			w -= 0.03999999910593033D;
			T = this.j(s, (aX().b + aX().e) / 2.0D, u);
			this.d(v, w, x);
			boolean var1 = ((int) p != (int) s) || ((int) q != (int) t) || ((int) r != (int) u);
			if (var1 || ((W % 25) == 0)) {
				if (o.p(new class_cj(this)).c().v() == class_avq.i) {
					w = 0.20000000298023224D;
					v = (V.nextFloat() - V.nextFloat()) * 0.2F;
					x = (V.nextFloat() - V.nextFloat()) * 0.2F;
					this.a("random.fizz", 0.4F, 2.0F + (V.nextFloat() * 0.4F));
				}

				if (!o.D) {
					v();
				}
			}

			float var2 = 0.98F;
			if (C) {
				var2 = o.p(new class_cj(MathHelper.c(s), MathHelper.c(aX().b) - 1, MathHelper.c(u))).c().L * 0.98F;
			}

			v *= var2;
			w *= 0.9800000190734863D;
			x *= var2;
			if (C) {
				w *= -0.5D;
			}

			if (d != -32768) {
				++d;
			}

			Z();
			if (!o.D && (d >= 6000)) {
				L();
			}

		}
	}

	private void v() {
		Iterator var1 = o.a(class_xg.class, aX().b(0.5D, 0.0D, 0.5D)).iterator();

		while (var1.hasNext()) {
			class_xg var2 = (class_xg) var1.next();
			this.a(var2);
		}

	}

	private boolean a(class_xg var1) {
		if (var1 == this) {
			return false;
		} else if (var1.al() && al()) {
			class_aco var2 = this.j();
			class_aco var3 = var1.j();
			if ((e != 32767) && (var1.e != 32767)) {
				if ((d != -32768) && (var1.d != -32768)) {
					if (var3.b() != var2.b()) {
						return false;
					} else if (var3.n() ^ var2.n()) {
						return false;
					} else if (var3.n() && !var3.o().equals(var2.o())) {
						return false;
					} else if (var3.b() == null) {
						return false;
					} else if (var3.b().k() && (var3.i() != var2.i())) {
						return false;
					} else if (var3.b < var2.b) {
						return var1.a(this);
					} else if ((var3.b + var2.b) > var3.c()) {
						return false;
					} else {
						var3.b += var2.b;
						var1.e = Math.max(var1.e, e);
						var1.d = Math.min(var1.d, d);
						var1.a(var3);
						L();
						return true;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void i() {
		d = 4800;
	}

	@Override
	public boolean Z() {
		if (o.a(aX(), class_avq.h, this)) {
			if (!Y && !aa) {
				aa();
			}

			Y = true;
		} else {
			Y = false;
		}

		return Y;
	}

	@Override
	protected void f(int var1) {
		this.a(class_qi.a, var1);
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if ((this.j() != null) && (this.j().b() == Items.ce) && var1.c()) {
			return false;
		} else {
			af();
			f = (int) (f - var2);
			if (f <= 0) {
				L();
			}

			return false;
		}
	}

	@Override
	public void b(class_dn var1) {
		var1.a("Health", (short) f);
		var1.a("Age", (short) d);
		var1.a("PickupDelay", (short) e);
		if (this.m() != null) {
			var1.a("Thrower", g);
		}

		if (this.k() != null) {
			var1.a("Owner", h);
		}

		if (this.j() != null) {
			var1.a("Item", this.j().b(new class_dn()));
		}

	}

	@Override
	public void a(class_dn var1) {
		f = var1.g("Health");
		d = var1.g("Age");
		if (var1.e("PickupDelay")) {
			e = var1.g("PickupDelay");
		}

		if (var1.e("Owner")) {
			h = var1.l("Owner");
		}

		if (var1.e("Thrower")) {
			g = var1.l("Thrower");
		}

		class_dn var2 = var1.o("Item");
		this.a(class_aco.a(var2));
		if (this.j() == null) {
			L();
		}

	}

	@Override
	public void d(class_yu var1) {
		if (!o.D) {
			class_aco var2 = this.j();
			int var3 = var2.b;
			if ((e == 0) && ((h == null) || ((6000 - d) <= 200) || h.equals(var1.e_())) && var1.bq.a(var2)) {
				if (var2.b() == Item.a(Blocks.LOG)) {
					var1.b(class_my.g);
				}

				if (var2.b() == Item.a(Blocks.LOG2)) {
					var1.b(class_my.g);
				}

				if (var2.b() == Items.aH) {
					var1.b(class_my.t);
				}

				if (var2.b() == Items.k) {
					var1.b(class_my.w);
				}

				if (var2.b() == Items.bx) {
					var1.b(class_my.A);
				}

				if ((var2.b() == Items.k) && (this.m() != null)) {
					class_yu var4 = o.a(this.m());
					if ((var4 != null) && (var4 != var1)) {
						var4.b(class_my.x);
					}
				}

				if (!T()) {
					o.a((Entity) var1, "random.pop", 0.2F, (((V.nextFloat() - V.nextFloat()) * 0.7F) + 1.0F) * 2.0F);
				}

				var1.a(this, var3);
				if (var2.b <= 0) {
					L();
				}

				var1.a(class_nh.e(Item.b(var2.b())), var3);
			}

		}
	}

	@Override
	public String e_() {
		return k_() ? aS() : class_di.a("item." + this.j().a());
	}

	@Override
	public boolean aJ() {
		return false;
	}

	@Override
	public Entity a(int var1, class_cj var2) {
		Entity var3 = super.a(var1, var2);
		if (!o.D && (var3 instanceof class_xg)) {
			((class_xg) var3).v();
		}

		return var3;
	}

	public class_aco j() {
		class_aco var1 = (class_aco) ((Optional) J().a(c)).orNull();
		if (var1 == null) {
			if (o != null) {
				b.error("Item entity " + G() + " has no item?!");
			}

			return new class_aco(Blocks.STONE);
		} else {
			return var1;
		}
	}

	public void a(class_aco var1) {
		J().b(c, Optional.fromNullable(var1));
		J().b(c);
	}

	public String k() {
		return h;
	}

	public void d(String var1) {
		h = var1;
	}

	public String m() {
		return g;
	}

	public void e(String var1) {
		g = var1;
	}

	public void o() {
		e = 10;
	}

	public void p() {
		e = 0;
	}

	public void q() {
		e = 32767;
	}

	public void a(int var1) {
		e = var1;
	}

	public boolean r() {
		return e > 0;
	}

	public void t() {
		d = -6000;
	}

	public void u() {
		q();
		d = 5999;
	}

	static {
		c = class_kc.a(class_xg.class, class_kb.f);
	}
}
