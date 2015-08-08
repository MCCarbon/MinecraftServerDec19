package net.minecraft.server;

import java.util.Arrays;
import java.util.List;

public class EntityArmorStand extends EntityLiving {

	private static final class_dc br = new class_dc(0.0F, 0.0F, 0.0F);
	private static final class_dc bs = new class_dc(0.0F, 0.0F, 0.0F);
	private static final class_dc bt = new class_dc(-10.0F, 0.0F, -10.0F);
	private static final class_dc bu = new class_dc(-15.0F, 0.0F, 10.0F);
	private static final class_dc bv = new class_dc(-1.0F, 0.0F, -1.0F);
	private static final class_dc bw = new class_dc(1.0F, 0.0F, 1.0F);
	public static final int a = 1 << EnumWearable.MAINHAND.getAbsolute();
	public static final int b = 1 << EnumWearable.FEET.getAbsolute();
	public static final int c = 1 << EnumWearable.LEGS.getAbsolute();
	public static final int d = 1 << EnumWearable.TORSO.getAbsolute();
	public static final int e = 1 << EnumWearable.HEAD.getAbsolute();
	public static final int f = 1 << EnumWearable.OFFHAND.getAbsolute();
	public static final int INFO_DW_ID = DataWathcer.claimId(EntityArmorStand.class); //value = 10
	public static final int HEADPOS_DW_ID = DataWathcer.claimId(EntityArmorStand.class); //value = 11 
	public static final int BODYPOS_DW_ID = DataWathcer.claimId(EntityArmorStand.class); //value = 12
	public static final int LEFTARM_DW_ID = DataWathcer.claimId(EntityArmorStand.class); //value = 13
	public static final int RIGHTARM_DW_ID = DataWathcer.claimId(EntityArmorStand.class); //value = 14
	public static final int LEFTLEG_DW_ID = DataWathcer.claimId(EntityArmorStand.class); //value = 15
	public static final int RIGHTLEG_DW_ID = DataWathcer.claimId(EntityArmorStand.class); //value = 16

	private final ItemStack[] bx;
	private final ItemStack[] by;
	private boolean bz;
	private long bA;
	private int bB;
	private boolean bC;
	private class_dc bD;
	private class_dc bE;
	private class_dc bF;
	private class_dc bG;
	private class_dc bH;
	private class_dc bI;

	public EntityArmorStand(World var1) {
		super(var1);
		this.bx = new ItemStack[2];
		this.by = new ItemStack[4];
		this.bD = br;
		this.bE = bs;
		this.bF = bt;
		this.bG = bu;
		this.bH = bv;
		this.bI = bw;
		this.b(true);
		this.noclip = this.p();
		this.a(0.5F, 1.975F);
	}

	public EntityArmorStand(World var1, double var2, double var4, double var6) {
		this(var1);
		this.b(var2, var4, var6);
	}

	public boolean bN() {
		return super.bN() && !this.p();
	}

	protected void initDatawatcher() {
		super.initDatawatcher();
		this.datawatcher.add(INFO_DW_ID, Byte.valueOf((byte) 0));
		this.datawatcher.add(HEADPOS_DW_ID, br);
		this.datawatcher.add(BODYPOS_DW_ID, bs);
		this.datawatcher.add(LEFTARM_DW_ID, bt);
		this.datawatcher.add(RIGHTARM_DW_ID, bu);
		this.datawatcher.add(LEFTLEG_DW_ID, bv);
		this.datawatcher.add(RIGHTLEG_DW_ID, bw);
	}

	public Iterable as() {
		return Arrays.asList(this.bx);
	}

	public Iterable at() {
		return Arrays.asList(this.by);
	}

	public ItemStack a(EnumWearable var1) {
		ItemStack var2 = null;
		switch (EntityArmorStand.SyntheticClass_1.a[var1.getSlot().ordinal()]) {
			case 1:
				var2 = this.bx[var1.getRelative()];
				break;
			case 2:
				var2 = this.by[var1.getRelative()];
		}

		return var2;
	}

	public void a(EnumWearable var1, ItemStack var2) {
		switch (EntityArmorStand.SyntheticClass_1.a[var1.getSlot().ordinal()]) {
			case 1:
				this.bx[var1.getRelative()] = var2;
				break;
			case 2:
				this.by[var1.getRelative()] = var2;
		}

	}

