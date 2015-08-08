package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;

public abstract class EntityMinecartAbstract extends Entity implements INamableTileEntity {

	private static final int SHAKINGPOWER_DW_ID = DataWathcer.claimId(EntityMinecartAbstract.class); //value = 5
	private static final int SHAKINGDIRECTION_DW_ID = DataWathcer.claimId(EntityMinecartAbstract.class); //value = 6
	private static final int DAMAGETAKEN_DW_ID = DataWathcer.claimId(EntityMinecartAbstract.class); //value = 7
	private static final int BLOCK_DW_ID = DataWathcer.claimId(EntityMinecartAbstract.class); //value = 8
	private static final int BLOCKY_DW_ID = DataWathcer.claimId(EntityMinecartAbstract.class); //value = 9
	private static final int SHOWBLOCK_DW_ID = DataWathcer.claimId(EntityMinecartAbstract.class); //value = 10

	private boolean g;
	private String h;
	private static final int[][][] i = new int[][][] { { { 0, 0, -1 }, { 0, 0, 1 } }, { { -1, 0, 0 }, { 1, 0, 0 } }, { { -1, -1, 0 }, { 1, 0, 0 } }, { { -1, 0, 0 }, { 1, -1, 0 } }, { { 0, 0, -1 }, { 0, -1, 1 } }, { { 0, -1, -1 }, { 0, 0, 1 } }, { { 0, 0, 1 }, { 1, 0, 0 } }, { { 0, 0, 1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { 1, 0, 0 } } };
	private int as;
	private double at;
	private double au;
	private double av;
	private double aw;
	private double ax;

	public EntityMinecartAbstract(World var1) {
		super(var1);
		this.k = true;
		this.a(0.98F, 0.7F);
	}

	public static EntityMinecartAbstract a(World var0, double var1, double var3, double var5, EnumMinecartType var7) {
		switch (EntityMinecartAbstract.SyntheticClass_1.a[var7.ordinal()]) {
			case 1:
				return new EntityMinecartChest(var0, var1, var3, var5);
			case 2:
				return new EntityMinecartFurnace(var0, var1, var3, var5);
			case 3:
				return new EntityMinecartTNT(var0, var1, var3, var5);
			case 4:
				return new EntityMinecartMobSpawner(var0, var1, var3, var5);
			case 5:
				return new EntityMinecartHopper(var0, var1, var3, var5);
			case 6:
				return new EntityMinecartCommandBlock(var0, var1, var3, var5);
			default:
				return new EntityMinecartRideable(var0, var1, var3, var5);
		}
	}

	protected boolean s_() {
		return false;
	}

	protected void initDatawatcher() {
		this.datawatcher.add(SHAKINGPOWER_DW_ID, new Integer(0));
		this.datawatcher.add(SHAKINGDIRECTION_DW_ID, new Integer(1));
		this.datawatcher.add(DAMAGETAKEN_DW_ID, new Float(0.0F));
		this.datawatcher.add(BLOCK_DW_ID, new Integer(0));
		this.datawatcher.add(BLOCKY_DW_ID, new Integer(6));
		this.datawatcher.add(SHOWBLOCK_DW_ID, Byte.valueOf((byte) 0));
	}

	public AxisAlignedBB j(Entity var1) {
		return var1.ae() ? var1.aT() : null;
	}

	public AxisAlignedBB S() {
		return null;
	}

	public boolean ae() {
		return true;
	}

	public EntityMinecartAbstract(World var1, double var2, double var4, double var6) {
		this(var1);
		this.b(var2, var4, var6);
		this.motX = 0.0D;
		this.motY = 0.0D;
		this.motZ = 0.0D;
		this.lastX = var2;
		this.lastY = var4;
		this.lastZ = var6;
	}

	public double an() {
		return 0.0D;
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (!this.world.isClientSide && !this.dead) {
			if (this.b(var1)) {
				return false;
			} else {
				this.k(-this.r());
				this.j(10);
				this.ac();
				this.a(this.p() + var2 * 10.0F);
				boolean var3 = var1.j() instanceof EntityHuman && ((EntityHuman) var1.j()).abilities.instabuild;
				if (var3 || this.p() > 40.0F) {
					if (this.passenger != null) {
						this.passenger.a((Entity) null);
					}

					if (var3 && !this.hasCustomName()) {
						this.J();
					} else {
						this.a(var1);
					}
				}

				return true;
			}
		} else {
			return true;
		}
	}

	public void a(DamageSource var1) {
		this.J();
		if (this.world.R().getBooleanValue("doEntityDrops")) {
			ItemStack var2 = new ItemStack(Items.MINECART, 1);
			if (this.h != null) {
				var2.setDisplayName(this.h);
			}

			this.a(var2, 0.0F);
		}

	}

	public boolean ad() {
		return !this.dead;
	}

	public void J() {
		super.J();
	}

	public void t_() {
		if (this.q() > 0) {
			this.j(this.q() - 1);
		}

		if (this.p() > 0.0F) {
			this.a(this.p() - 1.0F);
		}

		if (this.locY < -64.0D) {
			this.O();
		}

		int var2;
		if (!this.world.isClientSide && this.world instanceof WorldServer) {
			this.world.B.a("portal");
			MinecraftServer var1 = ((WorldServer) this.world).s();
			var2 = this.L();
			if (this.ak) {
				if (var1.C()) {
					if (this.vehicle == null && this.al++ >= var2) {
						this.al = var2;
						this.portalCooldown = this.aq();
						byte var3;
						if (this.world.worldProvider.p().a() == -1) {
							var3 = 0;
						} else {
							var3 = -1;
						}

						this.c(var3);
					}

					this.ak = false;
				}
			} else {
				if (this.al > 0) {
					this.al -= 4;
				}

				if (this.al < 0) {
					this.al = 0;
				}
			}

			if (this.portalCooldown > 0) {
				--this.portalCooldown;
			}

			this.world.B.b();
		}

		if (this.world.isClientSide) {
			if (this.as > 0) {
				double var15 = this.locX + (this.at - this.locX) / (double) this.as;
				double var17 = this.locY + (this.au - this.locY) / (double) this.as;
				double var18 = this.locZ + (this.av - this.locZ) / (double) this.as;
				double var7 = MathHelper.clampAngle(this.aw - (double) this.yaw);
				this.yaw = (float) ((double) this.yaw + var7 / (double) this.as);
				this.pitch = (float) ((double) this.pitch + (this.ax - (double) this.pitch) / (double) this.as);
				--this.as;
				this.b(var15, var17, var18);
				this.b(this.yaw, this.pitch);
			} else {
				this.b(this.locX, this.locY, this.locZ);
				this.b(this.yaw, this.pitch);
			}

		} else {
			this.lastX = this.locX;
			this.lastY = this.locY;
			this.lastZ = this.locZ;
			this.motY -= 0.03999999910593033D;
			int var14 = MathHelper.floor(this.locX);
			var2 = MathHelper.floor(this.locY);
			int var16 = MathHelper.floor(this.locZ);
			if (BlockMinecartTrackAbstract.e(this.world, new BlockPosition(var14, var2 - 1, var16))) {
				--var2;
			}

			BlockPosition var4 = new BlockPosition(var14, var2, var16);
			IBlockData var5 = this.world.getType(var4);
			if (BlockMinecartTrackAbstract.d(var5)) {
				this.a(var4, var5);
				if (var5.getBlock() == Blocks.ACTIVATOR_RAIL) {
					this.a(var14, var2, var16, ((Boolean) var5.get(BlockPoweredRail.POWERED)).booleanValue());
				}
			} else {
				this.n();
			}

			this.Q();
			this.pitch = 0.0F;
			double var6 = this.lastX - this.locX;
			double var8 = this.lastZ - this.locZ;
			if (var6 * var6 + var8 * var8 > 0.001D) {
				this.yaw = (float) (MathHelper.b(var8, var6) * 180.0D / 3.141592653589793D);
				if (this.g) {
					this.yaw += 180.0F;
				}
			}

			double var10 = (double) MathHelper.clampAngle(this.yaw - this.lastYaw);
			if (var10 < -170.0D || var10 >= 170.0D) {
				this.yaw += 180.0F;
				this.g = !this.g;
			}

			this.b(this.yaw, this.pitch);
			Iterator var12 = this.world.getEntities((Entity) this, (AxisAlignedBB) this.aT().grow(0.20000000298023224D, 0.0D, 0.20000000298023224D)).iterator();

			while (var12.hasNext()) {
				Entity var13 = (Entity) var12.next();
				if (var13 != this.passenger && var13.ae() && var13 instanceof EntityMinecartAbstract) {
					var13.i(this);
				}
			}

			if (this.passenger != null && this.passenger.dead) {
				if (this.passenger.vehicle == this) {
					this.passenger.vehicle = null;
				}

				this.passenger = null;
			}

			this.W();
		}
	}

	protected double m() {
		return 0.4D;
	}

	public void a(int var1, int var2, int var3, boolean var4) {
	}

	protected void n() {
		double var1 = this.m();
		this.motX = MathHelper.clamp(this.motX, -var1, var1);
		this.motZ = MathHelper.clamp(this.motZ, -var1, var1);
		if (this.onGround) {
			this.motX *= 0.5D;
			this.motY *= 0.5D;
			this.motZ *= 0.5D;
		}

		this.d(this.motX, this.motY, this.motZ);
		if (!this.onGround) {
			this.motX *= 0.949999988079071D;
			this.motY *= 0.949999988079071D;
			this.motZ *= 0.949999988079071D;
		}

	}

	protected void a(BlockPosition var1, IBlockData var2) {
		this.fallDistance = 0.0F;
		Vec3D var3 = this.k(this.locX, this.locY, this.locZ);
		this.locY = (double) var1.getY();
		boolean var4 = false;
		boolean var5 = false;
		BlockMinecartTrackAbstract var6 = (BlockMinecartTrackAbstract) var2.getBlock();
		if (var6 == Blocks.GOLDEN_RAIL) {
			var4 = ((Boolean) var2.get(BlockPoweredRail.POWERED)).booleanValue();
			var5 = !var4;
		}

		double var7 = 0.0078125D;
		BlockMinecartTrackAbstract.EnumTrackPosition var9 = (BlockMinecartTrackAbstract.EnumTrackPosition) var2.get(var6.n());
		switch (EntityMinecartAbstract.SyntheticClass_1.b[var9.ordinal()]) {
			case 1:
				this.motX -= 0.0078125D;
				++this.locY;
				break;
			case 2:
				this.motX += 0.0078125D;
				++this.locY;
				break;
			case 3:
				this.motZ += 0.0078125D;
				++this.locY;
				break;
			case 4:
				this.motZ -= 0.0078125D;
				++this.locY;
		}

		int[][] var10 = i[var9.getId()];
		double var11 = (double) (var10[1][0] - var10[0][0]);
		double var13 = (double) (var10[1][2] - var10[0][2]);
		double var15 = Math.sqrt(var11 * var11 + var13 * var13);
		double var17 = this.motX * var11 + this.motZ * var13;
		if (var17 < 0.0D) {
			var11 = -var11;
			var13 = -var13;
		}

		double var19 = Math.sqrt(this.motX * this.motX + this.motZ * this.motZ);
		if (var19 > 2.0D) {
			var19 = 2.0D;
		}

		this.motX = var19 * var11 / var15;
		this.motZ = var19 * var13 / var15;
		double var21;
		double var23;
		double var25;
		double var27;
		if (this.passenger instanceof EntityLiving) {
			var21 = (double) ((EntityLiving) this.passenger).bd;
			if (var21 > 0.0D) {
				var23 = -Math.sin((double) (this.passenger.yaw * 3.1415927F / 180.0F));
				var25 = Math.cos((double) (this.passenger.yaw * 3.1415927F / 180.0F));
				var27 = this.motX * this.motX + this.motZ * this.motZ;
				if (var27 < 0.01D) {
					this.motX += var23 * 0.1D;
					this.motZ += var25 * 0.1D;
					var5 = false;
				}
			}
		}

		if (var5) {
			var21 = Math.sqrt(this.motX * this.motX + this.motZ * this.motZ);
			if (var21 < 0.03D) {
				this.motX *= 0.0D;
				this.motY *= 0.0D;
				this.motZ *= 0.0D;
			} else {
				this.motX *= 0.5D;
				this.motY *= 0.0D;
				this.motZ *= 0.5D;
			}
		}

		var21 = 0.0D;
		var23 = (double) var1.getX() + 0.5D + (double) var10[0][0] * 0.5D;
		var25 = (double) var1.getZ() + 0.5D + (double) var10[0][2] * 0.5D;
		var27 = (double) var1.getX() + 0.5D + (double) var10[1][0] * 0.5D;
		double var29 = (double) var1.getZ() + 0.5D + (double) var10[1][2] * 0.5D;
		var11 = var27 - var23;
		var13 = var29 - var25;
		double var31;
		double var33;
		if (var11 == 0.0D) {
			this.locX = (double) var1.getX() + 0.5D;
			var21 = this.locZ - (double) var1.getZ();
		} else if (var13 == 0.0D) {
			this.locZ = (double) var1.getZ() + 0.5D;
			var21 = this.locX - (double) var1.getX();
		} else {
			var31 = this.locX - var23;
			var33 = this.locZ - var25;
			var21 = (var31 * var11 + var33 * var13) * 2.0D;
		}

		this.locX = var23 + var11 * var21;
		this.locZ = var25 + var13 * var21;
		this.b(this.locX, this.locY, this.locZ);
		var31 = this.motX;
		var33 = this.motZ;
		if (this.passenger != null) {
			var31 *= 0.75D;
			var33 *= 0.75D;
		}

		double var35 = this.m();
		var31 = MathHelper.clamp(var31, -var35, var35);
		var33 = MathHelper.clamp(var33, -var35, var35);
		this.d(var31, 0.0D, var33);
		if (var10[0][1] != 0 && MathHelper.floor(this.locX) - var1.getX() == var10[0][0] && MathHelper.floor(this.locZ) - var1.getZ() == var10[0][2]) {
			this.b(this.locX, this.locY + (double) var10[0][1], this.locZ);
		} else if (var10[1][1] != 0 && MathHelper.floor(this.locX) - var1.getX() == var10[1][0] && MathHelper.floor(this.locZ) - var1.getZ() == var10[1][2]) {
			this.b(this.locX, this.locY + (double) var10[1][1], this.locZ);
		}

		this.o();
		Vec3D var37 = this.k(this.locX, this.locY, this.locZ);
		if (var37 != null && var3 != null) {
			double var38 = (var3.y - var37.y) * 0.05D;
			var19 = Math.sqrt(this.motX * this.motX + this.motZ * this.motZ);
			if (var19 > 0.0D) {
				this.motX = this.motX / var19 * (var19 + var38);
				this.motZ = this.motZ / var19 * (var19 + var38);
			}

			this.b(this.locX, var37.y, this.locZ);
		}

		int var44 = MathHelper.floor(this.locX);
		int var39 = MathHelper.floor(this.locZ);
		if (var44 != var1.getX() || var39 != var1.getZ()) {
			var19 = Math.sqrt(this.motX * this.motX + this.motZ * this.motZ);
			this.motX = var19 * (double) (var44 - var1.getX());
			this.motZ = var19 * (double) (var39 - var1.getZ());
		}

		if (var4) {
			double var40 = Math.sqrt(this.motX * this.motX + this.motZ * this.motZ);
			if (var40 > 0.01D) {
				double var42 = 0.06D;
				this.motX += this.motX / var40 * var42;
				this.motZ += this.motZ / var40 * var42;
			} else if (var9 == BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST) {
				if (this.world.getType(var1.west()).getBlock().isOccluding()) {
					this.motX = 0.02D;
				} else if (this.world.getType(var1.east()).getBlock().isOccluding()) {
					this.motX = -0.02D;
				}
			} else if (var9 == BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH) {
				if (this.world.getType(var1.north()).getBlock().isOccluding()) {
					this.motZ = 0.02D;
				} else if (this.world.getType(var1.south()).getBlock().isOccluding()) {
					this.motZ = -0.02D;
				}
			}
		}

	}

	protected void o() {
		if (this.passenger != null) {
			this.motX *= 0.996999979019165D;
			this.motY *= 0.0D;
			this.motZ *= 0.996999979019165D;
		} else {
			this.motX *= 0.9599999785423279D;
			this.motY *= 0.0D;
			this.motZ *= 0.9599999785423279D;
		}

	}

	public void b(double var1, double var3, double var5) {
		this.locX = var1;
		this.locY = var3;
		this.locZ = var5;
		float var7 = this.width / 2.0F;
		float var8 = this.length;
		this.a((AxisAlignedBB) (new AxisAlignedBB(var1 - (double) var7, var3, var5 - (double) var7, var1 + (double) var7, var3 + (double) var8, var5 + (double) var7)));
	}

	public Vec3D k(double var1, double var3, double var5) {
		int var7 = MathHelper.floor(var1);
		int var8 = MathHelper.floor(var3);
		int var9 = MathHelper.floor(var5);
		if (BlockMinecartTrackAbstract.e(this.world, new BlockPosition(var7, var8 - 1, var9))) {
			--var8;
		}

		IBlockData var10 = this.world.getType(new BlockPosition(var7, var8, var9));
		if (BlockMinecartTrackAbstract.d(var10)) {
			BlockMinecartTrackAbstract.EnumTrackPosition var11 = (BlockMinecartTrackAbstract.EnumTrackPosition) var10.get(((BlockMinecartTrackAbstract) var10.getBlock()).n());
			int[][] var12 = i[var11.getId()];
			double var13 = 0.0D;
			double var15 = (double) var7 + 0.5D + (double) var12[0][0] * 0.5D;
			double var17 = (double) var8 + 0.0625D + (double) var12[0][1] * 0.5D;
			double var19 = (double) var9 + 0.5D + (double) var12[0][2] * 0.5D;
			double var21 = (double) var7 + 0.5D + (double) var12[1][0] * 0.5D;
			double var23 = (double) var8 + 0.0625D + (double) var12[1][1] * 0.5D;
			double var25 = (double) var9 + 0.5D + (double) var12[1][2] * 0.5D;
			double var27 = var21 - var15;
			double var29 = (var23 - var17) * 2.0D;
			double var31 = var25 - var19;
			if (var27 == 0.0D) {
				var1 = (double) var7 + 0.5D;
				var13 = var5 - (double) var9;
			} else if (var31 == 0.0D) {
				var5 = (double) var9 + 0.5D;
				var13 = var1 - (double) var7;
			} else {
				double var33 = var1 - var15;
				double var35 = var5 - var19;
				var13 = (var33 * var27 + var35 * var31) * 2.0D;
			}

			var1 = var15 + var27 * var13;
			var3 = var17 + var29 * var13;
			var5 = var19 + var31 * var13;
			if (var29 < 0.0D) {
				++var3;
			}

			if (var29 > 0.0D) {
				var3 += 0.5D;
			}

			return new Vec3D(var1, var3, var5);
		} else {
			return null;
		}
	}

	protected void read(NBTTagCompound var1) {
		if (var1.getBoolean("CustomDisplayTile")) {
			int var2 = var1.getInt("DisplayData");
			Block var3;
			if (var1.hasOfType("DisplayTile", 8)) {
				var3 = Block.getByName(var1.getString("DisplayTile"));
				if (var3 == null) {
					this.a(Blocks.AIR.getBlockData());
				} else {
					this.a(var3.fromLegacyData(var2));
				}
			} else {
				var3 = Block.getById(var1.getInt("DisplayTile"));
				if (var3 == null) {
					this.a(Blocks.AIR.getBlockData());
				} else {
					this.a(var3.fromLegacyData(var2));
				}
			}

			this.l(var1.getInt("DisplayOffset"));
		}

		if (var1.hasOfType("CustomName", 8) && !var1.getString("CustomName").isEmpty()) {
			this.h = var1.getString("CustomName");
		}

	}

	protected void write(NBTTagCompound var1) {
		if (this.x()) {
			var1.put("CustomDisplayTile", true);
			IBlockData var2 = this.t();
			MinecraftKey var3 = (MinecraftKey) Block.BLOCK_REGISTRY.getKey(var2.getBlock());
			var1.put("DisplayTile", var3 == null ? "" : var3.toString());
			var1.put("DisplayData", var2.getBlock().toLegacyData(var2));
			var1.put("DisplayOffset", this.v());
		}

		if (this.h != null && !this.h.isEmpty()) {
			var1.put("CustomName", this.h);
		}

	}

	public void i(Entity var1) {
		if (!this.world.isClientSide) {
			if (!var1.noclip && !this.noclip) {
				if (var1 != this.passenger) {
					if (var1 instanceof EntityLiving && !(var1 instanceof EntityHuman) && !(var1 instanceof EntityVillagerGolem) && this.s() == EnumMinecartType.RIDEABLE && this.motX * this.motX + this.motZ * this.motZ > 0.01D && this.passenger == null && var1.vehicle == null) {
						var1.a((Entity) this);
					}

					double var2 = var1.locX - this.locX;
					double var4 = var1.locZ - this.locZ;
					double var6 = var2 * var2 + var4 * var4;
					if (var6 >= 9.999999747378752E-5D) {
						var6 = (double) MathHelper.sqrt(var6);
						var2 /= var6;
						var4 /= var6;
						double var8 = 1.0D / var6;
						if (var8 > 1.0D) {
							var8 = 1.0D;
						}

						var2 *= var8;
						var4 *= var8;
						var2 *= 0.10000000149011612D;
						var4 *= 0.10000000149011612D;
						var2 *= (double) (1.0F - this.U);
						var4 *= (double) (1.0F - this.U);
						var2 *= 0.5D;
						var4 *= 0.5D;
						if (var1 instanceof EntityMinecartAbstract) {
							double var10 = var1.locX - this.locX;
							double var12 = var1.locZ - this.locZ;
							Vec3D var14 = (new Vec3D(var10, 0.0D, var12)).normalize();
							Vec3D var15 = (new Vec3D((double) MathHelper.cos(this.yaw * 3.1415927F / 180.0F), 0.0D, (double) MathHelper.sin(this.yaw * 3.1415927F / 180.0F))).normalize();
							double var16 = Math.abs(var14.dotProduct(var15));
							if (var16 < 0.800000011920929D) {
								return;
							}

							double var18 = var1.motX + this.motX;
							double var20 = var1.motZ + this.motZ;
							if (((EntityMinecartAbstract) var1).s() == EnumMinecartType.FURNACE && this.s() != EnumMinecartType.FURNACE) {
								this.motX *= 0.20000000298023224D;
								this.motZ *= 0.20000000298023224D;
								this.g(var1.motX - var2, 0.0D, var1.motZ - var4);
								var1.motX *= 0.949999988079071D;
								var1.motZ *= 0.949999988079071D;
							} else if (((EntityMinecartAbstract) var1).s() != EnumMinecartType.FURNACE && this.s() == EnumMinecartType.FURNACE) {
								var1.motX *= 0.20000000298023224D;
								var1.motZ *= 0.20000000298023224D;
								var1.g(this.motX + var2, 0.0D, this.motZ + var4);
								this.motX *= 0.949999988079071D;
								this.motZ *= 0.949999988079071D;
							} else {
								var18 /= 2.0D;
								var20 /= 2.0D;
								this.motX *= 0.20000000298023224D;
								this.motZ *= 0.20000000298023224D;
								this.g(var18 - var2, 0.0D, var20 - var4);
								var1.motX *= 0.20000000298023224D;
								var1.motZ *= 0.20000000298023224D;
								var1.g(var18 + var2, 0.0D, var20 + var4);
							}
						} else {
							this.g(-var2, 0.0D, -var4);
							var1.g(var2 / 4.0D, 0.0D, var4 / 4.0D);
						}
					}

				}
			}
		}
	}

	public void a(float var1) {
		this.datawatcher.update(DAMAGETAKEN_DW_ID, Float.valueOf(var1));
	}

	public float p() {
		return this.datawatcher.getFloat(DAMAGETAKEN_DW_ID);
	}

	public void j(int var1) {
		this.datawatcher.update(SHAKINGPOWER_DW_ID, Integer.valueOf(var1));
	}

	public int q() {
		return this.datawatcher.getInt(SHAKINGPOWER_DW_ID);
	}

	public void k(int var1) {
		this.datawatcher.update(SHAKINGDIRECTION_DW_ID, Integer.valueOf(var1));
	}

	public int r() {
		return this.datawatcher.getInt(SHAKINGDIRECTION_DW_ID);
	}

	public abstract EnumMinecartType s();

	public IBlockData t() {
		return !this.x() ? this.u() : Block.getByCombinedId(this.H().getInt(BLOCK_DW_ID));
	}

	public IBlockData u() {
		return Blocks.AIR.getBlockData();
	}

	public int v() {
		return !this.x() ? this.w() : this.H().getInt(BLOCKY_DW_ID);
	}

	public int w() {
		return 6;
	}

	public void a(IBlockData var1) {
		this.H().update(BLOCK_DW_ID, Integer.valueOf(Block.getCombinedId(var1)));
		this.a(true);
	}

	public void l(int var1) {
		this.H().update(BLOCKY_DW_ID, Integer.valueOf(var1));
		this.a(true);
	}

	public boolean x() {
		return this.H().getByte(SHOWBLOCK_DW_ID) == 1;
	}

	public void a(boolean var1) {
		this.H().update(SHOWBLOCK_DW_ID, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	public void a(String var1) {
		this.h = var1;
	}

	public String getName() {
		return this.h != null ? this.h : super.getName();
	}

	public boolean hasCustomName() {
		return this.h != null;
	}

	public String getCustomName() {
		return this.h;
	}

	public IChatBaseComponent getScoreboardDisplayName() {
		if (this.hasCustomName()) {
			ChatComponentText var2 = new ChatComponentText(this.h);
			var2.getChatModifier().a(this.aS());
			var2.getChatModifier().a(this.getUniqueId().toString());
			return var2;
		} else {
			ChatMessage var1 = new ChatMessage(this.getName(), new Object[0]);
			var1.getChatModifier().a(this.aS());
			var1.getChatModifier().a(this.getUniqueId().toString());
			return var1;
		}
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[BlockMinecartTrackAbstract.EnumTrackPosition.values().length];

		static {
			try {
				b[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST.ordinal()] = 1;
			} catch (NoSuchFieldError var10) {
				;
			}

			try {
				b[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST.ordinal()] = 2;
			} catch (NoSuchFieldError var9) {
				;
			}

			try {
				b[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH.ordinal()] = 3;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				b[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH.ordinal()] = 4;
			} catch (NoSuchFieldError var7) {
				;
			}

			a = new int[EnumMinecartType.values().length];

			try {
				a[EnumMinecartType.CHEST.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[EnumMinecartType.FURNACE.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[EnumMinecartType.TNT.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[EnumMinecartType.SPAWNER.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[EnumMinecartType.HOPPER.ordinal()] = 5;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[EnumMinecartType.COMMAND_BLOCK.ordinal()] = 6;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum EnumMinecartType {
		RIDEABLE(0, "MinecartRideable"), CHEST(1, "MinecartChest"), FURNACE(2, "MinecartFurnace"), TNT(3, "MinecartTNT"), SPAWNER(4, "MinecartSpawner"), HOPPER(5, "MinecartHopper"), COMMAND_BLOCK(6, "MinecartCommandBlock");

		private static final Map h;
		private final int i;
		private final String j;

		private EnumMinecartType(int var3, String var4) {
			this.i = var3;
			this.j = var4;
		}

		public int a() {
			return this.i;
		}

		public String b() {
			return this.j;
		}

		public static EnumMinecartType a(int var0) {
			EnumMinecartType var1 = (EnumMinecartType) h.get(Integer.valueOf(var0));
			return var1 == null ? RIDEABLE : var1;
		}

		static {
			h = Maps.newHashMap();
			EnumMinecartType[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				EnumMinecartType var3 = var0[var2];
				h.put(Integer.valueOf(var3.a()), var3);
			}

		}
	}
}
