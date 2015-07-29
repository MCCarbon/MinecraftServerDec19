package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahl;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_zw extends Item {
   private Block a;

   public class_zw(Block var1) {
      this.a = var1;
      this.a(CreativeTab.d);
   }

   public class_oq a(class_aas var1, class_xa var2, World var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(var6 != class_cq.b) {
         return class_oq.b;
      } else {
         IBlockData var10 = var3.p(var4);
         Block var11 = var10.getBlock();
         if(!var11.isReplaceable(var3, var4)) {
            var4 = var4.a(var6);
         }

         if(!var2.a(var4, var6, var1)) {
            return class_oq.b;
         } else if(!this.a.d(var3, var4)) {
            return class_oq.b;
         } else {
            a(var3, var4, class_cq.a((double)var2.y), this.a);
            --var1.b;
            return class_oq.a;
         }
      }
   }

   public static void a(World var0, class_cj var1, class_cq var2, Block var3) {
      class_cj var4 = var1.a(var2.e());
      class_cj var5 = var1.a(var2.f());
      int var6 = (var0.p(var5).getBlock().isOccluding()?1:0) + (var0.p(var5.a()).getBlock().isOccluding()?1:0);
      int var7 = (var0.p(var4).getBlock().isOccluding()?1:0) + (var0.p(var4.a()).getBlock().isOccluding()?1:0);
      boolean var8 = var0.p(var5).getBlock() == var3 || var0.p(var5.a()).getBlock() == var3;
      boolean var9 = var0.p(var4).getBlock() == var3 || var0.p(var4.a()).getBlock() == var3;
      boolean var10 = false;
      if(var8 && !var9 || var7 > var6) {
         var10 = true;
      }

      class_cj var11 = var1.a();
      IBlockData var12 = var3.getBlockData().set(class_ahl.a, var2).set(class_ahl.N, var10?class_ahl.class_b_in_class_ahl.b:class_ahl.class_b_in_class_ahl.a);
      var0.a((class_cj)var1, (IBlockData)var12.set(class_ahl.P, class_ahl.class_a_in_class_ahl.b), 2);
      var0.a((class_cj)var11, (IBlockData)var12.set(class_ahl.P, class_ahl.class_a_in_class_ahl.a), 2);
      var0.c(var1, var3);
      var0.c(var11, var3);
   }
}