	public boolean c(int var1, ItemStack var2) {
		EnumWearable var3;
		if (var1 == 98) {
			var3 = EnumWearable.MAINHAND;
		} else if (var1 == 100 + EnumWearable.HEAD.getRelative()) {
			var3 = EnumWearable.HEAD;
		} else if (var1 == 100 + EnumWearable.TORSO.getRelative()) {
			var3 = EnumWearable.TORSO;
		} else if (var1 == 100 + EnumWearable.LEGS.getRelative()) {
			var3 = EnumWearable.LEGS;
		} else {
			if (var1 != 100 + EnumWearable.FEET.getRelative()) {
				return false;
			}

			var3 = EnumWearable.FEET;
		}

		if (var2 != null && EntityInsentient.c(var2) != var3 && (var3 != EnumWearable.HEAD || !(var2.getItem() instanceof ItemBlock))) {
			return false;
		} else {
			this.a(var3, var2);
			return true;
		}
	}

	public void write(NBTTagCompound var1) {
		super.write(var1);
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < this.by.length; ++var3) {
			NBTTagCompound var4 = new NBTTagCompound();
			if (this.by[var3] != null) {
				this.by[var3].write(var4);
			}

			var2.add((NBTTag) var4);
		}

		var1.put((String) "ArmorItems", (NBTTag) var2);
		NBTTagList var6 = new NBTTagList();

		for (int var7 = 0; var7 < this.bx.length; ++var7) {
			NBTTagCompound var5 = new NBTTagCompound();
			if (this.bx[var7] != null) {
				this.bx[var7].write(var5);
			}

			var6.add((NBTTag) var5);
		}

		var1.put((String) "HandItems", (NBTTag) var6);
		if (this.isCustomNameVisible() && (this.getCustomName() == null || this.getCustomName().isEmpty())) {
			var1.put("CustomNameVisible", this.isCustomNameVisible());
		}

		var1.put("Invisible", this.aA());
		var1.put("Small", this.n());
		var1.put("ShowArms", this.q());
		var1.put("DisabledSlots", this.bB);
		var1.put("NoGravity", this.p());
		var1.put("NoBasePlate", this.r());
		if (this.t()) {
			var1.put("Marker", this.t());
		}

