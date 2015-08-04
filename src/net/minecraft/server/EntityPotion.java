package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class EntityPotion extends class_xo {
   private ItemStack d;

   public EntityPotion(World var1) {
      super(var1);
      this.d = ItemPotion.a(new ItemStack(Items.POTION), class_acf.a);
   }

   public EntityPotion(World var1, EntityLiving var2, ItemStack var3) {
      super(var1, var2);
      this.d = ItemPotion.a(new ItemStack(Items.POTION), class_acf.a);
      this.d = var3;
   }

   public EntityPotion(World var1, double var2, double var4, double var6, ItemStack var8) {
      super(var1, var2, var4, var6);
      this.d = ItemPotion.a(new ItemStack(Items.POTION), class_acf.a);
      this.d = var8;
   }

   protected float j() {
      return 0.05F;
   }

   protected void a(MovingObjectPosition var1) {
      if(!this.o.isClientSide) {
         class_acd var2 = ItemPotion.i(this.d);
         if(var1.a == MovingObjectPosition.class_a_in_class_awg.b && var2 == class_acf.a) {
            BlockPosition var16 = var1.a().shift(var1.b);
            this.a(var16);
            Iterator var17 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

            while(var17.hasNext()) {
               EnumDirection var18 = (EnumDirection)var17.next();
               this.a(var16.shift(var18));
            }

            this.o.b(2002, new BlockPosition(this), class_acd.a(var2));
            this.J();
         } else {
            List var3 = var2.b();
            if(!var3.isEmpty()) {
               AxisAlignedBB var4 = this.aT().grow(4.0D, 2.0D, 4.0D);
               List var5 = this.o.getEntities(EntityLiving.class, var4);
               if(!var5.isEmpty()) {
                  Iterator var6 = var5.iterator();

                  label54:
                  while(true) {
                     EntityLiving var7;
                     double var8;
                     do {
                        if(!var6.hasNext()) {
                           break label54;
                        }

                        var7 = (EntityLiving)var6.next();
                        var8 = this.h(var7);
                     } while(var8 >= 16.0D);

                     double var10 = 1.0D - Math.sqrt(var8) / 4.0D;
                     if(var7 == var1.d) {
                        var10 = 1.0D;
                     }

                     Iterator var12 = var3.iterator();

                     while(var12.hasNext()) {
                        MobEffect var13 = (MobEffect)var12.next();
                        MobEffectType var14 = var13.a();
                        if(var14.b()) {
                           var14.a(this, this.l(), var7, var13.c(), var10);
                        } else {
                           int var15 = (int)(var10 * (double)var13.b() + 0.5D);
                           if(var15 > 20) {
                              var7.addEffect(new MobEffect(var14, var15, var13.c()));
                           }
                        }
                     }
                  }
               }
            }

            this.o.b(2002, new BlockPosition(this), class_acd.a(var2));
            this.J();
         }
      }
   }

   private void a(BlockPosition var1) {
      if(this.o.getType(var1).getBlock() == Blocks.FIRE) {
         this.o.setTypeAndData((BlockPosition)var1, (IBlockData)Blocks.FLOWING_WATER.getBlockData().set(BlockFluids.LEVEL, Integer.valueOf(7)), 2);
      }

   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      this.d = ItemStack.a(var1.getCompound("Potion"));
      if(this.d == null) {
         this.J();
      }

   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      if(this.d != null) {
         var1.put((String)"Potion", (NBTTag)this.d.write(new NBTTagCompound()));
      }

   }

   public ItemStack m() {
      return this.d;
   }
}
