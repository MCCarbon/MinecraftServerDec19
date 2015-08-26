package net.minecraft.server;

import java.util.List;
import java.util.Random;

public abstract class BlockStepAbstract extends Block {
	public static final class_aqa a = class_aqa.a("half", BlockStepAbstract.class_a_in_class_akq.class);

	public BlockStepAbstract(class_avq var1) {
		super(var1);
		if (l()) {
			r = true;
		} else {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}

		this.e(255);
	}

	@Override
	protected boolean K() {
		return false;
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		if (l()) {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			class_apn var3 = var1.p(var2);
			if (var3.c() == this) {
				if (var3.b(a) == BlockStepAbstract.class_a_in_class_akq.a) {
					this.a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
				} else {
					this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
				}
			}

		}
	}

	@Override
	public void j() {
		if (l()) {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, Entity var6) {
		this.a(var1, var2);
		super.a(var1, var2, var3, var4, var5, var6);
	}

	@Override
	public boolean c() {
		return l();
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		class_apn var9 = super.a(var1, var2, var3, var4, var5, var6, var7, var8).a(a, BlockStepAbstract.class_a_in_class_akq.b);
		return l() ? var9 : ((var3 != class_cq.a) && ((var3 == class_cq.b) || (var5 <= 0.5D)) ? var9 : var9.a(a, BlockStepAbstract.class_a_in_class_akq.a));
	}

	@Override
	public int a(Random var1) {
		return l() ? 2 : 1;
	}

	@Override
	public boolean d() {
		return l();
	}

	public abstract String b(int var1);

	public abstract boolean l();

	public abstract class_aqc n();

	public abstract Object a(class_aco var1);

	public static enum class_a_in_class_akq implements class_oe {
		a("top"),
		b("bottom");

		private final String c;

		private class_a_in_class_akq(String var3) {
			c = var3;
		}

		@Override
		public String toString() {
			return c;
		}

		@Override
		public String l() {
			return c;
		}
	}
}
