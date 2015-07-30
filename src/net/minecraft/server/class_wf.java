package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_wi;
import net.minecraft.server.class_wl;

public class class_wf extends class_wi {
   public class_wf(World var1) {
      super(var1);
      this.a(this.J * 6.0F, this.K * 6.0F);
   }

   public float aU() {
      return 10.440001F;
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(100.0D);
      this.a(class_wl.d).a(0.5D);
      this.a(class_wl.e).a(50.0D);
   }

   public float a(BlockPosition var1) {
      return this.o.o(var1) - 0.5F;
   }
}
