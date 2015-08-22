package net.minecraft.server;

import com.google.common.base.Predicate;

public class class_apu implements Predicate {
	private final Block a;

	private class_apu(Block var1) {
		a = var1;
	}

	public static class_apu a(Block var0) {
		return new class_apu(var0);
	}

	public boolean a(class_apn var1) {
		return (var1 != null) && (var1.c() == a);
	}

	// $FF: synthetic method
	@Override
	public boolean apply(Object var1) {
		return this.a((class_apn) var1);
	}
}
