package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.List;

public class EntityArrow extends Entity implements class_xi {

	private static final Predicate f;
	private static final int CRITICAL_DW_ID = DataWathcer.claimId(EntityArrow.class); // value = 5

	private int h;
	private int i;
	private int as;
	private Block at;
	private int au;
	protected boolean a;
	protected int b;
	public int c;
	public int d;
	public Entity e;
	private int av;
	private int aw;
	private double ax;
	private int ay;

	public EntityArrow(World var1) {
		super(var1);
		this.h = -1;
		this.i = -1;
		this.as = -1;
		this.ax = 2.0D;
		this.j = 10.0D;
		this.a(0.5F, 0.5F);
	}

	public EntityArrow(World var1, double var2, double var4, double var6) {
		this(var1);
		this.b(var2, var4, var6);
	}

	public EntityArrow(World var1, EntityLiving var2) {
		this(var1, var2.locX, var2.locY + (double) var2.getHeadHeight() - 0.10000000149011612D, var2.locZ);
		this.e = var2;
		if (var2 instanceof EntityHuman) {
			this.c = 1;
		}

	}

	protected void initDatawatcher() {
		this.datawatcher.add(CRITICAL_DW_ID, Byte.valueOf((byte) 0));
	}

	public void a(float var1, float var2, float var3, float var4, float var5) {
		float var6 = -MathHelper.sin(var2 * 0.017453292F) * MathHelper.cos(var1 * 0.017453292F);
		float var7 = -MathHelper.sin(var1 * 0.017453292F);
		float var8 = MathHelper.cos(var2 * 0.017453292F) * MathHelper.cos(var1 * 0.017453292F);
		this.c((double) var6, (double) var7, (double) var8, var4, var5);
	}

