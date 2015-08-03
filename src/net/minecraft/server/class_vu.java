package net.minecraft.server;

import net.minecraft.server.class_aee;
import net.minecraft.server.World;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.Entity;
import net.minecraft.server.class_vn;

public class class_vu extends class_vn {
   private final class_aee a = new class_aee() {
      public void a(int var1) {
         class_vu.this.o.a((Entity)class_vu.this, (byte)((byte)var1));
      }

      public World a() {
         return class_vu.this.o;
      }

      public BlockPosition b() {
         return new BlockPosition(class_vu.this);
      }
   };

   public class_vu(World var1) {
      super(var1);
   }

   public class_vu(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public class_vn.class_a_in_class_vn s() {
      return class_vn.class_a_in_class_vn.e;
   }

   public IBlockData u() {
      return BlockStainedGlassPane.MOB_SPAWNER.getBlockData();
   }

   protected void a(NBTTagCompound var1) {
      super.a(var1);
      this.a.a(var1);
   }

   protected void b(NBTTagCompound var1) {
      super.b(var1);
      this.a.b(var1);
   }

   public void t_() {
      super.t_();
      this.a.c();
   }
}
