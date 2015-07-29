package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_alp;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public class class_aqk extends class_aql {
   public static final class_cj a = new class_cj(0, 0, 0);
   public static final class_cj b;
   private final boolean c;

   public class_aqk(boolean var1) {
      this.c = var1;
   }

   public boolean b(World var1, Random var2, class_cj var3) {
      Iterator var4 = class_cj.b(new class_cj(var3.n() - 4, var3.o() - 1, var3.p() - 4), new class_cj(var3.n() + 4, var3.o() + 32, var3.p() + 4)).iterator();

      while(var4.hasNext()) {
         class_cj.class_a_in_class_cj var5 = (class_cj.class_a_in_class_cj)var4.next();
         double var6 = var5.d(var3.n(), var5.o(), var3.p());
         if(var6 <= 3.5D) {
            if(var5.o() < var3.o()) {
               if(var6 <= 2.5D) {
                  this.a(var1, var5, Blocks.BEDROCK.getBlockData());
               } else if(var5.o() < var3.o()) {
                  this.a(var1, var5, Blocks.END_STONE.getBlockData());
               }
            } else if(var5.o() > var3.o()) {
               this.a(var1, var5, Blocks.AIR.getBlockData());
            } else if(var6 > 2.5D) {
               this.a(var1, var5, Blocks.BEDROCK.getBlockData());
            } else if(this.c) {
               this.a(var1, new class_cj(var5), Blocks.END_PORTAL.getBlockData());
            } else {
               this.a(var1, new class_cj(var5), Blocks.AIR.getBlockData());
            }
         }
      }

      for(int var8 = 0; var8 < 4; ++var8) {
         this.a(var1, var3.b(var8), Blocks.BEDROCK.getBlockData());
      }

      class_cj var9 = var3.b(2);
      Iterator var10 = class_cq.class_c_in_class_cq.a.iterator();

      while(var10.hasNext()) {
         class_cq var11 = (class_cq)var10.next();
         this.a(var1, var9.a(var11), Blocks.TORCH.getBlockData().set(class_alp.a, var11));
      }

      if(this.c) {
         this.a(var1, var3.b(4), Blocks.DRAGON_EGG.getBlockData());
      }

      return true;
   }

   static {
      b = new class_cj(a.n() - 4 & -16, 0, a.p() - 4 & -16);
   }
}
