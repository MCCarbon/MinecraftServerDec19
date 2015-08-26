package net.minecraft.server;

import java.util.Map;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;

public abstract class TileEntity {
	private static final Logger a = LogManager.getLogger();
	private static Map f = Maps.newHashMap();
	private static Map g = Maps.newHashMap();
	protected class_ago b;
	protected class_cj c;
	protected boolean d;
	private int h;
	protected Block e;

	public TileEntity() {
		c = class_cj.a;
		h = -1;
	}

	private static void a(Class var0, String var1) {
		if (f.containsKey(var1)) {
			throw new IllegalArgumentException("Duplicate id: " + var1);
		} else {
			f.put(var1, var0);
			g.put(var0, var1);
		}
	}

	public class_ago z() {
		return b;
	}

	public void a(class_ago var1) {
		b = var1;
	}

	public boolean t() {
		return b != null;
	}

	public void a(class_dn var1) {
		c = new class_cj(var1.h("x"), var1.h("y"), var1.h("z"));
	}

	public void b(class_dn var1) {
		String var2 = (String) g.get(this.getClass());
		if (var2 == null) {
			throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
		} else {
			var1.a("id", var2);
			var1.a("x", c.n());
			var1.a("y", c.o());
			var1.a("z", c.p());
		}
	}

	public static TileEntity c(class_dn var0) {
		TileEntity var1 = null;

		try {
			Class var2 = (Class) f.get(var0.l("id"));
			if (var2 != null) {
				var1 = (TileEntity) var2.newInstance();
			}
		} catch (Exception var3) {
			var3.printStackTrace();
		}

		if (var1 != null) {
			var1.a(var0);
		} else {
			a.warn("Skipping BlockEntity with id " + var0.l("id"));
		}

		return var1;
	}

	public int u() {
		if (h == -1) {
			class_apn var1 = b.p(c);
			h = var1.c().c(var1);
		}

		return h;
	}

	public void o_() {
		if (b != null) {
			class_apn var1 = b.p(c);
			h = var1.c().c(var1);
			b.b(c, this);
			if (w() != Blocks.AIR) {
				b.f(c, w());
			}
		}

	}

	public class_cj v() {
		return c;
	}

	public Block w() {
		if (e == null) {
			e = b.p(c).c();
		}

		return e;
	}

	public Packet x_() {
		return null;
	}

	public boolean x() {
		return d;
	}

	public void y() {
		d = true;
	}

	public void D() {
		d = false;
	}

	public boolean c(int var1, int var2) {
		return false;
	}

	public void E() {
		e = null;
		h = -1;
	}

	public void a(class_c var1) {
		var1.a("Name", new Callable() {
			public String a() throws Exception {
				return (String) TileEntity.g.get(TileEntity.this.getClass()) + " // " + TileEntity.this.getClass().getCanonicalName();
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		if (b != null) {
			class_c.a(var1, c, w(), u());
			var1.a("Actual block type", new Callable() {
				public String a() throws Exception {
					int var1 = Block.a(b.p(c).c());

					try {
						return String.format("ID #%d (%s // %s)", new Object[] { Integer.valueOf(var1), Block.c(var1).a(), Block.c(var1).getClass().getCanonicalName() });
					} catch (Throwable var3) {
						return "ID #" + var1;
					}
				}

				// $FF: synthetic method
				@Override
				public Object call() throws Exception {
					return this.a();
				}
			});
			var1.a("Actual block data value", new Callable() {
				public String a() throws Exception {
					class_apn var1 = b.p(c);
					int var2 = var1.c().c(var1);
					if (var2 < 0) {
						return "Unknown? (Got " + var2 + ")";
					} else {
						String var3 = String.format("%4s", new Object[] { Integer.toBinaryString(var2) }).replace(" ", "0");
						return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[] { Integer.valueOf(var2), var3 });
					}
				}

				// $FF: synthetic method
				@Override
				public Object call() throws Exception {
					return this.a();
				}
			});
		}
	}

	public void a(class_cj var1) {
		if (var1 instanceof class_cj.class_a_in_class_cj) {
			a.warn("Tried to assign a mutable BlockPos to a block entity...", (new Error()));
			var1 = new class_cj(var1);
		}

		c = var1;
	}

	public boolean F() {
		return false;
	}

	static {
		a(class_aot.class, "Furnace");
		a(class_aok.class, "Chest");
		a(class_aor.class, "EnderChest");
		a(class_ala.class_a_in_class_ala.class, "RecordPlayer");
		a(class_aoo.class, "Trap");
		a(class_aop.class, "Dropper");
		a(class_aoz.class, "Sign");
		a(class_aox.class, "MobSpawner");
		a(class_aoy.class, "Music");
		a(class_api.class, "Piston");
		a(class_aoj.class, "Cauldron");
		a(class_aoq.class, "EnchantTable");
		a(class_apd.class, "Airportal");
		a(class_aoh.class, "Beacon");
		a(class_apa.class, "Skull");
		a(class_aon.class, "DLDetector");
		a(class_aov.class, "Hopper");
		a(class_aom.class, "Comparator");
		a(class_aos.class, "FlowerPot");
		a(class_aog.class, "Banner");
		a(class_apb.class, "Structure");
		a(class_apc.class, "EndGateway");
		a(class_aol.class, "Control");
	}
}
