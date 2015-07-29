package net.minecraft.server;

import net.minecraft.server.class_akp;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_cq;
import net.minecraft.server.CreativeTab;

public class class_ait extends class_akp {
   public class_ait() {
      super(Material.b, MaterialMapColor.t);
      this.setBlockData(this.blockStateList.getFirst().set(N, class_cq.class_a_in_class_cq.b));
      this.a(CreativeTab.b);
   }
}
