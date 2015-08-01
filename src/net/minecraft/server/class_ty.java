package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_po;
import net.minecraft.server.class_re;
import net.minecraft.server.class_rj;
import net.minecraft.server.class_rl;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_se;
import net.minecraft.server.class_sh;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sr;
import net.minecraft.server.class_tf;
import net.minecraft.server.class_tw;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;

public class class_ty extends class_tw {
   public class_ty(World var1) {
      super(var1);
      this.a(0.9F, 1.3F);
      ((class_tf)this.u()).a(true);
      this.i.a(0, new class_rj(this));
      this.i.a(1, new class_se(this, 2.0D));
      this.i.a(2, new class_re(this, 1.0D));
      this.i.a(3, new class_sr(this, 1.25D, Items.Q, false));
      this.i.a(4, new class_rl(this, 1.25D));
      this.i.a(5, new class_si(this, 1.0D));
      this.i.a(6, new class_rr(this, class_xa.class, 6.0F));
      this.i.a(7, new class_sh(this));
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(10.0D);
      this.a(class_wl.d).a(0.20000000298023224D);
   }

   protected String C() {
      return "mob.cow.say";
   }

   protected String bp() {
      return "mob.cow.hurt";
   }

   protected String bq() {
      return "mob.cow.hurt";
   }

   protected void a(BlockPosition var1, Block var2) {
      this.a("mob.cow.step", 0.15F, 1.0F);
   }

   protected float bC() {
      return 0.4F;
   }

   protected Item D() {
      return Items.aH;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3) + this.V.nextInt(1 + var2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.a(Items.aH, 1);
      }

      var3 = this.V.nextInt(3) + 1 + this.V.nextInt(1 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         if(this.av()) {
            this.a(Items.bl, 1);
         } else {
            this.a(Items.bk, 1);
         }
      }

   }

   public boolean a(class_xa var1, EnumUsedHand var2, ItemStack var3) {
      if(var3 != null && var3.getItem() == Items.ay && !var1.bH.instabuild && !this.j_()) {
         if(--var3.count == 0) {
            var1.a((EnumUsedHand)var2, (ItemStack)(new ItemStack(Items.aI)));
         } else if(!var1.bp.a(new ItemStack(Items.aI))) {
            var1.a(new ItemStack(Items.aI), false);
         }

         return true;
      } else {
         return super.a(var1, var2, var3);
      }
   }

   public class_ty b(class_po var1) {
      return new class_ty(this.o);
   }

   public float aU() {
      return this.K;
   }

   // $FF: synthetic method
   public class_po a(class_po var1) {
      return this.b(var1);
   }
}
