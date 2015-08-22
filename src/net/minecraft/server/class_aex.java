package net.minecraft.server;


public class class_aex {
	public void a(class_aet var1) {
		class_abt[] var2 = class_abt.values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_abt var5 = var2[var4];
			class_aco var6 = new class_aco(Items.cK, 1, 0);
			class_aog.a(var6, var5);
			var1.a(var6, new Object[] { "#W ", "#Wo", "#W ", Character.valueOf('#'), new class_aco(Blocks.L, 1, var5.a()), Character.valueOf('W'), Blocks.f, Character.valueOf('o'), Items.l });
		}

		var1.a(new class_aex.class_a_in_class_aex());
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
	}

	static class class_a_in_class_aex implements class_aes {
		private class_a_in_class_aex() {
		}

		@Override
		public boolean a(class_aab var1, class_ago var2) {
			class_aco var3 = null;
			class_aco var4 = null;

			for (int var5 = 0; var5 < var1.n_(); ++var5) {
				class_aco var6 = var1.a(var5);
				if (var6 != null) {
					if (var6.b() == Items.cJ) {
						if (var4 != null) {
							return false;
						}

						if (class_aog.c(var6) == 0) {
							return false;
						}

						var4 = var6;
					} else {
						if (var6.b() != Items.cK) {
							return false;
						}

						if (var3 != null) {
							return false;
						}

						if (class_aog.c(var6) > 0) {
							return false;
						}

						var3 = var6;
					}
				}
			}

			if ((var3 != null) && (var4 != null)) {
				if (class_aog.b(var3) != class_aog.b(var4)) {
					return false;
				} else {
					return true;
				}
			} else {
				return false;
			}
		}

		@Override
		public class_aco a(class_aab var1) {
			class_aco var2 = null;

			for (int var3 = 0; var3 < var1.n_(); ++var3) {
				class_aco var4 = var1.a(var3);
				if ((var4 != null) && (var4.b() == Items.cJ)) {
					var2 = var4;
				}
			}

			class_aco var5 = new class_aco(Items.cK, 1, 0);
			var5.d((class_dn) var2.o().b());
			class_aog.a(var5, class_abt.a(class_aog.b(var2)));
			return var5;
		}

		@Override
		public int a() {
			return 2;
		}

		@Override
		public class_aco b() {
			return null;
		}

		@Override
		public class_aco[] b(class_aab var1) {
			class_aco[] var2 = new class_aco[var1.n_()];

			for (int var3 = 0; var3 < var2.length; ++var3) {
				class_aco var4 = var1.a(var3);
				if (var4 != null) {
					if (var4.b().r()) {
						var2[var3] = new class_aco(var4.b().q());
					} else if (var4.b() == Items.cJ) {
						var2[var3] = var4.k();
					}
				}
			}

			return var2;
		}

		// $FF: synthetic method
		class_a_in_class_aex(class_aex.SyntheticClass_1 var1) {
			this();
		}
	}
}
