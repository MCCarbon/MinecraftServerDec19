package net.minecraft.server;

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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;

public abstract class class_me {
	public static final File a = new File("banned-players.json");
	public static final File b = new File("banned-ips.json");
	public static final File c = new File("ops.json");
	public static final File d = new File("whitelist.json");
	private static final Logger f = LogManager.getLogger();
	private static final SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");
	private final MinecraftServer h;
	private final List i = Lists.newArrayList();
	private final Map j = Maps.newHashMap();
	private final class_mj k;
	private final class_mb l;
	private final class_mf m;
	private final class_ml n;
	private final Map o;
	private class_ayc p;
	private boolean q;
	protected int e;
	private int r;
	private class_agr.class_a_in_class_agr s;
	private boolean t;
	private int u;

	public class_me(MinecraftServer var1) {
		k = new class_mj(a);
		l = new class_mb(b);
		m = new class_mf(c);
		n = new class_ml(d);
		o = Maps.newHashMap();
		h = var1;
		k.a(false);
		l.a(false);
		e = 8;
	}

	public void a(class_ek var1, class_lm var2) {
		GameProfile var3 = var2.cl();
		class_ma var4 = h.aH();
		GameProfile var5 = var4.a(var3.getId());
		String var6 = var5 == null ? var3.getName() : var5.getName();
		var4.a(var3);
		class_dn var7 = this.a(var2);
		var2.a(h.a(var2.am));
		var2.c.a((class_ll) var2.o);
		String var8 = "local";
		if (var1.b() != null) {
			var8 = var1.b().toString();
		}

		f.info(var2.e_() + "[" + var8 + "] logged in with entity id " + var2.G() + " at (" + var2.s + ", " + var2.t + ", " + var2.u + ")");
		class_ll var9 = h.a(var2.am);
		class_axt var10 = var9.R();
		class_cj var11 = var9.O();
		this.a(var2, (class_lm) null, var9);
		class_lt var12 = new class_lt(h, var1, var2);
		var12.a((new PacketPlayOutLogin(var2.G(), var2.c.b(), var10.s(), var9.t.p().a(), var9.ac(), p(), var10.t(), var9.S().b("reducedDebugInfo"))));
		var12.a((new class_gi("MC|Brand", (new PacketDataSerializer(Unpooled.buffer())).a(this.c().getServerModName()))));
		var12.a((new class_fx(var10.x(), var10.y())));
		var12.a((new PacketPlayOutSpawnPosition(var11)));
		var12.a((new class_gy(var2.bI)));
		var12.a((new PacketPlayOutHeldItemSlot(var2.bq.d)));
		int var13 = this.h(var3) ? m.a(var3) : 0;
		var13 = h.V() && h.d[0].R().u() ? 4 : var13;
		var13 = t ? 4 : var13;
		this.a(var2, var13);
		var2.B().d();
		var2.B().b(var2);
		this.a((class_kq) var9.ab(), var2);
		h.aJ();
		class_fb var14;
		if (!var2.e_().equalsIgnoreCase(var6)) {
			var14 = new class_fb("multiplayer.player.joined.renamed", new Object[] { var2.f_(), var6 });
		} else {
			var14 = new class_fb("multiplayer.player.joined", new Object[] { var2.f_() });
		}

		var14.b().a(EnumChatFormat.YELLOW);
		this.a(var14);
		this.c(var2);
		var12.a(var2.s, var2.t, var2.u, var2.y, var2.z);
		this.b(var2, var9);
		if (!h.ad().isEmpty()) {
			var2.a(h.ad(), h.ae());
		}

		Iterator var15 = var2.bs().iterator();

		while (var15.hasNext()) {
			class_qr var16 = (class_qr) var15.next();
			var12.a((new class_ic(var2.G(), var16)));
		}

		var2.g_();
		if ((var7 != null) && var7.b("Riding", 10)) {
			Entity var17 = EntityTypes.a(var7.o("Riding"), var9);
			if (var17 != null) {
				var17.n = true;
				var9.a(var17);
				var2.a(var17);
				var17.n = false;
			}
		}

	}

