package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;

public class class_ll extends class_ago implements class_pl {
	private static final Logger a = LogManager.getLogger();
	private final MinecraftServer H;
	private final class_lg I;
	private final class_li J;
	private final Set K = Sets.newHashSet();
	private final TreeSet L = new TreeSet();
	private final Map M = Maps.newHashMap();
	public class_lk b;
	public boolean c;
	private boolean N;
	private int O;
	private final class_agw P;
	private final class_agv Q = new class_agv();
	protected final class_uw d = new class_uw(this);
	private class_ll.class_a_in_class_ll[] R = new class_ll.class_a_in_class_ll[] { new class_ll.class_a_in_class_ll(null), new class_ll.class_a_in_class_ll(null) };
	private int S;
	private static final List T;
	private List U = Lists.newArrayList();

	public class_ll(MinecraftServer var1, class_axu var2, class_axt var3, int var4, class_ob var5) {
		super(var2, var3, class_ard.a(var4).d(), var5, false);
		H = var1;
		I = new class_lg(this);
		J = new class_li(this);
		t.a(this);
		v = this.m();
		P = new class_agw(this);
		this.E();
		F();
		ah().a(var1.aK());
	}

	@Override
	public class_ago b() {
		z = new class_aye(w);
		String var1 = class_ux.a(t);
		class_ux var2 = (class_ux) z.a(class_ux.class, var1);
		if (var2 == null) {
			A = new class_ux(this);
			z.a(var1, A);
		} else {
			A = var2;
			A.a(this);
		}

		C = new class_kq(H);
		class_ayt var3 = (class_ayt) z.a(class_ayt.class, "scoreboard");
		if (var3 == null) {
			var3 = new class_ayt();
			z.a("scoreboard", var3);
		}

		var3.a(C);
		((class_kq) C).a(var3);
		ah().c(x.B(), x.C());
		ah().c(x.H());
		ah().b(x.G());
		ah().c(x.I());
		ah().b(x.J());
		if (x.E() > 0L) {
			ah().a(x.D(), x.F(), x.E());
		} else {
			ah().a(x.D());
		}

		return this;
	}

	@Override
	public void d() {
		super.d();
		if (R().s() && (ac() != class_ps.d)) {
			R().a(class_ps.d);
		}

		t.k().b();
		if (this.g()) {
			if (S().b("doDaylightCycle")) {
				long var1 = x.f() + 24000L;
				x.c(var1 - (var1 % 24000L));
			}

			this.f();
		}

		B.a("mobSpawner");
		if (S().b("doMobSpawning") && (x.t() != class_agt.g)) {
			Q.a(this, E, F, (x.e() % 400L) == 0L);
		}

		B.c("chunkSource");
		v.d();
		int var3 = this.a(1.0F);
		if (var3 != ad()) {
			this.c(var3);
		}

		x.b(x.e() + 1L);
		if (S().b("doDaylightCycle")) {
			x.c(x.f() + 1L);
		}

		B.c("tickPending");
		this.a(false);
		B.c("tickBlocks");
		this.j();
		B.c("chunkMap");
		J.c();
		B.c("village");
		A.a();
		d.a();
		B.c("portalForcer");
		P.a(M());
		B.b();
		al();
	}

	public class_ahb.class_c_in_class_ahb a(class_ri var1, class_cj var2) {
		List var3 = P().a(var1, var2);
		return (var3 != null) && !var3.isEmpty() ? (class_ahb.class_c_in_class_ahb) class_oi.a(s, var3) : null;
	}

	public boolean a(class_ri var1, class_ahb.class_c_in_class_ahb var2, class_cj var3) {
		List var4 = P().a(var1, var3);
		return (var4 != null) && !var4.isEmpty() ? var4.contains(var2) : false;
	}

	@Override
	public void e() {
		N = false;
		if (!j.isEmpty()) {
			int var1 = 0;
			int var2 = 0;
			Iterator var3 = j.iterator();

			while (var3.hasNext()) {
				class_yu var4 = (class_yu) var3.next();
				if (var4.w()) {
					++var1;
				} else if (var4.bQ()) {
					++var2;
				}
			}

			N = (var2 > 0) && (var2 >= (j.size() - var1));
		}

	}

