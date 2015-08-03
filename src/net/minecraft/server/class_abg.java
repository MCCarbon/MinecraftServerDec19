package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_abf;
import net.minecraft.server.World;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.BlockJukeBox;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.StatisticList;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_abg extends Item {
   private static final Map b = Maps.newHashMap();
   public final String a;

   protected class_abg(String var1) {
      this.a = var1;
      this.h = 1;
      this.a(CreativeTab.MISC);
      b.put("records." + var1, this);
   }

   public class_oq a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      IBlockData var10 = var3.getType(var4);
      if(var10.getBlock() == BlockStainedGlassPane.JUKEBOX && !((Boolean)var10.get(BlockJukeBox.HAS_RECORD)).booleanValue()) {
         if(var3.isClientSide) {
            return class_oq.a;
         } else {
            ((BlockJukeBox)BlockStainedGlassPane.JUKEBOX).a(var3, var4, var10, var1);
            var3.a((EntityHuman)null, 1005, var4, Item.getId((Item)this));
            --var1.count;
            var2.b(StatisticList.X);
            return class_oq.a;
         }
      } else {
         return class_oq.b;
      }
   }

   public class_abf g(ItemStack var1) {
      return class_abf.c;
   }
}
