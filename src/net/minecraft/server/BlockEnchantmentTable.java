package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.BlockContainer;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityEnchantTable;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.ITileEntityContainer;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class BlockEnchantmentTable extends BlockContainer {
   protected BlockEnchantmentTable() {
      super(Material.STONE, MaterialMapColor.COLOR29);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
      this.setLightOpacity(0);
      this.setCreativeTab(CreativeTab.DECORATIONS);
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public int getRenderType() {
      return 3;
   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntityEnchantTable();
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.isClientSide) {
         return true;
      } else {
         TileEntity var11 = var1.getTileEntity(var2);
         if(var11 instanceof TileEntityEnchantTable) {
            var4.a((ITileEntityContainer)((TileEntityEnchantTable)var11));
         }

         return true;
      }
   }

   public void postPlace(World var1, BlockPosition var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      super.postPlace(var1, var2, var3, var4, var5);
      if(var5.hasDisplayName()) {
         TileEntity var6 = var1.getTileEntity(var2);
         if(var6 instanceof TileEntityEnchantTable) {
            ((TileEntityEnchantTable)var6).a(var5.getDisplayName());
         }
      }

   }
}
