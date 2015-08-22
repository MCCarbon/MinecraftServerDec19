package net.minecraft.server;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;

public class class_b {
	private static final Logger a = LogManager.getLogger();
	private final String b;
	private final Throwable c;
	private final class_c d = new class_c(this, "System Details");
	private final List e = Lists.newArrayList();
	private File f;
	private boolean g = true;
	private StackTraceElement[] h = new StackTraceElement[0];

	public class_b(String var1, Throwable var2) {
		b = var1;
		c = var2;
		h();
	}

	private void h() {
		d.a("Minecraft Version", new Callable() {
			public String a() {
				return "15w34d";
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		d.a("Operating System", new Callable() {
			public String a() {
				return System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version");
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		d.a("Java Version", new Callable() {
			public String a() {
				return System.getProperty("java.version") + ", " + System.getProperty("java.vendor");
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		d.a("Java VM Version", new Callable() {
			public String a() {
				return System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor");
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		d.a("Memory", new Callable() {
			public String a() {
				Runtime var1 = Runtime.getRuntime();
				long var2 = var1.maxMemory();
				long var4 = var1.totalMemory();
				long var6 = var1.freeMemory();
				long var8 = var2 / 1024L / 1024L;
				long var10 = var4 / 1024L / 1024L;
				long var12 = var6 / 1024L / 1024L;
				return var6 + " bytes (" + var12 + " MB) / " + var4 + " bytes (" + var10 + " MB) up to " + var2 + " bytes (" + var8 + " MB)";
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		d.a("JVM Flags", new Callable() {
			public String a() {
				RuntimeMXBean var1 = ManagementFactory.getRuntimeMXBean();
				List var2 = var1.getInputArguments();
				int var3 = 0;
				StringBuilder var4 = new StringBuilder();
				Iterator var5 = var2.iterator();

				while (var5.hasNext()) {
					String var6 = (String) var5.next();
					if (var6.startsWith("-X")) {
						if (var3++ > 0) {
							var4.append(" ");
						}

						var4.append(var6);
					}
				}

				return String.format("%d total; %s", new Object[] { Integer.valueOf(var3), var4.toString() });
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		d.a("IntCache", new Callable() {
			public String a() throws Exception {
				return class_awg.b();
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
	}

	public String a() {
		return b;
	}

	public Throwable b() {
		return c;
	}

	public void a(StringBuilder var1) {
		if (((h == null) || (h.length <= 0)) && !e.isEmpty()) {
			h = (StackTraceElement[]) ArrayUtils.subarray((Object[]) ((class_c) e.get(0)).a(), 0, 1);
		}

		if ((h != null) && (h.length > 0)) {
			var1.append("-- Head --\n");
			var1.append("Stacktrace:\n");
			StackTraceElement[] var2 = h;
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				StackTraceElement var5 = var2[var4];
				var1.append("\t").append("at ").append(var5.toString());
				var1.append("\n");
			}

			var1.append("\n");
		}

		Iterator var6 = e.iterator();

		while (var6.hasNext()) {
			class_c var7 = (class_c) var6.next();
			var7.a(var1);
			var1.append("\n\n");
		}

		d.a(var1);
	}

	public String d() {
		StringWriter var1 = null;
		PrintWriter var2 = null;
		Object var3 = c;
		if (((Throwable) var3).getMessage() == null) {
			if (var3 instanceof NullPointerException) {
				var3 = new NullPointerException(b);
			} else if (var3 instanceof StackOverflowError) {
				var3 = new StackOverflowError(b);
			} else if (var3 instanceof OutOfMemoryError) {
				var3 = new OutOfMemoryError(b);
			}

			((Throwable) var3).setStackTrace(c.getStackTrace());
		}

		String var4 = ((Throwable) var3).toString();

		try {
			var1 = new StringWriter();
			var2 = new PrintWriter(var1);
			((Throwable) var3).printStackTrace(var2);
			var4 = var1.toString();
		} finally {
			IOUtils.closeQuietly(var1);
			IOUtils.closeQuietly(var2);
		}

		return var4;
	}

	public String e() {
		StringBuilder var1 = new StringBuilder();
		var1.append("---- Minecraft Crash Report ----\n");
		var1.append("// ");
		var1.append(i());
		var1.append("\n\n");
		var1.append("Time: ");
		var1.append((new SimpleDateFormat()).format(new Date()));
		var1.append("\n");
		var1.append("Description: ");
		var1.append(b);
		var1.append("\n\n");
		var1.append(d());
		var1.append("\n\nA detailed walkthrough of the error, its code path and all known details is as follows:\n");

		for (int var2 = 0; var2 < 87; ++var2) {
			var1.append("-");
		}

		var1.append("\n\n");
		this.a(var1);
		return var1.toString();
	}

	public boolean a(File var1) {
		if (f != null) {
			return false;
		} else {
			if (var1.getParentFile() != null) {
				var1.getParentFile().mkdirs();
			}

			try {
				FileWriter var2 = new FileWriter(var1);
				var2.write(e());
				var2.close();
				f = var1;
				return true;
			} catch (Throwable var3) {
				a.error("Could not save crash report to " + var1, var3);
				return false;
			}
		}
	}

	public class_c g() {
		return d;
	}

	public class_c a(String var1) {
		return this.a(var1, 1);
	}

	public class_c a(String var1, int var2) {
		class_c var3 = new class_c(this, var1);
		if (g) {
			int var4 = var3.a(var2);
			StackTraceElement[] var5 = c.getStackTrace();
			StackTraceElement var6 = null;
			StackTraceElement var7 = null;
			int var8 = var5.length - var4;
			if (var8 < 0) {
				System.out.println("Negative index in crash report handler (" + var5.length + "/" + var4 + ")");
			}

			if ((var5 != null) && (0 <= var8) && (var8 < var5.length)) {
				var6 = var5[var8];
				if (((var5.length + 1) - var4) < var5.length) {
					var7 = var5[(var5.length + 1) - var4];
				}
			}

			g = var3.a(var6, var7);
			if ((var4 > 0) && !e.isEmpty()) {
				class_c var9 = (class_c) e.get(e.size() - 1);
				var9.b(var4);
			} else if ((var5 != null) && (var5.length >= var4) && (0 <= var8) && (var8 < var5.length)) {
				h = new StackTraceElement[var8];
				System.arraycopy(var5, 0, h, 0, h.length);
			} else {
				g = false;
			}
		}

		e.add(var3);
		return var3;
	}

	private static String i() {
		String[] var0 = new String[] { "Who set us up the TNT?", "Everything\'s going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I\'m sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!",
				"Don\'t be sad. I\'ll do better next time, I promise!", "Don\'t be sad, have a hug! <3", "I just don\'t know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn\'t worry myself about that.", "I bet Cylons wouldn\'t have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I\'m Minecraft, and I\'m a crashaholic.", "Ooh. Shiny.", "This doesn\'t make any sense!", "Why is it breaking :(", "Don\'t do that.",
				"Ouch. That hurt :(", "You\'re mean.", "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!", "But it works on my machine." };

		try {
			return var0[(int) (System.nanoTime() % var0.length)];
		} catch (Throwable var2) {
			return "Witty comment unavailable :(";
		}
	}

	public static class_b a(Throwable var0, String var1) {
		class_b var2;
		if (var0 instanceof class_e) {
			var2 = ((class_e) var0).a();
		} else {
			var2 = new class_b(var1, var0);
		}

		return var2;
	}
}