	protected void f() {
		N = false;
		Iterator var1 = j.iterator();

		while (var1.hasNext()) {
			class_yu var2 = (class_yu) var1.next();
			if (var2.bQ()) {
				var2.a(false, false, true);
			}
		}

		this.c();
	}

	private void c() {
		x.g(0);
		x.b(false);
		x.f(0);
		x.a(false);
	}

	public boolean g() {
		if (N && !D) {
			Iterator var1 = j.iterator();

			class_yu var2;
			do {
				if (!var1.hasNext()) {
					return true;
				}

				var2 = (class_yu) var1.next();
			} while (var2.w() || var2.cn());

			return false;
		} else {
			return false;
		}
	}

	protected void i() {
		B.a("playerCheckLight");
		if (!j.isEmpty()) {
			int var1 = s.nextInt(j.size());
			class_yu var2 = (class_yu) j.get(var1);
			int var3 = (MathHelper.c(var2.s) + s.nextInt(11)) - 5;
			int var4 = (MathHelper.c(var2.t) + s.nextInt(11)) - 5;
			int var5 = (MathHelper.c(var2.u) + s.nextInt(11)) - 5;
			this.x(new class_cj(var3, var4, var5));
		}

		B.b();
	}

	@Override
	protected void j() {
		this.i();
		if (x.t() == class_agt.g) {
			Iterator var19 = J.b();

			while (var19.hasNext()) {
				((class_aqn) var19.next()).b(false);
			}

		} else {
			int var1 = S().c("randomTickSpeed");
			boolean var2 = U();
			boolean var3 = T();
			B.a("pollingChunks");

			for (Iterator var4 = J.b(); var4.hasNext(); B.b()) {
				B.a("getChunk");
				class_aqn var5 = (class_aqn) var4.next();
				int var6 = var5.b * 16;
				int var7 = var5.c * 16;
				B.c("checkNextLight");
				var5.n();
				B.c("tickChunk");
				var5.b(false);
				B.c("thunder");
				int var8;
				class_cj var9;
				if (var2 && var3 && (s.nextInt(100000) == 0)) {
					m = (m * 3) + 1013904223;
					var8 = m >> 2;
					var9 = this.a(new class_cj(var6 + (var8 & 15), 0, var7 + ((var8 >> 8) & 15)));
					if (C(var9)) {
						this.d(new class_xc(this, var9.n(), var9.o(), var9.p()));
					}
				}

				B.c("iceandsnow");
				if (s.nextInt(16) == 0) {
					m = (m * 3) + 1013904223;
					var8 = m >> 2;
					var9 = this.q(new class_cj(var6 + (var8 & 15), 0, var7 + ((var8 >> 8) & 15)));
					class_cj var10 = var9.b();
					if (this.w(var10)) {
						this.a(var10, Blocks.ICE.S());
					}

					if (var2 && this.f(var9, true)) {
						this.a(var9, Blocks.SNOW_LAYER.S());
					}

					if (var2 && this.b(var10).e()) {
						this.p(var10).c().i(this, var10);
					}
				}

				B.c("tickBlocks");
				if (var1 > 0) {
					class_aqo[] var20 = var5.h();
					int var21 = var20.length;

					for (int var22 = 0; var22 < var21; ++var22) {
						class_aqo var11 = var20[var22];
						if ((var11 != class_aqn.a) && var11.b()) {
							for (int var12 = 0; var12 < var1; ++var12) {
								m = (m * 3) + 1013904223;
								int var13 = m >> 2;
							int var14 = var13 & 15;
							int var15 = (var13 >> 8) & 15;
							int var16 = (var13 >> 16) & 15;
							class_apn var17 = var11.a(var14, var16, var15);
							Block var18 = var17.c();
							B.a("randomTick");
							if (var18.A()) {
								var18.a(this, new class_cj(var14 + var6, var16 + var11.d(), var15 + var7), var17, s);
							}

							B.b();
							}
						}
					}
				}
			}

			B.b();
		}
	}

	protected class_cj a(class_cj var1) {
		class_cj var2 = this.q(var1);
		class_ayk var3 = (new class_ayk(var2, new class_cj(var2.n(), W(), var2.p()))).b(3.0D, 3.0D, 3.0D);
		List var4 = this.a(class_rg.class, var3, new Predicate() {
			public boolean a(class_rg var1) {
				return (var1 != null) && var1.al() && class_ll.this.i(var1.c());
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((class_rg) var1);
			}
		});
		return !var4.isEmpty() ? ((class_rg) var4.get(s.nextInt(var4.size()))).c() : var2;
	}

