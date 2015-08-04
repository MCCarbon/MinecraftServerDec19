package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_tq {
   private World a;
   private boolean b;
   private int c = -1;
   private int d;
   private int e;
   private class_tp f;
   private int g;
   private int h;
   private int i;

   public class_tq(World var1) {
      this.a = var1;
   }

   public void a() {
      if(this.a.x()) {
         this.c = 0;
      } else if(this.c != 2) {
         if(this.c == 0) {
            float var1 = this.a.c(0.0F);
            if((double)var1 < 0.5D || (double)var1 > 0.501D) {
               return;
            }

            this.c = this.a.random.nextInt(10) == 0?1:2;
            this.b = false;
            if(this.c == 2) {
               return;
            }
         }

         if(this.c != -1) {
            if(!this.b) {
               if(!this.b()) {
                  return;
               }

               this.b = true;
            }

            if(this.e > 0) {
               --this.e;
            } else {
               this.e = 2;
               if(this.d > 0) {
                  this.c();
                  --this.d;
               } else {
                  this.c = 2;
               }

            }
         }
      }
   }

   private boolean b() {
      List var1 = this.a.players;
      Iterator var2 = var1.iterator();

      Vec3D var11;
      do {
         do {
            do {
               do {
                  do {
                     EntityHuman var3;
                     do {
                        if(!var2.hasNext()) {
                           return false;
                        }

                        var3 = (EntityHuman)var2.next();
                     } while(var3.isSpectator());

                     this.f = this.a.af().a(new BlockPosition(var3), 1);
                  } while(this.f == null);
               } while(this.f.c() < 10);
            } while(this.f.d() < 20);
         } while(this.f.e() < 20);

         BlockPosition var4 = this.f.a();
         float var5 = (float)this.f.b();
         boolean var6 = false;

         for(int var7 = 0; var7 < 10; ++var7) {
            float var8 = this.a.random.nextFloat() * 3.1415927F * 2.0F;
            this.g = var4.getX() + (int)((double)(MathHelper.cos(var8) * var5) * 0.9D);
            this.h = var4.getY();
            this.i = var4.getZ() + (int)((double)(MathHelper.sin(var8) * var5) * 0.9D);
            var6 = false;
            Iterator var9 = this.a.af().b().iterator();

            while(var9.hasNext()) {
               class_tp var10 = (class_tp)var9.next();
               if(var10 != this.f && var10.a(new BlockPosition(this.g, this.h, this.i))) {
                  var6 = true;
                  break;
               }
            }

            if(!var6) {
               break;
            }
         }

         if(var6) {
            return false;
         }

         var11 = this.a(new BlockPosition(this.g, this.h, this.i));
      } while(var11 == null);

      this.e = 0;
      this.d = 20;
      return true;
   }

   private boolean c() {
      Vec3D var1 = this.a(new BlockPosition(this.g, this.h, this.i));
      if(var1 == null) {
         return false;
      } else {
         EntityZombie var2;
         try {
            var2 = new EntityZombie(this.a);
            var2.a((class_on)this.a.E(new BlockPosition(var2)), (class_qd)null);
            var2.n(false);
         } catch (Exception var4) {
            var4.printStackTrace();
            return false;
         }

         var2.b(var1.x, var1.y, var1.z, this.a.random.nextFloat() * 360.0F, 0.0F);
         this.a.addEntity((Entity)var2);
         BlockPosition var3 = this.f.a();
         var2.a(var3, this.f.b());
         return true;
      }
   }

   private Vec3D a(BlockPosition var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         BlockPosition var3 = var1.add(this.a.random.nextInt(16) - 8, this.a.random.nextInt(6) - 3, this.a.random.nextInt(16) - 8);
         if(this.f.a(var3) && class_aeu.a(EntityInsentient.class_a_in_class_qb.a, this.a, var3)) {
            return new Vec3D((double)var3.getX(), (double)var3.getY(), (double)var3.getZ());
         }
      }

      return null;
   }
}
