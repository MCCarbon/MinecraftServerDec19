package net.minecraft.server;

import java.util.Random;

public class class_ajh extends class_aiq {
	protected class_ajh() {
		super(class_avq.l);
		float var1 = 0.4F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
	}

	@Override
	public class_avr g(class_apn var1) {
		return class_avr.o;
	}

	@Override
	protected boolean c(Block var1) {
		return (var1 == Blocks.m) || (var1 == Blocks.cz) || (var1 == Blocks.cu) || (var1 == Blocks.d);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2) {
		return true;
	}

	@Override
	public int a(Random var1) {
		return var1.nextInt(3);
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Items.A;
	}

	@Override
	public void a(class_ago var1, class_yu var2, class_cj var3, class_apn var4, TileEntity var5, class_aco var6) {
		if (!var1.D && (var6 != null) && (var6.b() == Items.bg)) {
			var2.b(class_nh.a(Block.a(this)));
			a(var1, var3, new class_aco(Blocks.I, 1, 0));
		} else {
			super.a(var1, var2, var3, var4, var5, var6);
		}

	}
}
