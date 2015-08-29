package net.minecraft.server;


public class EntitySquid extends class_vq {
	public float a;
	public float b;
	public float c;
	public float br;
	public float bs;
	public float bt;
	public float bu;
	public float bv;
	private float bw;
	private float bx;
	private float by;
	private float bz;
	private float bA;
	private float bB;

	public EntitySquid(class_ago var1) {
		super(var1);
		this.a(0.95F, 0.95F);
		V.setSeed(1 + G());
		bx = (1.0F / (V.nextFloat() + 1.0F)) * 0.2F;
		i.a(0, new EntitySquid.class_a_in_class_vo(this));
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(10.0D);
	}

	@Override
	public float aY() {
		return K * 0.5F;
	}

	@Override
	protected String B() {
		return null;
	}

	@Override
	protected String bv() {
		return null;
	}

	@Override
	protected String bw() {
		return null;
	}

	@Override
	protected float bI() {
		return 0.4F;
	}

	@Override
	protected Item D() {
		return null;
	}

	@Override
	protected boolean U() {
		return false;
	}

	@Override
	protected void b(boolean var1, int var2) {
		int var3 = V.nextInt(3 + var2) + 1;

		for (int var4 = 0; var4 < var3; ++var4) {
			this.a(new class_aco(Items.aY, 1, class_abt.p.b()), 0.0F);
		}

	}

	@Override
	public boolean Y() {
		return o.a(aX().b(0.0D, -0.6000000238418579D, 0.0D), class_avq.h, this);
	}

	@Override
	public void m() {
		super.m();
		b = a;
		br = c;
		bt = bs;
		bv = bu;
		bs += bx;
		if (bs > 6.283185307179586D) {
			if (o.D) {
				bs = 6.2831855F;
			} else {
				bs = (float) (bs - 6.283185307179586D);
				if (V.nextInt(10) == 0) {
					bx = (1.0F / (V.nextFloat() + 1.0F)) * 0.2F;
				}

				o.a(this, (byte) 19);
			}
		}

		if (Y) {
			float var1;
			if (bs < 3.1415927F) {
				var1 = bs / 3.1415927F;
				bu = MathHelper.a(var1 * var1 * 3.1415927F) * 3.1415927F * 0.25F;
				if (var1 > 0.75D) {
					bw = 1.0F;
					by = 1.0F;
				} else {
					by *= 0.8F;
				}
			} else {
				bu = 0.0F;
				bw *= 0.9F;
				by *= 0.99F;
			}

			if (!o.D) {
				v = bz * bw;
				w = bA * bw;
				x = bB * bw;
			}

			var1 = MathHelper.a((v * v) + (x * x));
			aM += (((-((float) MathHelper.b(v, x)) * 180.0F) / 3.1415927F) - aM) * 0.1F;
			y = aM;
			c = (float) (c + (3.141592653589793D * by * 1.5D));
			a += (((-((float) MathHelper.b(var1, w)) * 180.0F) / 3.1415927F) - a) * 0.1F;
		} else {
			bu = MathHelper.e(MathHelper.a(bs)) * 3.1415927F * 0.25F;
			if (!o.D) {
				v = 0.0D;
				w -= 0.08D;
				w *= 0.9800000190734863D;
				x = 0.0D;
			}

			a = (float) (a + ((-90.0F - a) * 0.02D));
		}

	}

	@Override
	public void g(float var1, float var2) {
		this.d(v, w, x);
	}

	@Override
	public boolean cj() {
		return (t > 45.0D) && (t < o.H()) && super.cj();
	}

	public void b(float var1, float var2, float var3) {
		bz = var1;
		bA = var2;
		bB = var3;
	}

	public boolean n() {
		return (bz != 0.0F) || (bA != 0.0F) || (bB != 0.0F);
	}

	static class class_a_in_class_vo extends class_sr {
		private EntitySquid a;

		public class_a_in_class_vo(EntitySquid var1) {
			a = var1;
		}

		@Override
		public boolean a() {
			return true;
		}

		@Override
		public void e() {
			int var1 = a.bo();
			if (var1 > 100) {
				a.b(0.0F, 0.0F, 0.0F);
			} else if ((a.bj().nextInt(50) == 0) || !a.Y || !a.n()) {
				float var2 = a.bj().nextFloat() * 3.1415927F * 2.0F;
				float var3 = MathHelper.b(var2) * 0.2F;
				float var4 = -0.1F + (a.bj().nextFloat() * 0.2F);
				float var5 = MathHelper.a(var2) * 0.2F;
				a.b(var3, var4, var5);
			}

		}
	}
}
