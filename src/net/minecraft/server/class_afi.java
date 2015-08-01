package net.minecraft.server;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_we;
import net.minecraft.server.class_wh;
import net.minecraft.server.class_wj;

public class class_afi extends BiomeBase {
   public class_afi(int var1) {
      super(var1);
      this.at.clear();
      this.au.clear();
      this.av.clear();
      this.aw.clear();
      this.at.add(new BiomeBase.class_c_in_class_aez(class_we.class, 50, 4, 4));
      this.at.add(new BiomeBase.class_c_in_class_aez(class_wj.class, 100, 4, 4));
      this.at.add(new BiomeBase.class_c_in_class_aez(class_wh.class, 1, 4, 4));
   }
}
