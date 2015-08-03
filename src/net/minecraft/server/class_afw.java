package net.minecraft.server;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_afx;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_wb;

public class class_afw extends BiomeBase {
   public class_afw(int var1) {
      super(var1);
      this.at.clear();
      this.au.clear();
      this.av.clear();
      this.aw.clear();
      this.at.add(new BiomeBase.class_c_in_class_aez(class_wb.class, 10, 4, 4));
      this.ak = Blocks.DIRT.getBlockData();
      this.al = Blocks.DIRT.getBlockData();
      this.as = new class_afx();
   }
}
