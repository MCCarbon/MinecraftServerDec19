package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;

public class class_axp extends class_axs {
	private static final Logger c = LogManager.getLogger();

	public class_axp(File var1, class_oo var2) {
		super(var1, var2);
	}

	protected int c() {
		return 19133;
	}

	@Override
	public void d() {
		class_aqy.a();
	}

	@Override
	public class_axu a(String var1, boolean var2) {
		return new class_axo(a, var1, var2, b);
	}

	@Override
	public boolean b(String var1) {
		class_axt var2 = this.c(var1);
		return (var2 != null) && (var2.k() != this.c());
	}

	@Override
	public boolean a(String var1, class_oc var2) {
		var2.a(0);
		ArrayList var3 = Lists.newArrayList();
		ArrayList var4 = Lists.newArrayList();
		ArrayList var5 = Lists.newArrayList();
		File var6 = new File(a, var1);
		File var7 = new File(var6, "DIM-1");
		File var8 = new File(var6, "DIM1");
		c.info("Scanning folders...");
		this.a(var6, var3);
		if (var7.exists()) {
			this.a(var7, var4);
		}

		if (var8.exists()) {
			this.a(var8, var5);
		}

		int var9 = var3.size() + var4.size() + var5.size();
		c.info("Total conversion count is " + var9);
		class_axt var10 = this.c(var1);
		Object var11 = null;
		if (var10.t() == class_agt.c) {
			var11 = new class_ahi(class_ahb.q, 0.5F);
		} else {
			var11 = new class_ahf(var10.a(), var10.t(), var10.A());
		}

		this.a(new File(var6, "region"), (Iterable) var3, (class_ahf) var11, 0, var9, var2);
		this.a(new File(var7, "region"), var4, new class_ahi(class_ahb.x, 0.0F), var3.size(), var9, var2);
		this.a(new File(var8, "region"), var5, new class_ahi(class_ahb.y, 0.0F), var3.size() + var4.size(), var9, var2);
		var10.e(19133);
		if (var10.t() == class_agt.h) {
			var10.a(class_agt.b);
		}

		g(var1);
		class_axu var12 = this.a(var1, false);
		var12.a(var10);
		return true;
	}

	private void g(String var1) {
		File var2 = new File(a, var1);
		if (!var2.exists()) {
			c.warn("Unable to create level.dat_mcr backup");
		} else {
			File var3 = new File(var2, "level.dat");
			if (!var3.exists()) {
				c.warn("Unable to create level.dat_mcr backup");
			} else {
				File var4 = new File(var2, "level.dat_mcr");
				if (!var3.renameTo(var4)) {
					c.warn("Unable to create level.dat_mcr backup");
				}

			}
		}
	}

	private void a(File var1, Iterable var2, class_ahf var3, int var4, int var5, class_oc var6) {
		Iterator var7 = var2.iterator();

		while (var7.hasNext()) {
			File var8 = (File) var7.next();
			this.a(var1, var8, var3, var4, var5, var6);
			++var4;
			int var9 = (int) Math.round((100.0D * var4) / var5);
			var6.a(var9);
		}

	}

	private void a(File var1, File var2, class_ahf var3, int var4, int var5, class_oc var6) {
		try {
			String var7 = var2.getName();
			class_aqx var8 = new class_aqx(var2);
			class_aqx var9 = new class_aqx(new File(var1, var7.substring(0, var7.length() - ".mcr".length()) + ".mca"));

			for (int var10 = 0; var10 < 32; ++var10) {
				int var11;
				for (var11 = 0; var11 < 32; ++var11) {
					if (var8.c(var10, var11) && !var9.c(var10, var11)) {
						DataInputStream var12 = var8.a(var10, var11);
						if (var12 == null) {
							c.warn("Failed to fetch input stream");
						} else {
							class_dn var13 = class_dx.a(var12);
							var12.close();
							class_dn var14 = var13.o("Level");
							class_aqw.class_a_in_class_aqw var15 = class_aqw.a(var14);
							class_dn var16 = new class_dn();
							class_dn var17 = new class_dn();
							var16.a("Level", var17);
							class_aqw.a(var15, var17, var3);
							DataOutputStream var18 = var9.b(var10, var11);
							class_dx.a(var16, (DataOutput) var18);
							var18.close();
						}
					}
				}

				var11 = (int) Math.round((100.0D * (var4 * 1024)) / (var5 * 1024));
				int var20 = (int) Math.round((100.0D * (((var10 + 1) * 32) + (var4 * 1024))) / (var5 * 1024));
				if (var20 > var11) {
					var6.a(var20);
				}
			}

			var8.c();
			var9.c();
		} catch (IOException var19) {
			var19.printStackTrace();
		}

	}

	private void a(File var1, Collection var2) {
		File var3 = new File(var1, "region");
		File[] var4 = var3.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File var1, String var2) {
				return var2.endsWith(".mcr");
			}
		});
		if (var4 != null) {
			Collections.addAll(var2, var4);
		}

	}
}
