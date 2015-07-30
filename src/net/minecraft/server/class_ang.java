package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_pr;

public class class_ang extends class_amg implements class_kn {
   private IBlockData a;
   private EnumDirection f;
   private boolean g;
   private boolean h;
   private float i;
   private float j;
   private List k = Lists.newArrayList();

   public class_ang() {
   }

   public class_ang(IBlockData var1, EnumDirection var2, boolean var3, boolean var4) {
      this.a = var1;
      this.f = var2;
      this.g = var3;
      this.h = var4;
   }

   public IBlockData b() {
      return this.a;
   }

   public int u() {
      return 0;
   }

   public boolean d() {
      return this.g;
   }

   public EnumDirection e() {
      return this.f;
   }

   public float a(float var1) {
      if(var1 > 1.0F) {
         var1 = 1.0F;
      }

      return this.j + (this.i - this.j) * var1;
   }

   private void a(float var1, float var2) {
      if(this.g) {
         var1 = 1.0F - var1;
      } else {
         --var1;
      }

      class_awf var3 = Blocks.PISTON_EXTENSION.a(this.b, this.c, this.a, var1, this.f);
      if(var3 != null) {
         List var4 = this.b.b((class_pr)null, (class_awf)var3);
         if(!var4.isEmpty()) {
            this.k.addAll(var4);
            Iterator var5 = this.k.iterator();

            while(true) {
               while(var5.hasNext()) {
                  class_pr var6 = (class_pr)var5.next();
                  if(this.a.getBlock() == Blocks.SLINE && this.g) {
                     switch(class_ang.SyntheticClass_1.a[this.f.getAxis().ordinal()]) {
                     case 1:
                        var6.v = (double)this.f.getAdjacentX();
                        break;
                     case 2:
                        var6.w = (double)this.f.getAdjacentY();
                        break;
                     case 3:
                        var6.x = (double)this.f.getAdjacentZ();
                     }
                  } else {
                     var6.d((double)(var2 * (float)this.f.getAdjacentX()), (double)(var2 * (float)this.f.getAdjacentY()), (double)(var2 * (float)this.f.getAdjacentZ()));
                  }
               }

               this.k.clear();
               break;
            }
         }
      }

   }

   public void h() {
      if(this.j < 1.0F && this.b != null) {
         this.j = this.i = 1.0F;
         this.b.t(this.c);
         this.y();
         if(this.b.p(this.c).getBlock() == Blocks.PISTON_EXTENSION) {
            this.b.a((BlockPosition)this.c, (IBlockData)this.a, 3);
            this.b.d(this.c, this.a.getBlock());
         }
      }

   }

   public void c() {
      this.j = this.i;
      if(this.j >= 1.0F) {
         this.a(1.0F, 0.25F);
         this.b.t(this.c);
         this.y();
         if(this.b.p(this.c).getBlock() == Blocks.PISTON_EXTENSION) {
            this.b.a((BlockPosition)this.c, (IBlockData)this.a, 3);
            this.b.d(this.c, this.a.getBlock());
         }

      } else {
         this.i += 0.5F;
         if(this.i >= 1.0F) {
            this.i = 1.0F;
         }

         if(this.g) {
            this.a(this.i, this.i - this.j + 0.0625F);
         }

      }
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.a = Block.getById(var1.g("blockId")).fromLegacyData(var1.g("blockData"));
      this.f = EnumDirection.getById(var1.g("facing"));
      this.j = this.i = var1.i("progress");
      this.g = var1.o("extending");
   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("blockId", Block.getId(this.a.getBlock()));
      var1.a("blockData", this.a.getBlock().toLegacyData(this.a));
      var1.a("facing", this.f.getId());
      var1.a("progress", this.j);
      var1.a("extending", this.g);
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumDirection.EnumAxis.values().length];

      static {
         try {
            a[EnumDirection.EnumAxis.X.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.EnumAxis.Y.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.EnumAxis.Z.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}