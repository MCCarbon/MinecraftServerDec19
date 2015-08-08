package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class PlayerList {

	public static final File BANNED_PLAYERS_FILE = new File("banned-players.json");
	public static final File BANNED_IPS_FILE = new File("banned-ips.json");
	public static final File OPS_FILE = new File("ops.json");
	public static final File WHITELIST_FILE = new File("whitelist.json");
	private static final Logger looger = LogManager.getLogger();
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");

	private final MinecraftServer mcserver;
	private final List<EntityPlayer> playerList = Lists.newArrayList();
	private final Map<UUID, EntityPlayer> playerMap = Maps.newHashMap();
	private final GameProfileBanList gameProfileBanList;
	private final IpBanList ipBanList;
	private final OpList opList;
	private final WhiteList whiteList;
	private final Map<UUID, ServerStatisticManager> stats;
	private IPlayerFileData playerDataProvider;
	private boolean hasWhitelist;
	protected int maxPlayers;
	private int viewDistance;
	private WorldSettings.EnumGameMode defaultGameMode;
	private boolean isEveryoneOP;
	private int pingUpdateCounter;

	public PlayerList(MinecraftServer var1) {
		this.gameProfileBanList = new GameProfileBanList(BANNED_PLAYERS_FILE);
		this.ipBanList = new IpBanList(BANNED_IPS_FILE);
		this.opList = new OpList(OPS_FILE);
		this.whiteList = new WhiteList(WHITELIST_FILE);
		this.stats = Maps.newHashMap();
		this.mcserver = var1;
		this.gameProfileBanList.a(false);
		this.ipBanList.a(false);
		this.maxPlayers = 8;
	}

	public void processLogin(NetworkManager networkManager, EntityPlayer player) {
		GameProfile var3 = player.cf();
		class_lv var4 = this.mcserver.aF();
		GameProfile var5 = var4.a(var3.getId());
		String var6 = var5 == null ? var3.getName() : var5.getName();
		var4.a(var3);
		NBTTagCompound var7 = this.a(player);
		player.a((World) this.mcserver.getWorldServer(player.dimension));
		player.playerInteractManager.a((WorldServer) player.world);
		String var8 = "local";
		if (networkManager.getAddress() != null) {
			var8 = networkManager.getAddress().toString();
		}

		looger.info(player.getName() + "[" + var8 + "] logged in with entity id " + player.getId() + " at (" + player.locX + ", " + player.locY + ", " + player.locZ + ")");
		WorldServer var9 = this.mcserver.getWorldServer(player.dimension);
		class_avn var10 = var9.Q();
		BlockPosition var11 = var9.N();
		this.a(player, (EntityPlayer) null, var9);
		PlayerConnection var12 = new PlayerConnection(this.mcserver, networkManager, player);
		var12.sendPacket((Packet<?>) (new PacketPlayOutLogin(player.getId(), player.playerInteractManager.getGameMode(), var10.t(), var9.worldProvider.p().a(), var9.ab(), this.getMaxPlayers(), var10.u(), var9.R().getBooleanValue("reducedDebugInfo"))));
		var12.sendPacket((Packet<?>) (new PacketPlayOutCustomPayload("MC|Brand", (new PacketDataSerializer(Unpooled.buffer())).writeString(this.getMinecraftServer().getServerModName()))));
		var12.sendPacket((Packet<?>) (new PacketPlayOutServerDifficulty(var10.y(), var10.z())));
		var12.sendPacket((Packet<?>) (new PacketPlayOutSpawnPosition(var11)));
		var12.sendPacket((Packet<?>) (new PacketPlayOutAbilities(player.abilities)));
		var12.sendPacket((Packet<?>) (new PacketPlayOutHeldItemSlot(player.inventory.itemInHandIndex)));
		int var13 = this.h(var3) ? this.opList.a(var3) : 0;
		var13 = this.mcserver.isLocal() && this.mcserver.d[0].Q().v() ? 4 : var13;
		var13 = this.isEveryoneOP ? 4 : var13;
		this.b(player, var13);
		player.A().d();
		player.A().b(player);
		this.a((class_kl) var9.aa(), player);
		this.mcserver.aH();
		ChatMessage var14;
		if (!player.getName().equalsIgnoreCase(var6)) {
			var14 = new ChatMessage("multiplayer.player.joined.renamed", new Object[] { player.getScoreboardDisplayName(), var6 });
		} else {
			var14 = new ChatMessage("multiplayer.player.joined", new Object[] { player.getScoreboardDisplayName() });
		}

		var14.getChatModifier().a(EnumChatFormat.YELLOW);
		this.a((IChatBaseComponent) var14);
		this.c(player);
		var12.a(player.locX, player.locY, player.locZ, player.yaw, player.pitch);
		this.b(player, var9);
		if (!this.mcserver.ab().isEmpty()) {
			player.a(this.mcserver.ab(), this.mcserver.ac());
		}

		Iterator<?> var15 = player.getEffects().iterator();

		while (var15.hasNext()) {
			MobEffect var16 = (MobEffect) var15.next();
			var12.sendPacket((Packet<?>) (new PacketPlayOutEntityEffect(player.getId(), var16)));
		}

		player.g_();
		if (var7 != null && var7.hasOfType("Riding", 10)) {
			Entity var17 = EntityTypes.a((NBTTagCompound) var7.getCompound("Riding"), (World) var9);
			if (var17 != null) {
				var17.attachedToPlayer = true;
				var9.addEntity(var17);
				player.a(var17);
				var17.attachedToPlayer = false;
			}
		}

	}

	protected void a(class_kl var1, EntityPlayer var2) {
		HashSet<class_awj> var3 = Sets.newHashSet();
		Iterator<?> var4 = var1.g().iterator();

		while (var4.hasNext()) {
			class_awk var5 = (class_awk) var4.next();
			var2.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutScoreboardTeam(var5, 0)));
		}

		for (int var9 = 0; var9 < 19; ++var9) {
			class_awj var10 = var1.a(var9);
			if (var10 != null && !var3.contains(var10)) {
				List<?> var6 = var1.d(var10);
				Iterator<?> var7 = var6.iterator();

				while (var7.hasNext()) {
					Packet<?> var8 = (Packet<?>) var7.next();
					var2.playerConnection.sendPacket(var8);
				}

				var3.add(var10);
			}
		}

	}

	public void a(WorldServer[] var1) {
		this.playerDataProvider = var1[0].P().e();
		var1[0].ag().a(new class_aoc() {
			public void a(class_aoe var1, double var2) {
				PlayerList.this.a((Packet<?>) (new PacketPlayOutWorldBorder(var1, PacketPlayOutWorldBorder.class_a_in_class_hg.a)));
			}

			public void a(class_aoe var1, double var2, double var4, long var6) {
				PlayerList.this.a((Packet<?>) (new PacketPlayOutWorldBorder(var1, PacketPlayOutWorldBorder.class_a_in_class_hg.b)));
			}

			public void a(class_aoe var1, double var2, double var4) {
				PlayerList.this.a((Packet<?>) (new PacketPlayOutWorldBorder(var1, PacketPlayOutWorldBorder.class_a_in_class_hg.c)));
			}

			public void a(class_aoe var1, int var2) {
				PlayerList.this.a((Packet<?>) (new PacketPlayOutWorldBorder(var1, PacketPlayOutWorldBorder.class_a_in_class_hg.e)));
			}

			public void b(class_aoe var1, int var2) {
				PlayerList.this.a((Packet<?>) (new PacketPlayOutWorldBorder(var1, PacketPlayOutWorldBorder.class_a_in_class_hg.f)));
			}

			public void b(class_aoe var1, double var2) {
			}

			public void c(class_aoe var1, double var2) {
			}
		});
	}

	public void a(EntityPlayer var1, WorldServer var2) {
		WorldServer var3 = var1.u();
		if (var2 != null) {
			var2.u().c(var1);
		}

		var3.u().a(var1);
		var3.b.c((int) var1.locX >> 4, (int) var1.locZ >> 4);
	}

	public int d() {
		return class_ld.b(this.getViewDistance());
	}

	public NBTTagCompound a(EntityPlayer var1) {
		NBTTagCompound var2 = this.mcserver.d[0].Q().i();
		NBTTagCompound var3;
		if (var1.getName().equals(this.mcserver.S()) && var2 != null) {
			var1.f(var2);
			var3 = var2;
			looger.debug("loading single player");
		} else {
			var3 = this.playerDataProvider.b(var1);
		}

		return var3;
	}

	protected void b(EntityPlayer var1) {
		this.playerDataProvider.a(var1);
		ServerStatisticManager var2 = (ServerStatisticManager) this.stats.get(var1.getUniqueId());
		if (var2 != null) {
			var2.b();
		}

	}

	public void c(EntityPlayer var1) {
		this.playerList.add(var1);
		this.playerMap.put(var1.getUniqueId(), var1);
		this.a((Packet<?>) (new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.class_a_in_class_gz.a, new EntityPlayer[] { var1 })));
		WorldServer var2 = this.mcserver.getWorldServer(var1.dimension);
		var2.addEntity((Entity) var1);
		this.a((EntityPlayer) var1, (WorldServer) null);

		for (int var3 = 0; var3 < this.playerList.size(); ++var3) {
			EntityPlayer var4 = (EntityPlayer) this.playerList.get(var3);
			var1.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.class_a_in_class_gz.a, new EntityPlayer[] { var4 })));
		}

	}

	public void d(EntityPlayer var1) {
		var1.u().u().d(var1);
	}

	public void e(EntityPlayer var1) {
		var1.b((class_my) StatisticList.f);
		this.b(var1);
		WorldServer var2 = var1.u();
		if (var1.vehicle != null) {
			var2.f(var1.vehicle);
			looger.debug("removing player mount");
		}

		var2.e(var1);
		var2.u().c(var1);
		this.playerList.remove(var1);
		UUID var3 = var1.getUniqueId();
		EntityPlayer var4 = (EntityPlayer) this.playerMap.get(var3);
		if (var4 == var1) {
			this.playerMap.remove(var3);
			this.stats.remove(var3);
		}

		this.a((Packet<?>) (new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.class_a_in_class_gz.e, new EntityPlayer[] { var1 })));
	}

	public String getKickReason(SocketAddress address, GameProfile profile) {
		String reason;
		if (this.gameProfileBanList.a(profile)) {
			class_mf var5 = (class_mf) this.gameProfileBanList.b((Object) profile);
			reason = "You are banned from this server!\nReason: " + var5.d();
			if (var5.c() != null) {
				reason = reason + "\nYour ban will be removed on " + format.format(var5.c());
			}

			return reason;
		} else if (!this.e(profile)) {
			return "You are not white-listed on this server!";
		} else if (this.ipBanList.a(address)) {
			class_lx var3 = this.ipBanList.b(address);
			reason = "Your IP address is banned from this server!\nReason: " + var3.d();
			if (var3.c() != null) {
				reason = reason + "\nYour ban will be removed on " + format.format(var3.c());
			}

			return reason;
		} else {
			return this.playerList.size() >= this.maxPlayers && !this.f(profile) ? "The server is full!" : null;
		}
	}

	public EntityPlayer addPlayer(GameProfile var1) {
		UUID var2 = EntityHuman.a(var1);
		ArrayList<EntityPlayer> var3 = Lists.newArrayList();

		for (int var4 = 0; var4 < this.playerList.size(); ++var4) {
			EntityPlayer var5 = (EntityPlayer) this.playerList.get(var4);
			if (var5.getUniqueId().equals(var2)) {
				var3.add(var5);
			}
		}

		EntityPlayer var7 = (EntityPlayer) this.playerMap.get(var1.getId());
		if (var7 != null && !var3.contains(var7)) {
			var3.add(var7);
		}

		Iterator<EntityPlayer> var8 = var3.iterator();

		while (var8.hasNext()) {
			EntityPlayer var6 = (EntityPlayer) var8.next();
			var6.playerConnection.c("You logged in from another location");
		}

		Object var9;
		if (this.mcserver.X()) {
			var9 = new class_kz(this.mcserver.getWorldServer(0));
		} else {
			var9 = new PlayerInteractManager(this.mcserver.getWorldServer(0));
		}

		return new EntityPlayer(this.mcserver, this.mcserver.getWorldServer(0), var1, (PlayerInteractManager) var9);
	}

	public EntityPlayer a(EntityPlayer var1, int var2, boolean var3) {
		var1.u().t().b(var1);
		var1.u().t().b((Entity) var1);
		var1.u().u().c(var1);
		this.playerList.remove(var1);
		this.mcserver.getWorldServer(var1.dimension).f(var1);
		BlockPosition var4 = var1.cj();
		boolean var5 = var1.ck();
		var1.dimension = var2;
		Object var6;
		if (this.mcserver.X()) {
			var6 = new class_kz(this.mcserver.getWorldServer(var1.dimension));
		} else {
			var6 = new PlayerInteractManager(this.mcserver.getWorldServer(var1.dimension));
		}

		EntityPlayer var7 = new EntityPlayer(this.mcserver, this.mcserver.getWorldServer(var1.dimension), var1.cf(), (PlayerInteractManager) var6);
		var7.playerConnection = var1.playerConnection;
		var7.a((EntityHuman) var1, var3);
		var7.e(var1.getId());
		var7.o(var1);
		var7.a(var1.bR());
		WorldServer var8 = this.mcserver.getWorldServer(var1.dimension);
		this.a(var7, var1, var8);
		BlockPosition var9;
		if (var4 != null) {
			var9 = EntityHuman.a(this.mcserver.getWorldServer(var1.dimension), var4, var5);
			if (var9 != null) {
				var7.b((double) ((float) var9.getX() + 0.5F), (double) ((float) var9.getY() + 0.1F), (double) ((float) var9.getZ() + 0.5F), 0.0F, 0.0F);
				var7.a((BlockPosition) var4, var5);
			} else {
				var7.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutGameStateChange(0, 0.0F)));
			}
		}

		var8.b.c((int) var7.locX >> 4, (int) var7.locZ >> 4);

		while (!var8.a((Entity) var7, (AxisAlignedBB) var7.aT()).isEmpty() && var7.locY < 256.0D) {
			var7.b(var7.locX, var7.locY + 1.0D, var7.locZ);
		}

		var7.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutRespawn(var7.dimension, var7.world.ab(), var7.world.Q().u(), var7.playerInteractManager.getGameMode())));
		var9 = var8.N();
		var7.playerConnection.a(var7.locX, var7.locY, var7.locZ, var7.yaw, var7.pitch);
		var7.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutSpawnPosition(var9)));
		var7.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutExperience(var7.exp, var7.expTotal, var7.expLevel)));
		this.b(var7, var8);
		var8.u().a(var7);
		var8.addEntity((Entity) var7);
		this.playerList.add(var7);
		this.playerMap.put(var7.getUniqueId(), var7);
		var7.g_();
		var7.i(var7.getHealth());
		return var7;
	}

	public void a(EntityPlayer var1, int var2) {
		int var3 = var1.dimension;
		WorldServer var4 = this.mcserver.getWorldServer(var1.dimension);
		var1.dimension = var2;
		WorldServer var5 = this.mcserver.getWorldServer(var1.dimension);
		var1.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutRespawn(var1.dimension, var1.world.ab(), var1.world.Q().u(), var1.playerInteractManager.getGameMode())));
		var4.f(var1);
		var1.dead = false;
		this.a(var1, var3, var4, var5);
		this.a(var1, var4);
		var1.playerConnection.a(var1.locX, var1.locY, var1.locZ, var1.yaw, var1.pitch);
		var1.playerInteractManager.a(var5);
		this.b(var1, var5);
		this.f(var1);
		Iterator<?> var6 = var1.getEffects().iterator();

		while (var6.hasNext()) {
			MobEffect var7 = (MobEffect) var6.next();
			var1.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutEntityEffect(var1.getId(), var7)));
		}

	}

	public void a(Entity var1, int var2, WorldServer var3, WorldServer var4) {
		double var5 = var1.locX;
		double var7 = var1.locZ;
		double var9 = 8.0D;
		float var11 = var1.yaw;
		var3.B.a("moving");
		if (var1.dimension == -1) {
			var5 = MathHelper.clamp(var5 / var9, var4.ag().b() + 16.0D, var4.ag().d() - 16.0D);
			var7 = MathHelper.clamp(var7 / var9, var4.ag().c() + 16.0D, var4.ag().e() - 16.0D);
			var1.b(var5, var1.locY, var7, var1.yaw, var1.pitch);
			if (var1.isAlive()) {
				var3.a(var1, false);
			}
		} else if (var1.dimension == 0) {
			var5 = MathHelper.clamp(var5 * var9, var4.ag().b() + 16.0D, var4.ag().d() - 16.0D);
			var7 = MathHelper.clamp(var7 * var9, var4.ag().c() + 16.0D, var4.ag().e() - 16.0D);
			var1.b(var5, var1.locY, var7, var1.yaw, var1.pitch);
			if (var1.isAlive()) {
				var3.a(var1, false);
			}
		} else {
			BlockPosition var12;
			if (var2 == 1) {
				var12 = var4.N();
			} else {
				var12 = var4.n();
			}

			var5 = (double) var12.getX();
			var1.locY = (double) var12.getY();
			var7 = (double) var12.getZ();
			var1.b(var5, var1.locY, var7, 90.0F, 0.0F);
			if (var1.isAlive()) {
				var3.a(var1, false);
			}
		}

		var3.B.b();
		if (var2 != 1) {
			var3.B.a("placing");
			var5 = (double) MathHelper.clamp((int) var5, -29999872, 29999872);
			var7 = (double) MathHelper.clamp((int) var7, -29999872, 29999872);
			if (var1.isAlive()) {
				var1.b(var5, var1.locY, var7, var1.yaw, var1.pitch);
				var4.v().a(var1, var11);
				var4.addEntity(var1);
				var4.a(var1, false);
			}

			var3.B.b();
		}

		var1.a((World) var4);
	}

	public void tick() {
		if (++this.pingUpdateCounter > 600) {
			this.a((Packet<?>) (new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.class_a_in_class_gz.c, this.playerList)));
			this.pingUpdateCounter = 0;
		}
	}

	public void a(Packet<?> var1) {
		for (int var2 = 0; var2 < this.playerList.size(); ++var2) {
			((EntityPlayer) this.playerList.get(var2)).playerConnection.sendPacket(var1);
		}

	}

	public void a(Packet<?> var1, int var2) {
		for (int var3 = 0; var3 < this.playerList.size(); ++var3) {
			EntityPlayer var4 = (EntityPlayer) this.playerList.get(var3);
			if (var4.dimension == var2) {
				var4.playerConnection.sendPacket(var1);
			}
		}

	}

	public void a(EntityHuman var1, IChatBaseComponent var2) {
		class_awp var3 = var1.bP();
		if (var3 != null) {
			Collection<?> var4 = var3.d();
			Iterator<?> var5 = var4.iterator();

			while (var5.hasNext()) {
				String var6 = (String) var5.next();
				EntityPlayer var7 = this.a(var6);
				if (var7 != null && var7 != var1) {
					var7.a(var2);
				}
			}

		}
	}

	public void b(EntityHuman var1, IChatBaseComponent var2) {
		class_awp var3 = var1.bP();
		if (var3 == null) {
			this.a(var2);
		} else {
			for (int var4 = 0; var4 < this.playerList.size(); ++var4) {
				EntityPlayer var5 = (EntityPlayer) this.playerList.get(var4);
				if (var5.bP() != var3) {
					var5.a(var2);
				}
			}

		}
	}

	public String b(boolean var1) {
		String var2 = "";
		ArrayList<EntityPlayer> var3 = Lists.newArrayList((Iterable<EntityPlayer>) this.playerList);

		for (int var4 = 0; var4 < var3.size(); ++var4) {
			if (var4 > 0) {
				var2 = var2 + ", ";
			}

			var2 = var2 + ((EntityPlayer) var3.get(var4)).getName();
			if (var1) {
				var2 = var2 + " (" + ((EntityPlayer) var3.get(var4)).getUniqueId().toString() + ")";
			}
		}

		return var2;
	}

	public String[] f() {
		String[] var1 = new String[this.playerList.size()];

		for (int var2 = 0; var2 < this.playerList.size(); ++var2) {
			var1[var2] = ((EntityPlayer) this.playerList.get(var2)).getName();
		}

		return var1;
	}

	public GameProfile[] g() {
		GameProfile[] var1 = new GameProfile[this.playerList.size()];

		for (int var2 = 0; var2 < this.playerList.size(); ++var2) {
			var1[var2] = ((EntityPlayer) this.playerList.get(var2)).cf();
		}

		return var1;
	}

	public GameProfileBanList h() {
		return this.gameProfileBanList;
	}

	public IpBanList i() {
		return this.ipBanList;
	}

	public void a(GameProfile var1) {
		int var2 = this.mcserver.p();
		this.opList.a((class_mc) (new class_mb(var1, this.mcserver.p(), this.opList.b(var1))));
		this.b(this.getPlayer(var1.getId()), var2);
	}

	public void b(GameProfile var1) {
		this.opList.c(var1);
		this.b(this.getPlayer(var1.getId()), 0);
	}

	private void b(EntityPlayer var1, int var2) {
		if (var1 != null && var1.playerConnection != null) {
			byte var3 = var2 <= 0 ? 24 : (var2 >= 4 ? 28 : (byte) (24 + var2));
			var1.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutEntityStatus(var1, var3)));
		}

	}

	public boolean e(GameProfile var1) {
		return !this.hasWhitelist || this.opList.d(var1) || this.whiteList.d(var1);
	}

	public boolean h(GameProfile var1) {
		return this.opList.d(var1) || this.mcserver.isLocal() && this.mcserver.d[0].Q().v() && this.mcserver.S().equalsIgnoreCase(var1.getName()) || this.isEveryoneOP;
	}

	public EntityPlayer a(String var1) {
		Iterator<EntityPlayer> var2 = this.playerList.iterator();

		EntityPlayer var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (EntityPlayer) var2.next();
		} while (!var3.getName().equalsIgnoreCase(var1));

		return var3;
	}

	public void a(double var1, double var3, double var5, double var7, int var9, Packet<?> var10) {
		this.a((EntityHuman) null, var1, var3, var5, var7, var9, var10);
	}

	public void a(EntityHuman var1, double var2, double var4, double var6, double var8, int var10, Packet<?> var11) {
		for (int var12 = 0; var12 < this.playerList.size(); ++var12) {
			EntityPlayer var13 = (EntityPlayer) this.playerList.get(var12);
			if (var13 != var1 && var13.dimension == var10) {
				double var14 = var2 - var13.locX;
				double var16 = var4 - var13.locY;
				double var18 = var6 - var13.locZ;
				if (var14 * var14 + var16 * var16 + var18 * var18 < var8 * var8) {
					var13.playerConnection.sendPacket(var11);
				}
			}
		}

	}

	public void j() {
		for (int var1 = 0; var1 < this.playerList.size(); ++var1) {
			this.b((EntityPlayer) this.playerList.get(var1));
		}

	}

	public void d(GameProfile var1) {
		this.whiteList.a((class_mc) (new class_mh(var1)));
	}

	public void c(GameProfile var1) {
		this.whiteList.c(var1);
	}

	public WhiteList k() {
		return this.whiteList;
	}

	public String[] l() {
		return this.whiteList.a();
	}

	public OpList m() {
		return this.opList;
	}

	public String[] n() {
		return this.opList.a();
	}

	public void a() {
	}

	public void b(EntityPlayer var1, WorldServer var2) {
		class_aoe var3 = this.mcserver.d[0].ag();
		var1.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutWorldBorder(var3, PacketPlayOutWorldBorder.class_a_in_class_hg.d)));
		var1.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutUpdateTime(var2.L(), var2.M(), var2.R().getBooleanValue("doDaylightCycle"))));
		if (var2.T()) {
			var1.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutGameStateChange(1, 0.0F)));
			var1.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutGameStateChange(7, var2.j(1.0F))));
			var1.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutGameStateChange(8, var2.h(1.0F))));
		}

	}

	public void f(EntityPlayer var1) {
		var1.a(var1.bq);
		var1.r();
		var1.playerConnection.sendPacket((Packet<?>) (new PacketPlayOutHeldItemSlot(var1.inventory.itemInHandIndex)));
	}

	public int getOnlinePlayers() {
		return this.playerList.size();
	}

	public int getMaxPlayers() {
		return this.maxPlayers;
	}

	public String[] q() {
		return this.mcserver.d[0].P().e().f();
	}

	public boolean hasWhitelist() {
		return this.hasWhitelist;
	}

	public void setHasWhitelist(boolean has) {
		this.hasWhitelist = has;
	}

	public List<EntityPlayer> b(String var1) {
		ArrayList<EntityPlayer> var2 = Lists.newArrayList();
		Iterator<EntityPlayer> var3 = this.playerList.iterator();

		while (var3.hasNext()) {
			EntityPlayer var4 = (EntityPlayer) var3.next();
			if (var4.w().equals(var1)) {
				var2.add(var4);
			}
		}

		return var2;
	}

	public int getViewDistance() {
		return this.viewDistance;
	}

	public MinecraftServer getMinecraftServer() {
		return this.mcserver;
	}

	public NBTTagCompound t() {
		return null;
	}

	private void a(EntityPlayer var1, EntityPlayer var2, World var3) {
		if (var2 != null) {
			var1.playerInteractManager.setGameMode(var2.playerInteractManager.getGameMode());
		} else if (this.defaultGameMode != null) {
			var1.playerInteractManager.setGameMode(this.defaultGameMode);
		}

		var1.playerInteractManager.b(var3.Q().r());
	}

	public void u() {
		for (int var1 = 0; var1 < this.playerList.size(); ++var1) {
			((EntityPlayer) this.playerList.get(var1)).playerConnection.c("Server closed");
		}

	}

	public void a(IChatBaseComponent var1, boolean var2) {
		this.mcserver.a(var1);
		int var3 = var2 ? 1 : 0;
		this.a((Packet<?>) (new PacketPlayOutChat(var1, (byte) var3)));
	}

	public void a(IChatBaseComponent var1) {
		this.a(var1, true);
	}

	public ServerStatisticManager a(EntityHuman var1) {
		UUID var2 = var1.getUniqueId();
		ServerStatisticManager var3 = var2 == null ? null : (ServerStatisticManager) this.stats.get(var2);
		if (var3 == null) {
			File var4 = new File(this.mcserver.getWorldServer(0).P().b(), "stats");
			File var5 = new File(var4, var2.toString() + ".json");
			if (!var5.exists()) {
				File var6 = new File(var4, var1.getName() + ".json");
				if (var6.exists() && var6.isFile()) {
					var6.renameTo(var5);
				}
			}

			var3 = new ServerStatisticManager(this.mcserver, var5);
			var3.a();
			this.stats.put(var2, var3);
		}

		return var3;
	}

	public void a(int var1) {
		this.viewDistance = var1;
		if (this.mcserver.d != null) {
			WorldServer[] var2 = this.mcserver.d;
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				WorldServer var5 = var2[var4];
				if (var5 != null) {
					var5.u().a(var1);
				}
			}

		}
	}

	public List<EntityPlayer> v() {
		return this.playerList;
	}

	public EntityPlayer getPlayer(UUID var1) {
		return (EntityPlayer) this.playerMap.get(var1);
	}

	public boolean f(GameProfile var1) {
		return false;
	}
}
