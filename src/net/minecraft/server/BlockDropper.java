package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.BlockDispenser;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityDispenser;
import net.minecraft.server.TileEntityDropper;
import net.minecraft.server.TileEntityHopper;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.SourceBlock;
import net.minecraft.server.DispenseBehaviorItem;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.IDispenseBehavior;
import net.minecraft.server.IInventory;

public class BlockDropper extends BlockDispenser {
   private final IDispenseBehavior P = new DispenseBehaviorItem();

   protected IDispenseBehavior a(ItemStack var1) {
      return this.P;
   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntityDropper();
   }

   protected void dispense(World var1, BlockPosition var2) {
      SourceBlock var3 = new SourceBlock(var1, var2);
      TileEntityDispenser var4 = (TileEntityDispenser)var3.getTileEntity();
      if(var4 != null) {
         int var5 = var4.m();
         if(var5 < 0) {
            var1.b(1001, var2, 0);
         } else {
            ItemStack var6 = var4.getItem(var5);
            if(var6 != null) {
               EnumDirection var7 = (EnumDirection)var1.getType(var2).get(FACING);
               BlockPosition var8 = var2.shift(var7);
               IInventory var9 = TileEntityHopper.b(var1, (double)var8.getX(), (double)var8.getY(), (double)var8.getZ());
               ItemStack var10;
               if(var9 == null) {
                  var10 = this.P.a(var3, var6);
                  if(var10 != null && var10.count <= 0) {
                     var10 = null;
                  }
               } else {
                  var10 = TileEntityHopper.a(var9, var6.clone().a(1), var7.opposite());
                  if(var10 == null) {
                     var10 = var6.clone();
                     if(--var10.count <= 0) {
                        var10 = null;
                     }
                  } else {
                     var10 = var6.clone();
                  }
               }

               var4.setItem(var5, var10);
            }
         }
      }
   }
}
