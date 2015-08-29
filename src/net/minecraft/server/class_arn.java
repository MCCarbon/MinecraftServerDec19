package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class class_arn implements class_aqk {
	private static final List a = Lists.newArrayList();
	private static final int b;
	private static final int c;
	private final class_ago d;

	public class_arn(class_ago var1) {
		d = var1;
	}

	@Override
	public class_aqn d(int var1, int var2) {
		class_arl var3 = new class_arl();

		int var7;
		for (int var4 = 0; var4 < 16; ++var4) {
			for (int var5 = 0; var5 < 16; ++var5) {
				int var6 = (var1 * 16) + var4;
				var7 = (var2 * 16) + var5;
				var3.a(var4, 60, var5, Blocks.BARRIER.getBlockData());
				class_apn var8 = b(var6, var7);
				if (var8 != null) {
					var3.a(var4, 70, var5, var8);
				}
			}
		}

		class_aqn var9 = new class_aqn(d, var3, var1, var2);
		var9.b();
		class_ahb[] var10 = d.y().b((class_ahb[]) null, var1 * 16, var2 * 16, 16, 16);
		byte[] var11 = var9.l();

		for (var7 = 0; var7 < var11.length; ++var7) {
			var11[var7] = (byte) var10[var7].az;
		}

		var9.b();
		return var9;
	}

	public static class_apn b(int var0, int var1) {
		class_apn var2 = null;
		if ((var0 > 0) && (var1 > 0) && ((var0 % 2) != 0) && ((var1 % 2) != 0)) {
			var0 /= 2;
			var1 /= 2;
			if ((var0 <= b) && (var1 <= c)) {
				int var3 = MathHelper.a((var0 * b) + var1);
				if (var3 < a.size()) {
					var2 = (class_apn) a.get(var3);
				}
			}
		}

		return var2;
	}

	@Override
	public boolean a(int var1, int var2) {
		return true;
	}

	@Override
	public void a(class_aqk var1, int var2, int var3) {
	}

	@Override
	public boolean a(class_aqk var1, class_aqn var2, int var3, int var4) {
		return false;
	}

	@Override
	public boolean a(boolean var1, class_oc var2) {
		return true;
	}

	@Override
	public void c() {
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean e() {
		return true;
	}

	@Override
	public String f() {
		return "DebugLevelSource";
	}

	@Override
	public List a(class_ri var1, class_cj var2) {
		class_ahb var3 = d.b(var2);
		return var3.a(var1);
	}

	@Override
	public class_cj a(class_ago var1, String var2, class_cj var3) {
		return null;
	}

	@Override
	public int g() {
		return 0;
	}

	@Override
	public void a(class_aqn var1, int var2, int var3) {
	}

	@Override
	public class_aqn a(class_cj var1) {
		return this.d(var1.n() >> 4, var1.p() >> 4);
	}

	static {
		Iterator var0 = Block.c.iterator();

		while (var0.hasNext()) {
			Block var1 = (Block) var0.next();
			a.addAll(var1.R().a());
		}

		b = MathHelper.f(MathHelper.c((float) a.size()));
		c = MathHelper.f((float) a.size() / (float) b);
	}
}
