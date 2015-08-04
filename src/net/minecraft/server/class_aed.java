package net.minecraft.server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.World;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_e;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.class_l;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;
import net.minecraft.server.EntityHuman;

public abstract class class_aed implements class_m {
   private static final SimpleDateFormat a = new SimpleDateFormat("HH:mm:ss");
   private int b;
   private boolean c = true;
   private IChatBaseComponent d = null;
   private String e = "";
   private String f = "@";
   private final class_n g = new class_n();

   public int j() {
      return this.b;
   }

   public IChatBaseComponent k() {
      return this.d;
   }

   public void a(NBTTagCompound var1) {
      var1.put("Command", this.e);
      var1.put("SuccessCount", this.b);
      var1.put("CustomName", this.f);
      var1.put("TrackOutput", this.c);
      if(this.d != null && this.c) {
         var1.put("LastOutput", IChatBaseComponent.ChatSerializer.toJson(this.d));
      }

      this.g.b(var1);
   }

   public void b(NBTTagCompound var1) {
      this.e = var1.getString("Command");
      this.b = var1.getInt("SuccessCount");
      if(var1.hasOfType("CustomName", 8)) {
         this.f = var1.getString("CustomName");
      }

      if(var1.hasOfType("TrackOutput", 1)) {
         this.c = var1.getBoolean("TrackOutput");
      }

      if(var1.hasOfType("LastOutput", 8) && this.c) {
         this.d = IChatBaseComponent.ChatSerializer.fromJson(var1.getString("LastOutput"));
      }

      this.g.a(var1);
   }

   public boolean a(int var1, String var2) {
      return var1 <= 2;
   }

   public void a(String var1) {
      this.e = var1;
      this.b = 0;
   }

   public String l() {
      return this.e;
   }

   public void a(World var1) {
      if(var1.isClientSide) {
         this.b = 0;
      }

      MinecraftServer var2 = MinecraftServer.N();
      if(var2 != null && var2.O() && var2.al()) {
         class_l var3 = var2.P();

         try {
            this.d = null;
            this.b = var3.a(this, this.e);
         } catch (Throwable var7) {
            class_b var5 = class_b.a(var7, "Executing command block");
            class_c var6 = var5.a("Command to be executed");
            var6.a("Command", new Callable() {
               public String a() throws Exception {
                  return class_aed.this.l();
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            var6.a("Name", new Callable() {
               public String a() throws Exception {
                  return class_aed.this.getName();
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            throw new class_e(var5);
         }
      } else {
         this.b = 0;
      }

   }

   public String getName() {
      return this.f;
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      return new ChatComponentText(this.getName());
   }

   public void b(String var1) {
      this.f = var1;
   }

   public void a(IChatBaseComponent var1) {
      if(this.c && this.e() != null && !this.e().isClientSide) {
         this.d = (new ChatComponentText("[" + a.format(new Date()) + "] ")).addSibling(var1);
         this.h();
      }

   }

   public boolean u_() {
      MinecraftServer var1 = MinecraftServer.N();
      return var1 == null || !var1.O() || var1.d[0].R().b("commandBlockOutput");
   }

   public void a(class_n.class_a_in_class_n var1, int var2) {
      this.g.a(this, var1, var2);
   }

   public abstract void h();

   public void b(IChatBaseComponent var1) {
      this.d = var1;
   }

   public void a(boolean var1) {
      this.c = var1;
   }

   public boolean m() {
      return this.c;
   }

   public boolean a(EntityHuman var1) {
      if(!var1.abilities.instabuild) {
         return false;
      } else {
         if(var1.e().isClientSide) {
            var1.a(this);
         }

         return true;
      }
   }

   public class_n n() {
      return this.g;
   }
}
