package net.minecraft.server;


public class class_adj extends Item {
	public class_adj() {
		this.d(1);
		this.e(238);
		this.a(class_abp.i);
	}

	@Override
	public boolean a(class_aco var1, class_ago var2, Block var3, class_cj var4, class_rg var5) {
		if ((var3.v() != class_avq.j) && (var3 != Blocks.G) && (var3 != Blocks.H) && (var3 != Blocks.bn) && (var3 != Blocks.bS) && (var3 != Blocks.L)) {
			return super.a(var1, var2, var3, var4, var5);
		} else {
			var1.a(1, var5);
			return true;
		}
	}

	@Override
	public boolean b(Block var1) {
		return (var1 == Blocks.G) || (var1 == Blocks.af) || (var1 == Blocks.bS);
	}

	@Override
	public float a(class_aco var1, Block var2) {
		return (var2 != Blocks.G) && (var2.v() != class_avq.j) ? (var2 == Blocks.L ? 5.0F : super.a(var1, var2)) : 15.0F;
	}
}
