package net.minecraft.server;


public class ChunkSection {

	private int a;
	private int b;
	private int c;
	private char[] d;
	private class_aoi e;
	private class_aoi f;

	public ChunkSection(int var1, boolean var2) {
		a = var1;
		d = new char[4096];
		e = new class_aoi();
		if (var2) {
			f = new class_aoi();
		}

	}

	public IBlockData a(int var1, int var2, int var3) {
		IBlockData var4 = Block.BLOCKDATA_REGISTRY.get(d[(var2 << 8) | (var3 << 4) | var1]);
		return var4 != null ? var4 : Blocks.AIR.getBlockData();
	}

	public void a(int var1, int var2, int var3, IBlockData var4) {
		IBlockData var5 = this.a(var1, var2, var3);
		Block var6 = var5.getBlock();
		Block var7 = var4.getBlock();
		if (var6 != Blocks.AIR) {
			--b;
			if (var6.isTicking()) {
				--c;
			}
		}

		if (var7 != Blocks.AIR) {
			++b;
			if (var7.isTicking()) {
				++c;
			}
		}

		d[(var2 << 8) | (var3 << 4) | var1] = (char) Block.BLOCKDATA_REGISTRY.getId(var4);
	}

	public Block b(int var1, int var2, int var3) {
		return this.a(var1, var2, var3).getBlock();
	}

	public int c(int var1, int var2, int var3) {
		IBlockData var4 = this.a(var1, var2, var3);
		return var4.getBlock().toLegacyData(var4);
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
						if (var4.isTicking()) {
							++c;
						}
					}
				}
			}
		}

	}

	public char[] g() {
		return d;
	}

	public void a(char[] var1) {
		d = var1;
	}

	public class_aoi h() {
		return e;
	}

	public class_aoi i() {
		return f;
	}

	public void a(class_aoi var1) {
		e = var1;
	}

	public void b(class_aoi var1) {
		f = var1;
	}
}
