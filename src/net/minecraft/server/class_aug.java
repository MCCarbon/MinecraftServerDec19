package net.minecraft.server;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class class_aug extends class_auo {
	private List d = Lists.newArrayList();

	public class_aug() {
		d.add(new class_ahb.class_c_in_class_ahb(class_xs.class, 10, 2, 3));
		d.add(new class_ahb.class_c_in_class_ahb(class_yd.class, 5, 4, 4));
		d.add(new class_ahb.class_c_in_class_ahb(class_yh.class, 10, 4, 4));
		d.add(new class_ahb.class_c_in_class_ahb(class_yb.class, 3, 4, 4));
	}

	@Override
	public String a() {
		return "Fortress";
	}

	public List b() {
		return d;
	}

	@Override
	protected boolean a(int var1, int var2) {
		int var3 = var1 >> 4;
		int var4 = var2 >> 4;
		b.setSeed(var3 ^ (var4 << 4) ^ c.L());
		b.nextInt();
		return b.nextInt(3) != 0 ? false : (var1 != ((var3 << 4) + 4 + b.nextInt(8)) ? false : var2 == ((var4 << 4) + 4 + b.nextInt(8)));
	}

	@Override
	protected class_aus b(int var1, int var2) {
		return new class_aug.class_a_in_class_aug(c, b, var1, var2);
	}

	public static class class_a_in_class_aug extends class_aus {
		public class_a_in_class_aug() {
		}

		public class_a_in_class_aug(class_ago var1, Random var2, int var3, int var4) {
			super(var3, var4);
			class_auh.class_q_in_class_auh var5 = new class_auh.class_q_in_class_auh(var2, (var3 << 4) + 2, (var4 << 4) + 2);
			a.add(var5);
			var5.a(var5, a, var2);
			List var6 = var5.e;

			while (!var6.isEmpty()) {
				int var7 = var2.nextInt(var6.size());
				class_aur var8 = (class_aur) var6.remove(var7);
				var8.a(var5, a, var2);
			}

			d();
			this.a(var1, var2, 48, 70);
		}
	}
}