	protected void a(class_kq var1, class_lm var2) {
		HashSet var3 = Sets.newHashSet();
		Iterator var4 = var1.g().iterator();

		while (var4.hasNext()) {
			class_ayp var5 = (class_ayp) var4.next();
			var2.a.a((new class_hs(var5, 0)));
		}

		for (int var9 = 0; var9 < 19; ++var9) {
			class_ayo var10 = var1.a(var9);
			if ((var10 != null) && !var3.contains(var10)) {
				List var6 = var1.d(var10);
				Iterator var7 = var6.iterator();

				while (var7.hasNext()) {
					Packet var8 = (Packet) var7.next();
					var2.a.a(var8);
				}

				var3.add(var10);
			}
		}

	}

	public void a(class_ll[] var1) {
		p = var1[0].Q().e();
		var1[0].ah().a(new class_aqe() {
			@Override
			public void a(class_aqg var1, double var2) {
				class_me.this.a((new class_hh(var1, class_hh.class_a_in_class_hh.a)));
			}

			@Override
			public void a(class_aqg var1, double var2, double var4, long var6) {
				class_me.this.a((new class_hh(var1, class_hh.class_a_in_class_hh.b)));
			}

			@Override
			public void a(class_aqg var1, double var2, double var4) {
				class_me.this.a((new class_hh(var1, class_hh.class_a_in_class_hh.c)));
			}

			@Override
			public void a(class_aqg var1, int var2) {
				class_me.this.a((new class_hh(var1, class_hh.class_a_in_class_hh.e)));
			}

			@Override
			public void b(class_aqg var1, int var2) {
				class_me.this.a((new class_hh(var1, class_hh.class_a_in_class_hh.f)));
			}

			@Override
			public void b(class_aqg var1, double var2) {
			}

			@Override
			public void c(class_aqg var1, double var2) {
			}
		});
	}

	public void a(class_lm var1, class_ll var2) {
		class_ll var3 = var1.v();
		if (var2 != null) {
			var2.v().c(var1);
		}

		var3.v().a(var1);
		var3.b.c((int) var1.s >> 4, (int) var1.u >> 4);
	}

	public int d() {
		return class_li.b(s());
	}

	public class_dn a(class_lm var1) {
		class_dn var2 = h.d[0].R().h();
		class_dn var3;
		if (var1.e_().equals(h.U()) && (var2 != null)) {
			var3 = h.aP().a(class_om.b, var2);
			var1.f(var3);
			f.debug("loading single player");
		} else {
			var3 = p.b(var1);
		}

		return var3;
	}

	protected void b(class_lm var1) {
		p.a(var1);
		class_nc var2 = (class_nc) o.get(var1.aQ());
		if (var2 != null) {
			var2.b();
		}

	}

	public void c(class_lm var1) {
		i.add(var1);
		j.put(var1.aQ(), var1);
		this.a((new class_ha(class_ha.class_a_in_class_ha.a, new class_lm[] { var1 })));
		class_ll var2 = h.a(var1.am);
		var2.a(var1);
		this.a(var1, (class_ll) null);

		for (int var3 = 0; var3 < i.size(); ++var3) {
			class_lm var4 = (class_lm) i.get(var3);
			var1.a.a((new class_ha(class_ha.class_a_in_class_ha.a, new class_lm[] { var4 })));
		}

	}

	public void d(class_lm var1) {
		var1.v().v().d(var1);
	}

