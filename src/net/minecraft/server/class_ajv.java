package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.Material;
import net.minecraft.server.CreativeTab;

public class class_ajv extends Block {
   public class_ajv() {
      super(Material.SNOW_LAYER);
      this.frictionFactor = 0.98F;
      this.a(CreativeTab.b);
   }

   public int a(Random var1) {
      return 0;
   }
}
