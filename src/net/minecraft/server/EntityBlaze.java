package net.minecraft.server;


public class EntityBlaze extends EntityMonster {
	private float a = 0.5F;
	private int b;
	private static final class_jz c;

	public EntityBlaze(class_ago var1) {
		super(var1);
		ab = true;
		b_ = 10;
		i.a(4, new EntityBlaze.class_a_in_class_xs(this));
		i.a(5, new class_td(this, 1.0D));
		i.a(7, new class_tn(this, 1.0D));
		i.a(8, new class_sw(this, class_yu.class, 8.0F));
		i.a(8, new class_tm(this));
		bo.a(1, new class_uc(this, true, new Class[0]));
		bo.a(2, new class_uf(this, class_yu.class, true));
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.e).a(6.0D);
		this.a(class_yf.d).a(0.23000000417232513D);
		this.a(class_yf.b).a(48.0D);
	}

	@Override
	protected void h() {
		super.h();
		ac.a(c, Byte.valueOf((byte) 0));
	}

	@Override
	protected String B() {
		return "mob.blaze.breathe";
	}

	@Override
	protected String bv() {
		return "mob.blaze.hit";
	}

	@Override
	protected String bw() {
		return "mob.blaze.death";
	}

	@Override
	public float f(float var1) {
		return 1.0F;
	}

	@Override
	public void m() {
		if (!C && (w < 0.0D)) {
			w *= 0.6D;
		}

		if (o.D) {
			if ((V.nextInt(24) == 0) && !T()) {
				o.a(s + 0.5D, t + 0.5D, u + 0.5D, "fire.fire", 1.0F + V.nextFloat(), (V.nextFloat() * 0.7F) + 0.3F, false);
			}

			for (int var1 = 0; var1 < 2; ++var1) {
				o.a(class_cy.m, s + ((V.nextDouble() - 0.5D) * J), t + (V.nextDouble() * K), u + ((V.nextDouble() - 0.5D) * J), 0.0D, 0.0D, 0.0D, new int[0]);
			}
		}

		super.m();
	}

	@Override
	protected void cg() {
		if (X()) {
			this.a(class_qi.f, 1.0F);
		}

		--b;
		if (b <= 0) {
			b = 100;
			a = 0.5F + ((float) V.nextGaussian() * 3.0F);
		}

		EntityLiving var1 = w();
		if ((var1 != null) && ((var1.t + var1.aY()) > (t + aY() + a))) {
			w += (0.30000001192092896D - w) * 0.30000001192092896D;
			ai = true;
		}

		super.cg();
	}

	@Override
	public void e(float var1, float var2) {
	}

	@Override
	protected Item D() {
		return Items.bx;
	}

	@Override
	public boolean ay() {
		return this.n();
	}

	@Override
	protected void b(boolean var1, int var2) {
		if (var1) {
			int var3 = V.nextInt(2 + var2);

			for (int var4 = 0; var4 < var3; ++var4) {
				this.a(Items.bx, 1);
			}
		}

	}

	public boolean n() {
		return (((Byte) ac.a(c)).byteValue() & 1) != 0;
	}

	public void a(boolean var1) {
		byte var2 = ((Byte) ac.a(c)).byteValue();
		if (var1) {
			var2 = (byte) (var2 | 1);
		} else {
			var2 &= -2;
		}

		ac.b(c, Byte.valueOf(var2));
	}

	@Override
	protected boolean m_() {
		return true;
	}

	static {
		c = DataWatcher.claimId(EntityBlaze.class, class_kb.a);
	}

	static class class_a_in_class_xs extends class_sr {
		private EntityBlaze a;
		private int b;
		private int c;

		public class_a_in_class_xs(EntityBlaze var1) {
			a = var1;
			this.a(3);
		}

		@Override
		public boolean a() {
			EntityLiving var1 = a.w();
			return (var1 != null) && var1.al();
		}

		@Override
		public void c() {
			b = 0;
		}

		@Override
		public void d() {
			a.a(false);
		}

		@Override
		public void e() {
			--c;
			EntityLiving var1 = a.w();
			double var2 = a.h(var1);
			if (var2 < 4.0D) {
				if (c <= 0) {
					c = 20;
					a.r(var1);
				}

				a.r().a(var1.s, var1.t, var1.u, 1.0D);
			} else if (var2 < 256.0D) {
				double var4 = var1.s - a.s;
				double var6 = (var1.aX().b + var1.K / 2.0F) - (a.t + a.K / 2.0F);
				double var8 = var1.u - a.u;
				if (c <= 0) {
					++b;
					if (b == 1) {
						c = 60;
						a.a(true);
					} else if (b <= 4) {
						c = 6;
					} else {
						c = 100;
						b = 0;
						a.a(false);
					}

					if (b > 1) {
						float var10 = MathHelper.c(MathHelper.a(var2)) * 0.5F;
						a.o.a((class_yu) null, 1009, new class_cj((int) a.s, (int) a.t, (int) a.u), 0);

						for (int var11 = 0; var11 < 1; ++var11) {
							EntitySmallFireball var12 = new EntitySmallFireball(a.o, a, var4 + (a.bj().nextGaussian() * var10), var6, var8 + (a.bj().nextGaussian() * var10));
							var12.t = a.t + a.K / 2.0F + 0.5D;
							a.o.a(var12);
						}
					}
				}

				a.q().a(var1, 10.0F, 10.0F);
			} else {
				a.u().n();
				a.r().a(var1.s, var1.t, var1.u, 1.0D);
			}

			super.e();
		}
	}
}
