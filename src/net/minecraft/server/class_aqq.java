package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public class class_aqq extends class_aql {
   private final Block a;
   private final boolean b;

   public class_aqq(Block var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      if(var1.p(var3.a()).getBlock() != class_agk.aV) {
         return false;
      } else if(var1.p(var3).getBlock().v() != class_atk.a && var1.p(var3).getBlock() != class_agk.aV) {
         return false;
      } else {
         int var4 = 0;
         if(var1.p(var3.e()).getBlock() == class_agk.aV) {
            ++var4;
         }

         if(var1.p(var3.f()).getBlock() == class_agk.aV) {
            ++var4;
         }

         if(var1.p(var3.c()).getBlock() == class_agk.aV) {
            ++var4;
         }

         if(var1.p(var3.d()).getBlock() == class_agk.aV) {
            ++var4;
         }

         if(var1.p(var3.b()).getBlock() == class_agk.aV) {
            ++var4;
         }

         int var5 = 0;
         if(var1.d(var3.e())) {
            ++var5;
         }

         if(var1.d(var3.f())) {
            ++var5;
         }

         if(var1.d(var3.c())) {
            ++var5;
         }

         if(var1.d(var3.d())) {
            ++var5;
         }

         if(var1.d(var3.b())) {
            ++var5;
         }

         if(!this.b && var4 == 4 && var5 == 1 || var4 == 5) {
            var1.a((class_cj)var3, (IBlockData)this.a.S(), 2);
            var1.a(this.a, var3, var2);
         }

         return true;
      }
   }
}
