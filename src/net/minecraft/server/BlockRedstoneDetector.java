package net.minecraft.server;

import java.util.Random;

public class BlockRedstoneDetector extends class_aif {
	public static final class_aqb a = class_aqb.a("power", 0, 15);
	private final boolean b;

	public BlockRedstoneDetector(boolean var1) {
		super(class_avq.d);
		b = var1;
		this.j(M.b().a(a, Integer.valueOf(0)));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
		this.a(class_abp.d);
		this.c(0.2F);
		this.a(f);
		this.c("daylightDetector");
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
	}

	@Override
	public int a(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return ((Integer) var3.b(a)).intValue();
	}

	public void e(class_ago var1, class_cj var2) {
		if (!var1.t.m()) {
			class_apn var3 = var1.p(var2);
			int var4 = var1.b(class_agu.a, var2) - var1.ad();
			float var5 = var1.d(1.0F);
			float var6 = var5 < 3.1415927F ? 0.0F : 6.2831855F;
			var5 += (var6 - var5) * 0.2F;
			var4 = Math.round(var4 * class_oa.b(var5));
			var4 = class_oa.a(var4, 0, 15);
			if (b) {
				var4 = 15 - var4;
			}

			if (((Integer) var3.b(a)).intValue() != var4) {
				var1.a(var2, var3.a(a, Integer.valueOf(var4)), 3);
			}

		}
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var4.cv()) {
			if (var1.D) {
				return true;
			} else {
				if (b) {
					var1.a(var2, Blocks.DAYLIGHT_DETECTOR.S().a(a, var3.b(a)), 4);
					Blocks.DAYLIGHT_DETECTOR.e(var1, var2);
				} else {
					var1.a(var2, Blocks.DAYLIGHT_DETECTOR_INVERTED.S().a(a, var3.b(a)), 4);
					Blocks.DAYLIGHT_DETECTOR_INVERTED.e(var1, var2);
				}

				return true;
			}
		} else {
			return super.a(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
		}
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Item.a(Blocks.DAYLIGHT_DETECTOR);
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Blocks.DAYLIGHT_DETECTOR);
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public int b() {
		return 3;
	}

	@Override
	public boolean i() {
		return true;
	}

	@Override
	public TileEntity a(class_ago var1, int var2) {
		return new class_aon();
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, Integer.valueOf(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}
}
