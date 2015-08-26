package net.minecraft.server;

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

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

public abstract class MinecraftServer implements Runnable, ICommandListener, class_pl, class_qe {
	private static final Logger k = LogManager.getLogger();
	public static final File a = new File("usercache.json");
	private static MinecraftServer l;
	private final class_axw m;
	private final class_qd n = new class_qd("server", this, aB());
	private final File o;
	private final List p = Lists.newArrayList();
	protected final class_l b;
	public final class_ob c = new class_ob();
	private final class_ls q;
	private final class_ju r = new class_ju();
	private final Random s = new Random();
	private final class_oo t;
	private String u;
	private int v = -1;
	public class_ll[] d;
	private class_me w;
	private boolean x = true;
	private boolean y;
	private int z;
	protected final Proxy e;
	public String f;
	public int g;
	private boolean A;
	private boolean B;
	private boolean C;
	private boolean D;
	private boolean E;
	private String F;
	private int G;
	private int H = 0;
	public final long[] h = new long[100];
	public long[][] i;
	private KeyPair I;
	private String J;
	private String K;
	private boolean M;
	private boolean N;
	private boolean O;
	private String P = "";
	private String Q = "";
	private boolean R;
	private long S;
	private String T;
	private boolean U;
	private boolean V;
	private final YggdrasilAuthenticationService W;
	private final MinecraftSessionService X;
	private long Y = 0L;
	private final GameProfileRepository Z;
	private final class_ma aa;
	protected final Queue j = Queues.newArrayDeque();
	private Thread ab;
	private long ac = aB();

	public MinecraftServer(File var1, Proxy var2, File var3, class_oo var4) {
		e = var2;
		l = this;
		o = var1;
		q = new class_ls(this);
		aa = new class_ma(this, var3);
		b = this.h();
		m = new class_axp(var1, var4);
		W = new YggdrasilAuthenticationService(var2, UUID.randomUUID().toString());
		X = W.createMinecraftSessionService();
		Z = W.createProfileRepository();
		t = var4;
	}

	protected CommandDispatcher h() {
		return new CommandDispatcher();
	}

	protected abstract boolean i() throws IOException;

	protected void a(String var1) {
		if (aa().b(var1)) {
			k.info("Converting map!");
			this.b("menu.convertingLevel");
			aa().a(var1, new class_oc() {
				private long b = System.currentTimeMillis();

				@Override
				public void a(String var1) {
				}

				@Override
				public void a(int var1) {
					if ((System.currentTimeMillis() - b) >= 1000L) {
						b = System.currentTimeMillis();
						MinecraftServer.k.info("Converting... " + var1 + "%");
					}

				}

				@Override
				public void c(String var1) {
				}
			});
		}

	}

	protected synchronized void b(String var1) {
		T = var1;
	}

	protected void a(String var1, String var2, long var3, class_agt var5, String var6) {
		this.a(var1);
		this.b("menu.loadingLevel");
		d = new class_ll[3];
		i = new long[d.length][100];
		class_axu var7 = m.a(var1, true);
		this.a(W(), var7);
		class_axt var9 = var7.d();
		class_agr var8;
		if (var9 == null) {
			if (Z()) {
				var8 = class_ld.a;
			} else {
				var8 = new class_agr(var3, m(), this.l(), o(), var5);
				var8.a(var6);
				if (N) {
					var8.a();
				}
			}

			var9 = new class_axt(var8, var2);
		} else {
			var9.a(var2);
			var8 = new class_agr(var9);
		}

		for (int var10 = 0; var10 < d.length; ++var10) {
			byte var11 = 0;
			if (var10 == 1) {
				var11 = -1;
			}

			if (var10 == 2) {
				var11 = 1;
			}

			if (var10 == 0) {
				if (Z()) {
					d[var10] = (class_ll) (new class_ld(this, var7, var9, var11, c)).b();
				} else {
					d[var10] = (class_ll) (new class_ll(this, var7, var9, var11, c)).b();
				}

				d[var10].a(var8);
			} else {
				d[var10] = (class_ll) (new class_lf(this, var7, var11, d[0], c)).b();
			}

			d[var10].a((new class_lh(this, d[var10])));
			if (!V()) {
				d[var10].R().a(m());
			}
		}

		w.a(d);
		this.a(n());
		k();
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
		class_ll var7 = d[var6];
		class_cj var8 = var7.O();
		long var9 = aB();

		for (int var11 = -192; (var11 <= 192) && v(); var11 += 16) {
			for (int var12 = -192; (var12 <= 192) && v(); var12 += 16) {
				long var13 = aB();
				if ((var13 - var9) > 1000L) {
					this.a_("Preparing spawn area", (var5 * 100) / 625);
					var9 = var13;
				}

				++var5;
				var7.b.c((var8.n() + var11) >> 4, (var8.p() + var12) >> 4);
			}
		}

		s();
	}

