package net.minecraft.server;

import net.minecraft.server.BlockPosition;

public class ChunkCoordIntPair {

	public final int a;
	public final int b;

	public ChunkCoordIntPair(int var1, int var2) {
		this.a = var1;
		this.b = var2;
	}

	public static long a(int var0, int var1) {
		return (long) var0 & 4294967295L | ((long) var1 & 4294967295L) << 32;
	}

	public int hashCode() {
		int var1 = 1664525 * this.a + 1013904223;
		int var2 = 1664525 * (this.b ^ -559038737) + 1013904223;
		return var1 ^ var2;
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof ChunkCoordIntPair)) {
			return false;
		} else {
			ChunkCoordIntPair var2 = (ChunkCoordIntPair) var1;
			return this.a == var2.a && this.b == var2.b;
		}
	}

	public int a() {
		return (this.a << 4) + 8;
	}

	public int b() {
		return (this.b << 4) + 8;
	}

	public int c() {
		return this.a << 4;
	}

	public int d() {
		return this.b << 4;
	}

	public int e() {
		return (this.a << 4) + 15;
	}

	public int f() {
		return (this.b << 4) + 15;
	}

	public BlockPosition a(int var1, int var2, int var3) {
		return new BlockPosition((this.a << 4) + var1, var2, (this.b << 4) + var3);
	}

	public BlockPosition a(int var1) {
		return new BlockPosition(this.a(), var1, this.b());
	}

	public String toString() {
		return "[" + this.a + ", " + this.b + "]";
	}

}
