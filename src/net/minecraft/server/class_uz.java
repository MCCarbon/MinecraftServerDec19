package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahh;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import org.apache.commons.lang3.Validate;

public abstract class class_uz extends class_pr {
   private int c;
   protected BlockPosition a;
   public EnumDirection b;

   public class_uz(World var1) {
      super(var1);
      this.a(0.5F, 0.5F);
   }

   public class_uz(World var1, BlockPosition var2) {
      this(var1);
      this.a = var2;
   }

   protected void h() {
   }

   protected void a(EnumDirection var1) {
      Validate.notNull(var1);
      Validate.isTrue(var1.getAxis().isHorizontal());
      this.b = var1;
      this.A = this.y = (float)(this.b.getHorizontalId() * 90);
      this.o();
   }

   private void o() {
      if(this.b != null) {
         double var1 = (double)this.a.getX() + 0.5D;
         double var3 = (double)this.a.getY() + 0.5D;
         double var5 = (double)this.a.getZ() + 0.5D;
         double var7 = 0.46875D;
         double var9 = this.a(this.l());
         double var11 = this.a(this.m());
         var1 -= (double)this.b.getAdjacentX() * 0.46875D;
         var5 -= (double)this.b.getAdjacentZ() * 0.46875D;
         var3 += var11;
         EnumDirection var13 = this.b.rotateYCCW();
         var1 += var9 * (double)var13.getAdjacentX();
         var5 += var9 * (double)var13.getAdjacentZ();
         this.s = var1;
         this.t = var3;
         this.u = var5;
         double var14 = (double)this.l();
         double var16 = (double)this.m();
         double var18 = (double)this.l();
         if(this.b.getAxis() == EnumDirection.EnumAxis.Z) {
            var18 = 1.0D;
         } else {
            var14 = 1.0D;
         }

         var14 /= 32.0D;
         var16 /= 32.0D;
         var18 /= 32.0D;
         this.a((class_awf)(new class_awf(var1 - var14, var3 - var16, var5 - var18, var1 + var14, var3 + var16, var5 + var18)));
      }
   }

   private double a(int var1) {
      return var1 % 32 == 0?0.5D:0.0D;
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      if(this.c++ == 100 && !this.o.D) {
         this.c = 0;
         if(!this.I && !this.j()) {
            this.J();
            this.b((class_pr)null);
         }
      }

   }

   public boolean j() {
      if(!this.o.a((class_pr)this, (class_awf)this.aT()).isEmpty()) {
         return false;
      } else {
         int var1 = Math.max(1, this.l() / 16);
         int var2 = Math.max(1, this.m() / 16);
         BlockPosition var3 = this.a.shift(this.b.getOpposite());
         EnumDirection var4 = this.b.rotateYCCW();

         for(int var5 = 0; var5 < var1; ++var5) {
            for(int var6 = 0; var6 < var2; ++var6) {
               BlockPosition var7 = var3.shift(var4, var5).shiftUp(var6);
               Block var8 = this.o.p(var7).getBlock();
               if(!var8.getMaterial().isBuildable() && !class_ahh.d(var8)) {
                  return false;
               }
            }
         }

         List var9 = this.o.b((class_pr)this, (class_awf)this.aT());
         Iterator var10 = var9.iterator();

         class_pr var11;
         do {
            if(!var10.hasNext()) {
               return true;
            }

            var11 = (class_pr)var10.next();
         } while(!(var11 instanceof class_uz));

         return false;
      }
   }

   public boolean ad() {
      return true;
   }

   public boolean l(class_pr var1) {
      return var1 instanceof class_xa?this.a(class_pc.a((class_xa)var1), 0.0F):false;
   }

   public EnumDirection aR() {
      return this.b;
   }

   public boolean a(class_pc var1, float var2) {
      if(this.b((class_pc)var1)) {
         return false;
      } else {
         if(!this.I && !this.o.D) {
            this.J();
            this.ac();
            this.b(var1.j());
         }

         return true;
      }
   }

   public void d(double var1, double var3, double var5) {
      if(!this.o.D && !this.I && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D) {
         this.J();
         this.b((class_pr)null);
      }

   }

   public void g(double var1, double var3, double var5) {
      if(!this.o.D && !this.I && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D) {
         this.J();
         this.b((class_pr)null);
      }

   }

   public void b(class_dn var1) {
      var1.a("Facing", (byte)this.b.getHorizontalId());
      var1.a("TileX", this.n().getX());
      var1.a("TileY", this.n().getY());
      var1.a("TileZ", this.n().getZ());
   }

   public void a(class_dn var1) {
      this.a = new BlockPosition(var1.g("TileX"), var1.g("TileY"), var1.g("TileZ"));
      EnumDirection var2;
      if(var1.b("Direction", 99)) {
         var2 = EnumDirection.getByHorizontalId(var1.e("Direction"));
         this.a = this.a.shift(var2);
      } else if(var1.b("Facing", 99)) {
         var2 = EnumDirection.getByHorizontalId(var1.e("Facing"));
      } else {
         var2 = EnumDirection.getByHorizontalId(var1.e("Dir"));
      }

      this.a(var2);
   }

   public abstract int l();

   public abstract int m();

   public abstract void b(class_pr var1);

   protected boolean af() {
      return false;
   }

   public void b(double var1, double var3, double var5) {
      this.s = var1;
      this.t = var3;
      this.u = var5;
      BlockPosition var7 = this.a;
      this.a = new BlockPosition(var1, var3, var5);
      if(!this.a.equals(var7)) {
         this.o();
         this.ai = true;
      }

   }

   public BlockPosition n() {
      return this.a;
   }

   public float a(Block.class_c_in_class_agj var1) {
      if(this.b.getAxis() != EnumDirection.EnumAxis.Y) {
         switch(class_uz.SyntheticClass_1.a[var1.ordinal()]) {
         case 1:
            this.b = this.b.getOpposite();
            break;
         case 2:
            this.b = this.b.rotateYCCW();
            break;
         case 3:
            this.b = this.b.rotateY();
         }
      }

      return super.a(var1);
   }

   public float a(Block.class_a_in_class_agj var1) {
      return this.a(var1.a(this.b));
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[Block.class_c_in_class_agj.values().length];

      static {
         try {
            a[Block.class_c_in_class_agj.c.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[Block.class_c_in_class_agj.d.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[Block.class_c_in_class_agj.b.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
