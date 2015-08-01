package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_cy;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_po;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_ty;
import net.minecraft.server.class_vm;
import net.minecraft.server.class_xa;

public class class_ub extends class_ty {
   public class_ub(World var1) {
      super(var1);
      this.a(0.9F, 1.3F);
      this.bv = Blocks.MYCELIM;
   }

   public boolean a(class_xa var1, EnumUsedHand var2, ItemStack var3) {
      if(var3 != null && var3.getItem() == Items.B && this.l() >= 0 && !var1.bH.instabuild) {
         if(--var3.count == 0) {
            var1.a((EnumUsedHand)var2, (ItemStack)(new ItemStack(Items.C)));
         } else if(!var1.bp.a(new ItemStack(Items.C))) {
            var1.a(new ItemStack(Items.C), false);
         }

         return true;
      } else if(var3 != null && var3.getItem() == Items.bg && this.l() >= 0) {
         this.J();
         this.o.a(class_cy.b, this.s, this.t + (double)(this.K / 2.0F), this.u, 0.0D, 0.0D, 0.0D, new int[0]);
         if(!this.o.D) {
            class_ty var4 = new class_ty(this.o);
            var4.b(this.s, this.t, this.u, this.y, this.z);
            var4.i(this.bo());
            var4.aL = this.aL;
            if(this.l_()) {
               var4.a(this.aO());
            }

            this.o.a((class_pr)var4);

            for(int var5 = 0; var5 < 5; ++var5) {
               this.o.a((class_pr)(new class_vm(this.o, this.s, this.t + (double)this.K, this.u, new ItemStack(Blocks.RED_MUSHROOM))));
            }

            var3.a(1, (class_qa)var1);
            this.a("mob.sheep.shear", 1.0F, 1.0F);
         }

         return true;
      } else {
         return super.a(var1, var2, var3);
      }
   }

   public class_ub c(class_po var1) {
      return new class_ub(this.o);
   }

   // $FF: synthetic method
   public class_ty b(class_po var1) {
      return this.c(var1);
   }

   // $FF: synthetic method
   public class_po a(class_po var1) {
      return this.c(var1);
   }
}
