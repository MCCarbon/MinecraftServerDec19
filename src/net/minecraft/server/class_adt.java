package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_adi;
import net.minecraft.server.class_adj;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_adm;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_za;

public class class_adt extends class_adi {
   public class_adt(class_adi.class_a_in_class_adi var1, class_pw... var2) {
      super(var1, class_adj.e, var2);
      this.c("thorns");
   }

   public int a(int var1) {
      return 10 + 20 * (var1 - 1);
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 3;
   }

   public boolean a(class_aas var1) {
      return var1.b() instanceof class_za?true:super.a(var1);
   }

   public void b(class_qa var1, class_pr var2, int var3) {
      Random var4 = var1.bd();
      class_aas var5 = class_adk.b(class_adm.h, var1);
      if(a(var3, var4)) {
         if(var2 != null) {
            var2.a(class_pc.a((class_pr)var1), (float)b(var3, var4));
            var2.a("damage.thorns", 0.5F, 1.0F);
         }

         if(var5 != null) {
            var5.a(3, (class_qa)var1);
         }
      } else if(var5 != null) {
         var5.a(1, (class_qa)var1);
      }

   }

   public static boolean a(int var0, Random var1) {
      return var0 <= 0?false:var1.nextFloat() < 0.15F * (float)var0;
   }

   public static int b(int var0, Random var1) {
      return var0 > 10?var0 - 10:1 + var1.nextInt(4);
   }
}