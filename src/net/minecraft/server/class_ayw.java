package net.minecraft.server;


public class class_ayw implements class_ayy {
	private final String o;

	public class_ayw(String var1) {
		o = var1;
		class_ayy.a.put(var1, this);
	}

	@Override
	public String a() {
		return o;
	}

	@Override
	public boolean b() {
		return false;
	}

	@Override
	public class_ayy.class_a_in_class_ayy c() {
		return class_ayy.class_a_in_class_ayy.a;
	}
}
