package net.minecraft.server;


public class EntityTNTPrimed extends Entity {
	private static final class_jz a;
	private EntityLiving b;
	private int c;

	public EntityTNTPrimed(class_ago var1) {
		super(var1);
		c = 80;
		k = true;
		this.a(0.98F, 0.98F);
	}

	public EntityTNTPrimed(class_ago var1, double var2, double var4, double var6, EntityLiving var8) {
		this(var1);
		this.b(var2, var4, var6);
		float var9 = (float) (Math.random() * 3.1415927410125732D * 2.0D);
		v = -((float) Math.sin(var9)) * 0.02F;
		w = 0.20000000298023224D;
		x = -((float) Math.cos(var9)) * 0.02F;
		this.a(80);
		p = var2;
		q = var4;
		r = var6;
		b = var8;
	}

	@Override
	protected void h() {
		ac.a(a, Integer.valueOf(80));
	}

	@Override
	protected boolean U() {
		return false;
	}

	@Override
	public boolean ag() {
		return !I;
	}

	@Override
	public void r_() {
		p = s;
		q = t;
		r = u;
		w -= 0.03999999910593033D;
		this.d(v, w, x);
		v *= 0.9800000190734863D;
		w *= 0.9800000190734863D;
		x *= 0.9800000190734863D;
		if (C) {
			v *= 0.699999988079071D;
			x *= 0.699999988079071D;
			w *= -0.5D;
		}

		--c;
		if (c <= 0) {
			L();
			if (!o.D) {
				this.m();
			}
		} else {
			Z();
			o.a(class_cy.l, s, t + 0.5D, u, 0.0D, 0.0D, 0.0D, new int[0]);
		}

	}

	private void m() {
		float var1 = 4.0F;
		o.a(this, s, t + K / 16.0F, u, var1, true);
	}

	@Override
	protected void b(class_dn var1) {
		var1.a("Fuse", (short) this.k());
	}

	@Override
	protected void a(class_dn var1) {
		this.a(var1.g("Fuse"));
	}

	public EntityLiving i() {
		return b;
	}

	@Override
	public float aY() {
		return 0.0F;
	}

	public void a(int var1) {
		ac.b(a, Integer.valueOf(var1));
		c = var1;
	}

	@Override
	public void a(class_jz var1) {
		if (var1 == a) {
			c = this.j();
		}

	}

	public int j() {
		return ((Integer) ac.a(a)).intValue();
	}

	public int k() {
		return c;
	}

	static {
		a = DataWatcher.claimId(EntityTNTPrimed.class, class_kb.b);
	}
}
