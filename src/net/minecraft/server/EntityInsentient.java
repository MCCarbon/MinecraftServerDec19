package net.minecraft.server;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public abstract class EntityInsentient extends EntityLiving {

	private static final int NOAI_DW_ID = Datawathcer.claimId(EntityInsentient.class); //value = 10
	public int a_;
	protected int b_;
	private class_qy b;
	protected class_qz f;
	protected class_qx g;
	private class_qv c;
	protected class_tg h;
	protected final class_rn i;
	protected final class_rn bn;
	private EntityLiving bq;
	private class_tk br;
	private ItemStack[] bs = new ItemStack[2];
	protected float[] bo = new float[2];
	private ItemStack[] bt = new ItemStack[4];
	protected float[] bp = new float[4];
	private boolean bu;
	private boolean bv;
	private boolean bw;
	private Entity bx;
	private NBTTagCompound by;

	public EntityInsentient(World var1) {
		super(var1);
		this.i = new class_rn(var1 != null && var1.B != null ? var1.B : null);
		this.bn = new class_rn(var1 != null && var1.B != null ? var1.B : null);
		this.b = new class_qy(this);
		this.f = new class_qz(this);
		this.g = new class_qx(this);
		this.c = this.p();
		this.h = this.b(var1);
		this.br = new class_tk(this);

		int var2;
		for (var2 = 0; var2 < this.bp.length; ++var2) {
			this.bp[var2] = 0.085F;
		}

		for (var2 = 0; var2 < this.bo.length; ++var2) {
			this.bo[var2] = 0.085F;
		}

	}

	protected void aY() {
		super.aY();
		this.by().b(class_wl.b).a(16.0D);
	}

	protected class_tg b(World var1) {
		return new class_tf(this, var1);
	}

	protected class_qv p() {
		return new class_qv(this);
	}

	public class_qy q() {
		return this.b;
	}

	public class_qz r() {
		return this.f;
	}

	public class_qx t() {
		return this.g;
	}

	public class_tg u() {
		return this.h;
	}

	public class_tk v() {
		return this.br;
	}

	public EntityLiving w() {
		return this.bq;
	}

	public void d(EntityLiving var1) {
		this.bq = var1;
	}

	public boolean a(Class var1) {
		return var1 != EntityGhast.class;
	}

	public void x() {
	}

	protected void initDatawatcher() {
		super.initDatawatcher();
		this.datawatcher.add(NOAI_DW_ID, Byte.valueOf((byte) 0));
	}

	public int y() {
		return 80;
	}

	public void z() {
		String var1 = this.C();
		if (var1 != null) {
			this.a(var1, this.bC(), this.bD());
		}

	}

	public void K() {
		super.K();
		this.o.B.a("mobBaseTick");
		if (this.isAlive() && this.random.nextInt(1000) < this.a_++) {
			this.a_ = -this.y();
			this.z();
		}

		this.o.B.b();
	}

	protected int b(EntityHuman var1) {
		if (this.b_ > 0) {
			int var2 = this.b_;

			int var3;
			for (var3 = 0; var3 < this.bt.length; ++var3) {
				if (this.bt[var3] != null && this.bp[var3] <= 1.0F) {
					var2 += 1 + this.random.nextInt(3);
				}
			}

			for (var3 = 0; var3 < this.bs.length; ++var3) {
				if (this.bs[var3] != null && this.bo[var3] <= 1.0F) {
					var2 += 1 + this.random.nextInt(3);
				}
			}

			return var2;
		} else {
			return this.b_;
		}
	}

	public void A() {
		if (this.o.isClientSide) {
			for (int var1 = 0; var1 < 20; ++var1) {
				double var2 = this.random.nextGaussian() * 0.02D;
				double var4 = this.random.nextGaussian() * 0.02D;
				double var6 = this.random.nextGaussian() * 0.02D;
				double var8 = 10.0D;
				this.o.a(class_cy.a, this.s + (double) (this.random.nextFloat() * this.J * 2.0F) - (double) this.J - var2 * var8, this.t + (double) (this.random.nextFloat() * this.K) - var4 * var8, this.u + (double) (this.random.nextFloat() * this.J * 2.0F) - (double) this.J - var6 * var8, var2, var4, var6, new int[0]);
			}
		} else {
			this.o.a((Entity) this, (byte) 20);
		}

	}

	public void t_() {
		super.t_();
		if (!this.o.isClientSide) {
			this.co();
		}

	}

	protected float h(float var1, float var2) {
		this.c.a();
		return var2;
	}

	protected String C() {
		return null;
	}

	protected Item D() {
		return null;
	}

	protected void b(boolean var1, int var2) {
		Item var3 = this.D();
		if (var3 != null) {
			int var4 = this.random.nextInt(3);
			if (var2 > 0) {
				var4 += this.random.nextInt(var2 + 1);
			}

			for (int var5 = 0; var5 < var4; ++var5) {
				this.a(var3, 1);
			}
		}

	}

	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("CanPickUpLoot", this.cm());
		var1.put("PersistenceRequired", this.bv);
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < this.bt.length; ++var3) {
			NBTTagCompound var4 = new NBTTagCompound();
			if (this.bt[var3] != null) {
				this.bt[var3].write(var4);
			}

			var2.add((NBTTag) var4);
		}

		var1.put((String) "ArmorItems", (NBTTag) var2);
		NBTTagList var8 = new NBTTagList();

		for (int var9 = 0; var9 < this.bs.length; ++var9) {
			NBTTagCompound var5 = new NBTTagCompound();
			if (this.bs[var9] != null) {
				this.bs[var9].write(var5);
			}

			var8.add((NBTTag) var5);
		}

		var1.put((String) "HandItems", (NBTTag) var8);
		NBTTagList var10 = new NBTTagList();

		for (int var11 = 0; var11 < this.bp.length; ++var11) {
			var10.add((NBTTag) (new NBTTagFloat(this.bp[var11])));
		}

		var1.put((String) "ArmorDropChances", (NBTTag) var10);
		NBTTagList var12 = new NBTTagList();

		for (int var6 = 0; var6 < this.bo.length; ++var6) {
			var12.add((NBTTag) (new NBTTagFloat(this.bo[var6])));
		}

		var1.put((String) "HandDropChances", (NBTTag) var12);
		var1.put("Leashed", this.bw);
		if (this.bx != null) {
			NBTTagCompound var13 = new NBTTagCompound();
			if (this.bx instanceof EntityLiving) {
				var13.put("UUIDMost", this.bx.aM().getMostSignificantBits());
				var13.put("UUIDLeast", this.bx.aM().getLeastSignificantBits());
			} else if (this.bx instanceof class_uz) {
				BlockPosition var7 = ((class_uz) this.bx).n();
				var13.put("X", var7.getX());
				var13.put("Y", var7.getY());
				var13.put("Z", var7.getZ());
			}

			var1.put((String) "Leash", (NBTTag) var13);
		}

		var1.put("LeftHanded", this.ct());
		if (this.cs()) {
			var1.put("NoAI", this.cs());
		}

	}

	public void read(NBTTagCompound var1) {
		super.read(var1);
		if (var1.hasOfType("CanPickUpLoot", 1)) {
			this.j(var1.getBoolean("CanPickUpLoot"));
		}

		this.bv = var1.getBoolean("PersistenceRequired");
		NBTTagList var3;
		int var4;
		NBTTagList var5;
		int var7;
		if (var1.hasOfType("Equipment", 9)) {
			ItemStack[] var2 = new ItemStack[5];
			var3 = var1.getList("Equipment", 10);

			for (var4 = 0; var4 < var2.length; ++var4) {
				var2[var4] = ItemStack.a(var3.getCompound(var4));
			}

			this.bs[EnumWearable.MAINHAND.getRelative()] = var2[0];
			this.bt[EnumWearable.FEET.getRelative()] = var2[1];
			this.bt[EnumWearable.LEGS.getRelative()] = var2[2];
			this.bt[EnumWearable.TORSO.getRelative()] = var2[3];
			this.bt[EnumWearable.HEAD.getRelative()] = var2[4];
		} else {
			if (var1.hasOfType("ArmorItems", 9)) {
				var5 = var1.getList("ArmorItems", 10);

				for (var7 = 0; var7 < this.bt.length; ++var7) {
					this.bt[var7] = ItemStack.a(var5.getCompound(var7));
				}
			}

			if (var1.hasOfType("HandItems", 9)) {
				var5 = var1.getList("HandItems", 10);

				for (var7 = 0; var7 < this.bs.length; ++var7) {
					this.bs[var7] = ItemStack.a(var5.getCompound(var7));
				}
			}
		}

		if (var1.hasOfType("DropChances", 9)) {
			float[] var6 = new float[5];
			var3 = var1.getList("DropChances", 5);

			for (var4 = 0; var4 < var3.getSize(); ++var4) {
				var6[var4] = var3.getFloat(var4);
			}

			this.bo[0] = var6[0];
			this.bp[0] = var6[1];
			this.bp[1] = var6[2];
			this.bp[2] = var6[3];
			this.bp[3] = var6[4];
		} else {
			if (var1.hasOfType("ArmorDropChances", 9)) {
				var5 = var1.getList("ArmorDropChances", 5);

				for (var7 = 0; var7 < var5.getSize(); ++var7) {
					this.bp[var7] = var5.getFloat(var7);
				}
			}

			if (var1.hasOfType("HandDropChances", 9)) {
				var5 = var1.getList("HandDropChances", 5);

				for (var7 = 0; var7 < var5.getSize(); ++var7) {
					this.bo[var7] = var5.getFloat(var7);
				}
			}
		}

		this.bw = var1.getBoolean("Leashed");
		if (this.bw && var1.hasOfType("Leash", 10)) {
			this.by = var1.getCompound("Leash");
		}

		this.l(var1.getBoolean("LeftHanded"));
		this.k(var1.getBoolean("NoAI"));
	}

	public void n(float var1) {
		this.bd = var1;
	}

	public void k(float var1) {
		super.k(var1);
		this.n(var1);
	}

	public void m() {
		super.m();
		this.o.B.a("looting");
		if (!this.o.isClientSide && this.cm() && !this.aS && this.o.R().getBooleanValue("mobGriefing")) {
			List var1 = this.o.getEntities(EntityItem.class, this.aT().grow(1.0D, 0.0D, 1.0D));
			Iterator var2 = var1.iterator();

			while (var2.hasNext()) {
				EntityItem var3 = (EntityItem) var2.next();
				if (!var3.I && var3.l() != null && !var3.isNotPickable()) {
					this.a(var3);
				}
			}
		}

		this.o.B.b();
	}

	protected void a(EntityItem var1) {
		ItemStack var2 = var1.l();
		EnumWearable var3 = c(var2);
		boolean var4 = true;
		ItemStack var5 = this.a(var3);
		if (var5 != null) {
			if (var3.getSlot() == EnumWearable.SLOT.HAND) {
				if (var2.getItem() instanceof ItemSword && !(var5.getItem() instanceof ItemSword)) {
					var4 = true;
				} else if (var2.getItem() instanceof ItemSword && var5.getItem() instanceof ItemSword) {
					ItemSword var6 = (ItemSword) var2.getItem();
					ItemSword var7 = (ItemSword) var5.getItem();
					if (var6.g() == var7.g()) {
						var4 = var2.i() > var5.i() || var2.hasTag() && !var5.hasTag();
					} else {
						var4 = var6.g() > var7.g();
					}
				} else if (var2.getItem() instanceof ItemBow && var5.getItem() instanceof ItemBow) {
					var4 = var2.hasTag() && !var5.hasTag();
				} else {
					var4 = false;
				}
			} else if (var2.getItem() instanceof ItemArmor && !(var5.getItem() instanceof ItemArmor)) {
				var4 = true;
			} else if (var2.getItem() instanceof ItemArmor && var5.getItem() instanceof ItemArmor) {
				ItemArmor var9 = (ItemArmor) var2.getItem();
				ItemArmor var11 = (ItemArmor) var5.getItem();
				if (var9.c == var11.c) {
					var4 = var2.i() > var5.i() || var2.hasTag() && !var5.hasTag();
				} else {
					var4 = var9.c > var11.c;
				}
			} else {
				var4 = false;
			}
		}

		if (var4 && this.a(var2)) {
			double var10;
			switch (EntityInsentient.SyntheticClass_1.a[var3.getSlot().ordinal()]) {
				case 1:
					var10 = (double) this.bo[var3.getRelative()];
					break;
				case 2:
					var10 = (double) this.bp[var3.getRelative()];
					break;
				default:
					var10 = 0.0D;
			}

			if (var5 != null && (double) (this.random.nextFloat() - 0.1F) < var10) {
				this.a(var5, 0.0F);
			}

			if (var2.getItem() == Items.DIAMOND && var1.n() != null) {
				EntityHuman var8 = this.o.a(var1.n());
				if (var8 != null) {
					var8.b((class_my) class_mt.x);
				}
			}

			this.a(var3, var2);
			switch (EntityInsentient.SyntheticClass_1.a[var3.getSlot().ordinal()]) {
				case 1:
					this.bo[var3.getRelative()] = 2.0F;
					break;
				case 2:
					this.bp[var3.getRelative()] = 2.0F;
			}

			this.bv = true;
			this.a(var1, 1);
			var1.J();
		}

	}

	protected boolean a(ItemStack var1) {
		return true;
	}

	protected boolean E() {
		return true;
	}

	protected void cb() {
		if (this.bv) {
			this.aT = 0;
		} else {
			EntityHuman var1 = this.o.a(this, -1.0D);
			if (var1 != null) {
				double var2 = var1.s - this.s;
				double var4 = var1.t - this.t;
				double var6 = var1.u - this.u;
				double var8 = var2 * var2 + var4 * var4 + var6 * var6;
				if (this.E() && var8 > 16384.0D) {
					this.J();
				}

				if (this.aT > 600 && this.random.nextInt(800) == 0 && var8 > 1024.0D && this.E()) {
					this.J();
				} else if (var8 < 1024.0D) {
					this.aT = 0;
				}
			}

		}
	}

	protected final void bL() {
		++this.aT;
		this.o.B.a("checkDespawn");
		this.cb();
		this.o.B.b();
		this.o.B.a("sensing");
		this.br.a();
		this.o.B.b();
		this.o.B.a("targetSelector");
		this.bn.a();
		this.o.B.b();
		this.o.B.a("goalSelector");
		this.i.a();
		this.o.B.b();
		this.o.B.a("navigation");
		this.h.k();
		this.o.B.b();
		this.o.B.a("mob tick");
		this.cc();
		this.o.B.b();
		this.o.B.a("controls");
		this.o.B.a("move");
		this.f.c();
		this.o.B.c("look");
		this.b.a();
		this.o.B.c("jump");
		this.g.b();
		this.o.B.b();
		this.o.B.b();
	}

	protected void cc() {
	}

	public int cd() {
		return 40;
	}

	public int ce() {
		return 10;
	}

	public void a(Entity var1, float var2, float var3) {
		double var4 = var1.s - this.s;
		double var8 = var1.u - this.u;
		double var6;
		if (var1 instanceof EntityLiving) {
			EntityLiving var10 = (EntityLiving) var1;
			var6 = var10.t + (double) var10.aU() - (this.t + (double) this.aU());
		} else {
			var6 = (var1.aT().yMin + var1.aT().yMax) / 2.0D - (this.t + (double) this.aU());
		}

		double var14 = (double) MathHelper.sqrt(var4 * var4 + var8 * var8);
		float var12 = (float) (MathHelper.b(var8, var4) * 180.0D / 3.1415927410125732D) - 90.0F;
		float var13 = (float) (-(MathHelper.b(var6, var14) * 180.0D / 3.1415927410125732D));
		this.z = this.b(this.z, var13, var3);
		this.y = this.b(this.y, var12, var2);
	}

	private float b(float var1, float var2, float var3) {
		float var4 = MathHelper.clampAngle(var2 - var1);
		if (var4 > var3) {
			var4 = var3;
		}

		if (var4 < -var3) {
			var4 = -var3;
		}

		return var1 + var4;
	}

	public boolean cf() {
		return true;
	}

	public boolean cg() {
		return this.o.a((AxisAlignedBB) this.aT(), (Entity) this) && this.o.a((Entity) this, (AxisAlignedBB) this.aT()).isEmpty() && !this.o.d(this.aT());
	}

	public int cj() {
		return 4;
	}

	public int aG() {
		if (this.w() == null) {
			return 3;
		} else {
			int var1 = (int) (this.getHealth() - this.bv() * 0.33F);
			var1 -= (3 - this.o.ab().a()) * 4;
			if (var1 < 0) {
				var1 = 0;
			}

			return var1 + 3;
		}
	}

	public Iterable as() {
		return Arrays.asList(this.bs);
	}

	public Iterable at() {
		return Arrays.asList(this.bt);
	}

	public ItemStack a(EnumWearable var1) {
		ItemStack var2 = null;
		switch (EntityInsentient.SyntheticClass_1.a[var1.getSlot().ordinal()]) {
			case 1:
				var2 = this.bs[var1.getRelative()];
				break;
			case 2:
				var2 = this.bt[var1.getRelative()];
		}

		return var2;
	}

	public void a(EnumWearable var1, ItemStack var2) {
		switch (EntityInsentient.SyntheticClass_1.a[var1.getSlot().ordinal()]) {
			case 1:
				this.bs[var1.getRelative()] = var2;
				break;
			case 2:
				this.bt[var1.getRelative()] = var2;
		}

	}

	protected void a(boolean var1, int var2) {
		EnumWearable[] var3 = EnumWearable.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			EnumWearable var6 = var3[var5];
			ItemStack var7 = this.a(var6);
			double var8;
			switch (EntityInsentient.SyntheticClass_1.a[var6.getSlot().ordinal()]) {
				case 1:
					var8 = (double) this.bo[var6.getRelative()];
					break;
				case 2:
					var8 = (double) this.bp[var6.getRelative()];
					break;
				default:
					var8 = 0.0D;
			}

			boolean var10 = var8 > 1.0D;
			if (var7 != null && (var1 || var10) && (double) (this.random.nextFloat() - (float) var2 * 0.01F) < var8) {
				if (!var10 && var7.e()) {
					int var11 = Math.max(var7.j() - 25, 1);
					int var12 = var7.j() - this.random.nextInt(this.random.nextInt(var11) + 1);
					if (var12 > var11) {
						var12 = var11;
					}

					if (var12 < 1) {
						var12 = 1;
					}

					var7.setData(var12);
				}

				this.a(var7, 0.0F);
			}
		}

	}

	protected void a(class_on var1) {
		if (this.random.nextFloat() < 0.15F * var1.c()) {
			int var2 = this.random.nextInt(2);
			float var3 = this.o.ab() == class_om.d ? 0.1F : 0.25F;
			if (this.random.nextFloat() < 0.095F) {
				++var2;
			}

			if (this.random.nextFloat() < 0.095F) {
				++var2;
			}

			if (this.random.nextFloat() < 0.095F) {
				++var2;
			}

			boolean var4 = true;
			EnumWearable[] var5 = EnumWearable.values();
			int var6 = var5.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				EnumWearable var8 = var5[var7];
				if (var8.getSlot() == EnumWearable.SLOT.ARMOR) {
					ItemStack var9 = this.a(var8);
					if (!var4 && this.random.nextFloat() < var3) {
						break;
					}

					var4 = false;
					if (var9 == null) {
						Item var10 = a(var8, var2);
						if (var10 != null) {
							this.a(var8, new ItemStack(var10));
						}
					}
				}
			}
		}

	}

	public static EnumWearable c(ItemStack var0) {
		return var0.getItem() != Item.getItemOf(Blocks.PUMPKIN) && var0.getItem() != Items.SKULL ? (var0.getItem() instanceof ItemArmor ? ((ItemArmor) var0.getItem()).b : EnumWearable.MAINHAND) : EnumWearable.HEAD;
	}

	public static Item a(EnumWearable var0, int var1) {
		switch (EntityInsentient.SyntheticClass_1.b[var0.ordinal()]) {
			case 1:
				if (var1 == 0) {
					return Items.LEATHER_HELMET;
				} else if (var1 == 1) {
					return Items.GOLDEN_HELMET;
				} else if (var1 == 2) {
					return Items.CHAINMAIL_HELMET;
				} else if (var1 == 3) {
					return Items.IRON_HELMET;
				} else if (var1 == 4) {
					return Items.DIAMOND_HELMET;
				}
			case 2:
				if (var1 == 0) {
					return Items.LEATHER_CHESTPLATE;
				} else if (var1 == 1) {
					return Items.GOLDEN_CHESTPLATE;
				} else if (var1 == 2) {
					return Items.CHAINMAIL_CHESTPLATE;
				} else if (var1 == 3) {
					return Items.IRON_CHESTPLATE;
				} else if (var1 == 4) {
					return Items.DIAMOND_CHESTPLATE;
				}
			case 3:
				if (var1 == 0) {
					return Items.LEATHER_LEGGINGS;
				} else if (var1 == 1) {
					return Items.GOLDEN_LEGGINGS;
				} else if (var1 == 2) {
					return Items.CHAINMAIL_LEGGINGS;
				} else if (var1 == 3) {
					return Items.IRON_LEGGINGS;
				} else if (var1 == 4) {
					return Items.DIAMOND_LEGGINGS;
				}
			case 4:
				if (var1 == 0) {
					return Items.LEATHER_BOOTS;
				} else if (var1 == 1) {
					return Items.GOLDEN_BOOTS;
				} else if (var1 == 2) {
					return Items.CHAINMAIL_BOOTS;
				} else if (var1 == 3) {
					return Items.IRON_BOOTS;
				} else if (var1 == 4) {
					return Items.DIAMOND_BOOTS;
				}
			default:
				return null;
		}
	}

	protected void b(class_on var1) {
		float var2 = var1.c();
		if (this.bA() != null && this.random.nextFloat() < 0.25F * var2) {
			EnchantmentManager.a(this.random, this.bA(), (int) (5.0F + var2 * (float) this.random.nextInt(18)));
		}

		EnumWearable[] var3 = EnumWearable.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			EnumWearable var6 = var3[var5];
			if (var6.getSlot() == EnumWearable.SLOT.ARMOR) {
				ItemStack var7 = this.a(var6);
				if (var7 != null && this.random.nextFloat() < 0.5F * var2) {
					EnchantmentManager.a(this.random, var7, (int) (5.0F + var2 * (float) this.random.nextInt(18)));
				}
			}
		}

	}

	public class_qd a(class_on var1, class_qd var2) {
		this.a((class_qk) class_wl.b).b(new class_qm("Random spawn bonus", this.random.nextGaussian() * 0.05D, 1));
		if (this.random.nextFloat() < 0.05F) {
			this.l(true);
		} else {
			this.l(false);
		}

		return var2;
	}

	public boolean ck() {
		return false;
	}

	public void cl() {
		this.bv = true;
	}

	public void a(EnumWearable var1, float var2) {
		switch (EntityInsentient.SyntheticClass_1.a[var1.getSlot().ordinal()]) {
			case 1:
				this.bo[var1.getRelative()] = var2;
				break;
			case 2:
				this.bp[var1.getRelative()] = var2;
		}

	}

	public boolean cm() {
		return this.bu;
	}

	public void j(boolean var1) {
		this.bu = var1;
	}

	public boolean cn() {
		return this.bv;
	}

	public final boolean a(EntityHuman var1, ItemStack var2, EnumUsedHand var3) {
		if (this.cq() && this.cr() == var1) {
			this.a(true, !var1.abilities.instabuild);
			return true;
		} else {
			if (var2 != null && var2.getItem() == Items.LEAD && this.cp()) {
				if (!(this instanceof class_qj) || !((class_qj) this).cA()) {
					this.a(var1, true);
					--var2.count;
					return true;
				}

				if (((class_qj) this).e(var1)) {
					this.a(var1, true);
					--var2.count;
					return true;
				}
			}

			return this.a(var1, var3, var2) ? true : super.a(var1, var2, var3);
		}
	}

	protected boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
		return false;
	}

	protected void co() {
		if (this.by != null) {
			this.n();
		}

		if (this.bw) {
			if (!this.isAlive()) {
				this.a(true, true);
			}

			if (this.bx == null || this.bx.I) {
				this.a(true, true);
			}
		}
	}

	public void a(boolean var1, boolean var2) {
		if (this.bw) {
			this.bw = false;
			this.bx = null;
			if (!this.o.isClientSide && var2) {
				this.a(Items.LEAD, 1);
			}

			if (!this.o.isClientSide && var1 && this.o instanceof WorldServer) {
				((WorldServer) this.o).t().a((Entity) this, (Packet) (new PacketPlayOutAttachEntity(1, this, (Entity) null)));
			}
		}

	}

	public boolean cp() {
		return !this.cq() && !(this instanceof class_wd);
	}

	public boolean cq() {
		return this.bw;
	}

	public Entity cr() {
		return this.bx;
	}

	public void a(Entity var1, boolean var2) {
		this.bw = true;
		this.bx = var1;
		if (!this.o.isClientSide && var2 && this.o instanceof WorldServer) {
			((WorldServer) this.o).t().a((Entity) this, (Packet) (new PacketPlayOutAttachEntity(1, this, this.bx)));
		}

	}

	private void n() {
		if (this.bw && this.by != null) {
			if (this.by.hasOfType("UUIDMost", 4) && this.by.hasOfType("UUIDLeast", 4)) {
				UUID var5 = new UUID(this.by.getLong("UUIDMost"), this.by.getLong("UUIDLeast"));
				List var6 = this.o.getEntities(EntityLiving.class, this.aT().grow(10.0D, 10.0D, 10.0D));
				Iterator var3 = var6.iterator();

				while (var3.hasNext()) {
					EntityLiving var4 = (EntityLiving) var3.next();
					if (var4.aM().equals(var5)) {
						this.bx = var4;
						break;
					}
				}
			} else if (this.by.hasOfType("X", 99) && this.by.hasOfType("Y", 99) && this.by.hasOfType("Z", 99)) {
				BlockPosition var1 = new BlockPosition(this.by.getInt("X"), this.by.getInt("Y"), this.by.getInt("Z"));
				EntityLeash var2 = EntityLeash.b(this.o, var1);
				if (var2 == null) {
					var2 = EntityLeash.a(this.o, var1);
				}

				this.bx = var2;
			} else {
				this.a(false, true);
			}
		}

		this.by = null;
	}

	public boolean c(int var1, ItemStack var2) {
		EnumWearable var3;
		if (var1 == 98) {
			var3 = EnumWearable.MAINHAND;
		} else if (var1 == 99) {
			var3 = EnumWearable.OFFHAND;
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

		if (var2 != null && c(var2) != var3 && (var3 != EnumWearable.HEAD || !(var2.getItem() instanceof ItemBlock))) {
			return false;
		} else {
			this.a(var3, var2);
			return true;
		}
	}

	public boolean bN() {
		return super.bN() && !this.cs();
	}

	public void k(boolean var1) {
		byte var2 = this.datawatcher.getByte(NOAI_DW_ID);
		this.datawatcher.update(NOAI_DW_ID, Byte.valueOf(var1 ? (byte) (var2 | 1) : (byte) (var2 & -2)));
	}

	public void l(boolean var1) {
		byte var2 = this.datawatcher.getByte(NOAI_DW_ID);
		this.datawatcher.update(NOAI_DW_ID, Byte.valueOf(var1 ? (byte) (var2 | 2) : (byte) (var2 & -3)));
	}

	public boolean cs() {
		return (this.datawatcher.getByte(NOAI_DW_ID) & 1) != 0;
	}

	public boolean ct() {
		return (this.datawatcher.getByte(NOAI_DW_ID) & 2) != 0;
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[EnumWearable.values().length];

		static {
			try {
				b[EnumWearable.HEAD.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				b[EnumWearable.TORSO.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				b[EnumWearable.LEGS.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				b[EnumWearable.FEET.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			a = new int[EnumWearable.SLOT.values().length];

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

	public static enum class_a_in_class_qb {
		a, b, c;
	}
}
