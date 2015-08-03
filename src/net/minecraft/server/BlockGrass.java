package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockFragilePlantElement;
import net.minecraft.server.BlockDirt;
import net.minecraft.server.BlockFlowers;
import net.minecraft.server.BlockLongGrass;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateBoolean;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.CreativeTab;

public class BlockGrass extends Block implements IBlockFragilePlantElement {
	public static final BlockStateBoolean a = BlockStateBoolean.of("snowy");

	protected BlockGrass() {
		super(Material.GRASS);
		this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)));
		this.setTicking(true);
		this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
	}

	public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
		Block var4 = var2.getType(var3.up()).getBlock();
		return var1.set(a, Boolean.valueOf(var4 == Blocks.SNOW || var4 == Blocks.SNOW_LAYER));
	}

	public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
		if (!var1.isClientSide) {
			if (var1.l(var2.up()) < 4 && var1.getType(var2.up()).getBlock().getLightOpacity() > 2) {
				var1.setTypeUpdate(var2, Blocks.DIRT.getBlockData());
			} else {
				if (var1.l(var2.up()) >= 9) {
					for (int var5 = 0; var5 < 4; ++var5) {
						BlockPosition var6 = var2.add(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
						Block var7 = var1.getType(var6.up()).getBlock();
						IBlockData var8 = var1.getType(var6);
						if (var8.getBlock() == Blocks.DIRT && var8.get(BlockDirt.VARIANT) == BlockDirt.EnumDirtVariant.DIRT && var1.l(var6.up()) >= 4 && var7.getLightOpacity() <= 2) {
							var1.setTypeUpdate(var6, Blocks.GRASS.getBlockData());
						}
					}
				}

			}
		}
	}

	public Item getDropType(IBlockData var1, Random var2, int var3) {
		return Blocks.DIRT.getDropType(Blocks.DIRT.getBlockData().set(BlockDirt.VARIANT, BlockDirt.EnumDirtVariant.DIRT), var2, var3);
	}

	public boolean a(World var1, BlockPosition var2, IBlockData var3, boolean var4) {
		return true;
	}

	public boolean a(World var1, Random var2, BlockPosition var3, IBlockData var4) {
		return true;
	}

	public void b(World var1, Random var2, BlockPosition var3, IBlockData var4) {
		BlockPosition var5 = var3.up();

		label38: for (int var6 = 0; var6 < 128; ++var6) {
			BlockPosition var7 = var5;

			for (int var8 = 0; var8 < var6 / 16; ++var8) {
				var7 = var7.add(var2.nextInt(3) - 1, (var2.nextInt(3) - 1) * var2.nextInt(3) / 2, var2.nextInt(3) - 1);
				if (var1.getType(var7.down()).getBlock() != Blocks.GRASS || var1.getType(var7).getBlock().isOccluding()) {
					continue label38;
				}
			}

			if (var1.getType(var7).getBlock().material == Material.AIR) {
				if (var2.nextInt(8) == 0) {
					BlockFlowers.EnumFlowerVarient var11 = var1.b(var7).a(var2, var7);
					BlockFlowers var9 = var11.getType().isYellow();
					IBlockData var10 = var9.getBlockData().set(var9.getFlowerVarients(), var11);
					if (var9.f(var1, var7, var10)) {
						var1.setTypeAndData((BlockPosition) var7, (IBlockData) var10, 3);
					}
				} else {
					IBlockData var12 = Blocks.TALLGRASS.getBlockData().set(BlockLongGrass.TYPE, BlockLongGrass.EnumTallGrassType.GRASS);
					if (Blocks.TALLGRASS.f(var1, var7, var12)) {
						var1.setTypeAndData((BlockPosition) var7, (IBlockData) var12, 3);
					}
				}
			}
		}
	}

	public int toLegacyData(IBlockData var1) {
		return 0;
	}

	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { a });
	}

}
