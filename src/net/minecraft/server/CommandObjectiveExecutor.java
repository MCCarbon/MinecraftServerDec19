package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.Vec3D;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awl;
import net.minecraft.server.class_awn;
import net.minecraft.server.class_ca;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTag;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.class_m;
import net.minecraft.server.Entity;

public class CommandObjectiveExecutor {
   private static final int a = CommandObjectiveExecutor.class_a_in_class_n.values().length;
   private static final String[] b;
   private String[] c;
   private String[] d;

   public CommandObjectiveExecutor() {
      this.c = b;
      this.d = b;
   }

   public void a(final class_m var1, CommandObjectiveExecutor.class_a_in_class_n var2, int var3) {
      String var4 = this.c[var2.a()];
      if(var4 != null) {
         class_m var5 = new class_m() {
            public String getName() {
               return var1.getName();
            }

            public IChatBaseComponent getScoreboardDisplayName() {
               return var1.getScoreboardDisplayName();
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

            public Entity f() {
               return var1.f();
            }

            public boolean u_() {
               return var1.u_();
            }

            public void a(CommandObjectiveExecutor.class_a_in_class_n var1x, int var2) {
               var1.a(var1x, var2);
            }
         };

         String var6;
         try {
            var6 = CommandAbstract.e(var5, var4);
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

   public void a(NBTTagCompound var1) {
      if(var1.hasOfType("CommandStats", 10)) {
         NBTTagCompound var2 = var1.getCompound("CommandStats");
         CommandObjectiveExecutor.class_a_in_class_n[] var3 = CommandObjectiveExecutor.class_a_in_class_n.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            CommandObjectiveExecutor.class_a_in_class_n var6 = var3[var5];
            String var7 = var6.b() + "Name";
            String var8 = var6.b() + "Objective";
            if(var2.hasOfType(var7, 8) && var2.hasOfType(var8, 8)) {
               String var9 = var2.getString(var7);
               String var10 = var2.getString(var8);
               a(this, var6, var9, var10);
            }
         }

      }
   }

   public void b(NBTTagCompound var1) {
      NBTTagCompound var2 = new NBTTagCompound();
      CommandObjectiveExecutor.class_a_in_class_n[] var3 = CommandObjectiveExecutor.class_a_in_class_n.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         CommandObjectiveExecutor.class_a_in_class_n var6 = var3[var5];
         String var7 = this.c[var6.a()];
         String var8 = this.d[var6.a()];
         if(var7 != null && var8 != null) {
            var2.put(var6.b() + "Name", var7);
            var2.put(var6.b() + "Objective", var8);
         }
      }

      if(!var2.isEmpty()) {
         var1.put((String)"CommandStats", (NBTTag)var2);
      }

   }

   public static void a(CommandObjectiveExecutor var0, CommandObjectiveExecutor.class_a_in_class_n var1, String var2, String var3) {
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

   private static void a(CommandObjectiveExecutor var0, CommandObjectiveExecutor.class_a_in_class_n var1) {
      if(var0.c != b && var0.d != b) {
         var0.c[var1.a()] = null;
         var0.d[var1.a()] = null;
         boolean var2 = true;
         CommandObjectiveExecutor.class_a_in_class_n[] var3 = CommandObjectiveExecutor.class_a_in_class_n.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            CommandObjectiveExecutor.class_a_in_class_n var6 = var3[var5];
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

   public void a(CommandObjectiveExecutor var1) {
      CommandObjectiveExecutor.class_a_in_class_n[] var2 = CommandObjectiveExecutor.class_a_in_class_n.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         CommandObjectiveExecutor.class_a_in_class_n var5 = var2[var4];
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
         CommandObjectiveExecutor.class_a_in_class_n[] var2 = values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            CommandObjectiveExecutor.class_a_in_class_n var5 = var2[var4];
            var0[var1++] = var5.b();
         }

         return var0;
      }

      public static CommandObjectiveExecutor.class_a_in_class_n a(String var0) {
         CommandObjectiveExecutor.class_a_in_class_n[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            CommandObjectiveExecutor.class_a_in_class_n var4 = var1[var3];
            if(var4.b().equals(var0)) {
               return var4;
            }
         }

         return null;
      }
   }
}
