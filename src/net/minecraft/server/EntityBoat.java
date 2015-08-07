package net.minecraft.server;

import java.util.List;

public class EntityBoat extends Entity {

	private static final int TIMESH_DW_ID = Datawathcer.claimId(EntityBoat.class); //value = 5
	private static final int FORWARD_DW_ID = Datawathcer.claimId(EntityBoat.class); //value = 6
	private static final int DAMAGETAKEN_DW_ID = Datawathcer.claimId(EntityBoat.class); //value = 7

	private boolean d;
	private double e;
	private int f;
	private double g;
	private double h;
	private double i;
	private double as;
	private double at;

	public EntityBoat(World var1) {
		super(var1);
		this.d = true;
		this.e = 0.07D;
		this.k = true;
		this.a(1.5F, 0.6F);
	}

	protected boolean s_() {
		return false;
	}

	protected void initDatawatcher() {
		this.datawatcher.add(TIMESH_DW_ID, new Integer(0));
		this.datawatcher.add(FORWARD_DW_ID, new Integer(1));
		this.datawatcher.add(DAMAGETAKEN_DW_ID, new Float(0.0F));
	}

	public AxisAlignedBB j(Entity var1) {
		return var1.aT();
	}

	public AxisAlignedBB S() {
		return this.aT();
	}

	public boolean ae() {
		return true;
	}

	public EntityBoat(World var1, double var2, double var4, double var6) {
		this(var1);
		this.b(var2, var4, var6);
		this.v = 0.0D;
		this.motY = 0.0D;
		this.x = 0.0D;
		this.p = var2;
		this.q = var4;
		this.r = var6;
	}

	public double an() {
		return -0.3D;
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (!this.o.isClientSide && !this.I) {
			if (this.passenger != null && this.passenger == var1.j() && var1 instanceof class_pe) {
				return false;
			} else {
				this.b(-this.m());
				this.a(10);
				this.a(this.j() + var2 * 10.0F);
				this.ac();
				boolean var3 = var1.j() instanceof EntityHuman && ((EntityHuman) var1.j()).abilities.instabuild;
				if (var3 || this.j() > 40.0F) {
					if (this.passenger != null) {
						this.passenger.a((Entity) this);
					}

					if (!var3 && this.o.R().getBooleanValue("doEntityDrops")) {
						this.a(Items.BOAT, 1, 0.0F);
					}

					this.J();
				}

				return true;
			}
		} else {
			return true;
		}
	}

	public boolean ad() {
		return !this.I;
	}

