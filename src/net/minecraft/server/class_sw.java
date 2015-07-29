package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_td;

public class class_sw extends class_td {
   private boolean a;
   private int b;
   private final Class[] c;

   public class_sw(class_qh var1, boolean var2, Class... var3) {
      super(var1, false);
      this.a = var2;
      this.c = var3;
      this.a(1);
   }

   public boolean a() {
      int var1 = this.e.bf();
      return var1 != this.b && this.a(this.e.be(), false);
   }

   public void c() {
      this.e.d(this.e.be());
      this.b = this.e.bf();
      if(this.a) {
         double var1 = this.f();
         List var3 = this.e.o.a(this.e.getClass(), (new class_awf(this.e.s, this.e.t, this.e.u, this.e.s + 1.0D, this.e.t + 1.0D, this.e.u + 1.0D)).b(var1, 10.0D, var1));
         Iterator var4 = var3.iterator();

         label46:
         while(true) {
            class_qh var5;
            do {
               do {
                  do {
                     if(!var4.hasNext()) {
                        break label46;
                     }

                     var5 = (class_qh)var4.next();
                  } while(this.e == var5);
               } while(var5.w() != null);
            } while(var5.c(this.e.be()));

            boolean var6 = false;
            Class[] var7 = this.c;
            int var8 = var7.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               Class var10 = var7[var9];
               if(var5.getClass() == var10) {
                  var6 = true;
                  break;
               }
            }

            if(!var6) {
               this.a(var5, this.e.be());
            }
         }
      }

      super.c();
   }

   protected void a(class_qh var1, class_qa var2) {
      var1.d(var2);
   }
}
