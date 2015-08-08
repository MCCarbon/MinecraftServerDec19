package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EntityTippedArrow extends EntityArrow {
   private static final int f = DataWathcer.claimId(EntityTippedArrow.class);
   private final Set g;
   private ItemStack h;

   public EntityTippedArrow(World var1) {
      super(var1);
      this.g = Sets.newHashSet();
   }

   public EntityTippedArrow(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
      this.g = Sets.newHashSet();
   }

   public EntityTippedArrow(World var1, double var2, double var4, double var6, ItemStack var8) {
      this(var1, var2, var4, var6);
      this.a(var8);
   }

   public EntityTippedArrow(World var1, EntityLiving var2, ItemStack var3) {
      super(var1, var2);
      this.g = Sets.newHashSet();
      this.a(var3);
   }

   private void a(ItemStack var1) {
      List var2 = ItemPotion.h(var1);
      if(!var2.isEmpty()) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            MobEffect var4 = (MobEffect)var3.next();
            this.g.add(new MobEffect(var4));
         }

         this.datawatcher.update(f, Integer.valueOf(ItemPotion.a((Collection) this.g)));
      }

      this.h = var1.clone();
      this.h.count = 1;
   }

   protected void initDatawatcher() {
      super.initDatawatcher();
      this.datawatcher.add(f, Integer.valueOf(0));
   }

   public void t_() {
      super.t_();
      int var1;
      double var2;
      double var4;
      double var6;
      if(this.a) {
         if(this.world.isClientSide) {
            var1 = this.datawatcher.getInt(f);
            if(var1 > 0 && this.b % 5 == 0) {
               var2 = (double)(var1 >> 16 & 255) / 255.0D;
               var4 = (double)(var1 >> 8 & 255) / 255.0D;
               var6 = (double)(var1 >> 0 & 255) / 255.0D;
               this.world.addParticle(EnumParticle.p, this.locX + (this.random.nextDouble() - 0.5D) * (double)this.width, this.locY + this.random.nextDouble() * (double)this.length, this.locZ + (this.random.nextDouble() - 0.5D) * (double)this.width, var2, var4, var6, new int[0]);
            }
         } else if(!this.g.isEmpty() && this.b >= 200) {
            this.world.a((Entity)this, (byte)0);
            this.g.clear();
            this.datawatcher.update(f, Integer.valueOf(0));
         }
      } else if(this.world.isClientSide) {
         var1 = this.datawatcher.getInt(f);
         if(var1 > 0) {
            var2 = (double)(var1 >> 16 & 255) / 255.0D;
            var4 = (double)(var1 >> 8 & 255) / 255.0D;
            var6 = (double)(var1 >> 0 & 255) / 255.0D;

            for(int var8 = 0; var8 < 2; ++var8) {
               this.world.addParticle(EnumParticle.p, this.locX + (this.random.nextDouble() - 0.5D) * (double)this.width, this.locY + this.random.nextDouble() * (double)this.length, this.locZ + (this.random.nextDouble() - 0.5D) * (double)this.width, var2, var4, var6, new int[0]);
            }
         }
      }

   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      if(this.h != null) {
         var1.put((String)"Item", (NBTTag)this.h.write(new NBTTagCompound()));
      }

   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      if(var1.hasOfType("Item", 10)) {
         this.h = ItemStack.a(var1.getCompound("Item"));
      }

   }

   protected void b(EntityLiving var1) {
      super.b(var1);
      if(!this.g.isEmpty()) {
         Iterator var2 = this.g.iterator();

         while(var2.hasNext()) {
            MobEffect var3 = (MobEffect)var2.next();
            var1.addEffect(var3);
         }
      }

   }

   protected ItemStack j() {
      return this.g.isEmpty()?new ItemStack(Items.ARROW):this.h;
   }
}
