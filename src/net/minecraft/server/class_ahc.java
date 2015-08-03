package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.StatisticList;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.ITileEntityContainer;
import net.minecraft.server.PlayerInventory;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Container;
import net.minecraft.server.class_yh;
import net.minecraft.server.CreativeTab;

public class class_ahc extends Block {
   protected class_ahc() {
      super(Material.WOOD);
      this.setCreativeTab(CreativeTab.DECORATIONS);
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.isClientSide) {
         return true;
      } else {
         var4.a((ITileEntityContainer)(new class_ahc.class_a_in_class_ahc(var1, var2)));
         var4.b(StatisticList.Z);
         return true;
      }
   }

   public static class class_a_in_class_ahc implements ITileEntityContainer {
      private final World a;
      private final BlockPosition b;

      public class_a_in_class_ahc(World var1, BlockPosition var2) {
         this.a = var1;
         this.b = var2;
      }

      public String getName() {
         return null;
      }

      public boolean hasCustomName() {
         return false;
      }

      public IChatBaseComponent getScoreboardDisplayName() {
         return new ChatMessage(BlockStainedGlassPane.CRAFTING_TABLE.getInternalName() + ".name", new Object[0]);
      }

      public Container createContainer(PlayerInventory var1, EntityHuman var2) {
         return new class_yh(var1, this.a, this.b);
      }

      public String getContainerName() {
         return "minecraft:crafting_table";
      }
   }
}
