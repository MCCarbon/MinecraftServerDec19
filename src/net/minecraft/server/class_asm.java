package net.minecraft.server;

import net.minecraft.server.class_avd;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTag;

public class class_asm extends class_avd {
   private NBTTagCompound b = new NBTTagCompound();

   public class_asm(String var1) {
      super(var1);
   }

   public void a(NBTTagCompound var1) {
      this.b = var1.getCompound("Features");
   }

   public void b(NBTTagCompound var1) {
      var1.put((String)"Features", (NBTTag)this.b);
   }

   public void a(NBTTagCompound var1, int var2, int var3) {
      this.b.put((String)b(var2, var3), (NBTTag)var1);
   }

   public static String b(int var0, int var1) {
      return "[" + var0 + "," + var1 + "]";
   }

   public NBTTagCompound a() {
      return this.b;
   }
}
