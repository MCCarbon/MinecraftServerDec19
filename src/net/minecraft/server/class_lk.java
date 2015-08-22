package net.minecraft.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;

public class class_lk implements class_aqk {
	private static final Logger b = LogManager.getLogger();
	private Set c = Collections.newSetFromMap(new ConcurrentHashMap());
	private class_aqn d;
	private class_aqk e;
	private class_aqt f;
	public boolean a = true;
	private class_ny g = new class_ny();
	private List h = Lists.newArrayList();
	private class_ll i;

	public class_lk(class_ll var1, class_aqt var2, class_aqk var3) {
		d = new class_aqm(var1, 0, 0);
		i = var1;
		f = var2;
		e = var3;
	}

	@Override
	public boolean a(int var1, int var2) {
		return g.b(class_agi.a(var1, var2));
	}

	public List a() {
		return h;
	}

	public void b(int var1, int var2) {
		if (i.t.c(var1, var2)) {
			c.add(Long.valueOf(class_agi.a(var1, var2)));
		}

	}

	public void b() {
		Iterator var1 = h.iterator();

		while (var1.hasNext()) {
			class_aqn var2 = (class_aqn) var1.next();
			this.b(var2.b, var2.c);
		}

	}

	public class_aqn c(int var1, int var2) {
		long var3 = class_agi.a(var1, var2);
		c.remove(Long.valueOf(var3));
		class_aqn var5 = (class_aqn) g.a(var3);
		if (var5 == null) {
			var5 = this.e(var1, var2);
			if (var5 == null) {
				if (e == null) {
					var5 = d;
				} else {
					try {
						var5 = e.d(var1, var2);
					} catch (Throwable var9) {
						class_b var7 = class_b.a(var9, "Exception generating new chunk");
						class_c var8 = var7.a("Chunk to be generated");
						var8.a("Location", String.format("%d,%d", new Object[] { Integer.valueOf(var1), Integer.valueOf(var2) }));
						var8.a("Position hash", Long.valueOf(var3));
						var8.a("Generator", e.f());
						throw new class_e(var7);
					}
				}
			}

			g.a(var3, var5);
			h.add(var5);
			var5.c();
			var5.a(this, this, var1, var2);
		}

		return var5;
	}

	@Override
	public class_aqn d(int var1, int var2) {
		class_aqn var3 = (class_aqn) g.a(class_agi.a(var1, var2));
		return var3 == null ? (!i.af() && !a ? d : this.c(var1, var2)) : var3;
	}

	private class_aqn e(int var1, int var2) {
		if (f == null) {
			return null;
		} else {
			try {
				class_aqn var3 = f.a(i, var1, var2);
				if (var3 != null) {
					var3.b(i.M());
					if (e != null) {
						e.a(var3, var1, var2);
					}
				}

				return var3;
			} catch (Exception var4) {
				b.error("Couldn\'t load chunk", var4);
				return null;
			}
		}
	}

	private void a(class_aqn var1) {
		if (f != null) {
			try {
				f.b(i, var1);
			} catch (Exception var3) {
				b.error("Couldn\'t save entities", var3);
			}

		}
	}

	private void b(class_aqn var1) {
		if (f != null) {
			try {
				var1.b(i.M());
				f.a(i, var1);
			} catch (IOException var3) {
				b.error("Couldn\'t save chunk", var3);
			} catch (class_agp var4) {
				b.error("Couldn\'t save chunk; already in use by another instance of Minecraft?", var4);
			}

		}
	}

	@Override
	public void a(class_aqk var1, int var2, int var3) {
		class_aqn var4 = this.d(var2, var3);
		if (!var4.u()) {
			var4.o();
			if (e != null) {
				e.a(var1, var2, var3);
				var4.e();
			}
		}

	}

	@Override
	public boolean a(class_aqk var1, class_aqn var2, int var3, int var4) {
		if ((e != null) && e.a(var1, var2, var3, var4)) {
			class_aqn var5 = this.d(var3, var4);
			var5.e();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean a(boolean var1, class_oc var2) {
		int var3 = 0;
		ArrayList var4 = Lists.newArrayList((Iterable) h);

		for (int var5 = 0; var5 < var4.size(); ++var5) {
			class_aqn var6 = (class_aqn) var4.get(var5);
			if (var1) {
				this.a(var6);
			}

			if (var6.a(var1)) {
				this.b(var6);
				var6.f(false);
				++var3;
				if ((var3 == 24) && !var1) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public void c() {
		if (f != null) {
			f.b();
		}

	}

	@Override
	public boolean d() {
		if (!i.c) {
			for (int var1 = 0; var1 < 100; ++var1) {
				if (!c.isEmpty()) {
					Long var2 = (Long) c.iterator().next();
					class_aqn var3 = (class_aqn) g.a(var2.longValue());
					if (var3 != null) {
						var3.d();
						this.b(var3);
						this.a(var3);
						g.d(var2.longValue());
						h.remove(var3);
					}

					c.remove(var2);
				}
			}

			if (f != null) {
				f.a();
			}
		}

		return e.d();
	}

	@Override
	public boolean e() {
		return !i.c;
	}

	@Override
	public String f() {
		return "ServerChunkCache: " + g.a() + " Drop: " + c.size();
	}

	@Override
	public List a(class_ri var1, class_cj var2) {
		return e.a(var1, var2);
	}

	@Override
	public class_cj a(class_ago var1, String var2, class_cj var3) {
		return e.a(var1, var2, var3);
	}

	@Override
	public int g() {
		return g.a();
	}

	@Override
	public void a(class_aqn var1, int var2, int var3) {
	}

	@Override
	public class_aqn a(class_cj var1) {
		return this.d(var1.n() >> 4, var1.p() >> 4);
	}
}
