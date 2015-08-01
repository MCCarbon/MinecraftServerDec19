package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.google.common.collect.Lists;

public class BlockSponge extends Block {

	public static final BlockStateBoolean WET = BlockStateBoolean.of("wet");

	protected BlockSponge() {
		super(Material.SPONGE);
		setBlockData(blockStateList.getFirst().set(WET, Boolean.valueOf(false)));
		setCreativeTab(CreativeTab.BUILDING_BLOCKS);
	}

	@Override
	public String getName() {
		return LocaleI18n.get(getInternalName() + ".dry.name");
	}

	@Override
	public int getDropData(IBlockData var1) {
		return var1.get(WET).booleanValue() ? 1 : 0;
	}

	@Override
	public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
		this.e(var1, var2, var3);
	}

	@Override
	public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
		this.e(var1, var2, var3);
		super.doPhysics(var1, var2, var3, var4);
	}

	protected void e(World var1, BlockPosition var2, IBlockData var3) {
		if (!var3.get(WET).booleanValue() && this.e(var1, var2)) {
			var1.setTypeAndData(var2, var3.set(WET, Boolean.valueOf(true)), 2);
			var1.b(2001, var2, Block.getId(Blocks.WATER));
		}

	}

	private boolean e(World var1, BlockPosition var2) {
		LinkedList<Tuple> var3 = Lists.newLinkedList();
		ArrayList<BlockPosition> var4 = Lists.newArrayList();
		var3.add(new Tuple(var2, Integer.valueOf(0)));
		int var5 = 0;

		BlockPosition var7;
		while (!var3.isEmpty()) {
			Tuple var6 = (Tuple) var3.poll();
			var7 = (BlockPosition) var6.getObject1();
			int var8 = ((Integer) var6.getObject2()).intValue();
			EnumDirection[] var9 = EnumDirection.values();
			int var10 = var9.length;

			for (int var11 = 0; var11 < var10; ++var11) {
				EnumDirection var12 = var9[var11];
				BlockPosition var13 = var7.shift(var12);
				if (var1.getType(var13).getBlock().getMaterial() == Material.WATER) {
					var1.setTypeAndData(var13, Blocks.AIR.getBlockData(), 2);
					var4.add(var13);
					++var5;
					if (var8 < 6) {
						var3.add(new Tuple(var13, Integer.valueOf(var8 + 1)));
					}
				}
			}

			if (var5 > 64) {
				break;
			}
		}

		Iterator<BlockPosition> var14 = var4.iterator();

		while (var14.hasNext()) {
			var7 = (BlockPosition) var14.next();
			var1.c(var7, Blocks.AIR);
		}

		return var5 > 0;
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(WET, Boolean.valueOf((var1 & 1) == 1));
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		return var1.get(WET).booleanValue() ? 1 : 0;
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { WET });
	}

}
