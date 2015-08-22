package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_aqz implements class_aqt, class_ayh {
	private static final Logger a = LogManager.getLogger();
	private Map b = new ConcurrentHashMap();
	private Set c = Collections.newSetFromMap(new ConcurrentHashMap());
	private final File d;
	private final class_oo e;
	private boolean f = false;

	public class_aqz(File var1, class_oo var2) {
		d = var1;
		e = var2;
	}

	@Override
	public class_aqn a(class_ago var1, int var2, int var3) throws IOException {
		class_agi var4 = new class_agi(var2, var3);
		class_dn var5 = (class_dn) b.get(var4);
		if (var5 == null) {
			DataInputStream var6 = class_aqy.c(d, var2, var3);
			if (var6 == null) {
				return null;
			}

			var5 = e.a(class_om.c, class_dx.a(var6));
		}

		return this.a(var1, var2, var3, var5);
	}

	protected class_aqn a(class_ago var1, int var2, int var3, class_dn var4) {
		if (!var4.b("Level", 10)) {
			a.error("Chunk file at " + var2 + "," + var3 + " is missing level data, skipping");
			return null;
		} else {
			class_dn var5 = var4.o("Level");
			if (!var5.b("Sections", 9)) {
				a.error("Chunk file at " + var2 + "," + var3 + " is missing block data, skipping");
				return null;
			} else {
				class_aqn var6 = this.a(var1, var5);
				if (!var6.a(var2, var3)) {
					a.error("Chunk file at " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var6.b + ", " + var6.c + ")");
					var5.a("xPos", var2);
					var5.a("zPos", var3);
					var6 = this.a(var1, var5);
				}

				return var6;
			}
		}
	}

	@Override
	public void a(class_ago var1, class_aqn var2) throws IOException, class_agp {
		var1.K();

		try {
			class_dn var3 = new class_dn();
			class_dn var4 = new class_dn();
			var3.a("Level", var4);
			var3.a("DataVersion", 117);
			this.a(var2, var1, var4);
			this.a(var2.k(), var3);
		} catch (Exception var5) {
			a.error("Failed to save chunk", var5);
		}

	}

	protected void a(class_agi var1, class_dn var2) {
		if (!c.contains(var1)) {
			b.put(var1, var2);
		}

		class_ayg.a().a(this);
	}

	@Override
	public boolean c() {
		if (b.isEmpty()) {
			if (f) {
				a.info("ThreadedAnvilChunkStorage ({}): All chunks are saved", new Object[] { d.getName() });
			}

			return false;
		} else {
			class_agi var1 = (class_agi) b.keySet().iterator().next();

			boolean var3;
			try {
				c.add(var1);
				class_dn var2 = (class_dn) b.remove(var1);
				if (var2 != null) {
					try {
						this.b(var1, var2);
					} catch (Exception var7) {
						a.error("Failed to save chunk", var7);
					}
				}

				var3 = true;
			} finally {
				c.remove(var1);
			}

			return var3;
		}
	}

	private void b(class_agi var1, class_dn var2) throws IOException {
		DataOutputStream var3 = class_aqy.d(d, var1.a, var1.b);
		class_dx.a(var2, (DataOutput) var3);
		var3.close();
	}

	@Override
	public void b(class_ago var1, class_aqn var2) throws IOException {
	}

	@Override
	public void a() {
	}

	@Override
	public void b() {
		try {
			f = true;

			while (true) {
				if (c()) {
					continue;
				}
			}
		} finally {
			f = false;
		}

	}

	private void a(class_aqn var1, class_ago var2, class_dn var3) {
		var3.a("xPos", var1.b);
		var3.a("zPos", var1.c);
		var3.a("LastUpdate", var2.M());
		var3.a("HeightMap", var1.r());
		var3.a("TerrainPopulated", var1.u());
		var3.a("LightPopulated", var1.v());
		var3.a("InhabitedTime", var1.x());
		class_aqo[] var4 = var1.h();
		class_du var5 = new class_du();
		boolean var6 = !var2.t.m();
		class_aqo[] var7 = var4;
		int var8 = var4.length;

		class_dn var11;
		for (int var9 = 0; var9 < var8; ++var9) {
			class_aqo var10 = var7[var9];
			if (var10 != class_aqn.a) {
				var11 = new class_dn();
				var11.a("Y", (byte) ((var10.d() >> 4) & 255));
				byte[] var12 = new byte[4096];
				class_aql var13 = new class_aql();
				class_aql var14 = var10.g().a(var12, var13);
				var11.a("Blocks", var12);
				var11.a("Data", var13.a());
				if (var14 != null) {
					var11.a("Add", var14.a());
				}

				var11.a("BlockLight", var10.h().a());
				if (var6) {
					var11.a("SkyLight", var10.i().a());
				} else {
					var11.a("SkyLight", new byte[var10.h().a().length]);
				}

				var5.a(var11);
			}
		}

		var3.a("Sections", var5);
		var3.a("Biomes", var1.l());
		var1.g(false);
		class_du var17 = new class_du();

		Iterator var19;
		for (var8 = 0; var8 < var1.t().length; ++var8) {
			var19 = var1.t()[var8].iterator();

			while (var19.hasNext()) {
				class_qx var21 = (class_qx) var19.next();
				var11 = new class_dn();
				if (var21.d(var11)) {
					var1.g(true);
					var17.a(var11);
				}
			}
		}

		var3.a("Entities", var17);
		class_du var18 = new class_du();
		var19 = var1.s().values().iterator();

		while (var19.hasNext()) {
			class_aoi var22 = (class_aoi) var19.next();
			var11 = new class_dn();
			var22.b(var11);
			var18.a(var11);
		}

		var3.a("TileEntities", var18);
		List var20 = var2.a(var1, false);
		if (var20 != null) {
			long var23 = var2.M();
			class_du var24 = new class_du();
			Iterator var25 = var20.iterator();

			while (var25.hasNext()) {
				class_agz var26 = (class_agz) var25.next();
				class_dn var15 = new class_dn();
				class_ke var16 = (class_ke) class_ail.c.b(var26.a());
				var15.a("i", var16 == null ? "" : var16.toString());
				var15.a("x", var26.a.n());
				var15.a("y", var26.a.o());
				var15.a("z", var26.a.p());
				var15.a("t", (int) (var26.b - var23));
				var15.a("p", var26.c);
				var24.a(var15);
			}

			var3.a("TileTicks", var24);
		}

	}

	private class_aqn a(class_ago var1, class_dn var2) {
		int var3 = var2.h("xPos");
		int var4 = var2.h("zPos");
		class_aqn var5 = new class_aqn(var1, var3, var4);
		var5.a(var2.n("HeightMap"));
		var5.d(var2.p("TerrainPopulated"));
		var5.e(var2.p("LightPopulated"));
		var5.c(var2.i("InhabitedTime"));
		class_du var6 = var2.c("Sections", 10);
		byte var7 = 16;
		class_aqo[] var8 = new class_aqo[var7];
		boolean var9 = !var1.t.m();

		for (int var10 = 0; var10 < var6.c(); ++var10) {
			class_dn var11 = var6.b(var10);
			byte var12 = var11.f("Y");
			class_aqo var13 = new class_aqo(var12 << 4, var9);
			byte[] var14 = var11.m("Blocks");
			class_aql var15 = new class_aql(var11.m("Data"));
			class_aql var16 = var11.b("Add", 7) ? new class_aql(var11.m("Add")) : null;
			var13.g().a(var14, var15, var16);
			var13.a(new class_aql(var11.m("BlockLight")));
			if (var9) {
				var13.b(new class_aql(var11.m("SkyLight")));
			}

			var13.e();
			var8[var12] = var13;
		}

		var5.a(var8);
		if (var2.b("Biomes", 7)) {
			var5.a(var2.m("Biomes"));
		}

		class_du var17 = var2.c("Entities", 10);
		if (var17 != null) {
			for (int var18 = 0; var18 < var17.c(); ++var18) {
				class_dn var20 = var17.b(var18);
				class_qx var22 = class_qz.a(var20, var1);
				var5.g(true);
				if (var22 != null) {
					var5.a(var22);
					class_qx var26 = var22;

					for (class_dn var28 = var20; var28.b("Riding", 10); var28 = var28.o("Riding")) {
						class_qx var31 = class_qz.a(var28.o("Riding"), var1);
						if (var31 != null) {
							var5.a(var31);
							var26.a(var31);
						}

						var26 = var31;
					}
				}
			}
		}

		class_du var19 = var2.c("TileEntities", 10);
		if (var19 != null) {
			for (int var21 = 0; var21 < var19.c(); ++var21) {
				class_dn var24 = var19.b(var21);
				class_aoi var27 = class_aoi.c(var24);
				if (var27 != null) {
					var5.a(var27);
				}
			}
		}

		if (var2.b("TileTicks", 9)) {
			class_du var23 = var2.c("TileTicks", 10);
			if (var23 != null) {
				for (int var25 = 0; var25 < var23.c(); ++var25) {
					class_dn var29 = var23.b(var25);
					class_ail var30;
					if (var29.b("i", 8)) {
						var30 = class_ail.b(var29.l("i"));
					} else {
						var30 = class_ail.c(var29.h("i"));
					}

					var1.b(new class_cj(var29.h("x"), var29.h("y"), var29.h("z")), var30, var29.h("t"), var29.h("p"));
				}
			}
		}

		return var5;
	}
}
