package net.minecraft.server;

import net.minecraft.server.class_atk;
import net.minecraft.server.class_tt;
import net.minecraft.server.class_tw;
import net.minecraft.server.class_uk;
import net.minecraft.server.class_wd;

public enum class_qc {
    a(class_wd.class, 70, class_atk.a, false, false),
    b(class_tw.class, 10, class_atk.a, true, true),
    c(class_tt.class, 15, class_atk.a, true, false),
    d(class_uk.class, 5, class_atk.h, true, false);

   private final Class e;
   private final int f;
   private final class_atk g;
   private final boolean h;
   private final boolean i;

   private class_qc(Class var3, int var4, class_atk var5, boolean var6, boolean var7) {
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
