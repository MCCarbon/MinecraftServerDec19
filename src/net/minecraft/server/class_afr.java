package net.minecraft.server;


public class class_afr extends class_afj {
	protected class_afr(class_afj.class_a_in_class_afj var1, class_afk var2, class_rc... var3) {
		super(var1, var2, var3);
		if (var2 == class_afk.h) {
			this.c("lootBonusDigger");
		} else if (var2 == class_afk.i) {
			this.c("lootBonusFishing");
		} else {
			this.c("lootBonus");
		}

	}

	@Override
	public int a(int var1) {
		return 15 + ((var1 - 1) * 9);
	}

	@Override
	public int b(int var1) {
		return super.a(var1) + 50;
	}

	@Override
	public int b() {
		return 3;
	}

	@Override
	public boolean a(class_afj var1) {
		return super.a(var1) && (var1 != class_afn.q);
	}
}
