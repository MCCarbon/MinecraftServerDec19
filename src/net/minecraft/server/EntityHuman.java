package net.minecraft.server;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;

public abstract class EntityHuman extends EntityLiving {

	private static final int ABS_HEARTH_DW_ID = Datawathcer.claimId(EntityHuman.class); //value = 10
	private static final int SCORE_DW_ID = Datawathcer.claimId(EntityHuman.class); //value = 11
	protected static final int SKIN_PARTS_DW_ID = Datawathcer.claimId(EntityHuman.class); //value = 12
	protected static final int MAIN_HAND_DW_ID = Datawathcer.claimId(EntityHuman.class); //value = 13

	public PlayerInventory inventory = new PlayerInventory(this);
	private class_yu enderChest = new class_yu();
	public Container bq;
	public Container br;
	protected class_xx foodData = new class_xx();
	protected int bt;
	public float bu;
	public float bv;
	public int bw;
	public double bx;
	public double by;
	public double bz;
	public double bA;
	public double bB;
	public double bC;
	protected boolean sleeping;
	public BlockPosition bedPosition;
	private int sleepTicks;
	public float bF;
	public float bG;
	private BlockPosition e;
	private boolean f;
	private BlockPosition g;
	public PlayerAbilities abilities = new PlayerAbilities();
	public int expLevel;
	public int expTotal;
	public float exp;
	private int xpSeed;
	protected float bL = 0.1F;
	protected float bM = 0.02F;
	private int i;
	private final GameProfile bO;
	private boolean bP = false;
	public class_ve bN;

	public EntityHuman(World var1, GameProfile var2) {
		super(var1);
		uniqueID = a(var2);
		bO = var2;
		bq = new class_yp(inventory, !var1.isClientSide, this);
		br = bq;
		BlockPosition var3 = var1.N();
		this.b(var3.getX() + 0.5D, var3.getY() + 1, var3.getZ() + 0.5D, 0.0F, 0.0F);
		aY = 180.0F;
		X = 20;
	}

	@Override
	protected void aY() {
		super.aY();
		by().b(class_wl.e).a(1.0D);
		this.a(class_wl.d).a(0.10000000149011612D);
	}

	@Override
	protected void h() {
		super.h();
		datawatcher.add(ABS_HEARTH_DW_ID, Float.valueOf(0.0F));
		datawatcher.add(SCORE_DW_ID, Integer.valueOf(0));
		datawatcher.add(SKIN_PARTS_DW_ID, Byte.valueOf((byte) 0));
		datawatcher.add(MAIN_HAND_DW_ID, Byte.valueOf((byte) 1));
	}

	@Override
	public void t_() {
		T = isSpectator();
		if (isSpectator()) {
			C = false;
		}

		if (bw > 0) {
			--bw;
		}

		if (isSleeping()) {
			++sleepTicks;
			if (sleepTicks > 100) {
				sleepTicks = 100;
			}

			if (!o.isClientSide) {
				if (!this.p()) {
					this.a(true, true, false);
				} else if (o.x()) {
					this.a(false, true, true);
				}
			}
		} else if (sleepTicks > 0) {
			++sleepTicks;
			if (sleepTicks >= 110) {
				sleepTicks = 0;
			}
		}

		super.t_();
		if (!o.isClientSide && (br != null) && !br.a(this)) {
			this.n();
			br = bq;
		}

		if (av() && abilities.invulnerable) {
			N();
		}

		bx = bA;
		by = bB;
		bz = bC;
		double var1 = s - bA;
		double var3 = t - bB;
		double var5 = u - bC;
		double var7 = 10.0D;
		if (var1 > var7) {
			bx = bA = s;
		}

		if (var5 > var7) {
			bz = bC = u;
		}

		if (var3 > var7) {
			by = bB = t;
		}

		if (var1 < -var7) {
			bx = bA = s;
		}

		if (var5 < -var7) {
			bz = bC = u;
		}

		if (var3 < -var7) {
			by = bB = t;
		}

		bA += var1 * 0.25D;
		bC += var5 * 0.25D;
		bB += var3 * 0.25D;
		if (vehicle == null) {
			g = null;
		}

		if (!o.isClientSide) {
			foodData.a(this);
			this.b(StatisticList.g);
			if (isAlive()) {
				this.b(StatisticList.h);
			}
		}

		int var9 = 29999999;
		double var10 = MathHelper.clamp(s, -2.9999999E7D, 2.9999999E7D);
		double var12 = MathHelper.clamp(u, -2.9999999E7D, 2.9999999E7D);
		if ((var10 != s) || (var12 != u)) {
			this.b(var10, t, var12);
		}

	}

	@Override
	public int L() {
		return abilities.invulnerable ? 0 : 80;
	}

	@Override
	protected String P() {
		return "game.player.swim";
	}

	@Override
	protected String aa() {
		return "game.player.swim.splash";
	}

	@Override
	public int aq() {
		return 10;
	}

	@Override
	public void a(String var1, float var2, float var3) {
		o.a(this, var1, var2, var3);
	}

	@Override
	protected boolean bE() {
		return (getHealth() <= 0.0F) || isSleeping();
	}

	protected void n() {
		br = bq;
	}

