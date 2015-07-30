package net.minecraft.server;

import net.minecraft.server.class_aez;
import net.minecraft.server.class_afg;
import net.minecraft.server.class_aoh;
import net.minecraft.server.class_aoy;
import net.minecraft.server.class_aoz;
import net.minecraft.server.class_apc;
import net.minecraft.server.class_apq;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_lg;

public class class_apd extends class_aoy {
   private class_apc g = null;

   public void b() {
      this.c = new class_afg(class_aez.y, 0.0F);
      this.e = true;
      class_dn var1 = this.b.Q().a(class_aoz.c);
      this.g = this.b instanceof class_lg?new class_apc((class_lg)this.b, var1.n("DragonFight")):null;
   }

   public class_aoh c() {
      return new class_apq(this.b, this.b.K());
   }

   public float a(long var1, float var3) {
      return 0.0F;
   }

   public boolean e() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean a(int var1, int var2) {
      return this.b.c(new BlockPosition(var1, 0, var2)).getMaterial().isSolid();
   }

   public BlockPosition h() {
      return new BlockPosition(100, 50, 0);
   }

   public int i() {
      return 50;
   }

   public class_aoz p() {
      return class_aoz.c;
   }

   public void q() {
      class_dn var1 = new class_dn();
      if(this.g != null) {
         var1.a((String)"DragonFight", (class_eb)this.g.a());
      }

      this.b.Q().a(class_aoz.c, var1);
   }

   public void r() {
      if(this.g != null) {
         this.g.b();
      }

   }

   public class_apc s() {
      return this.g;
   }
}
