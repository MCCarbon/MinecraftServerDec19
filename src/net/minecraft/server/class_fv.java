package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_fv implements class_ff {
   private BlockPosition a;
   private IBlockData b;

   public class_fv() {
   }

   public class_fv(World var1, BlockPosition var2) {
      this.a = var2;
      this.b = var1.p(var2);
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.c();
      this.b = (IBlockData)Block.BLOCKDATA_REGISTRY.get(var1.e());
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.b(Block.BLOCKDATA_REGISTRY.getId(this.b));
   }

   public void a(class_fj var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_fj)var1);
   }
}