	@Override
	public void ak() {
		if (!o.isClientSide && ax()) {
			this.a((Entity) null);
			this.c(false);
		} else {
			double var1 = s;
			double var3 = t;
			double var5 = u;
			float var7 = y;
			float var8 = z;
			super.ak();
			bu = bv;
			bv = 0.0F;
			this.l(s - var1, t - var3, u - var5);
			if (vehicle instanceof class_ud) {
				z = var8;
				y = var7;
				aL = ((class_ud) vehicle).aL;
			}

		}
	}

	@Override
	protected void bL() {
		super.bL();
		bx();
		aN = y;
	}

	@Override
	public void m() {
		if (bt > 0) {
			--bt;
		}

		if ((o.ab() == class_om.a) && o.R().b("naturalRegeneration")) {
			if ((getHealth() < bv()) && ((W % 20) == 0)) {
				this.h(1.0F);
			}

			if (foodData.c() && ((W % 10) == 0)) {
				foodData.a(foodData.a() + 1);
			}
		}

		inventory.k();
		bu = bv;
		super.m();
		class_ql var1 = this.a(class_wl.d);
		if (!o.isClientSide) {
			var1.a(abilities.getWalkSpeed());
		}

		aP = bM;
		if (ay()) {
			aP = (float) (aP + (bM * 0.3D));
		}

		this.k((float) var1.e());
		float var2 = MathHelper.sqrt((v * v) + (x * x));
		float var3 = (float) (Math.atan(-motY * 0.20000000298023224D) * 15.0D);
		if (var2 > 0.1F) {
			var2 = 0.1F;
		}

		if (!C || (getHealth() <= 0.0F)) {
			var2 = 0.0F;
		}

		if (C || (getHealth() <= 0.0F)) {
			var3 = 0.0F;
		}

		bv += (var2 - bv) * 0.4F;
		aI += (var3 - aI) * 0.8F;
		if ((getHealth() > 0.0F) && !isSpectator()) {
			AxisAlignedBB var4 = null;
			if ((vehicle != null) && !vehicle.I) {
				var4 = aT().a(vehicle.aT()).grow(1.0D, 0.0D, 1.0D);
			} else {
				var4 = aT().grow(1.0D, 0.5D, 1.0D);
			}

			List var5 = o.getEntities(this, var4);

			for (int var6 = 0; var6 < var5.size(); ++var6) {
				Entity var7 = (Entity) var5.get(var6);
				if (!var7.I) {
					this.d(var7);
				}
			}
		}

	}

	private void d(Entity var1) {
		var1.d(this);
	}

	public int getScore() {
		return datawatcher.getInt(SCORE_DW_ID);
	}

	public void setScore(int score) {
		datawatcher.update(SCORE_DW_ID, Integer.valueOf(score));
	}

	public void addScore(int score) {
		int old = getScore();
		datawatcher.update(SCORE_DW_ID, Integer.valueOf(old + score));
	}

	@Override
	public void a(class_pc var1) {
		super.a(var1);
		this.a(0.2F, 0.2F);
		this.b(s, t, u);
		motY = 0.10000000149011612D;
		if (getName().equals("Notch")) {
			this.a(new ItemStack(Items.e, 1), true, false);
		}

		if (!o.R().b("keepInventory")) {
			inventory.n();
		}

		if (var1 != null) {
			v = -MathHelper.cos(((az + y) * 3.1415927F) / 180.0F) * 0.1F;
			x = -MathHelper.sin(((az + y) * 3.1415927F) / 180.0F) * 0.1F;
		} else {
			v = x = 0.0D;
		}

		this.b(StatisticList.y);
		this.a(StatisticList.h);
	}

	@Override
	protected String bp() {
		return "game.player.hurt";
	}

	@Override
	protected String bq() {
		return "game.player.die";
	}

	@Override
	public void b(Entity var1, int var2) {
		addScore(var2);
		Collection var3 = cr().a(class_awt.f);
		if (var1 instanceof EntityHuman) {
			this.b(StatisticList.B);
			var3.addAll(cr().a(class_awt.e));
			var3.addAll(this.e(var1));
		} else {
			this.b(StatisticList.z);
		}

		Iterator var4 = var3.iterator();

		while (var4.hasNext()) {
			class_awj var5 = (class_awj) var4.next();
			class_awl var6 = cr().c(getName(), var5);
			var6.a();
		}

	}

	private Collection e(Entity var1) {
		class_awk var2 = cr().h(getName());
		if (var2 != null) {
			int var3 = var2.l().getId();
			if ((var3 >= 0) && (var3 < class_awt.i.length)) {
				Iterator var4 = cr().a(class_awt.i[var3]).iterator();

				while (var4.hasNext()) {
					class_awj var5 = (class_awj) var4.next();
					class_awl var6 = cr().c(var1.getName(), var5);
					var6.a();
				}
			}
		}

		class_awk var7 = cr().h(var1.getName());
		if (var7 != null) {
			int var8 = var7.l().getId();
			if ((var8 >= 0) && (var8 < class_awt.h.length)) {
				return cr().a(class_awt.h[var8]);
			}
		}

		return Lists.newArrayList();
	}

