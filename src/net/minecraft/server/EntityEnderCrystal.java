package net.minecraft.server;

public class EntityEnderCrystal extends Entity {

	private static final int HEALTH = DataWathcer.claimId(EntityEnderCrystal.class); //value = 5

	public int a;
	public int b;

	public EntityEnderCrystal(World var1) {
		super(var1);
		this.k = true;
		this.setSize(2.0F, 2.0F);
		this.b = 5;
		this.a = this.random.nextInt(100000);
	}

	protected boolean s_() {
		return false;
	}

	protected void initDatawatcher() {
		this.datawatcher.add(HEALTH, Integer.valueOf(this.b));
	}

	public void t_() {
		this.lastX = this.locX;
		this.lastY = this.locY;
		this.lastZ = this.locZ;
		++this.a;
		this.datawatcher.update(HEALTH, Integer.valueOf(this.b));
		if (!this.world.isClientSide) {
			BlockPosition var1 = new BlockPosition(this);
			if (this.world.worldProvider instanceof WorldProviderTheEnd && this.world.getType(var1).getBlock() != Blocks.FIRE) {
				this.world.setTypeUpdate(var1, Blocks.FIRE.getBlockData());
			}
		}

	}

	protected void write(NBTTagCompound var1) {
	}

	protected void read(NBTTagCompound var1) {
	}

	public boolean ad() {
		return true;
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (var1.j() instanceof EntityEnderDragon) {
			return false;
		} else {
			if (!this.dead && !this.world.isClientSide) {
				this.b = 0;
				this.die();
				if (!this.world.isClientSide) {
					this.world.a((Entity) null, this.locX, this.locY, this.locZ, 6.0F, true);
					if (this.world.worldProvider instanceof WorldProviderTheEnd) {
						WorldProviderTheEnd var3 = (WorldProviderTheEnd) this.world.worldProvider;
						class_apc var4 = var3.s();
						if (var4 != null) {
							var4.a(this, var1);
						}
					}
				}
			}

			return true;
		}
	}
}