	public void t_() {
		super.t_();
		if (this.l() > 0) {
			this.a(this.l() - 1);
		}

		if (this.j() > 0.0F) {
			this.a(this.j() - 1.0F);
		}

		this.p = this.s;
		this.q = this.t;
		this.r = this.u;
		byte var1 = 5;
		double var2 = 0.0D;

		for (int var4 = 0; var4 < var1; ++var4) {
			double var5 = this.aT().yMin + (this.aT().yMax - this.aT().yMin) * (double) (var4 + 0) / (double) var1 - 0.125D;
			double var7 = this.aT().yMin + (this.aT().yMax - this.aT().yMin) * (double) (var4 + 1) / (double) var1 - 0.125D;
			AxisAlignedBB var9 = new AxisAlignedBB(this.aT().xMin, var5, this.aT().zMin, this.aT().xMax, var7, this.aT().zMax);
			if (this.o.b(var9, Material.WATER)) {
				var2 += 1.0D / (double) var1;
			}
		}

		double var19 = Math.sqrt(this.v * this.v + this.x * this.x);
		double var6;
		double var8;
		int var10;
		if (var19 > 0.2975D) {
			var6 = Math.cos((double) this.y * 3.141592653589793D / 180.0D);
			var8 = Math.sin((double) this.y * 3.141592653589793D / 180.0D);

			for (var10 = 0; (double) var10 < 1.0D + var19 * 60.0D; ++var10) {
				double var11 = (double) (this.random.nextFloat() * 2.0F - 1.0F);
				double var13 = (double) (this.random.nextInt(2) * 2 - 1) * 0.7D;
				double var15;
				double var17;
				if (this.random.nextBoolean()) {
					var15 = this.s - var6 * var11 * 0.8D + var8 * var13;
					var17 = this.u - var8 * var11 * 0.8D - var6 * var13;
					this.o.a(class_cy.f, var15, this.t - 0.125D, var17, this.v, this.motY, this.x, new int[0]);
				} else {
					var15 = this.s + var6 + var8 * var11 * 0.7D;
					var17 = this.u + var8 - var6 * var11 * 0.7D;
					this.o.a(class_cy.f, var15, this.t - 0.125D, var17, this.v, this.motY, this.x, new int[0]);
				}
			}
		}

		double var24;
		double var26;
		if (this.o.isClientSide && this.d) {
			if (this.f > 0) {
				var6 = this.s + (this.g - this.s) / (double) this.f;
				var8 = this.t + (this.h - this.t) / (double) this.f;
				var24 = this.u + (this.i - this.u) / (double) this.f;
				var26 = MathHelper.clampAngle(this.as - (double) this.y);
				this.y = (float) ((double) this.y + var26 / (double) this.f);
				this.z = (float) ((double) this.z + (this.at - (double) this.z) / (double) this.f);
				--this.f;
				this.b(var6, var8, var24);
				this.b(this.y, this.z);
			} else {
				var6 = this.s + this.v;
				var8 = this.t + this.motY;
				var24 = this.u + this.x;
				this.b(var6, var8, var24);
				if (this.C) {
					this.v *= 0.5D;
					this.motY *= 0.5D;
					this.x *= 0.5D;
				}

				this.v *= 0.9900000095367432D;
				this.motY *= 0.949999988079071D;
				this.x *= 0.9900000095367432D;
			}

		} else {
			if (var2 < 1.0D) {
				var6 = var2 * 2.0D - 1.0D;
				this.motY += 0.03999999910593033D * var6;
			} else {
				if (this.motY < 0.0D) {
					this.motY /= 2.0D;
				}

				this.motY += 0.007000000216066837D;
			}

			if (this.passenger instanceof EntityLiving) {
				EntityLiving var20 = (EntityLiving) this.passenger;
				float var21 = this.passenger.y + -var20.bc * 90.0F;
				this.v += -Math.sin((double) (var21 * 3.1415927F / 180.0F)) * this.e * (double) var20.bd * 0.05000000074505806D;
				this.x += Math.cos((double) (var21 * 3.1415927F / 180.0F)) * this.e * (double) var20.bd * 0.05000000074505806D;
			}

			var6 = Math.sqrt(this.v * this.v + this.x * this.x);
			if (var6 > 0.35D) {
				var8 = 0.35D / var6;
				this.v *= var8;
				this.x *= var8;
				var6 = 0.35D;
			}

			if (var6 > var19 && this.e < 0.35D) {
				this.e += (0.35D - this.e) / 35.0D;
				if (this.e > 0.35D) {
					this.e = 0.35D;
				}
			} else {
				this.e -= (this.e - 0.07D) / 35.0D;
				if (this.e < 0.07D) {
					this.e = 0.07D;
				}
			}

			int var22;
			for (var22 = 0; var22 < 4; ++var22) {
				int var23 = MathHelper.floor(this.s + ((double) (var22 % 2) - 0.5D) * 0.8D);
				var10 = MathHelper.floor(this.u + ((double) (var22 / 2) - 0.5D) * 0.8D);

				for (int var25 = 0; var25 < 2; ++var25) {
					int var12 = MathHelper.floor(this.t) + var25;
					BlockPosition var27 = new BlockPosition(var23, var12, var10);
					Block var14 = this.o.getType(var27).getBlock();
					if (var14 == Blocks.SNOW_LAYER) {
						this.o.setAir(var27);
						this.D = false;
					} else if (var14 == Blocks.WATERLILY) {
						this.o.setAir(var27, true);
						this.D = false;
					}
				}
			}

			if (this.C) {
				this.v *= 0.5D;
				this.motY *= 0.5D;
				this.x *= 0.5D;
			}

			this.d(this.v, this.motY, this.x);
			if (this.D && var19 > 0.2975D) {
				if (!this.o.isClientSide && !this.I) {
					this.J();
					if (this.o.R().getBooleanValue("doEntityDrops")) {
						for (var22 = 0; var22 < 3; ++var22) {
							this.a(Item.getItemOf(Blocks.PLANKS), 1, 0.0F);
						}

						for (var22 = 0; var22 < 2; ++var22) {
							this.a(Items.STICK, 1, 0.0F);
						}
					}
				}
			} else {
				this.v *= 0.9900000095367432D;
				this.motY *= 0.949999988079071D;
				this.x *= 0.9900000095367432D;
			}

			this.z = 0.0F;
			var8 = (double) this.y;
			var24 = this.p - this.s;
			var26 = this.r - this.u;
			if (var24 * var24 + var26 * var26 > 0.001D) {
				var8 = (double) ((float) (MathHelper.b(var26, var24) * 180.0D / 3.141592653589793D));
			}

			double var28 = MathHelper.clampAngle(var8 - (double) this.y);
			if (var28 > 20.0D) {
				var28 = 20.0D;
			}

			if (var28 < -20.0D) {
				var28 = -20.0D;
			}

			this.y = (float) ((double) this.y + var28);
			this.b(this.y, this.z);
			if (!this.o.isClientSide) {
				List var16 = this.o.getEntities((Entity) this, (AxisAlignedBB) this.aT().grow(0.20000000298023224D, 0.0D, 0.20000000298023224D));
				if (var16 != null && !var16.isEmpty()) {
					for (int var29 = 0; var29 < var16.size(); ++var29) {
						Entity var18 = (Entity) var16.get(var29);
						if (var18 != this.passenger && var18.ae() && var18 instanceof EntityBoat) {
							var18.i(this);
						}
					}
				}

				if (this.passenger != null && this.passenger.I) {
					this.passenger = null;
				}

			}
		}
	}

