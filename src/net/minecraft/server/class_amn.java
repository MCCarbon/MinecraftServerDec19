package net.minecraft.server;

import java.util.Random;

public class class_amn extends Block {
	private final boolean a;

	public class_amn(boolean var1) {
		super(class_avq.t);
		a = var1;
		if (var1) {
			this.a(1.0F);
		}

	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		if (!var1.D) {
			if (a && !var1.z(var2)) {
				var1.a(var2, Blocks.REDSTONE_LAMP.S(), 2);
			} else if (!a && var1.z(var2)) {
				var1.a(var2, Blocks.LIT_REDSTONE_LAMP.S(), 2);
			}

		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!var1.D) {
			if (a && !var1.z(var2)) {
				var1.a(var2, this, 4);
			} else if (!a && var1.z(var2)) {
				var1.a(var2, Blocks.LIT_REDSTONE_LAMP.S(), 2);
			}

		}
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!var1.D) {
			if (a && !var1.z(var2)) {
				var1.a(var2, Blocks.REDSTONE_LAMP.S(), 2);
			}

		}
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Item.a(Blocks.REDSTONE_LAMP);
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Blocks.REDSTONE_LAMP);
	}

	@Override
	protected class_aco i(class_apn var1) {
		return new class_aco(Blocks.REDSTONE_LAMP);
	}
}
