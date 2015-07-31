package net.minecraft.server;

import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTag;

public class class_wy {
   public boolean a;
   public boolean b;
   public boolean c;
   public boolean d;
   public boolean e = true;
   private float f = 0.05F;
   private float g = 0.1F;

   public void a(NBTTagCompound var1) {
      NBTTagCompound var2 = new NBTTagCompound();
      var2.put("invulnerable", this.a);
      var2.put("flying", this.b);
      var2.put("mayfly", this.c);
      var2.put("instabuild", this.d);
      var2.put("mayBuild", this.e);
      var2.put("flySpeed", this.f);
      var2.put("walkSpeed", this.g);
      var1.put((String)"abilities", (NBTTag)var2);
   }

   public void b(NBTTagCompound var1) {
      if(var1.hasOfType("abilities", 10)) {
         NBTTagCompound var2 = var1.getCompound("abilities");
         this.a = var2.getBoolean("invulnerable");
         this.b = var2.getBoolean("flying");
         this.c = var2.getBoolean("mayfly");
         this.d = var2.getBoolean("instabuild");
         if(var2.hasOfType("flySpeed", 99)) {
            this.f = var2.getFloat("flySpeed");
            this.g = var2.getFloat("walkSpeed");
         }

         if(var2.hasOfType("mayBuild", 1)) {
            this.e = var2.getBoolean("mayBuild");
         }
      }

   }

   public float a() {
      return this.f;
   }

   public float b() {
      return this.g;
   }
}
