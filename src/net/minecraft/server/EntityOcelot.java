package net.minecraft.server;

import com.google.common.base.Predicate;

public class EntityOcelot extends class_ro {
	private static final class_jz bx;
	private class_sg by;
	private class_tw bz;

	public EntityOcelot(class_ago var1) {
		super(var1);
		this.a(0.6F, 0.7F);
		((class_ul) u()).a(true);
		i.a(1, new class_so(this));
		i.a(2, bv);
		i.a(3, bz = new class_tw(this, 0.6D, Items.aW, true));
		i.a(5, new class_sp(this, 1.0D, 10.0F, 5.0F));
		i.a(6, new class_tg(this, 0.8D));
		i.a(7, new class_sv(this, 0.3F));
		i.a(8, new class_tf(this));
		i.a(9, new class_sj(this, 0.8D));
		i.a(10, new class_tn(this, 0.8D));
		i.a(11, new class_sw(this, class_yu.class, 10.0F));
		bo.a(1, new class_ug(this, EntityChicken.class, false, (Predicate) null));
	}

	@Override
	protected void h() {
		super.h();
		ac.a(bx, Integer.valueOf(0));
	}

	@Override
	public void cg() {
		if (this.r().a()) {
			double var1 = this.r().b();
			if (var1 == 0.6D) {
				this.c(true);
				this.d(false);
			} else if (var1 == 1.33D) {
				this.c(false);
				this.d(true);
			} else {
				this.c(false);
				this.d(false);
			}
		} else {
			this.c(false);
			this.d(false);
		}

	}

	@Override
	protected boolean E() {
		return !cE() && (W > 2400);
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(10.0D);
		this.a(class_yf.d).a(0.30000001192092896D);
	}

	@Override
	public void e(float var1, float var2) {
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("CatType", cM());
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		this.k(var1.h("CatType"));
	}

	@Override
	protected String B() {
		return cE() ? (cK() ? "mob.cat.purr" : (V.nextInt(4) == 0 ? "mob.cat.purreow" : "mob.cat.meow")) : "";
	}

	@Override
	protected String bv() {
		return "mob.cat.hitt";
	}

	@Override
	protected String bw() {
		return "mob.cat.hitt";
	}

	@Override
	protected float bI() {
		return 0.4F;
	}

	@Override
	protected Item D() {
		return Items.aH;
	}

	@Override
	public boolean r(Entity var1) {
		return var1.a(class_qi.a(this), 3.0F);
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			bv.a(false);
			return super.a(var1, var2);
		}
	}

	@Override
	protected void b(boolean var1, int var2) {
	}

	@Override
	public boolean a(class_yu var1, class_pu var2, class_aco var3) {
		if (cE()) {
			if (this.d((EntityLiving) var1) && !o.D && !this.d(var3)) {
				bv.a(!cG());
			}
		} else if (bz.f() && (var3 != null) && (var3.b() == Items.aW) && (var1.h(this) < 9.0D)) {
			if (!var1.bI.d) {
				--var3.b;
			}

			if (!o.D) {
				if (V.nextInt(3) == 0) {
					this.n(true);
					this.k(1 + o.s.nextInt(3));
					this.b(var1.aQ());
					this.m(true);
					bv.a(true);
					o.a(this, (byte) 7);
				} else {
					this.m(false);
					o.a(this, (byte) 6);
				}
			}

			return true;
		}

		return super.a(var1, var2, var3);
	}

	public EntityOcelot b(EntityAgeable var1) {
		EntityOcelot var2 = new EntityOcelot(o);
		if (cE()) {
			var2.b(this.b());
			var2.n(true);
			var2.k(cM());
		}

		return var2;
	}

	@Override
	public boolean d(class_aco var1) {
		return (var1 != null) && (var1.b() == Items.aW);
	}

	@Override
	public boolean a(EntityAnimal var1) {
		if (var1 == this) {
			return false;
		} else if (!cE()) {
			return false;
		} else if (!(var1 instanceof EntityOcelot)) {
			return false;
		} else {
			EntityOcelot var2 = (EntityOcelot) var1;
			return !var2.cE() ? false : cK() && var2.cK();
		}
	}

	public int cM() {
		return ((Integer) ac.a(bx)).intValue();
	}

	public void k(int var1) {
		ac.b(bx, Integer.valueOf(var1));
	}

	@Override
	public boolean cj() {
		return o.s.nextInt(3) != 0;
	}

	@Override
	public boolean ck() {
		if (o.a(aX(), this) && o.a(this, aX()).isEmpty() && !o.d(aX())) {
			class_cj var1 = new class_cj(s, aX().b, u);
			if (var1.o() < o.H()) {
				return false;
			}

			Block var2 = o.p(var1.b()).c();
			if ((var2 == Blocks.GRASS) || (var2.v() == class_avq.j)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String e_() {
		return k_() ? aS() : (cE() ? class_di.a("entity.Cat.name") : super.e_());
	}

	@Override
	public void n(boolean var1) {
		super.n(var1);
	}

	@Override
	protected void cF() {
		if (by == null) {
			by = new class_sg(this, class_yu.class, 16.0F, 0.8D, 1.33D);
		}

		i.a(by);
		if (!cE()) {
			i.a(4, by);
		}

	}

	@Override
	public class_rj a(class_pt var1, class_rj var2) {
		var2 = super.a(var1, var2);
		if (o.s.nextInt(7) == 0) {
			for (int var3 = 0; var3 < 2; ++var3) {
				EntityOcelot var4 = new EntityOcelot(o);
				var4.b(s, t, u, y, 0.0F);
				var4.b(-24000);
				o.a(var4);
			}
		}

		return var2;
	}

	// $FF: synthetic method
	@Override
	public EntityAgeable a(EntityAgeable var1) {
		return this.b(var1);
	}

	static {
		bx = DataWatcher.claimId(EntityOcelot.class, class_kb.b);
	}
}
