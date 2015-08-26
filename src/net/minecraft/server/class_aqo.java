package net.minecraft.server;


public class class_aqo {
	private int a;
	private int b;
	private int c;
	private class_aqj d;
	private class_aql e;
	private class_aql f;

	public class_aqo(int var1, boolean var2) {
		a = var1;
		d = new class_aqj();
		e = new class_aql();
		if (var2) {
			f = new class_aql();
		}

	}

	public class_apn a(int var1, int var2, int var3) {
		return d.a(var1, var2, var3);
	}

	public void a(int var1, int var2, int var3, class_apn var4) {
		class_apn var5 = this.a(var1, var2, var3);
		Block var6 = var5.c();
		Block var7 = var4.c();
		if (var6 != Blocks.AIR) {
			--b;
			if (var6.A()) {
				--c;
			}
		}

		if (var7 != Blocks.AIR) {
			++b;
			if (var7.A()) {
				++c;
			}
		}

		d.a(var1, var2, var3, var4);
	}

	public Block b(int var1, int var2, int var3) {
		return this.a(var1, var2, var3).c();
	}

	public int c(int var1, int var2, int var3) {
		class_apn var4 = this.a(var1, var2, var3);
		return var4.c().c(var4);
	}

	public boolean a() {
		return b == 0;
	}

	public boolean b() {
		return c > 0;
	}

	public int d() {
		return a;
	}

	public void a(int var1, int var2, int var3, int var4) {
		f.a(var1, var2, var3, var4);
	}

	public int d(int var1, int var2, int var3) {
		return f.a(var1, var2, var3);
	}

	public void b(int var1, int var2, int var3, int var4) {
		e.a(var1, var2, var3, var4);
	}

	public int e(int var1, int var2, int var3) {
		return e.a(var1, var2, var3);
	}

	public void e() {
		b = 0;
		c = 0;

		for (int var1 = 0; var1 < 16; ++var1) {
			for (int var2 = 0; var2 < 16; ++var2) {
				for (int var3 = 0; var3 < 16; ++var3) {
					Block var4 = this.b(var1, var2, var3);
					if (var4 != Blocks.AIR) {
						++b;
						if (var4.A()) {
							++c;
						}
					}
				}
			}
		}

	}

	public class_aqj g() {
		return d;
	}

	public class_aql h() {
		return e;
	}

	public class_aql i() {
		return f;
	}

	public void a(class_aql var1) {
		e = var1;
	}

	public void b(class_aql var1) {
		f = var1;
	}
}
