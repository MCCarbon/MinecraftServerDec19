package net.minecraft.server;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class EntityArrow extends Entity implements IProjectile {

	@SuppressWarnings("unchecked")
	private static final Predicate<Entity> TARGET_ENTITY_SELECTOR = Predicates.and(IEntitySelector.NOT_PLAYER_SPECTATOR, IEntitySelector.IS_ALIVE, new Predicate<Entity>() {
		public boolean apply(Entity entity) {
			return entity.ad();
		}
	});
	private static final int CRITICAL_DW_ID = DataWathcer.claimId(EntityArrow.class); // value = 5

	private int hitBlockX;
	private int hitBlockY;
	private int hitBlockZ;
	private Block hitBlockId;
	private int hitBlockData;
	protected boolean inGround;
	protected int ticksInGround;
	public int fromPlayer;
	public int shake;
	public Entity shooter;
	private int life;
	private int ticksInAir;
	private double damage;
	private int knockbackStrength;

	public EntityArrow(World world) {
		super(world);
		this.hitBlockX = -1;
		this.hitBlockY = -1;
		this.hitBlockZ = -1;
		this.damage = 2.0D;
		this.j = 10.0D;
		this.setSize(0.5F, 0.5F);
	}

	public EntityArrow(World world, double x, double y, double z) {
		this(world);
		this.setPosition(x, y, z);
	}

	public EntityArrow(World world, EntityLiving entity) {
		this(world, entity.locX, (entity.locY + entity.getHeadHeight()) - 0.10000000149011612D, entity.locZ);
		this.shooter = entity;
		if (entity instanceof EntityHuman) {
			this.fromPlayer = 1;
		}
	}

	@Override
	protected void initDatawatcher() {
		this.datawatcher.add(CRITICAL_DW_ID, Byte.valueOf((byte) 0));
	}

	public void startShoot(float aX, float aY, float aZ, float f1, float f2) {
		float mX = -MathHelper.sin(aY * 0.017453292F) * MathHelper.cos(aX * 0.017453292F);
		float mY = -MathHelper.sin(aX * 0.017453292F);
		float mZ = MathHelper.cos(aY * 0.017453292F) * MathHelper.cos(aX * 0.017453292F);
		this.shoot(mX, mY, mZ, f1, f2);
	}

	@Override
	public void shoot(double mX, double mY, double mZ, float f1, float f2) {
		float var9 = MathHelper.sqrt((mX * mX) + (mY * mY) + (mZ * mZ));
		mX /= var9;
		mY /= var9;
		mZ /= var9;
		mX += this.random.nextGaussian() * 0.007499999832361937D * f2;
		mY += this.random.nextGaussian() * 0.007499999832361937D * f2;
		mZ += this.random.nextGaussian() * 0.007499999832361937D * f2;
		mX *= f1;
		mY *= f1;
		mZ *= f1;
		this.motX = mX;
		this.motY = mY;
		this.motZ = mZ;
		float var10 = MathHelper.sqrt((mX * mX) + (mZ * mZ));
		this.lastYaw = this.yaw = (float) ((MathHelper.b(mX, mZ) * 180.0D) / 3.1415927410125732D);
		this.lastPitch = this.pitch = (float) ((MathHelper.b(mY, var10) * 180.0D) / 3.1415927410125732D);
		this.life = 0;
	}

	@Override
	public void t_() {
		super.t_();
		if ((this.lastPitch == 0.0F) && (this.lastYaw == 0.0F)) {
			float var1 = MathHelper.sqrt((this.motX * this.motX) + (this.motZ * this.motZ));
			this.lastYaw = this.yaw = (float) ((MathHelper.b(this.motX, this.motZ) * 180.0D) / 3.1415927410125732D);
			this.lastPitch = this.pitch = (float) ((MathHelper.b(this.motY, var1) * 180.0D) / 3.1415927410125732D);
		}

		BlockPosition var13 = new BlockPosition(this.hitBlockX, this.hitBlockY, this.hitBlockZ);
		IBlockData var2 = this.world.getType(var13);
		Block var3 = var2.getBlock();
		if (var3.getMaterial() != Material.AIR) {
			var3.updateShape(this.world, var13);
			AxisAlignedBB var4 = var3.getBoundingBox(this.world, var13, var2);
			if ((var4 != null) && var4.a(new Vec3D(this.locX, this.locY, this.locZ))) {
				this.inGround = true;
			}
		}

		if (this.shake > 0) {
			--this.shake;
		}

		if (this.inGround) {
			int var15 = var3.toLegacyData(var2);
			if ((var3 == this.hitBlockId) && (var15 == this.hitBlockData)) {
				++this.life;
				if (this.life >= 1200) {
					this.die();
				}
			} else {
				this.inGround = false;
				this.motX *= this.random.nextFloat() * 0.2F;
				this.motY *= this.random.nextFloat() * 0.2F;
				this.motZ *= this.random.nextFloat() * 0.2F;
				this.life = 0;
				this.ticksInAir = 0;
			}

			++this.ticksInGround;
		} else {
			this.ticksInGround = 0;
			++this.ticksInAir;
			Vec3D var14 = new Vec3D(this.locX, this.locY, this.locZ);
			Vec3D var5 = new Vec3D(this.locX + this.motX, this.locY + this.motY, this.locZ + this.motZ);
			MovingObjectPosition targetPosition = this.world.rayTrace(var14, var5, false, true, false);
			var14 = new Vec3D(this.locX, this.locY, this.locZ);
			var5 = new Vec3D(this.locX + this.motX, this.locY + this.motY, this.locZ + this.motZ);
			if (targetPosition != null) {
				var5 = new Vec3D(targetPosition.pos.x, targetPosition.pos.y, targetPosition.pos.z);
			}

			Entity target = this.findTarget(var14, var5);
			if (target != null) {
				targetPosition = new MovingObjectPosition(target);
			}

			if ((targetPosition != null) && (targetPosition.entity != null) && (targetPosition.entity instanceof EntityHuman)) {
				EntityHuman var8 = (EntityHuman) targetPosition.entity;
				if (var8.abilities.invulnerable || ((this.shooter instanceof EntityHuman) && !((EntityHuman) this.shooter).a(var8))) {
					targetPosition = null;
				}
			}

			if (targetPosition != null) {
				this.hit(targetPosition);
			}

			if (this.isCritical()) {
				for (int var16 = 0; var16 < 4; ++var16) {
					this.world.addParticle(EnumParticle.j, this.locX + ((this.motX * var16) / 4.0D), this.locY + ((this.motY * var16) / 4.0D), this.locZ + ((this.motZ * var16) / 4.0D), -this.motX, -this.motY + 0.2D, -this.motZ, new int[0]);
				}
			}

			this.locX += this.motX;
			this.locY += this.motY;
			this.locZ += this.motZ;
			float var17 = MathHelper.sqrt((this.motX * this.motX) + (this.motZ * this.motZ));
			this.yaw = (float) ((MathHelper.b(this.motX, this.motZ) * 180.0D) / 3.1415927410125732D);

			for (this.pitch = (float) ((MathHelper.b(this.motY, var17) * 180.0D) / 3.1415927410125732D); (this.pitch - this.lastPitch) < -180.0F; this.lastPitch -= 360.0F) {
				;
			}

			while ((this.pitch - this.lastPitch) >= 180.0F) {
				this.lastPitch += 360.0F;
			}

			while ((this.yaw - this.lastYaw) < -180.0F) {
				this.lastYaw -= 360.0F;
			}

			while ((this.yaw - this.lastYaw) >= 180.0F) {
				this.lastYaw += 360.0F;
			}

			this.pitch = this.lastPitch + ((this.pitch - this.lastPitch) * 0.2F);
			this.yaw = this.lastYaw + ((this.yaw - this.lastYaw) * 0.2F);
			float var9 = 0.99F;
			float var10 = 0.05F;
			if (this.V()) {
				for (int var11 = 0; var11 < 4; ++var11) {
					float var12 = 0.25F;
					this.world.addParticle(EnumParticle.e, this.locX - (this.motX * var12), this.locY - (this.motY * var12), this.locZ - (this.motZ * var12), this.motX, this.motY, this.motZ, new int[0]);
				}

				var9 = 0.6F;
			}

			if (this.U()) {
				this.extinguish();
			}

			this.motX *= var9;
			this.motY *= var9;
			this.motZ *= var9;
			this.motY -= var10;
			this.setPosition(this.locX, this.locY, this.locZ);
			this.checkBlockCollisions();
		}
	}

	protected void hit(MovingObjectPosition mvpos) {
		Entity hitEntity = mvpos.entity;
		if (hitEntity != null) {
			float var3 = MathHelper.sqrt((this.motX * this.motX) + (this.motY * this.motY) + (this.motZ * this.motZ));
			int var4 = MathHelper.ceil(var3 * this.damage);
			if (this.isCritical()) {
				var4 += this.random.nextInt((var4 / 2) + 2);
			}

			DamageSource var5;
			if (this.shooter == null) {
				var5 = DamageSource.a(this, this);
			} else {
				var5 = DamageSource.a(this, this.shooter);
			}

			if (this.av() && !(hitEntity instanceof EntityEnderman)) {
				hitEntity.f(5);
			}

			if (hitEntity.damageEntity(var5, var4)) {
				if (hitEntity instanceof EntityLiving) {
					EntityLiving var6 = (EntityLiving) hitEntity;
					if (!this.world.isClientSide) {
						var6.l(var6.bw() + 1);
					}

					if (this.knockbackStrength > 0) {
						float var7 = MathHelper.sqrt((this.motX * this.motX) + (this.motZ * this.motZ));
						if (var7 > 0.0F) {
							var6.g((this.motX * this.knockbackStrength * 0.6000000238418579D) / var7, 0.1D, (this.motZ * this.knockbackStrength * 0.6000000238418579D) / var7);
						}
					}

					if (this.shooter instanceof EntityLiving) {
						EnchantmentManager.a(var6, this.shooter);
						EnchantmentManager.b(((EntityLiving) this.shooter), var6);
					}

					this.b(var6);
					if ((this.shooter != null) && (var6 != this.shooter) && (var6 instanceof EntityHuman) && (this.shooter instanceof EntityPlayer)) {
						((EntityPlayer) this.shooter).playerConnection.sendPacket((new PacketPlayOutGameStateChange(6, 0.0F)));
					}
				}

				this.makeSound("random.bowhit", 1.0F, 1.2F / ((this.random.nextFloat() * 0.2F) + 0.9F));
				if (!(hitEntity instanceof EntityEnderman)) {
					this.die();
				}
			} else {
				this.motX *= -0.10000000149011612D;
				this.motY *= -0.10000000149011612D;
				this.motZ *= -0.10000000149011612D;
				this.yaw += 180.0F;
				this.lastYaw += 180.0F;
				this.ticksInAir = 0;
			}
		} else {
			BlockPosition var8 = mvpos.a();
			this.hitBlockX = var8.getX();
			this.hitBlockY = var8.getY();
			this.hitBlockZ = var8.getZ();
			IBlockData var9 = this.world.getType(var8);
			this.hitBlockId = var9.getBlock();
			this.hitBlockData = this.hitBlockId.toLegacyData(var9);
			this.motX = ((float) (mvpos.pos.x - this.locX));
			this.motY = ((float) (mvpos.pos.y - this.locY));
			this.motZ = ((float) (mvpos.pos.z - this.locZ));
			float var10 = MathHelper.sqrt((this.motX * this.motX) + (this.motY * this.motY) + (this.motZ * this.motZ));
			this.locX -= (this.motX / var10) * 0.05000000074505806D;
			this.locY -= (this.motY / var10) * 0.05000000074505806D;
			this.locZ -= (this.motZ / var10) * 0.05000000074505806D;
			this.makeSound("random.bowhit", 1.0F, 1.2F / ((this.random.nextFloat() * 0.2F) + 0.9F));
			this.inGround = true;
			this.shake = 7;
			this.setCritical(false);
			if (this.hitBlockId.getMaterial() != Material.AIR) {
				this.hitBlockId.a(this.world, var8, var9, this);
			}
		}

	}

	protected void b(EntityLiving var1) {
	}

	protected Entity findTarget(Vec3D var1, Vec3D var2) {
		Entity var3 = null;
		List var4 = this.world.a(this, this.getBoundingBox().add(this.motX, this.motY, this.motZ).grow(1.0D, 1.0D, 1.0D), TARGET_ENTITY_SELECTOR);
		double var5 = 0.0D;

		for (int var7 = 0; var7 < var4.size(); ++var7) {
			Entity var8 = (Entity) var4.get(var7);
			if ((var8 != this.shooter) || (this.ticksInAir >= 5)) {
				float var9 = 0.3F;
				AxisAlignedBB var10 = var8.getBoundingBox().grow(var9, var9, var9);
				MovingObjectPosition var11 = var10.a(var1, var2);
				if (var11 != null) {
					double var12 = var1.distanceSquared(var11.pos);
					if ((var12 < var5) || (var5 == 0.0D)) {
						var3 = var8;
						var5 = var12;
					}
				}
			}
		}

		return var3;
	}

	@Override
	public void write(NBTTagCompound var1) {
		var1.put("xTile", (short) this.hitBlockX);
		var1.put("yTile", (short) this.hitBlockY);
		var1.put("zTile", (short) this.hitBlockZ);
		var1.put("life", (short) this.life);
		MinecraftKey var2 = Block.BLOCK_REGISTRY.getKey(this.hitBlockId);
		var1.put("inTile", var2 == null ? "" : var2.toString());
		var1.put("inData", (byte) this.hitBlockData);
		var1.put("shake", (byte) this.shake);
		var1.put("inGround", (byte) (this.inGround ? 1 : 0));
		var1.put("pickup", (byte) this.fromPlayer);
		var1.put("damage", this.damage);
	}

	@Override
	public void read(NBTTagCompound var1) {
		this.hitBlockX = var1.getShort("xTile");
		this.hitBlockY = var1.getShort("yTile");
		this.hitBlockZ = var1.getShort("zTile");
		this.life = var1.getShort("life");
		if (var1.hasOfType("inTile", 8)) {
			this.hitBlockId = Block.getByName(var1.getString("inTile"));
		} else {
			this.hitBlockId = Block.getById(var1.getByte("inTile") & 255);
		}

		this.hitBlockData = var1.getByte("inData") & 255;
		this.shake = var1.getByte("shake") & 255;
		this.inGround = var1.getByte("inGround") == 1;
		if (var1.hasOfType("damage", 99)) {
			this.damage = var1.getDouble("damage");
		}

		if (var1.hasOfType("pickup", 99)) {
			this.fromPlayer = var1.getByte("pickup");
		} else if (var1.hasOfType("player", 99)) {
			this.fromPlayer = var1.getBoolean("player") ? 1 : 0;
		}

	}

	@Override
	public void d(EntityHuman player) {
		if (!this.world.isClientSide && this.inGround && (this.shake <= 0)) {
			boolean pickup = (this.fromPlayer == 1) || ((this.fromPlayer == 2) && player.abilities.instabuild);
			if ((this.fromPlayer == 1) && !player.inventory.pickup(this.getItemStack())) {
				pickup = false;
			}

			if (pickup) {
				this.makeSound("random.pop", 0.2F, (((this.random.nextFloat() - this.random.nextFloat()) * 0.7F) + 1.0F) * 2.0F);
				player.receive(this, 1);
				this.die();
			}
		}
	}

	protected ItemStack getItemStack() {
		return new ItemStack(Items.ARROW);
	}

	@Override
	protected boolean s_() {
		return false;
	}

	public void b(double var1) {
		this.damage = var1;
	}

	public double l() {
		return this.damage;
	}

	public void a(int var1) {
		this.knockbackStrength = var1;
	}

	@Override
	public boolean aF() {
		return false;
	}

	@Override
	public float getHeadHeight() {
		return 0.0F;
	}

	public void setCritical(boolean b) {
		byte prev = this.datawatcher.getByte(CRITICAL_DW_ID);
		if (b) {
			this.datawatcher.update(CRITICAL_DW_ID, Byte.valueOf((byte) (prev | 1)));
		} else {
			this.datawatcher.update(CRITICAL_DW_ID, Byte.valueOf((byte) (prev & -2)));
		}

	}

	public boolean isCritical() {
		byte var1 = this.datawatcher.getByte(CRITICAL_DW_ID);
		return (var1 & 1) != 0;
	}

}
