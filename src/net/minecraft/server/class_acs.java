package net.minecraft.server;


public class class_acs extends class_abb {
	private final class_alc b;

	public class_acs(class_alc var1) {
		super(var1);
		b = var1;
		this.e(0);
		this.a(true);
	}

	@Override
	public int a(int var1) {
		return var1 | 4;
	}

	@Override
	public String e_(class_aco var1) {
		return super.a() + "." + b.b(var1.i()).d();
	}
}
