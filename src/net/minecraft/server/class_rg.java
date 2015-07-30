package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.class_ahl;
import net.minecraft.server.Material;
import net.minecraft.server.class_aut;
import net.minecraft.server.class_auv;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tf;

public abstract class class_rg extends class_rm {
   protected class_qb a;
   protected BlockPosition b;
   protected class_ahl c;
   boolean d;
   float e;
   float f;

   public class_rg(class_qb var1) {
      this.b = BlockPosition.ZERO;
      this.a = var1;
      if(!(var1.u() instanceof class_tf)) {
         throw new IllegalArgumentException("Unsupported mob type for DoorInteractGoal");
      }
   }

   public boolean a() {
      if(!this.a.D) {
         return false;
      } else {
         class_tf var1 = (class_tf)this.a.u();
         class_auv var2 = var1.j();
         if(var2 != null && !var2.b() && var1.g()) {
            for(int var3 = 0; var3 < Math.min(var2.e() + 2, var2.d()); ++var3) {
               class_aut var4 = var2.a(var3);
               this.b = new BlockPosition(var4.a, var4.b + 1, var4.c);
               if(this.a.e((double)this.b.getX(), this.a.t, (double)this.b.getZ()) <= 2.25D) {
                  this.c = this.a(this.b);
                  if(this.c != null) {
                     return true;
                  }
               }
            }

            this.b = (new BlockPosition(this.a)).shiftUp();
            this.c = this.a(this.b);
            return this.c != null;
         } else {
            return false;
         }
      }
   }

   public boolean b() {
      return !this.d;
   }

   public void c() {
      this.d = false;
      this.e = (float)((double)((float)this.b.getX() + 0.5F) - this.a.s);
      this.f = (float)((double)((float)this.b.getZ() + 0.5F) - this.a.u);
   }

   public void e() {
      float var1 = (float)((double)((float)this.b.getX() + 0.5F) - this.a.s);
      float var2 = (float)((double)((float)this.b.getZ() + 0.5F) - this.a.u);
      float var3 = this.e * var1 + this.f * var2;
      if(var3 < 0.0F) {
         this.d = true;
      }

   }

   private class_ahl a(BlockPosition var1) {
      Block var2 = this.a.o.p(var1).getBlock();
      return var2 instanceof class_ahl && var2.getMaterial() == Material.WOOD?(class_ahl)var2:null;
   }
}
