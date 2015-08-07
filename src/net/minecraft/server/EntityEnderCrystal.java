package net.minecraft.server;

public class EntityEnderCrystal extends Entity {

	private static final int HEALTH = Datawathcer.claimId(EntityEnderCrystal.class); //value = 5

	public int a;
	public int b;

	public EntityEnderCrystal(World var1) {
		super(var1);
		this.k = true;
		this.a(2.0F, 2.0F);
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
		this.p = this.s;
		this.q = this.t;
		this.r = this.u;
		++this.a;
		this.datawatcher.update(HEALTH, Integer.valueOf(this.b));
		if (!this.o.isClientSide) {
			BlockPosition var1 = new BlockPosition(this);
			if (this.o.worldProvider instanceof class_apd && this.o.getType(var1).getBlock() != Blocks.FIRE) {
				this.o.setTypeUpdate(var1, Blocks.FIRE.getBlockData());
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
			if (!this.I && !this.o.isClientSide) {
				this.b = 0;
				this.J();
				if (!this.o.isClientSide) {
					this.o.a((Entity) null, this.s, this.t, this.u, 6.0F, true);
					if (this.o.worldProvider instanceof class_apd) {
						class_apd var3 = (class_apd) this.o.worldProvider;
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
