package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_adz;
import net.minecraft.server.class_aeb;
import net.minecraft.server.class_aeh;
import net.minecraft.server.WorldSettings;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahz;
import net.minecraft.server.class_aia;
import net.minecraft.server.class_alv;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntitySign;
import net.minecraft.server.Chunk;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awl;
import net.minecraft.server.class_awp;
import net.minecraft.server.class_awt;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_e;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketPlayOutAnimation;
import net.minecraft.server.PacketPlayOutChat;
import net.minecraft.server.PacketPlayOutCloseWindow;
import net.minecraft.server.PacketPlayOutOpenWindow;
import net.minecraft.server.PacketPlayOutWindowItems;
import net.minecraft.server.PacketPlayOutWindowData;
import net.minecraft.server.PacketPlayOutSetSlot;
import net.minecraft.server.PacketPlayOutCustomPayload;
import net.minecraft.server.PacketPlayOutEntityStatus;
import net.minecraft.server.PacketPlayOutGameStateChange;
import net.minecraft.server.PacketPlayOutMapChunk;
import net.minecraft.server.PacketPlayOutMapChunkBulk;
import net.minecraft.server.PacketPlayOutNamedSoundEffect;
import net.minecraft.server.PacketPlayOutOpenSignEditor;
import net.minecraft.server.PacketPlayOutAbilities;
import net.minecraft.server.PacketPlayOutCombatEvent;
import net.minecraft.server.PacketPlayOutBed;
import net.minecraft.server.PacketPlayOutEntityDestroy;
import net.minecraft.server.PacketPlayOutRemoveEntityEffect;
import net.minecraft.server.PacketPlayOutResourcePackSend;
import net.minecraft.server.PacketPlayOutCamera;
import net.minecraft.server.PacketPlayOutAttachEntity;
import net.minecraft.server.PacketPlayOutExperience;
import net.minecraft.server.PacketPlayOutUpdateHealth;
import net.minecraft.server.PacketPlayOutEntityEffect;
import net.minecraft.server.PacketPlayInSettings;
import net.minecraft.server.WorldServer;
import net.minecraft.server.PlayerInteractManager;
import net.minecraft.server.PlayerConnection;
import net.minecraft.server.class_mb;
import net.minecraft.server.class_ms;
import net.minecraft.server.class_mt;
import net.minecraft.server.ServerStatisticManager;
import net.minecraft.server.class_my;
import net.minecraft.server.StatisticList;
import net.minecraft.server.class_ne;
import net.minecraft.server.MathHelper;
import net.minecraft.server.IInventory;
import net.minecraft.server.ITileEntityContainer;
import net.minecraft.server.ChestLock;
import net.minecraft.server.ITileInventory;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pd;
import net.minecraft.server.class_pl;
import net.minecraft.server.Entity;
import net.minecraft.server.class_pt;
import net.minecraft.server.EnumMainHandOption;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_tz;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.class_xd;
import net.minecraft.server.Container;
import net.minecraft.server.class_ye;
import net.minecraft.server.class_yf;
import net.minecraft.server.class_yo;
import net.minecraft.server.class_yr;
import net.minecraft.server.class_ys;
import net.minecraft.server.class_yw;
import net.minecraft.server.class_zt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityPlayer extends EntityHuman implements class_ye {
	private static final Logger bO = LogManager.getLogger();
	private String bP = "en_US";
	public PlayerConnection playerConnection;
	public final MinecraftServer b;
	public final PlayerInteractManager playerInteractManager;
	public double d;
	public double e;
	public final List f = Lists.newLinkedList();
	private final List bQ = Lists.newLinkedList();
	private final ServerStatisticManager bR;
	private float bS = Float.MIN_VALUE;
	private float bT = -1.0E8F;
	private int bU = -99999999;
	private boolean bV = true;
	private int bW = -99999999;
	private int bX = 60;
	private EntityHuman.ChatMode bY;
	private boolean bZ = true;
	private long ca = System.currentTimeMillis();
	private Entity cb = null;
	private int cc;
	public boolean g;
	public int h;
	public boolean i;

	public EntityPlayer(MinecraftServer var1, WorldServer var2, GameProfile var3, PlayerInteractManager var4) {
		super(var2, var3);
		var4.player = this;
		this.playerInteractManager = var4;
		BlockPosition var5 = var2.N();
		if (!var2.worldProvider.m() && var2.Q().r() != WorldSettings.EnumGameMode.ADVENTURE) {
			int var6 = Math.max(5, var1.aw() - 6);
			int var7 = MathHelper.floor(var2.ag().b((double) var5.getX(), (double) var5.getZ()));
			if (var7 < var6) {
				var6 = var7;
			}

			if (var7 <= 1) {
				var6 = 1;
			}

			var5 = var2.r(var5.add(this.random.nextInt(var6 * 2) - var6, 0, this.random.nextInt(var6 * 2) - var6));
		}

		this.b = var1;
		this.bR = var1.getPlayerList().a((EntityHuman) this);
		this.S = 0.0F;
		this.a(var5, 0.0F, 0.0F);

		while (!var2.a((Entity) this, (AxisAlignedBB) this.aT()).isEmpty() && this.t < 255.0D) {
			this.b(this.s, this.t + 1.0D, this.u);
		}

	}

	public void read(NBTTagCompound var1) {
		super.read(var1);
		if (var1.hasOfType("playerGameType", 99)) {
			if (MinecraftServer.N().ax()) {
				this.playerInteractManager.setGameMode(MinecraftServer.N().m());
			} else {
				this.playerInteractManager.setGameMode(WorldSettings.EnumGameMode.getById(var1.getInt("playerGameType")));
			}
		}

	}

	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("playerGameType", this.playerInteractManager.getGameMode().getId());
	}

	public void a(int var1) {
		super.a(var1);
		this.bW = -1;
	}

	public void b(int var1) {
		super.b(var1);
		this.bW = -1;
	}

	public void g_() {
		this.br.a((class_ye) this);
	}

	public void h_() {
		super.h_();
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutCombatEvent(this.bt(), PacketPlayOutCombatEvent.class_a_in_class_gy.a)));
	}

	public void j() {
		super.j();
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutCombatEvent(this.bt(), PacketPlayOutCombatEvent.class_a_in_class_gy.b)));
	}

	public void t_() {
		this.playerInteractManager.a();
		--this.bX;
		if (this.Z > 0) {
			--this.Z;
		}

		this.br.b();
		if (!this.o.isClientSide && !this.br.a((EntityHuman) this)) {
			this.n();
			this.br = this.bq;
		}

		while (!this.bQ.isEmpty()) {
			int var1 = Math.min(this.bQ.size(), Integer.MAX_VALUE);
			int[] var2 = new int[var1];
			Iterator var3 = this.bQ.iterator();
			int var4 = 0;

			while (var3.hasNext() && var4 < var1) {
				var2[var4++] = ((Integer) var3.next()).intValue();
				var3.remove();
			}

			this.playerConnection.sendPacket((Packet) (new PacketPlayOutEntityDestroy(var2)));
		}

		if (!this.f.isEmpty()) {
			ArrayList var6 = Lists.newArrayList();
			Iterator var8 = this.f.iterator();
			ArrayList var9 = Lists.newArrayList();

			Chunk var5;
			while (var8.hasNext() && var6.size() < 10) {
				class_aeh var10 = (class_aeh) var8.next();
				if (var10 != null) {
					if (this.o.e(new BlockPosition(var10.a << 4, 0, var10.b << 4))) {
						var5 = this.o.getChunkAt(var10.a, var10.b);
						if (var5.i()) {
							var6.add(var5);
							var9.addAll(((WorldServer) this.o).a(var10.a * 16, 0, var10.b * 16, var10.a * 16 + 16, 256, var10.b * 16 + 16));
							var8.remove();
						}
					}
				} else {
					var8.remove();
				}
			}

			if (!var6.isEmpty()) {
				if (var6.size() == 1) {
					this.playerConnection.sendPacket((Packet) (new PacketPlayOutMapChunk((Chunk) var6.get(0), true, '\uffff')));
				} else {
					this.playerConnection.sendPacket((Packet) (new PacketPlayOutMapChunkBulk(var6)));
				}

				Iterator var11 = var9.iterator();

				while (var11.hasNext()) {
					TileEntity var12 = (TileEntity) var11.next();
					this.a(var12);
				}

				var11 = var6.iterator();

				while (var11.hasNext()) {
					var5 = (Chunk) var11.next();
					this.u().t().a(this, var5);
				}
			}
		}

		Entity var7 = this.C();
		if (var7 != this) {
			if (!var7.isAlive()) {
				this.e(this);
			} else {
				this.a(var7.s, var7.t, var7.u, var7.y, var7.z);
				this.b.getPlayerList().d(this);
				if (this.ax()) {
					this.e(this);
				}
			}
		}

	}

	public void l() {
		try {
			super.t_();

			for (int var1 = 0; var1 < this.inventory.getSize(); ++var1) {
				ItemStack var6 = this.inventory.getItem(var1);
				if (var6 != null && var6.getItem().f()) {
					Packet var8 = ((class_zt) var6.getItem()).a(var6, this.o, this);
					if (var8 != null) {
						this.playerConnection.sendPacket(var8);
					}
				}
			}

			if (this.getHealth() != this.bT || this.bU != this.foodData.a() || this.foodData.e() == 0.0F != this.bV) {
				this.playerConnection.sendPacket((Packet) (new PacketPlayOutUpdateHealth(this.getHealth(), this.foodData.a(), this.foodData.e())));
				this.bT = this.getHealth();
				this.bU = this.foodData.a();
				this.bV = this.foodData.e() == 0.0F;
			}

			if (this.getHealth() + this.getAbsorptionHearts() != this.bS) {
				this.bS = this.getHealth() + this.getAbsorptionHearts();
				Collection var5 = this.cr().a(class_awt.g);
				Iterator var7 = var5.iterator();

				while (var7.hasNext()) {
					class_awj var9 = (class_awj) var7.next();
					this.cr().c(this.getName(), var9).a(Arrays.asList(new EntityHuman[] { this }));
				}
			}

			if (this.expTotal != this.bW) {
				this.bW = this.expTotal;
				this.playerConnection.sendPacket((Packet) (new PacketPlayOutExperience(this.exp, this.expTotal, this.expLevel)));
			}

			if (this.W % 20 * 5 == 0 && !this.A().a((class_ms) class_mt.L)) {
				this.i_();
			}

		} catch (Throwable var4) {
			class_b var2 = class_b.a(var4, "Ticking player");
			class_c var3 = var2.a("Player being ticked");
			this.a((class_c) var3);
			throw new class_e(var2);
		}
	}

	protected void i_() {
		BiomeBase var1 = this.o.b(new BlockPosition(MathHelper.floor(this.s), 0, MathHelper.floor(this.u)));
		String var2 = var1.ah;
		class_ne var3 = (class_ne) this.A().b((class_my) class_mt.L);
		if (var3 == null) {
			var3 = (class_ne) this.A().a(class_mt.L, new class_ne());
		}

		var3.add(var2);
		if (this.A().b(class_mt.L) && var3.size() >= BiomeBase.n.size()) {
			HashSet var4 = Sets.newHashSet((Iterable) BiomeBase.n);
			Iterator var5 = var3.iterator();

			while (var5.hasNext()) {
				String var6 = (String) var5.next();
				Iterator var7 = var4.iterator();

				while (var7.hasNext()) {
					BiomeBase var8 = (BiomeBase) var7.next();
					if (var8.ah.equals(var6)) {
						var7.remove();
					}
				}

				if (var4.isEmpty()) {
					break;
				}
			}

			if (var4.isEmpty()) {
				this.b((class_my) class_mt.L);
			}
		}

	}

	public void a(class_pc var1) {
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutCombatEvent(this.bt(), PacketPlayOutCombatEvent.class_a_in_class_gy.c)));
		if (this.o.R().b("showDeathMessages")) {
			class_awp var2 = this.bP();
			if (var2 != null && var2.j() != class_awp.class_a_in_class_awp.a) {
				if (var2.j() == class_awp.class_a_in_class_awp.c) {
					this.b.getPlayerList().a((EntityHuman) this, (IChatBaseComponent) this.bt().b());
				} else if (var2.j() == class_awp.class_a_in_class_awp.d) {
					this.b.getPlayerList().b((EntityHuman) this, (IChatBaseComponent) this.bt().b());
				}
			} else {
				this.b.getPlayerList().a(this.bt().b());
			}
		}

		if (!this.o.R().b("keepInventory")) {
			this.inventory.n();
		}

		Collection var6 = this.o.aa().a(class_awt.d);
		Iterator var3 = var6.iterator();

		while (var3.hasNext()) {
			class_awj var4 = (class_awj) var3.next();
			class_awl var5 = this.cr().c(this.getName(), var4);
			var5.a();
		}

		EntityLiving var7 = this.bu();
		if (var7 != null) {
			class_pt.class_a_in_class_pt var8 = (class_pt.class_a_in_class_pt) class_pt.a.get(Integer.valueOf(class_pt.a(var7)));
			if (var8 != null) {
				this.b((class_my) var8.e);
			}

			var7.b(this, this.aZ);
		}

		this.b((class_my) StatisticList.y);
		this.a(StatisticList.h);
		this.bt().g();
	}

	public boolean damageEntity(class_pc var1, float var2) {
		if (this.b((class_pc) var1)) {
			return false;
		} else {
			boolean var3 = this.b.ae() && this.ct() && "fall".equals(var1.p);
			if (!var3 && this.bX > 0 && var1 != class_pc.j) {
				return false;
			} else {
				if (var1 instanceof class_pd) {
					Entity var4 = var1.j();
					if (var4 instanceof EntityHuman && !this.a((EntityHuman) var4)) {
						return false;
					}

					if (var4 instanceof class_xd) {
						class_xd var5 = (class_xd) var4;
						if (var5.e instanceof EntityHuman && !this.a((EntityHuman) var5.e)) {
							return false;
						}
					}
				}

				return super.damageEntity(var1, var2);
			}
		}
	}

	public boolean a(EntityHuman var1) {
		return !this.ct() ? false : super.a(var1);
	}

	private boolean ct() {
		return this.b.aj();
	}

	public void c(int var1) {
		if (this.am == 1 && var1 == 1) {
			this.b((class_my) class_mt.D);
			this.o.e((Entity) this);
			this.i = true;
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutGameStateChange(4, 0.0F)));
		} else {
			if (this.am == 0 && var1 == 1) {
				this.b((class_my) class_mt.C);
				BlockPosition var2 = this.b.getWorldServer(var1).n();
				if (var2 != null) {
					this.playerConnection.a((double) var2.getX(), (double) var2.getY(), (double) var2.getZ(), 0.0F, 0.0F);
				}

				var1 = 1;
			} else {
				this.b((class_my) class_mt.y);
			}

			this.b.getPlayerList().a(this, var1);
			this.bW = -1;
			this.bT = -1.0F;
			this.bU = -1;
		}

	}

	public boolean a(EntityPlayer var1) {
		return var1.isSpectator() ? this.C() == this : (this.isSpectator() ? false : super.a((EntityPlayer) var1));
	}

	private void a(TileEntity var1) {
		if (var1 != null) {
			Packet var2 = var1.getUpdatePacket();
			if (var2 != null) {
				this.playerConnection.sendPacket(var2);
			}
		}

	}

	public void a(Entity var1, int var2) {
		super.a(var1, var2);
		this.br.b();
	}

	public EntityHuman.EnumBedResult trySleepOnBed(BlockPosition var1) {
		EntityHuman.EnumBedResult var2 = super.trySleepOnBed(var1);
		if (var2 == EntityHuman.EnumBedResult.OK) {
			PacketPlayOutBed var3 = new PacketPlayOutBed(this, var1);
			this.u().t().a((Entity) this, (Packet) var3);
			this.playerConnection.a(this.s, this.t, this.u, this.y, this.z);
			this.playerConnection.sendPacket((Packet) var3);
		}

		return var2;
	}

	public void a(boolean var1, boolean var2, boolean var3) {
		if (this.isSleeping()) {
			this.u().t().b(this, new PacketPlayOutAnimation(this, 2));
		}

		super.a(var1, var2, var3);
		if (this.playerConnection != null) {
			this.playerConnection.a(this.s, this.t, this.u, this.y, this.z);
		}

	}

	public void a(Entity var1) {
		Entity var2 = this.vehicle;
		super.a((Entity) var1);
		if (var1 != var2) {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutAttachEntity(0, this, this.vehicle)));
			this.playerConnection.a(this.s, this.t, this.u, this.y, this.z);
		}

	}

	protected void a(double var1, boolean var3, Block var4, BlockPosition var5) {
	}

	public void a(double var1, boolean var3) {
		int var4 = MathHelper.floor(this.s);
		int var5 = MathHelper.floor(this.t - 0.20000000298023224D);
		int var6 = MathHelper.floor(this.u);
		BlockPosition var7 = new BlockPosition(var4, var5, var6);
		Block var8 = this.o.getType(var7).getBlock();
		if (var8.getMaterial() == Material.AIR) {
			Block var9 = this.o.getType(var7.down()).getBlock();
			if (var9 instanceof class_ahz || var9 instanceof class_alv || var9 instanceof class_aia) {
				var7 = var7.down();
				var8 = this.o.getType(var7).getBlock();
			}
		}

		super.a(var1, var3, var8, var7);
	}

	public void a(TileEntitySign var1) {
		var1.a((EntityHuman) this);
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutOpenSignEditor(var1.getPosition())));
	}

	private void cu() {
		this.cc = this.cc % 100 + 1;
	}

	public void a(ITileEntityContainer var1) {
		this.cu();
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutOpenWindow(this.cc, var1.getContainerName(), var1.getScoreboardDisplayName())));
		this.br = var1.createContainer(this.inventory, this);
		this.br.d = this.cc;
		this.br.a((class_ye) this);
	}

	public void openContainer(IInventory var1) {
		if (this.br != this.bq) {
			this.n();
		}

		if (var1 instanceof ITileInventory) {
			ITileInventory var2 = (ITileInventory) var1;
			if (var2.isLocked() && !this.a((ChestLock) var2.getChestLock()) && !this.isSpectator()) {
				this.playerConnection.sendPacket((Packet) (new PacketPlayOutChat(new ChatMessage("container.isLocked", new Object[] { var1.getScoreboardDisplayName() }), (byte) 2)));
				this.playerConnection.sendPacket((Packet) (new PacketPlayOutNamedSoundEffect("random.door_close", this.s, this.t, this.u, 1.0F, 1.0F)));
				return;
			}
		}

		this.cu();
		if (var1 instanceof ITileEntityContainer) {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutOpenWindow(this.cc, ((ITileEntityContainer) var1).getContainerName(), var1.getScoreboardDisplayName(), var1.getSize())));
			this.br = ((ITileEntityContainer) var1).createContainer(this.inventory, this);
		} else {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutOpenWindow(this.cc, "minecraft:container", var1.getScoreboardDisplayName(), var1.getSize())));
			this.br = new class_yf(this.inventory, var1, this);
		}

		this.br.d = this.cc;
		this.br.a((class_ye) this);
	}

	public void a(class_adz var1) {
		this.cu();
		this.br = new class_ys(this.inventory, var1, this.o);
		this.br.d = this.cc;
		this.br.a((class_ye) this);
		class_yr var2 = ((class_ys) this.br).e();
		IChatBaseComponent var3 = var1.getScoreboardDisplayName();
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutOpenWindow(this.cc, "minecraft:villager", var3, var2.getSize())));
		class_aeb var4 = var1.a_((EntityHuman) this);
		if (var4 != null) {
			PacketDataSerializer var5 = new PacketDataSerializer(Unpooled.buffer());
			var5.writeInt(this.cc);
			var4.a(var5);
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutCustomPayload("MC|TrList", var5)));
		}

	}

	public void a(class_tz var1, IInventory var2) {
		if (this.br != this.bq) {
			this.n();
		}

		this.cu();
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutOpenWindow(this.cc, "EntityHorse", var2.getScoreboardDisplayName(), var2.getSize(), var1.getId())));
		this.br = new class_yo(this.inventory, var2, var1, this);
		this.br.d = this.cc;
		this.br.a((class_ye) this);
	}

	public void a(ItemStack var1) {
		Item var2 = var1.getItem();
		if (var2 == Items.bQ) {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(Unpooled.buffer()))));
		}

	}

	public void a(Container var1, int var2, ItemStack var3) {
		if (!(var1.a(var2) instanceof class_yw)) {
			if (!this.g) {
				this.playerConnection.sendPacket((Packet) (new PacketPlayOutSetSlot(var1.d, var2, var3)));
			}
		}
	}

	public void a(Container var1) {
		this.a(var1, var1.a());
	}

	public void a(Container var1, List var2) {
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutWindowItems(var1.d, var2)));
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutSetSlot(-1, -1, this.inventory.o())));
	}

	public void a(Container var1, int var2, int var3) {
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutWindowData(var1.d, var2, var3)));
	}

	public void a(Container var1, IInventory var2) {
		for (int var3 = 0; var3 < var2.getPropertyCount(); ++var3) {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutWindowData(var1.d, var3, var2.getProperty(var3))));
		}

	}

	public void n() {
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutCloseWindow(this.br.d)));
		this.p();
	}

	public void o() {
		if (!this.g) {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutSetSlot(-1, -1, this.inventory.o())));
		}
	}

	public void p() {
		this.br.b((EntityHuman) this);
		this.br = this.bq;
	}

	public void a(float var1, float var2, boolean var3, boolean var4) {
		if (this.vehicle != null) {
			if (var1 >= -1.0F && var1 <= 1.0F) {
				this.bc = var1;
			}

			if (var2 >= -1.0F && var2 <= 1.0F) {
				this.bd = var2;
			}

			this.bb = var3;
			this.c(var4);
		}

	}

	public void a(class_my var1, int var2) {
		if (var1 != null) {
			this.bR.b(this, var1, var2);
			Iterator var3 = this.cr().a(var1.k()).iterator();

			while (var3.hasNext()) {
				class_awj var4 = (class_awj) var3.next();
				this.cr().c(this.getName(), var4).a(var2);
			}

			if (this.bR.e()) {
				this.bR.a(this);
			}

		}
	}

	public void a(class_my var1) {
		if (var1 != null) {
			this.bR.a(this, var1, 0);
			Iterator var2 = this.cr().a(var1.k()).iterator();

			while (var2.hasNext()) {
				class_awj var3 = (class_awj) var2.next();
				this.cr().c(this.getName(), var3).c(0);
			}

			if (this.bR.e()) {
				this.bR.a(this);
			}

		}
	}

	public void q() {
		if (this.passenger != null) {
			this.passenger.a((Entity) this);
		}

		if (this.sleeping) {
			this.a(true, false, false);
		}

	}

	public void r() {
		this.bT = -1.0E8F;
	}

	public void b(IChatBaseComponent var1) {
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutChat(var1)));
	}

	protected void s() {
		if (this.bl != null && this.bS()) {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutEntityStatus(this, (byte) 9)));
			super.s();
		}

	}

	public void a(EntityHuman var1, boolean var2) {
		super.a(var1, var2);
		this.bW = -1;
		this.bT = -1.0F;
		this.bU = -1;
		this.bQ.addAll(((EntityPlayer) var1).bQ);
	}

	protected void a(class_pl var1) {
		super.a((class_pl) var1);
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutEntityEffect(this.getId(), var1)));
	}

	protected void a(class_pl var1, boolean var2) {
		super.a((class_pl) var1, var2);
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutEntityEffect(this.getId(), var1)));
	}

	protected void b(class_pl var1) {
		super.b((class_pl) var1);
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutRemoveEntityEffect(this.getId(), var1.a())));
	}

	public void a(double var1, double var3, double var5) {
		this.playerConnection.a(var1, var3, var5, this.y, this.z);
	}

	public void b(Entity var1) {
		this.u().t().b(this, new PacketPlayOutAnimation(var1, 4));
	}

	public void c(Entity var1) {
		this.u().t().b(this, new PacketPlayOutAnimation(var1, 5));
	}

	public void t() {
		if (this.playerConnection != null) {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutAbilities(this.abilities)));
			this.B();
		}
	}

	public WorldServer u() {
		return (WorldServer) this.o;
	}

	public void a(WorldSettings.EnumGameMode var1) {
		this.playerInteractManager.setGameMode(var1);
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutGameStateChange(3, (float) var1.getId())));
		if (var1 == WorldSettings.EnumGameMode.SPECTATOR) {
			this.a((Entity) null);
		} else {
			this.e(this);
		}

		this.t();
		this.bQ();
	}

	public boolean isSpectator() {
		return this.playerInteractManager.getGameMode() == WorldSettings.EnumGameMode.SPECTATOR;
	}

	public void a(IChatBaseComponent var1) {
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutChat(var1)));
	}

	public boolean a(int var1, String var2) {
		if ("seed".equals(var2) && !this.b.ae()) {
			return true;
		} else if (!"tell".equals(var2) && !"help".equals(var2) && !"me".equals(var2) && !"trigger".equals(var2)) {
			if (this.b.getPlayerList().h(this.cf())) {
				class_mb var3 = (class_mb) this.b.getPlayerList().m().b((Object) this.cf());
				return var3 != null ? var3.a() >= var1 : this.b.p() >= var1;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public String w() {
		String var1 = this.playerConnection.networkManager.getAddress().toString();
		var1 = var1.substring(var1.indexOf("/") + 1);
		var1 = var1.substring(0, var1.indexOf(":"));
		return var1;
	}

	public void a(PacketPlayInSettings var1) {
		this.bP = var1.getLocale();
		this.bY = var1.getChatMode();
		this.bZ = var1.getChatColors();
		this.H().update(SKIN_PARTS_DW_ID, Byte.valueOf((byte) var1.getSkinParts()));
		this.H().update(MAIN_HAND_DW_ID, Byte.valueOf((byte) (var1.getMainHand() == EnumMainHandOption.LEFT ? 0 : 1)));
	}

	public EntityHuman.ChatMode y() {
		return this.bY;
	}

	public void a(String var1, String var2) {
		this.playerConnection.sendPacket((Packet) (new PacketPlayOutResourcePackSend(var1, var2)));
	}

	public BlockPosition c() {
		return new BlockPosition(this.s, this.t + 0.5D, this.u);
	}

	public void z() {
		this.ca = MinecraftServer.az();
	}

	public ServerStatisticManager A() {
		return this.bR;
	}

	public void d(Entity var1) {
		if (var1 instanceof EntityHuman) {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutEntityDestroy(new int[] { var1.getId() })));
		} else {
			this.bQ.add(Integer.valueOf(var1.getId()));
		}

	}

	protected void B() {
		if (this.isSpectator()) {
			this.bk();
			this.f(true);
		} else {
			super.B();
		}

		this.u().t().a(this);
	}

	public Entity C() {
		return (Entity) (this.cb == null ? this : this.cb);
	}

	public void e(Entity var1) {
		Entity var2 = this.C();
		this.cb = (Entity) (var1 == null ? this : var1);
		if (var2 != this.cb) {
			this.playerConnection.sendPacket((Packet) (new PacketPlayOutCamera(this.cb)));
			this.a(this.cb.s, this.cb.t, this.cb.u);
		}

	}

	public void f(Entity var1) {
		if (this.playerInteractManager.getGameMode() == WorldSettings.EnumGameMode.SPECTATOR) {
			this.e(var1);
		} else {
			super.f(var1);
		}

	}

	public long D() {
		return this.ca;
	}

	public IChatBaseComponent E() {
		return null;
	}
}
