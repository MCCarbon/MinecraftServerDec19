package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_agu;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_vq;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yf;

public class class_vo extends class_vq {
   public class_vo(class_aen var1) {
      super(var1);
   }

   public class_vo(class_aen var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public void a(class_pc var1) {
      super.a(var1);
      if(this.o.R().b("doEntityDrops")) {
         this.a(class_aar.a((class_agj)class_agk.ae), 1, 0.0F);
      }

   }

   public int o_() {
      return 27;
   }

   public class_vn.class_a_in_class_vn s() {
      return class_vn.class_a_in_class_vn.b;
   }

   public class_anl u() {
      return class_agk.ae.S().a(class_agu.a, class_cq.c);
   }

   public int w() {
      return 8;
   }

   public String k() {
      return "minecraft:chest";
   }

   public class_xz a(class_wz var1, class_xa var2) {
      return new class_yf(var1, this, var2);
   }
}
