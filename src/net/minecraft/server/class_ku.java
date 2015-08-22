package net.minecraft.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;

public class class_ku extends MinecraftServer implements class_kp {
	private static final Logger k = LogManager.getLogger();
	private final List l = Collections.synchronizedList(Lists.newArrayList());
	private class_mt m;
	private class_mv n;
	private class_kr o;
	private class_kl p;
	private boolean q;
	private class_agr.class_a_in_class_agr r;
	private boolean s;

	public class_ku(File var1, class_oo var2) {
		super(var1, Proxy.NO_PROXY, a, var2);
		Thread var10001 = new Thread("Server Infinisleeper") {
			{
				setDaemon(true);
				start();
			}

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(2147483647L);
					} catch (InterruptedException var2) {
						;
					}
				}
			}
		};
	}

	@Override
	protected boolean i() throws IOException {
		Thread var1 = new Thread("Server console handler") {
			@Override
			public void run() {
				BufferedReader var1 = new BufferedReader(new InputStreamReader(System.in));

				String var2;
				try {
					while (!class_ku.this.aq() && class_ku.this.v() && ((var2 = var1.readLine()) != null)) {
						class_ku.this.a(var2, class_ku.this);
					}
				} catch (IOException var4) {
					class_ku.k.error("Exception handling console input", var4);
				}

			}
		};
		var1.setDaemon(true);
		var1.start();
		k.info("Starting minecraft server version 15w34d");
		if ((Runtime.getRuntime().maxMemory() / 1024L / 1024L) < 512L) {
			k.warn("To start the server with more ram, launch it as \"java -Xmx1024M -Xms1024M -jar minecraft_server.jar\"");
		}

		k.info("Loading properties");
		o = new class_kr(new File("server.properties"));
		p = new class_kl(new File("eula.txt"));
		if (!p.a()) {
			k.info("You need to agree to the EULA in order to run the server. Go to eula.txt for more info.");
			p.b();
			return false;
		} else {
			if (V()) {
				this.c("127.0.0.1");
			} else {
				this.d(o.a("online-mode", true));
				this.c(o.a("server-ip", ""));
			}

			this.e(o.a("spawn-animals", true));
			this.f(o.a("spawn-npcs", true));
			this.g(o.a("pvp", true));
			this.h(o.a("allow-flight", false));
			this.a_(o.a("resource-pack", ""), o.a("resource-pack-hash", ""));
			this.l(o.a("motd", "A Minecraft Server"));
			this.i(o.a("force-gamemode", false));
			this.d(o.a("player-idle-timeout", 0));
			if (o.a("difficulty", 1) < 0) {
				o.a("difficulty", Integer.valueOf(0));
			} else if (o.a("difficulty", 1) > 3) {
				o.a("difficulty", Integer.valueOf(3));
			}

			q = o.a("generate-structures", true);
			int var2 = o.a("gamemode", class_agr.class_a_in_class_agr.b.a());
			r = class_agr.a(var2);
			k.info("Default game type: " + r);
			InetAddress var3 = null;
			if (!u().isEmpty()) {
				var3 = InetAddress.getByName(u());
			}

			if (T() < 0) {
				this.b(o.a("server-port", 25565));
			}

			k.info("Generating keypair");
			this.a(class_no.b());
			k.info("Starting Minecraft server on " + (u().isEmpty() ? "*" : u()) + ":" + T());

			try {
				as().a(var3, T());
			} catch (IOException var17) {
				k.warn("**** FAILED TO BIND TO PORT!");
				k.warn("The exception was: {}", new Object[] { var17.toString() });
				k.warn("Perhaps a server is already running on that port?");
				return false;
			}

			if (!ah()) {
				k.warn("**** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!");
				k.warn("The server will make no attempt to authenticate usernames. Beware.");
				k.warn("While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.");
				k.warn("To change this, set \"online-mode\" to \"true\" in the server.properties file.");
			}

			if (aU()) {
				aH().c();
			}

			if (!class_md.a(o)) {
				return false;
			} else {
				this.a((new class_kt(this)));
				long var4 = System.nanoTime();
				if (W() == null) {
					j(o.a("level-name", "world"));
				}

				String var6 = o.a("level-seed", "");
				String var7 = o.a("level-type", "DEFAULT");
				String var8 = o.a("generator-settings", "");
				long var9 = (new Random()).nextLong();
				if (!var6.isEmpty()) {
					try {
						long var11 = Long.parseLong(var6);
						if (var11 != 0L) {
							var9 = var11;
						}
					} catch (NumberFormatException var16) {
						var9 = var6.hashCode();
					}
				}

				class_agt var18 = class_agt.a(var7);
				if (var18 == null) {
					var18 = class_agt.b;
				}

				aD();
				an();
				p();
				af();
				aM();
				this.c(o.a("max-build-height", 256));
				this.c(((ap() + 8) / 16) * 16);
				this.c(class_oa.a(ap(), 64, 256));
				o.a("max-build-height", Integer.valueOf(ap()));
				k.info("Preparing level \"" + W() + "\"");
				this.a(W(), W(), var9, var18, var8);
				long var12 = System.nanoTime() - var4;
				String var14 = String.format("%.3fs", new Object[] { Double.valueOf(var12 / 1.0E9D) });
				k.info("Done (" + var14 + ")! For help, type \"help\" or \"?\"");
				if (o.a("enable-query", false)) {
					k.info("Starting GS4 status listener");
					m = new class_mt(this);
					m.a();
				}

				if (o.a("enable-rcon", false)) {
					k.info("Starting remote control listener");
					n = new class_mv(this);
					n.a();
				}

				if (aV() > 0L) {
					Thread var15 = new Thread(new class_kv(this));
					var15.setName("Server Watchdog");
					var15.setDaemon(true);
					var15.start();
				}

				return true;
			}
		}
	}

	@Override
	public void a(class_agr.class_a_in_class_agr var1) {
		super.a(var1);
		r = var1;
	}

	@Override
	public boolean l() {
		return q;
	}

	@Override
	public class_agr.class_a_in_class_agr m() {
		return r;
	}

	@Override
	public class_ps n() {
		return class_ps.a(o.a("difficulty", class_ps.c.a()));
	}

	@Override
	public boolean o() {
		return o.a("hardcore", false);
	}

	@Override
	protected void a(class_b var1) {
	}

	@Override
	public class_b b(class_b var1) {
		var1 = super.b(var1);
		var1.g().a("Is Modded", new Callable() {
			public String a() throws Exception {
				String var1 = class_ku.this.getServerModName();
				return !var1.equals("vanilla") ? "Definitely; Server brand changed to \'" + var1 + "\'" : "Unknown (can\'t tell)";
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.g().a("Type", new Callable() {
			public String a() throws Exception {
				return "Dedicated Server (map_server.txt)";
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		return var1;
	}

	@Override
	protected void B() {
		System.exit(0);
	}

	@Override
	public void D() {
		super.D();
		aR();
	}

	@Override
	public boolean E() {
		return o.a("allow-nether", true);
	}

	@Override
	public boolean Y() {
		return o.a("spawn-monsters", true);
	}

	@Override
	public void a(class_qd var1) {
		var1.a("whitelist_enabled", Boolean.valueOf(aS().r()));
		var1.a("whitelist_count", Integer.valueOf(aS().l().length));
		super.a(var1);
	}

	@Override
	public boolean af() {
		return o.a("snooper-enabled", true);
	}

	public void a(String var1, class_m var2) {
		l.add(new class_kj(var1, var2));
	}

	public void aR() {
		while (!l.isEmpty()) {
			class_kj var1 = (class_kj) l.remove(0);
			R().a(var1.b, var1.a);
		}

	}

	@Override
	public boolean ag() {
		return true;
	}

	@Override
	public boolean ak() {
		return o.a("use-native-transport", true);
	}

	public class_kt aS() {
		return (class_kt) super.ar();
	}

	@Override
	public int a(String var1, int var2) {
		return o.a(var1, var2);
	}

	@Override
	public String a(String var1, String var2) {
		return o.a(var1, var2);
	}

	public boolean a(String var1, boolean var2) {
		return o.a(var1, var2);
	}

	@Override
	public void a(String var1, Object var2) {
		o.a(var1, var2);
	}

	@Override
	public void a() {
		o.b();
	}

	@Override
	public String b() {
		File var1 = o.c();
		return var1 != null ? var1.getAbsolutePath() : "No settings file";
	}

	public void aT() {
		class_kx.a(this);
		s = true;
	}

	@Override
	public boolean au() {
		return s;
	}

	@Override
	public String a(class_agr.class_a_in_class_agr var1, boolean var2) {
		return "";
	}

	@Override
	public boolean an() {
		return o.a("enable-command-block", false);
	}

	@Override
	public int ay() {
		return o.a("spawn-protection", super.ay());
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_yu var3) {
		if (var1.t.p().a() != 0) {
			return false;
		} else if (aS().m().d()) {
			return false;
		} else if (aS().h(var3.cl())) {
			return false;
		} else if (ay() <= 0) {
			return false;
		} else {
			class_cj var4 = var1.O();
			int var5 = class_oa.a(var2.n() - var4.n());
			int var6 = class_oa.a(var2.p() - var4.p());
			int var7 = Math.max(var5, var6);
			return var7 <= ay();
		}
	}

	@Override
	public int p() {
		return o.a("op-permission-level", 4);
	}

	@Override
	public void d(int var1) {
		super.d(var1);
		o.a("player-idle-timeout", Integer.valueOf(var1));
		this.a();
	}

	@Override
	public boolean q() {
		return o.a("broadcast-rcon-to-ops", true);
	}

	@Override
	public boolean r() {
		return o.a("broadcast-console-to-ops", true);
	}

	@Override
	public boolean aD() {
		return o.a("announce-player-achievements", true);
	}

	@Override
	public int aK() {
		int var1 = o.a("max-world-size", super.aK());
		if (var1 < 1) {
			var1 = 1;
		} else if (var1 > super.aK()) {
			var1 = super.aK();
		}

		return var1;
	}

	@Override
	public int aM() {
		return o.a("network-compression-threshold", super.aM());
	}

	protected boolean aU() {
		boolean var2 = false;

		int var1;
		for (var1 = 0; !var2 && (var1 <= 2); ++var1) {
			if (var1 > 0) {
				k.warn("Encountered a problem while converting the user banlist, retrying in a few seconds");
				aX();
			}

			var2 = class_md.a(this);
		}

		boolean var3 = false;

		for (var1 = 0; !var3 && (var1 <= 2); ++var1) {
			if (var1 > 0) {
				k.warn("Encountered a problem while converting the ip banlist, retrying in a few seconds");
				aX();
			}

			var3 = class_md.b(this);
		}

		boolean var4 = false;

		for (var1 = 0; !var4 && (var1 <= 2); ++var1) {
			if (var1 > 0) {
				k.warn("Encountered a problem while converting the op list, retrying in a few seconds");
				aX();
			}

			var4 = class_md.c(this);
		}

		boolean var5 = false;

		for (var1 = 0; !var5 && (var1 <= 2); ++var1) {
			if (var1 > 0) {
				k.warn("Encountered a problem while converting the whitelist, retrying in a few seconds");
				aX();
			}

			var5 = class_md.d(this);
		}

		boolean var6 = false;

		for (var1 = 0; !var6 && (var1 <= 2); ++var1) {
			if (var1 > 0) {
				k.warn("Encountered a problem while converting the player save files, retrying in a few seconds");
				aX();
			}

			var6 = class_md.a(this, o);
		}

		return var2 || var3 || var4 || var5 || var6;
	}

	private void aX() {
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException var2) {
			;
		}
	}

	public long aV() {
		return o.a("max-tick-time", TimeUnit.MINUTES.toMillis(1L));
	}

	@Override
	public String d_() {
		return "";
	}

	@Override
	public String a_(String var1) {
		class_mq.h().i();
		b.a(class_mq.h(), var1);
		return class_mq.h().j();
	}

	// $FF: synthetic method
	@Override
	public class_me ar() {
		return aS();
	}
}
