package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class class_pb {
   private final List a = Lists.newArrayList();
   private final EntityLiving b;
   private int c;
   private int d;
   private int e;
   private boolean f;
   private boolean g;
   private String h;

   public class_pb(EntityLiving var1) {
      this.b = var1;
   }

   public void a() {
      this.j();
      if(this.b.k_()) {
         Block var1 = this.b.world.getType(new BlockPosition(this.b.locX, this.b.getBoundingBox().yMin, this.b.locZ)).getBlock();
         if(var1 == Blocks.LADDER) {
            this.h = "ladder";
         } else if(var1 == Blocks.VINE) {
            this.h = "vines";
         }
      } else if(this.b.V()) {
         this.h = "water";
      }

   }

   public void a(DamageSource var1, float var2, float var3) {
      this.g();
      this.a();
      class_pa var4 = new class_pa(var1, this.b.ticksLived, var2, var3, this.h, this.b.fallDistance);
      this.a.add(var4);
      this.c = this.b.ticksLived;
      this.g = true;
      if(var4.f() && !this.f && this.b.isAlive()) {
         this.f = true;
         this.d = this.b.ticksLived;
         this.e = this.d;
         this.b.h_();
      }

   }

   public IChatBaseComponent b() {
      if(this.a.isEmpty()) {
         return new ChatMessage("death.attack.generic", new Object[]{this.b.getScoreboardDisplayName()});
      } else {
         class_pa var1 = this.i();
         class_pa var2 = (class_pa)this.a.get(this.a.size() - 1);
         IChatBaseComponent var4 = var2.h();
         Entity var5 = var2.a().j();
         Object var3;
         if(var1 != null && var2.a() == DamageSource.i) {
            IChatBaseComponent var6 = var1.h();
            if(var1.a() != DamageSource.i && var1.a() != DamageSource.j) {
               if(var6 == null || var4 != null && var6.equals(var4)) {
                  if(var4 != null) {
                     ItemStack var9 = var5 instanceof EntityLiving?((EntityLiving)var5).bA():null;
                     if(var9 != null && var9.hasDisplayName()) {
                        var3 = new ChatMessage("death.fell.finish.item", new Object[]{this.b.getScoreboardDisplayName(), var4, var9.B()});
                     } else {
                        var3 = new ChatMessage("death.fell.finish", new Object[]{this.b.getScoreboardDisplayName(), var4});
                     }
                  } else {
                     var3 = new ChatMessage("death.fell.killer", new Object[]{this.b.getScoreboardDisplayName()});
                  }
               } else {
                  Entity var7 = var1.a().j();
                  ItemStack var8 = var7 instanceof EntityLiving?((EntityLiving)var7).bA():null;
                  if(var8 != null && var8.hasDisplayName()) {
                     var3 = new ChatMessage("death.fell.assist.item", new Object[]{this.b.getScoreboardDisplayName(), var6, var8.B()});
                  } else {
                     var3 = new ChatMessage("death.fell.assist", new Object[]{this.b.getScoreboardDisplayName(), var6});
                  }
               }
            } else {
               var3 = new ChatMessage("death.fell.accident." + this.a(var1), new Object[]{this.b.getScoreboardDisplayName()});
            }
         } else {
            var3 = var2.a().b(this.b);
         }

         return (IChatBaseComponent)var3;
      }
   }

   public EntityLiving c() {
      EntityLiving var1 = null;
      EntityHuman var2 = null;
      float var3 = 0.0F;
      float var4 = 0.0F;
      Iterator var5 = this.a.iterator();

      while(true) {
         class_pa var6;
         do {
            do {
               if(!var5.hasNext()) {
                  if(var2 != null && var4 >= var3 / 3.0F) {
                     return var2;
                  }

                  return var1;
               }

               var6 = (class_pa)var5.next();
               if(var6.a().j() instanceof EntityHuman && (var2 == null || var6.c() > var4)) {
                  var4 = var6.c();
                  var2 = (EntityHuman)var6.a().j();
               }
            } while(!(var6.a().j() instanceof EntityLiving));
         } while(var1 != null && var6.c() <= var3);

         var3 = var6.c();
         var1 = (EntityLiving)var6.a().j();
      }
   }

   private class_pa i() {
      class_pa var1 = null;
      class_pa var2 = null;
      float var3 = 0.0F;
      float var4 = 0.0F;

      for(int var5 = 0; var5 < this.a.size(); ++var5) {
         class_pa var6 = (class_pa)this.a.get(var5);
         class_pa var7 = var5 > 0?(class_pa)this.a.get(var5 - 1):null;
         if((var6.a() == DamageSource.i || var6.a() == DamageSource.j) && var6.i() > 0.0F && (var1 == null || var6.i() > var4)) {
            if(var5 > 0) {
               var1 = var7;
            } else {
               var1 = var6;
            }

            var4 = var6.i();
         }

         if(var6.g() != null && (var2 == null || var6.c() > var3)) {
            var2 = var6;
            var3 = var6.c();
         }
      }

      if(var4 > 5.0F && var1 != null) {
         return var1;
      } else if(var3 > 5.0F && var2 != null) {
         return var2;
      } else {
         return null;
      }
   }

   private String a(class_pa var1) {
      return var1.g() == null?"generic":var1.g();
   }

   public int f() {
      return this.f?this.b.ticksLived - this.d:this.e - this.d;
   }

   private void j() {
      this.h = null;
   }

   public void g() {
      int var1 = this.f?300:100;
      if(this.g && (!this.b.isAlive() || this.b.ticksLived - this.c > var1)) {
         boolean var2 = this.f;
         this.g = false;
         this.f = false;
         this.e = this.b.ticksLived;
         if(var2) {
            this.b.j();
         }

         this.a.clear();
      }

   }

   public EntityLiving h() {
      return this.b;
   }
}
