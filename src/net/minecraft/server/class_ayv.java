package net.minecraft.server;


public class class_ayv implements class_ayy {
	private final String o;

	public class_ayv(String var1, EnumChatFormat var2) {
		o = var1 + var2.e();
		class_ayy.a.put(o, this);
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
