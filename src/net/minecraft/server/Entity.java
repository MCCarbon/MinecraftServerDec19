package net.minecraft.server;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;

public abstract class Entity implements class_m {

	private static final int FLAGS_DW_ID = DataWathcer.claimId(Entity.class); // value = 0
	private static final int AIR_DW_ID = DataWathcer.claimId(Entity.class); // value = 1
	private static final int NAMETAG_DW_ID = DataWathcer.claimId(Entity.class); // value = 2
	private static final int NAMETAG_VISIBLE_DW_ID = DataWathcer.claimId(Entity.class); // value = 3
	private static final int SILENT_DW_ID = DataWathcer.claimId(Entity.class); // value = 4
	private static final AxisAlignedBB a = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
	private static int entityCount;

	private int c;
	public double j;
	public boolean k;
	public Entity passenger;
	public Entity vehicle;
	public boolean attachedToPlayer;
	public World world;
	public double lastX;
	public double lastY;
	public double lastZ;
	public double locX;
	public double locY;
	public double locZ;
	public double motX;
	public double motY;
	public double motZ;
	public float yaw;
	public float pitch;
	public float lastYaw;
	public float lastPitch;
	private AxisAlignedBB boundingBox;
	public boolean onGround;
	public boolean positionChanged;
	public boolean E;
	public boolean F;
	public boolean velocityChanged;
	protected boolean H;
	private boolean g;
	public boolean dead;
	public float width;
	public float length;
	public float L;
	public float M;
	public float N;
	public float fallDistance;
	private int h;
	public double P;
	public double Q;
	public double R;
	public float S;
	public boolean noclip;
	public float U;
	protected Random random;
	public int ticksLived;
	public int maxFireTicks;
	private int fireTicks;
	protected boolean inWater;
	public int noDamageTicks;
	protected boolean justCreated;
	protected boolean fireProof;
	protected DataWathcer datawatcher;
	private double ax;
	private double ay;
	public boolean ad;
	public int ae;
	public int af;
	public int ag;
	public boolean ah;
	public boolean ai;
	public int portalCooldown;
	protected boolean ak;
	protected int al;
	public int dimension;
	protected BlockPosition an;
	protected Vec3D ao;
	protected EnumDirection ap;
	private boolean invulnerable;
	protected UUID uniqueID;
	private final CommandObjectiveExecutor aA;
	private final List aB;
	protected boolean glowing;

	public int getId() {
		return this.c;
	}

	public void e(int var1) {
		this.c = var1;
	}

	public void G() {
		this.J();
	}

	public Entity(World var1) {
		this.c = entityCount++;
		this.j = 1.0D;
		this.boundingBox = a;
		this.width = 0.6F;
		this.length = 1.8F;
		this.h = 1;
		this.random = new Random();
		this.maxFireTicks = 1;
		this.justCreated = true;
		this.uniqueID = MathHelper.getRandomUUID(this.random);
		this.aA = new CommandObjectiveExecutor();
		this.aB = Lists.newArrayList();
		this.world = var1;
		this.b(0.0D, 0.0D, 0.0D);
		if (var1 != null) {
			this.dimension = var1.worldProvider.p().a();
		}

		this.datawatcher = new DataWathcer(this);
		this.datawatcher.add(FLAGS_DW_ID, Byte.valueOf((byte) 0));
		this.datawatcher.add(AIR_DW_ID, Short.valueOf((short) 300));
		this.datawatcher.add(NAMETAG_VISIBLE_DW_ID, Byte.valueOf((byte) 0));
		this.datawatcher.add(NAMETAG_DW_ID, "");
		this.datawatcher.add(SILENT_DW_ID, Byte.valueOf((byte) 0));
		this.initDatawatcher();
	}

	protected abstract void initDatawatcher();

	public DataWathcer H() {
		return this.datawatcher;
	}

	public boolean equals(Object var1) {
		return var1 instanceof Entity ? ((Entity) var1).c == this.c : false;
	}

	public int hashCode() {
		return this.c;
	}

	public void J() {
		this.dead = true;
	}

	protected void a(float var1, float var2) {
		if (var1 != this.width || var2 != this.length) {
			float var3 = this.width;
			this.width = var1;
			this.length = var2;
			this.a(new AxisAlignedBB(this.aT().xMin, this.aT().yMin, this.aT().zMin, this.aT().xMin + (double) this.width, this.aT().yMin + (double) this.length, this.aT().zMin + (double) this.width));
			if (this.width > var3 && !this.justCreated && !this.world.isClientSide) {
				this.d((double) (var3 - this.width), 0.0D, (double) (var3 - this.width));
			}
		}

	}

	protected void b(float var1, float var2) {
		this.yaw = var1 % 360.0F;
		this.pitch = var2 % 360.0F;
	}

	public void b(double var1, double var3, double var5) {
		this.locX = var1;
		this.locY = var3;
		this.locZ = var5;
		float var7 = this.width / 2.0F;
		float var8 = this.length;
		this.a(new AxisAlignedBB(var1 - (double) var7, var3, var5 - (double) var7, var1 + (double) var7, var3 + (double) var8, var5 + (double) var7));
	}

	public void t_() {
		if (!this.world.isClientSide) {
			this.b(6, this.az());
		}

		this.K();
	}

