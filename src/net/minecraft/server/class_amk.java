package net.minecraft.server;

import net.minecraft.server.class_amg;
import net.minecraft.server.NBTTagCompound;

public class class_amk extends class_amg {
   private int a;

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.put("OutputSignal", this.a);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.a = var1.getInt("OutputSignal");
   }

   public int b() {
      return this.a;
   }

   public void a(int var1) {
      this.a = var1;
   }
}
