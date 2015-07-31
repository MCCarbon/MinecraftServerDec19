package net.minecraft.server;

import net.minecraft.server.NBTTagCompound;

public abstract class class_avd {
   public final String a;
   private boolean b;

   public class_avd(String var1) {
      this.a = var1;
   }

   public abstract void a(NBTTagCompound var1);

   public abstract void b(NBTTagCompound var1);

   public void c() {
      this.a(true);
   }

   public void a(boolean var1) {
      this.b = var1;
   }

   public boolean d() {
      return this.b;
   }
}