	@Override
	public boolean a(class_cj var1, Block var2) {
		class_agz var3 = new class_agz(var1, var2);
		return U.contains(var3);
	}

	@Override
	public boolean b(class_cj var1, Block var2) {
		class_agz var3 = new class_agz(var1, var2);
		return K.contains(var3);
	}

	@Override
	public void a(class_cj var1, Block var2, int var3) {
		this.a(var1, var2, var3, 0);
	}

	@Override
	public void a(class_cj var1, Block var2, int var3, int var4) {
		class_agz var5 = new class_agz(var1, var2);
		byte var6 = 0;
		if (e && (var2.v() != class_avq.a)) {
			if (var2.P()) {
				var6 = 8;
				if (this.a(var5.a.a(-var6, -var6, -var6), var5.a.a(var6, var6, var6))) {
					class_apn var7 = this.p(var5.a);
					if ((var7.c().v() != class_avq.a) && (var7.c() == var5.a())) {
						var7.c().b(this, var5.a, var7, s);
					}
				}

				return;
			}

			var3 = 1;
		}

		if (this.a(var1.a(-var6, -var6, -var6), var1.a(var6, var6, var6))) {
			if (var2.v() != class_avq.a) {
				var5.a(var3 + x.e());
				var5.a(var4);
			}

			if (!K.contains(var5)) {
				K.add(var5);
				L.add(var5);
			}
		}

	}

	@Override
	public void b(class_cj var1, Block var2, int var3, int var4) {
		class_agz var5 = new class_agz(var1, var2);
		var5.a(var4);
		if (var2.v() != class_avq.a) {
			var5.a(var3 + x.e());
		}

		if (!K.contains(var5)) {
			K.add(var5);
			L.add(var5);
		}

	}

	@Override
	public void k() {
		if (j.isEmpty()) {
			if (O++ >= 300) {
				return;
			}
		} else {
			this.l();
		}

		t.r();
		super.k();
	}

	public void l() {
		O = 0;
	}

	@Override
	public boolean a(boolean var1) {
		if (x.t() == class_agt.g) {
			return false;
		} else {
			int var2 = L.size();
			if (var2 != K.size()) {
				throw new IllegalStateException("TickNextTick list out of synch");
			} else {
				if (var2 > 1000) {
					var2 = 1000;
				}

				B.a("cleaning");

				class_agz var4;
				for (int var3 = 0; var3 < var2; ++var3) {
					var4 = (class_agz) L.first();
					if (!var1 && (var4.b > x.e())) {
						break;
					}

					L.remove(var4);
					K.remove(var4);
					U.add(var4);
				}

				B.b();
				B.a("ticking");
				Iterator var11 = U.iterator();

				while (var11.hasNext()) {
					var4 = (class_agz) var11.next();
					var11.remove();
					byte var5 = 0;
					if (this.a(var4.a.a(-var5, -var5, -var5), var4.a.a(var5, var5, var5))) {
						class_apn var6 = this.p(var4.a);
						if ((var6.c().v() != class_avq.a) && Block.a(var6.c(), var4.a())) {
							try {
								var6.c().b(this, var4.a, var6, s);
							} catch (Throwable var10) {
								class_b var8 = class_b.a(var10, "Exception while ticking a block");
								class_c var9 = var8.a("Block being ticked");
								class_c.a(var9, var4.a, var6);
								throw new class_e(var8);
							}
						}
					} else {
						this.a(var4.a, var4.a(), 0);
					}
				}

				B.b();
				U.clear();
				return !L.isEmpty();
			}
		}
	}

	@Override
	public List a(class_aqn var1, boolean var2) {
		class_agi var3 = var1.k();
		int var4 = (var3.a << 4) - 2;
		int var5 = var4 + 16 + 2;
		int var6 = (var3.b << 4) - 2;
		int var7 = var6 + 16 + 2;
		return this.a(new class_aua(var4, 0, var6, var5, 256, var7), var2);
	}

