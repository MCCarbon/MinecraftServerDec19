package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pp;
import net.minecraft.server.Entity;
import net.minecraft.server.class_qb;
import net.minecraft.server.EntityHuman;

public abstract class class_uk extends class_qb implements class_pp {
   public class_uk(World var1) {
      super(var1);
   }

   public boolean aZ() {
      return true;
   }

   public boolean cf() {
      return true;
   }

   public boolean cg() {
      return this.o.a((AxisAlignedBB)this.aT(), (Entity)this);
   }

   public int y() {
      return 120;
   }

   protected boolean E() {
      return true;
   }

   protected int b(EntityHuman var1) {
      return 1 + this.o.random.nextInt(3);
   }

   public void K() {
      int var1 = this.aB();
      super.K();
      if(this.ai() && !this.V()) {
         --var1;
         this.i(var1);
         if(this.aB() == -20) {
            this.i(0);
            this.a(class_pc.f, 2.0F);
         }
      } else {
         this.i(300);
      }

   }

   public boolean aN() {
      return false;
   }
}
