package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;

public class ChunkSnapshot {

	private final short[] a = new short[65536];
	private final IBlockData b;

	public ChunkSnapshot() {
		this.b = Blocks.AIR.getBlockData();
	}

	public IBlockData a(int var1, int var2, int var3) {
		int var4 = var1 << 12 | var3 << 8 | var2;
		return this.a(var4);
	}

	public IBlockData a(int var1) {
		if (var1 >= 0 && var1 < this.a.length) {
			IBlockData var2 = (IBlockData) Block.BLOCKDATA_REGISTRY.get(this.a[var1]);
			return var2 != null ? var2 : this.b;
		} else {
			throw new IndexOutOfBoundsException("The coordinate is out of range");
		}
	}

	public void a(int var1, int var2, int var3, IBlockData var4) {
		int var5 = var1 << 12 | var3 << 8 | var2;
		this.a(var5, var4);
	}

	public void a(int var1, IBlockData var2) {
		if (var1 >= 0 && var1 < this.a.length) {
			this.a[var1] = (short) Block.BLOCKDATA_REGISTRY.getId(var2);
		} else {
			throw new IndexOutOfBoundsException("The coordinate is out of range");
		}
	}

	public int a(int var1, int var2) {
		int var3 = (var1 << 12 | var2 << 8) + 256 - 1;

		for (int var4 = 255; var4 >= 0; --var4) {
			IBlockData var5 = (IBlockData) Block.BLOCKDATA_REGISTRY.get(this.a[var3 + var4]);
			if (var5 != null && var5 != this.b) {
				return var4;
			}
		}

		return 0;
	}

}
