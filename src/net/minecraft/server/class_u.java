package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.Lists;

public class class_u extends CommandAbstract {
	@Override
	public String getCommand() {
		return "clone";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.clone.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 9) {
			throw new class_cf("commands.clone.usage", new Object[0]);
		} else {
			var1.a(class_n.class_a_in_class_n.b, 0);
			class_cj var3 = a(var1, var2, 0, false);
			class_cj var4 = a(var1, var2, 3, false);
			class_cj var5 = a(var1, var2, 6, false);
			class_aua var6 = new class_aua(var3, var4);
			class_aua var7 = new class_aua(var5, var5.a(var6.b()));
			int var8 = var6.c() * var6.d() * var6.e();
			if (var8 > '耀') {
				throw new class_bz("commands.clone.tooManyBlocks", new Object[] { Integer.valueOf(var8), Integer.valueOf('耀') });
			} else {
				boolean var9 = false;
				Block var10 = null;
				int var11 = -1;
				if (((var2.length < 11) || (!var2[10].equals("force") && !var2[10].equals("move"))) && var6.a(var7)) {
					throw new class_bz("commands.clone.noOverlap", new Object[0]);
				} else {
					if ((var2.length >= 11) && var2[10].equals("move")) {
						var9 = true;
					}

					if ((var6.b >= 0) && (var6.e < 256) && (var7.b >= 0) && (var7.e < 256)) {
						class_ago var12 = var1.e();
						if (var12.a(var6) && var12.a(var7)) {
							boolean var13 = false;
							if (var2.length >= 10) {
								if (var2[9].equals("masked")) {
									var13 = true;
								} else if (var2[9].equals("filtered")) {
									if (var2.length < 12) {
										throw new class_cf("commands.clone.usage", new Object[0]);
									}

									var10 = g(var1, var2[11]);
									if (var2.length >= 13) {
										var11 = a(var2[12], 0, 15);
									}
								}
							}

							ArrayList var14 = Lists.newArrayList();
							ArrayList var15 = Lists.newArrayList();
							ArrayList var16 = Lists.newArrayList();
							LinkedList var17 = Lists.newLinkedList();
							class_cj var18 = new class_cj(var7.a - var6.a, var7.b - var6.b, var7.c - var6.c);

							for (int var19 = var6.c; var19 <= var6.f; ++var19) {
								for (int var20 = var6.b; var20 <= var6.e; ++var20) {
									for (int var21 = var6.a; var21 <= var6.d; ++var21) {
										class_cj var22 = new class_cj(var21, var20, var19);
										class_cj var23 = var22.a(var18);
										class_apn var24 = var12.p(var22);
										if ((!var13 || (var24.c() != Blocks.a)) && ((var10 == null) || ((var24.c() == var10) && ((var11 < 0) || (var24.c().c(var24) == var11))))) {
											TileEntity var25 = var12.s(var22);
											if (var25 != null) {
												class_dn var26 = new class_dn();
												var25.b(var26);
												var15.add(new class_u.class_a_in_class_u(var23, var24, var26));
												var17.addLast(var22);
											} else if (!var24.c().q() && !var24.c().d()) {
												var16.add(new class_u.class_a_in_class_u(var23, var24, (class_dn) null));
												var17.addFirst(var22);
											} else {
												var14.add(new class_u.class_a_in_class_u(var23, var24, (class_dn) null));
												var17.addLast(var22);
											}
										}
									}
								}
							}

							if (var9) {
								Iterator var27;
								class_cj var29;
								for (var27 = var17.iterator(); var27.hasNext(); var12.a(var29, Blocks.cv.S(), 2)) {
									var29 = (class_cj) var27.next();
									TileEntity var31 = var12.s(var29);
									if (var31 instanceof class_pp) {
										((class_pp) var31).l();
									}
								}

								var27 = var17.iterator();

								while (var27.hasNext()) {
									var29 = (class_cj) var27.next();
									var12.a(var29, Blocks.a.S(), 3);
								}
							}

							ArrayList var28 = Lists.newArrayList();
							var28.addAll(var14);
							var28.addAll(var15);
							var28.addAll(var16);
							List var30 = Lists.reverse(var28);

							Iterator var32;
							class_u.class_a_in_class_u var33;
							TileEntity var34;
							for (var32 = var30.iterator(); var32.hasNext(); var12.a(var33.a, Blocks.cv.S(), 2)) {
								var33 = (class_u.class_a_in_class_u) var32.next();
								var34 = var12.s(var33.a);
								if (var34 instanceof class_pp) {
									((class_pp) var34).l();
								}
							}

							var8 = 0;
							var32 = var28.iterator();

							while (var32.hasNext()) {
								var33 = (class_u.class_a_in_class_u) var32.next();
								if (var12.a(var33.a, var33.b, 2)) {
									++var8;
								}
							}

							for (var32 = var15.iterator(); var32.hasNext(); var12.a(var33.a, var33.b, 2)) {
								var33 = (class_u.class_a_in_class_u) var32.next();
								var34 = var12.s(var33.a);
								if ((var33.c != null) && (var34 != null)) {
									var33.c.a("x", var33.a.n());
									var33.c.a("y", var33.a.o());
									var33.c.a("z", var33.a.p());
									var34.a(var33.c);
									var34.o_();
								}
							}

							var32 = var30.iterator();

							while (var32.hasNext()) {
								var33 = (class_u.class_a_in_class_u) var32.next();
								var12.c(var33.a, var33.b.c());
							}

							List var35 = var12.a(var6, false);
							if (var35 != null) {
								Iterator var36 = var35.iterator();

								while (var36.hasNext()) {
									class_agz var37 = (class_agz) var36.next();
									if (var6.b(var37.a)) {
										class_cj var38 = var37.a.a(var18);
										var12.b(var38, var37.a(), (int) (var37.b - var12.R().e()), var37.c);
									}
								}
							}

							if (var8 <= 0) {
								throw new class_bz("commands.clone.failed", new Object[0]);
							} else {
								var1.a(class_n.class_a_in_class_n.b, var8);
								a(var1, this, "commands.clone.success", new Object[] { Integer.valueOf(var8) });
							}
						} else {
							throw new class_bz("commands.clone.outOfWorld", new Object[0]);
						}
					} else {
						throw new class_bz("commands.clone.outOfWorld", new Object[0]);
					}
				}
			}
		}
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return (var2.length > 0) && (var2.length <= 3) ? a(var2, 0, var3) : ((var2.length > 3) && (var2.length <= 6) ? a(var2, 3, var3) : ((var2.length > 6) && (var2.length <= 9) ? a(var2, 6, var3) : (var2.length == 10 ? a(var2, new String[] { "replace", "masked", "filtered" }) : (var2.length == 11 ? a(var2, new String[] { "normal", "force", "move" }) : ((var2.length == 12) && "filtered".equals(var2[9]) ? a(var2, Block.c.c()) : null)))));
	}

	static class class_a_in_class_u {
		public final class_cj a;
		public final class_apn b;
		public final class_dn c;

		public class_a_in_class_u(class_cj var1, class_apn var2, class_dn var3) {
			a = var1;
			b = var2;
			c = var3;
		}
	}
}
