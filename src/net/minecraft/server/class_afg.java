package net.minecraft.server;


public class class_afg extends class_afj {
	private static final String[] e = new String[] { "all", "undead", "arthropods" };
	private static final int[] f = new int[] { 1, 5, 5 };
	private static final int[] g = new int[] { 11, 8, 8 };
	private static final int[] h = new int[] { 20, 20, 20 };
	public final int a;

	public class_afg(class_afj.class_a_in_class_afj var1, int var2, class_rc... var3) {
		super(var1, class_afk.g, var3);
		a = var2;
	}

	@Override
	public int a(int var1) {
		return f[a] + ((var1 - 1) * g[a]);
	}

	@Override
	public int b(int var1) {
		return this.a(var1) + h[a];
	}

	@Override
	public int b() {
		return 5;
	}

	@Override
	public float a(int var1, class_rl var2) {
		return a == 0 ? var1 * 1.25F : ((a == 1) && (var2 == class_rl.b) ? var1 * 2.5F : ((a == 2) && (var2 == class_rl.c) ? var1 * 2.5F : 0.0F));
	}

	@Override
	public String a() {
		return "enchantment.damage." + e[a];
	}

	@Override
	public boolean a(class_afj var1) {
		return !(var1 instanceof class_afg);
	}

	@Override
	public boolean a(class_aco var1) {
		return var1.b() instanceof class_aay ? true : super.a(var1);
	}

	@Override
	public void a(EntityLiving var1, Entity var2, int var3) {
		if (var2 instanceof EntityLiving) {
			EntityLiving var4 = (EntityLiving) var2;
			if ((a == 2) && (var4.bF() == class_rl.c)) {
				int var5 = 20 + var1.bj().nextInt(10 * var3);
				var4.c(new class_qr(class_qs.b, var5, 3));
			}
		}

	}
}
