package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;
import net.minecraft.server.CreativeTab;

public class class_akz extends Block {
   public class_akz() {
      super(Material.p, MaterialMapColor.B);
      this.a(CreativeTab.b);
   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      float var4 = 0.125F;
      return new class_awf((double)var2.n(), (double)var2.o(), (double)var2.p(), (double)(var2.n() + 1), (double)((float)(var2.o() + 1) - var4), (double)(var2.p() + 1));
   }

   public void a(World var1, class_cj var2, IBlockData var3, class_pr var4) {
      var4.v *= 0.4D;
      var4.x *= 0.4D;
   }
}
