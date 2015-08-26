package net.minecraft.server;


public class class_n {
	private static final int a = class_n.class_a_in_class_n.values().length;
	private static final String[] b;
	private String[] c;
	private String[] d;

	public class_n() {
		c = b;
		d = b;
	}

	public void a(final ICommandListener var1, class_n.class_a_in_class_n var2, int var3) {
		String var4 = c[var2.a()];
		if (var4 != null) {
			ICommandListener var5 = new ICommandListener() {
				@Override
				public String e_() {
					return var1.e_();
				}

				@Override
				public IChatBaseComponent f_() {
					return var1.f_();
				}

				@Override
				public void a(IChatBaseComponent var1x) {
					var1.a(var1x);
				}

				@Override
				public boolean a(int var1x, String var2) {
					return true;
				}

				@Override
				public class_cj c() {
					return var1.c();
				}

				@Override
				public class_aym d() {
					return var1.d();
				}

				@Override
				public class_ago e() {
					return var1.e();
				}

				@Override
				public Entity f() {
					return var1.f();
				}

				@Override
				public boolean s_() {
					return var1.s_();
				}

				@Override
				public void a(class_n.class_a_in_class_n var1x, int var2) {
					var1.a(var1x, var2);
				}
			};

			String var6;
			try {
				var6 = CommandAbstract.e(var5, var4);
			} catch (class_ca var11) {
				return;
			}

			String var7 = d[var2.a()];
			if (var7 != null) {
				class_ays var8 = var1.e().ab();
				class_ayo var9 = var8.b(var7);
				if (var9 != null) {
					if (var8.b(var6, var9)) {
						class_ayq var10 = var8.c(var6, var9);
						var10.c(var3);
					}
				}
			}
		}
	}

	public void a(class_dn var1) {
		if (var1.b("CommandStats", 10)) {
			class_dn var2 = var1.o("CommandStats");
			class_n.class_a_in_class_n[] var3 = class_n.class_a_in_class_n.values();
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				class_n.class_a_in_class_n var6 = var3[var5];
				String var7 = var6.b() + "Name";
				String var8 = var6.b() + "Objective";
				if (var2.b(var7, 8) && var2.b(var8, 8)) {
					String var9 = var2.l(var7);
					String var10 = var2.l(var8);
					a(this, var6, var9, var10);
				}
			}

		}
	}

	public void b(class_dn var1) {
		class_dn var2 = new class_dn();
		class_n.class_a_in_class_n[] var3 = class_n.class_a_in_class_n.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_n.class_a_in_class_n var6 = var3[var5];
			String var7 = c[var6.a()];
			String var8 = d[var6.a()];
			if ((var7 != null) && (var8 != null)) {
				var2.a(var6.b() + "Name", var7);
				var2.a(var6.b() + "Objective", var8);
			}
		}

		if (!var2.c_()) {
			var1.a("CommandStats", var2);
		}

	}

	public static void a(class_n var0, class_n.class_a_in_class_n var1, String var2, String var3) {
		if ((var2 != null) && !var2.isEmpty() && (var3 != null) && !var3.isEmpty()) {
			if ((var0.c == b) || (var0.d == b)) {
				var0.c = new String[a];
				var0.d = new String[a];
			}

			var0.c[var1.a()] = var2;
			var0.d[var1.a()] = var3;
		} else {
			a(var0, var1);
		}
	}

	private static void a(class_n var0, class_n.class_a_in_class_n var1) {
		if ((var0.c != b) && (var0.d != b)) {
			var0.c[var1.a()] = null;
			var0.d[var1.a()] = null;
			boolean var2 = true;
			class_n.class_a_in_class_n[] var3 = class_n.class_a_in_class_n.values();
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				class_n.class_a_in_class_n var6 = var3[var5];
				if ((var0.c[var6.a()] != null) && (var0.d[var6.a()] != null)) {
					var2 = false;
					break;
				}
			}

			if (var2) {
				var0.c = b;
				var0.d = b;
			}

		}
	}

	public void a(class_n var1) {
		class_n.class_a_in_class_n[] var2 = class_n.class_a_in_class_n.values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_n.class_a_in_class_n var5 = var2[var4];
			a(this, var5, var1.c[var5.a()], var1.d[var5.a()]);
		}

	}

	static {
		b = new String[a];
	}

	public static enum class_a_in_class_n {
		a(0, "SuccessCount"),
		b(1, "AffectedBlocks"),
		c(2, "AffectedEntities"),
		d(3, "AffectedItems"),
		e(4, "QueryResult");

		final int f;
		final String g;

		private class_a_in_class_n(int var3, String var4) {
			f = var3;
			g = var4;
		}

		public int a() {
			return f;
		}

		public String b() {
			return g;
		}

		public static String[] c() {
			String[] var0 = new String[values().length];
			int var1 = 0;
			class_n.class_a_in_class_n[] var2 = values();
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				class_n.class_a_in_class_n var5 = var2[var4];
				var0[var1++] = var5.b();
			}

			return var0;
		}

		public static class_n.class_a_in_class_n a(String var0) {
			class_n.class_a_in_class_n[] var1 = values();
			int var2 = var1.length;

			for (int var3 = 0; var3 < var2; ++var3) {
				class_n.class_a_in_class_n var4 = var1[var3];
				if (var4.b().equals(var0)) {
					return var4;
				}
			}

			return null;
		}
	}
}
