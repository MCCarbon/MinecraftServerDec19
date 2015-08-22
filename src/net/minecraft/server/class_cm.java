package net.minecraft.server;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;

public class class_cm {
	public static Iterable a(Class var0, Iterable var1) {
		return new class_cm.class_b_in_class_cm(var0, (Iterable[]) b(Iterable.class, var1));
	}

	public static Iterable a(Iterable var0) {
		return b(a(Object.class, var0));
	}

	private static Iterable b(Iterable var0) {
		return Iterables.transform(var0, new class_cm.class_a_in_class_cm());
	}

	private static Object[] b(Class var0, Iterable var1) {
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			Object var4 = var3.next();
			var2.add(var4);
		}

		return var2.toArray(b(var0, var2.size()));
	}

	private static Object[] b(Class var0, int var1) {
		return ((Object[]) Array.newInstance(var0, var1));
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
	}

	static class class_b_in_class_cm implements Iterable {
		private final Class a;
		private final Iterable[] b;

		private class_b_in_class_cm(Class var1, Iterable[] var2) {
			a = var1;
			b = var2;
		}

		@Override
		public Iterator iterator() {
			return b.length <= 0 ? Collections.singletonList(class_cm.b(a, 0)).iterator() : new class_cm.class_b_in_class_cm.class_b_in_class_cm$class_a_in_class_b_in_class_cm(a, b);
		}

		// $FF: synthetic method
		class_b_in_class_cm(Class var1, Iterable[] var2, class_cm.SyntheticClass_1 var3) {
			this(var1, var2);
		}

		static class class_b_in_class_cm$class_a_in_class_b_in_class_cm extends UnmodifiableIterator {
			private int a;
			private final Iterable[] b;
			private final Iterator[] c;
			private final Object[] d;

			private class_b_in_class_cm$class_a_in_class_b_in_class_cm(Class var1, Iterable[] var2) {
				a = -2;
				b = var2;
				c = (Iterator[]) class_cm.b(Iterator.class, b.length);

				for (int var3 = 0; var3 < b.length; ++var3) {
					c[var3] = var2[var3].iterator();
				}

				d = class_cm.b(var1, c.length);
			}

			private void b() {
				a = -1;
				Arrays.fill(c, (Object) null);
				Arrays.fill(d, (Object) null);
			}

			@Override
			public boolean hasNext() {
				if (a == -2) {
					a = 0;
					Iterator[] var5 = c;
					int var2 = var5.length;

					for (int var3 = 0; var3 < var2; ++var3) {
						Iterator var4 = var5[var3];
						if (!var4.hasNext()) {
							this.b();
							break;
						}
					}

					return true;
				} else {
					if (a >= c.length) {
						for (a = c.length - 1; a >= 0; --a) {
							Iterator var1 = c[a];
							if (var1.hasNext()) {
								break;
							}

							if (a == 0) {
								this.b();
								break;
							}

							var1 = b[a].iterator();
							c[a] = var1;
							if (!var1.hasNext()) {
								this.b();
								break;
							}
						}
					}

					return a >= 0;
				}
			}

			public Object[] a() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				} else {
					while (a < c.length) {
						d[a] = c[a].next();
						++a;
					}

					return d.clone();
				}
			}

			// $FF: synthetic method
			@Override
			public Object next() {
				return this.a();
			}

			// $FF: synthetic method
			class_b_in_class_cm$class_a_in_class_b_in_class_cm(Class var1, Iterable[] var2, class_cm.SyntheticClass_1 var3) {
				this(var1, var2);
			}
		}
	}

	static class class_a_in_class_cm implements Function {
		private class_a_in_class_cm() {
		}

		public List a(Object[] var1) {
			return Arrays.asList(var1);
		}

		// $FF: synthetic method
		@Override
		public Object apply(Object var1) {
			return this.a((Object[]) var1);
		}

		// $FF: synthetic method
		class_a_in_class_cm(class_cm.SyntheticClass_1 var1) {
			this();
		}
	}
}
