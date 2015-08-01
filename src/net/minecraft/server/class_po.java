package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_cy;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.MathHelper;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.Entity;
import net.minecraft.server.class_pt;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_qi;
import net.minecraft.server.EntityHuman;

public abstract class class_po extends class_qh {
   private static final int bs = class_qi.a(class_po.class);
   protected int a;
   protected int b;
   protected int c;
   private float bt = -1.0F;
   private float bu;

   public class_po(World var1) {
      super(var1);
   }

   public abstract class_po a(class_po var1);

   public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
      if(var3 != null && var3.getItem() == Items.bM) {
         if(!this.o.isClientSide) {
            Class var4 = class_pt.a(var3.i());
            if(var4 != null && this.getClass() == var4) {
               class_po var5 = this.a(this);
               if(var5 != null) {
                  var5.b(-24000);
                  var5.b(this.s, this.t, this.u, 0.0F, 0.0F);
                  this.o.addEntity((Entity)var5);
                  if(var3.hasDisplayName()) {
                     var5.a((String)var3.getDisplayName());
                  }

                  if(!var1.bH.instabuild) {
                     --var3.count;
                  }
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   protected void h() {
      super.h();
      this.ac.a(bs, Byte.valueOf((byte)0));
   }

   public int l() {
      return this.o.isClientSide?this.ac.a(bs):this.a;
   }

   public void a(int var1, boolean var2) {
      int var3 = this.l();
      int var4 = var3;
      var3 += var1 * 20;
      if(var3 > 0) {
         var3 = 0;
         if(var4 < 0) {
            this.n();
         }
      }

      int var5 = var3 - var4;
      this.b(var3);
      if(var2) {
         this.b += var5;
         if(this.c == 0) {
            this.c = 40;
         }
      }

      if(this.l() == 0) {
         this.b(this.b);
      }

   }

   public void a(int var1) {
      this.a(var1, false);
   }

   public void b(int var1) {
      this.ac.b(bs, Byte.valueOf((byte)MathHelper.clamp(var1, -1, 1)));
      this.a = var1;
      this.a(this.j_());
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.put("Age", this.l());
      var1.put("ForcedAge", this.b);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.b(var1.getInt("Age"));
      this.b = var1.getInt("ForcedAge");
   }

   public void d(int var1) {
      if(var1 == bs) {
         this.a(this.j_());
      }

      super.d(var1);
   }

   public void m() {
      super.m();
      if(this.o.isClientSide) {
         if(this.c > 0) {
            if(this.c % 4 == 0) {
               this.o.a(class_cy.v, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 0.5D + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, 0.0D, 0.0D, 0.0D, new int[0]);
            }

            --this.c;
         }
      } else {
         int var1 = this.l();
         if(var1 < 0) {
            ++var1;
            this.b(var1);
            if(var1 == 0) {
               this.n();
            }
         } else if(var1 > 0) {
            --var1;
            this.b(var1);
         }
      }

   }

   protected void n() {
   }

   public boolean j_() {
      return this.l() < 0;
   }

   public void a(boolean var1) {
      this.a(var1?0.5F:1.0F);
   }

   protected final void a(float var1, float var2) {
      boolean var3 = this.bt > 0.0F;
      this.bt = var1;
      this.bu = var2;
      if(!var3) {
         this.a(1.0F);
      }

   }

   protected final void a(float var1) {
      super.a(this.bt * var1, this.bu * var1);
   }
}
