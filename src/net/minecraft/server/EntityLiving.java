package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public abstract class EntityLiving extends Entity {

	private static final UUID a = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
	private static final class_qm b;
	protected static final int USED_HAND_DW_ID = DataWathcer.claimId(EntityLiving.class); //value = 5
	private static final int HEALTH_DW_ID = DataWathcer.claimId(EntityLiving.class); //value = 6
	private static final int POTION_COLOR_DW_ID = DataWathcer.claimId(EntityLiving.class); //value = 7
	private static final int POTION_AMBIENT_DW_ID = DataWathcer.claimId(EntityLiving.class); //value = 8
	private static final int ARROWS_DW_ID = DataWathcer.claimId(EntityLiving.class); //value = 9

	private class_qo i;
	private final class_pb bn = new class_pb(this);
	private final Map<MobEffectType, MobEffect> effects = Maps.newHashMap();
	private final ItemStack[] bp = new ItemStack[2];
	private final ItemStack[] bq = new ItemStack[4];
	public boolean at;
	public EnumUsedHand au;
	public int av;
	public int aw;
	public int hurtTicks;
	public int ay;
	public float az;
	public int deathTicks;
	public float aB;
	public float aC;
	public float aD;
	public float aE;
	public float aF;
	public int aG = 20;
	public float aH;
	public float aI;
	public float aJ;
	public float aK;
	public float aL;
	public float aM;
	public float aN;
	public float aO;
	public float aP = 0.02F;
	protected EntityHuman aQ;
	protected int aR;
	protected boolean aS;
	protected int aT;
	protected float aU;
	protected float aV;
	protected float aW;
	protected float aX;
	protected float aY;
	protected int aZ;
	protected float ba;
	protected boolean bb;
	public float bc;
	public float bd;
	protected float be;
	protected int bf;
	protected double bg;
	protected double bh;
	protected double bi;
	protected double bj;
	protected double bk;
	private boolean br = true;
	private EntityLiving bs;
	private int hurtTimestamp;
	private EntityLiving bu;
	private int bv;
	private float bw;
	private int bx;
	private float by;
	protected ItemStack bl;
	protected int bm;

	public void G() {
		this.damageEntity(DamageSource.j, Float.MAX_VALUE);
	}

	public EntityLiving(World var1) {
		super(var1);
		this.aY();
		this.i(this.bv());
		this.k = true;
		this.aK = (float) ((Math.random() + 1.0D) * 0.009999999776482582D);
		this.setPosition(this.locX, this.locY, this.locZ);
		this.aJ = (float) Math.random() * 12398.0F;
		this.yaw = (float) (Math.random() * 3.1415927410125732D * 2.0D);
		this.aN = this.yaw;
		this.S = 0.6F;
	}

	protected void initDatawatcher() {
		this.datawatcher.add(USED_HAND_DW_ID, Integer.valueOf(0));
		this.datawatcher.add(POTION_COLOR_DW_ID, Integer.valueOf(0));
		this.datawatcher.add(POTION_AMBIENT_DW_ID, Byte.valueOf((byte) 0));
		this.datawatcher.add(ARROWS_DW_ID, Byte.valueOf((byte) 0));
		this.datawatcher.add(HEALTH_DW_ID, Float.valueOf(1.0F));
	}

	protected void aY() {
		this.by().b(class_wl.a);
		this.by().b(class_wl.c);
		this.by().b(class_wl.d);
	}

	protected void a(double var1, boolean var3, Block var4, BlockPosition var5) {
		if (!this.V()) {
			this.W();
		}

		if (!this.world.isClientSide && this.fallDistance > 3.0F && var3) {
			IBlockData var6 = this.world.getType(var5);
			Block var7 = var6.getBlock();
			float var8 = (float) MathHelper.ceil(this.fallDistance - 3.0F);
			if (var7.getMaterial() != Material.AIR) {
				double var9 = (double) Math.min(0.2F + var8 / 15.0F, 10.0F);
				if (var9 > 2.5D) {
					var9 = 2.5D;
				}

				int var11 = (int) (150.0D * var9);
				((WorldServer) this.world).a(EnumParticle.M, this.locX, this.locY, this.locZ, var11, 0.0D, 0.0D, 0.0D, 0.15000000596046448D, new int[] { Block.getCombinedId(var6) });
			}
		}

		super.a(var1, var3, var4, var5);
	}

	public boolean aZ() {
		return false;
	}

	public void K() {
		this.aB = this.aC;
		super.K();
		this.world.B.a("livingEntityBaseTick");
		boolean var1 = this instanceof EntityHuman;
		if (this.isAlive()) {
			if (this.aj()) {
				this.damageEntity(DamageSource.e, 1.0F);
			} else if (var1 && !this.world.ag().a(this.getBoundingBox())) {
				double var2 = this.world.ag().a((Entity) this) + this.world.ag().m();
				if (var2 < 0.0D) {
					this.damageEntity(DamageSource.e, (float) Math.max(1, MathHelper.floor(-var2 * this.world.ag().n())));
				}
			}
		}

		if (this.T() || this.world.isClientSide) {
			this.N();
		}

		boolean var7 = var1 && ((EntityHuman) this).abilities.invulnerable;
		if (this.isAlive()) {
			if (this.a((Material) Material.WATER)) {
				if (!this.aZ() && !this.hasEffect(MobEffectList.m) && !var7) {
					this.i(this.j(this.aB()));
					if (this.aB() == -20) {
						this.i(0);

						for (int var3 = 0; var3 < 8; ++var3) {
							float var4 = this.random.nextFloat() - this.random.nextFloat();
							float var5 = this.random.nextFloat() - this.random.nextFloat();
							float var6 = this.random.nextFloat() - this.random.nextFloat();
							this.world.addParticle(EnumParticle.e, this.locX + (double) var4, this.locY + (double) var5, this.locZ + (double) var6, this.motX, this.motY, this.motZ, new int[0]);
						}

						this.damageEntity(DamageSource.f, 2.0F);
					}
				}

				if (!this.world.isClientSide && this.aw() && this.vehicle instanceof EntityLiving) {
					this.a((Entity) null);
				}
			} else {
				this.i(300);
			}
		}

		if (this.isAlive() && this.U()) {
			this.N();
		}

		this.aH = this.aI;
		if (this.hurtTicks > 0) {
			--this.hurtTicks;
		}

		if (this.noDamageTicks > 0 && !(this instanceof EntityPlayer)) {
			--this.noDamageTicks;
		}

		if (this.getHealth() <= 0.0F) {
			this.ba();
		}

		if (this.aR > 0) {
			--this.aR;
		} else {
			this.aQ = null;
		}

		if (this.bu != null && !this.bu.isAlive()) {
			this.bu = null;
		}

		if (this.bs != null) {
			if (!this.bs.isAlive()) {
				this.b((EntityLiving) null);
			} else if (this.ticksLived - this.hurtTimestamp > 100) {
				this.b((EntityLiving) null);
			}
		}

		this.bj();
		this.aX = this.aW;
		this.aM = this.aL;
		this.aO = this.aN;
		this.lastYaw = this.yaw;
		this.lastPitch = this.pitch;
		this.world.B.b();
	}

	public boolean isBaby() {
		return false;
	}

	protected void ba() {
		++this.deathTicks;
		if (this.deathTicks == 20) {
			int var1;
			if (!this.world.isClientSide && (this.aR > 0 || this.bc()) && this.bb() && this.world.R().getBooleanValue("doMobLoot")) {
				var1 = this.b(this.aQ);

				while (var1 > 0) {
					int var2 = EntityExperienceOrb.getOrbValue(var1);
					var1 -= var2;
					this.world.addEntity((Entity) (new EntityExperienceOrb(this.world, this.locX, this.locY, this.locZ, var2)));
				}
			}

			this.die();

			for (var1 = 0; var1 < 20; ++var1) {
				double var8 = this.random.nextGaussian() * 0.02D;
				double var4 = this.random.nextGaussian() * 0.02D;
				double var6 = this.random.nextGaussian() * 0.02D;
				this.world.addParticle(EnumParticle.a, this.locX + (double) (this.random.nextFloat() * this.width * 2.0F) - (double) this.width, this.locY + (double) (this.random.nextFloat() * this.length), this.locZ + (double) (this.random.nextFloat() * this.width * 2.0F) - (double) this.width, var8, var4, var6, new int[0]);
			}
		}

	}

	protected boolean bb() {
		return !this.isBaby();
	}

	protected int j(int var1) {
		int var2 = EnchantmentManager.c(this);
		return var2 > 0 && this.random.nextInt(var2 + 1) > 0 ? var1 : var1 - 1;
	}

	protected int b(EntityHuman var1) {
		return 0;
	}

	protected boolean bc() {
		return false;
	}

	public Random getRandom() {
		return this.random;
	}

	public EntityLiving be() {
		return this.bs;
	}

	public int bf() {
		return this.hurtTimestamp;
	}

	public void b(EntityLiving var1) {
		this.bs = var1;
		this.hurtTimestamp = this.ticksLived;
	}

	public EntityLiving bg() {
		return this.bu;
	}

	public int bh() {
		return this.bv;
	}

	public void p(Entity var1) {
		if (var1 instanceof EntityLiving) {
			this.bu = (EntityLiving) var1;
		} else {
			this.bu = null;
		}

		this.bv = this.ticksLived;
	}

	public int bi() {
		return this.aT;
	}

	public void write(NBTTagCompound compound) {
		compound.put("HealF", this.getHealth());
		compound.put("Health", (short) ((int) Math.ceil((double) this.getHealth())));
		compound.put("HurtTime", (short) this.hurtTicks);
		compound.put("HurtByTimestamp", this.hurtTimestamp);
		compound.put("DeathTime", (short) this.deathTicks);
		compound.put("AbsorptionAmount", this.getAbsorptionHearts());
		EnumWearable[] var2 = EnumWearable.values();
		int var3 = var2.length;

		int var4;
		EnumWearable var5;
		ItemStack var6;
		for (var4 = 0; var4 < var3; ++var4) {
			var5 = var2[var4];
			var6 = this.a(var5);
			if (var6 != null) {
				this.by().a(var6.a(var5));
			}
		}

		compound.put((String) "Attributes", (NBTTag) class_wl.a(this.by()));
		var2 = EnumWearable.values();
		var3 = var2.length;

		for (var4 = 0; var4 < var3; ++var4) {
			var5 = var2[var4];
			var6 = this.a(var5);
			if (var6 != null) {
				this.by().b(var6.a(var5));
			}
		}

		if (!this.effects.isEmpty()) {
			NBTTagList var7 = new NBTTagList();
			Iterator<MobEffect> var8 = this.effects.values().iterator();

			while (var8.hasNext()) {
				MobEffect var9 = (MobEffect) var8.next();
				var7.add((NBTTag) var9.a(new NBTTagCompound()));
			}

			compound.put((String) "ActiveEffects", (NBTTag) var7);
		}

	}

	public void read(NBTTagCompound compound) {
		this.setAbsorptionHearts(compound.getFloat("AbsorptionAmount"));
		if (compound.hasOfType("Attributes", 9) && this.world != null && !this.world.isClientSide) {
			class_wl.a(this.by(), compound.getList("Attributes", 10));
		}

		if (compound.hasOfType("ActiveEffects", 9)) {
			NBTTagList var2 = compound.getList("ActiveEffects", 10);

			for (int var3 = 0; var3 < var2.getSize(); ++var3) {
				NBTTagCompound var4 = var2.getCompound(var3);
				MobEffect var5 = MobEffect.b(var4);
				if (var5 != null) {
					this.effects.put(var5.a(), var5);
				}
			}
		}

		if (compound.hasOfType("HealF", 99)) {
			this.i(compound.getFloat("HealF"));
		} else {
			NBTTag var6 = compound.getTag("Health");
			if (var6 == null) {
				this.i(this.bv());
			} else if (var6.getId() == 5) {
				this.i(((NBTTagFloat) var6).asFloat());
			} else if (var6.getId() == 2) {
				this.i((float) ((NBTTagShort) var6).asShort());
			}
		}

		this.hurtTicks = compound.getShort("HurtTime");
		this.deathTicks = compound.getShort("DeathTime");
		this.hurtTimestamp = compound.getInt("HurtByTimestamp");
		if (compound.hasOfType("Team", 8)) {
			String var7 = compound.getString("Team");
			this.world.aa().a(this.getUniqueId().toString(), var7);
		}

	}

	protected void bj() {
		Iterator<MobEffectType> var1 = this.effects.keySet().iterator();

		while (var1.hasNext()) {
			MobEffectType var2 = (MobEffectType) var1.next();
			MobEffect var3 = (MobEffect) this.effects.get(var2);
			if (!var3.a(this)) {
				if (!this.world.isClientSide) {
					var1.remove();
					this.b(var3);
				}
			} else if (var3.b() % 600 == 0) {
				this.a(var3, false);
			}
		}

		if (this.br) {
			if (!this.world.isClientSide) {
				this.B();
			}

			this.br = false;
		}

		int var11 = this.datawatcher.getInt(POTION_COLOR_DW_ID);
		boolean var12 = this.datawatcher.getByte(POTION_AMBIENT_DW_ID) > 0;
		if (var11 > 0) {
			boolean var4 = false;
			if (!this.aA()) {
				var4 = this.random.nextBoolean();
			} else {
				var4 = this.random.nextInt(15) == 0;
			}

			if (var12) {
				var4 &= this.random.nextInt(5) == 0;
			}

			if (var4 && var11 > 0) {
				double var5 = (double) (var11 >> 16 & 255) / 255.0D;
				double var7 = (double) (var11 >> 8 & 255) / 255.0D;
				double var9 = (double) (var11 >> 0 & 255) / 255.0D;
				this.world.addParticle(var12 ? EnumParticle.q : EnumParticle.p, this.locX + (this.random.nextDouble() - 0.5D) * (double) this.width, this.locY + this.random.nextDouble() * (double) this.length, this.locZ + (this.random.nextDouble() - 0.5D) * (double) this.width, var5, var7, var9, new int[0]);
			}
		}

	}

	protected void B() {
		if (this.effects.isEmpty()) {
			this.bk();
			this.f(false);
		} else {
			Collection<MobEffect> var1 = this.effects.values();
			this.datawatcher.update(POTION_AMBIENT_DW_ID, Byte.valueOf((byte) (a(var1) ? 1 : 0)));
			this.datawatcher.update(POTION_COLOR_DW_ID, Integer.valueOf(ItemPotion.a(var1)));
			this.f(this.hasEffect(MobEffectList.n));
		}

	}

	public static boolean a(Collection<MobEffect> var0) {
		Iterator<MobEffect> var1 = var0.iterator();

		MobEffect var2;
		do {
			if (!var1.hasNext()) {
				return true;
			}

			var2 = (MobEffect) var1.next();
		} while (var2.d());

		return false;
	}

	protected void bk() {
		this.datawatcher.update(POTION_AMBIENT_DW_ID, Byte.valueOf((byte) 0));
		this.datawatcher.update(POTION_COLOR_DW_ID, Integer.valueOf(0));
	}

	public void bl() {
		if (!this.world.isClientSide) {
			Iterator<MobEffect> var1 = this.effects.values().iterator();

			while (var1.hasNext()) {
				this.b((MobEffect) var1.next());
				var1.remove();
			}

		}
	}

	public Collection<MobEffect> getEffects() {
		return this.effects.values();
	}

	public boolean hasEffect(MobEffectType var1) {
		return this.effects.containsKey(var1);
	}

	public MobEffect getEffect(MobEffectType var1) {
		return this.effects.get(var1);
	}

	public void addEffect(MobEffect var1) {
		if (this.d(var1)) {
			MobEffect var2 = (MobEffect) this.effects.get(var1.a());
			if (var2 == null) {
				this.effects.put(var1.a(), var1);
				this.a(var1);
			} else {
				var2.a(var1);
				this.a(var2, true);
			}

		}
	}

	public boolean d(MobEffect var1) {
		if (this.bz() == class_qf.b) {
			MobEffectType var2 = var1.a();
			if (var2 == MobEffectList.j || var2 == MobEffectList.s) {
				return false;
			}
		}

		return true;
	}

	public boolean bn() {
		return this.bz() == class_qf.b;
	}

	public MobEffect c(MobEffectType var1) {
		return (MobEffect) this.effects.remove(var1);
	}

	public void d(MobEffectType var1) {
		MobEffect var2 = this.c(var1);
		if (var2 != null) {
			this.b(var2);
		}

	}

	protected void a(MobEffect var1) {
		this.br = true;
		if (!this.world.isClientSide) {
			var1.a().b(this, this.by(), var1.c());
		}

	}

	protected void a(MobEffect var1, boolean var2) {
		this.br = true;
		if (var2 && !this.world.isClientSide) {
			MobEffectType var3 = var1.a();
			var3.a(this, this.by(), var1.c());
			var3.b(this, this.by(), var1.c());
		}

	}

	protected void b(MobEffect var1) {
		this.br = true;
		if (!this.world.isClientSide) {
			var1.a().a(this, this.by(), var1.c());
		}

	}

	public void h(float var1) {
		float var2 = this.getHealth();
		if (var2 > 0.0F) {
			this.i(var2 + var1);
		}

	}

	public final float getHealth() {
		return this.datawatcher.getFloat(HEALTH_DW_ID);
	}

	public void i(float var1) {
		this.datawatcher.update(HEALTH_DW_ID, Float.valueOf(MathHelper.clamp(var1, 0.0F, this.bv())));
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b((DamageSource) var1)) {
			return false;
		} else if (this.world.isClientSide) {
			return false;
		} else {
			this.aT = 0;
			if (this.getHealth() <= 0.0F) {
				return false;
			} else if (var1.o() && this.hasEffect(MobEffectList.l)) {
				return false;
			} else {
				if ((var1 == DamageSource.n || var1 == DamageSource.o) && this.a(EnumWearable.HEAD) != null) {
					this.a(EnumWearable.HEAD).a((int) (var2 * 4.0F + this.random.nextFloat() * var2 * 2.0F), this);
					var2 *= 0.75F;
				}

				this.aE = 1.5F;
				boolean var3 = true;
				if ((float) this.noDamageTicks > (float) this.aG / 2.0F) {
					if (var2 <= this.ba) {
						return false;
					}

					this.d(var1, var2 - this.ba);
					this.ba = var2;
					var3 = false;
				} else {
					this.ba = var2;
					this.noDamageTicks = this.aG;
					this.d(var1, var2);
					this.hurtTicks = this.ay = 10;
				}

				this.az = 0.0F;
				Entity var4 = var1.j();
				if (var4 != null) {
					if (var4 instanceof EntityLiving) {
						this.b((EntityLiving) var4);
					}

					if (var4 instanceof EntityHuman) {
						this.aR = 100;
						this.aQ = (EntityHuman) var4;
					} else if (var4 instanceof EntityWolf) {
						EntityWolf var5 = (EntityWolf) var4;
						if (var5.cA()) {
							this.aR = 100;
							this.aQ = null;
						}
					}
				}

				if (var3) {
					this.world.a((Entity) this, (byte) 2);
					if (var1 != DamageSource.f) {
						this.ac();
					}

					if (var4 != null) {
						double var9 = var4.locX - this.locX;

						double var7;
						for (var7 = var4.locZ - this.locZ; var9 * var9 + var7 * var7 < 1.0E-4D; var7 = (Math.random() - Math.random()) * 0.01D) {
							var9 = (Math.random() - Math.random()) * 0.01D;
						}

						this.az = (float) (MathHelper.b(var7, var9) * 180.0D / 3.1415927410125732D - (double) this.yaw);
						this.a(var4, var2, var9, var7);
					} else {
						this.az = (float) ((int) (Math.random() * 2.0D) * 180);
					}
				}

				String var10;
				if (this.getHealth() <= 0.0F) {
					var10 = this.bq();
					if (var3 && var10 != null) {
						this.makeSound(var10, this.bC(), this.bD());
					}

					this.a(var1);
				} else {
					var10 = this.bp();
					if (var3 && var10 != null) {
						this.makeSound(var10, this.bC(), this.bD());
					}
				}

				return true;
			}
		}
	}

	public void b(ItemStack var1) {
		this.makeSound("random.break", 0.8F, 0.8F + this.world.random.nextFloat() * 0.4F);

		for (int var2 = 0; var2 < 5; ++var2) {
			Vec3D var3 = new Vec3D(((double) this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
			var3 = var3.rotatePitch(-this.pitch * 3.1415927F / 180.0F);
			var3 = var3.rotateYaw(-this.yaw * 3.1415927F / 180.0F);
			double var4 = (double) (-this.random.nextFloat()) * 0.6D - 0.3D;
			Vec3D var6 = new Vec3D(((double) this.random.nextFloat() - 0.5D) * 0.3D, var4, 0.6D);
			var6 = var6.rotatePitch(-this.pitch * 3.1415927F / 180.0F);
			var6 = var6.rotateYaw(-this.yaw * 3.1415927F / 180.0F);
			var6 = var6.add(this.locX, this.locY + (double) this.getHeadHeight(), this.locZ);
			this.world.addParticle(EnumParticle.K, var6.x, var6.y, var6.z, var3.x, var3.y + 0.05D, var3.z, new int[] { Item.getId(var1.getItem()) });
		}

	}

	public void a(DamageSource var1) {
		Entity var2 = var1.j();
		EntityLiving var3 = this.bu();
		if (this.aZ >= 0 && var3 != null) {
			var3.b(this, this.aZ);
		}

		if (var2 != null) {
			var2.a(this);
		}

		this.aS = true;
		this.bt().g();
		if (!this.world.isClientSide) {
			int var4 = 0;
			if (var2 instanceof EntityHuman) {
				var4 = EnchantmentManager.h((EntityLiving) var2);
			}

			if (this.bb() && this.world.R().getBooleanValue("doMobLoot")) {
				this.b(this.aR > 0, var4);
				this.a(this.aR > 0, var4);
				if (this.aR > 0 && this.random.nextFloat() < 0.025F + (float) var4 * 0.01F) {
					this.br();
				}
			}
		}

		this.world.a((Entity) this, (byte) 3);
	}

	protected void a(boolean var1, int var2) {
	}

	public void a(Entity var1, float var2, double var3, double var5) {
		if (this.random.nextDouble() >= this.a(class_wl.c).e()) {
			this.ai = true;
			float var7 = MathHelper.sqrt(var3 * var3 + var5 * var5);
			float var8 = 0.4F;
			this.motX /= 2.0D;
			this.motY /= 2.0D;
			this.motZ /= 2.0D;
			this.motX -= var3 / (double) var7 * (double) var8;
			this.motY += (double) var8;
			this.motZ -= var5 / (double) var7 * (double) var8;
			if (this.motY > 0.4000000059604645D) {
				this.motY = 0.4000000059604645D;
			}

		}
	}

	protected String bp() {
		return "game.neutral.hurt";
	}

	protected String bq() {
		return "game.neutral.die";
	}

	protected void br() {
	}

	protected void b(boolean var1, int var2) {
	}

	public boolean k_() {
		int var1 = MathHelper.floor(this.locX);
		int var2 = MathHelper.floor(this.getBoundingBox().yMin);
		int var3 = MathHelper.floor(this.locZ);
		if (this instanceof EntityHuman && ((EntityHuman) this).isSpectator()) {
			return false;
		} else {
			BlockPosition var4 = new BlockPosition(var1, var2, var3);
			IBlockData var5 = this.world.getType(var4);
			Block var6 = var5.getBlock();
			return var6 != Blocks.LADDER && var6 != Blocks.VINE ? var6 instanceof BlockTrapdoor && this.a(var4, var5) : true;
		}
	}

	private boolean a(BlockPosition var1, IBlockData var2) {
		if (((Boolean) var2.get(BlockTrapdoor.b)).booleanValue()) {
			IBlockData var3 = this.world.getType(var1.down());
			if (var3.getBlock() == Blocks.LADDER && var3.get(BlockLadder.a) == var2.get(BlockTrapdoor.a)) {
				return true;
			}
		}

		return false;
	}

	public boolean isAlive() {
		return !this.dead && this.getHealth() > 0.0F;
	}

	public void e(float var1, float var2) {
		super.e(var1, var2);
		MobEffect var3 = this.getEffect(MobEffectList.h);
		float var4 = var3 != null ? (float) (var3.c() + 1) : 0.0F;
		int var5 = MathHelper.ceil((var1 - 3.0F - var4) * var2);
		if (var5 > 0) {
			this.makeSound(this.k(var5), 1.0F, 1.0F);
			this.damageEntity(DamageSource.i, (float) var5);
			int var6 = MathHelper.floor(this.locX);
			int var7 = MathHelper.floor(this.locY - 0.20000000298023224D);
			int var8 = MathHelper.floor(this.locZ);
			Block var9 = this.world.getType(new BlockPosition(var6, var7, var8)).getBlock();
			if (var9.getMaterial() != Material.AIR) {
				Block.Sound var10 = var9.stepSound;
				this.makeSound(var10.getStepSound(), var10.getVolume() * 0.5F, var10.getPitch() * 0.75F);
			}
		}

	}

	protected String k(int var1) {
		return var1 > 4 ? "game.neutral.hurt.fall.big" : "game.neutral.hurt.fall.small";
	}

	public int bs() {
		int var1 = 0;
		Iterator<?> var2 = this.at().iterator();

		while (var2.hasNext()) {
			ItemStack var3 = (ItemStack) var2.next();
			if (var3 != null && var3.getItem() instanceof ItemArmor) {
				int var4 = ((ItemArmor) var3.getItem()).c;
				var1 += var4;
			}
		}

		return var1;
	}

	protected void j(float var1) {
	}

	protected float b(DamageSource var1, float var2) {
		if (!var1.e()) {
			int var3 = 25 - this.bs();
			float var4 = var2 * (float) var3;
			this.j(var2);
			var2 = var4 / 25.0F;
		}

		return var2;
	}

	protected float c(DamageSource var1, float var2) {
		if (var1.h()) {
			return var2;
		} else {
			int var3;
			int var4;
			float var5;
			if (this.hasEffect(MobEffectList.k) && var1 != DamageSource.j) {
				var3 = (this.getEffect(MobEffectList.k).c() + 1) * 5;
				var4 = 25 - var3;
				var5 = var2 * (float) var4;
				var2 = var5 / 25.0F;
			}

			if (var2 <= 0.0F) {
				return 0.0F;
			} else {
				var3 = EnchantmentManager.a(this.au(), var1);
				if (var3 > 20) {
					var3 = 20;
				}

				if (var3 > 0 && var3 <= 20) {
					var4 = 25 - var3;
					var5 = var2 * (float) var4;
					var2 = var5 / 25.0F;
				}

				return var2;
			}
		}
	}

	protected void d(DamageSource var1, float var2) {
		if (!this.b((DamageSource) var1)) {
			var2 = this.b(var1, var2);
			var2 = this.c(var1, var2);
			float var3 = var2;
			var2 = Math.max(var2 - this.getAbsorptionHearts(), 0.0F);
			this.setAbsorptionHearts(this.getAbsorptionHearts() - (var3 - var2));
			if (var2 != 0.0F) {
				float var4 = this.getHealth();
				this.i(var4 - var2);
				this.bt().a(var1, var4, var2);
				this.setAbsorptionHearts(this.getAbsorptionHearts() - var2);
			}
		}
	}

	public class_pb bt() {
		return this.bn;
	}

	public EntityLiving bu() {
		return (EntityLiving) (this.bn.c() != null ? this.bn.c() : (this.aQ != null ? this.aQ : (this.bs != null ? this.bs : null)));
	}

	public final float bv() {
		return (float) this.a(class_wl.a).e();
	}

	public final int bw() {
		return this.datawatcher.getByte(ARROWS_DW_ID);
	}

	public final void l(int var1) {
		this.datawatcher.update(ARROWS_DW_ID, Byte.valueOf((byte) var1));
	}

	private int n() {
		return this.hasEffect(MobEffectList.c) ? 6 - (1 + this.getEffect(MobEffectList.c).c()) * 1 : (this.hasEffect(MobEffectList.d) ? 6 + (1 + this.getEffect(MobEffectList.d).c()) * 2 : 6);
	}

	public void a(EnumUsedHand var1) {
		if (!this.at || this.av >= this.n() / 2 || this.av < 0) {
			this.av = -1;
			this.at = true;
			this.au = var1;
			if (this.world instanceof WorldServer) {
				((WorldServer) this.world).t().a((Entity) this, (Packet<?>) (new PacketPlayOutAnimation(this, var1 == EnumUsedHand.MAIN_HAND ? 0 : 3)));
			}
		}

	}

	protected void O() {
		this.damageEntity(DamageSource.j, 4.0F);
	}

	protected void bx() {
		int var1 = this.n();
		if (this.at) {
			++this.av;
			if (this.av >= var1) {
				this.av = 0;
				this.at = false;
			}
		} else {
			this.av = 0;
		}

		this.aC = (float) this.av / (float) var1;
	}

	public class_ql a(class_qk var1) {
		return this.by().a(var1);
	}

	public class_qo by() {
		if (this.i == null) {
			this.i = new class_qr();
		}

		return this.i;
	}

	public class_qf bz() {
		return class_qf.a;
	}

	public ItemStack bA() {
		return this.a(EnumWearable.MAINHAND);
	}

	public ItemStack bB() {
		return this.a(EnumWearable.OFFHAND);
	}

	public ItemStack getItemInHand(EnumUsedHand var1) {
		if (var1 == EnumUsedHand.MAIN_HAND) {
			return this.a(EnumWearable.MAINHAND);
		} else if (var1 == EnumUsedHand.OFF_HAND) {
			return this.a(EnumWearable.OFFHAND);
		} else {
			throw new IllegalArgumentException("Invalid hand " + var1);
		}
	}

	public void a(EnumUsedHand var1, ItemStack var2) {
		if (var1 == EnumUsedHand.MAIN_HAND) {
			this.a(EnumWearable.MAINHAND, var2);
		} else {
			if (var1 != EnumUsedHand.OFF_HAND) {
				throw new IllegalArgumentException("Invalid hand " + var1);
			}

			this.a(EnumWearable.OFFHAND, var2);
		}

	}

	public abstract Iterable<?> at();

	public abstract ItemStack a(EnumWearable var1);

	public abstract void a(EnumWearable var1, ItemStack var2);

	public void d(boolean var1) {
		super.d(var1);
		class_ql var2 = this.a(class_wl.d);
		if (var2.a(a) != null) {
			var2.c(b);
		}

		if (var1) {
			var2.b(b);
		}

	}

	protected float bC() {
		return 1.0F;
	}

	protected float bD() {
		return this.isBaby() ? (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.5F : (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F;
	}

	protected boolean bE() {
		return this.getHealth() <= 0.0F;
	}

	public void q(Entity var1) {
		double var3 = var1.locX;
		double var5 = var1.getBoundingBox().yMin + (double) var1.length;
		double var7 = var1.locZ;
		byte var9 = 1;

		for (int var10 = -var9; var10 <= var9; ++var10) {
			for (int var11 = -var9; var11 < var9; ++var11) {
				if (var10 != 0 || var11 != 0) {
					int var12 = (int) (this.locX + (double) var10);
					int var13 = (int) (this.locZ + (double) var11);
					AxisAlignedBB var2 = this.getBoundingBox().c((double) var10, 1.0D, (double) var11);
					if (this.world.a(var2).isEmpty()) {
						if (World.a((IBlockAccess) this.world, (BlockPosition) (new BlockPosition(var12, (int) this.locY, var13)))) {
							this.enderTeleportTo(this.locX + (double) var10, this.locY + 1.0D, this.locZ + (double) var11);
							return;
						}

						if (World.a((IBlockAccess) this.world, (BlockPosition) (new BlockPosition(var12, (int) this.locY - 1, var13))) || this.world.getType(new BlockPosition(var12, (int) this.locY - 1, var13)).getBlock().getMaterial() == Material.WATER) {
							var3 = this.locX + (double) var10;
							var5 = this.locY + 1.0D;
							var7 = this.locZ + (double) var11;
						}
					}
				}
			}
		}

		this.enderTeleportTo(var3, var5, var7);
	}

	protected float bF() {
		return 0.42F;
	}

	protected void bG() {
		this.motY = (double) this.bF();
		if (this.hasEffect(MobEffectList.h)) {
			this.motY += (double) ((float) (this.getEffect(MobEffectList.h).c() + 1) * 0.1F);
		}

		if (this.ay()) {
			float var1 = this.yaw * 0.017453292F;
			this.motX -= (double) (MathHelper.sin(var1) * 0.2F);
			this.motZ += (double) (MathHelper.cos(var1) * 0.2F);
		}

		this.ai = true;
	}

	protected void bH() {
		this.motY += 0.03999999910593033D;
	}

	protected void bI() {
		this.motY += 0.03999999910593033D;
	}

	public void g(float var1, float var2) {
		double var3;
		float var10;
		if (this.bN()) {
			float var5;
			float var6;
			if (this.V() && (!(this instanceof EntityHuman) || !((EntityHuman) this).abilities.flying)) {
				var3 = this.locY;
				var5 = 0.8F;
				var6 = 0.02F;
				var10 = (float) EnchantmentManager.d(this);
				if (var10 > 3.0F) {
					var10 = 3.0F;
				}

				if (!this.onGround) {
					var10 *= 0.5F;
				}

				if (var10 > 0.0F) {
					var5 += (0.54600006F - var5) * var10 / 3.0F;
					var6 += (this.bJ() * 1.0F - var6) * var10 / 3.0F;
				}

				this.a(var1, var2, var6);
				this.d(this.motX, this.motY, this.motZ);
				this.motX *= (double) var5;
				this.motY *= 0.800000011920929D;
				this.motZ *= (double) var5;
				this.motY -= 0.02D;
				if (this.positionChanged && this.c(this.motX, this.motY + 0.6000000238418579D - this.locY + var3, this.motZ)) {
					this.motY = 0.30000001192092896D;
				}
			} else if (!this.ab() || this instanceof EntityHuman && ((EntityHuman) this).abilities.flying) {
				float var8 = 0.91F;
				if (this.onGround) {
					var8 = this.world.getType(new BlockPosition(MathHelper.floor(this.locX), MathHelper.floor(this.getBoundingBox().yMin) - 1, MathHelper.floor(this.locZ))).getBlock().frictionFactor * 0.91F;
				}

				float var4 = 0.16277136F / (var8 * var8 * var8);
				if (this.onGround) {
					var5 = this.bJ() * var4;
				} else {
					var5 = this.aP;
				}

				this.a(var1, var2, var5);
				var8 = 0.91F;
				if (this.onGround) {
					var8 = this.world.getType(new BlockPosition(MathHelper.floor(this.locX), MathHelper.floor(this.getBoundingBox().yMin) - 1, MathHelper.floor(this.locZ))).getBlock().frictionFactor * 0.91F;
				}

				if (this.k_()) {
					var6 = 0.15F;
					this.motX = MathHelper.clamp(this.motX, (double) (-var6), (double) var6);
					this.motZ = MathHelper.clamp(this.motZ, (double) (-var6), (double) var6);
					this.fallDistance = 0.0F;
					if (this.motY < -0.15D) {
						this.motY = -0.15D;
					}

					boolean var7 = this.ax() && this instanceof EntityHuman;
					if (var7 && this.motY < 0.0D) {
						this.motY = 0.0D;
					}
				}

				this.d(this.motX, this.motY, this.motZ);
				if (this.positionChanged && this.k_()) {
					this.motY = 0.2D;
				}

				if (this.hasEffect(MobEffectList.y)) {
					this.motY += (0.05D * (double) (this.getEffect(MobEffectList.y).c() + 1) - this.motY) * 0.2D;
				} else if (!this.world.isClientSide || this.world.isLoaded(new BlockPosition((int) this.locX, 0, (int) this.locZ)) && this.world.f(new BlockPosition((int) this.locX, 0, (int) this.locZ)).o()) {
					this.motY -= 0.08D;
				} else if (this.locY > 0.0D) {
					this.motY = -0.1D;
				} else {
					this.motY = 0.0D;
				}

				this.motY *= 0.9800000190734863D;
				this.motX *= (double) var8;
				this.motZ *= (double) var8;
			} else {
				var3 = this.locY;
				this.a(var1, var2, 0.02F);
				this.d(this.motX, this.motY, this.motZ);
				this.motX *= 0.5D;
				this.motY *= 0.5D;
				this.motZ *= 0.5D;
				this.motY -= 0.02D;
				if (this.positionChanged && this.c(this.motX, this.motY + 0.6000000238418579D - this.locY + var3, this.motZ)) {
					this.motY = 0.30000001192092896D;
				}
			}
		}

		this.aD = this.aE;
		var3 = this.locX - this.lastX;
		double var9 = this.locZ - this.lastZ;
		var10 = MathHelper.sqrt(var3 * var3 + var9 * var9) * 4.0F;
		if (var10 > 1.0F) {
			var10 = 1.0F;
		}

		this.aE += (var10 - this.aE) * 0.4F;
		this.aF += this.aE;
	}

	public float bJ() {
		return this.bw;
	}

	public void k(float var1) {
		this.bw = var1;
	}

	public boolean r(Entity var1) {
		this.p(var1);
		return false;
	}

	public boolean isSleeping() {
		return false;
	}

	public void t_() {
		super.t_();
		this.bU();
		if (!this.world.isClientSide) {
			int var1 = this.bw();
			if (var1 > 0) {
				if (this.aw <= 0) {
					this.aw = 20 * (30 - var1);
				}

				--this.aw;
				if (this.aw <= 0) {
					this.l(var1 - 1);
				}
			}

			EnumWearable[] var2 = EnumWearable.values();
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				EnumWearable var5 = var2[var4];
				ItemStack var6;
				switch (EntityLiving.SyntheticClass_1.a[var5.getSlot().ordinal()]) {
					case 1:
						var6 = this.bp[var5.getRelative()];
						break;
					case 2:
						var6 = this.bq[var5.getRelative()];
						break;
					default:
						continue;
				}

				ItemStack var7 = this.a(var5);
				if (!ItemStack.b(var7, var6)) {
					((WorldServer) this.world).t().a((Entity) this, (Packet<?>) (new PacketPlayOutEntityEquipment(this.getId(), var5, var7)));
					if (var6 != null) {
						this.by().a(var6.a(var5));
					}

					if (var7 != null) {
						this.by().b(var7.a(var5));
					}

					switch (EntityLiving.SyntheticClass_1.a[var5.getSlot().ordinal()]) {
						case 1:
							this.bp[var5.getRelative()] = var7 == null ? null : var7.clone();
							break;
						case 2:
							this.bq[var5.getRelative()] = var7 == null ? null : var7.clone();
					}
				}
			}

			if (this.ticksLived % 20 == 0) {
				this.bt().g();
			}

			if (!this.glowing) {
				boolean var10 = this.hasEffect(MobEffectList.x);
				if (this.h(6) != var10) {
					this.b(6, var10);
				}
			}
		}

		this.m();
		double var9 = this.locX - this.lastX;
		double var11 = this.locZ - this.lastZ;
		float var12 = (float) (var9 * var9 + var11 * var11);
		float var13 = this.aL;
		float var14 = 0.0F;
		this.aU = this.aV;
		float var8 = 0.0F;
		if (var12 > 0.0025000002F) {
			var8 = 1.0F;
			var14 = (float) Math.sqrt((double) var12) * 3.0F;
			var13 = (float) MathHelper.b(var11, var9) * 180.0F / 3.1415927F - 90.0F;
		}

		if (this.aC > 0.0F) {
			var13 = this.yaw;
		}

		if (!this.onGround) {
			var8 = 0.0F;
		}

		this.aV += (var8 - this.aV) * 0.3F;
		this.world.B.a("headTurn");
		var14 = this.h(var13, var14);
		this.world.B.b();
		this.world.B.a("rangeChecks");

		while (this.yaw - this.lastYaw < -180.0F) {
			this.lastYaw -= 360.0F;
		}

		while (this.yaw - this.lastYaw >= 180.0F) {
			this.lastYaw += 360.0F;
		}

		while (this.aL - this.aM < -180.0F) {
			this.aM -= 360.0F;
		}

		while (this.aL - this.aM >= 180.0F) {
			this.aM += 360.0F;
		}

		while (this.pitch - this.lastPitch < -180.0F) {
			this.lastPitch -= 360.0F;
		}

		while (this.pitch - this.lastPitch >= 180.0F) {
			this.lastPitch += 360.0F;
		}

		while (this.aN - this.aO < -180.0F) {
			this.aO -= 360.0F;
		}

		while (this.aN - this.aO >= 180.0F) {
			this.aO += 360.0F;
		}

		this.world.B.b();
		this.aW += var14;
	}

	protected float h(float var1, float var2) {
		float var3 = MathHelper.clampAngle(var1 - this.aL);
		this.aL += var3 * 0.3F;
		float var4 = MathHelper.clampAngle(this.yaw - this.aL);
		boolean var5 = var4 < -90.0F || var4 >= 90.0F;
		if (var4 < -75.0F) {
			var4 = -75.0F;
		}

		if (var4 >= 75.0F) {
			var4 = 75.0F;
		}

		this.aL = this.yaw - var4;
		if (var4 * var4 > 2500.0F) {
			this.aL += var4 * 0.2F;
		}

		if (var5) {
			var2 *= -1.0F;
		}

		return var2;
	}

	public void m() {
		if (this.bx > 0) {
			--this.bx;
		}

		if (this.bf > 0) {
			double var1 = this.locX + (this.bg - this.locX) / (double) this.bf;
			double var3 = this.locY + (this.bh - this.locY) / (double) this.bf;
			double var5 = this.locZ + (this.bi - this.locZ) / (double) this.bf;
			double var7 = MathHelper.clampAngle(this.bj - (double) this.yaw);
			this.yaw = (float) ((double) this.yaw + var7 / (double) this.bf);
			this.pitch = (float) ((double) this.pitch + (this.bk - (double) this.pitch) / (double) this.bf);
			--this.bf;
			this.setPosition(var1, var3, var5);
			this.b(this.yaw, this.pitch);
		} else if (!this.bN()) {
			this.motX *= 0.98D;
			this.motY *= 0.98D;
			this.motZ *= 0.98D;
		}

		if (Math.abs(this.motX) < 0.005D) {
			this.motX = 0.0D;
		}

		if (Math.abs(this.motY) < 0.005D) {
			this.motY = 0.0D;
		}

		if (Math.abs(this.motZ) < 0.005D) {
			this.motZ = 0.0D;
		}

		this.world.B.a("ai");
		if (this.bE()) {
			this.bb = false;
			this.bc = 0.0F;
			this.bd = 0.0F;
			this.be = 0.0F;
		} else if (this.bN()) {
			this.world.B.a("newAi");
			this.bL();
			this.world.B.b();
		}

		this.world.B.b();
		this.world.B.a("jump");
		if (this.bb) {
			if (this.V()) {
				this.bH();
			} else if (this.ab()) {
				this.bI();
			} else if (this.onGround && this.bx == 0) {
				this.bG();
				this.bx = 10;
			}
		} else {
			this.bx = 0;
		}

		this.world.B.b();
		this.world.B.a("travel");
		this.bc *= 0.98F;
		this.bd *= 0.98F;
		this.be *= 0.9F;
		this.g(this.bc, this.bd);
		this.world.B.b();
		this.world.B.a("push");
		if (!this.world.isClientSide) {
			this.bM();
		}

		this.world.B.b();
	}

	protected void bL() {
	}

	protected void bM() {
		List<?> var1 = this.world.a((Entity) this, (AxisAlignedBB) this.getBoundingBox().grow(0.20000000298023224D, 0.0D, 0.20000000298023224D), (Predicate<Entity>) Predicates.and(IEntitySelector.NOT_PLAYER_SPECTATOR, new Predicate<Object>() {
			public boolean a(Entity var1) {
				return var1.ae();
			}

			// $FF: synthetic method
			public boolean apply(Object var1) {
				return this.a((Entity) var1);
			}
		}));
		if (!var1.isEmpty()) {
			for (int var2 = 0; var2 < var1.size(); ++var2) {
				Entity var3 = (Entity) var1.get(var2);
				this.s(var3);
			}
		}

	}

	protected void s(Entity var1) {
		var1.i(this);
	}

	public void a(Entity var1) {
		if (this.vehicle != null && var1 == null) {
			if (!this.world.isClientSide) {
				this.q(this.vehicle);
			}

			if (this.vehicle != null) {
				this.vehicle.passenger = null;
			}

			this.vehicle = null;
		} else {
			super.a(var1);
		}
	}

	public void ak() {
		super.ak();
		this.aU = this.aV;
		this.aV = 0.0F;
		this.fallDistance = 0.0F;
	}

	public void i(boolean var1) {
		this.bb = var1;
	}

	public void receive(Entity var1, int var2) {
		if (!var1.dead && !this.world.isClientSide) {
			class_lb var3 = ((WorldServer) this.world).t();
			if (var1 instanceof EntityItem) {
				var3.a((Entity) var1, (Packet<?>) (new PacketPlayOutCollect(var1.getId(), this.getId())));
			}

			if (var1 instanceof EntityArrow) {
				var3.a((Entity) var1, (Packet<?>) (new PacketPlayOutCollect(var1.getId(), this.getId())));
			}

			if (var1 instanceof EntityExperienceOrb) {
				var3.a((Entity) var1, (Packet<?>) (new PacketPlayOutCollect(var1.getId(), this.getId())));
			}
		}

	}

	public boolean t(Entity var1) {
		return this.world.a(new Vec3D(this.locX, this.locY + (double) this.getHeadHeight(), this.locZ), new Vec3D(var1.locX, var1.locY + (double) var1.getHeadHeight(), var1.locZ)) == null;
	}

	public Vec3D ap() {
		return this.d(1.0F);
	}

	public Vec3D d(float var1) {
		if (var1 == 1.0F) {
			return this.f(this.pitch, this.aN);
		} else {
			float var2 = this.lastPitch + (this.pitch - this.lastPitch) * var1;
			float var3 = this.aO + (this.aN - this.aO) * var1;
			return this.f(var2, var3);
		}
	}

	public boolean bN() {
		return !this.world.isClientSide;
	}

	public boolean ad() {
		return !this.dead;
	}

	public boolean ae() {
		return !this.dead;
	}

	protected void ac() {
		this.velocityChanged = this.random.nextDouble() >= this.a(class_wl.c).e();
	}

	public float aE() {
		return this.aN;
	}

	public void f(float var1) {
		this.aN = var1;
	}

	public void g(float var1) {
		this.aL = var1;
	}

	public float getAbsorptionHearts() {
		return this.by;
	}

	public void setAbsorptionHearts(float var1) {
		if (var1 < 0.0F) {
			var1 = 0.0F;
		}

		this.by = var1;
	}

	public class_awp bP() {
		return this.world.aa().h(this.getUniqueId().toString());
	}

	public boolean c(EntityLiving var1) {
		return this.a(var1.bP());
	}

	public boolean a(class_awp var1) {
		return this.bP() != null ? this.bP().a(var1) : false;
	}

	public void h_() {
	}

	public void j() {
	}

	protected void bQ() {
		this.br = true;
	}

	public boolean bS() {
		return (this.datawatcher.getInt(USED_HAND_DW_ID) & 1) > 0;
	}

	public EnumUsedHand bT() {
		return (this.datawatcher.getInt(USED_HAND_DW_ID) & 2) > 0 ? EnumUsedHand.OFF_HAND : EnumUsedHand.MAIN_HAND;
	}

	protected void bU() {
		if (this.bS()) {
			ItemStack var1 = this.getItemInHand(this.bT());
			if (var1 == this.bl) {
				if (this.bW() <= 25 && this.bW() % 4 == 0) {
					this.a((ItemStack) this.bl, 5);
				}

				if (--this.bm == 0 && !this.world.isClientSide) {
					this.s();
				}
			} else {
				this.bZ();
			}
		}

	}

	public void c(EnumUsedHand var1) {
		ItemStack var2 = this.getItemInHand(var1);
		if (var2 != null && !this.bS()) {
			this.bl = var2;
			this.bm = var2.l();
			if (!this.world.isClientSide) {
				int var3 = 1;
				if (var1 == EnumUsedHand.OFF_HAND) {
					var3 |= 2;
				}

				this.datawatcher.update(USED_HAND_DW_ID, Integer.valueOf(var3));
			}

		}
	}

	public void d(int var1) {
		super.d(var1);
		if (var1 == USED_HAND_DW_ID && this.world.isClientSide) {
			if (this.bS() && this.bl == null) {
				this.bl = this.getItemInHand(this.bT());
				if (this.bl != null) {
					this.bm = this.bl.l();
				}
			} else if (!this.bS() && this.bl != null) {
				this.bl = null;
				this.bm = 0;
			}
		}

	}

	protected void a(ItemStack var1, int var2) {
		if (var1 != null && this.bS()) {
			if (var1.m() == EnumAnimation.DRINK) {
				this.makeSound("random.drink", 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
			}

			if (var1.m() == EnumAnimation.EAT) {
				for (int var3 = 0; var3 < var2; ++var3) {
					Vec3D var4 = new Vec3D(((double) this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
					var4 = var4.rotatePitch(-this.pitch * 3.1415927F / 180.0F);
					var4 = var4.rotateYaw(-this.yaw * 3.1415927F / 180.0F);
					double var5 = (double) (-this.random.nextFloat()) * 0.6D - 0.3D;
					Vec3D var7 = new Vec3D(((double) this.random.nextFloat() - 0.5D) * 0.3D, var5, 0.6D);
					var7 = var7.rotatePitch(-this.pitch * 3.1415927F / 180.0F);
					var7 = var7.rotateYaw(-this.yaw * 3.1415927F / 180.0F);
					var7 = var7.add(this.locX, this.locY + (double) this.getHeadHeight(), this.locZ);
					if (var1.f()) {
						this.world.addParticle(EnumParticle.K, var7.x, var7.y, var7.z, var4.x, var4.y + 0.05D, var4.z, new int[] { Item.getId(var1.getItem()), var1.i() });
					} else {
						this.world.addParticle(EnumParticle.K, var7.x, var7.y, var7.z, var4.x, var4.y + 0.05D, var4.z, new int[] { Item.getId(var1.getItem()) });
					}
				}

				this.makeSound("random.eat", 0.5F + 0.5F * (float) this.random.nextInt(2), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			}

		}
	}

	protected void s() {
		if (this.bl != null && this.bS()) {
			this.a((ItemStack) this.bl, 16);
			ItemStack var1 = this.bl.a(this.world, this);
			if (var1 != null && var1.count == 0) {
				var1 = null;
			}

			this.a(this.bT(), var1);
			this.bZ();
		}

	}

	public int bW() {
		return this.bm;
	}

	public int bX() {
		return this.bS() ? this.bl.l() - this.bW() : 0;
	}

	public void bY() {
		if (this.bl != null) {
			this.bl.a(this.world, this, this.bW());
		}

		this.bZ();
	}

	public void bZ() {
		if (!this.world.isClientSide) {
			this.datawatcher.update(USED_HAND_DW_ID, Integer.valueOf(0));
		}

		this.bl = null;
		this.bm = 0;
	}

	public boolean ca() {
		return this.bS() && this.bl != null && this.bl.getItem().getAnimation(this.bl) == EnumAnimation.BLOCK;
	}

	static {
		b = (new class_qm(a, "Sprinting speed boost", 0.30000001192092896D, 2)).a(false);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[EnumWearable.SLOT.values().length];

		static {
			try {
				a[EnumWearable.SLOT.HAND.ordinal()] = 1;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[EnumWearable.SLOT.ARMOR.ordinal()] = 2;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
