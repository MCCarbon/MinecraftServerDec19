package net.minecraft.server;

import net.minecraft.server.class_akp;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.CreativeTab;

public class class_ait extends class_akp {
   public class_ait() {
      super(Material.GRASS, MaterialMapColor.COLOR19);
      this.setBlockData(this.blockStateList.getFirst().set(N, EnumDirection.EnumAxis.Y));
      this.a(CreativeTab.b);
   }
}