	public EntityItem a(boolean var1) {
		return this.a(inventory.splitStack(inventory.itemInHandIndex, var1 && (inventory.getItemInHand() != null) ? inventory.getItemInHand().count : 1), false, true);
	}

	public EntityItem a(ItemStack var1, boolean var2) {
		return this.a(var1, false, false);
	}

	public EntityItem a(ItemStack var1, boolean var2, boolean var3) {
		if (var1 == null) {
			return null;
		} else if (var1.count == 0) {
			return null;
		} else {
			double var4 = (t - 0.30000001192092896D) + aU();
			EntityItem var6 = new EntityItem(o, s, var4, u, var1);
			var6.setPickupDelay(40);
			if (var3) {
				var6.c(getName());
			}

			float var7;
			float var8;
			if (var2) {
				var7 = random.nextFloat() * 0.5F;
				var8 = random.nextFloat() * 3.1415927F * 2.0F;
				var6.v = -MathHelper.sin(var8) * var7;
				var6.x = MathHelper.cos(var8) * var7;
				var6.motY = 0.20000000298023224D;
			} else {
				var7 = 0.3F;
				var6.v = -MathHelper.sin((y / 180.0F) * 3.1415927F) * MathHelper.cos((z / 180.0F) * 3.1415927F) * var7;
				var6.x = MathHelper.cos((y / 180.0F) * 3.1415927F) * MathHelper.cos((z / 180.0F) * 3.1415927F) * var7;
				var6.motY = (-MathHelper.sin((z / 180.0F) * 3.1415927F) * var7) + 0.1F;
				var8 = random.nextFloat() * 3.1415927F * 2.0F;
				var7 = 0.02F * random.nextFloat();
				var6.v += Math.cos(var8) * var7;
				var6.motY += (random.nextFloat() - random.nextFloat()) * 0.1F;
				var6.x += Math.sin(var8) * var7;
			}

			this.a(var6);
			if (var3) {
				this.b(StatisticList.v);
			}

			return var6;
		}
	}

	protected void a(EntityItem var1) {
		o.addEntity(var1);
	}

	public float a(Block var1) {
		float var2 = inventory.a(var1);
		if (var2 > 1.0F) {
			int var3 = EnchantmentManager.e(this);
			ItemStack var4 = bA();
			if ((var3 > 0) && (var4 != null)) {
				var2 += (var3 * var3) + 1;
			}
		}

		if (this.a(class_pm.c)) {
			var2 *= 1.0F + ((this.b(class_pm.c).c() + 1) * 0.2F);
		}

		if (this.a(class_pm.d)) {
			float var5 = 1.0F;
			switch (this.b(class_pm.d).c()) {
				case 0:
					var5 = 0.3F;
					break;
				case 1:
					var5 = 0.09F;
					break;
				case 2:
					var5 = 0.0027F;
					break;
				case 3:
				default:
					var5 = 8.1E-4F;
			}

			var2 *= var5;
		}

		if (this.a(Material.WATER) && !EnchantmentManager.i(this)) {
			var2 /= 5.0F;
		}

		if (!C) {
			var2 /= 5.0F;
		}

		return var2;
	}

	public boolean b(Block var1) {
		return inventory.b(var1);
	}

	@Override
	public void read(NBTTagCompound compound) {
		super.read(compound);
		uniqueID = a(bO);
		NBTTagList var2 = compound.getList("Inventory", 10);
		inventory.b(var2);
		inventory.itemInHandIndex = compound.getInt("SelectedItemSlot");
		sleeping = compound.getBoolean("Sleeping");
		sleepTicks = compound.getShort("SleepTimer");
		exp = compound.getFloat("XpP");
		expLevel = compound.getInt("XpLevel");
		expTotal = compound.getInt("XpTotal");
		xpSeed = compound.getInt("XpSeed");
		if (xpSeed == 0) {
			xpSeed = random.nextInt();
		}

		setScore(compound.getInt("Score"));
		if (sleeping) {
			bedPosition = new BlockPosition(this);
			this.a(true, true, false);
		}

		if (compound.hasOfType("SpawnX", 99) && compound.hasOfType("SpawnY", 99) && compound.hasOfType("SpawnZ", 99)) {
			e = new BlockPosition(compound.getInt("SpawnX"), compound.getInt("SpawnY"), compound.getInt("SpawnZ"));
			f = compound.getBoolean("SpawnForced");
		}

		foodData.a(compound);
		abilities.read(compound);
		if (compound.hasOfType("EnderItems", 9)) {
			NBTTagList var3 = compound.getList("EnderItems", 10);
			enderChest.a(var3);
		}
	}

	@Override
	public void write(NBTTagCompound compound) {
		super.write(compound);
		compound.put("Inventory", inventory.a(new NBTTagList()));
		compound.put("SelectedItemSlot", inventory.itemInHandIndex);
		compound.put("Sleeping", sleeping);
		compound.put("SleepTimer", (short) sleepTicks);
		compound.put("XpP", exp);
		compound.put("XpLevel", expLevel);
		compound.put("XpTotal", expTotal);
		compound.put("XpSeed", xpSeed);
		compound.put("Score", getScore());
		if (e != null) {
			compound.put("SpawnX", e.getX());
			compound.put("SpawnY", e.getY());
			compound.put("SpawnZ", e.getZ());
			compound.put("SpawnForced", f);
		}

		foodData.b(compound);
		abilities.write(compound);
		compound.put("EnderItems", enderChest.h());
		ItemStack iteminhand = inventory.getItemInHand();
		if ((iteminhand != null) && (iteminhand.getItem() != null)) {
			compound.put("SelectedItem", iteminhand.write(new NBTTagCompound()));
		}
	}

