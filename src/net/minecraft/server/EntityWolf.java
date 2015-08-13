package net.minecraft.server;

import com.google.common.base.Predicate;

public class EntityWolf extends EntityTameable {

	private static final int HEALTH_DW_ID = Datawatcher.claimId(EntityWolf.class); //value = 14
	private static final int BEGGING_DW_ID = Datawatcher.claimId(EntityWolf.class); //value = 15
	private static final int COLLARCOLOR_DW_ID = Datawatcher.claimId(EntityWolf.class); //value = 16

	private float bz;
	private float bA;
	private boolean bB;
	private boolean bC;
	private float bD;
	private float bE;

	public EntityWolf(World var1) {
		super(var1);
		this.setSize(0.6F, 0.8F);
		((class_tf) this.u()).a(true);
		this.i.a(1, new class_rj(this));
		this.i.a(2, this.bu);
		this.i.a(3, new class_rq(this, 0.4F));
		this.i.a(4, new class_ru(this, 1.0D, true));
		this.i.a(5, new class_rk(this, 1.0D, 10.0F, 2.0F));
		this.i.a(6, new class_re(this, 1.0D));
		this.i.a(7, new class_si(this, 1.0D));
		this.i.a(8, new class_rc(this, 8.0F));
		this.i.a(9, new class_rr(this, EntityHuman.class, 8.0F));
		this.i.a(9, new class_sh(this));
		this.bn.a(1, new class_tb(this));
		this.bn.a(2, new class_tc(this));
		this.bn.a(3, new class_sw(this, true, new Class[0]));
		this.bn.a(4, new class_ta(this, EntityAnimal.class, false, new Predicate() {
			public boolean a(Entity var1) {
				return var1 instanceof EntitySheep || var1 instanceof EntityRabbit;
			}

			// $FF: synthetic method
			public boolean apply(Object var1) {
				return this.a((Entity) var1);
			}
		}));
		this.bn.a(5, new class_sz(this, EntitySkeleton.class, false));
		this.n(false);
	}

	protected void aY() {
		super.aY();
		this.a((class_qk) class_wl.d).a(0.30000001192092896D);
		if (this.cA()) {
			this.a((class_qk) class_wl.a).a(20.0D);
		} else {
			this.a((class_qk) class_wl.a).a(8.0D);
		}

		this.by().b(class_wl.e);
		this.a((class_qk) class_wl.e).a(2.0D);
	}

	public void d(EntityLiving var1) {
		super.d(var1);
		if (var1 == null) {
			this.p(false);
		} else if (!this.cA()) {
			this.p(true);
		}

	}

	protected void cc() {
		this.datawatcher.update(HEALTH_DW_ID, Float.valueOf(this.getHealth()));
	}

	protected void initDatawatcher() {
		super.initDatawatcher();
		this.datawatcher.add(HEALTH_DW_ID, new Float(this.getHealth()));
		this.datawatcher.add(BEGGING_DW_ID, new Byte((byte) 0));
		this.datawatcher.add(COLLARCOLOR_DW_ID, new Byte((byte) EnumColor.o.a()));
	}

