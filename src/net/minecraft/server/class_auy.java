package net.minecraft.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.google.common.collect.Maps;

public class class_auy {
	private final Map a;
	private final String b;

	public class_auy() {
		this("structures");
	}

	public class_auy(String var1) {
		a = Maps.newHashMap();
		b = var1;
	}

	public class_ava a(class_ke var1) {
		String var2 = var1.a();
		if (a.containsKey(var2)) {
			return (class_ava) a.get(var2);
		} else {
			b(var1);
			if (a.containsKey(var2)) {
				return (class_ava) a.get(var2);
			} else {
				class_ava var3 = new class_ava();
				a.put(var2, var3);
				return var3;
			}
		}
	}

	public boolean b(class_ke var1) {
		String var2 = var1.a();
		File var3 = MinecraftServer.P().d(b);
		File var4 = new File(var3, var2 + ".nbt");
		if (!var4.exists()) {
			return d(var1);
		} else {
			FileInputStream var5 = null;

			boolean var7;
			try {
				var5 = new FileInputStream(var4);
				this.a(var2, var5);
				return true;
			} catch (Throwable var11) {
				var7 = false;
			} finally {
				IOUtils.closeQuietly(var5);
			}

			return var7;
		}
	}

	private boolean d(class_ke var1) {
		String var2 = var1.b();
		String var3 = var1.a();
		InputStream var4 = null;

		boolean var6;
		try {
			var4 = MinecraftServer.class.getResourceAsStream("/assets/" + var2 + "/structures/" + var3 + ".nbt");
			this.a(var3, var4);
			return true;
		} catch (Throwable var10) {
			var6 = false;
		} finally {
			IOUtils.closeQuietly(var4);
		}

		return var6;
	}

	private void a(String var1, InputStream var2) throws IOException {
		class_dn var3 = class_dx.a(var2);
		class_ava var4 = new class_ava();
		var4.b(var3);
		a.put(var1, var4);
	}

	public boolean c(class_ke var1) {
		String var2 = var1.a();
		if (!a.containsKey(var2)) {
			return false;
		} else {
			File var3 = MinecraftServer.P().d(b);
			if (!var3.exists()) {
				if (!var3.mkdirs()) {
					return false;
				}
			} else if (!var3.isDirectory()) {
				return false;
			}

			File var4 = new File(var3, var2 + ".nbt");
			class_dn var5 = new class_dn();
			class_ava var6 = (class_ava) a.get(var2);
			FileOutputStream var7 = null;

			boolean var9;
			try {
				var6.a(var5);
				var7 = new FileOutputStream(var4);
				class_dx.a(var5, var7);
				return true;
			} catch (Throwable var13) {
				var9 = false;
			} finally {
				IOUtils.closeQuietly(var7);
			}

			return var9;
		}
	}
}
