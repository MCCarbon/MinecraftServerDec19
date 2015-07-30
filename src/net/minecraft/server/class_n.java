package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.Vec3D;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awl;
import net.minecraft.server.class_awn;
import net.minecraft.server.class_ca;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_eb;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;
import net.minecraft.server.class_pr;

public class class_n {
   private static final int a = class_n.class_a_in_class_n.values().length;
   private static final String[] b;
   private String[] c;
   private String[] d;

   public class_n() {
      this.c = b;
      this.d = b;
   }

   public void a(final class_m var1, class_n.class_a_in_class_n var2, int var3) {
      String var4 = this.c[var2.a()];
      if(var4 != null) {
         class_m var5 = new class_m() {
            public String e_() {
               return var1.e_();
            }

            public IChatBaseComponent f_() {
               return var1.f_();
            }

            public void a(IChatBaseComponent var1x) {
               var1.a(var1x);
            }

            public boolean a(int var1x, String var2) {
               return true;
            }

            public BlockPosition c() {
               return var1.c();
            }

            public Vec3D d() {
               return var1.d();
            }

            public World e() {
               return var1.e();
            }

            public class_pr f() {
               return var1.f();
            }

            public boolean u_() {
               return var1.u_();
            }

            public void a(class_n.class_a_in_class_n var1x, int var2) {
               var1.a(var1x, var2);
            }
         };

         String var6;
         try {
            var6 = class_i.e(var5, var4);
         } catch (class_ca var11) {
            return;
         }

         String var7 = this.d[var2.a()];
         if(var7 != null) {
            class_awn var8 = var1.e().aa();
            class_awj var9 = var8.b(var7);
            if(var9 != null) {
               if(var8.b(var6, var9)) {
                  class_awl var10 = var8.c(var6, var9);
                  var10.c(var3);
               }
            }
         }
      }
   }

   public void a(class_dn var1) {
      if(var1.b("CommandStats", 10)) {
         class_dn var2 = var1.n("CommandStats");
         class_n.class_a_in_class_n[] var3 = class_n.class_a_in_class_n.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            class_n.class_a_in_class_n var6 = var3[var5];
            String var7 = var6.b() + "Name";
            String var8 = var6.b() + "Objective";
            if(var2.b(var7, 8) && var2.b(var8, 8)) {
               String var9 = var2.k(var7);
               String var10 = var2.k(var8);
               a(this, var6, var9, var10);
            }
         }

      }
   }

   public void b(class_dn var1) {
      class_dn var2 = new class_dn();
      class_n.class_a_in_class_n[] var3 = class_n.class_a_in_class_n.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         class_n.class_a_in_class_n var6 = var3[var5];
         String var7 = this.c[var6.a()];
         String var8 = this.d[var6.a()];
         if(var7 != null && var8 != null) {
            var2.a(var6.b() + "Name", var7);
            var2.a(var6.b() + "Objective", var8);
         }
      }

      if(!var2.c_()) {
         var1.a((String)"CommandStats", (class_eb)var2);
      }

   }

   public static void a(class_n var0, class_n.class_a_in_class_n var1, String var2, String var3) {
      if(var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         if(var0.c == b || var0.d == b) {
            var0.c = new String[a];
            var0.d = new String[a];
         }

         var0.c[var1.a()] = var2;
         var0.d[var1.a()] = var3;
      } else {
         a(var0, var1);
      }
   }

   private static void a(class_n var0, class_n.class_a_in_class_n var1) {
      if(var0.c != b && var0.d != b) {
         var0.c[var1.a()] = null;
         var0.d[var1.a()] = null;
         boolean var2 = true;
         class_n.class_a_in_class_n[] var3 = class_n.class_a_in_class_n.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            class_n.class_a_in_class_n var6 = var3[var5];
            if(var0.c[var6.a()] != null && var0.d[var6.a()] != null) {
               var2 = false;
               break;
            }
         }

         if(var2) {
            var0.c = b;
            var0.d = b;
         }

      }
   }

   public void a(class_n var1) {
      class_n.class_a_in_class_n[] var2 = class_n.class_a_in_class_n.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_n.class_a_in_class_n var5 = var2[var4];
         a(this, var5, var1.c[var5.a()], var1.d[var5.a()]);
      }

   }

   static {
      b = new String[a];
   }

   public static enum class_a_in_class_n {
      a(0, "SuccessCount"),
      b(1, "AffectedBlocks"),
      c(2, "AffectedEntities"),
      d(3, "AffectedItems"),
      e(4, "QueryResult");

      final int f;
      final String g;

      private class_a_in_class_n(int var3, String var4) {
         this.f = var3;
         this.g = var4;
      }

      public int a() {
         return this.f;
      }

      public String b() {
         return this.g;
      }

      public static String[] c() {
         String[] var0 = new String[values().length];
         int var1 = 0;
         class_n.class_a_in_class_n[] var2 = values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            class_n.class_a_in_class_n var5 = var2[var4];
            var0[var1++] = var5.b();
         }

         return var0;
      }

      public static class_n.class_a_in_class_n a(String var0) {
         class_n.class_a_in_class_n[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            class_n.class_a_in_class_n var4 = var1[var3];
            if(var4.b().equals(var0)) {
               return var4;
            }
         }

         return null;
      }
   }
}
