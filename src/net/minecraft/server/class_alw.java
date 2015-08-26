package net.minecraft.server;

import java.util.Random;

public class class_alw extends Block {
	public class_alw() {
		this(class_avq.e.r());
	}

	public class_alw(class_avr var1) {
		super(class_avq.e, var1);
		this.a(class_abp.b);
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return this == Blocks.COAL_ORE ? Items.j : (this == Blocks.ag ? Items.k : (this == Blocks.LAPIS_ORE ? Items.aY : (this == Blocks.bP ? Items.bT : (this == Blocks.co ? Items.cl : Item.a(this)))));
	}

	@Override
	public int a(Random var1) {
		return this == Blocks.LAPIS_ORE ? 4 + var1.nextInt(5) : 1;
	}

	@Override
	public int a(int var1, Random var2) {
		if ((var1 > 0) && (Item.a(this) != this.a((class_apn) R().a().iterator().next(), var2, var1))) {
			int var3 = var2.nextInt(var1 + 2) - 1;
			if (var3 < 0) {
				var3 = 0;
			}

			return this.a(var2) * (var3 + 1);
		} else {
			return this.a(var2);
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		if (this.a(var3, var1.s, var5) != Item.a(this)) {
			int var6 = 0;
			if (this == Blocks.COAL_ORE) {
				var6 = class_oa.a(var1.s, 0, 2);
			} else if (this == Blocks.ag) {
				var6 = class_oa.a(var1.s, 3, 7);
			} else if (this == Blocks.bP) {
				var6 = class_oa.a(var1.s, 3, 7);
			} else if (this == Blocks.LAPIS_ORE) {
				var6 = class_oa.a(var1.s, 2, 5);
			} else if (this == Blocks.co) {
				var6 = class_oa.a(var1.s, 2, 5);
			}

			this.b(var1, var2, var6);
		}

	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(this);
	}

	@Override
	public int a(class_apn var1) {
		return this == Blocks.LAPIS_ORE ? class_abt.l.b() : 0;
	}
}
