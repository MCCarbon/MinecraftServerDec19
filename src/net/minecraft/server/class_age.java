package net.minecraft.server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

public abstract class class_age implements class_m {
	private static final SimpleDateFormat a = new SimpleDateFormat("HH:mm:ss");
	private int b;
	private boolean c = true;
	private class_eu d = null;
	private String e = "";
	private String f = "@";
	private final class_n g = new class_n();

	public int j() {
		return b;
	}

	public void a(int var1) {
		b = var1;
	}

	public class_eu k() {
		return d;
	}

	public void a(class_dn var1) {
		var1.a("Command", e);
		var1.a("SuccessCount", b);
		var1.a("CustomName", f);
		var1.a("TrackOutput", c);
		if ((d != null) && c) {
			var1.a("LastOutput", class_eu.class_a_in_class_eu.a(d));
		}

		g.b(var1);
	}

	public void b(class_dn var1) {
		e = var1.l("Command");
		b = var1.h("SuccessCount");
		if (var1.b("CustomName", 8)) {
			f = var1.l("CustomName");
		}

		if (var1.b("TrackOutput", 1)) {
			c = var1.p("TrackOutput");
		}

		if (var1.b("LastOutput", 8) && c) {
			d = class_eu.class_a_in_class_eu.a(var1.l("LastOutput"));
		}

		g.a(var1);
	}

	@Override
	public boolean a(int var1, String var2) {
		return var1 <= 2;
	}

	public void a(String var1) {
		e = var1;
		b = 0;
	}

	public String l() {
		return e;
	}

	public void a(class_ago var1) {
		if (var1.D) {
			b = 0;
		} else {
			MinecraftServer var2 = MinecraftServer.P();
			if ((var2 != null) && var2.Q() && var2.an()) {
				class_l var3 = var2.R();

				try {
					d = null;
					b = var3.a(this, e);
				} catch (Throwable var7) {
					class_b var5 = class_b.a(var7, "Executing command block");
					class_c var6 = var5.a("Command to be executed");
					var6.a("Command", new Callable() {
						public String a() throws Exception {
							return class_age.this.l();
						}

						// $FF: synthetic method
						@Override
						public Object call() throws Exception {
							return this.a();
						}
					});
					var6.a("Name", new Callable() {
						public String a() throws Exception {
							return class_age.this.e_();
						}

						// $FF: synthetic method
						@Override
						public Object call() throws Exception {
							return this.a();
						}
					});
					throw new class_e(var5);
				}
			} else {
				b = 0;
			}

		}
	}

	@Override
	public String e_() {
		return f;
	}

	@Override
	public class_eu f_() {
		return new class_fa(e_());
	}

	public void b(String var1) {
		f = var1;
	}

	@Override
	public void a(class_eu var1) {
		if (c && (e() != null) && !e().D) {
			d = (new class_fa("[" + a.format(new Date()) + "] ")).a(var1);
			h();
		}

	}

	@Override
	public boolean s_() {
		MinecraftServer var1 = MinecraftServer.P();
		return (var1 == null) || !var1.Q() || var1.d[0].S().b("commandBlockOutput");
	}

	@Override
	public void a(class_n.class_a_in_class_n var1, int var2) {
		g.a(this, var1, var2);
	}

	public abstract void h();

	public void b(class_eu var1) {
		d = var1;
	}

	public void a(boolean var1) {
		c = var1;
	}

	public boolean m() {
		return c;
	}

	public boolean a(class_yu var1) {
		if (!var1.bI.d) {
			return false;
		} else {
			if (var1.e().D) {
				var1.a(this);
			}

			return true;
		}
	}

	public class_n n() {
		return g;
	}
}
