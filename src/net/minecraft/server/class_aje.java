package net.minecraft.server;


public class class_aje extends class_ail {
	protected class_aje() {
		super(class_avq.d);
		this.a(class_abp.c);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var1.D) {
			return true;
		} else {
			var4.a((new class_aje.class_a_in_class_aje(var1, var2)));
			var4.b(class_nh.aa);
			return true;
		}
	}

	public static class class_a_in_class_aje implements class_pv {
		private final class_ago a;
		private final class_cj b;

		public class_a_in_class_aje(class_ago var1, class_cj var2) {
			a = var1;
			b = var2;
		}

		@Override
		public String e_() {
			return null;
		}

		@Override
		public boolean k_() {
			return false;
		}

		@Override
		public class_eu f_() {
			return new class_fb(class_aim.ai.a() + ".name", new Object[0]);
		}

		@Override
		public class_zu a(class_yt var1, class_yu var2) {
			return new class_aac(var1, a, b);
		}

		@Override
		public String k() {
			return "minecraft:crafting_table";
		}
	}
}