	public void e(class_lm var1) {
		var1.b(StatisticList.f);
		this.b(var1);
		class_ll var2 = var1.v();
		if (var1.m != null) {
			var2.f(var1.m);
			f.debug("removing player mount");
		}

		var2.e(var1);
		var2.v().c(var1);
		i.remove(var1);
		UUID var3 = var1.aQ();
		class_lm var4 = (class_lm) j.get(var3);
		if (var4 == var1) {
			j.remove(var3);
			o.remove(var3);
		}

		this.a((new class_ha(class_ha.class_a_in_class_ha.e, new class_lm[] { var1 })));
	}

	public String a(SocketAddress var1, GameProfile var2) {
		String var4;
		if (k.a(var2)) {
			class_mk var5 = (class_mk) k.b((Object) var2);
			var4 = "You are banned from this server!\nReason: " + var5.d();
			if (var5.c() != null) {
				var4 = var4 + "\nYour ban will be removed on " + g.format(var5.c());
			}

			return var4;
		} else if (!this.e(var2)) {
			return "You are not white-listed on this server!";
		} else if (l.a(var1)) {
			class_mc var3 = l.b(var1);
			var4 = "Your IP address is banned from this server!\nReason: " + var3.d();
			if (var3.c() != null) {
				var4 = var4 + "\nYour ban will be removed on " + g.format(var3.c());
			}

			return var4;
		} else {
			return (i.size() >= e) && !this.f(var2) ? "The server is full!" : null;
		}
	}

	public class_lm g(GameProfile var1) {
		UUID var2 = class_yu.a(var1);
		ArrayList var3 = Lists.newArrayList();

		for (int var4 = 0; var4 < i.size(); ++var4) {
			class_lm var5 = (class_lm) i.get(var4);
			if (var5.aQ().equals(var2)) {
				var3.add(var5);
			}
		}

		class_lm var7 = (class_lm) j.get(var1.getId());
		if ((var7 != null) && !var3.contains(var7)) {
			var3.add(var7);
		}

		Iterator var8 = var3.iterator();

		while (var8.hasNext()) {
			class_lm var6 = (class_lm) var8.next();
			var6.a.c("You logged in from another location");
		}

		Object var9;
		if (h.Z()) {
			var9 = new class_le(h.a(0));
		} else {
			var9 = new class_ln(h.a(0));
		}

		return new class_lm(h, h.a(0), var1, (class_ln) var9);
	}

	public class_lm a(class_lm var1, int var2, boolean var3) {
		var1.v().u().b(var1);
		var1.v().u().b((Entity) var1);
		var1.v().v().c(var1);
		i.remove(var1);
		h.a(var1.am).f(var1);
		class_cj var4 = var1.cp();
		boolean var5 = var1.cq();
		var1.am = var2;
		Object var6;
		if (h.Z()) {
			var6 = new class_le(h.a(var1.am));
		} else {
			var6 = new class_ln(h.a(var1.am));
		}

		class_lm var7 = new class_lm(h, h.a(var1.am), var1.cl(), (class_ln) var6);
		var7.a = var1.a;
		var7.a(var1, var3);
		var7.d(var1.G());
		var7.o(var1);
		var7.a(var1.bW());
		Iterator var8 = var1.H().iterator();

		while (var8.hasNext()) {
			String var9 = (String) var8.next();
			var7.a(var9);
		}

		class_ll var10 = h.a(var1.am);
		this.a(var7, var1, var10);
		class_cj var11;
		if (var4 != null) {
			var11 = class_yu.a(h.a(var1.am), var4, var5);
			if (var11 != null) {
				var7.b(var11.n() + 0.5F, var11.o() + 0.1F, var11.p() + 0.5F, 0.0F, 0.0F);
				var7.a(var4, var5);
			} else {
				var7.a.a((new class_gn(0, 0.0F)));
			}
		}

		var10.b.c((int) var7.s >> 4, (int) var7.u >> 4);

		while (!var10.a(var7, var7.aX()).isEmpty() && (var7.t < 256.0D)) {
			var7.b(var7.s, var7.t + 1.0D, var7.u);
		}

		var7.a.a((new PacketPlayOutRespawn(var7.am, var7.o.ac(), var7.o.R().t(), var7.c.b())));
		var11 = var10.O();
		var7.a.a(var7.s, var7.t, var7.u, var7.y, var7.z);
		var7.a.a((new PacketPlayOutSpawnPosition(var11)));
		var7.a.a((new class_hp(var7.bL, var7.bK, var7.bJ)));
		this.b(var7, var10);
		var10.v().a(var7);
		var10.a(var7);
		i.add(var7);
		j.put(var7.aQ(), var7);
		var7.g_();
		var7.c(var7.bu());
		return var7;
	}

