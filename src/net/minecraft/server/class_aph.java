package net.minecraft.server;

import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;

public class class_aph {
   private final short[] a = new short[65536];
   private final class_anl b;

   public class_aph() {
      this.b = class_agk.a.S();
   }

   public class_anl a(int var1, int var2, int var3) {
      int var4 = var1 << 12 | var3 << 8 | var2;
      return this.a(var4);
   }

   public class_anl a(int var1) {
      if(var1 >= 0 && var1 < this.a.length) {
         class_anl var2 = (class_anl)class_agj.d.a(this.a[var1]);
         return var2 != null?var2:this.b;
      } else {
         throw new IndexOutOfBoundsException("The coordinate is out of range");
      }
   }

   public void a(int var1, int var2, int var3, class_anl var4) {
      int var5 = var1 << 12 | var3 << 8 | var2;
      this.a(var5, var4);
   }

   public void a(int var1, class_anl var2) {
      if(var1 >= 0 && var1 < this.a.length) {
         this.a[var1] = (short)class_agj.d.a(var2);
      } else {
         throw new IndexOutOfBoundsException("The coordinate is out of range");
      }
   }

   public int a(int var1, int var2) {
      int var3 = (var1 << 12 | var2 << 8) + 256 - 1;

      for(int var4 = 255; var4 >= 0; --var4) {
         class_anl var5 = (class_anl)class_agj.d.a(this.a[var3 + var4]);
         if(var5 != null && var5 != this.b) {
            return var4;
         }
      }

      return 0;
   }
}
