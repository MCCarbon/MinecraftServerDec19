package net.minecraft.server;

import java.util.UUID;

public class class_yd extends class_yl {
	private static final UUID b = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final class_rr c;
	private int bt;
	private int bu;
	private UUID bv;

	public class_yd(class_ago var1) {
		super(var1);
		ab = true;
	}

	@Override
	public void a(class_rg var1) {
		super.a(var1);
		if (var1 != null) {
			bv = var1.aQ();
		}

	}

	@Override
	protected void n() {
		bo.a(1, new class_yd.class_b_in_class_yd(this));
		bo.a(2, new class_yd.class_a_in_class_yd(this));
	}

	@Override
	protected void be() {
		super.be();
		this.a(a).a(0.0D);
		this.a(class_yf.d).a(0.23000000417232513D);
		this.a(class_yf.e).a(5.0D);
	}

	@Override
	public void r_() {
		super.r_();
	}

	@Override
	protected void cg() {
		class_rq var1 = this.a(class_yf.d);
		if (cF()) {
			if (!i_() && !var1.a(c)) {
				var1.b(c);
			}

			--bt;
		} else if (var1.a(c)) {
			var1.c(c);
		}

		if ((bu > 0) && (--bu == 0)) {
			this.a("mob.zombiepig.zpigangry", bI() * 2.0F, (((V.nextFloat() - V.nextFloat()) * 0.2F) + 1.0F) * 1.8F);
		}

		if ((bt > 0) && (bv != null) && (bk() == null)) {
			class_yu var2 = o.b(bv);
			this.a(var2);
			aR = var2;
			aS = bl();
		}

		super.cg();
	}

	@Override
	public boolean cj() {
		return o.ac() != class_ps.a;
	}

	@Override
	public boolean ck() {
		return o.a(aX(), this) && o.a(this, aX()).isEmpty() && !o.d(aX());
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("Anger", (short) bt);
		if (bv != null) {
			var1.a("HurtBy", bv.toString());
		} else {
			var1.a("HurtBy", "");
		}

	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		bt = var1.g("Anger");
		String var2 = var1.l("HurtBy");
		if (!var2.isEmpty()) {
			bv = UUID.fromString(var2);
			class_yu var3 = o.b(bv);
			this.a(var3);
			if (var3 != null) {
				aR = var3;
				aS = bl();
			}
		}

	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			Entity var3 = var1.j();
			if (var3 instanceof class_yu) {
				this.b(var3);
			}

			return super.a(var1, var2);
		}
	}

	private void b(Entity var1) {
		bt = 400 + V.nextInt(400);
		bu = V.nextInt(40);
		if (var1 instanceof class_rg) {
			this.a((class_rg) var1);
		}

	}

	public boolean cF() {
		return bt > 0;
	}

	@Override
	protected String B() {
		return "mob.zombiepig.zpig";
	}

	@Override
	protected String bv() {
		return "mob.zombiepig.zpighurt";
	}

	@Override
	protected String bw() {
		return "mob.zombiepig.zpigdeath";
	}

	@Override
	protected void b(boolean var1, int var2) {
		int var3 = V.nextInt(2 + var2);

		int var4;
		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Items.bv, 1);
		}

		var3 = V.nextInt(2 + var2);

		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Items.bz, 1);
		}

	}

	@Override
	public boolean a(class_yu var1, class_pu var2, class_aco var3) {
		return false;
	}

	@Override
	protected void bx() {
		this.a(Items.m, 1);
	}

	@Override
	protected void a(class_pt var1) {
		this.a(class_rc.a, (new class_aco(Items.D)));
	}

	@Override
	public class_rj a(class_pt var1, class_rj var2) {
		super.a(var1, var2);
		this.o(false);
		return var2;
	}

	static {
		c = (new class_rr(b, "Attacking speed boost", 0.05D, 0)).a(false);
	}

	static class class_a_in_class_yd extends class_uf {
		public class_a_in_class_yd(class_yd var1) {
			super(var1, class_yu.class, true);
		}

		@Override
		public boolean a() {
			return ((class_yd) e).cF() && super.a();
		}
	}

	static class class_b_in_class_yd extends class_uc {
		public class_b_in_class_yd(class_yd var1) {
			super(var1, true, new Class[0]);
		}

		@Override
		protected void a(class_rn var1, class_rg var2) {
			super.a(var1, var2);
			if (var1 instanceof class_yd) {
				((class_yd) var1).b((Entity) var2);
			}

		}
	}
}
