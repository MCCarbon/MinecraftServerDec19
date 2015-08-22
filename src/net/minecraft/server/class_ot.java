package net.minecraft.server;


public class class_ot implements class_ok {
	@Override
	public int a() {
		return 110;
	}

	@Override
	public class_dn a(class_dn var1) {
		if ("EntityHorse".equals(var1.l("id")) && !var1.b("SaddleItem", 10) && var1.p("Saddle")) {
			class_dn var2 = new class_dn();
			var2.a("id", "minecraft:saddle");
			var2.a("Count", (byte) 1);
			var2.a("Damage", (short) 0);
			var1.a("SaddleItem", var2);
			var1.q("Saddle");
		}

		return var1;
	}
}
