package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_axr implements class_axu, class_ayc {
	private static final Logger b = LogManager.getLogger();
	private final File c;
	private final File d;
	private final File e;
	private final long f = MinecraftServer.aB();
	private final String g;
	private final class_auy h;
	protected final class_oo a;

	public class_axr(File var1, String var2, boolean var3, class_oo var4) {
		a = var4;
		c = new File(var1, var2);
		c.mkdirs();
		d = new File(c, "playerdata");
		e = new File(c, "data");
		e.mkdirs();
		g = var2;
		if (var3) {
			d.mkdirs();
			h = new class_auy((new File(c, "structures")).toString());
		} else {
			h = null;
		}

		i();
	}

	private void i() {
		try {
			File var1 = new File(c, "session.lock");
			DataOutputStream var2 = new DataOutputStream(new FileOutputStream(var1));

			try {
				var2.writeLong(f);
			} finally {
				var2.close();
			}

		} catch (IOException var7) {
			var7.printStackTrace();
			throw new RuntimeException("Failed to check session lock, aborting");
		}
	}

	@Override
	public File b() {
		return c;
	}

	@Override
	public void c() throws class_agp {
		try {
			File var1 = new File(c, "session.lock");
			DataInputStream var2 = new DataInputStream(new FileInputStream(var1));

			try {
				if (var2.readLong() != f) {
					throw new class_agp("The save is being accessed from another location, aborting");
				}
			} finally {
				var2.close();
			}

		} catch (IOException var7) {
			throw new class_agp("Failed to check session lock, aborting");
		}
	}

	@Override
	public class_aqt a(class_arc var1) {
		throw new RuntimeException("Old Chunk Storage is no longer supported.");
	}

	@Override
	public class_axt d() {
		File var1 = new File(c, "level.dat");
		if (var1.exists()) {
			class_axt var2 = class_axs.a(var1, a);
			if (var2 != null) {
				return var2;
			}
		}

		var1 = new File(c, "level.dat_old");
		return var1.exists() ? class_axs.a(var1, a) : null;
	}

	@Override
	public void a(class_axt var1, class_dn var2) {
		class_dn var3 = var1.a(var2);
		class_dn var4 = new class_dn();
		var4.a("Data", var3);

		try {
			File var5 = new File(c, "level.dat_new");
			File var6 = new File(c, "level.dat_old");
			File var7 = new File(c, "level.dat");
			class_dx.a(var4, (new FileOutputStream(var5)));
			if (var6.exists()) {
				var6.delete();
			}

			var7.renameTo(var6);
			if (var7.exists()) {
				var7.delete();
			}

			var5.renameTo(var7);
			if (var5.exists()) {
				var5.delete();
			}
		} catch (Exception var8) {
			var8.printStackTrace();
		}

	}

	@Override
	public void a(class_axt var1) {
		this.a(var1, (class_dn) null);
	}

	@Override
	public void a(class_yu var1) {
		try {
			class_dn var2 = new class_dn();
			var1.e(var2);
			File var3 = new File(d, var1.aQ().toString() + ".dat.tmp");
			File var4 = new File(d, var1.aQ().toString() + ".dat");
			class_dx.a(var2, (new FileOutputStream(var3)));
			if (var4.exists()) {
				var4.delete();
			}

			var3.renameTo(var4);
		} catch (Exception var5) {
			b.warn("Failed to save player data for " + var1.e_());
		}

	}

	@Override
	public class_dn b(class_yu var1) {
		class_dn var2 = null;

		try {
			File var3 = new File(d, var1.aQ().toString() + ".dat");
			if (var3.exists() && var3.isFile()) {
				var2 = class_dx.a((new FileInputStream(var3)));
			}
		} catch (Exception var4) {
			b.warn("Failed to load player data for " + var1.e_());
		}

		if (var2 != null) {
			var1.f(a.a(class_om.b, var2));
		}

		return var2;
	}

	@Override
	public class_ayc e() {
		return this;
	}

	@Override
	public String[] f() {
		String[] var1 = d.list();
		if (var1 == null) {
			var1 = new String[0];
		}

		for (int var2 = 0; var2 < var1.length; ++var2) {
			if (var1[var2].endsWith(".dat")) {
				var1[var2] = var1[var2].substring(0, var1[var2].length() - 4);
			}
		}

		return var1;
	}

	@Override
	public void a() {
	}

	@Override
	public File a(String var1) {
		return new File(e, var1 + ".dat");
	}

	@Override
	public String g() {
		return g;
	}

	@Override
	public class_auy h() {
		return h;
	}
}
