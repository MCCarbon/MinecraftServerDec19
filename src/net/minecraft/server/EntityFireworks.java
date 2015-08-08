package net.minecraft.server;

public class EntityFireworks extends Entity {

	private static final int INFO_DW_ID = DataWathcer.claimId(EntityFireworks.class); //value = 5

	private int b;
	private int c;

	public EntityFireworks(World var1) {
		super(var1);
		this.a(0.25F, 0.25F);
	}

	protected void initDatawatcher() {
		this.datawatcher.addNull(INFO_DW_ID, 5);
	}

	public EntityFireworks(World var1, double var2, double var4, double var6, ItemStack var8) {
		super(var1);
		this.b = 0;
		this.a(0.25F, 0.25F);
		this.b(var2, var4, var6);
		int var9 = 1;
		if (var8 != null && var8.hasTag()) {
			this.datawatcher.update(INFO_DW_ID, var8);
			NBTTagCompound var10 = var8.getTag();
			NBTTagCompound var11 = var10.getCompound("Fireworks");
			if (var11 != null) {
				var9 += var11.getByte("Flight");
			}
		}

		this.motX = this.random.nextGaussian() * 0.001D;
		this.motZ = this.random.nextGaussian() * 0.001D;
		this.motY = 0.05D;
		this.c = 10 * var9 + this.random.nextInt(6) + this.random.nextInt(7);
	}

	public void t_() {
		this.P = this.locX;
		this.Q = this.locY;
		this.R = this.locZ;
		super.t_();
		this.motX *= 1.15D;
		this.motZ *= 1.15D;
		this.motY += 0.04D;
		this.d(this.motX, this.motY, this.motZ);
		float var1 = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
		this.yaw = (float) (MathHelper.b(this.motX, this.motZ) * 180.0D / 3.1415927410125732D);

		for (this.pitch = (float) (MathHelper.b(this.motY, (double) var1) * 180.0D / 3.1415927410125732D); this.pitch - this.lastPitch < -180.0F; this.lastPitch -= 360.0F) {
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
		if (this.b == 0 && !this.isSilent()) {
			this.world.a((Entity) this, "fireworks.launch", 3.0F, 1.0F);
		}

		++this.b;
		if (this.world.isClientSide && this.b % 2 < 2) {
			this.world.a(class_cy.d, this.locX, this.locY - 0.3D, this.locZ, this.random.nextGaussian() * 0.05D, -this.motY * 0.5D, this.random.nextGaussian() * 0.05D, new int[0]);
		}

		if (!this.world.isClientSide && this.b > this.c) {
			this.world.a((Entity) this, (byte) 17);
			this.J();
		}

	}

	public void write(NBTTagCompound var1) {
		var1.put("Life", this.b);
		var1.put("LifeTime", this.c);
		ItemStack var2 = this.datawatcher.getItemStack(INFO_DW_ID);
		if (var2 != null) {
			NBTTagCompound var3 = new NBTTagCompound();
			var2.write(var3);
			var1.put((String) "FireworksItem", (NBTTag) var3);
		}

	}

	public void read(NBTTagCompound var1) {
		this.b = var1.getInt("Life");
		this.c = var1.getInt("LifeTime");
		NBTTagCompound var2 = var1.getCompound("FireworksItem");
		if (var2 != null) {
			ItemStack var3 = ItemStack.a(var2);
			if (var3 != null) {
				this.datawatcher.update(INFO_DW_ID, var3);
			}
		}

	}

	public float c(float var1) {
		return super.c(var1);
	}

	public boolean aF() {
		return false;
	}
}
