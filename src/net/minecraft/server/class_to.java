package net.minecraft.server;


public class class_to extends class_sr {
	private final EntityInsentient a;
	private final class_ye b;
	private EntityLiving c;
	private int d;
	private double e;
	private int f;
	private int g;
	private int h;
	private float i;
	private float j;

	public class_to(class_ye var1, double var2, int var4, float var5) {
		this(var1, var2, var4, var4, var5);
	}

	public class_to(class_ye var1, double var2, int var4, int var5, float var6) {
		d = -1;
		if (!(var1 instanceof EntityLiving)) {
			throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
		} else {
			b = var1;
			a = (EntityInsentient) var1;
			e = var2;
			g = var4;
			h = var5;
			i = var6;
			j = var6 * var6;
			this.a(3);
		}
	}

	@Override
	public boolean a() {
		EntityLiving var1 = a.w();
		if (var1 == null) {
			return false;
		} else {
			c = var1;
			return true;
		}
	}

	@Override
	public boolean b() {
		return this.a() || !a.u().m();
	}

	@Override
	public void d() {
		c = null;
		f = 0;
		d = -1;
	}

	@Override
	public void e() {
		double var1 = a.e(c.s, c.aX().b, c.u);
		boolean var3 = a.v().a(c);
		if (var3) {
			++f;
		} else {
			f = 0;
		}

		if ((var1 <= j) && (f >= 20)) {
			a.u().n();
		} else {
			a.u().a(c, e);
		}

		a.q().a(c, 30.0F, 30.0F);
		float var4;
		if (--d == 0) {
			if ((var1 > j) || !var3) {
				return;
			}

			var4 = MathHelper.a(var1) / i;
			float var5 = MathHelper.a(var4, 0.1F, 1.0F);
			b.a(c, var5);
			d = MathHelper.d((var4 * (h - g)) + g);
		} else if (d < 0) {
			var4 = MathHelper.a(var1) / i;
			d = MathHelper.d((var4 * (h - g)) + g);
		}

	}
}
