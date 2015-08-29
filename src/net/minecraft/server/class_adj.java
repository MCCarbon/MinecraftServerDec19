package net.minecraft.server;


public class class_adj extends Item {
	public class_adj() {
		this.d(1);
		this.e(238);
		this.a(class_abp.i);
	}

	@Override
	public boolean a(class_aco var1, class_ago var2, Block var3, class_cj var4, EntityLiving var5) {
		if ((var3.v() != class_avq.j) && (var3 != Blocks.WEB) && (var3 != Blocks.TALLGRASS) && (var3 != Blocks.VINE) && (var3 != Blocks.TRIPWIRE) && (var3 != Blocks.WOOL)) {
			return super.a(var1, var2, var3, var4, var5);
		} else {
			var1.a(1, var5);
			return true;
		}
	}

	@Override
	public boolean b(Block var1) {
		return (var1 == Blocks.WEB) || (var1 == Blocks.REDSTONE_WIRE) || (var1 == Blocks.TRIPWIRE);
	}

	@Override
	public float a(class_aco var1, Block var2) {
		return (var2 != Blocks.WEB) && (var2.v() != class_avq.j) ? (var2 == Blocks.WOOL ? 5.0F : super.a(var1, var2)) : 15.0F;
	}
}
