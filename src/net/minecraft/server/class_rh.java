package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class class_rh extends class_rm {
   private static final Predicate b;
   private EntityInsentient c;
   private World d;
   int a;

   public class_rh(EntityInsentient var1) {
      this.c = var1;
      this.d = var1.world;
      this.a(7);
   }

   public boolean a() {
      if(this.c.getRandom().nextInt(this.c.isBaby()?50:1000) != 0) {
         return false;
      } else {
         BlockPosition var1 = new BlockPosition(this.c.locX, this.c.locY, this.c.locZ);
         return b.apply(this.d.getType(var1))?true:this.d.getType(var1.down()).getBlock() == Blocks.GRASS;
      }
   }

   public void c() {
      this.a = 40;
      this.d.a((Entity)this.c, (byte)10);
      this.c.u().n();
   }

   public void d() {
      this.a = 0;
   }

   public boolean b() {
      return this.a > 0;
   }

   public int f() {
      return this.a;
   }

   public void e() {
      this.a = Math.max(0, this.a - 1);
      if(this.a == 4) {
         BlockPosition var1 = new BlockPosition(this.c.locX, this.c.locY, this.c.locZ);
         if(b.apply(this.d.getType(var1))) {
            if(this.d.R().getBooleanValue("mobGriefing")) {
               this.d.setAir(var1, false);
            }

            this.c.x();
         } else {
            BlockPosition var2 = var1.down();
            if(this.d.getType(var2).getBlock() == Blocks.GRASS) {
               if(this.d.R().getBooleanValue("mobGriefing")) {
                  this.d.b(2001, var2, Block.getId((Block)Blocks.GRASS));
                  this.d.setTypeAndData((BlockPosition)var2, (IBlockData)Blocks.DIRT.getBlockData(), 2);
               }

               this.c.x();
            }
         }

      }
   }

   static {
      b = class_ant.a((Block)Blocks.TALLGRASS).a(BlockLongGrass.TYPE, Predicates.equalTo(BlockLongGrass.EnumTallGrassType.GRASS));
   }
}