		var1.put((String) "Pose", (NBTTag) this.A());
	}

	public void read(NBTTagCompound var1) {
		super.read(var1);
		if (var1.hasOfType("Equipment", 9)) {
			ItemStack[] var2 = new ItemStack[5];
			NBTTagList var3 = var1.getList("Equipment", 10);

			for (int var4 = 0; var4 < var2.length; ++var4) {
				var2[var4] = ItemStack.a(var3.getCompound(var4));
			}

			this.bx[EnumWearable.MAINHAND.getRelative()] = var2[0];
			this.by[EnumWearable.FEET.getRelative()] = var2[1];
			this.by[EnumWearable.LEGS.getRelative()] = var2[2];
			this.by[EnumWearable.TORSO.getRelative()] = var2[3];
			this.by[EnumWearable.HEAD.getRelative()] = var2[4];
		} else {
			NBTTagList var5;
			int var7;
			if (var1.hasOfType("ArmorItems", 9)) {
				var5 = var1.getList("ArmorItems", 10);

				for (var7 = 0; var7 < this.by.length; ++var7) {
					this.by[var7] = ItemStack.a(var5.getCompound(var7));
				}
			}

			if (var1.hasOfType("HandItems", 9)) {
				var5 = var1.getList("HandItems", 10);

				for (var7 = 0; var7 < this.bx.length; ++var7) {
					this.bx[var7] = ItemStack.a(var5.getCompound(var7));
				}
			}
		}

		this.f(var1.getBoolean("Invisible"));
		this.j(var1.getBoolean("Small"));
		this.l(var1.getBoolean("ShowArms"));
		this.bB = var1.getInt("DisabledSlots");
		this.k(var1.getBoolean("NoGravity"));
		this.m(var1.getBoolean("NoBasePlate"));
		this.n(var1.getBoolean("Marker"));
		this.bC = !this.t();
		this.noclip = this.p();
		NBTTagCompound var6 = var1.getCompound("Pose");
		this.g(var6);
	}

	private void g(NBTTagCompound var1) {
		NBTTagList var2 = var1.getList("Head", 5);
		if (!var2.isEmpty()) {
			this.a(new class_dc(var2));
		} else {
			this.a(br);
		}

		NBTTagList var3 = var1.getList("Body", 5);
		if (!var3.isEmpty()) {
			this.b(new class_dc(var3));
		} else {
			this.b(bs);
		}

		NBTTagList var4 = var1.getList("LeftArm", 5);
		if (!var4.isEmpty()) {
			this.c(new class_dc(var4));
		} else {
			this.c(bt);
		}

		NBTTagList var5 = var1.getList("RightArm", 5);
		if (!var5.isEmpty()) {
			this.d(new class_dc(var5));
		} else {
			this.d(bu);
		}

		NBTTagList var6 = var1.getList("LeftLeg", 5);
		if (!var6.isEmpty()) {
			this.e(new class_dc(var6));
		} else {
			this.e(bv);
		}

		NBTTagList var7 = var1.getList("RightLeg", 5);
		if (!var7.isEmpty()) {
			this.f(new class_dc(var7));
		} else {
			this.f(bw);
		}

	}

	private NBTTagCompound A() {
		NBTTagCompound var1 = new NBTTagCompound();
		if (!br.equals(this.bD)) {
			var1.put((String) "Head", (NBTTag) this.bD.a());
		}

		if (!bs.equals(this.bE)) {
			var1.put((String) "Body", (NBTTag) this.bE.a());
		}

		if (!bt.equals(this.bF)) {
			var1.put((String) "LeftArm", (NBTTag) this.bF.a());
		}

		if (!bu.equals(this.bG)) {
			var1.put((String) "RightArm", (NBTTag) this.bG.a());
		}

		if (!bv.equals(this.bH)) {
			var1.put((String) "LeftLeg", (NBTTag) this.bH.a());
		}

		if (!bw.equals(this.bI)) {
			var1.put((String) "RightLeg", (NBTTag) this.bI.a());
		}

		return var1;
	}

	public boolean ae() {
		return false;
	}

	protected void s(Entity var1) {
	}

	protected void bM() {
		List var1 = this.world.getEntities((Entity) this, (AxisAlignedBB) this.aT());
		if (var1 != null && !var1.isEmpty()) {
			for (int var2 = 0; var2 < var1.size(); ++var2) {
				Entity var3 = (Entity) var1.get(var2);
				if (var3 instanceof EntityMinecartAbstract && ((EntityMinecartAbstract) var3).s() == EntityMinecartAbstract.EnumMinecartType.RIDEABLE && this.h(var3) <= 0.2D) {
					var3.i(this);
				}
			}
		}

	}

	public UseResult a(EntityHuman var1, Vec3D var2, ItemStack var3, EnumUsedHand var4) {
		if (this.t()) {
			return UseResult.CANT_USE;
		} else if (!this.world.isClientSide && !var1.isSpectator()) {
			EnumWearable var5 = EnumWearable.MAINHAND;
			boolean var6 = var3 != null;
			Item var7 = var6 ? var3.getItem() : null;
			if (var6 && var7 instanceof ItemArmor) {
				var5 = ((ItemArmor) var7).b;
			}

			if (var6 && (var7 == Items.SKULL || var7 == Item.getItemOf(Blocks.PUMPKIN))) {
				var5 = EnumWearable.HEAD;
			}

			double var8 = 0.1D;
			double var10 = 0.9D;
			double var12 = 0.4D;
			double var14 = 1.6D;
			EnumWearable var16 = EnumWearable.MAINHAND;
			boolean var17 = this.n();
			double var18 = var17 ? var2.y * 2.0D : var2.y;
			if (var18 >= 0.1D && var18 < 0.1D + (var17 ? 0.8D : 0.45D) && this.a(EnumWearable.FEET) != null) {
				var16 = EnumWearable.FEET;
			} else if (var18 >= 0.9D + (var17 ? 0.3D : 0.0D) && var18 < 0.9D + (var17 ? 1.0D : 0.7D) && this.a(EnumWearable.TORSO) != null) {
				var16 = EnumWearable.TORSO;
			} else if (var18 >= 0.4D && var18 < 0.4D + (var17 ? 1.0D : 0.8D) && this.a(EnumWearable.LEGS) != null) {
				var16 = EnumWearable.LEGS;
			} else if (var18 >= 1.6D && this.a(EnumWearable.HEAD) != null) {
				var16 = EnumWearable.HEAD;
			}

			boolean var20 = this.a(var16) != null;
			if ((this.bB & 1 << var16.getAbsolute()) != 0 || (this.bB & 1 << var5.getAbsolute()) != 0) {
				var16 = var5;
				if ((this.bB & 1 << var5.getAbsolute()) != 0) {
					if ((this.bB & a) != 0) {
						return UseResult.FAILURE;
					}

					var16 = EnumWearable.MAINHAND;
				}
			}

			if (var6 && var5 == EnumWearable.MAINHAND && !this.q()) {
				return UseResult.FAILURE;
			} else {
				if (var6) {
					this.a(var1, var5, var3, var4);
				} else if (var20) {
					this.a(var1, var16, var3, var4);
				}

				return UseResult.SUCCESS;
			}
		} else {
			return UseResult.SUCCESS;
		}
	}

	private void a(EntityHuman var1, EnumWearable var2, ItemStack var3, EnumUsedHand var4) {
		ItemStack var5 = this.a(var2);
		if (var5 == null || (this.bB & 1 << var2.getAbsolute() + 8) == 0) {
			if (var5 != null || (this.bB & 1 << var2.getAbsolute() + 16) == 0) {
				ItemStack var6;
				if (var1.abilities.instabuild && (var5 == null || var5.getItem() == Item.getItemOf(Blocks.AIR)) && var3 != null) {
					var6 = var3.clone();
					var6.count = 1;
					this.a(var2, var6);
				} else if (var3 != null && var3.count > 1) {
					if (var5 == null) {
						var6 = var3.clone();
						var6.count = 1;
						this.a(var2, var6);
						--var3.count;
					}
				} else {
					this.a(var2, var3);
					var1.a((EnumUsedHand) var4, (ItemStack) var5);
				}
			}
		}
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.world.isClientSide) {
			return false;
		} else if (DamageSource.j.equals(var1)) {
			this.J();
			return false;
		} else if (!this.b((DamageSource) var1) && !this.bz && !this.t()) {
			if (var1.c()) {
				this.E();
				this.J();
				return false;
			} else if (DamageSource.a.equals(var1)) {
				if (!this.av()) {
					this.f(5);
				} else {
					this.a(0.15F);
				}

				return false;
			} else if (DamageSource.c.equals(var1) && this.getHealth() > 0.5F) {
				this.a(4.0F);
				return false;
			} else {
				boolean var3 = "arrow".equals(var1.p());
				boolean var4 = "player".equals(var1.p());
				if (!var4 && !var3) {
					return false;
				} else {
					if (var1.i() instanceof EntityArrow) {
						var1.i().J();
					}

					if (var1.j() instanceof EntityHuman && !((EntityHuman) var1.j()).abilities.mayBuild) {
						return false;
					} else if (var1.u()) {
						this.C();
						this.J();
						return false;
					} else {
						long var5 = this.world.L();
						if (var5 - this.bA > 5L && !var3) {
							this.bA = var5;
						} else {
							this.D();
							this.C();
							this.J();
						}

						return false;
					}
				}
			}
		} else {
			return false;
		}
	}

	private void C() {
		if (this.world instanceof WorldServer) {
			((WorldServer) this.world).a(class_cy.M, this.locX, this.locY + (double) this.length / 1.5D, this.locZ, 10, (double) (this.width / 4.0F), (double) (this.length / 4.0F), (double) (this.width / 4.0F), 0.05D, new int[] { Block.getCombinedId(Blocks.PLANKS.getBlockData()) });
		}

	}

	private void a(float var1) {
		float var2 = this.getHealth();
		var2 -= var1;
		if (var2 <= 0.5F) {
			this.E();
			this.J();
		} else {
			this.i(var2);
		}

	}

	private void D() {
		Block.dropItem(this.world, new BlockPosition(this), new ItemStack(Items.ARMOR_STAND));
		this.E();
	}

	private void E() {
		int var1;
		for (var1 = 0; var1 < this.bx.length; ++var1) {
			if (this.bx[var1] != null && this.bx[var1].count > 0) {
				if (this.bx[var1] != null) {
					Block.dropItem(this.world, (new BlockPosition(this)).up(), this.bx[var1]);
				}

				this.bx[var1] = null;
			}
		}

		for (var1 = 0; var1 < this.by.length; ++var1) {
			if (this.by[var1] != null && this.by[var1].count > 0) {
				if (this.by[var1] != null) {
					Block.dropItem(this.world, (new BlockPosition(this)).up(), this.by[var1]);
				}

				this.by[var1] = null;
			}
		}

	}

	protected float h(float var1, float var2) {
		this.aM = this.lastYaw;
		this.aL = this.yaw;
		return 0.0F;
	}

	public float aU() {
		return this.isBaby() ? this.length * 0.5F : this.length * 0.9F;
	}

	public void g(float var1, float var2) {
		if (!this.p()) {
			super.g(var1, var2);
		}
	}

	public void t_() {
		super.t_();
		class_dc var1 = this.datawatcher.h(HEADPOS_DW_ID);
		if (!this.bD.equals(var1)) {
			this.a(var1);
		}

		class_dc var2 = this.datawatcher.h(BODYPOS_DW_ID);
		if (!this.bE.equals(var2)) {
			this.b(var2);
		}

		class_dc var3 = this.datawatcher.h(LEFTARM_DW_ID);
		if (!this.bF.equals(var3)) {
			this.c(var3);
		}

		class_dc var4 = this.datawatcher.h(RIGHTARM_DW_ID);
		if (!this.bG.equals(var4)) {
			this.d(var4);
		}

		class_dc var5 = this.datawatcher.h(LEFTLEG_DW_ID);
		if (!this.bH.equals(var5)) {
			this.e(var5);
		}

		class_dc var6 = this.datawatcher.h(RIGHTLEG_DW_ID);
		if (!this.bI.equals(var6)) {
			this.f(var6);
		}

		boolean var7 = this.t();
		if (!this.bC && var7) {
			this.a(false);
		} else {
			if (!this.bC || var7) {
				return;
			}

			this.a(true);
		}

		this.bC = var7;
	}

	private void a(boolean var1) {
		double var2 = this.locX;
		double var4 = this.locY;
		double var6 = this.locZ;
		if (var1) {
			this.a(0.5F, 1.975F);
		} else {
			this.a(0.0F, 0.0F);
		}

		this.b(var2, var4, var6);
	}

	protected void B() {
		this.f(this.bz);
	}

	public void f(boolean var1) {
		this.bz = var1;
		super.f(var1);
	}

	public boolean isBaby() {
		return this.n();
	}

	public void G() {
		this.J();
	}

	public boolean aX() {
		return this.aA();
	}

	private void j(boolean var1) {
		byte var2 = this.datawatcher.getByte(INFO_DW_ID);
		if (var1) {
			var2 = (byte) (var2 | 1);
		} else {
			var2 &= -2;
		}

		this.datawatcher.update(INFO_DW_ID, Byte.valueOf(var2));
	}

	public boolean n() {
		return (this.datawatcher.getByte(INFO_DW_ID) & 1) != 0;
	}

	private void k(boolean var1) {
		byte var2 = this.datawatcher.getByte(INFO_DW_ID);
		if (var1) {
			var2 = (byte) (var2 | 2);
		} else {
			var2 &= -3;
		}

		this.datawatcher.update(INFO_DW_ID, Byte.valueOf(var2));
	}

	public boolean p() {
		return (this.datawatcher.getByte(INFO_DW_ID) & 2) != 0;
	}

	private void l(boolean var1) {
		byte var2 = this.datawatcher.getByte(INFO_DW_ID);
		if (var1) {
			var2 = (byte) (var2 | 4);
		} else {
			var2 &= -5;
		}

		this.datawatcher.update(INFO_DW_ID, Byte.valueOf(var2));
	}

	public boolean q() {
		return (this.datawatcher.getByte(INFO_DW_ID) & 4) != 0;
	}

	private void m(boolean var1) {
		byte var2 = this.datawatcher.getByte(INFO_DW_ID);
		if (var1) {
			var2 = (byte) (var2 | 8);
		} else {
			var2 &= -9;
		}

		this.datawatcher.update(INFO_DW_ID, Byte.valueOf(var2));
	}

	public boolean r() {
		return (this.datawatcher.getByte(INFO_DW_ID) & 8) != 0;
	}

	private void n(boolean var1) {
		byte var2 = this.datawatcher.getByte(INFO_DW_ID);
		if (var1) {
			var2 = (byte) (var2 | 16);
		} else {
			var2 &= -17;
		}

		this.datawatcher.update(INFO_DW_ID, Byte.valueOf(var2));
	}

	public boolean t() {
		return (this.datawatcher.getByte(INFO_DW_ID) & 16) != 0;
	}

	public void a(class_dc var1) {
		this.bD = var1;
		this.datawatcher.update(HEADPOS_DW_ID, var1);
	}

	public void b(class_dc var1) {
		this.bE = var1;
		this.datawatcher.update(BODYPOS_DW_ID, var1);
	}

	public void c(class_dc var1) {
		this.bF = var1;
		this.datawatcher.update(LEFTARM_DW_ID, var1);
	}

	public void d(class_dc var1) {
		this.bG = var1;
		this.datawatcher.update(RIGHTARM_DW_ID, var1);
	}

	public void e(class_dc var1) {
		this.bH = var1;
		this.datawatcher.update(LEFTLEG_DW_ID, var1);
	}

	public void f(class_dc var1) {
		this.bI = var1;
		this.datawatcher.update(RIGHTLEG_DW_ID, var1);
	}

	public class_dc u() {
		return this.bD;
	}

	public class_dc v() {
		return this.bE;
	}

	public boolean ad() {
		return super.ad() && !this.t();
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