	@Override
	public List a(class_aua var1, boolean var2) {
		ArrayList var3 = null;

		for (int var4 = 0; var4 < 2; ++var4) {
			Iterator var5;
			if (var4 == 0) {
				var5 = L.iterator();
			} else {
				var5 = U.iterator();
			}

			while (var5.hasNext()) {
				class_agz var6 = (class_agz) var5.next();
				class_cj var7 = var6.a;
				if ((var7.n() >= var1.a) && (var7.n() < var1.d) && (var7.p() >= var1.c) && (var7.p() < var1.f)) {
					if (var2) {
						K.remove(var6);
						var5.remove();
					}

					if (var3 == null) {
						var3 = Lists.newArrayList();
					}

					var3.add(var6);
				}
			}
		}

		return var3;
	}

	@Override
	public void a(Entity var1, boolean var2) {
		if (!aj() && ((var1 instanceof class_vc) || (var1 instanceof class_vq))) {
			var1.L();
		}

		if (!ai() && (var1 instanceof class_yo)) {
			var1.L();
		}

		super.a(var1, var2);
	}

	private boolean ai() {
		return H.aj();
	}

	private boolean aj() {
		return H.ai();
	}

	@Override
	protected class_aqk m() {
		class_aqt var1 = w.a(t);
		b = new class_lk(this, var1, t.c());
		return b;
	}

	public List a(int var1, int var2, int var3, int var4, int var5, int var6) {
		ArrayList var7 = Lists.newArrayList();

		for (int var8 = 0; var8 < h.size(); ++var8) {
			TileEntity var9 = (TileEntity) h.get(var8);
			class_cj var10 = var9.v();
			if ((var10.n() >= var1) && (var10.o() >= var2) && (var10.p() >= var3) && (var10.n() < var4) && (var10.o() < var5) && (var10.p() < var6)) {
				var7.add(var9);
			}
		}

		return var7;
	}

	@Override
	public boolean a(class_yu var1, class_cj var2) {
		return !H.a(this, var2, var1) && ah().a(var2);
	}

	@Override
	public void a(class_agr var1) {
		if (!x.v()) {
			try {
				this.b(var1);
				if (x.t() == class_agt.g) {
					ak();
				}

				super.a(var1);
			} catch (Throwable var6) {
				class_b var3 = class_b.a(var6, "Exception initializing level");

				try {
					this.a(var3);
				} catch (Throwable var5) {
					;
				}

				throw new class_e(var3);
			}

			x.d(true);
		}

	}

	private void ak() {
		x.f(false);
		x.c(true);
		x.b(false);
		x.a(false);
		x.i(1000000000);
		x.c(6000L);
		x.a(class_agr.class_a_in_class_agr.e);
		x.g(false);
		x.a(class_ps.a);
		x.e(true);
		S().a("doDaylightCycle", "false");
	}

	private void b(class_agr var1) {
		if (!t.e()) {
			x.a(class_cj.a.b(t.i()));
		} else if (x.t() == class_agt.g) {
			x.a(class_cj.a.a());
		} else {
			y = true;
			class_ahf var2 = t.k();
			List var3 = var2.a();
			Random var4 = new Random(L());
			class_cj var5 = var2.a(0, 0, 256, var3, var4);
			int var6 = 0;
			int var7 = t.i();
			int var8 = 0;
			if (var5 != null) {
				var6 = var5.n();
				var8 = var5.p();
			} else {
				a.warn("Unable to find spawn biome");
			}

			int var9 = 0;

			while (!t.a(var6, var8)) {
				var6 += var4.nextInt(64) - var4.nextInt(64);
				var8 += var4.nextInt(64) - var4.nextInt(64);
				++var9;
				if (var9 == 1000) {
					break;
				}
			}

			x.a(new class_cj(var6, var7, var8));
			y = false;
			if (var1.c()) {
				this.n();
			}

		}
	}

	protected void n() {
		class_ase var1 = new class_ase(T, 10);

		for (int var2 = 0; var2 < 10; ++var2) {
			int var3 = (x.b() + s.nextInt(6)) - s.nextInt(6);
			int var4 = (x.d() + s.nextInt(6)) - s.nextInt(6);
			class_cj var5 = this.r(new class_cj(var3, 0, var4)).a();
			if (var1.b(this, s, var5)) {
				break;
			}
		}

	}

	public class_cj o() {
		return t.h();
	}

