package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_ec;
import net.minecraft.server.class_ed;
import net.minecraft.server.class_i;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vm;

public class class_aj extends class_i {
   public String c() {
      return "give";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.give.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 2) {
         throw new class_cf("commands.give.usage", new Object[0]);
      } else {
         class_lh var3 = a(var1, var2[0]);
         class_aar var4 = f(var1, var2[1]);
         int var5 = var2.length >= 3?a(var2[2], 1, 64):1;
         int var6 = var2.length >= 4?a(var2[3]):0;
         class_aas var7 = new class_aas(var4, var5, var6);
         if(var2.length >= 5) {
            String var8 = a(var1, var2, 4).c();

            try {
               var7.d(class_ed.a(var8));
            } catch (class_ec var10) {
               throw new class_bz("commands.give.tagError", new Object[]{var10.getMessage()});
            }
         }

         boolean var11 = var3.bp.a(var7);
         if(var11) {
            var3.o.a((class_pr)var3, "random.pop", 0.2F, ((var3.bd().nextFloat() - var3.bd().nextFloat()) * 0.7F + 1.0F) * 2.0F);
            var3.bq.b();
         }

         class_vm var9;
         if(var11 && var7.b <= 0) {
            var7.b = 1;
            var1.a(class_n.class_a_in_class_n.d, var5);
            var9 = var3.a(var7, false);
            if(var9 != null) {
               var9.v();
            }
         } else {
            var1.a(class_n.class_a_in_class_n.d, var5 - var7.b);
            var9 = var3.a(var7, false);
            if(var9 != null) {
               var9.q();
               var9.b(var3.e_());
            }
         }

         a(var1, this, "commands.give.success", new Object[]{var7.B(), Integer.valueOf(var5), var3.e_()});
      }
   }

   public List a(class_m var1, String[] var2, class_cj var3) {
      return var2.length == 1?a(var2, this.d()):(var2.length == 2?a(var2, class_aar.e.getKeys()):null);
   }

   protected String[] d() {
      return MinecraftServer.N().K();
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }
}