	protected void a(String var1, class_axu var2) {
		File var3 = new File(var2.b(), "resources.zip");
		if (var3.isFile()) {
			this.a_("level://" + var1 + "/" + var3.getName(), "");
		}

	}

	public abstract boolean l();

	public abstract class_agr.class_a_in_class_agr m();

	public abstract class_ps n();

	public abstract boolean o();

	public abstract int p();

	public abstract boolean q();

	public abstract boolean r();

	protected void a_(String var1, int var2) {
		f = var1;
		g = var2;
		k.info(var1 + ": " + var2 + "%");
	}

	protected void s() {
		f = null;
		g = 0;
	}

	protected void a(boolean var1) {
		if (!O) {
			class_ll[] var2 = d;
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				class_ll var5 = var2[var4];
				if (var5 != null) {
					if (!var1) {
						k.info("Saving chunks for level \'" + var5.R().j() + "\'/" + var5.t.p().b());
					}

					try {
						var5.a(true, (class_oc) null);
					} catch (class_agp var7) {
						k.warn(var7.getMessage());
					}
				}
			}

		}
	}

	protected void t() {
		if (!O) {
			k.info("Stopping server");
			if (as() != null) {
				as().b();
			}

			if (w != null) {
				k.info("Saving players");
				w.j();
				w.u();
			}

			if (d != null) {
				k.info("Saving worlds");
				this.a(false);

				for (int var1 = 0; var1 < d.length; ++var1) {
					class_ll var2 = d[var1];
					var2.q();
				}
			}

			if (n.d()) {
				n.e();
			}

		}
	}

	public String u() {
		return u;
	}

	public void c(String var1) {
		u = var1;
	}

	public boolean v() {
		return x;
	}

	public void w() {
		x = false;
	}

	@Override
	public void run() {
		try {
			if (this.i()) {
				ac = aB();
				long var1 = 0L;
				r.a((new class_fa(F)));
				r.a(new class_ju.class_c_in_class_ju("15w34d", 61));
				this.a(r);

				while (x) {
					long var48 = aB();
					long var5 = var48 - ac;
					if ((var5 > 2000L) && ((ac - S) >= 15000L)) {
						k.warn("Can\'t keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", new Object[] { Long.valueOf(var5), Long.valueOf(var5 / 50L) });
						var5 = 2000L;
						S = ac;
					}

					if (var5 < 0L) {
						k.warn("Time ran backwards! Did the system time change?");
						var5 = 0L;
					}

					var1 += var5;
					ac = var48;
					if (d[0].g()) {
						C();
						var1 = 0L;
					} else {
						while (var1 > 50L) {
							var1 -= 50L;
							C();
						}
					}

					Thread.sleep(Math.max(1L, 50L - var1));
					R = true;
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

			File var3 = new File(new File(A(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-server.txt");
			if (var2.a(var3)) {
				k.error("This crash report has been saved to: " + var3.getAbsolutePath());
			} else {
				k.error("We were unable to save this crash report to disk.");
			}

			this.a(var2);
		} finally {
			try {
				y = true;
				t();
			} catch (Throwable var44) {
				k.error("Exception stopping the server", var44);
			} finally {
				B();
			}

		}

	}

	public void a(class_ju var1) {
		File var2 = this.d("server-icon.png");
		if (!var2.exists()) {
			var2 = aa().b(W(), "icon.png");
		}

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
				k.error("Couldn\'t load server icon", var9);
			} finally {
				var3.release();
			}
		}

	}

	public File A() {
		return new File(".");
	}

	protected void a(class_b var1) {
	}

	protected void B() {
	}

	protected void C() {
		long var1 = System.nanoTime();
		++z;
		if (U) {
			U = false;
			c.a = true;
			c.a();
		}

		c.a("root");
		D();
		if ((var1 - Y) >= 5000000000L) {
			Y = var1;
			r.a(new class_ju.class_a_in_class_ju(L(), K()));
			GameProfile[] var3 = new GameProfile[Math.min(K(), 12)];
			int var4 = class_oa.a(s, 0, K() - var3.length);

			for (int var5 = 0; var5 < var3.length; ++var5) {
				var3[var5] = ((class_lm) w.v().get(var4 + var5)).cl();
			}

			Collections.shuffle(Arrays.asList(var3));
			r.b().a(var3);
		}

		if ((z % 900) == 0) {
			c.a("save");
			w.j();
			this.a(true);
			c.b();
		}

		c.a("tallying");
		h[z % 100] = System.nanoTime() - var1;
		c.b();
		c.a("snooper");
		if (!n.d() && (z > 100)) {
			n.a();
		}

		if ((z % 6000) == 0) {
			n.b();
		}

		c.b();
		c.b();
	}

	public void D() {
		c.a("jobs");
		Queue var1 = j;
		synchronized (j) {
			while (!j.isEmpty()) {
				class_g.a((FutureTask) j.poll(), k);
			}
		}

		c.c("levels");

		int var10;
		for (var10 = 0; var10 < d.length; ++var10) {
			long var2 = System.nanoTime();
			if ((var10 == 0) || E()) {
				class_ll var4 = d[var10];
				c.a(var4.R().j());
				if ((z % 20) == 0) {
					c.a("timeSync");
					w.a((new class_hv(var4.M(), var4.N(), var4.S().b("doDaylightCycle"))), var4.t.p().a());
					c.b();
				}

				c.a("tick");

				class_b var6;
				try {
					var4.d();
				} catch (Throwable var8) {
					var6 = class_b.a(var8, "Exception ticking world");
					var4.a(var6);
					throw new class_e(var6);
				}

				try {
					var4.k();
				} catch (Throwable var7) {
					var6 = class_b.a(var7, "Exception ticking world entities");
					var4.a(var6);
					throw new class_e(var6);
				}

				c.b();
				c.a("tracker");
				var4.u().a();
				c.b();
				c.b();
			}

			i[var10][z % 100] = System.nanoTime() - var2;
		}

		c.c("connection");
		as().c();
		c.c("players");
		w.e();
		c.c("tickables");

		for (var10 = 0; var10 < p.size(); ++var10) {
			((class_ks) p.get(var10)).c();
		}

		c.b();
	}

	public boolean E() {
		return true;
	}

	public void a(class_ks var1) {
		p.add(var1);
	}

	public static void main(String[] var0) {
		Bootstrap.c();

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
				String var10 = var8 == (var0.length - 1) ? null : var0[var8 + 1];
				boolean var11 = false;
				if (!var9.equals("nogui") && !var9.equals("--nogui")) {
					if (var9.equals("--port") && (var10 != null)) {
						var11 = true;

						try {
							var7 = Integer.parseInt(var10);
						} catch (NumberFormatException var13) {
							;
						}
					} else if (var9.equals("--singleplayer") && (var10 != null)) {
						var11 = true;
						var2 = var10;
					} else if (var9.equals("--universe") && (var10 != null)) {
						var11 = true;
						var3 = var10;
					} else if (var9.equals("--world") && (var10 != null)) {
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

			final class_ku var15 = new class_ku(new File(var3), class_op.a());
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
				var15.aT();
			}

			var15.F();
			Runtime.getRuntime().addShutdownHook(new Thread("Server Shutdown Thread") {
				@Override
				public void run() {
					var15.t();
				}
			});
		} catch (Exception var14) {
			k.fatal("Failed to start the minecraft server", var14);
		}

	}

	public void F() {
		ab = new Thread(this, "Server thread");
		ab.start();
	}

	public File d(String var1) {
		return new File(A(), var1);
	}

	public void e(String var1) {
		k.info(var1);
	}

	public void f(String var1) {
		k.warn(var1);
	}

	public class_ll a(int var1) {
		return var1 == -1 ? d[1] : (var1 == 1 ? d[2] : d[0]);
	}

	public String G() {
		return u;
	}

	public int H() {
		return v;
	}

	public String I() {
		return F;
	}

	public String J() {
		return "15w34d";
	}

	public int K() {
		return w.o();
	}

	public int L() {
		return w.p();
	}

	public String[] M() {
		return w.f();
	}

	public GameProfile[] N() {
		return w.g();
	}

	public boolean O() {
		return false;
	}

	public void g(String var1) {
		k.error(var1);
	}

	public void h(String var1) {
		if (O()) {
			k.info(var1);
		}

	}

	public String getServerModName() {
		return "vanilla";
	}

	public class_b b(class_b var1) {
		var1.g().a("Profiler Position", new Callable() {
			public String a() throws Exception {
				return c.a ? c.c() : "N/A (disabled)";
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		if (w != null) {
			var1.g().a("Player Count", new Callable() {
				public String a() {
					return w.o() + " / " + w.p() + "; " + w.v();
				}

				// $FF: synthetic method
				@Override
				public Object call() throws Exception {
					return this.a();
				}
			});
		}

		return var1;
	}

	public List a(ICommandListener var1, String var2, class_cj var3, boolean var4) {
		ArrayList var5 = Lists.newArrayList();
		boolean var6 = var2.startsWith("/");
		if (var6) {
			var2 = var2.substring(1);
		}

		if (!var6 && !var4) {
			String[] var13 = var2.split(" ", -1);
			String var14 = var13[var13.length - 1];
			String[] var15 = w.f();
			int var16 = var15.length;

			for (int var11 = 0; var11 < var16; ++var11) {
				String var12 = var15[var11];
				if (CommandAbstract.a(var14, var12)) {
					var5.add(var12);
				}
			}

			return var5;
		} else {
			boolean var7 = !var2.contains(" ");
			List var8 = b.a(var1, var2, var3);
			if (var8 != null) {
				Iterator var9 = var8.iterator();

				while (var9.hasNext()) {
					String var10 = (String) var9.next();
					if (var7) {
						var5.add("/" + var10);
					} else {
						var5.add(var10);
					}
				}
			}

			return var5;
		}
	}

	public static MinecraftServer P() {
		return l;
	}

	public boolean Q() {
		return o != null;
	}

	@Override
	public String e_() {
		return "Server";
	}

	@Override
	public void a(class_eu var1) {
		k.info(var1.c());
	}

	@Override
	public boolean a(int var1, String var2) {
		return true;
	}

	public class_l R() {
		return b;
	}

	public KeyPair S() {
		return I;
	}

	public int T() {
		return v;
	}

	public void b(int var1) {
		v = var1;
	}

	public String U() {
		return J;
	}

	public void i(String var1) {
		J = var1;
	}

	public boolean V() {
		return J != null;
	}

	public String W() {
		return K;
	}

	public void j(String var1) {
		K = var1;
	}

	public void a(KeyPair var1) {
		I = var1;
	}

	public void a(class_ps var1) {
		for (int var2 = 0; var2 < d.length; ++var2) {
			class_ll var3 = d[var2];
			if (var3 != null) {
				if (var3.R().s()) {
					var3.R().a(class_ps.d);
					var3.a(true, true);
				} else if (V()) {
					var3.R().a(var1);
					var3.a(var3.ac() != class_ps.a, true);
				} else {
					var3.R().a(var1);
					var3.a(Y(), B);
				}
			}
		}

	}

	protected boolean Y() {
		return true;
	}

	public boolean Z() {
		return M;
	}

	public void b(boolean var1) {
		M = var1;
	}

	public void c(boolean var1) {
		N = var1;
	}

	public class_axw aa() {
		return m;
	}

	public void ac() {
		O = true;
		aa().d();

		for (int var1 = 0; var1 < d.length; ++var1) {
			class_ll var2 = d[var1];
			if (var2 != null) {
				var2.q();
			}
		}

		aa().e(d[0].Q().g());
		w();
	}

	public String ad() {
		return P;
	}

	public String ae() {
		return Q;
	}

	public void a_(String var1, String var2) {
		P = var1;
		Q = var2;
	}

	@Override
	public void a(class_qd var1) {
		var1.a("whitelist_enabled", Boolean.valueOf(false));
		var1.a("whitelist_count", Integer.valueOf(0));
		if (w != null) {
			var1.a("players_current", Integer.valueOf(K()));
			var1.a("players_max", Integer.valueOf(L()));
			var1.a("players_seen", Integer.valueOf(w.q().length));
		}

		var1.a("uses_auth", Boolean.valueOf(A));
		var1.a("gui_state", au() ? "enabled" : "disabled");
		var1.a("run_time", Long.valueOf(((aB() - var1.g()) / 60L) * 1000L));
		var1.a("avg_tick_ms", Integer.valueOf((int) (class_oa.a(h) * 1.0E-6D)));
		int var2 = 0;
		if (d != null) {
			for (int var3 = 0; var3 < d.length; ++var3) {
				if (d[var3] != null) {
					class_ll var4 = d[var3];
					class_axt var5 = var4.R();
					var1.a("world[" + var2 + "][dimension]", Integer.valueOf(var4.t.p().a()));
					var1.a("world[" + var2 + "][mode]", var5.q());
					var1.a("world[" + var2 + "][difficulty]", var4.ac());
					var1.a("world[" + var2 + "][hardcore]", Boolean.valueOf(var5.s()));
					var1.a("world[" + var2 + "][generator_name]", var5.t().a());
					var1.a("world[" + var2 + "][generator_version]", Integer.valueOf(var5.t().d()));
					var1.a("world[" + var2 + "][height]", Integer.valueOf(G));
					var1.a("world[" + var2 + "][chunks_loaded]", Integer.valueOf(var4.P().g()));
					++var2;
				}
			}
		}

		var1.a("worlds", Integer.valueOf(var2));
	}

	@Override
	public void b(class_qd var1) {
		var1.b("singleplayer", Boolean.valueOf(V()));
		var1.b("server_brand", getServerModName());
		var1.b("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
		var1.b("dedicated", Boolean.valueOf(ag()));
	}

	@Override
	public boolean af() {
		return true;
	}

	public abstract boolean ag();

	public boolean ah() {
		return A;
	}

	public void d(boolean var1) {
		A = var1;
	}

	public boolean ai() {
		return B;
	}

	public void e(boolean var1) {
		B = var1;
	}

	public boolean aj() {
		return C;
	}

	public abstract boolean ak();

	public void f(boolean var1) {
		C = var1;
	}

	public boolean al() {
		return D;
	}

	public void g(boolean var1) {
		D = var1;
	}

	public boolean am() {
		return E;
	}

	public void h(boolean var1) {
		E = var1;
	}

	public abstract boolean an();

	public String ao() {
		return F;
	}

	public void l(String var1) {
		F = var1;
	}

	public int ap() {
		return G;
	}

	public void c(int var1) {
		G = var1;
	}

	public boolean aq() {
		return y;
	}

	public class_me ar() {
		return w;
	}

	public void a(class_me var1) {
		w = var1;
	}

	public void a(class_agr.class_a_in_class_agr var1) {
		for (int var2 = 0; var2 < d.length; ++var2) {
			P().d[var2].R().a(var1);
		}

	}

	public class_ls as() {
		return q;
	}

	public boolean au() {
		return false;
	}

	public abstract String a(class_agr.class_a_in_class_agr var1, boolean var2);

	public int av() {
		return z;
	}

	public void aw() {
		U = true;
	}

	@Override
	public class_cj c() {
		return class_cj.a;
	}

	@Override
	public class_aym d() {
		return new class_aym(0.0D, 0.0D, 0.0D);
	}

	@Override
	public class_ago e() {
		return d[0];
	}

	@Override
	public Entity f() {
		return null;
	}

	public int ay() {
		return 16;
	}

	public boolean a(class_ago var1, class_cj var2, class_yu var3) {
		return false;
	}

	public void i(boolean var1) {
		V = var1;
	}

	public boolean az() {
		return V;
	}

	public Proxy aA() {
		return e;
	}

	public static long aB() {
		return System.currentTimeMillis();
	}

	public int aC() {
		return H;
	}

	public void d(int var1) {
		H = var1;
	}

	@Override
	public class_eu f_() {
		return new class_fa(e_());
	}

	public boolean aD() {
		return true;
	}

	public MinecraftSessionService aF() {
		return X;
	}

	public GameProfileRepository aG() {
		return Z;
	}

	public class_ma aH() {
		return aa;
	}

	public class_ju aI() {
		return r;
	}

	public void aJ() {
		Y = 0L;
	}

	public Entity a(UUID var1) {
		class_ll[] var2 = d;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_ll var5 = var2[var4];
			if (var5 != null) {
				Entity var6 = var5.a(var1);
				if (var6 != null) {
					return var6;
				}
			}
		}

		return null;
	}

	@Override
	public boolean s_() {
		return P().d[0].S().b("sendCommandFeedback");
	}

	@Override
	public void a(class_n.class_a_in_class_n var1, int var2) {
	}

	public int aK() {
		return 29999984;
	}

	public ListenableFuture a(Callable var1) {
		Validate.notNull(var1);
		if (!aL() && !aq()) {
			ListenableFutureTask var2 = ListenableFutureTask.create(var1);
			Queue var3 = j;
			synchronized (j) {
				j.add(var2);
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

	@Override
	public ListenableFuture a(Runnable var1) {
		Validate.notNull(var1);
		return this.a(Executors.callable(var1));
	}

	@Override
	public boolean aL() {
		return Thread.currentThread() == ab;
	}

	public int aM() {
		return 256;
	}

	public long aN() {
		return ac;
	}

	public Thread aO() {
		return ab;
	}

	public class_oo aP() {
		return t;
	}
}
