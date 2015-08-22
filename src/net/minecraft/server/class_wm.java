package net.minecraft.server;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class class_wm {
	private static class_wm[] k = new class_wm[0];
	public static final class_wm a = a(class_wd.class, "HoldingPattern");
	public static final class_wm b = a(class_wk.class, "StrafePlayer");
	public static final class_wm c = a(class_we.class, "LandingApproach");
	public static final class_wm d = a(class_wf.class, "Landing");
	public static final class_wm e = a(class_wl.class, "Takeoff");
	public static final class_wm f = a(class_wi.class, "SittingFlaming");
	public static final class_wm g = a(class_wj.class, "SittingScanning");
	public static final class_wm h = a(class_wh.class, "SittingAttacking");
	public static final class_wm i = a(class_wb.class, "ChargingPlayer");
	public static final class_wm j = a(class_wc.class, "Dying");
	private final Class l;
	private final int m;
	private final String n;

	private class_wm(int var1, Class var2, String var3) {
		m = var1;
		l = var2;
		n = var3;
	}

	public class_wg a(class_vx var1) {
		try {
			Constructor var2 = this.a();
			return (class_wg) var2.newInstance(new Object[] { var1 });
		} catch (Exception var3) {
			throw new Error(var3);
		}
	}

	protected Constructor a() throws NoSuchMethodException {
		return l.getConstructor(new Class[] { class_vx.class });
	}

	public int b() {
		return m;
	}

	@Override
	public String toString() {
		return n + " (#" + m + ")";
	}

	public static class_wm a(int var0) {
		return (var0 >= 0) && (var0 < k.length) ? k[var0] : a;
	}

	public static int c() {
		return k.length;
	}

	private static class_wm a(Class var0, String var1) {
		class_wm var2 = new class_wm(k.length, var0, var1);
		k = Arrays.copyOf(k, k.length + 1);
		k[var2.b()] = var2;
		return var2;
	}
}
