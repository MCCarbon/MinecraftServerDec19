package net.minecraft.server;

import java.util.Random;

public class class_aio extends Block {
	public class_aio() {
		super(class_avq.d);
		this.a(class_abp.b);
	}

	@Override
	public int a(Random var1) {
		return 3;
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Items.aN;
	}
}