	public void K() {
		this.world.B.a("entityBaseTick");
		if (this.vehicle != null && this.vehicle.dead) {
			this.vehicle = null;
		}

		this.L = this.M;
		this.lastX = this.locX;
		this.lastY = this.locY;
		this.lastZ = this.locZ;
		this.lastPitch = this.pitch;
		this.lastYaw = this.yaw;
		if (!this.world.isClientSide && this.world instanceof WorldServer) {
			this.world.B.a("portal");
			MinecraftServer var1 = ((WorldServer) this.world).s();
			int var2 = this.L();
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

		this.Y();
		this.W();
		if (this.world.isClientSide) {
			this.fireTicks = 0;
		} else if (this.fireTicks > 0) {
			if (this.fireProof) {
				this.fireTicks -= 4;
				if (this.fireTicks < 0) {
					this.fireTicks = 0;
				}
			} else {
				if (this.fireTicks % 20 == 0) {
					this.damageEntity(DamageSource.c, 1.0F);
				}

				--this.fireTicks;
			}
		}

		if (this.ab()) {
			this.M();
			this.fallDistance *= 0.5F;
		}

		if (this.locY < -64.0D) {
			this.O();
		}

		if (!this.world.isClientSide) {
			this.b(0, this.fireTicks > 0);
		}

		this.justCreated = false;
		this.world.B.b();
	}

	public int L() {
		return 0;
	}

	protected void M() {
		if (!this.fireProof) {
			this.damageEntity(DamageSource.d, 4.0F);
			this.f(15);
		}
	}

	public void f(int var1) {
		int var2 = var1 * 20;
		if (this instanceof EntityLiving) {
			var2 = class_ads.a((EntityLiving) this, var2);
		}

		if (this.fireTicks < var2) {
			this.fireTicks = var2;
		}

	}

	public void N() {
		this.fireTicks = 0;
	}

	protected void O() {
		this.J();
	}

	public boolean c(double var1, double var3, double var5) {
		AxisAlignedBB var7 = this.aT().c(var1, var3, var5);
		return this.b(var7);
	}

	private boolean b(AxisAlignedBB var1) {
		return this.world.a(this, var1).isEmpty() && !this.world.d(var1);
	}

	public void d(double var1, double var3, double var5) {
		if (this.noclip) {
			this.a(this.aT().c(var1, var3, var5));
			this.m();
		} else {
			this.world.B.a("move");
			double var7 = this.locX;
			double var9 = this.locY;
			double var11 = this.locZ;
			if (this.H) {
				this.H = false;
				var1 *= 0.25D;
				var3 *= 0.05000000074505806D;
				var5 *= 0.25D;
				this.motX = 0.0D;
				this.motY = 0.0D;
				this.motZ = 0.0D;
			}

			double var13 = var1;
			double var15 = var3;
			double var17 = var5;
			boolean var19 = this.onGround && this.ax() && this instanceof EntityHuman;
			if (var19) {
				double var20;
				for (var20 = 0.05D; var1 != 0.0D && this.world.a(this, this.aT().c(var1, -1.0D, 0.0D)).isEmpty(); var13 = var1) {
					if (var1 < var20 && var1 >= -var20) {
						var1 = 0.0D;
					} else if (var1 > 0.0D) {
						var1 -= var20;
					} else {
						var1 += var20;
					}
				}

				for (; var5 != 0.0D && this.world.a(this, this.aT().c(0.0D, -1.0D, var5)).isEmpty(); var17 = var5) {
					if (var5 < var20 && var5 >= -var20) {
						var5 = 0.0D;
					} else if (var5 > 0.0D) {
						var5 -= var20;
					} else {
						var5 += var20;
					}
				}

				for (; var1 != 0.0D && var5 != 0.0D && this.world.a(this, this.aT().c(var1, -1.0D, var5)).isEmpty(); var17 = var5) {
					if (var1 < var20 && var1 >= -var20) {
						var1 = 0.0D;
					} else if (var1 > 0.0D) {
						var1 -= var20;
					} else {
						var1 += var20;
					}

					var13 = var1;
					if (var5 < var20 && var5 >= -var20) {
						var5 = 0.0D;
					} else if (var5 > 0.0D) {
						var5 -= var20;
					} else {
						var5 += var20;
					}
				}
			}

			List var53 = this.world.a(this, this.aT().add(var1, var3, var5));
			AxisAlignedBB var21 = this.aT();

			AxisAlignedBB var23;
			for (Iterator var22 = var53.iterator(); var22.hasNext(); var3 = var23.b(this.aT(), var3)) {
				var23 = (AxisAlignedBB) var22.next();
			}

			this.a(this.aT().c(0.0D, var3, 0.0D));
			boolean var54 = this.onGround || var15 != var3 && var15 < 0.0D;

			AxisAlignedBB var24;
			Iterator var55;
			for (var55 = var53.iterator(); var55.hasNext(); var1 = var24.a(this.aT(), var1)) {
				var24 = (AxisAlignedBB) var55.next();
			}

			this.a(this.aT().c(var1, 0.0D, 0.0D));

			for (var55 = var53.iterator(); var55.hasNext(); var5 = var24.c(this.aT(), var5)) {
				var24 = (AxisAlignedBB) var55.next();
			}

			this.a(this.aT().c(0.0D, 0.0D, var5));
			if (this.S > 0.0F && var54 && (var13 != var1 || var17 != var5)) {
				double var56 = var1;
				double var25 = var3;
				double var27 = var5;
				AxisAlignedBB var29 = this.aT();
				this.a(var21);
				var3 = (double) this.S;
				List var30 = this.world.a(this, this.aT().add(var13, var3, var17));
				AxisAlignedBB var31 = this.aT();
				AxisAlignedBB var32 = var31.add(var13, 0.0D, var17);
				double var33 = var3;

				AxisAlignedBB var36;
				for (Iterator var35 = var30.iterator(); var35.hasNext(); var33 = var36.b(var32, var33)) {
					var36 = (AxisAlignedBB) var35.next();
				}

				var31 = var31.c(0.0D, var33, 0.0D);
				double var67 = var13;

				AxisAlignedBB var38;
				for (Iterator var37 = var30.iterator(); var37.hasNext(); var67 = var38.a(var31, var67)) {
					var38 = (AxisAlignedBB) var37.next();
				}

				var31 = var31.c(var67, 0.0D, 0.0D);
				double var68 = var17;

				AxisAlignedBB var40;
				for (Iterator var39 = var30.iterator(); var39.hasNext(); var68 = var40.c(var31, var68)) {
					var40 = (AxisAlignedBB) var39.next();
				}

				var31 = var31.c(0.0D, 0.0D, var68);
				AxisAlignedBB var69 = this.aT();
				double var70 = var3;

				AxisAlignedBB var43;
				for (Iterator var42 = var30.iterator(); var42.hasNext(); var70 = var43.b(var69, var70)) {
					var43 = (AxisAlignedBB) var42.next();
				}

				var69 = var69.c(0.0D, var70, 0.0D);
				double var71 = var13;

				AxisAlignedBB var45;
				for (Iterator var44 = var30.iterator(); var44.hasNext(); var71 = var45.a(var69, var71)) {
					var45 = (AxisAlignedBB) var44.next();
				}

				var69 = var69.c(var71, 0.0D, 0.0D);
				double var72 = var17;

				AxisAlignedBB var47;
				for (Iterator var46 = var30.iterator(); var46.hasNext(); var72 = var47.c(var69, var72)) {
					var47 = (AxisAlignedBB) var46.next();
				}

				var69 = var69.c(0.0D, 0.0D, var72);
				double var73 = var67 * var67 + var68 * var68;
				double var48 = var71 * var71 + var72 * var72;
				if (var73 > var48) {
					var1 = var67;
					var5 = var68;
					var3 = -var33;
					this.a(var31);
				} else {
					var1 = var71;
					var5 = var72;
					var3 = -var70;
					this.a(var69);
				}

				AxisAlignedBB var51;
				for (Iterator var50 = var30.iterator(); var50.hasNext(); var3 = var51.b(this.aT(), var3)) {
					var51 = (AxisAlignedBB) var50.next();
				}

				this.a(this.aT().c(0.0D, var3, 0.0D));
				if (var56 * var56 + var27 * var27 >= var1 * var1 + var5 * var5) {
					var1 = var56;
					var3 = var25;
					var5 = var27;
					this.a(var29);
				}
			}

			this.world.B.b();
			this.world.B.a("rest");
			this.m();
			this.positionChanged = var13 != var1 || var17 != var5;
			this.E = var15 != var3;
			this.onGround = this.E && var15 < 0.0D;
			this.F = this.positionChanged || this.E;
			int var57 = MathHelper.floor(this.locX);
			int var58 = MathHelper.floor(this.locY - 0.20000000298023224D);
			int var59 = MathHelper.floor(this.locZ);
			BlockPosition var26 = new BlockPosition(var57, var58, var59);
			Block var60 = this.world.getType(var26).getBlock();
			if (var60.getMaterial() == Material.AIR) {
				Block var28 = this.world.getType(var26.down()).getBlock();
				if (var28 instanceof BlockFence || var28 instanceof BlockCobbleWall || var28 instanceof BlockFenceGate) {
					var60 = var28;
					var26 = var26.down();
				}
			}

			this.a(var3, this.onGround, var60, var26);
			if (var13 != var1) {
				this.motX = 0.0D;
			}

			if (var17 != var5) {
				this.motZ = 0.0D;
			}

			if (var15 != var3) {
				var60.landOn(this.world, this);
			}

			if (this.s_() && !var19 && this.vehicle == null) {
				double var61 = this.locX - var7;
				double var64 = this.locY - var9;
				double var66 = this.locZ - var11;
				if (var60 != Blocks.LADDER) {
					var64 = 0.0D;
				}

				if (var60 != null && this.onGround) {
					var60.onCollide(this.world, var26, this);
				}

				this.M = (float) ((double) this.M + (double) MathHelper.sqrt(var61 * var61 + var66 * var66) * 0.6D);
				this.N = (float) ((double) this.N + (double) MathHelper.sqrt(var61 * var61 + var64 * var64 + var66 * var66) * 0.6D);
				if (this.N > (float) this.h && var60.getMaterial() != Material.AIR) {
					this.h = (int) this.N + 1;
					if (this.V()) {
						float var34 = MathHelper.sqrt(this.motX * this.motX * 0.20000000298023224D + this.motY * this.motY + this.motZ * this.motZ * 0.20000000298023224D) * 0.35F;
						if (var34 > 1.0F) {
							var34 = 1.0F;
						}

						this.a(this.P(), var34, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
					}

					this.a(var26, var60);
				}
			}

			try {
				this.Q();
			} catch (Throwable var52) {
				class_b var63 = class_b.a(var52, "Checking entity block collision");
				class_c var65 = var63.a("Entity being checked for collision");
				this.a(var65);
				throw new class_e(var63);
			}

			boolean var62 = this.U();
			if (this.world.e(this.aT().d(0.001D, 0.001D, 0.001D))) {
				this.g(1);
				if (!var62) {
					++this.fireTicks;
					if (this.fireTicks == 0) {
						this.f(8);
					}
				}
			} else if (this.fireTicks <= 0) {
				this.fireTicks = -this.maxFireTicks;
			}

			if (var62 && this.fireTicks > 0) {
				this.a("random.fizz", 0.7F, 1.6F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
				this.fireTicks = -this.maxFireTicks;
			}

			this.world.B.b();
		}
	}

	private void m() {
		this.locX = (this.aT().xMin + this.aT().xMax) / 2.0D;
		this.locY = this.aT().yMin;
		this.locZ = (this.aT().zMin + this.aT().zMax) / 2.0D;
	}

	protected String P() {
		return "game.neutral.swim";
	}

	protected void Q() {
		BlockPosition var1 = new BlockPosition(this.aT().xMin + 0.001D, this.aT().yMin + 0.001D, this.aT().zMin + 0.001D);
		BlockPosition var2 = new BlockPosition(this.aT().xMax - 0.001D, this.aT().yMax - 0.001D, this.aT().zMax - 0.001D);
		if (this.world.areChunksLoadedBetween(var1, var2)) {
			for (int var3 = var1.getX(); var3 <= var2.getX(); ++var3) {
				for (int var4 = var1.getY(); var4 <= var2.getY(); ++var4) {
					for (int var5 = var1.getZ(); var5 <= var2.getZ(); ++var5) {
						BlockPosition var6 = new BlockPosition(var3, var4, var5);
						IBlockData var7 = this.world.getType(var6);

						try {
							var7.getBlock().a(this.world, var6, var7, this);
						} catch (Throwable var11) {
							class_b var9 = class_b.a(var11, "Colliding entity with block");
							class_c var10 = var9.a("Block being collided with");
							class_c.a(var10, var6, var7);
							throw new class_e(var9);
						}
					}
				}
			}
		}

	}

	protected void a(BlockPosition var1, Block var2) {
		Block.Sound var3 = var2.stepSound;
		if (this.world.getType(var1.up()).getBlock() == Blocks.SNOW_LAYER) {
			var3 = Blocks.SNOW_LAYER.stepSound;
			this.a(var3.getStepSound(), var3.getVolume() * 0.15F, var3.getPitch());
		} else if (!var2.getMaterial().isLiquid()) {
			this.a(var3.getStepSound(), var3.getVolume() * 0.15F, var3.getPitch());
		}

	}

	public void a(String var1, float var2, float var3) {
		if (!this.isSilent()) {
			this.world.a(this, var1, var2, var3);
		}

	}

	public boolean isSilent() {
		return this.datawatcher.getByte(SILENT_DW_ID) == 1;
	}

	public void b(boolean var1) {
		this.datawatcher.update(SILENT_DW_ID, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	protected boolean s_() {
		return true;
	}

	protected void a(double var1, boolean var3, Block var4, BlockPosition var5) {
		if (var3) {
			if (this.fallDistance > 0.0F) {
				if (var4 != null) {
					var4.fallOn(this.world, var5, this, this.fallDistance);
				} else {
					this.e(this.fallDistance, 1.0F);
				}

				this.fallDistance = 0.0F;
			}
		} else if (var1 < 0.0D) {
			this.fallDistance = (float) ((double) this.fallDistance - var1);
		}

	}

	public AxisAlignedBB S() {
		return null;
	}

	protected void g(int var1) {
		if (!this.fireProof) {
			this.damageEntity(DamageSource.a, (float) var1);
		}

	}

	public final boolean T() {
		return this.fireProof;
	}

	public void e(float var1, float var2) {
		if (this.passenger != null) {
			this.passenger.e(var1, var2);
		}

	}

	public boolean U() {
		return this.inWater || this.world.C(new BlockPosition(this.locX, this.locY, this.locZ)) || this.world.C(new BlockPosition(this.locX, this.locY + (double) this.length, this.locZ));
	}

	public boolean V() {
		return this.inWater;
	}

	public boolean W() {
		if (this.world.a(this.aT().grow(0.0D, -0.4000000059604645D, 0.0D).d(0.001D, 0.001D, 0.001D), Material.WATER, this)) {
			if (!this.inWater && !this.justCreated) {
				this.X();
			}

			this.fallDistance = 0.0F;
			this.inWater = true;
			this.fireTicks = 0;
		} else {
			this.inWater = false;
		}

		return this.inWater;
	}

	protected void X() {
		float var1 = MathHelper.sqrt(this.motX * this.motX * 0.20000000298023224D + this.motY * this.motY + this.motZ * this.motZ * 0.20000000298023224D) * 0.2F;
		if (var1 > 1.0F) {
			var1 = 1.0F;
		}

		this.a(this.aa(), var1, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
		float var2 = (float) MathHelper.floor(this.aT().yMin);

		int var3;
		float var4;
		float var5;
		for (var3 = 0; (float) var3 < 1.0F + this.width * 20.0F; ++var3) {
			var4 = (this.random.nextFloat() * 2.0F - 1.0F) * this.width;
			var5 = (this.random.nextFloat() * 2.0F - 1.0F) * this.width;
			this.world.a(class_cy.e, this.locX + (double) var4, (double) (var2 + 1.0F), this.locZ + (double) var5, this.motX, this.motY - (double) (this.random.nextFloat() * 0.2F), this.motZ, new int[0]);
		}

		for (var3 = 0; (float) var3 < 1.0F + this.width * 20.0F; ++var3) {
			var4 = (this.random.nextFloat() * 2.0F - 1.0F) * this.width;
			var5 = (this.random.nextFloat() * 2.0F - 1.0F) * this.width;
			this.world.a(class_cy.f, this.locX + (double) var4, (double) (var2 + 1.0F), this.locZ + (double) var5, this.motX, this.motY, this.motZ, new int[0]);
		}

	}

	public void Y() {
		if (this.ay() && !this.V()) {
			this.Z();
		}

	}

	protected void Z() {
		int var1 = MathHelper.floor(this.locX);
		int var2 = MathHelper.floor(this.locY - 0.20000000298023224D);
		int var3 = MathHelper.floor(this.locZ);
		BlockPosition var4 = new BlockPosition(var1, var2, var3);
		IBlockData var5 = this.world.getType(var4);
		Block var6 = var5.getBlock();
		if (var6.getRenderType() != -1) {
			this.world.a(class_cy.L, this.locX + ((double) this.random.nextFloat() - 0.5D) * (double) this.width, this.aT().yMin + 0.1D, this.locZ + ((double) this.random.nextFloat() - 0.5D) * (double) this.width, -this.motX * 4.0D, 1.5D, -this.motZ * 4.0D, new int[] { Block.getCombinedId(var5) });
		}

	}

	protected String aa() {
		return "game.neutral.swim.splash";
	}

	public boolean a(Material var1) {
		double var2 = this.locY + (double) this.aU();
		BlockPosition var4 = new BlockPosition(this.locX, var2, this.locZ);
		IBlockData var5 = this.world.getType(var4);
		Block var6 = var5.getBlock();
		if (var6.getMaterial() == var1) {
			float var7 = BlockFluids.b(var5.getBlock().toLegacyData(var5)) - 0.11111111F;
			float var8 = (float) (var4.getY() + 1) - var7;
			boolean var9 = var2 < (double) var8;
			return !var9 && this instanceof EntityHuman ? false : var9;
		} else {
			return false;
		}
	}

	public boolean ab() {
		return this.world.a(this.aT().grow(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.LAVA);
	}

	public void a(float var1, float var2, float var3) {
		float var4 = var1 * var1 + var2 * var2;
		if (var4 >= 1.0E-4F) {
			var4 = MathHelper.sqrt(var4);
			if (var4 < 1.0F) {
				var4 = 1.0F;
			}

			var4 = var3 / var4;
			var1 *= var4;
			var2 *= var4;
			float var5 = MathHelper.sin(this.yaw * 3.1415927F / 180.0F);
			float var6 = MathHelper.cos(this.yaw * 3.1415927F / 180.0F);
			this.motX += (double) (var1 * var6 - var2 * var5);
			this.motZ += (double) (var2 * var6 + var1 * var5);
		}
	}

	public float c(float var1) {
		BlockPosition var2 = new BlockPosition(this.locX, this.locY + (double) this.aU(), this.locZ);
		return this.world.e(var2) ? this.world.o(var2) : 0.0F;
	}

	public void a(World var1) {
		this.world = var1;
	}

	public void a(double var1, double var3, double var5, float var7, float var8) {
		this.lastX = this.locX = var1;
		this.lastY = this.locY = var3;
		this.lastZ = this.locZ = var5;
		this.lastYaw = this.yaw = var7;
		this.lastPitch = this.pitch = var8;
		double var9 = (double) (this.lastYaw - var7);
		if (var9 < -180.0D) {
			this.lastYaw += 360.0F;
		}

		if (var9 >= 180.0D) {
			this.lastYaw -= 360.0F;
		}

		this.b(this.locX, this.locY, this.locZ);
		this.b(var7, var8);
	}

	public void a(BlockPosition var1, float var2, float var3) {
		this.b((double) var1.getX() + 0.5D, (double) var1.getY(), (double) var1.getZ() + 0.5D, var2, var3);
	}

	public void b(double var1, double var3, double var5, float var7, float var8) {
		this.P = this.lastX = this.locX = var1;
		this.Q = this.lastY = this.locY = var3;
		this.R = this.lastZ = this.locZ = var5;
		this.yaw = var7;
		this.pitch = var8;
		this.b(this.locX, this.locY, this.locZ);
	}

	public float g(Entity var1) {
		float var2 = (float) (this.locX - var1.locX);
		float var3 = (float) (this.locY - var1.locY);
		float var4 = (float) (this.locZ - var1.locZ);
		return MathHelper.sqrt(var2 * var2 + var3 * var3 + var4 * var4);
	}

	public double e(double var1, double var3, double var5) {
		double var7 = this.locX - var1;
		double var9 = this.locY - var3;
		double var11 = this.locZ - var5;
		return var7 * var7 + var9 * var9 + var11 * var11;
	}

	public double b(BlockPosition var1) {
		return var1.distanceSquared(this.locX, this.locY, this.locZ);
	}

	public double c(BlockPosition var1) {
		return var1.distanceSquaredFromCenter(this.locX, this.locY, this.locZ);
	}

	public double f(double var1, double var3, double var5) {
		double var7 = this.locX - var1;
		double var9 = this.locY - var3;
		double var11 = this.locZ - var5;
		return (double) MathHelper.sqrt(var7 * var7 + var9 * var9 + var11 * var11);
	}

	public double h(Entity var1) {
		double var2 = this.locX - var1.locX;
		double var4 = this.locY - var1.locY;
		double var6 = this.locZ - var1.locZ;
		return var2 * var2 + var4 * var4 + var6 * var6;
	}

	public void d(EntityHuman var1) {
	}

	public void i(Entity var1) {
		if (var1.passenger != this && var1.vehicle != this) {
			if (!var1.noclip && !this.noclip) {
				double var2 = var1.locX - this.locX;
				double var4 = var1.locZ - this.locZ;
				double var6 = MathHelper.maxAbs(var2, var4);
				if (var6 >= 0.009999999776482582D) {
					var6 = (double) MathHelper.sqrt(var6);
					var2 /= var6;
					var4 /= var6;
					double var8 = 1.0D / var6;
					if (var8 > 1.0D) {
						var8 = 1.0D;
					}

					var2 *= var8;
					var4 *= var8;
					var2 *= 0.05000000074505806D;
					var4 *= 0.05000000074505806D;
					var2 *= (double) (1.0F - this.U);
					var4 *= (double) (1.0F - this.U);
					if (this.passenger == null) {
						this.g(-var2, 0.0D, -var4);
					}

					if (var1.passenger == null) {
						var1.g(var2, 0.0D, var4);
					}
				}

			}
		}
	}

	public void g(double var1, double var3, double var5) {
		this.motX += var1;
		this.motY += var3;
		this.motZ += var5;
		this.ai = true;
	}

	protected void ac() {
		this.velocityChanged = true;
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			this.ac();
			return false;
		}
	}

	public Vec3D d(float var1) {
		if (var1 == 1.0F) {
			return this.f(this.pitch, this.yaw);
		} else {
			float var2 = this.lastPitch + (this.pitch - this.lastPitch) * var1;
			float var3 = this.lastYaw + (this.yaw - this.lastYaw) * var1;
			return this.f(var2, var3);
		}
	}

	protected final Vec3D f(float var1, float var2) {
		float var3 = MathHelper.cos(-var2 * 0.017453292F - 3.1415927F);
		float var4 = MathHelper.sin(-var2 * 0.017453292F - 3.1415927F);
		float var5 = -MathHelper.cos(-var1 * 0.017453292F);
		float var6 = MathHelper.sin(-var1 * 0.017453292F);
		return new Vec3D((double) (var4 * var5), (double) var6, (double) (var3 * var5));
	}

	public boolean ad() {
		return false;
	}

	public boolean ae() {
		return false;
	}

	public void b(Entity var1, int var2) {
	}

	public boolean c(NBTTagCompound var1) {
		String var2 = this.ag();
		if (!this.dead && var2 != null) {
			var1.put("id", var2);
			this.e(var1);
			return true;
		} else {
			return false;
		}
	}

	public boolean d(NBTTagCompound var1) {
		String var2 = this.ag();
		if (!this.dead && var2 != null && this.passenger == null) {
			var1.put("id", var2);
			this.e(var1);
			return true;
		} else {
			return false;
		}
	}

	public void e(NBTTagCompound var1) {
		try {
			var1.put((String) "Pos", (NBTTag) this.a(new double[] { this.locX, this.locY, this.locZ }));
			var1.put((String) "Motion", (NBTTag) this.a(new double[] { this.motX, this.motY, this.motZ }));
			var1.put((String) "Rotation", (NBTTag) this.a(new float[] { this.yaw, this.pitch }));
			var1.put("FallDistance", this.fallDistance);
			var1.put("Fire", (short) this.fireTicks);
			var1.put("Air", (short) this.aB());
			var1.put("OnGround", this.onGround);
			var1.put("Dimension", this.dimension);
			var1.put("Invulnerable", this.invulnerable);
			var1.put("PortalCooldown", this.portalCooldown);
			var1.put("UUID", this.getUniqueId());
			if (this.getCustomName() != null && !this.getCustomName().isEmpty()) {
				var1.put("CustomName", this.getCustomName());
				var1.put("CustomNameVisible", this.isCustomNameVisible());
			}

			this.aA.b(var1);
			if (this.isSilent()) {
				var1.put("Silent", this.isSilent());
			}

			if (this.glowing) {
				var1.put("Glowing", this.glowing);
			}

			this.write(var1);
			if (this.vehicle != null) {
				NBTTagCompound var2 = new NBTTagCompound();
				if (this.vehicle.c(var2)) {
					var1.put((String) "Riding", (NBTTag) var2);
				}
			}

		} catch (Throwable var5) {
			class_b var3 = class_b.a(var5, "Saving entity NBT");
			class_c var4 = var3.a("Entity being saved");
			this.a(var4);
			throw new class_e(var3);
		}
	}

	public void f(NBTTagCompound var1) {
		try {
			NBTTagList var2 = var1.getList("Pos", 6);
			NBTTagList var7 = var1.getList("Motion", 6);
			NBTTagList var8 = var1.getList("Rotation", 5);
			this.motX = var7.getDouble(0);
			this.motY = var7.getDouble(1);
			this.motZ = var7.getDouble(2);
			if (Math.abs(this.motX) > 10.0D) {
				this.motX = 0.0D;
			}

			if (Math.abs(this.motY) > 10.0D) {
				this.motY = 0.0D;
			}

			if (Math.abs(this.motZ) > 10.0D) {
				this.motZ = 0.0D;
			}

			this.lastX = this.P = this.locX = var2.getDouble(0);
			this.lastY = this.Q = this.locY = var2.getDouble(1);
			this.lastZ = this.R = this.locZ = var2.getDouble(2);
			this.lastYaw = this.yaw = var8.getFloat(0);
			this.lastPitch = this.pitch = var8.getFloat(1);
			this.f(this.yaw);
			this.g(this.yaw);
			this.fallDistance = var1.getFloat("FallDistance");
			this.fireTicks = var1.getShort("Fire");
			this.i(var1.getShort("Air"));
			this.onGround = var1.getBoolean("OnGround");
			this.dimension = var1.getInt("Dimension");
			this.invulnerable = var1.getBoolean("Invulnerable");
			this.portalCooldown = var1.getInt("PortalCooldown");
			UUID var5 = var1.getUUID("UUID");
			if (var5 != null) {
				this.uniqueID = var5;
			} else if (var1.hasOfType("UUID", 8)) {
				this.uniqueID = UUID.fromString(var1.getString("UUID"));
			}

			this.b(this.locX, this.locY, this.locZ);
			this.b(this.yaw, this.pitch);
			if (var1.hasOfType("CustomName", 8) && !var1.getString("CustomName").isEmpty()) {
				this.a(var1.getString("CustomName"));
			}

			this.g(var1.getBoolean("CustomNameVisible"));
			this.aA.a(var1);
			this.b(var1.getBoolean("Silent"));
			this.glowing = var1.getBoolean("Glowing");
			this.read(var1);
			if (this.af()) {
				this.b(this.locX, this.locY, this.locZ);
			}

		} catch (Throwable var6) {
			class_b var3 = class_b.a(var6, "Loading entity NBT");
			class_c var4 = var3.a("Entity being loaded");
			this.a(var4);
			throw new class_e(var3);
		}
	}

	protected boolean af() {
		return true;
	}

	protected final String ag() {
		return EntityTypes.b(this);
	}

	protected abstract void read(NBTTagCompound var1);

	protected abstract void write(NBTTagCompound var1);

	public void ah() {
	}

	protected NBTTagList a(double... var1) {
		NBTTagList var2 = new NBTTagList();
		double[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			double var6 = var3[var5];
			var2.add((NBTTag) (new NBTTagDouble(var6)));
		}

		return var2;
	}

	protected NBTTagList a(float... var1) {
		NBTTagList var2 = new NBTTagList();
		float[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			float var6 = var3[var5];
			var2.add((NBTTag) (new NBTTagFloat(var6)));
		}

		return var2;
	}

	public EntityItem a(Item var1, int var2) {
		return this.a(var1, var2, 0.0F);
	}

	public EntityItem a(Item var1, int var2, float var3) {
		return this.a(new ItemStack(var1, var2, 0), var3);
	}

	public EntityItem a(ItemStack var1, float var2) {
		if (var1.count != 0 && var1.getItem() != null) {
			EntityItem var3 = new EntityItem(this.world, this.locX, this.locY + (double) var2, this.locZ, var1);
			var3.setPickupDelay();
			this.world.addEntity((Entity) var3);
			return var3;
		} else {
			return null;
		}
	}

	public boolean isAlive() {
		return !this.dead;
	}

	public boolean aj() {
		if (this.noclip) {
			return false;
		} else {
			BlockPosition.MutableBlockPosition var1 = new BlockPosition.MutableBlockPosition(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

			for (int var2 = 0; var2 < 8; ++var2) {
				int var3 = MathHelper.floor(this.locY + (double) (((float) ((var2 >> 0) % 2) - 0.5F) * 0.1F) + (double) this.aU());
				int var4 = MathHelper.floor(this.locX + (double) (((float) ((var2 >> 1) % 2) - 0.5F) * this.width * 0.8F));
				int var5 = MathHelper.floor(this.locZ + (double) (((float) ((var2 >> 2) % 2) - 0.5F) * this.width * 0.8F));
				if (var1.getX() != var4 || var1.getY() != var3 || var1.getZ() != var5) {
					var1.setPosition(var4, var3, var5);
					if (this.world.getType(var1).getBlock().isVisuallyOpaque()) {
						return true;
					}
				}
			}

			return false;
		}
	}

	public boolean a(EntityHuman var1, ItemStack var2, EnumUsedHand var3) {
		return false;
	}

	public AxisAlignedBB j(Entity var1) {
		return null;
	}

	public void ak() {
		if (this.vehicle.dead) {
			this.vehicle = null;
		} else {
			this.motX = 0.0D;
			this.motY = 0.0D;
			this.motZ = 0.0D;
			this.t_();
			if (this.vehicle != null) {
				this.vehicle.al();
				this.ay += (double) (this.vehicle.yaw - this.vehicle.lastYaw);

				for (this.ax += (double) (this.vehicle.pitch - this.vehicle.lastPitch); this.ay >= 180.0D; this.ay -= 360.0D) {
					;
				}

				while (this.ay < -180.0D) {
					this.ay += 360.0D;
				}

				while (this.ax >= 180.0D) {
					this.ax -= 360.0D;
				}

				while (this.ax < -180.0D) {
					this.ax += 360.0D;
				}

				double var1 = this.ay * 0.5D;
				double var3 = this.ax * 0.5D;
				float var5 = 10.0F;
				if (var1 > (double) var5) {
					var1 = (double) var5;
				}

				if (var1 < (double) (-var5)) {
					var1 = (double) (-var5);
				}

				if (var3 > (double) var5) {
					var3 = (double) var5;
				}

				if (var3 < (double) (-var5)) {
					var3 = (double) (-var5);
				}

				this.ay -= var1;
				this.ax -= var3;
			}
		}
	}

	public void al() {
		if (this.passenger != null) {
			this.passenger.b(this.locX, this.locY + this.an() + this.passenger.am(), this.locZ);
		}
	}

	public double am() {
		return 0.0D;
	}

	public double an() {
		return (double) this.length * 0.75D;
	}

	public void a(Entity var1) {
		this.ax = 0.0D;
		this.ay = 0.0D;
		if (var1 == null) {
			if (this.vehicle != null) {
				this.b(this.vehicle.locX, this.vehicle.aT().yMin + (double) this.vehicle.length, this.vehicle.locZ, this.yaw, this.pitch);
				this.vehicle.passenger = null;
			}

			this.vehicle = null;
		} else {
			if (this.vehicle != null) {
				this.vehicle.passenger = null;
			}

			if (var1 != null) {
				for (Entity var2 = var1.vehicle; var2 != null; var2 = var2.vehicle) {
					if (var2 == this) {
						return;
					}
				}
			}

			this.vehicle = var1;
			var1.passenger = this;
		}
	}

	public float ao() {
		return 0.1F;
	}

	public Vec3D ap() {
		return null;
	}

	public void d(BlockPosition var1) {
		if (this.portalCooldown > 0) {
			this.portalCooldown = this.aq();
		} else {
			if (!this.world.isClientSide && !var1.equals(this.an)) {
				this.an = var1;
				class_anp.class_b_in_class_anp var2 = Blocks.PORTAL.f(this.world, var1);
				double var3 = var2.b().getAxis() == EnumDirection.EnumAxis.X ? (double) var2.a().getZ() : (double) var2.a().getX();
				double var5 = var2.b().getAxis() == EnumDirection.EnumAxis.X ? this.locZ : this.locX;
				var5 = Math.abs(MathHelper.c(var5 - (double) (var2.b().rotateY().getAxisDirection() == EnumDirection.EnumAxisDirection.NEGATIVE ? 1 : 0), var3, var3 - (double) var2.d()));
				double var7 = MathHelper.c(this.locY - 1.0D, (double) var2.a().getY(), (double) (var2.a().getY() - var2.e()));
				this.ao = new Vec3D(var5, var7, 0.0D);
				this.ap = var2.b();
			}

			this.ak = true;
		}
	}

	public int aq() {
		return 300;
	}

	public Iterable as() {
		return this.aB;
	}

	public Iterable at() {
		return this.aB;
	}

	public Iterable au() {
		return Iterables.concat(this.as(), this.at());
	}

	public void a(EnumWearable var1, ItemStack var2) {
	}

	public boolean av() {
		boolean var1 = this.world != null && this.world.isClientSide;
		return !this.fireProof && (this.fireTicks > 0 || var1 && this.h(0));
	}

	public boolean aw() {
		return this.vehicle != null;
	}

	public boolean ax() {
		return this.h(1);
	}

	public void c(boolean var1) {
		this.b(1, var1);
	}

	public boolean ay() {
		return this.h(3);
	}

	public void d(boolean var1) {
		this.b(3, var1);
	}

	public boolean az() {
		return this.glowing || this.world.isClientSide && this.h(6);
	}

	public boolean aA() {
		return this.h(5);
	}

	public void f(boolean var1) {
		this.b(5, var1);
	}

	protected boolean h(int var1) {
		return (this.datawatcher.getByte(FLAGS_DW_ID) & 1 << var1) != 0;
	}

	protected void b(int var1, boolean var2) {
		byte var3 = this.datawatcher.getByte(FLAGS_DW_ID);
		if (var2) {
			this.datawatcher.update(FLAGS_DW_ID, Byte.valueOf((byte) (var3 | 1 << var1)));
		} else {
			this.datawatcher.update(FLAGS_DW_ID, Byte.valueOf((byte) (var3 & ~(1 << var1))));
		}

	}

	public int aB() {
		return this.datawatcher.getShort(AIR_DW_ID);
	}

	public void i(int var1) {
		this.datawatcher.update(AIR_DW_ID, Short.valueOf((short) var1));
	}

	public void a(class_vi var1) {
		this.damageEntity(DamageSource.b, 5.0F);
		++this.fireTicks;
		if (this.fireTicks == 0) {
			this.f(8);
		}

	}

	public void a(EntityLiving var1) {
	}

	protected boolean j(double var1, double var3, double var5) {
		BlockPosition var7 = new BlockPosition(var1, var3, var5);
		double var8 = var1 - (double) var7.getX();
		double var10 = var3 - (double) var7.getY();
		double var12 = var5 - (double) var7.getZ();
		List var14 = this.world.a(this.aT());
		if (var14.isEmpty() && !this.world.u(var7)) {
			return false;
		} else {
			byte var15 = 3;
			double var16 = 9999.0D;
			if (!this.world.u(var7.west()) && var8 < var16) {
				var16 = var8;
				var15 = 0;
			}

			if (!this.world.u(var7.east()) && 1.0D - var8 < var16) {
				var16 = 1.0D - var8;
				var15 = 1;
			}

			if (!this.world.u(var7.up()) && 1.0D - var10 < var16) {
				var16 = 1.0D - var10;
				var15 = 3;
			}

			if (!this.world.u(var7.north()) && var12 < var16) {
				var16 = var12;
				var15 = 4;
			}

			if (!this.world.u(var7.south()) && 1.0D - var12 < var16) {
				var16 = 1.0D - var12;
				var15 = 5;
			}

			float var18 = this.random.nextFloat() * 0.2F + 0.1F;
			if (var15 == 0) {
				this.motX = (double) (-var18);
			}

			if (var15 == 1) {
				this.motX = (double) var18;
			}

			if (var15 == 3) {
				this.motY = (double) var18;
			}

			if (var15 == 4) {
				this.motZ = (double) (-var18);
			}

			if (var15 == 5) {
				this.motZ = (double) var18;
			}

			return true;
		}
	}

	public void aC() {
		this.H = true;
		this.fallDistance = 0.0F;
	}

	public String getName() {
		if (this.hasCustomName()) {
			return this.getCustomName();
		} else {
			String var1 = EntityTypes.b(this);
			if (var1 == null) {
				var1 = "generic";
			}

			return LocaleI18n.get("entity." + var1 + ".name");
		}
	}

	public Entity[] aD() {
		return null;
	}

	public boolean k(Entity var1) {
		return this == var1;
	}

	public float aE() {
		return 0.0F;
	}

	public void f(float var1) {
	}

	public void g(float var1) {
	}

	public boolean aF() {
		return true;
	}

	public boolean l(Entity var1) {
		return false;
	}

	public String toString() {
		return String.format("%s[\'%s\'/%d, l=\'%s\', x=%.2f, y=%.2f, z=%.2f]", new Object[] { this.getClass().getSimpleName(), this.getName(), Integer.valueOf(this.c), this.world == null ? "~NULL~" : this.world.Q().k(), Double.valueOf(this.locX), Double.valueOf(this.locY), Double.valueOf(this.locZ) });
	}

	public boolean b(DamageSource var1) {
		return this.invulnerable && var1 != DamageSource.j && !var1.u();
	}

	public void m(Entity var1) {
		this.b(var1.locX, var1.locY, var1.locZ, var1.yaw, var1.pitch);
	}

	public void n(Entity var1) {
		NBTTagCompound var2 = new NBTTagCompound();
		var1.e(var2);
		this.f(var2);
		this.portalCooldown = var1.portalCooldown;
		this.an = var1.an;
		this.ao = var1.ao;
		this.ap = var1.ap;
	}

	public void c(int var1) {
		if (!this.world.isClientSide && !this.dead) {
			this.world.B.a("changeDimension");
			MinecraftServer var2 = MinecraftServer.N();
			int var3 = this.dimension;
			WorldServer var4 = var2.getWorldServer(var3);
			WorldServer var5 = var2.getWorldServer(var1);
			this.dimension = var1;
			if (var3 == 1 && var1 == 1) {
				var5 = var2.getWorldServer(0);
				this.dimension = 0;
			}

			this.world.e(this);
			this.dead = false;
			this.world.B.a("reposition");
			var2.getPlayerList().a(this, var3, var4, var5);
			this.world.B.c("reloading");
			Entity var6 = EntityTypes.a((String) EntityTypes.b(this), (World) var5);
			if (var6 != null) {
				var6.n(this);
				if (var3 == 1 && var1 == 1) {
					BlockPosition var7 = this.world.r(var5.N());
					var6.a(var7, var6.yaw, var6.pitch);
				}

				var5.addEntity(var6);
			}

			this.dead = true;
			this.world.B.b();
			var4.k();
			var5.k();
			this.world.B.b();
		}
	}

	public float a(Explosion var1, World var2, BlockPosition var3, IBlockData var4) {
		return var4.getBlock().getResistance(this);
	}

	public boolean a(Explosion var1, World var2, BlockPosition var3, IBlockData var4, float var5) {
		return true;
	}

	public int aG() {
		return 3;
	}

	public Vec3D aI() {
		return this.ao;
	}

	public EnumDirection aJ() {
		return this.ap;
	}

	public boolean aK() {
		return false;
	}

	public void a(class_c var1) {
		var1.a("Entity Type", new Callable() {
			public String a() throws Exception {
				return EntityTypes.b(Entity.this) + " (" + Entity.this.getClass().getCanonicalName() + ")";
			}

			// $FF: synthetic method
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a((String) "Entity ID", (Object) Integer.valueOf(this.c));
		var1.a("Entity Name", new Callable() {
			public String a() throws Exception {
				return Entity.this.getName();
			}

			// $FF: synthetic method
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a((String) "Entity\'s Exact location", (Object) String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.locX), Double.valueOf(this.locY), Double.valueOf(this.locZ) }));
		var1.a((String) "Entity\'s Block location", (Object) class_c.a((double) MathHelper.floor(this.locX), (double) MathHelper.floor(this.locY), (double) MathHelper.floor(this.locZ)));
		var1.a((String) "Entity\'s Momentum", (Object) String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.motX), Double.valueOf(this.motY), Double.valueOf(this.motZ) }));
		var1.a("Entity\'s Rider", new Callable() {
			public String a() throws Exception {
				return Entity.this.passenger.toString();
			}

			// $FF: synthetic method
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a("Entity\'s Vehicle", new Callable() {
			public String a() throws Exception {
				return Entity.this.vehicle.toString();
			}

			// $FF: synthetic method
			public Object call() throws Exception {
				return this.a();
			}
		});
	}

	public UUID getUniqueId() {
		return this.uniqueID;
	}

	public boolean aN() {
		return true;
	}

	public IChatBaseComponent getScoreboardDisplayName() {
		ChatComponentText var1 = new ChatComponentText(this.getName());
		var1.getChatModifier().a(this.aS());
		var1.getChatModifier().a(this.getUniqueId().toString());
		return var1;
	}

	public void a(String var1) {
		this.datawatcher.update(NAMETAG_DW_ID, var1);
	}

	public String getCustomName() {
		return this.datawatcher.getString(NAMETAG_DW_ID);
	}

	public boolean hasCustomName() {
		return !this.datawatcher.getString(NAMETAG_DW_ID).isEmpty();
	}

	public void g(boolean var1) {
		this.datawatcher.update(NAMETAG_VISIBLE_DW_ID, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	public boolean isCustomNameVisible() {
		return this.datawatcher.getByte(NAMETAG_VISIBLE_DW_ID) == 1;
	}

	public void a(double var1, double var3, double var5) {
		this.b(var1, var3, var5, this.yaw, this.pitch);
	}

	public void d(int var1) {
	}

	public EnumDirection aR() {
		return EnumDirection.getByHorizontalId(MathHelper.floor((double) (this.yaw * 4.0F / 360.0F) + 0.5D) & 3);
	}

	protected class_ew aS() {
		NBTTagCompound var1 = new NBTTagCompound();
		String var2 = EntityTypes.b(this);
		var1.put("id", this.getUniqueId().toString());
		if (var2 != null) {
			var1.put("type", var2);
		}

		var1.put("name", this.getName());
		return new class_ew(class_ew.class_a_in_class_ew.d, new ChatComponentText(var1.toString()));
	}

	public boolean a(EntityPlayer var1) {
		return true;
	}

	public AxisAlignedBB aT() {
		return this.boundingBox;
	}

	public void a(AxisAlignedBB var1) {
		this.boundingBox = var1;
	}

	public float aU() {
		return this.length * 0.85F;
	}

	public boolean aV() {
		return this.g;
	}

	public void h(boolean var1) {
		this.g = var1;
	}

	public boolean c(int var1, ItemStack var2) {
		return false;
	}

	public void a(IChatBaseComponent var1) {
	}

	public boolean a(int var1, String var2) {
		return true;
	}

	public BlockPosition c() {
		return new BlockPosition(this.locX, this.locY + 0.5D, this.locZ);
	}

	public Vec3D d() {
		return new Vec3D(this.locX, this.locY, this.locZ);
	}

	public World e() {
		return this.world;
	}

	public Entity f() {
		return this;
	}

	public boolean u_() {
		return false;
	}

	public void a(CommandObjectiveExecutor.class_a_in_class_n var1, int var2) {
		this.aA.a(this, var1, var2);
	}

	public CommandObjectiveExecutor aW() {
		return this.aA;
	}

	public void o(Entity var1) {
		this.aA.a(var1.aW());
	}

	public UseResult a(EntityHuman var1, Vec3D var2, ItemStack var3, EnumUsedHand var4) {
		return UseResult.CANT_USE;
	}

	public boolean aX() {
		return false;
	}

	protected void a(EntityLiving var1, Entity var2) {
		if (var2 instanceof EntityLiving) {
			EnchantmentManager.a((EntityLiving) ((EntityLiving) var2), (Entity) var1);
		}

		EnchantmentManager.b(var1, var2);
	}

	public void b(EntityPlayer var1) {
	}

	public void c(EntityPlayer var1) {
	}

	public float a(Block.EnumRotation var1) {
		float var2 = MathHelper.clampAngle(this.yaw);
		switch (Entity.SyntheticClass_1.a[var1.ordinal()]) {
			case 1:
				return var2 + 180.0F;
			case 2:
				return var2 + 270.0F;
			case 3:
				return var2 + 90.0F;
			default:
				return var2;
		}
	}

	public float a(Block.class_a_in_class_agj var1) {
		float var2 = MathHelper.clampAngle(this.yaw);
		switch (Entity.SyntheticClass_1.b[var1.ordinal()]) {
			case 1:
				return -var2;
			case 2:
				return 180.0F - var2;
			default:
				return var2;
		}
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[Block.class_a_in_class_agj.values().length];

		static {
			try {
				b[Block.class_a_in_class_agj.LEFT_RIGHT.ordinal()] = 1;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				b[Block.class_a_in_class_agj.FRONT_BACK.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			a = new int[Block.EnumRotation.values().length];

			try {
				a[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
