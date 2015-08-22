package net.minecraft.server;

import java.util.Random;

public abstract class class_asp {
	private final boolean a;

	public class_asp() {
		this(false);
	}

	public class_asp(boolean var1) {
		a = var1;
	}

	public abstract boolean b(class_ago var1, Random var2, class_cj var3);

	public void e() {
	}

	protected void a(class_ago var1, class_cj var2, class_apn var3) {
		if (a) {
			var1.a(var2, var3, 3);
		} else {
			var1.a(var2, var3, 2);
		}

	}
}
