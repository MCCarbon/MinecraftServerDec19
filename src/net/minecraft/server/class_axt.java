package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

import com.google.common.collect.Maps;

public class class_axt {
	private String b;
	private int c;
	private boolean d;
	public static final class_ps a;
	private long e;
	private class_agt f;
	private String g;
	private int h;
	private int i;
	private int j;
	private long k;
	private long l;
	private long m;
	private long n;
	private class_dn o;
	private int p;
	private String q;
	private int r;
	private int s;
	private boolean t;
	private int u;
	private boolean v;
	private int w;
	private class_agr.class_a_in_class_agr x;
	private boolean y;
	private boolean z;
	private boolean A;
	private boolean B;
	private class_ps C;
	private boolean D;
	private double E;
	private double F;
	private double G;
	private long H;
	private double I;
	private double J;
	private double K;
	private int L;
	private int M;
	private final Map N;
	private class_agm O;

	protected class_axt() {
		f = class_agt.b;
		g = "";
		E = 0.0D;
		F = 0.0D;
		G = 6.0E7D;
		H = 0L;
		I = 0.0D;
		J = 5.0D;
		K = 0.2D;
		L = 5;
		M = 15;
		N = Maps.newEnumMap(class_ard.class);
		O = new class_agm();
	}

	public class_axt(class_dn var1) {
		f = class_agt.b;
		g = "";
		E = 0.0D;
		F = 0.0D;
		G = 6.0E7D;
		H = 0L;
		I = 0.0D;
		J = 5.0D;
		K = 0.2D;
		L = 5;
		M = 15;
		N = Maps.newEnumMap(class_ard.class);
		O = new class_agm();
		class_dn var2;
		if (var1.b("Version", 10)) {
			var2 = var1.o("Version");
			b = var2.l("Name");
			c = var2.h("Id");
			d = var2.p("Snapshot");
		}

		e = var1.i("RandomSeed");
		if (var1.b("generatorName", 8)) {
			String var5 = var1.l("generatorName");
			f = class_agt.a(var5);
			if (f == null) {
				f = class_agt.b;
			} else if (f.f()) {
				int var3 = 0;
				if (var1.b("generatorVersion", 99)) {
					var3 = var1.h("generatorVersion");
				}

				f = f.a(var3);
			}

			if (var1.b("generatorOptions", 8)) {
				g = var1.l("generatorOptions");
			}
		}

		x = class_agr.class_a_in_class_agr.a(var1.h("GameType"));
		if (var1.b("MapFeatures", 99)) {
			y = var1.p("MapFeatures");
		} else {
			y = true;
		}

		h = var1.h("SpawnX");
		i = var1.h("SpawnY");
		j = var1.h("SpawnZ");
		k = var1.i("Time");
		if (var1.b("DayTime", 99)) {
			l = var1.i("DayTime");
		} else {
			l = k;
		}

		m = var1.i("LastPlayed");
		n = var1.i("SizeOnDisk");
		q = var1.l("LevelName");
		r = var1.h("version");
		s = var1.h("clearWeatherTime");
		u = var1.h("rainTime");
		t = var1.p("raining");
		w = var1.h("thunderTime");
		v = var1.p("thundering");
		z = var1.p("hardcore");
		if (var1.b("initialized", 99)) {
			B = var1.p("initialized");
		} else {
			B = true;
		}

		if (var1.b("allowCommands", 99)) {
			A = var1.p("allowCommands");
		} else {
			A = x == class_agr.class_a_in_class_agr.c;
		}

		if (var1.b("Player", 10)) {
			o = var1.o("Player");
			p = o.h("Dimension");
		}

		if (var1.b("GameRules", 10)) {
			O.a(var1.o("GameRules"));
		}

		if (var1.b("Difficulty", 99)) {
			C = class_ps.a(var1.f("Difficulty"));
		}

		if (var1.b("DifficultyLocked", 1)) {
			D = var1.p("DifficultyLocked");
		}

		if (var1.b("BorderCenterX", 99)) {
			E = var1.k("BorderCenterX");
		}

		if (var1.b("BorderCenterZ", 99)) {
			F = var1.k("BorderCenterZ");
		}

		if (var1.b("BorderSize", 99)) {
			G = var1.k("BorderSize");
		}

		if (var1.b("BorderSizeLerpTime", 99)) {
			H = var1.i("BorderSizeLerpTime");
		}

		if (var1.b("BorderSizeLerpTarget", 99)) {
			I = var1.k("BorderSizeLerpTarget");
		}

		if (var1.b("BorderSafeZone", 99)) {
			J = var1.k("BorderSafeZone");
		}

		if (var1.b("BorderDamagePerBlock", 99)) {
			K = var1.k("BorderDamagePerBlock");
		}

		if (var1.b("BorderWarningBlocks", 99)) {
			L = var1.h("BorderWarningBlocks");
		}

		if (var1.b("BorderWarningTime", 99)) {
			M = var1.h("BorderWarningTime");
		}

		if (var1.b("DimensionData", 10)) {
			var2 = var1.o("DimensionData");
			Iterator var6 = var2.c().iterator();

			while (var6.hasNext()) {
				String var4 = (String) var6.next();
				N.put(class_ard.a(Integer.parseInt(var4)), var2.o(var4));
			}
		}

	}

