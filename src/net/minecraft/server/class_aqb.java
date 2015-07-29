package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_ago;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_cj;

public class class_aqb extends class_aql {
   private class_ago a;

   public class_aqb(class_ago var1) {
      this.a = var1;
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         class_cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var5) && (!var1.t.m() || var5.o() < 255) && this.a.f(var1, var5, this.a.S())) {
            var1.a((class_cj)var5, (IBlockData)this.a.S(), 2);
         }
      }

      return true;
   }
}