	@Override
	public boolean damageEntity(class_pc var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (abilities.invulnerable && !var1.g()) {
			return false;
		} else {
			aT = 0;
			if (getHealth() <= 0.0F) {
				return false;
			} else {
				if (isSleeping() && !o.isClientSide) {
					this.a(true, true, false);
				}

				if (var1.r()) {
					if (o.ab() == class_om.a) {
						var2 = 0.0F;
					}

					if (o.ab() == class_om.b) {
						var2 = (var2 / 2.0F) + 1.0F;
					}

					if (o.ab() == class_om.d) {
						var2 = (var2 * 3.0F) / 2.0F;
					}
				}

				if (var2 == 0.0F) {
					return false;
				} else {
					Entity var3 = var1.j();
					if ((var3 instanceof class_xd) && (((class_xd) var3).e != null)) {
						var3 = ((class_xd) var3).e;
					}

					return super.damageEntity(var1, var2);
				}
			}
		}
	}

	public boolean a(EntityHuman var1) {
		class_awp var2 = bP();
		class_awp var3 = var1.bP();
		return var2 == null ? true : (!var2.a(var3) ? true : var2.g());
	}

	@Override
	protected void j(float var1) {
		inventory.a(var1);
	}

	@Override
	public int bs() {
		return inventory.m();
	}

	public float cc() {
		int var1 = 0;
		ItemStack[] var2 = inventory.b;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			ItemStack var5 = var2[var4];
			if (var5 != null) {
				++var1;
			}
		}

