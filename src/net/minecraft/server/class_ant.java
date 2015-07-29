package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.IBlockState;

public class class_ant implements Predicate {
   private final BlockStateList a;
   private final Map b = Maps.newHashMap();

   private class_ant(BlockStateList var1) {
      this.a = var1;
   }

   public static class_ant a(Block var0) {
      return new class_ant(var0.getBlockStateList());
   }

   public boolean a(IBlockData var1) {
      if(var1 != null && var1.getBlock().equals(this.a.getBlock())) {
         Iterator var2 = this.b.entrySet().iterator();

         Entry var3;
         Comparable var4;
         do {
            if(!var2.hasNext()) {
               return true;
            }

            var3 = (Entry)var2.next();
            var4 = var1.get((IBlockState)var3.getKey());
         } while(((Predicate)var3.getValue()).apply(var4));

         return false;
      } else {
         return false;
      }
   }

   public class_ant a(IBlockState var1, Predicate var2) {
      if(!this.a.d().contains(var1)) {
         throw new IllegalArgumentException(this.a + " cannot support property " + var1);
      } else {
         this.b.put(var1, var2);
         return this;
      }
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((IBlockData)var1);
   }
}