	public void a(class_lm var1, int var2, class_cj var3) {
		int var4 = var1.am;
		class_ll var5 = h.a(var1.am);
		var1.am = var2;
		class_ll var6 = h.a(var1.am);
		var1.a.a((new PacketPlayOutRespawn(var1.am, var1.o.ac(), var1.o.R().t(), var1.c.b())));
		var5.f(var1);
		var1.I = false;
		if (var3 == null) {
			this.a(var1, var4, var5, var6);
		} else if (var1.al()) {
			var5.a(var1, false);
			var1.a(var3, var1.y, var1.z);
			var6.a(var1);
			var6.a(var1, false);
			var1.a(var6);
		}

		this.a(var1, var5);
		var1.a.a(var1.s, var1.t, var1.u, var1.y, var1.z);
		var1.c.a(var6);
		this.b(var1, var6);
		this.f(var1);
		Iterator var7 = var1.bs().iterator();

		while (var7.hasNext()) {
			class_qr var8 = (class_qr) var7.next();
			var1.a.a((new class_ic(var1.G(), var8)));
		}

	}

	public void a(Entity var1, int var2, class_ll var3, class_ll var4) {
		double var5 = var1.s;
		double var7 = var1.u;
		double var9 = 8.0D;
		float var11 = var1.y;
		var3.B.a("moving");
		if (var1.am == -1) {
			var5 = MathHelper.a(var5 / var9, var4.ah().b() + 16.0D, var4.ah().d() - 16.0D);
			var7 = MathHelper.a(var7 / var9, var4.ah().c() + 16.0D, var4.ah().e() - 16.0D);
			var1.b(var5, var1.t, var7, var1.y, var1.z);
			if (var1.al()) {
				var3.a(var1, false);
			}
		} else if (var1.am == 0) {
			var5 = MathHelper.a(var5 * var9, var4.ah().b() + 16.0D, var4.ah().d() - 16.0D);
			var7 = MathHelper.a(var7 * var9, var4.ah().c() + 16.0D, var4.ah().e() - 16.0D);
			var1.b(var5, var1.t, var7, var1.y, var1.z);
			if (var1.al()) {
				var3.a(var1, false);
			}
		} else {
			class_cj var12;
			if (var2 == 1) {
				var12 = var4.O();
			} else {
				var12 = var4.o();
			}

			var5 = var12.n();
			var1.t = var12.o();
			var7 = var12.p();
			var1.b(var5, var1.t, var7, 90.0F, 0.0F);
			if (var1.al()) {
				var3.a(var1, false);
			}
		}

		var3.B.b();
		if (var2 != 1) {
			var3.B.a("placing");
			var5 = MathHelper.a((int) var5, -29999872, 29999872);
			var7 = MathHelper.a((int) var7, -29999872, 29999872);
			if (var1.al()) {
				var1.b(var5, var1.t, var7, var1.y, var1.z);
				var4.w().a(var1, var11);
				var4.a(var1);
				var4.a(var1, false);
			}

			var3.B.b();
		}

		var1.a(var4);
	}

	public void e() {
		if (++u > 600) {
			this.a((new class_ha(class_ha.class_a_in_class_ha.c, i)));
			u = 0;
		}

	}

	public void a(Packet var1) {
		for (int var2 = 0; var2 < i.size(); ++var2) {
			((class_lm) i.get(var2)).a.a(var1);
		}

	}

