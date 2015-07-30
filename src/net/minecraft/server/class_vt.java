package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_xa;

public class class_vt extends class_vn {
   public class_vt(World var1) {
      super(var1);
   }

   public class_vt(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public boolean a(class_xa var1, class_aas var2, EnumUsedHand var3) {
      if(this.l != null && this.l instanceof class_xa && this.l != var1) {
         return true;
      } else if(this.l != null && this.l != var1) {
         return false;
      } else {
         if(!this.o.D) {
            var1.a((class_pr)this);
         }

         return true;
      }
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      if(var4) {
         if(this.l != null) {
            this.l.a((class_pr)null);
         }

         if(this.q() == 0) {
            this.k(-this.r());
            this.j(10);
            this.a(50.0F);
            this.ac();
         }
      }

   }

   public class_vn.class_a_in_class_vn s() {
      return class_vn.class_a_in_class_vn.a;
   }
}