		return (float) var1 / (float) inventory.b.length;
	}

	@Override
	protected void d(class_pc var1, float var2) {
		if (!this.b(var1)) {
			if (!var1.e() && ca() && (var2 > 0.0F)) {
				var2 = (1.0F + var2) * 0.5F;
			}

			var2 = this.b(var1, var2);
			var2 = this.c(var1, var2);
			float var3 = var2;
			var2 = Math.max(var2 - getAbsorptionHearts(), 0.0F);
			setAbsorptionHearts(getAbsorptionHearts() - (var3 - var2));
			if (var2 != 0.0F) {
				this.a(var1.f());
				float var4 = getHealth();
				this.i(getHealth() - var2);
				bt().a(var1, var4, var2);
				if (var2 < 3.4028235E37F) {
					this.a(StatisticList.x, Math.round(var2 * 10.0F));
				}

			}
		}
	}

	public void a(TileEntitySign var1) {
	}

	public void a(class_aed var1) {
	}

	public void a(class_adz var1) {
	}

	public void openContainer(IInventory var1) {
	}

	public void a(class_tz var1, IInventory var2) {
	}

	public void a(ITileEntityContainer var1) {
	}

	public void a(ItemStack var1) {
	}

	public class_oq a(Entity var1, ItemStack var2, EnumUsedHand var3) {
		if (isSpectator()) {
			if (var1 instanceof IInventory) {
				openContainer((IInventory) var1);
			}

			return class_oq.b;
		} else {
			ItemStack var4 = var2 != null ? var2.clone() : null;
			if (!var1.a(this, var2, var3)) {
				if ((var2 != null) && (var1 instanceof EntityLiving)) {
					if (abilities.instabuild) {
						var2 = var4;
					}

					if (var2.a(this, (EntityLiving) var1, var3)) {
						if ((var2.count <= 0) && !abilities.instabuild) {
							this.a(var3, (ItemStack) null);
						}

						return class_oq.a;
					}
				}

				return class_oq.b;
			} else {
				if ((var2 != null) && (var2 == bA())) {
					if ((var2.count <= 0) && !abilities.instabuild) {
						this.a(var3, (ItemStack) null);
					} else if ((var2.count < var4.count) && abilities.instabuild) {
						var2.count = var4.count;
					}
				}

				return class_oq.a;
			}
		}
	}

	@Override
	public double am() {
		return -0.35D;
	}

	public void f(Entity var1) {
		if (var1.aF()) {
			if (!var1.l(this)) {
				float var2 = (float) this.a(class_wl.e).e();
				byte var3 = 0;
				float var4 = 0.0F;
				if (var1 instanceof EntityLiving) {
					var4 = EnchantmentManager.a(bA(), ((EntityLiving) var1).bz());
				} else {
					var4 = EnchantmentManager.a(bA(), class_qf.a);
				}

				int var18 = var3 + EnchantmentManager.a(this);
				if (ay()) {
					++var18;
				}

				if ((var2 > 0.0F) || (var4 > 0.0F)) {
					boolean var5 = (O > 0.0F) && !C && !k_() && !V() && !this.a(class_pm.o) && (vehicle == null) && (var1 instanceof EntityLiving);
					if (var5 && (var2 > 0.0F)) {
						var2 *= 1.5F;
					}

					var2 += var4;
					boolean var6 = false;
					int var7 = EnchantmentManager.b(this);
					if ((var1 instanceof EntityLiving) && (var7 > 0) && !var1.av()) {
						var6 = true;
						var1.f(1);
					}

					double var8 = var1.v;
					double var10 = var1.motY;
					double var12 = var1.x;
					boolean var14 = var1.damageEntity(class_pc.a(this), var2);
					if (var14) {
						if (var18 > 0) {
							var1.g(-MathHelper.sin((y * 3.1415927F) / 180.0F) * var18 * 0.5F, 0.1D, MathHelper.cos((y * 3.1415927F) / 180.0F) * var18 * 0.5F);
							v *= 0.6D;
							x *= 0.6D;
							this.d(false);
						}

						if ((var1 instanceof EntityPlayer) && var1.G) {
							((EntityPlayer) var1).a.a((new PacketPlayOutEntityVelocity(var1)));
							var1.G = false;
							var1.v = var8;
							var1.motY = var10;
							var1.x = var12;
						}

						if (var5) {
							this.b(var1);
						}

						if (var4 > 0.0F) {
							this.c(var1);
						}

						if (var2 >= 18.0F) {
							this.b(class_mt.F);
						}

						this.p(var1);
						if (var1 instanceof EntityLiving) {
							EnchantmentManager.a(((EntityLiving) var1), this);
						}

						EnchantmentManager.b(this, var1);
						ItemStack var15 = bA();
						Object var16 = var1;
						if (var1 instanceof class_up) {
							class_uo var17 = ((class_up) var1).a;
							if (var17 instanceof EntityLiving) {
								var16 = var17;
							}
						}

						if ((var15 != null) && (var16 instanceof EntityLiving)) {
							var15.a((EntityLiving) var16, this);
							if (var15.count <= 0) {
								this.a(EnumUsedHand.MAIN_HAND, (ItemStack) null);
							}
						}

						if (var1 instanceof EntityLiving) {
							this.a(StatisticList.w, Math.round(var2 * 10.0F));
							if (var7 > 0) {
								var1.f(var7 * 4);
							}
						}

						this.a(0.3F);
					} else if (var6) {
						var1.N();
					}
				}

			}
		}
	}

	public void b(Entity var1) {
	}

	public void c(Entity var1) {
	}

	@Override
	public void J() {
		super.J();
		bq.b(this);
		if (br != null) {
			br.b(this);
		}

	}

	@Override
	public boolean aj() {
		return !sleeping && super.aj();
	}

	public GameProfile cf() {
		return bO;
	}

	public EntityHuman.EnumBedResult trySleepOnBed(BlockPosition var1) {
		if (!o.isClientSide) {
			if (isSleeping() || !isAlive()) {
				return EntityHuman.EnumBedResult.OTHER_PROBLEM;
			}

			if (!o.worldProvider.d()) {
				return EntityHuman.EnumBedResult.NOT_POSSIBLE_HERE;
			}

			if (o.x()) {
				return EntityHuman.EnumBedResult.NOT_POSSIBLE_NOW;
			}

			if ((Math.abs(s - var1.getX()) > 3.0D) || (Math.abs(t - var1.getY()) > 2.0D) || (Math.abs(u - var1.getZ()) > 3.0D)) {
				return EntityHuman.EnumBedResult.TOO_FAR_AWAY;
			}

			double var2 = 8.0D;
			double var4 = 5.0D;
			List var6 = o.getEntities(class_wi.class, new AxisAlignedBB(var1.getX() - var2, var1.getY() - var4, var1.getZ() - var2, var1.getX() + var2, var1.getY() + var4, var1.getZ() + var2));
			if (!var6.isEmpty()) {
				return EntityHuman.EnumBedResult.NOT_SAFE;
			}
		}

		if (aw()) {
			this.a((Entity) null);
		}

		this.a(0.2F, 0.2F);
		if (o.e(var1)) {
			EnumDirection var7 = o.getType(var1).get(BlockDirectional.FACING);
			float var3 = 0.5F;
			float var8 = 0.5F;
			switch (EntityHuman.SyntheticClass_1.a[var7.ordinal()]) {
				case 1:
					var8 = 0.9F;
					break;
				case 2:
					var8 = 0.1F;
					break;
				case 3:
					var3 = 0.1F;
					break;
				case 4:
					var3 = 0.9F;
			}

			this.a(var7);
			this.b(var1.getX() + var3, var1.getY() + 0.6875F, var1.getZ() + var8);
		} else {
			this.b(var1.getX() + 0.5F, var1.getY() + 0.6875F, var1.getZ() + 0.5F);
		}

		sleeping = true;
		sleepTicks = 0;
		bedPosition = var1;
		v = x = motY = 0.0D;
		if (!o.isClientSide) {
			o.e();
		}

		return EntityHuman.EnumBedResult.OK;
	}

	private void a(EnumDirection var1) {
		bF = 0.0F;
		bG = 0.0F;
		switch (EntityHuman.SyntheticClass_1.a[var1.ordinal()]) {
			case 1:
				bG = -1.8F;
				break;
			case 2:
				bG = 1.8F;
				break;
			case 3:
				bF = 1.8F;
				break;
			case 4:
				bF = -1.8F;
		}

	}

	public void a(boolean var1, boolean var2, boolean var3) {
		this.a(0.6F, 1.8F);
		IBlockData var4 = o.getType(bedPosition);
		if ((bedPosition != null) && (var4.getBlock() == Blocks.BED)) {
			o.setTypeAndData(bedPosition, var4.set(BlockBed.OCCUPIED, Boolean.valueOf(false)), 4);
			BlockPosition var5 = BlockBed.a(o, bedPosition, 0);
			if (var5 == null) {
				var5 = bedPosition.up();
			}

			this.b(var5.getX() + 0.5F, var5.getY() + 0.1F, var5.getZ() + 0.5F);
		}

		sleeping = false;
		if (!o.isClientSide && var2) {
			o.e();
		}

		sleepTicks = var1 ? 0 : 100;
		if (var3) {
			this.a(bedPosition, false);
		}

	}

	private boolean p() {
		return o.getType(bedPosition).getBlock() == Blocks.BED;
	}

	public static BlockPosition a(World var0, BlockPosition var1, boolean var2) {
		Block var3 = var0.getType(var1).getBlock();
		if (var3 != Blocks.BED) {
			if (!var2) {
				return null;
			} else {
				boolean var4 = var3.g();
				boolean var5 = var0.getType(var1.up()).getBlock().g();
				return var4 && var5 ? var1 : null;
			}
		} else {
			return BlockBed.a(var0, var1, 0);
		}
	}

	@Override
	public boolean isSleeping() {
		return sleeping;
	}

	public boolean ch() {
		return sleeping && (sleepTicks >= 100);
	}

	public void b(IChatBaseComponent var1) {
	}

	public BlockPosition cj() {
		return e;
	}

	public boolean ck() {
		return f;
	}

	public void a(BlockPosition var1, boolean var2) {
		if (var1 != null) {
			e = var1;
			f = var2;
		} else {
			e = null;
			f = false;
		}

	}

	public void b(class_my var1) {
		this.a(var1, 1);
	}

	public void a(class_my var1, int var2) {
	}

	public void a(class_my var1) {
	}

	@Override
	public void bG() {
		super.bG();
		this.b(StatisticList.u);
		if (ay()) {
			this.a(0.8F);
		} else {
			this.a(0.2F);
		}

	}

	@Override
	public void g(float var1, float var2) {
		double var3 = s;
		double var5 = t;
		double var7 = u;
		if (abilities.flying && (vehicle == null)) {
			double var9 = motY;
			float var11 = aP;
			aP = abilities.getFlySpeed() * (ay() ? 2 : 1);
			super.g(var1, var2);
			motY = var9 * 0.6D;
			aP = var11;
		} else {
			super.g(var1, var2);
		}

		this.k(s - var3, t - var5, u - var7);
	}

	@Override
	public float bJ() {
		return (float) this.a(class_wl.d).e();
	}

	public void k(double var1, double var3, double var5) {
		if (vehicle == null) {
			int var7;
			if (this.a(Material.WATER)) {
				var7 = Math.round(MathHelper.sqrt((var1 * var1) + (var3 * var3) + (var5 * var5)) * 100.0F);
				if (var7 > 0) {
					this.a(StatisticList.p, var7);
					this.a(0.015F * var7 * 0.01F);
				}
			} else if (V()) {
				var7 = Math.round(MathHelper.sqrt((var1 * var1) + (var5 * var5)) * 100.0F);
				if (var7 > 0) {
					this.a(StatisticList.l, var7);
					this.a(0.015F * var7 * 0.01F);
				}
			} else if (k_()) {
				if (var3 > 0.0D) {
					this.a(StatisticList.n, (int) Math.round(var3 * 100.0D));
				}
			} else if (C) {
				var7 = Math.round(MathHelper.sqrt((var1 * var1) + (var5 * var5)) * 100.0F);
				if (var7 > 0) {
					this.a(StatisticList.i, var7);
					if (ay()) {
						this.a(StatisticList.k, var7);
						this.a(0.099999994F * var7 * 0.01F);
					} else {
						if (ax()) {
							this.a(StatisticList.j, var7);
						}

						this.a(0.01F * var7 * 0.01F);
					}
				}
			} else {
				var7 = Math.round(MathHelper.sqrt((var1 * var1) + (var5 * var5)) * 100.0F);
				if (var7 > 25) {
					this.a(StatisticList.o, var7);
				}
			}

		}
	}

	private void l(double var1, double var3, double var5) {
		if (vehicle != null) {
			int var7 = Math.round(MathHelper.sqrt((var1 * var1) + (var3 * var3) + (var5 * var5)) * 100.0F);
			if (var7 > 0) {
				if (vehicle instanceof class_vn) {
					this.a(StatisticList.q, var7);
					if (g == null) {
						g = new BlockPosition(this);
					} else if (g.distanceSquared(MathHelper.floor(s), MathHelper.floor(t), MathHelper.floor(u)) >= 1000000.0D) {
						this.b(class_mt.q);
					}
				} else if (vehicle instanceof class_vk) {
					this.a(StatisticList.r, var7);
				} else if (vehicle instanceof class_ud) {
					this.a(StatisticList.s, var7);
				} else if (vehicle instanceof class_tz) {
					this.a(StatisticList.t, var7);
				}
			}
		}

	}

	@Override
	public void e(float var1, float var2) {
		if (!abilities.mayfly) {
			if (var1 >= 2.0F) {
				this.a(StatisticList.m, (int) Math.round(var1 * 100.0D));
			}

			super.e(var1, var2);
		}
	}

	@Override
	protected void X() {
		if (!isSpectator()) {
			super.X();
		}

	}

	@Override
	protected String k(int var1) {
		return var1 > 4 ? "game.player.hurt.fall.big" : "game.player.hurt.fall.small";
	}

	@Override
	public void a(EntityLiving var1) {
		if (var1 instanceof class_wd) {
			this.b(class_mt.s);
		}

		class_pt.class_a_in_class_pt var2 = (class_pt.class_a_in_class_pt) class_pt.a.get(Integer.valueOf(class_pt.a(var1)));
		if (var2 != null) {
			this.b(var2.d);
		}

	}

	@Override
	public void aC() {
		if (!abilities.flying) {
			super.aC();
		}

	}

	public void o(int var1) {
		addScore(var1);
		int var2 = Integer.MAX_VALUE - expTotal;
		if (var1 > var2) {
			var1 = var2;
		}

		exp += (float) var1 / (float) cm();

		for (expTotal += var1; exp >= 1.0F; exp /= cm()) {
			exp = (exp - 1.0F) * cm();
			this.a(1);
		}

	}

	public int cl() {
		return xpSeed;
	}

	public void b(int var1) {
		expLevel -= var1;
		if (expLevel < 0) {
			expLevel = 0;
			exp = 0.0F;
			expTotal = 0;
		}

		xpSeed = random.nextInt();
	}

	public void a(int var1) {
		expLevel += var1;
		if (expLevel < 0) {
			expLevel = 0;
			exp = 0.0F;
			expTotal = 0;
		}

		if ((var1 > 0) && ((expLevel % 5) == 0) && (i < (W - 100.0F))) {
			float var2 = expLevel > 30 ? 1.0F : expLevel / 30.0F;
			o.a((Entity) this, "random.levelup", var2 * 0.75F, 1.0F);
			i = W;
		}

	}

	public int cm() {
		return expLevel >= 30 ? 112 + ((expLevel - 30) * 9) : (expLevel >= 15 ? 37 + ((expLevel - 15) * 5) : 7 + (expLevel * 2));
	}

	public void a(float var1) {
		if (!abilities.invulnerable) {
			if (!o.isClientSide) {
				foodData.a(var1);
			}

		}
	}

	public class_xx cn() {
		return foodData;
	}

	public boolean j(boolean var1) {
		return (var1 || foodData.c()) && !abilities.invulnerable;
	}

	public boolean co() {
		return (getHealth() > 0.0F) && (getHealth() < bv());
	}

	public boolean cp() {
		return abilities.mayBuild;
	}

	public boolean a(BlockPosition var1, EnumDirection var2, ItemStack var3) {
		if (abilities.mayBuild) {
			return true;
		} else if (var3 == null) {
			return false;
		} else {
			BlockPosition var4 = var1.shift(var2.opposite());
			Block var5 = o.getType(var4).getBlock();
			return var3.d(var5) || var3.x();
		}
	}

	@Override
	protected int b(EntityHuman var1) {
		if (o.R().b("keepInventory")) {
			return 0;
		} else {
			int var2 = expLevel * 7;
			return var2 > 100 ? 100 : var2;
		}
	}

	@Override
	protected boolean bc() {
		return true;
	}

	public void a(EntityHuman var1, boolean var2) {
		if (var2) {
			inventory.a(var1.inventory);
			this.i(var1.getHealth());
			foodData = var1.foodData;
			expLevel = var1.expLevel;
			expTotal = var1.expTotal;
			exp = var1.exp;
			setScore(var1.getScore());
			an = var1.an;
			ao = var1.ao;
			ap = var1.ap;
		} else if (o.R().b("keepInventory")) {
			inventory.a(var1.inventory);
			expLevel = var1.expLevel;
			expTotal = var1.expTotal;
			exp = var1.exp;
			setScore(var1.getScore());
		}

		xpSeed = var1.xpSeed;
		enderChest = var1.enderChest;
		H().update(SKIN_PARTS_DW_ID, Byte.valueOf(var1.H().getByte(SKIN_PARTS_DW_ID)));
	}

	@Override
	protected boolean s_() {
		return !abilities.flying;
	}

	public void t() {
	}

	public void a(WorldSettings.EnumGameMode var1) {
	}

	@Override
	public String getName() {
		return bO.getName();
	}

	public class_yu cq() {
		return enderChest;
	}

	@Override
	public ItemStack a(class_pw var1) {
		return var1 == class_pw.a ? inventory.getItemInHand() : (var1 == class_pw.b ? inventory.c[0] : (var1.a() == class_pw.class_a_in_class_pw.b ? inventory.b[var1.b()] : null));
	}

	@Override
	public void a(class_pw var1, ItemStack var2) {
		if (var1 == class_pw.a) {
			inventory.a[inventory.itemInHandIndex] = var2;
		} else if (var1 == class_pw.b) {
			inventory.c[0] = var2;
		} else if (var1.a() == class_pw.class_a_in_class_pw.b) {
			inventory.b[var1.b()] = var2;
		}

	}

	@Override
	public Iterable as() {
		return Lists.newArrayList((Object[]) (new ItemStack[] { bA(), bB() }));
	}

	@Override
	public Iterable at() {
		return Arrays.asList(inventory.b);
	}

	public abstract boolean isSpectator();

	@Override
	public boolean aN() {
		return !abilities.flying;
	}

	public class_awn cr() {
		return o.aa();
	}

	@Override
	public class_awp bP() {
		return cr().h(getName());
	}

	@Override
	public IChatBaseComponent getScoreboardDisplayName() {
		ChatComponentText var1 = new ChatComponentText(class_awk.a(bP(), getName()));
		var1.b().a(new class_et(class_et.class_a_in_class_et.d, "/msg " + getName() + " "));
		var1.b().a(aS());
		var1.b().a(getName());
		return var1;
	}

	@Override
	public float aU() {
		float var1 = 1.62F;
		if (isSleeping()) {
			var1 = 0.2F;
		}

		if (ax()) {
			var1 -= 0.08F;
		}

		return var1;
	}

	@Override
	public void setAbsorptionHearts(float var1) {
		if (var1 < 0.0F) {
			var1 = 0.0F;
		}

		H().update(ABS_HEARTH_DW_ID, Float.valueOf(var1));
	}

	@Override
	public float getAbsorptionHearts() {
		return H().getFloat(ABS_HEARTH_DW_ID);
	}

	public static UUID a(GameProfile var0) {
		UUID var1 = var0.getId();
		if (var1 == null) {
			var1 = b(var0.getName());
		}

		return var1;
	}

	public static UUID b(String var0) {
		return UUID.nameUUIDFromBytes(("OfflinePlayer:" + var0).getBytes(Charsets.UTF_8));
	}

	public boolean a(ChestLock var1) {
		if (var1.isNotLocked()) {
			return true;
		} else {
			ItemStack var2 = bA();
			return (var2 != null) && var2.hasDisplayName() ? var2.getDisplayName().equals(var1.getName()) : false;
		}
	}

	@Override
	public boolean u_() {
		return MinecraftServer.N().d[0].R().b("sendCommandFeedback");
	}

	@Override
	public boolean c(int var1, ItemStack var2) {
		if ((var1 >= 0) && (var1 < inventory.a.length)) {
			inventory.setItem(var1, var2);
			return true;
		} else {
			class_pw var3;
			if (var1 == (100 + class_pw.f.b())) {
				var3 = class_pw.f;
			} else if (var1 == (100 + class_pw.e.b())) {
				var3 = class_pw.e;
			} else if (var1 == (100 + class_pw.d.b())) {
				var3 = class_pw.d;
			} else if (var1 == (100 + class_pw.c.b())) {
				var3 = class_pw.c;
			} else {
				var3 = null;
			}

			if (var1 == 98) {
				this.a(class_pw.a, var2);
				return true;
			} else if (var1 == 99) {
				this.a(class_pw.b, var2);
				return true;
			} else if (var3 == null) {
				int var4 = var1 - 200;
				if ((var4 >= 0) && (var4 < enderChest.getSize())) {
					enderChest.setItem(var4, var2);
					return true;
				} else {
					return false;
				}
			} else {
				if ((var2 != null) && (var2.getItem() != null)) {
					if (var2.getItem() instanceof class_za) {
						if (class_qb.c(var2) != var3) {
							return false;
						}
					} else if ((var3 != class_pw.f) || ((var2.getItem() != Items.ca) && !(var2.getItem() instanceof ItemBlock))) {
						return false;
					}
				}

				inventory.setItem(var3.b() + inventory.a.length, var2);
				return true;
			}
		}
	}

	public EnumMainHandOption bR() {
		EnumMainHandOption pz;
		if (datawatcher.getByte(MAIN_HAND_DW_ID) == 0) {
			pz = EnumMainHandOption.LEFT;
			return pz;
		}
		pz = EnumMainHandOption.RIGHT;
		return pz;
	}

	public void a(EnumMainHandOption pz) {
		datawatcher.update(MAIN_HAND_DW_ID, Byte.valueOf((byte) (pz == EnumMainHandOption.LEFT ? 0 : 1)));
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[EnumDirection.values().length];

		static {
			try {
				a[EnumDirection.SOUTH.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[EnumDirection.NORTH.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[EnumDirection.WEST.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[EnumDirection.EAST.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum EnumBedResult {
		OK, NOT_POSSIBLE_HERE, NOT_POSSIBLE_NOW, TOO_FAR_AWAY, OTHER_PROBLEM, NOT_SAFE;
	}

	public static enum ChatMode {
		FULL, SYSTEM, HIDDEN;
	}
}
