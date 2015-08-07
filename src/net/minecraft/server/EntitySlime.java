package net.minecraft.server;

public class EntitySlime extends EntityInsentient implements class_wd {

	private static final int SIZE_DW_ID = Datawathcer.claimId(EntitySlime.class);  //value = 11

	public float a;
	public float b;
	public float c;
	private boolean br;

	public EntitySlime(World var1) {
		super(var1);
		this.f = new EntitySlime.class_d_in_class_wo(this);
		this.i.a(1, new EntitySlime.class_b_in_class_wo(this));
		this.i.a(2, new EntitySlime.class_a_in_class_wo(this));
		this.i.a(3, new EntitySlime.class_e_in_class_wo(this));
		this.i.a(5, new EntitySlime.class_c_in_class_wo(this));
		this.bn.a(1, new class_sy(this));
		this.bn.a(3, new class_sx(this, EntityVillagerGolem.class));
	}

	protected void initDatawatcher() {
		super.initDatawatcher();
		this.datawatcher.add(SIZE_DW_ID, Byte.valueOf((byte) 1));
	}

	protected void a(int var1) {
		this.datawatcher.update(SIZE_DW_ID, Byte.valueOf((byte) var1));
		this.a(0.51000005F * (float) var1, 0.51000005F * (float) var1);
		this.b(this.s, this.t, this.u);
		this.a(class_wl.a).a((double) (var1 * var1));
		this.a(class_wl.d).a((double) (0.2F + 0.1F * (float) var1));
		this.i(this.bv());
		this.b_ = var1;
	}

