package net.minecraft.server;


public class EntityEndermite extends EntityMonster {
	private int a = 0;
	private boolean b = false;

	public EntityEndermite(class_ago var1) {
		super(var1);
		b_ = 3;
		this.a(0.4F, 0.3F);
		i.a(1, new class_so(this));
		i.a(2, new class_sz(this, class_yu.class, 1.0D, false));
		i.a(3, new class_tn(this, 1.0D));
		i.a(7, new class_sw(this, class_yu.class, 8.0F));
		i.a(8, new class_tm(this));
		bo.a(1, new class_uc(this, true, new Class[0]));
		bo.a(2, new class_uf(this, class_yu.class, true));
	}

	@Override
	public float aY() {
		return 0.1F;
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(8.0D);
		this.a(class_yf.d).a(0.25D);
		this.a(class_yf.e).a(2.0D);
	}

	@Override
	protected boolean U() {
		return false;
	}

	@Override
	protected String B() {
		return "mob.silverfish.say";
	}

	@Override
	protected String bv() {
		return "mob.silverfish.hit";
	}

	@Override
	protected String bw() {
		return "mob.silverfish.kill";
	}

	@Override
	protected void a(class_cj var1, Block var2) {
		this.a("mob.silverfish.step", 0.15F, 1.0F);
	}

	@Override
	protected Item D() {
		return null;
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		a = var1.h("Lifetime");
		b = var1.p("PlayerSpawned");
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("Lifetime", a);
		var1.a("PlayerSpawned", b);
	}

	@Override
	public void r_() {
		aM = y;
		super.r_();
	}

	public boolean n() {
		return b;
	}

	public void a(boolean var1) {
		b = var1;
	}

	@Override
	public void m() {
		super.m();
		if (o.D) {
			for (int var1 = 0; var1 < 2; ++var1) {
				o.a(class_cy.y, s + ((V.nextDouble() - 0.5D) * J), t + (V.nextDouble() * K), u + ((V.nextDouble() - 0.5D) * J), (V.nextDouble() - 0.5D) * 2.0D, -V.nextDouble(), (V.nextDouble() - 0.5D) * 2.0D, new int[0]);
			}
		} else {
			if (!cr()) {
				++a;
			}

			if (a >= 2400) {
				L();
			}
		}

	}

	@Override
	protected boolean m_() {
		return true;
	}

	@Override
	public boolean cj() {
		if (super.cj()) {
			class_yu var1 = o.a(this, 5.0D);
			return var1 == null;
		} else {
			return false;
		}
	}

	@Override
	public class_rl bF() {
		return class_rl.c;
	}
}
