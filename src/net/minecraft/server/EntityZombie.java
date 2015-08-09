package net.minecraft.server;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class EntityZombie extends EntityMonster {

	protected static final class_qk a = (new class_qs((class_qk) null, "zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).a("Spawn Reinforcements Chance");
	private static final UUID b = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
	private static final class_qm c;
	private static final int BABY_DW_ID = DataWathcer.claimId(EntityZombie.class); //value = 11
	private static final int VILLAGER_DW_ID = DataWathcer.claimId(EntityZombie.class); //value = 12
	private static final int CONVERSION_DW_ID = DataWathcer.claimId(EntityZombie.class); //value = 13

	private final class_rd bv = new class_rd(this);
	private int bw;
	private boolean bx = false;
	private float by = -1.0F;
	private float bz;

	public EntityZombie(World var1) {
		super(var1);
		((class_tf) this.u()).b(true);
		this.i.a(0, new class_rj(this));
		this.i.a(2, new class_ru(this, EntityHuman.class, 1.0D, false));
		this.i.a(5, new class_ry(this, 1.0D));
		this.i.a(7, new class_si(this, 1.0D));
		this.i.a(8, new class_rr(this, EntityHuman.class, 8.0F));
		this.i.a(8, new class_sh(this));
		this.n();
		this.a(0.6F, 1.95F);
	}

	protected void n() {
		this.i.a(4, new class_ru(this, EntityVillager.class, 1.0D, true));
		this.i.a(4, new class_ru(this, EntityVillagerGolem.class, 1.0D, true));
		this.i.a(6, new class_rw(this, 1.0D, false));
		this.bn.a(1, new class_sw(this, true, new Class[] { EntityPigZombie.class }));
		this.bn.a(2, new class_sz(this, EntityHuman.class, true));
		this.bn.a(2, new class_sz(this, EntityVillager.class, false));
		this.bn.a(2, new class_sz(this, EntityVillagerGolem.class, true));
	}

	protected void aY() {
		super.aY();
		this.a((class_qk) class_wl.b).a(35.0D);
		this.a((class_qk) class_wl.d).a(0.23000000417232513D);
		this.a((class_qk) class_wl.e).a(3.0D);
		this.by().b(a).a(this.random.nextDouble() * 0.10000000149011612D);
	}

	protected void initDatawatcher() {
		super.initDatawatcher();
		this.H().add(BABY_DW_ID, Byte.valueOf((byte) 0));
		this.H().add(VILLAGER_DW_ID, Byte.valueOf((byte) 0));
		this.H().add(CONVERSION_DW_ID, Byte.valueOf((byte) 0));
	}

	public int bs() {
		int var1 = super.bs() + 2;
		if (var1 > 20) {
			var1 = 20;
		}

		return var1;
	}

	public boolean cC() {
		return this.bx;
	}

	public void a(boolean var1) {
		if (this.bx != var1) {
			this.bx = var1;
			if (var1) {
				this.i.a(1, this.bv);
			} else {
				this.i.a((class_rm) this.bv);
			}
		}

	}

	public boolean isBaby() {
		return this.H().getByte(BABY_DW_ID) == 1;
	}

	protected int b(EntityHuman var1) {
		if (this.isBaby()) {
			this.b_ = (int) ((float) this.b_ * 2.5F);
		}

		return super.b(var1);
	}

	public void setBaby(boolean var1) {
		this.H().update(BABY_DW_ID, Byte.valueOf((byte) (var1 ? 1 : 0)));
		if (this.world != null && !this.world.isClientSide) {
			class_ql var2 = this.a((class_qk) class_wl.d);
			var2.c(c);
			if (var1) {
				var2.b(c);
			}
		}

		this.o(var1);
	}

	public boolean isVillager() {
		return this.H().getByte(VILLAGER_DW_ID) == 1;
	}

	public void setVillager(boolean var1) {
		this.H().update(VILLAGER_DW_ID, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	public void d(int var1) {
		if (var1 == BABY_DW_ID) {
			this.o(this.isBaby());
		}

		super.d(var1);
	}

	public void m() {
		if (this.world.x() && !this.world.isClientSide && !this.isBaby()) {
			float var1 = this.c(1.0F);
			BlockPosition var2 = new BlockPosition(this.locX, (double) Math.round(this.locY), this.locZ);
			if (var1 > 0.5F && this.random.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.world.i(var2)) {
				boolean var3 = true;
				ItemStack var4 = this.a((EnumWearable) EnumWearable.HEAD);
				if (var4 != null) {
					if (var4.e()) {
						var4.setData(var4.h() + this.random.nextInt(2));
						if (var4.h() >= var4.j()) {
							this.b((ItemStack) var4);
							this.a((EnumWearable) EnumWearable.HEAD, (ItemStack) null);
						}
					}

					var3 = false;
				}

				if (var3) {
					this.f(8);
				}
			}
		}

		if (this.aw() && this.w() != null && this.vehicle instanceof EntityChicken) {
			((EntityInsentient) this.vehicle).u().a(this.u().j(), 1.5D);
		}

		super.m();
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (super.damageEntity(var1, var2)) {
			EntityLiving var3 = this.w();
			if (var3 == null && var1.j() instanceof EntityLiving) {
				var3 = (EntityLiving) var1.j();
			}

			if (var3 != null && this.world.ab() == class_om.d && (double) this.random.nextFloat() < this.a((class_qk) a).e()) {
				int var4 = MathHelper.floor(this.locX);
				int var5 = MathHelper.floor(this.locY);
				int var6 = MathHelper.floor(this.locZ);
				EntityZombie var7 = new EntityZombie(this.world);

				for (int var8 = 0; var8 < 50; ++var8) {
					int var9 = var4 + MathHelper.getRandomIntInRange((Random) this.random, 7, 40) * MathHelper.getRandomIntInRange((Random) this.random, -1, 1);
					int var10 = var5 + MathHelper.getRandomIntInRange((Random) this.random, 7, 40) * MathHelper.getRandomIntInRange((Random) this.random, -1, 1);
					int var11 = var6 + MathHelper.getRandomIntInRange((Random) this.random, 7, 40) * MathHelper.getRandomIntInRange((Random) this.random, -1, 1);
					if (World.a((IBlockAccess) this.world, (BlockPosition) (new BlockPosition(var9, var10 - 1, var11))) && this.world.l(new BlockPosition(var9, var10, var11)) < 10) {
						var7.b((double) var9, (double) var10, (double) var11);
						if (!this.world.b((double) var9, (double) var10, (double) var11, 7.0D) && this.world.a((AxisAlignedBB) var7.getBoundingBox(), (Entity) var7) && this.world.getCubes((Entity) var7, (AxisAlignedBB) var7.getBoundingBox()).isEmpty() && !this.world.containsLiquid(var7.getBoundingBox())) {
							this.world.addEntity((Entity) var7);
							var7.d(var3);
							var7.a((class_on) this.world.E(new BlockPosition(var7)), (class_qd) null);
							this.a((class_qk) a).b(new class_qm("Zombie reinforcement caller charge", -0.05000000074505806D, 0));
							var7.a((class_qk) a).b(new class_qm("Zombie reinforcement callee charge", -0.05000000074505806D, 0));
							break;
						}
					}
				}
			}

			return true;
		} else {
			return false;
		}
	}

	public void t_() {
		if (!this.world.isClientSide && this.isConversing()) {
			int var1 = this.cG();
			this.bw -= var1;
			if (this.bw <= 0) {
				this.cF();
			}
		}

		super.t_();
	}

	public boolean r(Entity var1) {
		boolean var2 = super.r(var1);
		if (var2) {
			int var3 = this.world.ab().a();
			if (this.bA() == null && this.av() && this.random.nextFloat() < (float) var3 * 0.3F) {
				var1.f(2 * var3);
			}
		}

		return var2;
	}

	protected String C() {
		return "mob.zombie.say";
	}

	protected String bp() {
		return "mob.zombie.hurt";
	}

	protected String bq() {
		return "mob.zombie.death";
	}

	protected void a(BlockPosition var1, Block var2) {
		this.makeSound("mob.zombie.step", 0.15F, 1.0F);
	}

	protected Item D() {
		return Items.ROTTEN_FLESH;
	}

	public class_qf bz() {
		return class_qf.b;
	}

	protected void br() {
		switch (this.random.nextInt(3)) {
			case 0:
				this.a(Items.IRON_INGOT, 1);
				break;
			case 1:
				this.a(Items.CARROT, 1);
				break;
			case 2:
				this.a(Items.POTATO, 1);
		}

	}

	protected void a(class_on var1) {
		super.a(var1);
		if (this.random.nextFloat() < (this.world.ab() == class_om.d ? 0.05F : 0.01F)) {
			int var2 = this.random.nextInt(3);
			if (var2 == 0) {
				this.a((EnumWearable) EnumWearable.MAINHAND, (ItemStack) (new ItemStack(Items.IRON_SWORD)));
			} else {
				this.a((EnumWearable) EnumWearable.MAINHAND, (ItemStack) (new ItemStack(Items.IRON_SHOVEL)));
			}
		}

	}

	public void write(NBTTagCompound var1) {
		super.write(var1);
		if (this.isBaby()) {
			var1.put("IsBaby", true);
		}

		if (this.isVillager()) {
			var1.put("IsVillager", true);
		}

		var1.put("ConversionTime", this.isConversing() ? this.bw : -1);
		var1.put("CanBreakDoors", this.cC());
	}

	public void read(NBTTagCompound var1) {
		super.read(var1);
		if (var1.getBoolean("IsBaby")) {
			this.setBaby(true);
		}

		if (var1.getBoolean("IsVillager")) {
			this.setVillager(true);
		}

		if (var1.hasOfType("ConversionTime", 99) && var1.getInt("ConversionTime") > -1) {
			this.setConversionTime(var1.getInt("ConversionTime"));
		}

		this.a(var1.getBoolean("CanBreakDoors"));
	}

	public void a(EntityLiving var1) {
		super.a(var1);
		if ((this.world.ab() == class_om.c || this.world.ab() == class_om.d) && var1 instanceof EntityVillager) {
			if (this.world.ab() != class_om.d && this.random.nextBoolean()) {
				return;
			}

			EntityInsentient var2 = (EntityInsentient) var1;
			EntityZombie var3 = new EntityZombie(this.world);
			var3.m(var1);
			this.world.e((Entity) var1);
			var3.a((class_on) this.world.E(new BlockPosition(var3)), (class_qd) null);
			var3.setVillager(true);
			if (var1.isBaby()) {
				var3.setBaby(true);
			}

			var3.k(var2.cs());
			if (var2.hasCustomName()) {
				var3.a((String) var2.getCustomName());
				var3.g(var2.isCustomNameVisible());
			}

			this.world.addEntity((Entity) var3);
			this.world.a((EntityHuman) null, 1016, new BlockPosition((int) this.locX, (int) this.locY, (int) this.locZ), 0);
		}

	}

	public float getHeadHeight() {
		float var1 = 1.74F;
		if (this.isBaby()) {
			var1 = (float) ((double) var1 - 0.81D);
		}

		return var1;
	}

	protected boolean a(ItemStack var1) {
		return var1.getItem() == Items.EGG && this.isBaby() && this.aw() ? false : super.a(var1);
	}

	public class_qd a(class_on var1, class_qd var2) {
		Object var7 = super.a(var1, var2);
		float var3 = var1.c();
		this.j(this.random.nextFloat() < 0.55F * var3);
		if (var7 == null) {
			var7 = new EntityZombie.class_a_in_class_wr(this.world.random.nextFloat() < 0.05F, this.world.random.nextFloat() < 0.05F);
		}

		if (var7 instanceof EntityZombie.class_a_in_class_wr) {
			EntityZombie.class_a_in_class_wr var4 = (EntityZombie.class_a_in_class_wr) var7;
			if (var4.b) {
				this.setVillager(true);
			}

			if (var4.a) {
				this.setBaby(true);
				if ((double) this.world.random.nextFloat() < 0.05D) {
					List var5 = this.world.a(EntityChicken.class, this.getBoundingBox().grow(5.0D, 3.0D, 5.0D), IEntitySelector.IS_ALIVE_AND_NOT_MOUNTED);
					if (!var5.isEmpty()) {
						EntityChicken var6 = (EntityChicken) var5.get(0);
						var6.m(true);
						this.a((Entity) var6);
					}
				} else if ((double) this.world.random.nextFloat() < 0.05D) {
					EntityChicken var10 = new EntityChicken(this.world);
					var10.b(this.locX, this.locY, this.locZ, this.yaw, 0.0F);
					var10.a(var1, (class_qd) null);
					var10.m(true);
					this.world.addEntity((Entity) var10);
					this.a((Entity) var10);
				}
			}
		}

		this.a(this.random.nextFloat() < var3 * 0.1F);
		this.a(var1);
		this.b((class_on) var1);
		if (this.a((EnumWearable) EnumWearable.HEAD) == null) {
			Calendar var8 = this.world.Z();
			if (var8.get(2) + 1 == 10 && var8.get(5) == 31 && this.random.nextFloat() < 0.25F) {
				this.a((EnumWearable) EnumWearable.HEAD, (ItemStack) (new ItemStack(this.random.nextFloat() < 0.1F ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN)));
				this.bp[EnumWearable.HEAD.getRelative()] = 0.0F;
			}
		}

		this.a((class_qk) class_wl.c).b(new class_qm("Random spawn bonus", this.random.nextDouble() * 0.05000000074505806D, 0));
		double var9 = this.random.nextDouble() * 1.5D * (double) var3;
		if (var9 > 1.0D) {
			this.a((class_qk) class_wl.b).b(new class_qm("Random zombie-spawn bonus", var9, 2));
		}

		if (this.random.nextFloat() < var3 * 0.05F) {
			this.a((class_qk) a).b(new class_qm("Leader zombie bonus", this.random.nextDouble() * 0.25D + 0.5D, 0));
			this.a((class_qk) class_wl.a).b(new class_qm("Leader zombie bonus", this.random.nextDouble() * 3.0D + 1.0D, 2));
			this.a(true);
		}

		return (class_qd) var7;
	}

	public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
		if (var3 != null && var3.getItem() == Items.GOLDEN_APPLE && var3.i() == 0 && this.isVillager() && this.hasEffect((MobEffectType) MobEffectList.r)) {
			if (!var1.abilities.instabuild) {
				--var3.count;
			}

			if (!this.world.isClientSide) {
				this.setConversionTime(this.random.nextInt(2401) + 3600);
			}

			return true;
		} else {
			return false;
		}
	}

	protected void setConversionTime(int var1) {
		this.bw = var1;
		this.H().update(CONVERSION_DW_ID, Byte.valueOf((byte) 1));
		this.d(MobEffectList.r);
		this.addEffect(new MobEffect(MobEffectList.e, var1, Math.min(this.world.ab().a() - 1, 0)));
		this.world.a((Entity) this, (byte) 16);
	}

	protected boolean E() {
		return !this.isConversing();
	}

	public boolean isConversing() {
		return this.H().getByte(CONVERSION_DW_ID) == 1;
	}

	protected void cF() {
		EntityVillager var1 = new EntityVillager(this.world);
		var1.m(this);
		var1.a(this.world.E(new BlockPosition(var1)), (class_qd) null);
		var1.cE();
		if (this.isBaby()) {
			var1.b(-24000);
		}

		this.world.e((Entity) this);
		var1.k(this.cs());
		if (this.hasCustomName()) {
			var1.a((String) this.getCustomName());
			var1.g(this.isCustomNameVisible());
		}

		this.world.addEntity((Entity) var1);
		var1.addEffect(new MobEffect(MobEffectList.i, 200, 0));
		this.world.a((EntityHuman) null, 1017, new BlockPosition((int) this.locX, (int) this.locY, (int) this.locZ), 0);
	}

	protected int cG() {
		int var1 = 1;
		if (this.random.nextFloat() < 0.01F) {
			int var2 = 0;
			BlockPosition.MutableBlockPosition var3 = new BlockPosition.MutableBlockPosition();

			for (int var4 = (int) this.locX - 4; var4 < (int) this.locX + 4 && var2 < 14; ++var4) {
				for (int var5 = (int) this.locY - 4; var5 < (int) this.locY + 4 && var2 < 14; ++var5) {
					for (int var6 = (int) this.locZ - 4; var6 < (int) this.locZ + 4 && var2 < 14; ++var6) {
						Block var7 = this.world.getType(var3.setPosition(var4, var5, var6)).getBlock();
						if (var7 == Blocks.IRON_BARS || var7 == Blocks.BED) {
							if (this.random.nextFloat() < 0.3F) {
								++var1;
							}

							++var2;
						}
					}
				}
			}
		}

		return var1;
	}

	public void o(boolean var1) {
		this.a(var1 ? 0.5F : 1.0F);
	}

	protected final void a(float var1, float var2) {
		boolean var3 = this.by > 0.0F && this.bz > 0.0F;
		this.by = var1;
		this.bz = var2;
		if (!var3) {
			this.a(1.0F);
		}

	}

	protected final void a(float var1) {
		super.a(this.by * var1, this.bz * var1);
	}

	public double am() {
		return this.isBaby() ? 0.0D : -0.35D;
	}

	public void a(DamageSource var1) {
		super.a(var1);
		if (var1.j() instanceof EntityCreeper && !(this instanceof EntityPigZombie) && ((EntityCreeper) var1.j()).isPowered() && ((EntityCreeper) var1.j()).cE()) {
			((EntityCreeper) var1.j()).cF();
			this.a(new ItemStack(Items.SKULL, 1, 2), 0.0F);
		}

	}

	static {
		c = new class_qm(b, "Baby speed boost", 0.5D, 1);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
	}

	class class_a_in_class_wr implements class_qd {
		public boolean a;
		public boolean b;

		private class_a_in_class_wr(boolean var2, boolean var3) {
			this.a = false;
			this.b = false;
			this.a = var2;
			this.b = var3;
		}

		// $FF: synthetic method
		class_a_in_class_wr(boolean var2, boolean var3, EntityZombie.SyntheticClass_1 var4) {
			this(var2, var3);
		}
	}
}
