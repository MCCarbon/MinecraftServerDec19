package net.minecraft.server;

import java.util.Random;

public class class_aoa extends Block {
	public class_aoa() {
		super(class_avq.G);
		this.a(class_abp.c);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Entity var4) {
		var4.aG();
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Items.H;
	}

	@Override
	protected boolean K() {
		return true;
	}
}
