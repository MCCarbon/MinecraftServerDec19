package net.minecraft.server;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class class_apk {
	private final class_ago a;
	private final class_cj b;
	private final class_cj c;
	private final class_cq d;
	private final List e = Lists.newArrayList();
	private final List f = Lists.newArrayList();

	public class_apk(class_ago var1, class_cj var2, class_cq var3, boolean var4) {
		a = var1;
		b = var2;
		if (var4) {
			d = var3;
			c = var2.a(var3);
		} else {
			d = var3.d();
			c = var2.a(var3, 2);
		}

	}

	public boolean a() {
		e.clear();
		f.clear();
		class_ail var1 = a.p(c).c();
		if (!class_apg.a(var1, a, c, d, false)) {
			if (var1.k() != 1) {
				return false;
			} else {
				f.add(c);
				return true;
			}
		} else if (!this.a(c)) {
			return false;
		} else {
			for (int var2 = 0; var2 < e.size(); ++var2) {
				class_cj var3 = (class_cj) e.get(var2);
				if ((a.p(var3).c() == class_aim.cE) && !b(var3)) {
					return false;
				}
			}

			return true;
		}
	}

	private boolean a(class_cj var1) {
		class_ail var2 = a.p(var1).c();
		if (var2.v() == class_avq.a) {
			return true;
		} else if (!class_apg.a(var2, a, var1, d, false)) {
			return true;
		} else if (var1.equals(b)) {
			return true;
		} else if (e.contains(var1)) {
			return true;
		} else {
			int var3 = 1;
			if ((var3 + e.size()) > 12) {
				return false;
			} else {
				while (var2 == class_aim.cE) {
					class_cj var4 = var1.a(d.d(), var3);
					var2 = a.p(var4).c();
					if ((var2.v() == class_avq.a) || !class_apg.a(var2, a, var4, d, false) || var4.equals(b)) {
						break;
					}

					++var3;
					if ((var3 + e.size()) > 12) {
						return false;
					}
				}

				int var10 = 0;

				int var5;
				for (var5 = var3 - 1; var5 >= 0; --var5) {
					e.add(var1.a(d.d(), var5));
					++var10;
				}

				var5 = 1;

				while (true) {
					class_cj var6 = var1.a(d, var5);
					int var7 = e.indexOf(var6);
					if (var7 > -1) {
						this.a(var10, var7);

						for (int var8 = 0; var8 <= (var7 + var10); ++var8) {
							class_cj var9 = (class_cj) e.get(var8);
							if ((a.p(var9).c() == class_aim.cE) && !b(var9)) {
								return false;
							}
						}

						return true;
					}

					var2 = a.p(var6).c();
					if (var2.v() == class_avq.a) {
						return true;
					}

					if (!class_apg.a(var2, a, var6, d, true) || var6.equals(b)) {
						return false;
					}

					if (var2.k() == 1) {
						f.add(var6);
						return true;
					}

					if (e.size() >= 12) {
						return false;
					}

					e.add(var6);
					++var10;
					++var5;
				}
			}
		}
	}

	private void a(int var1, int var2) {
		ArrayList var3 = Lists.newArrayList();
		ArrayList var4 = Lists.newArrayList();
		ArrayList var5 = Lists.newArrayList();
		var3.addAll(e.subList(0, var2));
		var4.addAll(e.subList(e.size() - var1, e.size()));
		var5.addAll(e.subList(var2, e.size() - var1));
		e.clear();
		e.addAll(var3);
		e.addAll(var4);
		e.addAll(var5);
	}

	private boolean b(class_cj var1) {
		class_cq[] var2 = class_cq.values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_cq var5 = var2[var4];
			if ((var5.k() != d.k()) && !this.a(var1.a(var5))) {
				return false;
			}
		}

		return true;
	}

	public List c() {
		return e;
	}

	public List d() {
		return f;
	}
}
