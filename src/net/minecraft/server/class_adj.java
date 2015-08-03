package net.minecraft.server;

import net.minecraft.server.class_aal;
import net.minecraft.server.Item;
import net.minecraft.server.class_abw;
import net.minecraft.server.class_pw;
import net.minecraft.server.ItemArmor;
import net.minecraft.server.class_zl;
import net.minecraft.server.class_zv;

public enum class_adj {
   a,
   b,
   c,
   d,
   e,
   f,
   g,
   h,
   i,
   j,
   k;

   public boolean a(Item var1) {
      if(this == a) {
         return true;
      } else if(this == j && var1.m()) {
         return true;
      } else if(var1 instanceof ItemArmor) {
         if(this == b) {
            return true;
         } else {
            ItemArmor var2 = (ItemArmor)var1;
            return var2.b == class_pw.f?this == f:(var2.b == class_pw.d?this == d:(var2.b == class_pw.e?this == e:(var2.b == class_pw.c?this == c:false)));
         }
      } else {
         return var1 instanceof class_abw?this == g:(var1 instanceof class_zv?this == h:(var1 instanceof class_zl?this == k:(var1 instanceof class_aal?this == i:false)));
      }
   }
}
