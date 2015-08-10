package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Iterator;
import java.util.List;

public class EntityWither extends EntityMonster implements class_wk {

	private static final int TARGET1_DW_ID = DataWathcer.claimId(EntityWither.class); //value = 11
	private static final int TARGET2_DW_ID = DataWathcer.claimId(EntityWither.class); //value = 12
	private static final int TARGET3_DW_ID = DataWathcer.claimId(EntityWither.class); //value = 13
	private static final int INVULNERABLETIME_DW_ID = DataWathcer.claimId(EntityWither.class); //value = 14

	private float[] bt = new float[2];
	private float[] bu = new float[2];
	private float[] bv = new float[2];
	private float[] bw = new float[2];
	private int[] bx = new int[2];
	private int[] by = new int[2];
	private int bz;
	private final class_le bA;
	private static final Predicate bB = new Predicate() {
		public boolean a(Entity var1) {
			return var1 instanceof EntityLiving && ((EntityLiving) var1).bz() != class_qf.b;
		}

		// $FF: synthetic method
		public boolean apply(Object var1) {
			return this.a((Entity) var1);
		}
	};

	public EntityWither(World var1) {
		super(var1);
		this.bA = new class_le(this.getScoreboardDisplayName(), class_oh.class_a_in_class_oh.f, class_oh.class_b_in_class_oh.a, true, false);
		this.i(this.getMaxHealth());
		this.setSize(0.9F, 3.5F);
		this.fireProof = true;
		((class_tf) this.u()).d(true);
		this.i.a(0, new class_rj(this));
		this.i.a(2, new class_sj(this, 1.0D, 40, 20.0F));
		this.i.a(5, new class_si(this, 1.0D));
		this.i.a(6, new class_rr(this, EntityHuman.class, 8.0F));
		this.i.a(7, new class_sh(this));
		this.bn.a(1, new class_sw(this, false, new Class[0]));
		this.bn.a(2, new class_sz(this, EntityInsentient.class, 0, false, false, bB));
		this.b_ = 50;
	}

