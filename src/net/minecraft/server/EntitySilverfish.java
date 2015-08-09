package net.minecraft.server;

import java.util.Random;

public class EntitySilverfish extends EntityMonster {
   private EntitySilverfish.class_b_in_class_wm a;

   public EntitySilverfish(World var1) {
      super(var1);
      this.setSize(0.4F, 0.3F);
      this.i.a(1, new class_rj(this));
      this.i.a(3, this.a = new EntitySilverfish.class_b_in_class_wm(this));
      this.i.a(4, new class_ru(this, EntityHuman.class, 1.0D, false));
      this.i.a(5, new EntitySilverfish.class_a_in_class_wm(this));
      this.bn.a(1, new class_sw(this, true, new Class[0]));
      this.bn.a(2, new class_sz(this, EntityHuman.class, true));
   }

   public double am() {
      return 0.2D;
   }

   public float getHeadHeight() {
      return 0.1F;
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(8.0D);
      this.a(class_wl.d).a(0.25D);
      this.a(class_wl.e).a(1.0D);
   }

   protected boolean s_() {
      return false;
   }

   protected String C() {
      return "mob.silverfish.say";
   }

   protected String bp() {
      return "mob.silverfish.hit";
   }

   protected String bq() {
      return "mob.silverfish.kill";
   }

   public boolean damageEntity(DamageSource var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else {
         if(var1 instanceof class_pd || var1 == DamageSource.l) {
            this.a.f();
         }

         return super.damageEntity(var1, var2);
      }
   }

   protected void a(BlockPosition var1, Block var2) {
      this.makeSound("mob.silverfish.step", 0.15F, 1.0F);
   }

   protected Item D() {
      return null;
   }

   public void t_() {
      this.aL = this.yaw;
      super.t_();
   }

   public float a(BlockPosition var1) {
      return this.world.getType(var1.down()).getBlock() == Blocks.STONE?10.0F:super.a(var1);
   }

   protected boolean n_() {
      return true;
   }

   public boolean cf() {
      if(super.cf()) {
         EntityHuman var1 = this.world.a(this, 5.0D);
         return var1 == null;
      } else {
         return false;
      }
   }

   public class_qf bz() {
      return class_qf.c;
   }

   static class class_a_in_class_wm extends class_si {
      private final EntitySilverfish a;
      private EnumDirection b;
      private boolean c;

      public class_a_in_class_wm(EntitySilverfish var1) {
         super(var1, 1.0D, 10);
         this.a = var1;
         this.a(1);
      }

      public boolean a() {
         if(this.a.w() != null) {
            return false;
         } else if(!this.a.u().m()) {
            return false;
         } else {
            Random var1 = this.a.getRandom();
            if(var1.nextInt(10) == 0) {
               this.b = EnumDirection.getRandom(var1);
               BlockPosition var2 = (new BlockPosition(this.a.locX, this.a.locY + 0.5D, this.a.locZ)).shift(this.b);
               IBlockData var3 = this.a.world.getType(var2);
               if(BlockMonsterEggs.d(var3)) {
                  this.c = true;
                  return true;
               }
            }

            this.c = false;
            return super.a();
         }
      }

      public boolean b() {
         return this.c?false:super.b();
      }

      public void c() {
         if(!this.c) {
            super.c();
         } else {
            World var1 = this.a.world;
            BlockPosition var2 = (new BlockPosition(this.a.locX, this.a.locY + 0.5D, this.a.locZ)).shift(this.b);
            IBlockData var3 = var1.getType(var2);
            if(BlockMonsterEggs.d(var3)) {
               var1.setTypeAndData((BlockPosition)var2, (IBlockData)Blocks.MONSTER_EGG.getBlockData().set(BlockMonsterEggs.a, BlockMonsterEggs.EnumMonsterEggVariant.a(var3)), 3);
               this.a.A();
               this.a.die();
            }

         }
      }
   }

   static class class_b_in_class_wm extends class_rm {
      private EntitySilverfish a;
      private int b;

      public class_b_in_class_wm(EntitySilverfish var1) {
         this.a = var1;
      }

      public void f() {
         if(this.b == 0) {
            this.b = 20;
         }

      }

      public boolean a() {
         return this.b > 0;
      }

      public void e() {
         --this.b;
         if(this.b <= 0) {
            World var1 = this.a.world;
            Random var2 = this.a.getRandom();
            BlockPosition var3 = new BlockPosition(this.a);

            for(int var4 = 0; var4 <= 5 && var4 >= -5; var4 = var4 <= 0?1 - var4:0 - var4) {
               for(int var5 = 0; var5 <= 10 && var5 >= -10; var5 = var5 <= 0?1 - var5:0 - var5) {
                  for(int var6 = 0; var6 <= 10 && var6 >= -10; var6 = var6 <= 0?1 - var6:0 - var6) {
                     BlockPosition var7 = var3.add(var5, var4, var6);
                     IBlockData var8 = var1.getType(var7);
                     if(var8.getBlock() == Blocks.MONSTER_EGG) {
                        if(var1.R().getBooleanValue("mobGriefing")) {
                           var1.setAir(var7, true);
                        } else {
                           var1.setTypeAndData((BlockPosition)var7, (IBlockData)((BlockMonsterEggs.EnumMonsterEggVariant)var8.get(BlockMonsterEggs.a)).d(), 3);
                        }

                        if(var2.nextBoolean()) {
                           return;
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
