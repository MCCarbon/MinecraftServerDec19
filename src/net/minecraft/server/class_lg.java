package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class class_lg {
	private static final Logger a = LogManager.getLogger();
	private final class_ll b;
	private Set c = Sets.newHashSet();
	private class_nu d = new class_nu();
	private int e;

	public class_lg(class_ll var1) {
		b = var1;
		e = var1.t().ar().d();
	}

	public void a(Entity var1) {
		if (var1 instanceof class_lm) {
			this.a(var1, 512, 2);
			class_lm var2 = (class_lm) var1;
			Iterator var3 = c.iterator();

			while (var3.hasNext()) {
				class_lo var4 = (class_lo) var3.next();
				if (var4.a != var2) {
					var4.b(var2);
				}
			}
		} else if (var1 instanceof class_wy) {
			this.a(var1, 64, 5, true);
		} else if (var1 instanceof class_yx) {
			this.a(var1, 64, 20, false);
		} else if (var1 instanceof class_zg) {
			this.a(var1, 64, 10, false);
		} else if (var1 instanceof class_za) {
			this.a(var1, 64, 10, false);
		} else if (var1 instanceof class_zh) {
			this.a(var1, 64, 10, true);
		} else if (var1 instanceof class_zl) {
			this.a(var1, 64, 10, true);
		} else if (var1 instanceof class_yz) {
			this.a(var1, 64, 4, true);
		} else if (var1 instanceof class_zk) {
			this.a(var1, 64, 10, true);
		} else if (var1 instanceof class_zn) {
			this.a(var1, 64, 10, true);
		} else if (var1 instanceof class_zm) {
			this.a(var1, 64, 10, true);
		} else if (var1 instanceof class_zb) {
			this.a(var1, 64, 10, true);
		} else if (var1 instanceof class_xg) {
			this.a(var1, 64, 20, true);
		} else if (var1 instanceof class_xh) {
			this.a(var1, 80, 3, true);
		} else if (var1 instanceof class_xe) {
			this.a(var1, 80, 3, true);
		} else if (var1 instanceof class_vo) {
			this.a(var1, 64, 3, true);
		} else if (var1 instanceof class_wq) {
			this.a(var1, 80, 3, false);
		} else if (var1 instanceof class_zf) {
			this.a(var1, 80, 3, true);
		} else if (var1 instanceof class_va) {
			this.a(var1, 80, 3, false);
		} else if (var1 instanceof class_vx) {
			this.a(var1, 160, 3, true);
		} else if (var1 instanceof class_qw) {
			this.a(var1, 80, 3, true);
		} else if (var1 instanceof class_xq) {
			this.a(var1, 160, 10, true);
		} else if (var1 instanceof class_xf) {
			this.a(var1, 160, 20, true);
		} else if (var1 instanceof class_wt) {
			this.a(var1, 160, Integer.MAX_VALUE, false);
		} else if (var1 instanceof class_ws) {
			this.a(var1, 160, 3, true);
		} else if (var1 instanceof class_rd) {
			this.a(var1, 160, 20, true);
		} else if (var1 instanceof class_qv) {
			this.a(var1, 160, Integer.MAX_VALUE, true);
		} else if (var1 instanceof class_vw) {
			this.a(var1, 256, Integer.MAX_VALUE, false);
		}

	}

	public void a(Entity var1, int var2, int var3) {
		this.a(var1, var2, var3, false);
	}

	public void a(Entity var1, int var2, final int var3, boolean var4) {
		if (var2 > e) {
			var2 = e;
		}

		try {
			if (d.b(var1.G())) {
				throw new IllegalStateException("Entity is already tracked!");
			}

			class_lo var5 = new class_lo(var1, var2, var3, var4);
			c.add(var5);
			d.a(var1.G(), var5);
			var5.b(b.j);
		} catch (Throwable var11) {
			class_b var6 = class_b.a(var11, "Adding entity to track");
			class_c var7 = var6.a("Entity To Track");
			var7.a("Tracking range", var2 + " blocks");
			var7.a("Update interval", new Callable() {
				public String a() throws Exception {
					String var1 = "Once per " + var3 + " ticks";
					if (var3 == Integer.MAX_VALUE) {
						var1 = "Maximum (" + var1 + ")";
					}

					return var1;
				}

				// $FF: synthetic method
				@Override
				public Object call() throws Exception {
					return this.a();
				}
			});
			var1.a(var7);
			class_c var8 = var6.a("Entity That Is Already Tracked");
			((class_lo) d.a(var1.G())).a.a(var8);

			try {
				throw new class_e(var6);
			} catch (class_e var10) {
				a.error("\"Silently\" catching entity tracking error.", var10);
			}
		}

	}

	public void b(Entity var1) {
		if (var1 instanceof class_lm) {
			class_lm var2 = (class_lm) var1;
			Iterator var3 = c.iterator();

			while (var3.hasNext()) {
				class_lo var4 = (class_lo) var3.next();
				var4.a(var2);
			}
		}

		class_lo var5 = (class_lo) d.d(var1.G());
		if (var5 != null) {
			c.remove(var5);
			var5.a();
		}

	}

	public void a() {
		ArrayList var1 = Lists.newArrayList();
		Iterator var2 = c.iterator();

		while (var2.hasNext()) {
			class_lo var3 = (class_lo) var2.next();
			var3.a(b.j);
			if (var3.n && (var3.a instanceof class_lm)) {
				var1.add(var3.a);
			}
		}

		for (int var6 = 0; var6 < var1.size(); ++var6) {
			class_lm var7 = (class_lm) var1.get(var6);
			Iterator var4 = c.iterator();

			while (var4.hasNext()) {
				class_lo var5 = (class_lo) var4.next();
				if (var5.a != var7) {
					var5.b(var7);
				}
			}
		}

	}

	public void a(class_lm var1) {
		Iterator var2 = c.iterator();

		while (var2.hasNext()) {
			class_lo var3 = (class_lo) var2.next();
			if (var3.a == var1) {
				var3.b(b.j);
			} else {
				var3.b(var1);
			}
		}

	}

	public void a(Entity var1, Packet var2) {
		class_lo var3 = (class_lo) d.a(var1.G());
		if (var3 != null) {
			var3.a(var2);
		}

	}

	public void b(Entity var1, Packet var2) {
		class_lo var3 = (class_lo) d.a(var1.G());
		if (var3 != null) {
			var3.b(var2);
		}

	}

	public void b(class_lm var1) {
		Iterator var2 = c.iterator();

		while (var2.hasNext()) {
			class_lo var3 = (class_lo) var2.next();
			var3.d(var1);
		}

	}

	public void a(class_lm var1, class_aqn var2) {
		Iterator var3 = c.iterator();

		while (var3.hasNext()) {
			class_lo var4 = (class_lo) var3.next();
			if ((var4.a != var1) && (var4.a.ae == var2.b) && (var4.a.ag == var2.c)) {
				var4.b(var1);
			}
		}

	}
}
