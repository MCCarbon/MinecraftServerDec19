package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_ul;
import net.minecraft.server.class_xa;

public class class_rc extends class_rm {
   private class_ul a;
   private class_xa b;
   private World c;
   private float d;
   private int e;

   public class_rc(class_ul var1, float var2) {
      this.a = var1;
      this.c = var1.o;
      this.d = var2;
      this.a(2);
   }

   public boolean a() {
      this.b = this.c.a(this.a, (double)this.d);
      return this.b == null?false:this.a(this.b);
   }

   public boolean b() {
      return !this.b.ai()?false:(this.a.h(this.b) > (double)(this.d * this.d)?false:this.e > 0 && this.a(this.b));
   }

   public void c() {
      this.a.q(true);
      this.e = 40 + this.a.bd().nextInt(40);
   }

   public void d() {
      this.a.q(false);
      this.b = null;
   }

   public void e() {
      this.a.q().a(this.b.s, this.b.t + (double)this.b.aU(), this.b.u, 10.0F, (float)this.a.cd());
      --this.e;
   }

   private boolean a(class_xa var1) {
      class_oo[] var2 = class_oo.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_oo var5 = var2[var4];
         class_aas var6 = var1.b((class_oo)var5);
         if(var6 != null) {
            if(this.a.cA() && var6.b() == Items.aZ) {
               return true;
            }

            if(this.a.d(var6)) {
               return true;
            }
         }
      }

      return false;
   }
}
