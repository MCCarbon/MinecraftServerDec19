package net.minecraft.server;

import java.io.File;
import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_axs implements class_axw {
	private static final Logger c = LogManager.getLogger();
	protected final File a;
	protected final class_oo b;

	public class_axs(File var1, class_oo var2) {
		b = var2;
		if (!var1.exists()) {
			var1.mkdirs();
		}

		a = var1;
	}

	@Override
	public void d() {
	}

	public class_axt c(String var1) {
		File var2 = new File(a, var1);
		if (!var2.exists()) {
			return null;
		} else {
			File var3 = new File(var2, "level.dat");
			if (var3.exists()) {
				class_axt var4 = a(var3, b);
				if (var4 != null) {
					return var4;
				}
			}

			var3 = new File(var2, "level.dat_old");
			return var3.exists() ? a(var3, b) : null;
		}
	}

	public static class_axt a(File var0, class_oo var1) {
		try {
			class_dn var2 = class_dx.a((new FileInputStream(var0)));
			class_dn var3 = var2.o("Data");
			return new class_axt(var1.a(class_om.a, var3));
		} catch (Exception var4) {
			c.error("Exception reading " + var0, var4);
			return null;
		}
	}

	@Override
	public boolean e(String var1) {
		File var2 = new File(a, var1);
		if (!var2.exists()) {
			return true;
		} else {
			c.info("Deleting level " + var1);

			for (int var3 = 1; var3 <= 5; ++var3) {
				c.info("Attempt " + var3 + "...");
				if (a(var2.listFiles())) {
					break;
				}

				c.warn("Unsuccessful in deleting contents.");
				if (var3 < 5) {
					try {
						Thread.sleep(500L);
					} catch (InterruptedException var5) {
						;
					}
				}
			}

			return var2.delete();
		}
	}

	protected static boolean a(File[] var0) {
		for (int var1 = 0; var1 < var0.length; ++var1) {
			File var2 = var0[var1];
			c.debug("Deleting " + var2);
			if (var2.isDirectory() && !a(var2.listFiles())) {
				c.warn("Couldn\'t delete directory " + var2);
				return false;
			}

			if (!var2.delete()) {
				c.warn("Couldn\'t delete file " + var2);
				return false;
			}
		}

		return true;
	}

	@Override
	public class_axu a(String var1, boolean var2) {
		return new class_axr(a, var1, var2, b);
	}

	@Override
	public boolean b(String var1) {
		return false;
	}

	@Override
	public boolean a(String var1, class_oc var2) {
		return false;
	}

	@Override
	public File b(String var1, String var2) {
		return new File(new File(a, var1), var2);
	}
}