	protected void a(BlockPosition var1, Block var2) {
		this.makeSound("mob.wolf.step", 0.15F, 1.0F);
	}

	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("Angry", this.cK());
		var1.put("CollarColor", (byte) this.cL().b());
	}

	public void read(NBTTagCompound var1) {
		super.read(var1);
		this.p(var1.getBoolean("Angry"));
		if (var1.hasOfType("CollarColor", 99)) {
			this.a(EnumColor.a(var1.getByte("CollarColor")));
		}

	}

	protected String C() {
		return this.cK() ? "mob.wolf.growl" : (this.random.nextInt(3) == 0 ? (this.cA() && this.datawatcher.getFloat(HEALTH_DW_ID) < 10.0F ? "mob.wolf.whine" : "mob.wolf.panting") : "mob.wolf.bark");
	}

	protected String bp() {
		return "mob.wolf.hurt";
	}

	protected String bq() {
		return "mob.wolf.death";
	}

	protected float bC() {
		return 0.4F;
	}

	protected Item D() {
		return Item.getById(-1);
	}

	public void m() {
		super.m();
		if (!this.world.isClientSide && this.bB && !this.bC && !this.cu() && this.onGround) {
			this.bC = true;
			this.bD = 0.0F;
			this.bE = 0.0F;
			this.world.a((Entity) this, (byte) 8);
		}

		if (!this.world.isClientSide && this.w() == null && this.cK()) {
			this.p(false);
		}

	}

	public void t_() {
		super.t_();
		this.bA = this.bz;
		if (this.cM()) {
			this.bz += (1.0F - this.bz) * 0.4F;
		} else {
			this.bz += (0.0F - this.bz) * 0.4F;
		}

		if (this.U()) {
			this.bB = true;
			this.bC = false;
			this.bD = 0.0F;
			this.bE = 0.0F;
		} else if ((this.bB || this.bC) && this.bC) {
			if (this.bD == 0.0F) {
				this.makeSound("mob.wolf.shake", this.bC(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			}

			this.bE = this.bD;
			this.bD += 0.05F;
			if (this.bE >= 2.0F) {
				this.bB = false;
				this.bC = false;
				this.bE = 0.0F;
				this.bD = 0.0F;
			}

			if (this.bD > 0.4F) {
				float var1 = (float) this.getBoundingBox().yMin;
				int var2 = (int) (MathHelper.sin((this.bD - 0.4F) * 3.1415927F) * 7.0F);

				for (int var3 = 0; var3 < var2; ++var3) {
					float var4 = (this.random.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
					float var5 = (this.random.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
					this.world.addParticle(EnumParticle.SPLASH, this.locX + (double) var4, (double) (var1 + 0.8F), this.locZ + (double) var5, this.motX, this.motY, this.motZ, new int[0]);
				}
			}
		}

	}

	public float getHeadHeight() {
		return this.length * 0.8F;
	}

	public int cd() {
		return this.cC() ? 20 : super.cd();
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b((DamageSource) var1)) {
			return false;
		} else {
			Entity var3 = var1.getEntity();
			this.bu.a(false);
			if (var3 != null && !(var3 instanceof EntityHuman) && !(var3 instanceof EntityArrow)) {
				var2 = (var2 + 1.0F) / 2.0F;
			}

			return super.damageEntity(var1, var2);
		}
	}

	public boolean r(Entity var1) {
		boolean var2 = var1.damageEntity(DamageSource.mobAttack((EntityLiving) this), (float) ((int) this.a((class_qk) class_wl.e).e()));
		if (var2) {
			this.a((EntityLiving) this, (Entity) var1);
		}

		return var2;
	}

	public void n(boolean var1) {
		super.n(var1);
		if (var1) {
			this.a((class_qk) class_wl.a).a(20.0D);
		} else {
			this.a((class_qk) class_wl.a).a(8.0D);
		}

		this.a((class_qk) class_wl.e).a(4.0D);
	}

	public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
		if (this.cA()) {
			if (var3 != null) {
				if (var3.getItem() instanceof ItemFood) {
					ItemFood var4 = (ItemFood) var3.getItem();
					if (var4.g() && this.datawatcher.getFloat(HEALTH_DW_ID) < 20.0F) {
						if (!var1.abilities.instabuild) {
							--var3.count;
						}

						this.heal((float) var4.h(var3));
						return true;
					}
				} else if (var3.getItem() == Items.DYE) {
					EnumColor var5 = EnumColor.a(var3.i());
					if (var5 != this.cL()) {
						this.a(var5);
						if (!var1.abilities.instabuild) {
							--var3.count;
						}

						return true;
					}
				}
			}

			if (this.e(var1) && !this.world.isClientSide && !this.d(var3)) {
				this.bu.a(!this.cC());
				this.bb = false;
				this.h.n();
				this.d((EntityLiving) null);
			}
		} else if (var3 != null && var3.getItem() == Items.BONE && !this.cK()) {
			if (!var1.abilities.instabuild) {
				--var3.count;
			}

			if (!this.world.isClientSide) {
				if (this.random.nextInt(3) == 0) {
					this.n(true);
					this.h.n();
					this.d((EntityLiving) null);
					this.bu.a(true);
					this.i(20.0F);
					this.b((String) var1.getUniqueId().toString());
					this.m(true);
					this.world.a((Entity) this, (byte) 7);
				} else {
					this.m(false);
					this.world.a((Entity) this, (byte) 6);
				}
			}

			return true;
		}

		return super.a(var1, var2, var3);
	}

	public boolean d(ItemStack var1) {
		return var1 == null ? false : (!(var1.getItem() instanceof ItemFood) ? false : ((ItemFood) var1.getItem()).g());
	}

	public int cj() {
		return 8;
	}

	public boolean cK() {
		return (this.datawatcher.getByte(TAME_FLAGS_DW_ID) & 2) != 0;
	}

	public void p(boolean var1) {
		byte var2 = this.datawatcher.getByte(TAME_FLAGS_DW_ID);
		if (var1) {
			this.datawatcher.update(TAME_FLAGS_DW_ID, Byte.valueOf((byte) (var2 | 2)));
		} else {
			this.datawatcher.update(TAME_FLAGS_DW_ID, Byte.valueOf((byte) (var2 & -3)));
		}

	}

	public EnumColor cL() {
		return EnumColor.a(this.datawatcher.getByte(COLLARCOLOR_DW_ID) & 15);
	}

	public void a(EnumColor var1) {
		this.datawatcher.update(COLLARCOLOR_DW_ID, Byte.valueOf((byte) (var1.b() & 15)));
	}

	public EntityWolf b(EntityAgeable var1) {
		EntityWolf var2 = new EntityWolf(this.world);
		String var3 = this.b();
		if (var3 != null && !var3.trim().isEmpty()) {
			var2.b((String) var3);
			var2.n(true);
		}

		return var2;
	}

	public void q(boolean var1) {
		if (var1) {
			this.datawatcher.update(BEGGING_DW_ID, Byte.valueOf((byte) 1));
		} else {
			this.datawatcher.update(BEGGING_DW_ID, Byte.valueOf((byte) 0));
		}

	}

	public boolean a(EntityAnimal var1) {
		if (var1 == this) {
			return false;
		} else if (!this.cA()) {
			return false;
		} else if (!(var1 instanceof EntityWolf)) {
			return false;
		} else {
			EntityWolf var2 = (EntityWolf) var1;
			return !var2.cA() ? false : (var2.cC() ? false : this.cG() && var2.cG());
		}
	}

	public boolean cM() {
		return this.datawatcher.getByte(BEGGING_DW_ID) == 1;
	}

	protected boolean E() {
		return !this.cA() && this.ticksLived > 2400;
	}

	public boolean a(EntityLiving var1, EntityLiving var2) {
		if (!(var1 instanceof EntityCreeper) && !(var1 instanceof EntityGhast)) {
			if (var1 instanceof EntityWolf) {
				EntityWolf var3 = (EntityWolf) var1;
				if (var3.cA() && var3.cD() == var2) {
					return false;
				}
			}

			return var1 instanceof EntityHuman && var2 instanceof EntityHuman && !((EntityHuman) var2).a((EntityHuman) var1) ? false : !(var1 instanceof EntityHorse) || !((EntityHorse) var1).cD();
		} else {
			return false;
		}
	}

	public boolean cp() {
		return !this.cK() && super.cp();
	}

	// $FF: synthetic method
	public EntityAgeable createChild(EntityAgeable var1) {
		return this.b(var1);
	}
}