	public void c(double var1, double var3, double var5, float var7, float var8) {
		float var9 = MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5);
		var1 /= (double) var9;
		var3 /= (double) var9;
		var5 /= (double) var9;
		var1 += this.random.nextGaussian() * 0.007499999832361937D * (double) var8;
		var3 += this.random.nextGaussian() * 0.007499999832361937D * (double) var8;
		var5 += this.random.nextGaussian() * 0.007499999832361937D * (double) var8;
		var1 *= (double) var7;
		var3 *= (double) var7;
		var5 *= (double) var7;
		this.motX = var1;
		this.motY = var3;
		this.motZ = var5;
		float var10 = MathHelper.sqrt(var1 * var1 + var5 * var5);
		this.lastYaw = this.yaw = (float) (MathHelper.b(var1, var5) * 180.0D / 3.1415927410125732D);
		this.lastPitch = this.pitch = (float) (MathHelper.b(var3, (double) var10) * 180.0D / 3.1415927410125732D);
		this.av = 0;
	}

	public void t_() {
		super.t_();
		if (this.lastPitch == 0.0F && this.lastYaw == 0.0F) {
			float var1 = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
			this.lastYaw = this.yaw = (float) (MathHelper.b(this.motX, this.motZ) * 180.0D / 3.1415927410125732D);
			this.lastPitch = this.pitch = (float) (MathHelper.b(this.motY, (double) var1) * 180.0D / 3.1415927410125732D);
		}

		BlockPosition var13 = new BlockPosition(this.h, this.i, this.as);
		IBlockData var2 = this.world.getType(var13);
		Block var3 = var2.getBlock();
		if (var3.getMaterial() != Material.AIR) {
			var3.updateShape((IBlockAccess) this.world, (BlockPosition) var13);
			AxisAlignedBB var4 = var3.getBoundingBox(this.world, var13, var2);
			if (var4 != null && var4.a(new Vec3D(this.locX, this.locY, this.locZ))) {
				this.a = true;
			}
		}

		if (this.d > 0) {
			--this.d;
		}

		if (this.a) {
			int var15 = var3.toLegacyData(var2);
			if (var3 == this.at && var15 == this.au) {
				++this.av;
				if (this.av >= 1200) {
					this.J();
				}
			} else {
				this.a = false;
				this.motX *= (double) (this.random.nextFloat() * 0.2F);
				this.motY *= (double) (this.random.nextFloat() * 0.2F);
				this.motZ *= (double) (this.random.nextFloat() * 0.2F);
				this.av = 0;
				this.aw = 0;
			}

			++this.b;
		} else {
			this.b = 0;
			++this.aw;
			Vec3D var14 = new Vec3D(this.locX, this.locY, this.locZ);
			Vec3D var5 = new Vec3D(this.locX + this.motX, this.locY + this.motY, this.locZ + this.motZ);
			MovingObjectPosition var6 = this.world.rayTrace(var14, var5, false, true, false);
			var14 = new Vec3D(this.locX, this.locY, this.locZ);
			var5 = new Vec3D(this.locX + this.motX, this.locY + this.motY, this.locZ + this.motZ);
			if (var6 != null) {
				var5 = new Vec3D(var6.c.x, var6.c.y, var6.c.z);
			}

			Entity var7 = this.a(var14, var5);
			if (var7 != null) {
				var6 = new MovingObjectPosition(var7);
			}

			if (var6 != null && var6.d != null && var6.d instanceof EntityHuman) {
				EntityHuman var8 = (EntityHuman) var6.d;
				if (var8.abilities.invulnerable || this.e instanceof EntityHuman && !((EntityHuman) this.e).a(var8)) {
					var6 = null;
				}
			}

			if (var6 != null) {
				this.a(var6);
			}

			if (this.m()) {
				for (int var16 = 0; var16 < 4; ++var16) {
					this.world.addParticle(EnumParticle.j, this.locX + this.motX * (double) var16 / 4.0D, this.locY + this.motY * (double) var16 / 4.0D, this.locZ + this.motZ * (double) var16 / 4.0D, -this.motX, -this.motY + 0.2D, -this.motZ, new int[0]);
				}
			}

			this.locX += this.motX;
			this.locY += this.motY;
			this.locZ += this.motZ;
			float var17 = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
			this.yaw = (float) (MathHelper.b(this.motX, this.motZ) * 180.0D / 3.1415927410125732D);

			for (this.pitch = (float) (MathHelper.b(this.motY, (double) var17) * 180.0D / 3.1415927410125732D); this.pitch - this.lastPitch < -180.0F; this.lastPitch -= 360.0F) {
				;
			}

			while (this.pitch - this.lastPitch >= 180.0F) {
				this.lastPitch += 360.0F;
			}

			while (this.yaw - this.lastYaw < -180.0F) {
				this.lastYaw -= 360.0F;
			}

			while (this.yaw - this.lastYaw >= 180.0F) {
				this.lastYaw += 360.0F;
			}

			this.pitch = this.lastPitch + (this.pitch - this.lastPitch) * 0.2F;
			this.yaw = this.lastYaw + (this.yaw - this.lastYaw) * 0.2F;
			float var9 = 0.99F;
			float var10 = 0.05F;
			if (this.V()) {
				for (int var11 = 0; var11 < 4; ++var11) {
					float var12 = 0.25F;
					this.world.addParticle(EnumParticle.e, this.locX - this.motX * (double) var12, this.locY - this.motY * (double) var12, this.locZ - this.motZ * (double) var12, this.motX, this.motY, this.motZ, new int[0]);
				}

				var9 = 0.6F;
			}

			if (this.U()) {
				this.N();
			}

			this.motX *= (double) var9;
			this.motY *= (double) var9;
			this.motZ *= (double) var9;
			this.motY -= (double) var10;
			this.b(this.locX, this.locY, this.locZ);
			this.Q();
		}
	}

	protected void a(MovingObjectPosition var1) {
		Entity var2 = var1.d;
		if (var2 != null) {
			float var3 = MathHelper.sqrt(this.motX * this.motX + this.motY * this.motY + this.motZ * this.motZ);
			int var4 = MathHelper.ceil((double) var3 * this.ax);
			if (this.m()) {
				var4 += this.random.nextInt(var4 / 2 + 2);
			}

			DamageSource var5;
			if (this.e == null) {
				var5 = DamageSource.a((EntityArrow) this, (Entity) this);
			} else {
				var5 = DamageSource.a(this, this.e);
			}

			if (this.av() && !(var2 instanceof EntityEnderman)) {
				var2.f(5);
			}

			if (var2.damageEntity(var5, (float) var4)) {
				if (var2 instanceof EntityLiving) {
					EntityLiving var6 = (EntityLiving) var2;
					if (!this.world.isClientSide) {
						var6.l(var6.bw() + 1);
					}

					if (this.ay > 0) {
						float var7 = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
						if (var7 > 0.0F) {
							var6.g(this.motX * (double) this.ay * 0.6000000238418579D / (double) var7, 0.1D, this.motZ * (double) this.ay * 0.6000000238418579D / (double) var7);
						}
					}

					if (this.e instanceof EntityLiving) {
						EnchantmentManager.a(var6, this.e);
						EnchantmentManager.b((EntityLiving) ((EntityLiving) this.e), (Entity) var6);
					}

					this.b(var6);
					if (this.e != null && var6 != this.e && var6 instanceof EntityHuman && this.e instanceof EntityPlayer) {
						((EntityPlayer) this.e).playerConnection.sendPacket((Packet) (new PacketPlayOutGameStateChange(6, 0.0F)));
					}
				}

				this.makeSound("random.bowhit", 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
				if (!(var2 instanceof EntityEnderman)) {
					this.J();
				}
			} else {
				this.motX *= -0.10000000149011612D;
				this.motY *= -0.10000000149011612D;
				this.motZ *= -0.10000000149011612D;
				this.yaw += 180.0F;
				this.lastYaw += 180.0F;
				this.aw = 0;
			}
		} else {
			BlockPosition var8 = var1.a();
			this.h = var8.getX();
			this.i = var8.getY();
			this.as = var8.getZ();
			IBlockData var9 = this.world.getType(var8);
			this.at = var9.getBlock();
			this.au = this.at.toLegacyData(var9);
			this.motX = (double) ((float) (var1.c.x - this.locX));
			this.motY = (double) ((float) (var1.c.y - this.locY));
			this.motZ = (double) ((float) (var1.c.z - this.locZ));
			float var10 = MathHelper.sqrt(this.motX * this.motX + this.motY * this.motY + this.motZ * this.motZ);
			this.locX -= this.motX / (double) var10 * 0.05000000074505806D;
			this.locY -= this.motY / (double) var10 * 0.05000000074505806D;
			this.locZ -= this.motZ / (double) var10 * 0.05000000074505806D;
			this.makeSound("random.bowhit", 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
			this.a = true;
			this.d = 7;
			this.a(false);
			if (this.at.getMaterial() != Material.AIR) {
				this.at.a((World) this.world, var8, (IBlockData) var9, (Entity) this);
			}
		}

	}

	protected void b(EntityLiving var1) {
	}

	protected Entity a(Vec3D var1, Vec3D var2) {
		Entity var3 = null;
		List var4 = this.world.a((Entity) this, (AxisAlignedBB) this.getBoundingBox().add(this.motX, this.motY, this.motZ).grow(1.0D, 1.0D, 1.0D), (Predicate) f);
		double var5 = 0.0D;

		for (int var7 = 0; var7 < var4.size(); ++var7) {
			Entity var8 = (Entity) var4.get(var7);
			if (var8 != this.e || this.aw >= 5) {
				float var9 = 0.3F;
				AxisAlignedBB var10 = var8.getBoundingBox().grow((double) var9, (double) var9, (double) var9);
				MovingObjectPosition var11 = var10.a(var1, var2);
				if (var11 != null) {
					double var12 = var1.distanceSquared(var11.c);
					if (var12 < var5 || var5 == 0.0D) {
						var3 = var8;
						var5 = var12;
					}
				}
			}
		}

		return var3;
	}

	public void write(NBTTagCompound var1) {
		var1.put("xTile", (short) this.h);
		var1.put("yTile", (short) this.i);
		var1.put("zTile", (short) this.as);
		var1.put("life", (short) this.av);
		MinecraftKey var2 = (MinecraftKey) Block.BLOCK_REGISTRY.getKey(this.at);
		var1.put("inTile", var2 == null ? "" : var2.toString());
		var1.put("inData", (byte) this.au);
		var1.put("shake", (byte) this.d);
		var1.put("inGround", (byte) (this.a ? 1 : 0));
		var1.put("pickup", (byte) this.c);
		var1.put("damage", this.ax);
	}

	public void read(NBTTagCompound var1) {
		this.h = var1.getShort("xTile");
		this.i = var1.getShort("yTile");
		this.as = var1.getShort("zTile");
		this.av = var1.getShort("life");
		if (var1.hasOfType("inTile", 8)) {
			this.at = Block.getByName(var1.getString("inTile"));
		} else {
			this.at = Block.getById(var1.getByte("inTile") & 255);
		}

		this.au = var1.getByte("inData") & 255;
		this.d = var1.getByte("shake") & 255;
		this.a = var1.getByte("inGround") == 1;
		if (var1.hasOfType("damage", 99)) {
			this.ax = var1.getDouble("damage");
		}

		if (var1.hasOfType("pickup", 99)) {
			this.c = var1.getByte("pickup");
		} else if (var1.hasOfType("player", 99)) {
			this.c = var1.getBoolean("player") ? 1 : 0;
		}

	}

	public void d(EntityHuman var1) {
		if (!this.world.isClientSide && this.a && this.d <= 0) {
			boolean var2 = this.c == 1 || this.c == 2 && var1.abilities.instabuild;
			if (this.c == 1 && !var1.inventory.a(this.j())) {
				var2 = false;
			}

			if (var2) {
				this.makeSound("random.pop", 0.2F, ((this.random.nextFloat() - this.random.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				var1.a(this, 1);
				this.J();
			}

		}
	}

	protected ItemStack j() {
		return new ItemStack(Items.ARROW);
	}

	protected boolean s_() {
		return false;
	}

	public void b(double var1) {
		this.ax = var1;
	}

	public double l() {
		return this.ax;
	}

	public void a(int var1) {
		this.ay = var1;
	}

	public boolean aF() {
		return false;
	}

	public float getHeadHeight() {
		return 0.0F;
	}

	public void a(boolean var1) {
		byte var2 = this.datawatcher.getByte(CRITICAL_DW_ID);
		if (var1) {
			this.datawatcher.update(CRITICAL_DW_ID, Byte.valueOf((byte) (var2 | 1)));
		} else {
			this.datawatcher.update(CRITICAL_DW_ID, Byte.valueOf((byte) (var2 & -2)));
		}

	}

	public boolean m() {
		byte var1 = this.datawatcher.getByte(CRITICAL_DW_ID);
		return (var1 & 1) != 0;
	}

	static {
		f = Predicates.and(new Predicate[] { IEntitySelector.NOT_PLAYER_SPECTATOR, IEntitySelector.IS_ALIVE, new Predicate() {
			public boolean a(Entity var1) {
				return var1.ad();
			}

				// $FF: synthetic method
			public boolean apply(Object var1) {
				return this.a((Entity) var1);
			}
		} });
	}
}
