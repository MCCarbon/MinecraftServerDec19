package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityCreature;
import net.minecraft.server.class_td;

public class class_sw extends class_td {
   private boolean a;
   private int b;
   private final Class[] c;

   public class_sw(EntityCreature var1, boolean var2, Class... var3) {
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
         List var3 = this.e.world.getEntities(this.e.getClass(), (new AxisAlignedBB(this.e.locX, this.e.locY, this.e.locZ, this.e.locX + 1.0D, this.e.locY + 1.0D, this.e.locZ + 1.0D)).grow(var1, 10.0D, var1));
         Iterator var4 = var3.iterator();

         label46:
         while(true) {
            EntityCreature var5;
            do {
               do {
                  do {
                     if(!var4.hasNext()) {
                        break label46;
                     }

                     var5 = (EntityCreature)var4.next();
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

   protected void a(EntityCreature var1, EntityLiving var2) {
      var1.d(var2);
   }
}
