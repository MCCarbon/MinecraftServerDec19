package net.minecraft.server;

import java.util.Random;

public class class_alh extends Block {
	protected class_alh() {
		super(class_avq.C, class_avr.u);
		this.a(class_abp.b);
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Items.bh;
	}

	@Override
	public int a(Random var1) {
		return 3 + var1.nextInt(5);
	}

	@Override
	public int a(int var1, Random var2) {
		return Math.min(9, this.a(var2) + var2.nextInt(1 + var1));
	}
}
