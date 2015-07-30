package net.minecraft.server;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;

import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import javax.imageio.ImageIO;

import net.minecraft.server.World;
import net.minecraft.server.class_aeo;
import net.minecraft.server.class_aep;
import net.minecraft.server.class_aeq;
import net.minecraft.server.class_aes;
import net.minecraft.server.class_avj;
import net.minecraft.server.class_avn;
import net.minecraft.server.class_avo;
import net.minecraft.server.class_avq;
import net.minecraft.server.Vec3D;
import net.minecraft.server.class_b;
import net.minecraft.server.class_bd;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_e;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fa;
import net.minecraft.server.Packet;
import net.minecraft.server.class_g;
import net.minecraft.server.class_hu;
import net.minecraft.server.class_i;
import net.minecraft.server.class_jt;
import net.minecraft.server.Bootstrap;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_kp;
import net.minecraft.server.class_ky;
import net.minecraft.server.class_l;
import net.minecraft.server.class_la;
import net.minecraft.server.class_lc;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_lh;
import net.minecraft.server.ServerConnection;
import net.minecraft.server.class_lv;
import net.minecraft.server.class_lz;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_nv;
import net.minecraft.server.class_nw;
import net.minecraft.server.class_of;
import net.minecraft.server.class_om;
import net.minecraft.server.class_ox;
import net.minecraft.server.class_oy;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MinecraftServer implements Runnable, class_m, class_of, class_oy {

	private static final Logger k = LogManager.getLogger();
	public static final File a = new File("usercache.json");
	private static MinecraftServer l;
	private final class_avq m;
	private final class_ox n = new class_ox("server", this, az());
	private final File o;
	private final List<class_kn> p = Lists.newArrayList();
	protected final class_l b;
	public final class_nv c = new class_nv();
	private final ServerConnection q;
	private final class_jt r = new class_jt();
	private final Random s = new Random();
	private String t;
	private int u = -1;
	public class_lg[] d;
	private class_lz v;
	private boolean w = true;
	private boolean x;
	private int y;
	protected final Proxy e;
	public String f;
	public int g;
	private boolean z;
	private boolean A;
	private boolean B;
	private boolean C;
	private boolean D;
	private String E;
	private int F;
	private int G = 0;
	public final long[] h = new long[100];
	public long[][] i;
	private KeyPair H;
	private String I;
	private String J;
	private boolean L;
	private boolean M;
	private boolean N;
	private String O = "";
	private String P = "";
	private boolean Q;
	private long R;
	private String S;
	private boolean T;
	private boolean U;
	private final YggdrasilAuthenticationService V;
	private final MinecraftSessionService W;
	private long X = 0L;
	private final GameProfileRepository Y;
	private final class_lv Z;
	protected final Queue<ListenableFutureTask<?>> processQueue = Queues.newArrayDeque();
	private Thread aa;
	private long ab = az();

	public MinecraftServer(File var1, Proxy var2, File var3) {
		this.e = var2;
		l = this;
		this.o = var1;
		this.q = new ServerConnection(this);
		this.Z = new class_lv(this, var3);
		this.b = this.h();
		this.m = new class_avj(var1);
		this.V = new YggdrasilAuthenticationService(var2, UUID.randomUUID().toString());
		this.W = this.V.createMinecraftSessionService();
		this.Y = this.V.createProfileRepository();
	}

	protected class_bd h() {
		return new class_bd();
	}

	protected abstract boolean i() throws IOException;

	protected void a(String var1) {
		if (this.Y().b(var1)) {
			k.info("Converting map!");
			this.b("menu.convertingLevel");
			this.Y().a(var1, new class_nw() {
				private long b = System.currentTimeMillis();

				public void a(String var1) {
				}

				public void a(int var1) {
					if (System.currentTimeMillis() - this.b >= 1000L) {
						this.b = System.currentTimeMillis();
						MinecraftServer.k.info("Converting... " + var1 + "%");
					}

				}

				public void c(String var1) {
				}
			});
		}

	}

	protected synchronized void b(String var1) {
		this.S = var1;
	}

	protected void a(String var1, String var2, long var3, class_aes var5, String var6) {
		this.a(var1);
		this.b("menu.loadingLevel");
		this.d = new class_lg[3];
		this.i = new long[this.d.length][100];
		class_avo var7 = this.m.a(var1, true);
		this.a(this.U(), var7);
		class_avn var9 = var7.d();
		class_aeq var8;
		if (var9 == null) {
			if (this.X()) {
				var8 = class_ky.a;
			} else {
				var8 = new class_aeq(var3, this.m(), this.l(), this.o(), var5);
				var8.a(var6);
				if (this.M) {
					var8.a();
				}
			}

			var9 = new class_avn(var8, var2);
		} else {
			var9.a(var2);
			var8 = new class_aeq(var9);
		}

		for (int var10 = 0; var10 < this.d.length; ++var10) {
			byte var11 = 0;
			if (var10 == 1) {
				var11 = -1;
			}

			if (var10 == 2) {
				var11 = 1;
			}

			if (var10 == 0) {
				if (this.X()) {
					this.d[var10] = (class_lg) (new class_ky(this, var7, var9, var11, this.c)).b();
				} else {
					this.d[var10] = (class_lg) (new class_lg(this, var7, var9, var11, this.c)).b();
				}

				this.d[var10].a(var8);
			} else {
				this.d[var10] = (class_lg) (new class_la(this, var7, var11, this.d[0], this.c)).b();
			}

			this.d[var10].a((class_aep) (new class_lc(this, this.d[var10])));
			if (!this.T()) {
				this.d[var10].Q().a(this.m());
			}
		}

		this.v.a(this.d);
		this.a(this.n());
		this.k();
	}

	protected void k() {
		boolean var1 = true;
		boolean var2 = true;
		boolean var3 = true;
		boolean var4 = true;
		int var5 = 0;
		this.b("menu.generatingTerrain");
		byte var6 = 0;
		k.info("Preparing start region for level " + var6);
		class_lg var7 = this.d[var6];
		BlockPosition var8 = var7.N();
		long var9 = az();

		for (int var11 = -192; var11 <= 192 && this.v(); var11 += 16) {
			for (int var12 = -192; var12 <= 192 && this.v(); var12 += 16) {
				long var13 = az();
				if (var13 - var9 > 1000L) {
					this.a_("Preparing spawn area", var5 * 100 / 625);
					var9 = var13;
				}

				++var5;
				var7.b.c(var8.getX() + var11 >> 4, var8.getZ() + var12 >> 4);
			}
		}

		this.s();
	}

	protected void a(String var1, class_avo var2) {
		File var3 = new File(var2.b(), "resources.zip");
		if (var3.isFile()) {
			this.a_("level://" + var1 + "/" + var3.getName(), "");
		}

	}

	public abstract boolean l();

	public abstract class_aeq.class_a_in_class_aeq m();

	public abstract class_om n();

	public abstract boolean o();

	public abstract int p();

	public abstract boolean q();

	public abstract boolean r();

	protected void a_(String var1, int var2) {
		this.f = var1;
		this.g = var2;
		k.info(var1 + ": " + var2 + "%");
	}

	protected void s() {
		this.f = null;
		this.g = 0;
	}

	protected void a(boolean var1) {
		if (!this.N) {
			class_lg[] var2 = this.d;
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				class_lg var5 = var2[var4];
				if (var5 != null) {
					if (!var1) {
						k.info("Saving chunks for level \'" + var5.Q().k() + "\'/" + var5.t.p().b());
					}

					try {
						var5.a(true, (class_nw) null);
					} catch (class_aeo var7) {
						k.warn(var7.getMessage());
					}
				}
			}

		}
	}

	protected void t() {
		if (!this.N) {
			k.info("Stopping server");
			if (this.aq() != null) {
				this.aq().shutdownNetwork();
			}

			if (this.v != null) {
				k.info("Saving players");
				this.v.j();
				this.v.u();
			}

			if (this.d != null) {
				k.info("Saving worlds");
				this.a(false);

				for (int var1 = 0; var1 < this.d.length; ++var1) {
					class_lg var2 = this.d[var1];
					var2.p();
				}
			}

			if (this.n.d()) {
				this.n.e();
			}

		}
	}

	public String u() {
		return this.t;
	}

	public void c(String var1) {
		this.t = var1;
	}

	public boolean v() {
		return this.w;
	}

	public void w() {
		this.w = false;
	}

	public void run() {
		try {
			if (this.i()) {
				this.ab = az();
				long var1 = 0L;
				this.r.a((IChatBaseComponent) (new class_fa(this.E)));
				this.r.a(new class_jt.class_c_in_class_jt("15w31b", 50));
				this.a(this.r);

				while (this.w) {
					long var48 = az();
					long var5 = var48 - this.ab;
					if (var5 > 2000L && this.ab - this.R >= 15000L) {
						k.warn("Can\'t keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", new Object[] { Long.valueOf(var5), Long.valueOf(var5 / 50L) });
						var5 = 2000L;
						this.R = this.ab;
					}

					if (var5 < 0L) {
						k.warn("Time ran backwards! Did the system time change?");
						var5 = 0L;
					}

					var1 += var5;
					this.ab = var48;
					if (this.d[0].g()) {
						this.A();
						var1 = 0L;
					} else {
						while (var1 > 50L) {
							var1 -= 50L;
							this.A();
						}
					}

					Thread.sleep(Math.max(1L, 50L - var1));
					this.Q = true;
				}
			} else {
				this.a((class_b) null);
			}
		} catch (Throwable var46) {
			k.error("Encountered an unexpected exception", var46);
			class_b var2 = null;
			if (var46 instanceof class_e) {
				var2 = this.b(((class_e) var46).a());
			} else {
				var2 = this.b(new class_b("Exception in server tick loop", var46));
			}

			File var3 = new File(new File(this.y(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-server.txt");
			if (var2.a(var3)) {
				k.error("This crash report has been saved to: " + var3.getAbsolutePath());
			} else {
				k.error("We were unable to save this crash report to disk.");
			}

			this.a(var2);
		} finally {
			try {
				this.x = true;
				this.t();
			} catch (Throwable var44) {
				k.error("Exception stopping the server", var44);
			} finally {
				this.z();
			}

		}

	}

	private void a(class_jt var1) {
		File var2 = this.d("server-icon.png");
		if (var2.isFile()) {
			ByteBuf var3 = Unpooled.buffer();

			try {
				BufferedImage var4 = ImageIO.read(var2);
				Validate.validState(var4.getWidth() == 64, "Must be 64 pixels wide", new Object[0]);
				Validate.validState(var4.getHeight() == 64, "Must be 64 pixels high", new Object[0]);
				ImageIO.write(var4, "PNG", new ByteBufOutputStream(var3));
				ByteBuf var5 = Base64.encode(var3);
				var1.a("data:image/png;base64," + var5.toString(Charsets.UTF_8));
			} catch (Exception var9) {
				k.error((String) "Couldn\'t load server icon", (Throwable) var9);
			} finally {
				var3.release();
			}
		}

	}

	public File y() {
		return new File(".");
	}

	protected void a(class_b var1) {
	}

	protected void z() {
	}

	protected void A() {
		long var1 = System.nanoTime();
		++this.y;
		if (this.T) {
			this.T = false;
			this.c.a = true;
			this.c.a();
		}

		this.c.a("root");
		this.B();
		if (var1 - this.X >= 5000000000L) {
			this.X = var1;
			this.r.a(new class_jt.class_a_in_class_jt(this.J(), this.I()));
			GameProfile[] var3 = new GameProfile[Math.min(this.I(), 12)];
			int var4 = MathHelper.getRandomIntInRange((Random) this.s, 0, this.I() - var3.length);

			for (int var5 = 0; var5 < var3.length; ++var5) {
				var3[var5] = ((class_lh) this.v.v().get(var4 + var5)).cf();
			}

			Collections.shuffle(Arrays.asList(var3));
			this.r.b().a(var3);
		}

		if (this.y % 900 == 0) {
			this.c.a("save");
			this.v.j();
			this.a(true);
			this.c.b();
		}

		this.c.a("tallying");
		this.h[this.y % 100] = System.nanoTime() - var1;
		this.c.b();
		this.c.a("snooper");
		if (!this.n.d() && this.y > 100) {
			this.n.a();
		}

		if (this.y % 6000 == 0) {
			this.n.b();
		}

		this.c.b();
		this.c.b();
	}

	public void B() {
		this.c.a("jobs");
		synchronized (this.processQueue) {
			while (!this.processQueue.isEmpty()) {
				class_g.a((FutureTask<?>) this.processQueue.poll(), k);
			}
		}

		this.c.c("levels");

		int var10;
		for (var10 = 0; var10 < this.d.length; ++var10) {
			long var2 = System.nanoTime();
			if (var10 == 0 || this.C()) {
				class_lg var4 = this.d[var10];
				this.c.a(var4.Q().k());
				if (this.y % 20 == 0) {
					this.c.a("timeSync");
					this.v.a((Packet) (new class_hu(var4.L(), var4.M(), var4.R().b("doDaylightCycle"))), var4.t.p().a());
					this.c.b();
				}

				this.c.a("tick");

				class_b var6;
				try {
					var4.d();
				} catch (Throwable var8) {
					var6 = class_b.a(var8, "Exception ticking world");
					var4.a((class_b) var6);
					throw new class_e(var6);
				}

				try {
					var4.j();
				} catch (Throwable var7) {
					var6 = class_b.a(var7, "Exception ticking world entities");
					var4.a((class_b) var6);
					throw new class_e(var6);
				}

				this.c.b();
				this.c.a("tracker");
				var4.t().a();
				this.c.b();
				this.c.b();
			}

			this.i[var10][this.y % 100] = System.nanoTime() - var2;
		}

		this.c.c("connection");
		this.aq().handleNetwork();
		this.c.c("players");
		this.v.e();
		this.c.c("tickables");

		for (var10 = 0; var10 < this.p.size(); ++var10) {
			((class_kn) this.p.get(var10)).c();
		}

		this.c.b();
	}

	public boolean C() {
		return true;
	}

	public void a(class_kn var1) {
		this.p.add(var1);
	}

	public static void main(String[] var0) {
		Bootstrap.init();

		try {
			boolean var1 = true;
			String var2 = null;
			String var3 = ".";
			String var4 = null;
			boolean var5 = false;
			boolean var6 = false;
			int var7 = -1;

			for (int var8 = 0; var8 < var0.length; ++var8) {
				String var9 = var0[var8];
				String var10 = var8 == var0.length - 1 ? null : var0[var8 + 1];
				boolean var11 = false;
				if (!var9.equals("nogui") && !var9.equals("--nogui")) {
					if (var9.equals("--port") && var10 != null) {
						var11 = true;

						try {
							var7 = Integer.parseInt(var10);
						} catch (NumberFormatException var13) {
							;
						}
					} else if (var9.equals("--singleplayer") && var10 != null) {
						var11 = true;
						var2 = var10;
					} else if (var9.equals("--universe") && var10 != null) {
						var11 = true;
						var3 = var10;
					} else if (var9.equals("--world") && var10 != null) {
						var11 = true;
						var4 = var10;
					} else if (var9.equals("--demo")) {
						var5 = true;
					} else if (var9.equals("--bonusChest")) {
						var6 = true;
					}
				} else {
					var1 = false;
				}

				if (var11) {
					++var8;
				}
			}

			final class_kp var15 = new class_kp(new File(var3));
			if (var2 != null) {
				var15.i(var2);
			}

			if (var4 != null) {
				var15.j(var4);
			}

			if (var7 >= 0) {
				var15.b(var7);
			}

			if (var5) {
				var15.b(true);
			}

			if (var6) {
				var15.c(true);
			}

			if (var1 && !GraphicsEnvironment.isHeadless()) {
				var15.aQ();
			}

			var15.D();
			Runtime.getRuntime().addShutdownHook(new Thread("Server Shutdown Thread") {
				public void run() {
					var15.t();
				}
			});
		} catch (Exception var14) {
			k.fatal((String) "Failed to start the minecraft server", (Throwable) var14);
		}

	}

	public void D() {
		this.aa = new Thread(this, "Server thread");
		this.aa.start();
	}

	public File d(String var1) {
		return new File(this.y(), var1);
	}

	public void e(String var1) {
		k.info(var1);
	}

	public void f(String var1) {
		k.warn(var1);
	}

	public class_lg a(int var1) {
		return var1 == -1 ? this.d[1] : (var1 == 1 ? this.d[2] : this.d[0]);
	}

	public String E() {
		return this.t;
	}

	public int F() {
		return this.u;
	}

	public String G() {
		return this.E;
	}

	public String H() {
		return "15w31b";
	}

	public int I() {
		return this.v.o();
	}

	public int J() {
		return this.v.p();
	}

	public String[] K() {
		return this.v.f();
	}

	public GameProfile[] L() {
		return this.v.g();
	}

	public boolean M() {
		return false;
	}

	public void g(String var1) {
		k.error(var1);
	}

	public void h(String var1) {
		if (this.M()) {
			k.info(var1);
		}

	}

	public String getServerModName() {
		return "vanilla";
	}

	public class_b b(class_b var1) {
		var1.g().a("Profiler Position", new Callable<Object>() {
			public String a() throws Exception {
				return MinecraftServer.this.c.a ? MinecraftServer.this.c.c() : "N/A (disabled)";
			}

			// $FF: synthetic method
			public Object call() throws Exception {
				return this.a();
			}
		});
		if (this.v != null) {
			var1.g().a("Player Count", new Callable<Object>() {
				public String a() {
					return MinecraftServer.this.v.o() + " / " + MinecraftServer.this.v.p() + "; " + MinecraftServer.this.v.v();
				}

				// $FF: synthetic method
				public Object call() throws Exception {
					return this.a();
				}
			});
		}

		return var1;
	}

	public List<String> a(class_m var1, String var2, BlockPosition var3) {
		ArrayList<String> var4 = Lists.newArrayList();
		if (var2.startsWith("/")) {
			var2 = var2.substring(1);
			boolean var11 = !var2.contains(" ");
			List<?> var12 = this.b.a(var1, var2, var3);
			if (var12 != null) {
				Iterator<?> var13 = var12.iterator();

				while (var13.hasNext()) {
					String var14 = (String) var13.next();
					if (var11) {
						var4.add("/" + var14);
					} else {
						var4.add(var14);
					}
				}
			}

			return var4;
		} else {
			String[] var5 = var2.split(" ", -1);
			String var6 = var5[var5.length - 1];
			String[] var7 = this.v.f();
			int var8 = var7.length;

			for (int var9 = 0; var9 < var8; ++var9) {
				String var10 = var7[var9];
				if (class_i.a(var6, var10)) {
					var4.add(var10);
				}
			}

			return var4;
		}
	}

	public static MinecraftServer N() {
		return l;
	}

	public boolean O() {
		return this.o != null;
	}

	public String e_() {
		return "Server";
	}

	public void a(IChatBaseComponent var1) {
		k.info(var1.c());
	}

	public boolean a(int var1, String var2) {
		return true;
	}

	public class_l P() {
		return this.b;
	}

	public KeyPair Q() {
		return this.H;
	}

	public int R() {
		return this.u;
	}

	public void b(int var1) {
		this.u = var1;
	}

	public String S() {
		return this.I;
	}

	public void i(String var1) {
		this.I = var1;
	}

	public boolean T() {
		return this.I != null;
	}

	public String U() {
		return this.J;
	}

	public void j(String var1) {
		this.J = var1;
	}

	public void a(KeyPair var1) {
		this.H = var1;
	}

	public void a(class_om var1) {
		for (int var2 = 0; var2 < this.d.length; ++var2) {
			class_lg var3 = this.d[var2];
			if (var3 != null) {
				if (var3.Q().t()) {
					var3.Q().a(class_om.d);
					var3.a(true, true);
				} else if (this.T()) {
					var3.Q().a(var1);
					var3.a(var3.ab() != class_om.a, true);
				} else {
					var3.Q().a(var1);
					var3.a(this.W(), this.A);
				}
			}
		}

	}

	protected boolean W() {
		return true;
	}

	public boolean X() {
		return this.L;
	}

	public void b(boolean var1) {
		this.L = var1;
	}

	public void c(boolean var1) {
		this.M = var1;
	}

	public class_avq Y() {
		return this.m;
	}

	public void aa() {
		this.N = true;
		this.Y().d();

		for (int var1 = 0; var1 < this.d.length; ++var1) {
			class_lg var2 = this.d[var1];
			if (var2 != null) {
				var2.p();
			}
		}

		this.Y().e(this.d[0].P().g());
		this.w();
	}

	public String ab() {
		return this.O;
	}

	public String ac() {
		return this.P;
	}

	public void a_(String var1, String var2) {
		this.O = var1;
		this.P = var2;
	}

	public void a(class_ox var1) {
		var1.a("whitelist_enabled", Boolean.valueOf(false));
		var1.a("whitelist_count", Integer.valueOf(0));
		if (this.v != null) {
			var1.a("players_current", Integer.valueOf(this.I()));
			var1.a("players_max", Integer.valueOf(this.J()));
			var1.a("players_seen", Integer.valueOf(this.v.q().length));
		}

		var1.a("uses_auth", Boolean.valueOf(this.z));
		var1.a("gui_state", this.as() ? "enabled" : "disabled");
		var1.a("run_time", Long.valueOf((az() - var1.g()) / 60L * 1000L));
		var1.a("avg_tick_ms", Integer.valueOf((int) (MathHelper.getAverage(this.h) * 1.0E-6D)));
		int var2 = 0;
		if (this.d != null) {
			for (int var3 = 0; var3 < this.d.length; ++var3) {
				if (this.d[var3] != null) {
					class_lg var4 = this.d[var3];
					class_avn var5 = var4.Q();
					var1.a("world[" + var2 + "][dimension]", Integer.valueOf(var4.t.p().a()));
					var1.a("world[" + var2 + "][mode]", var5.r());
					var1.a("world[" + var2 + "][difficulty]", var4.ab());
					var1.a("world[" + var2 + "][hardcore]", Boolean.valueOf(var5.t()));
					var1.a("world[" + var2 + "][generator_name]", var5.u().a());
					var1.a("world[" + var2 + "][generator_version]", Integer.valueOf(var5.u().d()));
					var1.a("world[" + var2 + "][height]", Integer.valueOf(this.F));
					var1.a("world[" + var2 + "][chunks_loaded]", Integer.valueOf(var4.O().g()));
					++var2;
				}
			}
		}

		var1.a("worlds", Integer.valueOf(var2));
	}

	public void b(class_ox var1) {
		var1.b("singleplayer", Boolean.valueOf(this.T()));
		var1.b("server_brand", this.getServerModName());
		var1.b("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
		var1.b("dedicated", Boolean.valueOf(this.ae()));
	}

	public boolean ad() {
		return true;
	}

	public abstract boolean ae();

	public boolean af() {
		return this.z;
	}

	public void d(boolean var1) {
		this.z = var1;
	}

	public boolean ag() {
		return this.A;
	}

	public void e(boolean var1) {
		this.A = var1;
	}

	public boolean ah() {
		return this.B;
	}

	public abstract boolean ai();

	public void f(boolean var1) {
		this.B = var1;
	}

	public boolean aj() {
		return this.C;
	}

	public void g(boolean var1) {
		this.C = var1;
	}

	public boolean ak() {
		return this.D;
	}

	public void h(boolean var1) {
		this.D = var1;
	}

	public abstract boolean al();

	public String am() {
		return this.E;
	}

	public void l(String var1) {
		this.E = var1;
	}

	public int an() {
		return this.F;
	}

	public void c(int var1) {
		this.F = var1;
	}

	public boolean ao() {
		return this.x;
	}

	public class_lz ap() {
		return this.v;
	}

	public void a(class_lz var1) {
		this.v = var1;
	}

	public void a(class_aeq.class_a_in_class_aeq var1) {
		for (int var2 = 0; var2 < this.d.length; ++var2) {
			N().d[var2].Q().a(var1);
		}

	}

	public ServerConnection aq() {
		return this.q;
	}

	public boolean as() {
		return false;
	}

	public abstract String a(class_aeq.class_a_in_class_aeq var1, boolean var2);

	public int at() {
		return this.y;
	}

	public void au() {
		this.T = true;
	}

	public BlockPosition c() {
		return BlockPosition.ZERO;
	}

	public Vec3D d() {
		return new Vec3D(0.0D, 0.0D, 0.0D);
	}

	public World e() {
		return this.d[0];
	}

	public class_pr f() {
		return null;
	}

	public int aw() {
		return 16;
	}

	public boolean a(World var1, BlockPosition var2, class_xa var3) {
		return false;
	}

	public void i(boolean var1) {
		this.U = var1;
	}

	public boolean ax() {
		return this.U;
	}

	public Proxy ay() {
		return this.e;
	}

	public static long az() {
		return System.currentTimeMillis();
	}

	public int aA() {
		return this.G;
	}

	public void d(int var1) {
		this.G = var1;
	}

	public IChatBaseComponent f_() {
		return new class_fa(this.e_());
	}

	public boolean aB() {
		return true;
	}

	public MinecraftSessionService aD() {
		return this.W;
	}

	public GameProfileRepository aE() {
		return this.Y;
	}

	public class_lv aF() {
		return this.Z;
	}

	public class_jt aG() {
		return this.r;
	}

	public void aH() {
		this.X = 0L;
	}

	public class_pr a(UUID var1) {
		class_lg[] var2 = this.d;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_lg var5 = var2[var4];
			if (var5 != null) {
				class_pr var6 = var5.a(var1);
				if (var6 != null) {
					return var6;
				}
			}
		}

		return null;
	}

	public boolean u_() {
		return N().d[0].R().b("sendCommandFeedback");
	}

	public void a(class_n.class_a_in_class_n var1, int var2) {
	}

	public int aI() {
		return 29999984;
	}

	public ListenableFuture<?> a(Callable<?> var1) {
		Validate.notNull(var1);
		if (!this.aJ() && !this.ao()) {
			ListenableFutureTask<?> var2 = ListenableFutureTask.create(var1);
			synchronized (this.processQueue) {
				this.processQueue.add(var2);
				return var2;
			}
		} else {
			try {
				return Futures.immediateFuture(var1.call());
			} catch (Exception var6) {
				return Futures.immediateFailedCheckedFuture(var6);
			}
		}
	}

	public ListenableFuture<?> a(Runnable var1) {
		Validate.notNull(var1);
		return this.a(Executors.callable(var1));
	}

	public boolean aJ() {
		return Thread.currentThread() == this.aa;
	}

	public int aK() {
		return 256;
	}

	public long aL() {
		return this.ab;
	}

	public Thread aM() {
		return this.aa;
	}

}
