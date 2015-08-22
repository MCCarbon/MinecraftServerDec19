package net.minecraft.server;

public class class_avr {
	public static final class_avr[] a = new class_avr[64];
	public static final class_avr b = new class_avr(0, 0);
	public static final class_avr c = new class_avr(1, 8368696);
	public static final class_avr d = new class_avr(2, 16247203);
	public static final class_avr e = new class_avr(3, 13092807);
	public static final class_avr f = new class_avr(4, 16711680);
	public static final class_avr g = new class_avr(5, 10526975);
	public static final class_avr h = new class_avr(6, 10987431);
	public static final class_avr i = new class_avr(7, 31744);
	public static final class_avr j = new class_avr(8, 16777215);
	public static final class_avr k = new class_avr(9, 10791096);
	public static final class_avr l = new class_avr(10, 9923917);
	public static final class_avr m = new class_avr(11, 7368816);
	public static final class_avr n = new class_avr(12, 4210943);
	public static final class_avr o = new class_avr(13, 9402184);
	public static final class_avr p = new class_avr(14, 16776437);
	public static final class_avr q = new class_avr(15, 14188339);
	public static final class_avr r = new class_avr(16, 11685080);
	public static final class_avr s = new class_avr(17, 6724056);
	public static final class_avr t = new class_avr(18, 15066419);
	public static final class_avr u = new class_avr(19, 8375321);
	public static final class_avr v = new class_avr(20, 15892389);
	public static final class_avr w = new class_avr(21, 5000268);
	public static final class_avr x = new class_avr(22, 10066329);
	public static final class_avr y = new class_avr(23, 5013401);
	public static final class_avr z = new class_avr(24, 8339378);
	public static final class_avr A = new class_avr(25, 3361970);
	public static final class_avr B = new class_avr(26, 6704179);
	public static final class_avr C = new class_avr(27, 6717235);
	public static final class_avr D = new class_avr(28, 10040115);
	public static final class_avr E = new class_avr(29, 1644825);
	public static final class_avr F = new class_avr(30, 16445005);
	public static final class_avr G = new class_avr(31, 6085589);
	public static final class_avr H = new class_avr(32, 4882687);
	public static final class_avr I = new class_avr(33, '\ud93a');
	public static final class_avr J = new class_avr(34, 8476209);
	public static final class_avr K = new class_avr(35, 7340544);
	public final int L;
	public final int M;

	private class_avr(int var1, int var2) {
		if ((var1 >= 0) && (var1 <= 63)) {
			M = var1;
			L = var2;
			a[var1] = this;
		} else {
			throw new IndexOutOfBoundsException("Map colour ID must be between 0 and 63 (inclusive)");
		}
	}
}
