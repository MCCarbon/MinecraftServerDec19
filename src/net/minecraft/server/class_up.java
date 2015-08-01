package net.minecraft.server;

import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.class_uo;

public class class_up extends Entity {
   public final class_uo a;
   public final String b;

   public class_up(class_uo var1, String var2, float var3, float var4) {
      super(var1.a());
      this.a(var3, var4);
      this.a = var1;
      this.b = var2;
   }

   protected void h() {
   }

   protected void a(NBTTagCompound var1) {
   }

   protected void b(NBTTagCompound var1) {
   }

   public boolean ad() {
      return true;
   }

   public boolean a(class_pc var1, float var2) {
      return this.b(var1)?false:this.a.a(this, var1, var2);
   }

   public boolean k(Entity var1) {
      return this == var1 || this.a == var1;
   }
}
