package net.minecraft.server;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.EnchantmentManager;
import net.minecraft.server.class_adz;
import net.minecraft.server.class_aed;
import net.minecraft.server.World;
import net.minecraft.server.WorldSettings;
import net.minecraft.server.BlockBed;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockDirectional;
import net.minecraft.server.TileEntitySign;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awk;
import net.minecraft.server.class_awl;
import net.minecraft.server.class_awn;
import net.minecraft.server.class_awp;
import net.minecraft.server.class_awt;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;
import net.minecraft.server.class_et;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketPlayOutEntityVelocity;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.StatisticList;
import net.minecraft.server.MathHelper;
import net.minecraft.server.IInventory;
import net.minecraft.server.class_om;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.ITileEntityContainer;
import net.minecraft.server.class_oq;
import net.minecraft.server.ChestLock;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pk;
import net.minecraft.server.class_pm;
import net.minecraft.server.Entity;
import net.minecraft.server.class_pt;
import net.minecraft.server.class_pw;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qf;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_tz;
import net.minecraft.server.class_ud;
import net.minecraft.server.class_uo;
import net.minecraft.server.class_up;
import net.minecraft.server.class_ve;
import net.minecraft.server.class_vk;
import net.minecraft.server.EntityItem;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_wd;
import net.minecraft.server.class_wi;
import net.minecraft.server.class_wl;
import net.minecraft.server.PlayerAbilities;
import net.minecraft.server.PlayerInventory;
import net.minecraft.server.class_xd;
import net.minecraft.server.class_xx;
import net.minecraft.server.Container;
import net.minecraft.server.class_yp;
import net.minecraft.server.class_yu;
import net.minecraft.server.class_za;
import net.minecraft.server.ItemBlock;

public abstract class EntityHuman extends EntityLiving {
	private static final int a = class_qi.a(EntityHuman.class);
	private static final int b = class_qi.a(EntityHuman.class);
	protected static final int bn = class_qi.a(EntityHuman.class);
	protected static final int bo = class_qi.a(EntityHuman.class);
	public PlayerInventory bp = new PlayerInventory(this);
	private class_yu c = new class_yu();
	public Container bq;
	public Container br;
	protected class_xx bs = new class_xx();
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
	protected boolean bD;
	public BlockPosition bedPosition;
	private int d;
	public float bF;
	public float bG;
	private BlockPosition e;
	private boolean f;
	private BlockPosition g;
	public PlayerAbilities bH = new PlayerAbilities();
	public int bI;
	public int bJ;
	public float bK;
	private int h;
	protected float bL = 0.1F;
	protected float bM = 0.02F;
	private int i;
	private final GameProfile bO;
	private boolean bP = false;
	public class_ve bN;

	public EntityHuman(World var1, GameProfile var2) {
		super(var1);
		this.aq = a(var2);
		this.bO = var2;
		this.bq = new class_yp(this.bp, !var1.isClientSide, this);
		this.br = this.bq;
		BlockPosition var3 = var1.N();
		this.b((double) var3.getX() + 0.5D, (double) (var3.getY() + 1), (double) var3.getZ() + 0.5D, 0.0F, 0.0F);
		this.aY = 180.0F;
		this.X = 20;
	}

	protected void aY() {
		super.aY();
		this.by().b(class_wl.e).a(1.0D);
		this.a((class_qk) class_wl.d).a(0.10000000149011612D);
	}

	protected void h() {
		super.h();
		this.ac.a(a, Float.valueOf(0.0F));
		this.ac.a(b, Integer.valueOf(0));
		this.ac.a(bn, Byte.valueOf((byte) 0));
		this.ac.a(bo, Byte.valueOf((byte) 1));
	}

	public void t_() {
		this.T = this.v();
		if (this.v()) {
			this.C = false;
		}

		if (this.bw > 0) {
			--this.bw;
		}

		if (this.isSleeping()) {
			++this.d;
			if (this.d > 100) {
				this.d = 100;
			}

			if (!this.o.isClientSide) {
				if (!this.p()) {
					this.a(true, true, false);
				} else if (this.o.x()) {
					this.a(false, true, true);
				}
			}
		} else if (this.d > 0) {
			++this.d;
			if (this.d >= 110) {
				this.d = 0;
			}
		}

		super.t_();
		if (!this.o.isClientSide && this.br != null && !this.br.a(this)) {
			this.n();
			this.br = this.bq;
		}

		if (this.av() && this.bH.invulnerable) {
			this.N();
		}

		this.bx = this.bA;
		this.by = this.bB;
		this.bz = this.bC;
		double var1 = this.s - this.bA;
		double var3 = this.t - this.bB;
		double var5 = this.u - this.bC;
		double var7 = 10.0D;
		if (var1 > var7) {
			this.bx = this.bA = this.s;
		}

		if (var5 > var7) {
			this.bz = this.bC = this.u;
		}

		if (var3 > var7) {
			this.by = this.bB = this.t;
		}

		if (var1 < -var7) {
			this.bx = this.bA = this.s;
		}

		if (var5 < -var7) {
			this.bz = this.bC = this.u;
		}

		if (var3 < -var7) {
			this.by = this.bB = this.t;
		}

		this.bA += var1 * 0.25D;
		this.bC += var5 * 0.25D;
		this.bB += var3 * 0.25D;
		if (this.m == null) {
			this.g = null;
		}

		if (!this.o.isClientSide) {
			this.bs.a(this);
			this.b(StatisticList.g);
			if (this.ai()) {
				this.b(StatisticList.h);
			}
		}

		int var9 = 29999999;
		double var10 = MathHelper.clamp(this.s, -2.9999999E7D, 2.9999999E7D);
		double var12 = MathHelper.clamp(this.u, -2.9999999E7D, 2.9999999E7D);
		if (var10 != this.s || var12 != this.u) {
			this.b(var10, this.t, var12);
		}

	}

