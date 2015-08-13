package net.minecraft.server;

public abstract class EntityAgeable extends EntityCreature {

	private static final int AGE_DW_ID = Datawatcher.claimId(EntityAgeable.class); //value = 11

	protected int a;
	protected int b;
	protected int c;
	private float bt = -1.0F;
	private float bu;

	public EntityAgeable(World var1) {
		super(var1);
	}

	public abstract EntityAgeable createChild(EntityAgeable var1);

	public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
		if (var3 != null && var3.getItem() == Items.SPAWN_EGG) {
			if (!this.world.isClientSide) {
				Class var4 = EntityTypes.a(var3.i());
				if (var4 != null && this.getClass() == var4) {
					EntityAgeable var5 = this.createChild(this);
					if (var5 != null) {
						var5.b(-24000);
						var5.setPositionRotation(this.locX, this.locY, this.locZ, 0.0F, 0.0F);
						this.world.addEntity((Entity) var5);
						if (var3.hasDisplayName()) {
							var5.a((String) var3.getDisplayName());
						}

						if (!var1.abilities.instabuild) {
							--var3.count;
						}
					}
				}
			}

			return true;
		} else {
			return false;
		}
	}

	protected void initDatawatcher() {
		super.initDatawatcher();
		this.datawatcher.add(AGE_DW_ID, Byte.valueOf((byte) 0));
	}

	public int getAge() {
		return this.world.isClientSide ? this.datawatcher.getByte(AGE_DW_ID) : this.a;
	}

	public void setAge(int var1, boolean var2) {
		int var3 = this.getAge();
		int var4 = var3;
		var3 += var1 * 20;
		if (var3 > 0) {
			var3 = 0;
			if (var4 < 0) {
				this.n();
			}
		}

		int var5 = var3 - var4;
		this.b(var3);
		if (var2) {
			this.b += var5;
			if (this.c == 0) {
				this.c = 40;
			}
		}

		if (this.getAge() == 0) {
			this.b(this.b);
		}

	}

	public void a(int var1) {
		this.setAge(var1, false);
	}

	public void b(int var1) {
		this.datawatcher.update(AGE_DW_ID, Byte.valueOf((byte) MathHelper.clamp(var1, -1, 1)));
		this.a = var1;
		this.a(this.isBaby());
	}

	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("Age", this.getAge());
		var1.put("ForcedAge", this.b);
	}

	public void read(NBTTagCompound var1) {
		super.read(var1);
		this.b(var1.getInt("Age"));
		this.b = var1.getInt("ForcedAge");
	}

	public void d(int var1) {
		if (var1 == AGE_DW_ID) {
			this.a(this.isBaby());
		}

		super.d(var1);
	}

	public void m() {
		super.m();
		if (this.world.isClientSide) {
			if (this.c > 0) {
				if (this.c % 4 == 0) {
					this.world.addParticle(EnumParticle.HAPPY_VILLAGER, this.locX + (double) (this.random.nextFloat() * this.width * 2.0F) - (double) this.width, this.locY + 0.5D + (double) (this.random.nextFloat() * this.length), this.locZ + (double) (this.random.nextFloat() * this.width * 2.0F) - (double) this.width, 0.0D, 0.0D, 0.0D, new int[0]);
				}

				--this.c;
			}
		} else {
			int var1 = this.getAge();
			if (var1 < 0) {
				++var1;
				this.b(var1);
				if (var1 == 0) {
					this.n();
				}
			} else if (var1 > 0) {
				--var1;
				this.b(var1);
			}
		}

	}

	protected void n() {
	}

	public boolean isBaby() {
		return this.getAge() < 0;
	}

	public void a(boolean var1) {
		this.a(var1 ? 0.5F : 1.0F);
	}

	protected final void setSize(float var1, float var2) {
		boolean var3 = this.bt > 0.0F;
		this.bt = var1;
		this.bu = var2;
		if (!var3) {
			this.a(1.0F);
		}

	}

	protected final void a(float var1) {
		super.setSize(this.bt * var1, this.bu * var1);
	}
}
