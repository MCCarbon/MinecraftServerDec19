package net.minecraft.server;

import com.google.common.collect.ComparisonChain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_pl implements Comparable {
   private static final Logger a = LogManager.getLogger();
   private final MobEffect b;
   private int c;
   private int d;
   private boolean e;
   private boolean f;
   private boolean h;

   public class_pl(MobEffect var1) {
      this(var1, 0, 0);
   }

   public class_pl(MobEffect var1, int var2) {
      this(var1, var2, 0);
   }

   public class_pl(MobEffect var1, int var2, int var3) {
      this(var1, var2, var3, false, true);
   }

   public class_pl(MobEffect var1, int var2, int var3, boolean var4, boolean var5) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.f = var4;
      this.h = var5;
   }

   public class_pl(class_pl var1) {
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.f = var1.f;
      this.h = var1.h;
   }

   public void a(class_pl var1) {
      if(this.b != var1.b) {
         a.warn("This method should only be called for matching effects!");
      }

      if(var1.d > this.d) {
         this.d = var1.d;
         this.c = var1.c;
      } else if(var1.d == this.d && this.c < var1.c) {
         this.c = var1.c;
      } else if(!var1.f && this.f) {
         this.f = var1.f;
      }

      this.h = var1.h;
   }

   public MobEffect a() {
      return this.b;
   }

   public int b() {
      return this.c;
   }

   public int c() {
      return this.d;
   }

   public boolean d() {
      return this.f;
   }

   public boolean e() {
      return this.h;
   }

   public boolean a(EntityLiving var1) {
      if(this.c > 0) {
         if(this.b.a(this.c, this.d)) {
            this.b(var1);
         }

         this.h();
      }

      return this.c > 0;
   }

   private int h() {
      return --this.c;
   }

   public void b(EntityLiving var1) {
      if(this.c > 0) {
         this.b.a(var1, this.d);
      }

   }

   public String f() {
      return this.b.a();
   }

   public String toString() {
      String var1 = "";
      if(this.d > 0) {
         var1 = this.f() + " x " + (this.d + 1) + ", Duration: " + this.c;
      } else {
         var1 = this.f() + ", Duration: " + this.c;
      }

      if(this.e) {
         var1 = var1 + ", Splash: true";
      }

      if(!this.h) {
         var1 = var1 + ", Particles: false";
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof class_pl)) {
         return false;
      } else {
         class_pl var2 = (class_pl)var1;
         return this.c != var2.c?false:(this.d != var2.d?false:(this.e != var2.e?false:(this.f != var2.f?false:this.b.equals(var2.b))));
      }
   }

   public int hashCode() {
      int var1 = this.b.hashCode();
      var1 = 31 * var1 + this.c;
      var1 = 31 * var1 + this.d;
      var1 = 31 * var1 + (this.e?1:0);
      var1 = 31 * var1 + (this.f?1:0);
      return var1;
   }

   public NBTTagCompound a(NBTTagCompound var1) {
      var1.put("Id", (byte) MobEffect.a(this.a()));
      var1.put("Amplifier", (byte)this.c());
      var1.put("Duration", this.b());
      var1.put("Ambient", this.d());
      var1.put("ShowParticles", this.e());
      return var1;
   }

   public static class_pl b(NBTTagCompound var0) {
      byte var1 = var0.getByte("Id");
      MobEffect var2 = MobEffect.a(var1);
      if(var2 == null) {
         return null;
      } else {
         byte var3 = var0.getByte("Amplifier");
         int var4 = var0.getInt("Duration");
         boolean var5 = var0.getBoolean("Ambient");
         boolean var6 = true;
         if(var0.hasOfType("ShowParticles", 1)) {
            var6 = var0.getBoolean("ShowParticles");
         }

         return new class_pl(var2, var4, var3, var5, var6);
      }
   }

   public int b(class_pl var1) {
      return ComparisonChain.start().compare(this.b(), var1.b()).compare(this.a().g(), var1.a().g()).result();
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.b((class_pl)var1);
   }
}