	public class_axt(class_agr var1, String var2) {
		f = class_agt.b;
		g = "";
		E = 0.0D;
		F = 0.0D;
		G = 6.0E7D;
		H = 0L;
		I = 0.0D;
		J = 5.0D;
		K = 0.2D;
		L = 5;
		M = 15;
		N = Maps.newEnumMap(class_ard.class);
		O = new class_agm();
		this.a(var1);
		q = var2;
		C = a;
		B = false;
	}

	public void a(class_agr var1) {
		e = var1.d();
		x = var1.e();
		y = var1.g();
		z = var1.f();
		f = var1.h();
		g = var1.j();
		A = var1.i();
	}

	public class_axt(class_axt var1) {
		f = class_agt.b;
		g = "";
		E = 0.0D;
		F = 0.0D;
		G = 6.0E7D;
		H = 0L;
		I = 0.0D;
		J = 5.0D;
		K = 0.2D;
		L = 5;
		M = 15;
		N = Maps.newEnumMap(class_ard.class);
		O = new class_agm();
		e = var1.e;
		f = var1.f;
		g = var1.g;
		x = var1.x;
		y = var1.y;
		h = var1.h;
		i = var1.i;
		j = var1.j;
		k = var1.k;
		l = var1.l;
		m = var1.m;
		n = var1.n;
		o = var1.o;
		p = var1.p;
		q = var1.q;
		r = var1.r;
		u = var1.u;
		t = var1.t;
		w = var1.w;
		v = var1.v;
		z = var1.z;
		A = var1.A;
		B = var1.B;
		O = var1.O;
		C = var1.C;
		D = var1.D;
		E = var1.E;
		F = var1.F;
		G = var1.G;
		H = var1.H;
		I = var1.I;
		J = var1.J;
		K = var1.K;
		M = var1.M;
		L = var1.L;
	}

	public class_dn a(class_dn var1) {
		if (var1 == null) {
			var1 = o;
		}

		class_dn var2 = new class_dn();
		this.a(var2, var1);
		return var2;
	}

	private void a(class_dn var1, class_dn var2) {
		class_dn var3 = new class_dn();
		var3.a("Name", "15w34d");
		var3.a("Id", 117);
		var3.a("Snapshot", true);
		var1.a("Version", var3);
		var1.a("DataVersion", 117);
		var1.a("RandomSeed", e);
		var1.a("generatorName", f.a());
		var1.a("generatorVersion", f.d());
		var1.a("generatorOptions", g);
		var1.a("GameType", x.a());
		var1.a("MapFeatures", y);
		var1.a("SpawnX", h);
		var1.a("SpawnY", i);
		var1.a("SpawnZ", j);
		var1.a("Time", k);
		var1.a("DayTime", l);
		var1.a("SizeOnDisk", n);
		var1.a("LastPlayed", MinecraftServer.aB());
		var1.a("LevelName", q);
		var1.a("version", r);
		var1.a("clearWeatherTime", s);
		var1.a("rainTime", u);
		var1.a("raining", t);
		var1.a("thunderTime", w);
		var1.a("thundering", v);
		var1.a("hardcore", z);
		var1.a("allowCommands", A);
		var1.a("initialized", B);
		var1.a("BorderCenterX", E);
		var1.a("BorderCenterZ", F);
		var1.a("BorderSize", G);
		var1.a("BorderSizeLerpTime", H);
		var1.a("BorderSafeZone", J);
		var1.a("BorderDamagePerBlock", K);
		var1.a("BorderSizeLerpTarget", I);
		var1.a("BorderWarningBlocks", (double) L);
		var1.a("BorderWarningTime", (double) M);
		if (C != null) {
			var1.a("Difficulty", (byte) C.a());
		}

		var1.a("DifficultyLocked", D);
		var1.a("GameRules", O.a());
		class_dn var4 = new class_dn();
		Iterator var5 = N.entrySet().iterator();

		while (var5.hasNext()) {
			Entry var6 = (Entry) var5.next();
			var4.a(String.valueOf(((class_ard) var6.getKey()).a()), (class_eb) var6.getValue());
		}

		var1.a("DimensionData", var4);
		if (var2 != null) {
			var1.a("Player", var2);
		}

	}

	public long a() {
		return e;
	}

	public int b() {
		return h;
	}

	public int c() {
		return i;
	}

