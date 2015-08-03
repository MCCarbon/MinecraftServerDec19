package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Map;

public class ItemRecord extends Item {
   private static final Map b = Maps.newHashMap();
   public final String a;

   protected ItemRecord(String var1) {
      this.a = var1;
      this.h = 1;
      this.registerItemKey(CreativeTab.MISC);
      b.put("records." + var1, this);
   }

   public UseResult registerItemKey(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      IBlockData var10 = var3.getType(var4);
      if(var10.getBlock() == Blocks.JUKEBOX && !((Boolean)var10.get(BlockJukeBox.HAS_RECORD)).booleanValue()) {
         if(var3.isClientSide) {
            return UseResult.SUCCESS;
         } else {
            ((BlockJukeBox)Blocks.JUKEBOX).a(var3, var4, var10, var1);
            var3.a((EntityHuman)null, 1005, var4, Item.getId((Item)this));
            --var1.count;
            var2.b(StatisticList.X);
            return UseResult.SUCCESS;
         }
      } else {
         return UseResult.CANT_USE;
      }
   }

   public class_abf g(ItemStack var1) {
      return class_abf.c;
   }
}
