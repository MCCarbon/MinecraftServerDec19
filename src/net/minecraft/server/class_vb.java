package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_ahz;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_dn;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_uz;
import net.minecraft.server.class_xa;

public class class_vb extends class_uz {
   public class_vb(World var1) {
      super(var1);
   }

   public class_vb(World var1, BlockPosition var2) {
      super(var1, var2);
      this.b((double)var2.getX() + 0.5D, (double)var2.getY() + 0.5D, (double)var2.getZ() + 0.5D);
      float var3 = 0.125F;
      float var4 = 0.1875F;
      float var5 = 0.25F;
      this.a((class_awf)(new class_awf(this.s - 0.1875D, this.t - 0.25D + 0.125D, this.u - 0.1875D, this.s + 0.1875D, this.t + 0.25D + 0.125D, this.u + 0.1875D)));
   }

   public void a(EnumDirection var1) {
   }

   public int l() {
      return 9;
   }

   public int m() {
      return 9;
   }

   public float aU() {
      return -0.0625F;
   }

   public void b(class_pr var1) {
   }

   public boolean d(class_dn var1) {
      return false;
   }

   public void b(class_dn var1) {
   }

   public void a(class_dn var1) {
   }

   public boolean a(class_xa var1, class_aas var2, EnumUsedHand var3) {
      if(this.o.D) {
         return true;
      } else {
         boolean var4 = false;
         double var5;
         List var7;
         Iterator var8;
         class_qb var9;
         if(var2 != null && var2.b() == Items.cq) {
            var5 = 7.0D;
            var7 = this.o.a(class_qb.class, new class_awf(this.s - var5, this.t - var5, this.u - var5, this.s + var5, this.t + var5, this.u + var5));
            var8 = var7.iterator();

            while(var8.hasNext()) {
               var9 = (class_qb)var8.next();
               if(var9.cq() && var9.cr() == var1) {
                  var9.a(this, true);
                  var4 = true;
               }
            }
         }

         if(!var4) {
            this.J();
            if(var1.bH.d) {
               var5 = 7.0D;
               var7 = this.o.a(class_qb.class, new class_awf(this.s - var5, this.t - var5, this.u - var5, this.s + var5, this.t + var5, this.u + var5));
               var8 = var7.iterator();

               while(var8.hasNext()) {
                  var9 = (class_qb)var8.next();
                  if(var9.cq() && var9.cr() == this) {
                     var9.a(true, false);
                  }
               }
            }
         }

         return true;
      }
   }

   public boolean j() {
      return this.o.p(this.a).getBlock() instanceof class_ahz;
   }

   public static class_vb a(World var0, BlockPosition var1) {
      class_vb var2 = new class_vb(var0, var1);
      var2.n = true;
      var0.a((class_pr)var2);
      return var2;
   }

   public static class_vb b(World var0, BlockPosition var1) {
      int var2 = var1.getX();
      int var3 = var1.getY();
      int var4 = var1.getZ();
      List var5 = var0.a(class_vb.class, new class_awf((double)var2 - 1.0D, (double)var3 - 1.0D, (double)var4 - 1.0D, (double)var2 + 1.0D, (double)var3 + 1.0D, (double)var4 + 1.0D));
      Iterator var6 = var5.iterator();

      class_vb var7;
      do {
         if(!var6.hasNext()) {
            return null;
         }

         var7 = (class_vb)var6.next();
      } while(!var7.n().equals(var1));

      return var7;
   }
}
