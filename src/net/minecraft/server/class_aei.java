package net.minecraft.server;


public class class_aei {
	void a(class_aet var1) {
		class_abt[] var2 = class_abt.values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_abt var5 = var2[var4];
			var1.a(new class_aco(Items.cJ, 1, var5.b()), new Object[] { "###", "###", " | ", Character.valueOf('#'), new class_aco(Blocks.WOOL, 1, var5.a()), Character.valueOf('|'), Items.A });
		}

		var1.a(new class_aei.class_b_in_class_aei());
		var1.a(new class_aei.class_a_in_class_aei());
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
	}

	static class class_a_in_class_aei implements class_aes {
		private class_a_in_class_aei() {
		}

		@Override
		public boolean a(class_aab var1, class_ago var2) {
			boolean var3 = false;

			for (int var4 = 0; var4 < var1.n_(); ++var4) {
				class_aco var5 = var1.a(var4);
				if ((var5 != null) && (var5.b() == Items.cJ)) {
					if (var3) {
						return false;
					}

					if (class_aog.c(var5) >= 6) {
						return false;
					}

					var3 = true;
				}
			}

			if (!var3) {
				return false;
			} else {
				return c(var1) != null;
			}
		}

		@Override
		public class_aco a(class_aab var1) {
			class_aco var2 = null;

			for (int var3 = 0; var3 < var1.n_(); ++var3) {
				class_aco var4 = var1.a(var3);
				if ((var4 != null) && (var4.b() == Items.cJ)) {
					var2 = var4.k();
					var2.b = 1;
					break;
				}
			}

			class_aog.class_a_in_class_aog var8 = c(var1);
			if (var8 != null) {
				int var9 = 0;

				class_aco var6;
				for (int var5 = 0; var5 < var1.n_(); ++var5) {
					var6 = var1.a(var5);
					if ((var6 != null) && (var6.b() == Items.aY)) {
						var9 = var6.i();
						break;
					}
				}

				class_dn var10 = var2.a("BlockEntityTag", true);
				var6 = null;
				class_du var11;
				if (var10.b("Patterns", 9)) {
					var11 = var10.c("Patterns", 10);
				} else {
					var11 = new class_du();
					var10.a("Patterns", var11);
				}

				class_dn var7 = new class_dn();
				var7.a("Pattern", var8.b());
				var7.a("Color", var9);
				var11.a(var7);
			}

			return var2;
		}

		@Override
		public int a() {
			return 10;
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
				if ((var4 != null) && var4.b().r()) {
					var2[var3] = new class_aco(var4.b().q());
				}
			}

			return var2;
		}

		private class_aog.class_a_in_class_aog c(class_aab var1) {
			class_aog.class_a_in_class_aog[] var2 = class_aog.class_a_in_class_aog.values();
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				class_aog.class_a_in_class_aog var5 = var2[var4];
				if (var5.d()) {
					boolean var6 = true;
					int var9;
					if (var5.e()) {
						boolean var7 = false;
						boolean var8 = false;

						for (var9 = 0; (var9 < var1.n_()) && var6; ++var9) {
							class_aco var10 = var1.a(var9);
							if ((var10 != null) && (var10.b() != Items.cJ)) {
								if (var10.b() == Items.aY) {
									if (var8) {
										var6 = false;
										break;
									}

									var8 = true;
								} else {
									if (var7 || !var10.a(var5.f())) {
										var6 = false;
										break;
									}

									var7 = true;
								}
							}
						}

						if (!var7) {
							var6 = false;
						}
					} else if (var1.n_() == (var5.c().length * var5.c()[0].length())) {
						int var12 = -1;

						for (int var13 = 0; (var13 < var1.n_()) && var6; ++var13) {
							var9 = var13 / 3;
							int var14 = var13 % 3;
							class_aco var11 = var1.a(var13);
							if ((var11 != null) && (var11.b() != Items.cJ)) {
								if (var11.b() != Items.aY) {
									var6 = false;
									break;
								}

								if ((var12 != -1) && (var12 != var11.i())) {
									var6 = false;
									break;
								}

								if (var5.c()[var9].charAt(var14) == 32) {
									var6 = false;
									break;
								}

								var12 = var11.i();
							} else if (var5.c()[var9].charAt(var14) != 32) {
								var6 = false;
								break;
							}
						}
					} else {
						var6 = false;
					}

					if (var6) {
						return var5;
					}
				}
			}

			return null;
		}

		// $FF: synthetic method
		class_a_in_class_aei(class_aei.SyntheticClass_1 var1) {
			this();
		}
	}

	static class class_b_in_class_aei implements class_aes {
		private class_b_in_class_aei() {
		}

		@Override
		public boolean a(class_aab var1, class_ago var2) {
			class_aco var3 = null;
			class_aco var4 = null;

			for (int var5 = 0; var5 < var1.n_(); ++var5) {
				class_aco var6 = var1.a(var5);
				if (var6 != null) {
					if (var6.b() != Items.cJ) {
						return false;
					}

					if ((var3 != null) && (var4 != null)) {
						return false;
					}

					int var7 = class_aog.b(var6);
					boolean var8 = class_aog.c(var6) > 0;
					if (var3 != null) {
						if (var8) {
							return false;
						}

						if (var7 != class_aog.b(var3)) {
							return false;
						}

						var4 = var6;
					} else if (var4 != null) {
						if (!var8) {
							return false;
						}

						if (var7 != class_aog.b(var4)) {
							return false;
						}

						var3 = var6;
					} else if (var8) {
						var3 = var6;
					} else {
						var4 = var6;
					}
				}
			}

			return (var3 != null) && (var4 != null);
		}

		@Override
		public class_aco a(class_aab var1) {
			for (int var2 = 0; var2 < var1.n_(); ++var2) {
				class_aco var3 = var1.a(var2);
				if ((var3 != null) && (class_aog.c(var3) > 0)) {
					class_aco var4 = var3.k();
					var4.b = 1;
					return var4;
				}
			}

			return null;
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
					} else if (var4.n() && (class_aog.c(var4) > 0)) {
						var2[var3] = var4.k();
						var2[var3].b = 1;
					}
				}
			}

			return var2;
		}

		// $FF: synthetic method
		class_b_in_class_aei(class_aei.SyntheticClass_1 var1) {
			this();
		}
	}
}