	public int cB() {
		return this.datawatcher.getByte(SIZE_DW_ID);
	}

	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("Size", this.cB() - 1);
		var1.put("wasOnGround", this.br);
	}

	public void read(NBTTagCompound var1) {
		super.read(var1);
		int var2 = var1.getInt("Size");
		if (var2 < 0) {
			var2 = 0;
		}

		this.a(var2 + 1);
		this.br = var1.getBoolean("wasOnGround");
	}

	protected class_cy n() {
		return class_cy.H;
	}

	protected String cz() {
		return "mob.slime." + (this.cB() > 1 ? "big" : "small");
	}

	public void t_() {
		if (!this.o.isClientSide && this.o.ab() == class_om.a && this.cB() > 0) {
			this.I = true;
		}

		this.b += (this.a - this.b) * 0.5F;
		this.c = this.b;
		super.t_();
		if (this.C && !this.br) {
			int var1 = this.cB();

			for (int var2 = 0; var2 < var1 * 8; ++var2) {
				float var3 = this.random.nextFloat() * 3.1415927F * 2.0F;
				float var4 = this.random.nextFloat() * 0.5F + 0.5F;
				float var5 = MathHelper.sin(var3) * (float) var1 * 0.5F * var4;
				float var6 = MathHelper.cos(var3) * (float) var1 * 0.5F * var4;
				World var10000 = this.o;
				class_cy var10001 = this.n();
				double var10002 = this.s + (double) var5;
				double var10004 = this.u + (double) var6;
				var10000.a(var10001, var10002, this.aT().yMin, var10004, 0.0D, 0.0D, 0.0D, new int[0]);
			}

			if (this.cA()) {
				this.a(this.cz(), this.bC(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) / 0.8F);
			}

			this.a = -0.5F;
		} else if (!this.C && this.br) {
			this.a = 1.0F;
		}

		this.br = this.C;
		this.cw();
	}

	protected void cw() {
		this.a *= 0.6F;
	}

	protected int cv() {
		return this.random.nextInt(20) + 10;
	}

	protected EntitySlime cu() {
		return new EntitySlime(this.o);
	}

	public void d(int var1) {
		if (var1 == SIZE_DW_ID) {
			int var2 = this.cB();
			this.a(0.51000005F * (float) var2, 0.51000005F * (float) var2);
			this.y = this.aN;
			this.aL = this.aN;
			if (this.V() && this.random.nextInt(20) == 0) {
				this.X();
			}
		}

		super.d(var1);
	}

	public void J() {
		int var1 = this.cB();
		if (!this.o.isClientSide && var1 > 1 && this.getHealth() <= 0.0F) {
			int var2 = 2 + this.random.nextInt(3);

			for (int var3 = 0; var3 < var2; ++var3) {
				float var4 = ((float) (var3 % 2) - 0.5F) * (float) var1 / 4.0F;
				float var5 = ((float) (var3 / 2) - 0.5F) * (float) var1 / 4.0F;
				EntitySlime var6 = this.cu();
				if (this.hasCustomName()) {
					var6.a(this.aO());
				}

				if (this.cn()) {
					var6.cl();
				}

				var6.a(var1 / 2);
				var6.b(this.s + (double) var4, this.t + 0.5D, this.u + (double) var5, this.random.nextFloat() * 360.0F, 0.0F);
				this.o.addEntity((Entity) var6);
			}
		}

		super.J();
	}

	public void i(Entity var1) {
		super.i(var1);
		if (var1 instanceof EntityVillagerGolem && this.cx()) {
			this.e((EntityLiving) var1);
		}

	}

	public void d(EntityHuman var1) {
		if (this.cx()) {
			this.e(var1);
		}

	}

	protected void e(EntityLiving var1) {
		int var2 = this.cB();
		if (this.t(var1) && this.h(var1) < 0.6D * (double) var2 * 0.6D * (double) var2 && var1.damageEntity(DamageSource.a((EntityLiving) this), (float) this.cy())) {
			this.a("mob.attack", 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			this.a(this, var1);
		}

	}

	public float aU() {
		return 0.625F * this.K;
	}

	protected boolean cx() {
		return this.cB() > 1;
	}

	protected int cy() {
		return this.cB();
	}

	protected String bp() {
		return "mob.slime." + (this.cB() > 1 ? "big" : "small");
	}

	protected String bq() {
		return "mob.slime." + (this.cB() > 1 ? "big" : "small");
	}

	protected Item D() {
		return this.cB() == 1 ? Items.SLIME_BALL : null;
	}

	public boolean cf() {
		BlockPosition var1 = new BlockPosition(MathHelper.floor(this.s), 0, MathHelper.floor(this.u));
		Chunk var2 = this.o.f(var1);
		if (this.o.Q().u() == class_aes.c && this.random.nextInt(4) != 1) {
			return false;
		} else {
			if (this.o.ab() != class_om.a) {
				BiomeBase var3 = this.o.b(var1);
				if (var3 == BiomeBase.v && this.t > 50.0D && this.t < 70.0D && this.random.nextFloat() < 0.5F && this.random.nextFloat() < this.o.z() && this.o.l(new BlockPosition(this)) <= this.random.nextInt(8)) {
					return super.cf();
				}

				if (this.random.nextInt(10) == 0 && var2.a(987234911L).nextInt(10) == 0 && this.t < 40.0D) {
					return super.cf();
				}
			}

			return false;
		}
	}

	protected float bC() {
		return 0.4F * (float) this.cB();
	}

	public int cd() {
		return 0;
	}

	protected boolean cC() {
		return this.cB() > 0;
	}

	protected boolean cA() {
		return this.cB() > 2;
	}

	protected void bG() {
		this.motY = 0.41999998688697815D;
		this.ai = true;
	}

	public class_qd a(class_on var1, class_qd var2) {
		int var3 = this.random.nextInt(3);
		if (var3 < 2 && this.random.nextFloat() < 0.5F * var1.c()) {
			++var3;
		}

		int var4 = 1 << var3;
		this.a(var4);
		return super.a(var1, var2);
	}

	static class class_c_in_class_wo extends class_rm {
		private EntitySlime a;

		public class_c_in_class_wo(EntitySlime var1) {
			this.a = var1;
			this.a(5);
		}

		public boolean a() {
			return true;
		}

		public void e() {
			((EntitySlime.class_d_in_class_wo) this.a.r()).a(1.0D);
		}
	}

	static class class_b_in_class_wo extends class_rm {
		private EntitySlime a;

		public class_b_in_class_wo(EntitySlime var1) {
			this.a = var1;
			this.a(5);
			((class_tf) var1.u()).d(true);
		}

		public boolean a() {
			return this.a.V() || this.a.ab();
		}

		public void e() {
			if (this.a.bd().nextFloat() < 0.8F) {
				this.a.t().a();
			}

			((EntitySlime.class_d_in_class_wo) this.a.r()).a(1.2D);
		}
	}

	static class class_e_in_class_wo extends class_rm {
		private EntitySlime a;
		private float b;
		private int c;

		public class_e_in_class_wo(EntitySlime var1) {
			this.a = var1;
			this.a(2);
		}

		public boolean a() {
			return this.a.w() == null && (this.a.C || this.a.V() || this.a.ab());
		}

		public void e() {
			if (--this.c <= 0) {
				this.c = 40 + this.a.bd().nextInt(60);
				this.b = (float) this.a.bd().nextInt(360);
			}

			((EntitySlime.class_d_in_class_wo) this.a.r()).a(this.b, false);
		}
	}

	static class class_a_in_class_wo extends class_rm {
		private EntitySlime a;
		private int b;

		public class_a_in_class_wo(EntitySlime var1) {
			this.a = var1;
			this.a(2);
		}

		public boolean a() {
			EntityLiving var1 = this.a.w();
			return var1 == null ? false : (!var1.isAlive() ? false : !(var1 instanceof EntityHuman) || !((EntityHuman) var1).abilities.invulnerable);
		}

		public void c() {
			this.b = 300;
			super.c();
		}

		public boolean b() {
			EntityLiving var1 = this.a.w();
			return var1 == null ? false : (!var1.isAlive() ? false : (var1 instanceof EntityHuman && ((EntityHuman) var1).abilities.invulnerable ? false : --this.b > 0));
		}

		public void e() {
			this.a.a(this.a.w(), 10.0F, 10.0F);
			((EntitySlime.class_d_in_class_wo) this.a.r()).a(this.a.y, this.a.cx());
		}
	}

	static class class_d_in_class_wo extends class_qz {
		private float g;
		private int h;
		private EntitySlime i;
		private boolean j;

		public class_d_in_class_wo(EntitySlime var1) {
			super(var1);
			this.i = var1;
		}

		public void a(float var1, boolean var2) {
			this.g = var1;
			this.j = var2;
		}

		public void a(double var1) {
			this.e = var1;
			this.f = true;
		}

		public void c() {
			this.a.y = this.a(this.a.y, this.g, 30.0F);
			this.a.aN = this.a.y;
			this.a.aL = this.a.y;
			if (!this.f) {
				this.a.n(0.0F);
			} else {
				this.f = false;
				if (this.a.C) {
					this.a.k((float) (this.e * this.a.a((class_qk) class_wl.d).e()));
					if (this.h-- <= 0) {
						this.h = this.i.cv();
						if (this.j) {
							this.h /= 3;
						}

						this.i.t().a();
						if (this.i.cC()) {
							this.i.a(this.i.cz(), this.i.bC(), ((this.i.bd().nextFloat() - this.i.bd().nextFloat()) * 0.2F + 1.0F) * 0.8F);
						}
					} else {
						this.i.bc = this.i.bd = 0.0F;
						this.a.k(0.0F);
					}
				} else {
					this.a.k((float) (this.e * this.a.a((class_qk) class_wl.d).e()));
				}

			}
		}
	}
}