	public int d() {
		return j;
	}

	public long e() {
		return k;
	}

	public long f() {
		return l;
	}

	public class_dn h() {
		return o;
	}

	public void b(long var1) {
		k = var1;
	}

	public void c(long var1) {
		l = var1;
	}

	public void a(class_cj var1) {
		h = var1.n();
		i = var1.o();
		j = var1.p();
	}

	public String j() {
		return q;
	}

	public void a(String var1) {
		q = var1;
	}

	public int k() {
		return r;
	}

	public void e(int var1) {
		r = var1;
	}

	public int z() {
		return s;
	}

	public void i(int var1) {
		s = var1;
	}

	public boolean m() {
		return v;
	}

	public void a(boolean var1) {
		v = var1;
	}

	public int n() {
		return w;
	}

	public void f(int var1) {
		w = var1;
	}

	public boolean o() {
		return t;
	}

	public void b(boolean var1) {
		t = var1;
	}

	public int p() {
		return u;
	}

	public void g(int var1) {
		u = var1;
	}

	public class_agr.class_a_in_class_agr q() {
		return x;
	}

	public boolean r() {
		return y;
	}

	public void f(boolean var1) {
		y = var1;
	}

	public void a(class_agr.class_a_in_class_agr var1) {
		x = var1;
	}

	public boolean s() {
		return z;
	}

	public void g(boolean var1) {
		z = var1;
	}

	public class_agt t() {
		return f;
	}

	public void a(class_agt var1) {
		f = var1;
	}

	public String A() {
		return g;
	}

	public boolean u() {
		return A;
	}

	public void c(boolean var1) {
		A = var1;
	}

	public boolean v() {
		return B;
	}

	public void d(boolean var1) {
		B = var1;
	}

	public class_agm w() {
		return O;
	}

	public double B() {
		return E;
	}

	public double C() {
		return F;
	}

	public double D() {
		return G;
	}

	public void a(double var1) {
		G = var1;
	}

	public long E() {
		return H;
	}

	public void e(long var1) {
		H = var1;
	}

	public double F() {
		return I;
	}

	public void b(double var1) {
		I = var1;
	}

	public void c(double var1) {
		F = var1;
	}

	public void d(double var1) {
		E = var1;
	}

	public double G() {
		return J;
	}

	public void e(double var1) {
		J = var1;
	}

	public double H() {
		return K;
	}

	public void f(double var1) {
		K = var1;
	}

	public int I() {
		return L;
	}

	public int J() {
		return M;
	}

	public void j(int var1) {
		L = var1;
	}

	public void k(int var1) {
		M = var1;
	}

	public class_ps x() {
		return C;
	}

	public void a(class_ps var1) {
		C = var1;
	}

	public boolean y() {
		return D;
	}

	public void e(boolean var1) {
		D = var1;
	}

	public void a(class_c var1) {
		var1.a("Level seed", new Callable() {
			public String a() throws Exception {
				return String.valueOf(class_axt.this.a());
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a("Level generator", new Callable() {
			public String a() throws Exception {
				return String.format("ID %02d - %s, ver %d. Features enabled: %b", new Object[] { Integer.valueOf(f.g()), f.a(), Integer.valueOf(f.d()), Boolean.valueOf(y) });
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a("Level generator options", new Callable() {
			public String a() throws Exception {
				return g;
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a("Level spawn location", new Callable() {
			public String a() throws Exception {
				return class_c.a(h, i, j);
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a("Level time", new Callable() {
			public String a() throws Exception {
				return String.format("%d game time, %d day time", new Object[] { Long.valueOf(k), Long.valueOf(l) });
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a("Level dimension", new Callable() {
			public String a() throws Exception {
				return String.valueOf(p);
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a("Level storage version", new Callable() {
			public String a() throws Exception {
				String var1 = "Unknown?";

				try {
					switch (r) {
						case 19132:
							var1 = "McRegion";
							break;
						case 19133:
							var1 = "Anvil";
					}
				} catch (Throwable var3) {
					;
				}

				return String.format("0x%05X - %s", new Object[] { Integer.valueOf(r), var1 });
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a("Level weather", new Callable() {
			public String a() throws Exception {
				return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", new Object[] { Integer.valueOf(u), Boolean.valueOf(t), Integer.valueOf(w), Boolean.valueOf(v) });
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a("Level game mode", new Callable() {
			public String a() throws Exception {
				return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", new Object[] { x.b(), Integer.valueOf(x.a()), Boolean.valueOf(z), Boolean.valueOf(A) });
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
	}

	public class_dn a(class_ard var1) {
		class_dn var2 = (class_dn) N.get(var1);
		return var2 == null ? new class_dn() : var2;
	}

	public void a(class_ard var1, class_dn var2) {
		N.put(var1, var2);
	}

	static {
		a = class_ps.c;
	}
}
