package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.World;
import net.minecraft.server.BlockContainer;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityMobSpawner;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public class BlockMobSpawner extends BlockContainer {
   protected BlockMobSpawner() {
      super(Material.STONE);
   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntityMobSpawner();
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return null;
   }

   public int getDropCount(Random var1) {
      return 0;
   }

   public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
      super.dropNaturally(var1, var2, var3, var4, var5);
      int var6 = 15 + var1.random.nextInt(15) + var1.random.nextInt(15);
      this.dropExperience(var1, var2, var6);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public int getRenderType() {
      return 3;
   }
}
