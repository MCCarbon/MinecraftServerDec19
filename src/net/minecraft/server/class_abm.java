package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.UseResult;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.class_zv;

public class class_abm extends class_zv {
   private static final Set c;

   public class_abm(Item.class_a_in_class_aar var1) {
      super(1.0F, var1, c);
   }

   public boolean b(Block var1) {
      return var1 == Blocks.SNOW_LAYER?true:var1 == Blocks.SNOW;
   }

   public UseResult a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(!var2.a(var4.shift(var6), var6, var1)) {
         return UseResult.CANT_USE;
      } else {
         IBlockData var10 = var3.getType(var4);
         Block var11 = var10.getBlock();
         if(var6 != EnumDirection.DOWN && var3.getType(var4.up()).getBlock().getMaterial() == Material.AIR) {
            if(var11 != Blocks.GRASS) {
               return UseResult.CANT_USE;
            } else {
               IBlockData var12 = Blocks.GRASS_PATH.getBlockData();
               Block var13 = var12.getBlock();
               var3.a((double)((float)var4.getX() + 0.5F), (double)((float)var4.getY() + 0.5F), (double)((float)var4.getZ() + 0.5F), var13.stepSound.getStepSound(), (var13.stepSound.getVolume() + 1.0F) / 2.0F, var13.stepSound.getPitch() * 0.8F);
               if(var3.isClientSide) {
                  return UseResult.SUCCESS;
               } else {
                  var3.setTypeUpdate(var4, var12);
                  var1.a(1, (EntityLiving)var2);
                  return UseResult.CANT_USE;
               }
            }
         } else {
            return UseResult.CANT_USE;
         }
      }
   }

   static {
      c = Sets.newHashSet((Object[])(new Block[]{Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.GRASS_PATH}));
   }
}