	public void a(boolean var1, class_oc var2) throws class_agp {
		if (v.e()) {
			if (var2 != null) {
				var2.a("Saving level");
			}

			this.a();
			if (var2 != null) {
				var2.c("Saving chunks");
			}

			v.a(var1, var2);
			ArrayList var3 = Lists.newArrayList((Iterable) b.a());
			Iterator var4 = var3.iterator();

			while (var4.hasNext()) {
				class_aqn var5 = (class_aqn) var4.next();
				if ((var5 != null) && !J.a(var5.b, var5.c)) {
					b.b(var5.b, var5.c);
				}
			}

		}
	}

	public void p() {
		if (v.e()) {
			v.c();
		}
	}

	protected void a() throws class_agp {
		K();
		class_ll[] var1 = H.d;
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			class_ll var4 = var1[var3];
			if (var4 instanceof class_lf) {
				((class_lf) var4).c();
			}
		}

		x.a(ah().h());
		x.d(ah().f());
		x.c(ah().g());
		x.e(ah().m());
		x.f(ah().n());
		x.j(ah().q());
		x.k(ah().p());
		x.b(ah().j());
		x.e(ah().i());
		w.a(x, H.ar().t());
		z.a();
	}

	@Override
	public boolean a(Entity var1) {
		return !this.i(var1) ? false : super.a(var1);
	}

	@Override
	public void a(Collection var1) {
		ArrayList var2 = Lists.newArrayList((Iterable) var1);
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			Entity var4 = (Entity) var3.next();
			if (this.i(var4)) {
				f.add(var4);
				this.b(var4);
			}
		}

	}

	private boolean i(Entity var1) {
		if (var1.I) {
			a.warn("Tried to add entity " + EntityTypes.b(var1) + " but it was marked as removed already");
			return false;
		} else {
			UUID var2 = var1.aQ();
			if (M.containsKey(var2)) {
				if (g.contains(var1)) {
					a.warn("Tried to add entity " + EntityTypes.b(var1) + " with pending removal and duplicate UUID " + var2.toString());
					g.remove(var1);
				} else {
					if (!(var1 instanceof class_yu)) {
						return false;
					}

					a.warn("Force-added player with duplicate UUID " + var2.toString());
				}

				this.f(var1);
			}

			return true;
		}
	}

	@Override
	protected void b(Entity var1) {
		super.b(var1);
		l.a(var1.G(), var1);
		M.put(var1.aQ(), var1);
		Entity[] var2 = var1.aH();
		if (var2 != null) {
			for (int var3 = 0; var3 < var2.length; ++var3) {
				l.a(var2[var3].G(), var2[var3]);
			}
		}

	}

	@Override
	protected void c(Entity var1) {
		super.c(var1);
		l.d(var1.G());
		M.remove(var1.aQ());
		Entity[] var2 = var1.aH();
		if (var2 != null) {
			for (int var3 = 0; var3 < var2.length; ++var3) {
				l.d(var2[var3].G());
			}
		}

	}

	@Override
	public boolean d(Entity var1) {
		if (super.d(var1)) {
			H.ar().a(var1.s, var1.t, var1.u, 512.0D, t.p().a(), new class_fm(var1));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void a(Entity var1, byte var2) {
		this.u().b(var1, new class_gk(var1, var2));
	}

	@Override
	public class_agk a(Entity var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10) {
		class_agk var11 = new class_agk(this, var1, var2, var4, var6, var8, var9, var10);
		var11.a();
		var11.a(false);
		if (!var10) {
			var11.d();
		}

		Iterator var12 = j.iterator();

		while (var12.hasNext()) {
			class_yu var13 = (class_yu) var12.next();
			if (var13.e(var2, var4, var6) < 4096.0D) {
				((class_lm) var13).a.a((new class_gl(var2, var4, var6, var8, var11.e(), (class_aym) var11.b().get(var13))));
			}
		}

		return var11;
	}

	@Override
	public void c(class_cj var1, Block var2, int var3, int var4) {
		class_agg var5 = new class_agg(var1, var2, var3, var4);
		Iterator var6 = R[S].iterator();

		class_agg var7;
		do {
			if (!var6.hasNext()) {
				R[S].add(var5);
				return;
			}

			var7 = (class_agg) var6.next();
		} while (!var7.equals(var5));

	}

	private void al() {
		while (!R[S].isEmpty()) {
			int var1 = S;
			S ^= 1;
			Iterator var2 = R[var1].iterator();

			while (var2.hasNext()) {
				class_agg var3 = (class_agg) var2.next();
				if (this.a(var3)) {
					H.ar().a(var3.a().n(), var3.a().o(), var3.a().p(), 64.0D, t.p().a(), new class_fu(var3.a(), var3.d(), var3.b(), var3.c()));
				}
			}

			R[var1].clear();
		}

	}

	private boolean a(class_agg var1) {
		class_apn var2 = this.p(var1.a());
		return var2.c() == var1.d() ? var2.c().a(this, var1.a(), var2, var1.b(), var1.c()) : false;
	}

	public void q() {
		w.a();
	}

	@Override
	protected void r() {
		boolean var1 = U();
		super.r();
		if (o != p) {
			H.ar().a((new class_gn(7, p)), t.p().a());
		}

		if (q != r) {
			H.ar().a((new class_gn(8, r)), t.p().a());
		}

		if (var1 != U()) {
			if (var1) {
				H.ar().a((new class_gn(2, 0.0F)));
			} else {
				H.ar().a((new class_gn(1, 0.0F)));
			}

			H.ar().a((new class_gn(7, p)));
			H.ar().a((new class_gn(8, r)));
		}

	}

	public MinecraftServer t() {
		return H;
	}

	public class_lg u() {
		return I;
	}

	public class_li v() {
		return J;
	}

	public class_agw w() {
		return P;
	}

	public class_auy x() {
		return w.h();
	}

	public void a(class_cy var1, double var2, double var4, double var6, int var8, double var9, double var11, double var13, double var15, int... var17) {
		this.a(var1, false, var2, var4, var6, var8, var9, var11, var13, var15, var17);
	}

	public void a(class_cy var1, boolean var2, double var3, double var5, double var7, int var9, double var10, double var12, double var14, double var16, int... var18) {
		class_gs var19 = new class_gs(var1, var2, (float) var3, (float) var5, (float) var7, (float) var10, (float) var12, (float) var14, (float) var16, var9, var18);

		for (int var20 = 0; var20 < j.size(); ++var20) {
			class_lm var21 = (class_lm) j.get(var20);
			this.a(var21, var2, var3, var5, var7, var19);
		}

	}

	public void a(class_lm var1, class_cy var2, boolean var3, double var4, double var6, double var8, int var10, double var11, double var13, double var15, double var17, int... var19) {
		class_gs var20 = new class_gs(var2, var3, (float) var4, (float) var6, (float) var8, (float) var11, (float) var13, (float) var15, (float) var17, var10, var19);
		this.a(var1, var3, var4, var6, var8, var20);
	}

	private void a(class_lm var1, boolean var2, double var3, double var5, double var7, Packet var9) {
		class_cj var10 = var1.c();
		double var11 = var10.c(var3, var5, var7);
		if ((var11 <= 1024.0D) || (var2 && (var11 <= 262144.0D))) {
			var1.a.a(var9);
		}

	}

	public Entity a(UUID var1) {
		return (Entity) M.get(var1);
	}

	@Override
	public ListenableFuture a(Runnable var1) {
		return H.a(var1);
	}

	@Override
	public boolean aL() {
		return H.aL();
	}

	static {
		T = Lists.newArrayList((Object[]) (new class_oj[] { new class_oj(Items.A, 0, 1, 3, 10), new class_oj(Item.a(Blocks.PLANKS), 0, 1, 3, 10), new class_oj(Item.a(Blocks.LOG), 0, 1, 3, 10), new class_oj(Items.v, 0, 1, 1, 3), new class_oj(Items.r, 0, 1, 1, 5), new class_oj(Items.u, 0, 1, 1, 3), new class_oj(Items.q, 0, 1, 1, 5), new class_oj(Items.e, 0, 2, 3, 5), new class_oj(Items.R, 0, 2, 3, 3), new class_oj(Item.a(Blocks.LOG2), 0, 1, 3, 10) }));
	}

	static class class_a_in_class_ll extends ArrayList {
		private class_a_in_class_ll() {
		}

		// $FF: synthetic method
		class_a_in_class_ll(Object var1) {
			this();
		}
	}
}
