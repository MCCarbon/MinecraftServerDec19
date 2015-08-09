package net.minecraft.server;

import net.minecraft.server.Material;
import net.minecraft.server.class_tt;
import net.minecraft.server.EntityAnimal;
import net.minecraft.server.class_uk;
import net.minecraft.server.class_wd;

public enum EnumCreatureType {
    a(class_wd.class, 70, Material.AIR, false, false),
    b(EntityAnimal.class, 10, Material.AIR, true, true),
    c(class_tt.class, 15, Material.AIR, true, false),
    d(class_uk.class, 5, Material.WATER, true, false);

   private final Class e;
   private final int f;
   private final Material g;
   private final boolean h;
   private final boolean i;

   private EnumCreatureType(Class var3, int var4, Material var5, boolean var6, boolean var7) {
      this.e = var3;
      this.f = var4;
      this.g = var5;
      this.h = var6;
      this.i = var7;
   }

   public Class a() {
      return this.e;
   }

   public int b() {
      return this.f;
   }

   public boolean d() {
      return this.h;
   }

   public boolean e() {
      return this.i;
   }

}
