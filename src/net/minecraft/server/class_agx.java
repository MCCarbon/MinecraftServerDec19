package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_ano;
import net.minecraft.server.class_anp;
import net.minecraft.server.class_anq;
import net.minecraft.server.class_ant;
import net.minecraft.server.class_apc;
import net.minecraft.server.class_apd;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_zu;

public class class_agx extends class_agj {
   private class_anp a;

   public class_agx() {
      super(class_atk.B);
      this.a(class_zu.b);
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return class_aau.aK;
   }

   public int a(Random var1) {
      return 4;
   }

   protected class_anp l() {
      if(this.a == null) {
         this.a = class_anq.a().a(new String[]{"##  ##", "##  ##", "  ##  ", " #### ", " #### ", " #  # "}).a('#', class_ano.a(class_ant.a(class_agk.aL))).b();
      }

      return this.a;
   }

   public void c(class_aen var1, class_cj var2, class_anl var3) {
      super.c(var1, var2, var3);
      this.e(var1, var2);
   }

   private void e(class_aen var1, class_cj var2) {
      class_anp.class_b_in_class_anp var3 = this.l().a(var1, var2);
      if(var3 != null) {
         int var4;
         int var5;
         for(var4 = 0; var4 < this.l().c(); ++var4) {
            for(var5 = 0; var5 < this.l().b(); ++var5) {
               var1.a((class_cj)var3.a(var4, var5, 0).d(), (class_anl)class_agk.a.S(), 2);
            }
         }

         if(!var1.D && var1.t instanceof class_apd) {
            class_apc var7 = ((class_apd)var1.t).s();
            if(var7 != null) {
               var7.e();
            }
         }

         for(var4 = 0; var4 < this.l().c(); ++var4) {
            for(var5 = 0; var5 < this.l().b(); ++var5) {
               class_ano var6 = var3.a(var4, var5, 0);
               var1.b(var6.d(), class_agk.a);
            }
         }
      }

   }
}