	public void a(Packet var1, int var2) {
		for (int var3 = 0; var3 < i.size(); ++var3) {
			class_lm var4 = (class_lm) i.get(var3);
			if (var4.am == var2) {
				var4.a.a(var1);
			}
		}

	}

	public void a(class_yu var1, IChatBaseComponent var2) {
		class_ayu var3 = var1.aE();
		if (var3 != null) {
			Collection var4 = var3.d();
			Iterator var5 = var4.iterator();

			while (var5.hasNext()) {
				String var6 = (String) var5.next();
				class_lm var7 = this.a(var6);
				if ((var7 != null) && (var7 != var1)) {
					var7.a(var2);
				}
			}

		}
	}

	public void b(class_yu var1, IChatBaseComponent var2) {
		class_ayu var3 = var1.aE();
		if (var3 == null) {
			this.a(var2);
		} else {
			for (int var4 = 0; var4 < i.size(); ++var4) {
				class_lm var5 = (class_lm) i.get(var4);
				if (var5.aE() != var3) {
					var5.a(var2);
				}
			}

		}
	}

	public String b(boolean var1) {
		String var2 = "";
		ArrayList var3 = Lists.newArrayList((Iterable) i);

		for (int var4 = 0; var4 < var3.size(); ++var4) {
			if (var4 > 0) {
				var2 = var2 + ", ";
			}

			var2 = var2 + ((class_lm) var3.get(var4)).e_();
			if (var1) {
				var2 = var2 + " (" + ((class_lm) var3.get(var4)).aQ().toString() + ")";
			}
		}

		return var2;
	}

	public String[] f() {
		String[] var1 = new String[i.size()];

		for (int var2 = 0; var2 < i.size(); ++var2) {
			var1[var2] = ((class_lm) i.get(var2)).e_();
		}

		return var1;
	}

	public GameProfile[] g() {
		GameProfile[] var1 = new GameProfile[i.size()];

		for (int var2 = 0; var2 < i.size(); ++var2) {
			var1[var2] = ((class_lm) i.get(var2)).cl();
		}

		return var1;
	}

	public class_mj h() {
		return k;
	}

	public class_mb i() {
		return l;
	}

	public void a(GameProfile var1) {
		int var2 = h.p();
		m.a((new class_mg(var1, h.p(), m.b(var1))));
		this.a(this.a(var1.getId()), var2);
	}

	public void b(GameProfile var1) {
		m.c(var1);
		this.a(this.a(var1.getId()), 0);
	}

	private void a(class_lm var1, int var2) {
		if ((var1 != null) && (var1.a != null)) {
			byte var3 = var2 <= 0 ? 24 : (var2 >= 4 ? 28 : (byte) (24 + var2));
			var1.a.a((new PacketPlayOutEntityStatus(var1, var3)));
		}

	}

	public boolean e(GameProfile var1) {
		return !q || m.d(var1) || n.d(var1);
	}

	public boolean h(GameProfile var1) {
		return m.d(var1) || (h.V() && h.d[0].R().u() && h.U().equalsIgnoreCase(var1.getName())) || t;
	}

	public class_lm a(String var1) {
		Iterator var2 = i.iterator();

		class_lm var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (class_lm) var2.next();
		} while (!var3.e_().equalsIgnoreCase(var1));

