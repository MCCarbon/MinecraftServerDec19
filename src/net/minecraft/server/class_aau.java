package net.minecraft.server;


public class class_aau extends class_acx {
	public class_aau(class_ail var1) {
		super(var1, var1, new String[] { "intact", "slightlyDamaged", "veryDamaged" });
	}

	@Override
	public int a(int var1) {
		return var1 << 2;
	}
}
