package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;

public class class_ahz extends class_ahe {
	private static final LoadingCache M;
	private final class_atm N = new class_atm();

	@Override
	protected void a(class_ahb var1) {
		this.a();
		class_atm.class_a_in_class_atm[] var2 = a(a);
		class_atm.class_a_in_class_atm[] var3 = var2;
		int var4 = var2.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_atm.class_a_in_class_atm var6 = var3[var5];
			if (var6.a(c)) {
				N.a(var6);
				N.b(a, b, new class_cj(var6.a(), 45, var6.b()));
			}
		}

	}

	public static class_atm.class_a_in_class_atm[] a(class_ago var0) {
		Random var1 = new Random(var0.L());
		long var2 = var1.nextLong() & 65535L;
		return (class_atm.class_a_in_class_atm[]) M.getUnchecked(Long.valueOf(var2));
	}

	static {
		M = CacheBuilder.newBuilder().expireAfterWrite(5L, TimeUnit.MINUTES).build(new class_ahz.class_a_in_class_ahz());
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
	}

	static class class_a_in_class_ahz extends CacheLoader {
		private class_a_in_class_ahz() {
		}

		public class_atm.class_a_in_class_atm[] a(Long var1) throws Exception {
			ArrayList var2 = Lists.newArrayList((Iterable) ContiguousSet.create(Range.closedOpen(Integer.valueOf(0), Integer.valueOf(10)), DiscreteDomain.integers()));
			Collections.shuffle(var2, new Random(var1.longValue()));
			class_atm.class_a_in_class_atm[] var3 = new class_atm.class_a_in_class_atm[10];

			for (int var4 = 0; var4 < 10; ++var4) {
				int var5 = (int) (42.0D * Math.cos(2.0D * (-3.141592653589793D + (0.3141592653589793D * var4))));
				int var6 = (int) (42.0D * Math.sin(2.0D * (-3.141592653589793D + (0.3141592653589793D * var4))));
				int var7 = ((Integer) var2.get(var4)).intValue();
				int var8 = 2 + (var7 / 3);
				int var9 = 76 + (var7 * 3);
				boolean var10 = var7 > 5;
				var3[var4] = new class_atm.class_a_in_class_atm(var5, var6, var8, var9, var10);
			}

			return var3;
		}

		// $FF: synthetic method
		@Override
		public Object load(Object var1) throws Exception {
			return this.a((Long) var1);
		}

		// $FF: synthetic method
		class_a_in_class_ahz(class_ahz.SyntheticClass_1 var1) {
			this();
		}
	}
}
