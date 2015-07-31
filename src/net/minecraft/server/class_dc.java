package net.minecraft.server;

import net.minecraft.server.NBTTagFloat;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;

public class class_dc {
   protected final float a;
   protected final float b;
   protected final float c;

   public class_dc(float var1, float var2, float var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public class_dc(NBTTagList var1) {
      this.a = var1.getFloat(0);
      this.b = var1.getFloat(1);
      this.c = var1.getFloat(2);
   }

   public NBTTagList a() {
      NBTTagList var1 = new NBTTagList();
      var1.add((NBTTag)(new NBTTagFloat(this.a)));
      var1.add((NBTTag)(new NBTTagFloat(this.b)));
      var1.add((NBTTag)(new NBTTagFloat(this.c)));
      return var1;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class_dc)) {
         return false;
      } else {
         class_dc var2 = (class_dc)var1;
         return this.a == var2.a && this.b == var2.b && this.c == var2.c;
      }
   }

   public float b() {
      return this.a;
   }

   public float c() {
      return this.b;
   }

   public float d() {
      return this.c;
   }
}