	public int L() {
		return this.bH.invulnerable ? 0 : 80;
	}

	protected String P() {
		return "game.player.swim";
	}

	protected String aa() {
		return "game.player.swim.splash";
	}

	public int aq() {
		return 10;
	}

	public void a(String var1, float var2, float var3) {
		this.o.a(this, var1, var2, var3);
	}

	protected boolean bE() {
		return this.bo() <= 0.0F || this.isSleeping();
	}

	protected void n() {
		this.br = this.bq;
	}

	public void ak() {
		if (!this.o.isClientSide && this.ax()) {
			this.a((Entity) null);
			this.c(false);
		} else {
			double var1 = this.s;
			double var3 = this.t;
			double var5 = this.u;
			float var7 = this.y;
			float var8 = this.z;
			super.ak();
			this.bu = this.bv;
			this.bv = 0.0F;
			this.l(this.s - var1, this.t - var3, this.u - var5);
			if (this.m instanceof class_ud) {
				this.z = var8;
				this.y = var7;
				this.aL = ((class_ud) this.m).aL;
			}

		}
	}

	protected void bL() {
		super.bL();
		this.bx();
		this.aN = this.y;
	}

	public void m() {
		if (this.bt > 0) {
			--this.bt;
		}

		if (this.o.ab() == class_om.a && this.o.R().b("naturalRegeneration")) {
			if (this.bo() < this.bv() && this.W % 20 == 0) {
				this.h(1.0F);
			}

			if (this.bs.c() && this.W % 10 == 0) {
				this.bs.a(this.bs.a() + 1);
			}
		}

		this.bp.k();
		this.bu = this.bv;
		super.m();
		class_ql var1 = this.a((class_qk) class_wl.d);
		if (!this.o.isClientSide) {
			var1.a((double) this.bH.getWalkSpeed());
		}

		this.aP = this.bM;
		if (this.ay()) {
			this.aP = (float) ((double) this.aP + (double) this.bM * 0.3D);
		}

		this.k((float) var1.e());
		float var2 = MathHelper.sqrt(this.v * this.v + this.x * this.x);
		float var3 = (float) (Math.atan(-this.motY * 0.20000000298023224D) * 15.0D);
		if (var2 > 0.1F) {
			var2 = 0.1F;
		}

		if (!this.C || this.bo() <= 0.0F) {
			var2 = 0.0F;
		}

		if (this.C || this.bo() <= 0.0F) {
			var3 = 0.0F;
		}

		this.bv += (var2 - this.bv) * 0.4F;
		this.aI += (var3 - this.aI) * 0.8F;
		if (this.bo() > 0.0F && !this.v()) {
			AxisAlignedBB var4 = null;
			if (this.m != null && !this.m.I) {
				var4 = this.aT().a(this.m.aT()).grow(1.0D, 0.0D, 1.0D);
			} else {
				var4 = this.aT().grow(1.0D, 0.5D, 1.0D);
			}

			List var5 = this.o.b((Entity) this, (AxisAlignedBB) var4);

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

	public int cb() {
		return this.ac.c(b);
	}

	public void m(int var1) {
		this.ac.b(b, Integer.valueOf(var1));
	}

	public void n(int var1) {
		int var2 = this.cb();
		this.ac.b(b, Integer.valueOf(var2 + var1));
	}

	public void a(class_pc var1) {
		super.a(var1);
		this.a(0.2F, 0.2F);
		this.b(this.s, this.t, this.u);
		this.motY = 0.10000000149011612D;
		if (this.getName().equals("Notch")) {
			this.a(new ItemStack(Items.e, 1), true, false);
		}

		if (!this.o.R().b("keepInventory")) {
			this.bp.n();
		}

		if (var1 != null) {
			this.v = (double) (-MathHelper.cos((this.az + this.y) * 3.1415927F / 180.0F) * 0.1F);
			this.x = (double) (-MathHelper.sin((this.az + this.y) * 3.1415927F / 180.0F) * 0.1F);
		} else {
			this.v = this.x = 0.0D;
		}

		this.b(StatisticList.y);
		this.a(StatisticList.h);
	}

	protected String bp() {
		return "game.player.hurt";
	}

	protected String bq() {
		return "game.player.die";
	}

	public void b(Entity var1, int var2) {
		this.n(var2);
		Collection var3 = this.cr().a(class_awt.f);
		if (var1 instanceof EntityHuman) {
			this.b(StatisticList.B);
			var3.addAll(this.cr().a(class_awt.e));
			var3.addAll(this.e(var1));
		} else {
			this.b(StatisticList.z);
		}

		Iterator var4 = var3.iterator();

		while (var4.hasNext()) {
			class_awj var5 = (class_awj) var4.next();
			class_awl var6 = this.cr().c(this.getName(), var5);
			var6.a();
		}

	}

	private Collection e(Entity var1) {
		class_awk var2 = this.cr().h(this.getName());
		if (var2 != null) {
			int var3 = var2.l().getId();
			if (var3 >= 0 && var3 < class_awt.i.length) {
				Iterator var4 = this.cr().a(class_awt.i[var3]).iterator();

				while (var4.hasNext()) {
					class_awj var5 = (class_awj) var4.next();
					class_awl var6 = this.cr().c(var1.getName(), var5);
					var6.a();
				}
			}
		}

		class_awk var7 = this.cr().h(var1.getName());
		if (var7 != null) {
			int var8 = var7.l().getId();
			if (var8 >= 0 && var8 < class_awt.h.length) {
				return this.cr().a(class_awt.h[var8]);
			}
		}

		return Lists.newArrayList();
	}

	public EntityItem a(boolean var1) {
		return this.a(this.bp.splitStack(this.bp.d, var1 && this.bp.h() != null ? this.bp.h().count : 1), false, true);
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
			double var4 = this.t - 0.30000001192092896D + (double) this.aU();
			EntityItem var6 = new EntityItem(this.o, this.s, var4, this.u, var1);
			var6.setPickupDelay(40);
			if (var3) {
				var6.c(this.getName());
			}

			float var7;
			float var8;
			if (var2) {
				var7 = this.V.nextFloat() * 0.5F;
				var8 = this.V.nextFloat() * 3.1415927F * 2.0F;
				var6.v = (double) (-MathHelper.sin(var8) * var7);
				var6.x = (double) (MathHelper.cos(var8) * var7);
				var6.motY = 0.20000000298023224D;
			} else {
				var7 = 0.3F;
				var6.v = (double) (-MathHelper.sin(this.y / 180.0F * 3.1415927F) * MathHelper.cos(this.z / 180.0F * 3.1415927F) * var7);
				var6.x = (double) (MathHelper.cos(this.y / 180.0F * 3.1415927F) * MathHelper.cos(this.z / 180.0F * 3.1415927F) * var7);
				var6.motY = (double) (-MathHelper.sin(this.z / 180.0F * 3.1415927F) * var7 + 0.1F);
				var8 = this.V.nextFloat() * 3.1415927F * 2.0F;
				var7 = 0.02F * this.V.nextFloat();
				var6.v += Math.cos((double) var8) * (double) var7;
				var6.motY += (double) ((this.V.nextFloat() - this.V.nextFloat()) * 0.1F);
				var6.x += Math.sin((double) var8) * (double) var7;
			}

			this.a(var6);
			if (var3) {
				this.b(StatisticList.v);
			}

			return var6;
		}
	}

	protected void a(EntityItem var1) {
		this.o.addEntity((Entity) var1);
	}

	public float a(Block var1) {
		float var2 = this.bp.a(var1);
		if (var2 > 1.0F) {
			int var3 = EnchantmentManager.e(this);
			ItemStack var4 = this.bA();
			if (var3 > 0 && var4 != null) {
				var2 += (float) (var3 * var3 + 1);
			}
		}

		if (this.a((class_pk) class_pm.c)) {
			var2 *= 1.0F + (float) (this.b((class_pk) class_pm.c).c() + 1) * 0.2F;
		}

		if (this.a((class_pk) class_pm.d)) {
			float var5 = 1.0F;
			switch (this.b((class_pk) class_pm.d).c()) {
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

		if (this.a((Material) Material.WATER) && !EnchantmentManager.i(this)) {
			var2 /= 5.0F;
		}

		if (!this.C) {
			var2 /= 5.0F;
		}

		return var2;
	}

	public boolean b(Block var1) {
		return this.bp.b(var1);
	}

	public void a(NBTTagCompound var1) {
		super.a(var1);
		this.aq = a(this.bO);
		NBTTagList var2 = var1.getList("Inventory", 10);
		this.bp.b(var2);
		this.bp.d = var1.getInt("SelectedItemSlot");
		this.bD = var1.getBoolean("Sleeping");
		this.d = var1.getShort("SleepTimer");
		this.bK = var1.getFloat("XpP");
		this.bI = var1.getInt("XpLevel");
		this.bJ = var1.getInt("XpTotal");
		this.h = var1.getInt("XpSeed");
		if (this.h == 0) {
			this.h = this.V.nextInt();
		}

		this.m(var1.getInt("Score"));
		if (this.bD) {
			this.bedPosition = new BlockPosition(this);
			this.a(true, true, false);
		}

		if (var1.hasOfType("SpawnX", 99) && var1.hasOfType("SpawnY", 99) && var1.hasOfType("SpawnZ", 99)) {
			this.e = new BlockPosition(var1.getInt("SpawnX"), var1.getInt("SpawnY"), var1.getInt("SpawnZ"));
			this.f = var1.getBoolean("SpawnForced");
		}

		this.bs.a(var1);
		this.bH.read(var1);
		if (var1.hasOfType("EnderItems", 9)) {
			NBTTagList var3 = var1.getList("EnderItems", 10);
			this.c.a(var3);
		}

	}

	public void b(NBTTagCompound var1) {
		super.b(var1);
		var1.put((String) "Inventory", (NBTTag) this.bp.a(new NBTTagList()));
		var1.put("SelectedItemSlot", this.bp.d);
		var1.put("Sleeping", this.bD);
		var1.put("SleepTimer", (short) this.d);
		var1.put("XpP", this.bK);
		var1.put("XpLevel", this.bI);
		var1.put("XpTotal", this.bJ);
		var1.put("XpSeed", this.h);
		var1.put("Score", this.cb());
		if (this.e != null) {
			var1.put("SpawnX", this.e.getX());
			var1.put("SpawnY", this.e.getY());
			var1.put("SpawnZ", this.e.getZ());
			var1.put("SpawnForced", this.f);
		}

		this.bs.b(var1);
		this.bH.write(var1);
		var1.put((String) "EnderItems", (NBTTag) this.c.h());
		ItemStack var2 = this.bp.h();
		if (var2 != null && var2.getItem() != null) {
			var1.put((String) "SelectedItem", (NBTTag) var2.write(new NBTTagCompound()));
		}

	}

	public boolean a(class_pc var1, float var2) {
		if (this.b((class_pc) var1)) {
			return false;
		} else if (this.bH.invulnerable && !var1.g()) {
			return false;
		} else {
			this.aT = 0;
			if (this.bo() <= 0.0F) {
				return false;
			} else {
				if (this.isSleeping() && !this.o.isClientSide) {
					this.a(true, true, false);
				}

				if (var1.r()) {
					if (this.o.ab() == class_om.a) {
						var2 = 0.0F;
					}

					if (this.o.ab() == class_om.b) {
						var2 = var2 / 2.0F + 1.0F;
					}

					if (this.o.ab() == class_om.d) {
						var2 = var2 * 3.0F / 2.0F;
					}
				}

				if (var2 == 0.0F) {
					return false;
				} else {
					Entity var3 = var1.j();
					if (var3 instanceof class_xd && ((class_xd) var3).e != null) {
						var3 = ((class_xd) var3).e;
					}

					return super.a(var1, var2);
				}
			}
		}
	}

	public boolean a(EntityHuman var1) {
		class_awp var2 = this.bP();
		class_awp var3 = var1.bP();
		return var2 == null ? true : (!var2.a(var3) ? true : var2.g());
	}

	protected void j(float var1) {
		this.bp.a(var1);
	}

	public int bs() {
		return this.bp.m();
	}

	public float cc() {
		int var1 = 0;
		ItemStack[] var2 = this.bp.b;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			ItemStack var5 = var2[var4];
			if (var5 != null) {
				++var1;
			}
		}

		return (float) var1 / (float) this.bp.b.length;
	}

	protected void d(class_pc var1, float var2) {
		if (!this.b((class_pc) var1)) {
			if (!var1.e() && this.ca() && var2 > 0.0F) {
				var2 = (1.0F + var2) * 0.5F;
			}

			var2 = this.b(var1, var2);
			var2 = this.c(var1, var2);
			float var3 = var2;
			var2 = Math.max(var2 - this.bO(), 0.0F);
			this.m(this.bO() - (var3 - var2));
			if (var2 != 0.0F) {
				this.a(var1.f());
				float var4 = this.bo();
				this.i(this.bo() - var2);
				this.bt().a(var1, var4, var2);
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
		if (this.v()) {
			if (var1 instanceof IInventory) {
				this.openContainer((IInventory) var1);
			}

			return class_oq.b;
		} else {
			ItemStack var4 = var2 != null ? var2.clone() : null;
			if (!var1.a(this, var2, var3)) {
				if (var2 != null && var1 instanceof EntityLiving) {
					if (this.bH.instabuild) {
						var2 = var4;
					}

					if (var2.a(this, (EntityLiving) var1, var3)) {
						if (var2.count <= 0 && !this.bH.instabuild) {
							this.a((EnumUsedHand) var3, (ItemStack) null);
						}

						return class_oq.a;
					}
				}

				return class_oq.b;
			} else {
				if (var2 != null && var2 == this.bA()) {
					if (var2.count <= 0 && !this.bH.instabuild) {
						this.a((EnumUsedHand) var3, (ItemStack) null);
					} else if (var2.count < var4.count && this.bH.instabuild) {
						var2.count = var4.count;
					}
				}

				return class_oq.a;
			}
		}
	}

	public double am() {
		return -0.35D;
	}

	public void f(Entity var1) {
		if (var1.aF()) {
			if (!var1.l(this)) {
				float var2 = (float) this.a((class_qk) class_wl.e).e();
				byte var3 = 0;
				float var4 = 0.0F;
				if (var1 instanceof EntityLiving) {
					var4 = EnchantmentManager.a(this.bA(), ((EntityLiving) var1).bz());
				} else {
					var4 = EnchantmentManager.a(this.bA(), class_qf.a);
				}

				int var18 = var3 + EnchantmentManager.a((EntityLiving) this);
				if (this.ay()) {
					++var18;
				}

				if (var2 > 0.0F || var4 > 0.0F) {
					boolean var5 = this.O > 0.0F && !this.C && !this.k_() && !this.V() && !this.a((class_pk) class_pm.o) && this.m == null && var1 instanceof EntityLiving;
					if (var5 && var2 > 0.0F) {
						var2 *= 1.5F;
					}

					var2 += var4;
					boolean var6 = false;
					int var7 = EnchantmentManager.b(this);
					if (var1 instanceof EntityLiving && var7 > 0 && !var1.av()) {
						var6 = true;
						var1.f(1);
					}

					double var8 = var1.v;
					double var10 = var1.motY;
					double var12 = var1.x;
					boolean var14 = var1.a(class_pc.a(this), var2);
					if (var14) {
						if (var18 > 0) {
							var1.g((double) (-MathHelper.sin(this.y * 3.1415927F / 180.0F) * (float) var18 * 0.5F), 0.1D, (double) (MathHelper.cos(this.y * 3.1415927F / 180.0F) * (float) var18 * 0.5F));
							this.v *= 0.6D;
							this.x *= 0.6D;
							this.d(false);
						}

						if (var1 instanceof EntityPlayer && var1.G) {
							((EntityPlayer) var1).a.a((Packet) (new PacketPlayOutEntityVelocity(var1)));
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
							this.b((class_my) class_mt.F);
						}

						this.p(var1);
						if (var1 instanceof EntityLiving) {
							EnchantmentManager.a((EntityLiving) ((EntityLiving) var1), (Entity) this);
						}

						EnchantmentManager.b((EntityLiving) this, (Entity) var1);
						ItemStack var15 = this.bA();
						Object var16 = var1;
						if (var1 instanceof class_up) {
							class_uo var17 = ((class_up) var1).a;
							if (var17 instanceof EntityLiving) {
								var16 = (EntityLiving) var17;
							}
						}

						if (var15 != null && var16 instanceof EntityLiving) {
							var15.a((EntityLiving) var16, this);
							if (var15.count <= 0) {
								this.a((EnumUsedHand) EnumUsedHand.MAIN_HAND, (ItemStack) null);
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

	public void J() {
		super.J();
		this.bq.b(this);
		if (this.br != null) {
			this.br.b(this);
		}

	}

	public boolean aj() {
		return !this.bD && super.aj();
	}

	public GameProfile cf() {
		return this.bO;
	}

	public EntityHuman.EnumBedResult trySleepOnBed(BlockPosition var1) {
		if (!this.o.isClientSide) {
			if (this.isSleeping() || !this.ai()) {
				return EntityHuman.EnumBedResult.OTHER_PROBLEM;
			}

			if (!this.o.worldProvider.d()) {
				return EntityHuman.EnumBedResult.NOT_POSSIBLE_HERE;
			}

			if (this.o.x()) {
				return EntityHuman.EnumBedResult.NOT_POSSIBLE_NOW;
			}

			if (Math.abs(this.s - (double) var1.getX()) > 3.0D || Math.abs(this.t - (double) var1.getY()) > 2.0D || Math.abs(this.u - (double) var1.getZ()) > 3.0D) {
				return EntityHuman.EnumBedResult.TOO_FAR_AWAY;
			}

			double var2 = 8.0D;
			double var4 = 5.0D;
			List var6 = this.o.getEntities(class_wi.class, new AxisAlignedBB((double) var1.getX() - var2, (double) var1.getY() - var4, (double) var1.getZ() - var2, (double) var1.getX() + var2, (double) var1.getY() + var4, (double) var1.getZ() + var2));
			if (!var6.isEmpty()) {
				return EntityHuman.EnumBedResult.NOT_SAFE;
			}
		}

		if (this.aw()) {
			this.a((Entity) null);
		}

		this.a(0.2F, 0.2F);
		if (this.o.e(var1)) {
			EnumDirection var7 = (EnumDirection) this.o.getType(var1).get(BlockDirectional.FACING);
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
			this.b((double) ((float) var1.getX() + var3), (double) ((float) var1.getY() + 0.6875F), (double) ((float) var1.getZ() + var8));
		} else {
			this.b((double) ((float) var1.getX() + 0.5F), (double) ((float) var1.getY() + 0.6875F), (double) ((float) var1.getZ() + 0.5F));
		}

		this.bD = true;
		this.d = 0;
		this.bedPosition = var1;
		this.v = this.x = this.motY = 0.0D;
		if (!this.o.isClientSide) {
			this.o.e();
		}

		return EntityHuman.EnumBedResult.OK;
	}

	private void a(EnumDirection var1) {
		this.bF = 0.0F;
		this.bG = 0.0F;
		switch (EntityHuman.SyntheticClass_1.a[var1.ordinal()]) {
			case 1:
				this.bG = -1.8F;
				break;
			case 2:
				this.bG = 1.8F;
				break;
			case 3:
				this.bF = 1.8F;
				break;
			case 4:
				this.bF = -1.8F;
		}

	}

	public void a(boolean var1, boolean var2, boolean var3) {
		this.a(0.6F, 1.8F);
		IBlockData var4 = this.o.getType(this.bedPosition);
		if (this.bedPosition != null && var4.getBlock() == Blocks.BED) {
			this.o.setTypeAndData((BlockPosition) this.bedPosition, (IBlockData) var4.set(BlockBed.OCCUPIED, Boolean.valueOf(false)), 4);
			BlockPosition var5 = BlockBed.a((World) this.o, (BlockPosition) this.bedPosition, 0);
			if (var5 == null) {
				var5 = this.bedPosition.up();
			}

			this.b((double) ((float) var5.getX() + 0.5F), (double) ((float) var5.getY() + 0.1F), (double) ((float) var5.getZ() + 0.5F));
		}

		this.bD = false;
		if (!this.o.isClientSide && var2) {
			this.o.e();
		}

		this.d = var1 ? 0 : 100;
		if (var3) {
			this.a(this.bedPosition, false);
		}

	}

	private boolean p() {
		return this.o.getType(this.bedPosition).getBlock() == Blocks.BED;
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
			return BlockBed.a((World) var0, (BlockPosition) var1, 0);
		}
	}

	public boolean isSleeping() {
		return this.bD;
	}

	public boolean ch() {
		return this.bD && this.d >= 100;
	}

	public void b(IChatBaseComponent var1) {
	}

	public BlockPosition cj() {
		return this.e;
	}

	public boolean ck() {
		return this.f;
	}

	public void a(BlockPosition var1, boolean var2) {
		if (var1 != null) {
			this.e = var1;
			this.f = var2;
		} else {
			this.e = null;
			this.f = false;
		}

	}

	public void b(class_my var1) {
		this.a(var1, 1);
	}

	public void a(class_my var1, int var2) {
	}

	public void a(class_my var1) {
	}

	public void bG() {
		super.bG();
		this.b(StatisticList.u);
		if (this.ay()) {
			this.a(0.8F);
		} else {
			this.a(0.2F);
		}

	}

	public void g(float var1, float var2) {
		double var3 = this.s;
		double var5 = this.t;
		double var7 = this.u;
		if (this.bH.flying && this.m == null) {
			double var9 = this.motY;
			float var11 = this.aP;
			this.aP = this.bH.getFlySpeed() * (float) (this.ay() ? 2 : 1);
			super.g(var1, var2);
			this.motY = var9 * 0.6D;
			this.aP = var11;
		} else {
			super.g(var1, var2);
		}

		this.k(this.s - var3, this.t - var5, this.u - var7);
	}

	public float bJ() {
		return (float) this.a((class_qk) class_wl.d).e();
	}

	public void k(double var1, double var3, double var5) {
		if (this.m == null) {
			int var7;
			if (this.a((Material) Material.WATER)) {
				var7 = Math.round(MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
				if (var7 > 0) {
					this.a(StatisticList.p, var7);
					this.a(0.015F * (float) var7 * 0.01F);
				}
			} else if (this.V()) {
				var7 = Math.round(MathHelper.sqrt(var1 * var1 + var5 * var5) * 100.0F);
				if (var7 > 0) {
					this.a(StatisticList.l, var7);
					this.a(0.015F * (float) var7 * 0.01F);
				}
			} else if (this.k_()) {
				if (var3 > 0.0D) {
					this.a(StatisticList.n, (int) Math.round(var3 * 100.0D));
				}
			} else if (this.C) {
				var7 = Math.round(MathHelper.sqrt(var1 * var1 + var5 * var5) * 100.0F);
				if (var7 > 0) {
					this.a(StatisticList.i, var7);
					if (this.ay()) {
						this.a(StatisticList.k, var7);
						this.a(0.099999994F * (float) var7 * 0.01F);
					} else {
						if (this.ax()) {
							this.a(StatisticList.j, var7);
						}

						this.a(0.01F * (float) var7 * 0.01F);
					}
				}
			} else {
				var7 = Math.round(MathHelper.sqrt(var1 * var1 + var5 * var5) * 100.0F);
				if (var7 > 25) {
					this.a(StatisticList.o, var7);
				}
			}

		}
	}

	private void l(double var1, double var3, double var5) {
		if (this.m != null) {
			int var7 = Math.round(MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
			if (var7 > 0) {
				if (this.m instanceof class_vn) {
					this.a(StatisticList.q, var7);
					if (this.g == null) {
						this.g = new BlockPosition(this);
					} else if (this.g.distanceSquared((double) MathHelper.floor(this.s), (double) MathHelper.floor(this.t), (double) MathHelper.floor(this.u)) >= 1000000.0D) {
						this.b((class_my) class_mt.q);
					}
				} else if (this.m instanceof class_vk) {
					this.a(StatisticList.r, var7);
				} else if (this.m instanceof class_ud) {
					this.a(StatisticList.s, var7);
				} else if (this.m instanceof class_tz) {
					this.a(StatisticList.t, var7);
				}
			}
		}

	}

	public void e(float var1, float var2) {
		if (!this.bH.mayfly) {
			if (var1 >= 2.0F) {
				this.a(StatisticList.m, (int) Math.round((double) var1 * 100.0D));
			}

			super.e(var1, var2);
		}
	}

	protected void X() {
		if (!this.v()) {
			super.X();
		}

	}

	protected String k(int var1) {
		return var1 > 4 ? "game.player.hurt.fall.big" : "game.player.hurt.fall.small";
	}

	public void a(EntityLiving var1) {
		if (var1 instanceof class_wd) {
			this.b((class_my) class_mt.s);
		}

		class_pt.class_a_in_class_pt var2 = (class_pt.class_a_in_class_pt) class_pt.a.get(Integer.valueOf(class_pt.a(var1)));
		if (var2 != null) {
			this.b(var2.d);
		}

	}

	public void aC() {
		if (!this.bH.flying) {
			super.aC();
		}

	}

	public void o(int var1) {
		this.n(var1);
		int var2 = Integer.MAX_VALUE - this.bJ;
		if (var1 > var2) {
			var1 = var2;
		}

		this.bK += (float) var1 / (float) this.cm();

		for (this.bJ += var1; this.bK >= 1.0F; this.bK /= (float) this.cm()) {
			this.bK = (this.bK - 1.0F) * (float) this.cm();
			this.a(1);
		}

	}

	public int cl() {
		return this.h;
	}

	public void b(int var1) {
		this.bI -= var1;
		if (this.bI < 0) {
			this.bI = 0;
			this.bK = 0.0F;
			this.bJ = 0;
		}

		this.h = this.V.nextInt();
	}

	public void a(int var1) {
		this.bI += var1;
		if (this.bI < 0) {
			this.bI = 0;
			this.bK = 0.0F;
			this.bJ = 0;
		}

		if (var1 > 0 && this.bI % 5 == 0 && (float) this.i < (float) this.W - 100.0F) {
			float var2 = this.bI > 30 ? 1.0F : (float) this.bI / 30.0F;
			this.o.a((Entity) this, "random.levelup", var2 * 0.75F, 1.0F);
			this.i = this.W;
		}

	}

	public int cm() {
		return this.bI >= 30 ? 112 + (this.bI - 30) * 9 : (this.bI >= 15 ? 37 + (this.bI - 15) * 5 : 7 + this.bI * 2);
	}

	public void a(float var1) {
		if (!this.bH.invulnerable) {
			if (!this.o.isClientSide) {
				this.bs.a(var1);
			}

		}
	}

	public class_xx cn() {
		return this.bs;
	}

	public boolean j(boolean var1) {
		return (var1 || this.bs.c()) && !this.bH.invulnerable;
	}

	public boolean co() {
		return this.bo() > 0.0F && this.bo() < this.bv();
	}

	public boolean cp() {
		return this.bH.mayBuild;
	}

	public boolean a(BlockPosition var1, EnumDirection var2, ItemStack var3) {
		if (this.bH.mayBuild) {
			return true;
		} else if (var3 == null) {
			return false;
		} else {
			BlockPosition var4 = var1.shift(var2.opposite());
			Block var5 = this.o.getType(var4).getBlock();
			return var3.d(var5) || var3.x();
		}
	}

	protected int b(EntityHuman var1) {
		if (this.o.R().b("keepInventory")) {
			return 0;
		} else {
			int var2 = this.bI * 7;
			return var2 > 100 ? 100 : var2;
		}
	}

	protected boolean bc() {
		return true;
	}

	public void a(EntityHuman var1, boolean var2) {
		if (var2) {
			this.bp.a(var1.bp);
			this.i(var1.bo());
			this.bs = var1.bs;
			this.bI = var1.bI;
			this.bJ = var1.bJ;
			this.bK = var1.bK;
			this.m(var1.cb());
			this.an = var1.an;
			this.ao = var1.ao;
			this.ap = var1.ap;
		} else if (this.o.R().b("keepInventory")) {
			this.bp.a(var1.bp);
			this.bI = var1.bI;
			this.bJ = var1.bJ;
			this.bK = var1.bK;
			this.m(var1.cb());
		}

		this.h = var1.h;
		this.c = var1.c;
		this.H().b(bn, Byte.valueOf(var1.H().a(bn)));
	}

	protected boolean s_() {
		return !this.bH.flying;
	}

	public void t() {
	}

	public void a(WorldSettings.EnumGameMode var1) {
	}

	public String getName() {
		return this.bO.getName();
	}

	public class_yu cq() {
		return this.c;
	}

	public ItemStack a(class_pw var1) {
		return var1 == class_pw.a ? this.bp.h() : (var1 == class_pw.b ? this.bp.c[0] : (var1.a() == class_pw.class_a_in_class_pw.b ? this.bp.b[var1.b()] : null));
	}

	public void a(class_pw var1, ItemStack var2) {
		if (var1 == class_pw.a) {
			this.bp.a[this.bp.d] = var2;
		} else if (var1 == class_pw.b) {
			this.bp.c[0] = var2;
		} else if (var1.a() == class_pw.class_a_in_class_pw.b) {
			this.bp.b[var1.b()] = var2;
		}

	}

	public Iterable as() {
		return Lists.newArrayList((Object[]) (new ItemStack[] { this.bA(), this.bB() }));
	}

	public Iterable at() {
		return Arrays.asList(this.bp.b);
	}

	public abstract boolean v();

	public boolean aN() {
		return !this.bH.flying;
	}

	public class_awn cr() {
		return this.o.aa();
	}

	public class_awp bP() {
		return this.cr().h(this.getName());
	}

	public IChatBaseComponent getScoreboardDisplayName() {
		ChatComponentText var1 = new ChatComponentText(class_awk.a(this.bP(), this.getName()));
		var1.b().a(new class_et(class_et.class_a_in_class_et.d, "/msg " + this.getName() + " "));
		var1.b().a(this.aS());
		var1.b().a(this.getName());
		return var1;
	}

	public float aU() {
		float var1 = 1.62F;
		if (this.isSleeping()) {
			var1 = 0.2F;
		}

		if (this.ax()) {
			var1 -= 0.08F;
		}

		return var1;
	}

	public void m(float var1) {
		if (var1 < 0.0F) {
			var1 = 0.0F;
		}

		this.H().b(a, Float.valueOf(var1));
	}

	public float bO() {
		return this.H().d(a);
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
			ItemStack var2 = this.bA();
			return var2 != null && var2.hasDisplayName() ? var2.getDisplayName().equals(var1.getName()) : false;
		}
	}

	public boolean u_() {
		return MinecraftServer.N().d[0].R().b("sendCommandFeedback");
	}

	public boolean c(int var1, ItemStack var2) {
		if (var1 >= 0 && var1 < this.bp.a.length) {
			this.bp.setItem(var1, var2);
			return true;
		} else {
			class_pw var3;
			if (var1 == 100 + class_pw.f.b()) {
				var3 = class_pw.f;
			} else if (var1 == 100 + class_pw.e.b()) {
				var3 = class_pw.e;
			} else if (var1 == 100 + class_pw.d.b()) {
				var3 = class_pw.d;
			} else if (var1 == 100 + class_pw.c.b()) {
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
				if (var4 >= 0 && var4 < this.c.getSize()) {
					this.c.setItem(var4, var2);
					return true;
				} else {
					return false;
				}
			} else {
				if (var2 != null && var2.getItem() != null) {
					if (var2.getItem() instanceof class_za) {
						if (class_qb.c(var2) != var3) {
							return false;
						}
					} else if (var3 != class_pw.f || var2.getItem() != Items.ca && !(var2.getItem() instanceof ItemBlock)) {
						return false;
					}
				}

				this.bp.setItem(var3.b() + this.bp.a.length, var2);
				return true;
			}
		}
	}

	public EnumMainHandOption bR() {
		EnumMainHandOption pz;
		if (this.ac.a(bo) == 0) {
			pz = EnumMainHandOption.LEFT;
			return pz;
		}
		pz = EnumMainHandOption.RIGHT;
		return pz;
	}

	public void a(EnumMainHandOption pz) {
		this.ac.b(bo, (Object) Byte.valueOf((byte) (pz == EnumMainHandOption.LEFT ? 0 : 1)));
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