	public void al() {
		if (this.passenger != null) {
			double var1 = Math.cos((double) this.y * 3.141592653589793D / 180.0D) * 0.4D;
			double var3 = Math.sin((double) this.y * 3.141592653589793D / 180.0D) * 0.4D;
			this.passenger.b(this.s + var1, this.t + this.an() + this.passenger.am(), this.u + var3);
		}
	}

	protected void write(NBTTagCompound var1) {
	}

	protected void read(NBTTagCompound var1) {
	}

	public boolean a(EntityHuman var1, ItemStack var2, EnumUsedHand var3) {
		if (this.passenger != null && this.passenger instanceof EntityHuman && this.passenger != var1) {
			return true;
		} else {
			if (!this.o.isClientSide) {
				var1.a((Entity) this);
			}

			return true;
		}
	}

	protected void a(double var1, boolean var3, Block var4, BlockPosition var5) {
		if (var3) {
			if (this.O > 3.0F) {
				this.e(this.O, 1.0F);
				if (!this.o.isClientSide && !this.I) {
					this.J();
					if (this.o.R().getBooleanValue("doEntityDrops")) {
						int var6;
						for (var6 = 0; var6 < 3; ++var6) {
							this.a(Item.getItemOf(Blocks.PLANKS), 1, 0.0F);
						}

						for (var6 = 0; var6 < 2; ++var6) {
							this.a(Items.STICK, 1, 0.0F);
						}
					}
				}

				this.O = 0.0F;
			}
		} else if (this.o.getType((new BlockPosition(this)).down()).getBlock().getMaterial() != Material.WATER && var1 < 0.0D) {
			this.O = (float) ((double) this.O - var1);
		}

	}

	public void a(float var1) {
		this.datawatcher.update(DAMAGETAKEN_DW_ID, Float.valueOf(var1));
	}

	public float j() {
		return this.datawatcher.getFloat(DAMAGETAKEN_DW_ID);
	}

	public void a(int var1) {
		this.datawatcher.update(TIMESH_DW_ID, Integer.valueOf(var1));
	}

	public int l() {
		return this.datawatcher.getInt(TIMESH_DW_ID);
	}

	public void b(int var1) {
		this.datawatcher.update(FORWARD_DW_ID, Integer.valueOf(var1));
	}

	public int m() {
		return this.datawatcher.getInt(FORWARD_DW_ID);
	}
}