	protected void initDatawatcher() {
		super.initDatawatcher();
		this.datawatcher.add(TARGET1_DW_ID, new Integer(0));
		this.datawatcher.add(TARGET2_DW_ID, new Integer(0));
		this.datawatcher.add(TARGET3_DW_ID, new Integer(0));
		this.datawatcher.add(INVULNERABLETIME_DW_ID, new Integer(0));
	}

	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("Invul", this.cA());
	}

	public void read(NBTTagCompound var1) {
		super.read(var1);
		this.m(var1.getInt("Invul"));
	}

	protected String C() {
		return "mob.wither.idle";
	}

	protected String bp() {
		return "mob.wither.hurt";
	}

	protected String bq() {
		return "mob.wither.death";
	}

	public void m() {
		this.motY *= 0.6000000238418579D;
		double var4;
		double var6;
		double var8;
		if (!this.world.isClientSide && this.n(0) > 0) {
			Entity var1 = this.world.getEntityById(this.n(0));
			if (var1 != null) {
				if (this.locY < var1.locY || !this.cB() && this.locY < var1.locY + 5.0D) {
					if (this.motY < 0.0D) {
						this.motY = 0.0D;
					}

					this.motY += (0.5D - this.motY) * 0.6000000238418579D;
				}

				double var2 = var1.locX - this.locX;
				var4 = var1.locZ - this.locZ;
				var6 = var2 * var2 + var4 * var4;
				if (var6 > 9.0D) {
					var8 = (double) MathHelper.sqrt(var6);
					this.motX += (var2 / var8 * 0.5D - this.motX) * 0.6000000238418579D;
					this.motZ += (var4 / var8 * 0.5D - this.motZ) * 0.6000000238418579D;
				}
			}
		}

		if (this.motX * this.motX + this.motZ * this.motZ > 0.05000000074505806D) {
			this.yaw = (float) MathHelper.b(this.motZ, this.motX) * 57.295776F - 90.0F;
		}

		super.m();

		int var20;
		for (var20 = 0; var20 < 2; ++var20) {
			this.bw[var20] = this.bu[var20];
			this.bv[var20] = this.bt[var20];
		}

		int var21;
		for (var20 = 0; var20 < 2; ++var20) {
			var21 = this.n(var20 + 1);
			Entity var3 = null;
			if (var21 > 0) {
				var3 = this.world.getEntityById(var21);
			}

			if (var3 != null) {
				var4 = this.o(var20 + 1);
				var6 = this.p(var20 + 1);
				var8 = this.q(var20 + 1);
				double var10 = var3.locX - var4;
				double var12 = var3.locY + (double) var3.getHeadHeight() - var6;
				double var14 = var3.locZ - var8;
				double var16 = (double) MathHelper.sqrt(var10 * var10 + var14 * var14);
				float var18 = (float) (MathHelper.b(var14, var10) * 180.0D / 3.1415927410125732D) - 90.0F;
				float var19 = (float) (-(MathHelper.b(var12, var16) * 180.0D / 3.1415927410125732D));
				this.bt[var20] = this.b(this.bt[var20], var19, 40.0F);
				this.bu[var20] = this.b(this.bu[var20], var18, 10.0F);
			} else {
				this.bu[var20] = this.b(this.bu[var20], this.aL, 10.0F);
			}
		}

		boolean var22 = this.cB();

		for (var21 = 0; var21 < 3; ++var21) {
			double var23 = this.o(var21);
			double var5 = this.p(var21);
			double var7 = this.q(var21);
			this.world.addParticle(EnumParticle.l, var23 + this.random.nextGaussian() * 0.30000001192092896D, var5 + this.random.nextGaussian() * 0.30000001192092896D, var7 + this.random.nextGaussian() * 0.30000001192092896D, 0.0D, 0.0D, 0.0D, new int[0]);
			if (var22 && this.world.random.nextInt(4) == 0) {
				this.world.addParticle(EnumParticle.p, var23 + this.random.nextGaussian() * 0.30000001192092896D, var5 + this.random.nextGaussian() * 0.30000001192092896D, var7 + this.random.nextGaussian() * 0.30000001192092896D, 0.699999988079071D, 0.699999988079071D, 0.5D, new int[0]);
			}
		}

		if (this.cA() > 0) {
			for (var21 = 0; var21 < 3; ++var21) {
				this.world.addParticle(EnumParticle.p, this.locX + this.random.nextGaussian() * 1.0D, this.locY + (double) (this.random.nextFloat() * 3.3F), this.locZ + this.random.nextGaussian() * 1.0D, 0.699999988079071D, 0.699999988079071D, 0.8999999761581421D, new int[0]);
			}
		}

	}

	protected void cc() {
		int var1;
		if (this.cA() > 0) {
			var1 = this.cA() - 1;
			if (var1 <= 0) {
				this.world.createExplosion(this, this.locX, this.locY + (double) this.getHeadHeight(), this.locZ, 7.0F, false, this.world.R().getBooleanValue("mobGriefing"));
				this.world.a(1013, new BlockPosition(this), 0);
			}

			this.m(var1);
			if (this.ticksLived % 10 == 0) {
				this.heal(10.0F);
			}

		} else {
			super.cc();

			int var13;
			for (var1 = 1; var1 < 3; ++var1) {
				if (this.ticksLived >= this.bx[var1 - 1]) {
					this.bx[var1 - 1] = this.ticksLived + 10 + this.random.nextInt(10);
					if (this.world.ab() == class_om.c || this.world.ab() == class_om.d) {
						int var10001 = var1 - 1;
						int var10003 = this.by[var1 - 1];
						this.by[var10001] = this.by[var1 - 1] + 1;
						if (var10003 > 15) {
							float var2 = 10.0F;
							float var3 = 5.0F;
							double var4 = MathHelper.getRandomDoubleInRange(this.random, this.locX - (double) var2, this.locX + (double) var2);
							double var6 = MathHelper.getRandomDoubleInRange(this.random, this.locY - (double) var3, this.locY + (double) var3);
							double var8 = MathHelper.getRandomDoubleInRange(this.random, this.locZ - (double) var2, this.locZ + (double) var2);
							this.a(var1 + 1, var4, var6, var8, true);
							this.by[var1 - 1] = 0;
						}
					}

					var13 = this.n(var1);
					if (var13 > 0) {
						Entity var15 = this.world.getEntityById(var13);
						if (var15 != null && var15.isAlive() && this.h(var15) <= 900.0D && this.t(var15)) {
							if (var15 instanceof EntityHuman && ((EntityHuman) var15).abilities.invulnerable) {
								this.a(var1, 0);
							} else {
								this.a(var1 + 1, (EntityLiving) var15);
								this.bx[var1 - 1] = this.ticksLived + 40 + this.random.nextInt(20);
								this.by[var1 - 1] = 0;
							}
						} else {
							this.a(var1, 0);
						}
					} else {
						List var14 = this.world.a(EntityLiving.class, this.getBoundingBox().grow(20.0D, 8.0D, 20.0D), Predicates.and(bB, IEntitySelector.NOT_PLAYER_SPECTATOR));

						for (int var17 = 0; var17 < 10 && !var14.isEmpty(); ++var17) {
							EntityLiving var5 = (EntityLiving) var14.get(this.random.nextInt(var14.size()));
							if (var5 != this && var5.isAlive() && this.t(var5)) {
								if (var5 instanceof EntityHuman) {
									if (!((EntityHuman) var5).abilities.invulnerable) {
										this.a(var1, var5.getId());
									}
								} else {
									this.a(var1, var5.getId());
								}
								break;
							}

							var14.remove(var5);
						}
					}
				}
			}

			if (this.w() != null) {
				this.a(0, this.w().getId());
			} else {
				this.a(0, 0);
			}

			if (this.bz > 0) {
				--this.bz;
				if (this.bz == 0 && this.world.R().getBooleanValue("mobGriefing")) {
					var1 = MathHelper.floor(this.locY);
					var13 = MathHelper.floor(this.locX);
					int var16 = MathHelper.floor(this.locZ);
					boolean var18 = false;

					for (int var19 = -1; var19 <= 1; ++var19) {
						for (int var20 = -1; var20 <= 1; ++var20) {
							for (int var7 = 0; var7 <= 3; ++var7) {
								int var21 = var13 + var19;
								int var9 = var1 + var7;
								int var10 = var16 + var20;
								BlockPosition var11 = new BlockPosition(var21, var9, var10);
								Block var12 = this.world.getType(var11).getBlock();
								if (var12.getMaterial() != Material.AIR && a(var12)) {
									var18 = this.world.setAir(var11, true) || var18;
								}
							}
						}
					}

					if (var18) {
						this.world.a((EntityHuman) null, 1012, new BlockPosition(this), 0);
					}
				}
			}

			if (this.ticksLived % 20 == 0) {
				this.heal(1.0F);
			}

			this.bA.a(this.getHealth() / this.getMaxHealth());
		}
	}

	public static boolean a(Block var0) {
		return var0 != Blocks.BEDROCK && var0 != Blocks.END_PORTAL && var0 != Blocks.END_PORTAL_FRAME && var0 != Blocks.COMMAND_BLOCK && var0 != Blocks.BARRIER;
	}

	public void n() {
		this.m(220);
		this.i(this.getMaxHealth() / 3.0F);
	}

	public void aC() {
	}

	public void b(EntityPlayer var1) {
		super.b(var1);
		this.bA.a(var1);
	}

	public void c(EntityPlayer var1) {
		super.c(var1);
		this.bA.b(var1);
	}

	public int bs() {
		return 4;
	}

	private double o(int var1) {
		if (var1 <= 0) {
			return this.locX;
		} else {
			float var2 = (this.aL + (float) (180 * (var1 - 1))) / 180.0F * 3.1415927F;
			float var3 = MathHelper.cos(var2);
			return this.locX + (double) var3 * 1.3D;
		}
	}

	private double p(int var1) {
		return var1 <= 0 ? this.locY + 3.0D : this.locY + 2.2D;
	}

	private double q(int var1) {
		if (var1 <= 0) {
			return this.locZ;
		} else {
			float var2 = (this.aL + (float) (180 * (var1 - 1))) / 180.0F * 3.1415927F;
			float var3 = MathHelper.sin(var2);
			return this.locZ + (double) var3 * 1.3D;
		}
	}

	private float b(float var1, float var2, float var3) {
		float var4 = MathHelper.clampAngle(var2 - var1);
		if (var4 > var3) {
			var4 = var3;
		}

		if (var4 < -var3) {
			var4 = -var3;
		}

		return var1 + var4;
	}

	private void a(int var1, EntityLiving var2) {
		this.a(var1, var2.locX, var2.locY + (double) var2.getHeadHeight() * 0.5D, var2.locZ, var1 == 0 && this.random.nextFloat() < 0.001F);
	}

	private void a(int var1, double var2, double var4, double var6, boolean var8) {
		this.world.a((EntityHuman) null, 1014, new BlockPosition(this), 0);
		double var9 = this.o(var1);
		double var11 = this.p(var1);
		double var13 = this.q(var1);
		double var15 = var2 - var9;
		double var17 = var4 - var11;
		double var19 = var6 - var13;
		EntityWitherSkull var21 = new EntityWitherSkull(this.world, this, var15, var17, var19);
		if (var8) {
			var21.a(true);
		}

		var21.locY = var11;
		var21.locX = var9;
		var21.locZ = var13;
		this.world.addEntity((Entity) var21);
	}

	public void a(EntityLiving var1, float var2) {
		this.a(0, var1);
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b((DamageSource) var1)) {
			return false;
		} else if (var1 != DamageSource.DROWN && !(var1.getEntity() instanceof EntityWither)) {
			if (this.cA() > 0 && var1 != DamageSource.OUT_OF_WORLD) {
				return false;
			} else {
				Entity var3;
				if (this.cB()) {
					var3 = var1.i();
					if (var3 instanceof EntityArrow) {
						return false;
					}
				}

				var3 = var1.getEntity();
				if (var3 != null && !(var3 instanceof EntityHuman) && var3 instanceof EntityLiving && ((EntityLiving) var3).bz() == this.bz()) {
					return false;
				} else {
					if (this.bz <= 0) {
						this.bz = 20;
					}

					for (int var4 = 0; var4 < this.by.length; ++var4) {
						this.by[var4] += 3;
					}

					return super.damageEntity(var1, var2);
				}
			}
		} else {
			return false;
		}
	}

	protected void b(boolean var1, int var2) {
		EntityItem var3 = this.a(Items.NETHER_STAR, 1);
		if (var3 != null) {
			var3.u();
		}

		if (!this.world.isClientSide) {
			Iterator var4 = this.world.getEntities(EntityHuman.class, this.getBoundingBox().grow(50.0D, 100.0D, 50.0D)).iterator();

			while (var4.hasNext()) {
				EntityHuman var5 = (EntityHuman) var4.next();
				var5.b((class_my) class_mt.J);
			}
		}

	}

	protected void cb() {
		this.aT = 0;
	}

	public void e(float var1, float var2) {
	}

	public void addEffect(MobEffect var1) {
	}

	protected void aY() {
		super.aY();
		this.a((class_qk) class_wl.a).a(300.0D);
		this.a((class_qk) class_wl.d).a(0.6000000238418579D);
		this.a((class_qk) class_wl.b).a(40.0D);
	}

	public int cA() {
		return this.datawatcher.getInt(INVULNERABLETIME_DW_ID);
	}

	public void m(int var1) {
		this.datawatcher.update(INVULNERABLETIME_DW_ID, Integer.valueOf(var1));
	}

	public int n(int var1) {
		return this.datawatcher.getInt(TARGET1_DW_ID + var1);
	}

	public void a(int var1, int var2) {
		this.datawatcher.update(TARGET1_DW_ID + var1, Integer.valueOf(var2));
	}

	public boolean cB() {
		return this.getHealth() <= this.getMaxHealth() / 2.0F;
	}

	public class_qf bz() {
		return class_qf.b;
	}

	public void a(Entity var1) {
		this.vehicle = null;
	}
}
