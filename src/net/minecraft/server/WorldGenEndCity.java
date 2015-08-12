package net.minecraft.server;

import java.util.Random;

public class WorldGenEndCity extends StructureGenerator {

	private int d = 20;
	private int f = 11;
	private final ChunkProviderTheEnd endChunkProvider;

	public WorldGenEndCity(ChunkProviderTheEnd var1) {
		this.endChunkProvider = var1;
	}

	@Override
	public String a() {
		return "EndCity";
	}

	@Override
	protected boolean a(int var1, int var2) {
		int var3 = var1;
		int var4 = var2;
		if (var1 < 0) {
			var1 -= this.d - 1;
		}

		if (var2 < 0) {
			var2 -= this.d - 1;
		}

		int var5 = var1 / this.d;
		int var6 = var2 / this.d;
		Random var7 = this.c.a(var5, var6, 10387313);
		var5 *= this.d;
		var6 *= this.d;
		var5 += (var7.nextInt(this.d - this.f) + var7.nextInt(this.d - this.f)) / 2;
		var6 += (var7.nextInt(this.d - this.f) + var7.nextInt(this.d - this.f)) / 2;
		return (var3 == var5) && (var4 == var6) && this.endChunkProvider.b(var3, var4);
	}

	@Override
	protected StructureStart b(int var1, int var2) {
		return new WorldGenEndCity.WorldGenEndCityStart(this.c, this.endChunkProvider, this.b, var1, var2);
	}

	public static class WorldGenEndCityStart extends StructureStart {
		private boolean c;

		public WorldGenEndCityStart() {
		}

		public WorldGenEndCityStart(World var1, ChunkProviderTheEnd var2, Random var3, int var4, int var5) {
			super(var4, var5);
			this.a(var1, var2, var3, var4, var5);
		}

		private void a(World world, ChunkProviderTheEnd endProvider, Random rnd, int x, int z) {
			Block.EnumRotation rotation = Block.EnumRotation.values()[rnd.nextInt(Block.EnumRotation.values().length)];
			ChunkSnapshot snapshot = new ChunkSnapshot();
			endProvider.a(x, z, snapshot);
			byte var8 = 5;
			byte var9 = 5;
			if (rotation == Block.EnumRotation.CLOCKWISE_90) {
				var8 = -5;
			} else if (rotation == Block.EnumRotation.CLOCKWISE_180) {
				var8 = -5;
				var9 = -5;
			} else if (rotation == Block.EnumRotation.COUNTERCLOCKWISE_90) {
				var9 = -5;
			}

			int var10 = snapshot.a(7, 7);
			int var11 = snapshot.a(7, 7 + var9);
			int var12 = snapshot.a(7 + var8, 7);
			int var13 = snapshot.a(7 + var8, 7 + var9);
			int var14 = Math.min(Math.min(var10, var11), Math.min(var12, var13));
			if (var14 < 60) {
				this.c = false;
			} else {
				BlockPosition var15 = new BlockPosition((x * 16) + 8, var14, (z * 16) + 8);
				WorldGenEndCityPieces.a(var15, rotation, this.a, rnd);
				this.c();
				this.c = true;
			}
		}

		@Override
		public boolean d() {
			return this.c;
		}

		@Override
		public void a(NBTTagCompound var1) {
			super.a(var1);
		}

		@Override
		public void b(NBTTagCompound var1) {
			super.b(var1);
		}

	}
}
