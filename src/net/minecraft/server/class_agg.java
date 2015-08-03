package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.BlockContainer;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.TileEntityBeacon;
import net.minecraft.server.TileEntity;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Chunk;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.WorldServer;
import net.minecraft.server.StatisticList;
import net.minecraft.server.class_nl;
import net.minecraft.server.IInventory;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_agg extends BlockContainer {
   public class_agg() {
      super(Material.SHATTERABLE, MaterialMapColor.COLOR32);
      this.setStrength(3.0F);
      this.setCreativeTab(CreativeTab.MISC);
   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntityBeacon();
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.isClientSide) {
         return true;
      } else {
         TileEntity var11 = var1.getTileEntity(var2);
         if(var11 instanceof TileEntityBeacon) {
            var4.openContainer((IInventory)((TileEntityBeacon)var11));
            var4.b(StatisticList.N);
         }

         return true;
      }
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public int getRenderType() {
      return 3;
   }

   public void postPlace(World var1, BlockPosition var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      super.postPlace(var1, var2, var3, var4, var5);
      if(var5.hasDisplayName()) {
         TileEntity var6 = var1.getTileEntity(var2);
         if(var6 instanceof TileEntityBeacon) {
            ((TileEntityBeacon)var6).a(var5.getDisplayName());
         }
      }

   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      TileEntity var5 = var1.getTileEntity(var2);
      if(var5 instanceof TileEntityBeacon) {
         ((TileEntityBeacon)var5).m();
         var1.c(var2, this, 1, 0);
      }

   }

   public static void f(final World var0, final BlockPosition var1) {
      class_nl.a.submit(new Runnable() {
         public void run() {
            Chunk var1x = var0.f(var1);

            for(int var2 = var1.getY() - 1; var2 >= 0; --var2) {
               final BlockPosition var3 = new BlockPosition(var1.getX(), var2, var1.getZ());
               if(!var1x.d(var3)) {
                  break;
               }

               IBlockData var4 = var0.getType(var3);
               if(var4.getBlock() == BlockStainedGlassPane.BEACON) {
                  ((WorldServer)var0).a(new Runnable() {
                     public void run() {
                        TileEntity var1x = var0.getTileEntity(var3);
                        if(var1x instanceof TileEntityBeacon) {
                           ((TileEntityBeacon)var1x).m();
                           var0.c(var3, BlockStainedGlassPane.BEACON, 1, 0);
                        }

                     }
                  });
               }
            }

         }
      });
   }
}
