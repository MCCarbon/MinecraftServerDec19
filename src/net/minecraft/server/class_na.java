package net.minecraft.server;


public class class_na extends class_nd {
	public class_na(String var1, IChatBaseComponent var2, class_ne var3) {
		super(var1, var2, var3);
	}

	public class_na(String var1, IChatBaseComponent var2) {
		super(var1, var2);
	}

	@Override
	public class_nd h() {
		super.h();
		StatisticList.c.add(this);
		return this;
	}
}
