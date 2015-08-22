package net.minecraft.server;

import java.util.Collection;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_ayt extends class_axj {
	private static final Logger b = LogManager.getLogger();
	private class_ays c;
	private class_dn d;

	public class_ayt() {
		this("scoreboard");
	}

	public class_ayt(String var1) {
		super(var1);
	}

	public void a(class_ays var1) {
		c = var1;
		if (d != null) {
			this.a(d);
		}

	}

	@Override
	public void a(class_dn var1) {
		if (c == null) {
			d = var1;
		} else {
			this.b(var1.c("Objectives", 10));
			this.c(var1.c("PlayerScores", 10));
			if (var1.b("DisplaySlots", 10)) {
				this.c(var1.o("DisplaySlots"));
			}

			if (var1.b("Teams", 9)) {
				this.a(var1.c("Teams", 10));
			}

		}
	}

	protected void a(class_du var1) {
		for (int var2 = 0; var2 < var1.c(); ++var2) {
			class_dn var3 = var1.b(var2);
			String var4 = var3.l("Name");
			if (var4.length() > 16) {
				var4 = var4.substring(0, 16);
			}

			class_ayp var5 = c.e(var4);
			String var6 = var3.l("DisplayName");
			if (var6.length() > 32) {
				var6 = var6.substring(0, 32);
			}

			var5.a(var6);
			if (var3.b("TeamColor", 8)) {
				var5.a(EnumChatFormat.getByName(var3.l("TeamColor")));
			}

			var5.b(var3.l("Prefix"));
			var5.c(var3.l("Suffix"));
			if (var3.b("AllowFriendlyFire", 99)) {
				var5.a(var3.p("AllowFriendlyFire"));
			}

			if (var3.b("SeeFriendlyInvisibles", 99)) {
				var5.b(var3.p("SeeFriendlyInvisibles"));
			}

			class_ayu.class_a_in_class_ayu var7;
			if (var3.b("NameTagVisibility", 8)) {
				var7 = class_ayu.class_a_in_class_ayu.a(var3.l("NameTagVisibility"));
				if (var7 != null) {
					var5.a(var7);
				}
			}

			if (var3.b("DeathMessageVisibility", 8)) {
				var7 = class_ayu.class_a_in_class_ayu.a(var3.l("DeathMessageVisibility"));
				if (var7 != null) {
					var5.b(var7);
				}
			}

			this.a(var5, var3.c("Players", 8));
		}

	}

	protected void a(class_ayp var1, class_du var2) {
		for (int var3 = 0; var3 < var2.c(); ++var3) {
			c.a(var2.g(var3), var1.b());
		}

	}

	protected void c(class_dn var1) {
		for (int var2 = 0; var2 < 19; ++var2) {
			if (var1.b("slot_" + var2, 8)) {
				String var3 = var1.l("slot_" + var2);
				class_ayo var4 = c.b(var3);
				c.a(var2, var4);
			}
		}

	}

	protected void b(class_du var1) {
		for (int var2 = 0; var2 < var1.c(); ++var2) {
			class_dn var3 = var1.b(var2);
			class_ayy var4 = (class_ayy) class_ayy.a.get(var3.l("CriteriaName"));
			if (var4 != null) {
				String var5 = var3.l("Name");
				if (var5.length() > 16) {
					var5 = var5.substring(0, 16);
				}

				class_ayo var6 = c.a(var5, var4);
				var6.a(var3.l("DisplayName"));
				var6.a(class_ayy.class_a_in_class_ayy.a(var3.l("RenderType")));
			}
		}

	}

	protected void c(class_du var1) {
		for (int var2 = 0; var2 < var1.c(); ++var2) {
			class_dn var3 = var1.b(var2);
			class_ayo var4 = c.b(var3.l("Objective"));
			String var5 = var3.l("Name");
			if (var5.length() > 40) {
				var5 = var5.substring(0, 40);
			}

			class_ayq var6 = c.c(var5, var4);
			var6.c(var3.h("Score"));
			if (var3.e("Locked")) {
				var6.a(var3.p("Locked"));
			}
		}

	}

	@Override
	public void b(class_dn var1) {
		if (c == null) {
			b.warn("Tried to save scoreboard without having a scoreboard...");
		} else {
			var1.a("Objectives", this.b());
			var1.a("PlayerScores", e());
			var1.a("Teams", this.a());
			this.d(var1);
		}
	}

	protected class_du a() {
		class_du var1 = new class_du();
		Collection var2 = c.g();
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			class_ayp var4 = (class_ayp) var3.next();
			class_dn var5 = new class_dn();
			var5.a("Name", var4.b());
			var5.a("DisplayName", var4.c());
			if (var4.l().getId() >= 0) {
				var5.a("TeamColor", var4.l().e());
			}

			var5.a("Prefix", var4.e());
			var5.a("Suffix", var4.f());
			var5.a("AllowFriendlyFire", var4.g());
			var5.a("SeeFriendlyInvisibles", var4.h());
			var5.a("NameTagVisibility", var4.i().e);
			var5.a("DeathMessageVisibility", var4.j().e);
			class_du var6 = new class_du();
			Iterator var7 = var4.d().iterator();

			while (var7.hasNext()) {
				String var8 = (String) var7.next();
				var6.a((new class_ea(var8)));
			}

			var5.a("Players", var6);
			var1.a(var5);
		}

		return var1;
	}

	protected void d(class_dn var1) {
		class_dn var2 = new class_dn();
		boolean var3 = false;

		for (int var4 = 0; var4 < 19; ++var4) {
			class_ayo var5 = c.a(var4);
			if (var5 != null) {
				var2.a("slot_" + var4, var5.b());
				var3 = true;
			}
		}

		if (var3) {
			var1.a("DisplaySlots", var2);
		}

	}

	protected class_du b() {
		class_du var1 = new class_du();
		Collection var2 = c.c();
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			class_ayo var4 = (class_ayo) var3.next();
			if (var4.c() != null) {
				class_dn var5 = new class_dn();
				var5.a("Name", var4.b());
				var5.a("CriteriaName", var4.c().a());
				var5.a("DisplayName", var4.d());
				var5.a("RenderType", var4.e().a());
				var1.a(var5);
			}
		}

		return var1;
	}

	protected class_du e() {
		class_du var1 = new class_du();
		Collection var2 = c.e();
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			class_ayq var4 = (class_ayq) var3.next();
			if (var4.d() != null) {
				class_dn var5 = new class_dn();
				var5.a("Name", var4.e());
				var5.a("Objective", var4.d().b());
				var5.a("Score", var4.c());
				var5.a("Locked", var4.g());
				var1.a(var5);
			}
		}

		return var1;
	}
}
