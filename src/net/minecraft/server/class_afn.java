package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_aph;
import net.minecraft.server.class_apw;
import net.minecraft.server.class_cj;

public class class_afn extends class_aez {
   protected class_aez aE;

   public class_afn(int var1, class_aez var2) {
      super(var1);
      this.aE = var2;
      this.a(var2.ai, true);
      this.ah = var2.ah + " M";
      this.ak = var2.ak;
      this.al = var2.al;
      this.am = var2.am;
      this.an = var2.an;
      this.ao = var2.ao;
      this.ap = var2.ap;
      this.aq = var2.aq;
      this.ar = var2.ar;
      this.ax = var2.ax;
      this.ay = var2.ay;
      this.au = Lists.newArrayList((Iterable)var2.au);
      this.at = Lists.newArrayList((Iterable)var2.at);
      this.aw = Lists.newArrayList((Iterable)var2.aw);
      this.av = Lists.newArrayList((Iterable)var2.av);
      this.ap = var2.ap;
      this.aq = var2.aq;
      this.an = var2.an + 0.1F;
      this.ao = var2.ao + 0.2F;
   }

   public void a(class_aen var1, Random var2, class_cj var3) {
      this.aE.as.a(var1, var2, this, var3);
   }

   public void a(class_aen var1, Random var2, class_aph var3, int var4, int var5, double var6) {
      this.aE.a(var1, var2, var3, var4, var5, var6);
   }

   public float g() {
      return this.aE.g();
   }

   public class_apw a(Random var1) {
      return this.aE.a(var1);
   }

   public Class l() {
      return this.aE.l();
   }

   public boolean a(class_aez var1) {
      return this.aE.a(var1);
   }

   public class_aez.class_b_in_class_aez m() {
      return this.aE.m();
   }
}
