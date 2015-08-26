package net.minecraft.server;

import java.util.Random;

public class class_akl extends Block {
	public class_akl(class_avq var1) {
		super(var1);
		this.a(class_abp.b);
	}

	@Override
	public int a(int var1, Random var2) {
		return MathHelper.a(this.a(var2) + var2.nextInt(var1 + 1), 1, 4);
	}

	@Override
	public int a(Random var1) {
		return 2 + var1.nextInt(3);
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Items.aV;
	}

	@Override
	public class_avr g(class_apn var1) {
		return class_avr.d;
	}
}
