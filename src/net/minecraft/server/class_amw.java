package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.MathHelper;

public class class_amw extends class_amg {
   public byte a;
   public boolean f;

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.put("note", this.a);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.a = var1.getByte("note");
      this.a = (byte)MathHelper.clamp(this.a, 0, 24);
   }

   public void b() {
      this.a = (byte)((this.a + 1) % 25);
      this.p_();
   }

   public void a(World var1, BlockPosition var2) {
      if(var1.p(var2.shiftUp()).getBlock().getMaterial() == Material.AIR) {
         Material var3 = var1.p(var2.shiftDown()).getBlock().getMaterial();
         byte var4 = 0;
         if(var3 == Material.STONE) {
            var4 = 1;
         }

         if(var3 == Material.SAND) {
            var4 = 2;
         }

         if(var3 == Material.SHATTERABLE) {
            var4 = 3;
         }

         if(var3 == Material.WOOD) {
            var4 = 4;
         }

         var1.c(var2, Blocks.NOTEBLOCK, var4, this.a);
      }
   }
}
