package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_aic;
import net.minecraft.server.class_alm;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.CreativeTab;

public class BlockGrass extends Block implements class_agl {
	public static final class_anw a = class_anw.a("snowy");

	protected BlockGrass() {
		super(Material.GRASS);
		this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)));
		this.setTicking(true);
		this.a(CreativeTab.b);
	}

	public IBlockData a(IBlockData var1, class_aer var2, BlockPosition var3) {
		Block var4 = var2.p(var3.shiftUp()).getBlock();
		return var1.set(a, Boolean.valueOf(var4 == Blocks.SNOW || var4 == Blocks.SNOW_LAYER));
	}

	public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
		if (!var1.D) {
			if (var1.l(var2.shiftUp()) < 4 && var1.p(var2.shiftUp()).getBlock().getLightOpacity() > 2) {
				var1.a(var2, Blocks.DIRT.getBlockData());
			} else {
				if (var1.l(var2.shiftUp()) >= 9) {
					for (int var5 = 0; var5 < 4; ++var5) {
						BlockPosition var6 = var2.add(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
						Block var7 = var1.p(var6.shiftUp()).getBlock();
						IBlockData var8 = var1.p(var6);
						if (var8.getBlock() == Blocks.DIRT && var8.get(class_ahj.a) == class_ahj.class_a_in_class_ahj.a && var1.l(var6.shiftUp()) >= 4 && var7.getLightOpacity() <= 2) {
							var1.a(var6, Blocks.GRASS.getBlockData());
						}
					}
				}

			}
		}
	}

	public Item getDropType(IBlockData var1, Random var2, int var3) {
		return Blocks.DIRT.getDropType(Blocks.DIRT.getBlockData().set(class_ahj.a, class_ahj.class_a_in_class_ahj.a), var2, var3);
	}

	public boolean a(World var1, BlockPosition var2, IBlockData var3, boolean var4) {
		return true;
	}

	public boolean a(World var1, Random var2, BlockPosition var3, IBlockData var4) {
		return true;
	}

	public void b(World var1, Random var2, BlockPosition var3, IBlockData var4) {
		BlockPosition var5 = var3.shiftUp();

		label38: for (int var6 = 0; var6 < 128; ++var6) {
			BlockPosition var7 = var5;

			for (int var8 = 0; var8 < var6 / 16; ++var8) {
				var7 = var7.add(var2.nextInt(3) - 1, (var2.nextInt(3) - 1) * var2.nextInt(3) / 2, var2.nextInt(3) - 1);
				if (var1.p(var7.shiftDown()).getBlock() != Blocks.GRASS || var1.p(var7).getBlock().isOccluding()) {
					continue label38;
				}
			}

			if (var1.p(var7).getBlock().material == Material.AIR) {
				if (var2.nextInt(8) == 0) {
					class_aic.class_a_in_class_aic var11 = var1.b(var7).a(var2, var7);
					class_aic var9 = var11.a().a();
					IBlockData var10 = var9.getBlockData().set(var9.n(), var11);
					if (var9.f(var1, var7, var10)) {
						var1.a((BlockPosition) var7, (IBlockData) var10, 3);
					}
				} else {
					IBlockData var12 = Blocks.TALLGRASS.getBlockData().set(class_alm.a, class_alm.class_a_in_class_alm.b);
					if (Blocks.TALLGRASS.f(var1, var7, var12)) {
						var1.a((BlockPosition) var7, (IBlockData) var12, 3);
					}
				}
			}
		}
	}

	public int toLegacyData(IBlockData var1) {
		return 0;
	}

	protected BlockStateList createBlockStateList() {
		return new BlockStateList(this, new IBlockState[] { a });
	}

}