		return var3;
	}

	public void a(double var1, double var3, double var5, double var7, int var9, Packet var10) {
		this.a((class_yu) null, var1, var3, var5, var7, var9, var10);
	}

	public void a(class_yu var1, double var2, double var4, double var6, double var8, int var10, Packet var11) {
		for (int var12 = 0; var12 < i.size(); ++var12) {
			class_lm var13 = (class_lm) i.get(var12);
			if ((var13 != var1) && (var13.am == var10)) {
				double var14 = var2 - var13.s;
				double var16 = var4 - var13.t;
				double var18 = var6 - var13.u;
				if (((var14 * var14) + (var16 * var16) + (var18 * var18)) < (var8 * var8)) {
					var13.a.a(var11);
				}
			}
		}

	}

	public void j() {
		for (int var1 = 0; var1 < i.size(); ++var1) {
			this.b((class_lm) i.get(var1));
		}

	}

	public void d(GameProfile var1) {
		n.a((new class_mm(var1)));
	}

	public void c(GameProfile var1) {
		n.c(var1);
	}

	public class_ml k() {
		return n;
	}

	public String[] l() {
		return n.a();
	}

	public class_mf m() {
		return m;
	}

	public String[] n() {
		return m.a();
	}

	public void a() {
	}

	public void b(class_lm var1, class_ll var2) {
		class_aqg var3 = h.d[0].ah();
		var1.a.a((new class_hh(var3, class_hh.class_a_in_class_hh.d)));
		var1.a.a((new PacketPlayOutUpdateTime(var2.M(), var2.N(), var2.S().b("doDaylightCycle"))));
		if (var2.U()) {
			var1.a.a((new class_gn(1, 0.0F)));
			var1.a.a((new class_gn(7, var2.j(1.0F))));
			var1.a.a((new class_gn(8, var2.h(1.0F))));
		}

	}

	public void f(class_lm var1) {
		var1.a(var1.br);
		var1.s();
		var1.a.a((new PacketPlayOutHeldItemSlot(var1.bq.d)));
	}

	public int o() {
		return i.size();
	}

	public int p() {
		return e;
	}

	public String[] q() {
		return h.d[0].Q().e().f();
	}

	public boolean r() {
		return q;
	}

	public void a(boolean var1) {
		q = var1;
	}

	public List b(String var1) {
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = i.iterator();

		while (var3.hasNext()) {
			class_lm var4 = (class_lm) var3.next();
			if (var4.x().equals(var1)) {
				var2.add(var4);
			}
		}

		return var2;
	}

	public int s() {
		return r;
	}

	public MinecraftServer c() {
		return h;
	}

	public class_dn t() {
		return null;
	}

	private void a(class_lm var1, class_lm var2, class_ago var3) {
		if (var2 != null) {
			var1.c.a(var2.c.b());
		} else if (s != null) {
			var1.c.a(s);
		}

		var1.c.b(var3.R().q());
	}

	public void u() {
		for (int var1 = 0; var1 < i.size(); ++var1) {
			((class_lm) i.get(var1)).a.c("Server closed");
		}

	}

	public void a(IChatBaseComponent var1, boolean var2) {
		h.a(var1);
		int var3 = var2 ? 1 : 0;
		this.a((new PacketPlayOutChat(var1, (byte) var3)));
	}

	public void a(IChatBaseComponent var1) {
		this.a(var1, true);
	}

	public class_nc a(class_yu var1) {
		UUID var2 = var1.aQ();
		class_nc var3 = var2 == null ? null : (class_nc) o.get(var2);
		if (var3 == null) {
			File var4 = new File(h.a(0).Q().b(), "stats");
			File var5 = new File(var4, var2.toString() + ".json");
			if (!var5.exists()) {
				File var6 = new File(var4, var1.e_() + ".json");
				if (var6.exists() && var6.isFile()) {
					var6.renameTo(var5);
				}
			}

			var3 = new class_nc(h, var5);
			var3.a();
			o.put(var2, var3);
		}

		return var3;
	}

	public void a(int var1) {
		r = var1;
		if (h.d != null) {
			class_ll[] var2 = h.d;
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				class_ll var5 = var2[var4];
				if (var5 != null) {
					var5.v().a(var1);
				}
			}

		}
	}

	public List v() {
		return i;
	}

	public class_lm a(UUID var1) {
		return (class_lm) j.get(var1);
	}

	public boolean f(GameProfile var1) {
		return false;
	}
}
