package net.minecraft.server;

import net.minecraft.server.class_aee;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketPlayOutTileEntityData;
import net.minecraft.server.ITickAble;

public class class_amv extends class_amg implements ITickAble {
   private final class_aee a = new class_aee() {
      public void a(int var1) {
         class_amv.this.b.c(class_amv.this.c, Blocks.MOB_SPAWNER, var1, 0);
      }

      public World a() {
         return class_amv.this.b;
      }

      public BlockPosition b() {
         return class_amv.this.c;
      }

      public void a(class_aee.class_a_in_class_aee var1) {
         super.a(var1);
         if(this.a() != null) {
            this.a().h(class_amv.this.c);
         }

      }
   };

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.a.a(var1);
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      this.a.b(var1);
   }

   public void tick() {
      this.a.c();
   }

   public Packet z_() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.b(var1);
      var1.remove("SpawnPotentials");
      return new PacketPlayOutTileEntityData(this.c, 1, var1);
   }

   public boolean c(int var1, int var2) {
      return this.a.b(var1)?true:super.c(var1, var2);
   }

   public boolean F() {
      return true;
   }

   public class_aee b() {
      return this.a;
   }
}
