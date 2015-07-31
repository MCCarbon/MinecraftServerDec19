package net.minecraft.server;

import java.io.File;
import net.minecraft.server.class_aop;
import net.minecraft.server.class_aou;
import net.minecraft.server.class_aov;
import net.minecraft.server.class_aoy;
import net.minecraft.server.class_apa;
import net.minecraft.server.class_apd;
import net.minecraft.server.class_avl;
import net.minecraft.server.class_avn;
import net.minecraft.server.class_awb;
import net.minecraft.server.NBTTagCompound;

public class class_avi extends class_avl {
   public class_avi(File var1, String var2, boolean var3) {
      super(var1, var2, var3);
   }

   public class_aop a(class_aoy var1) {
      File var2 = this.b();
      File var3;
      if(var1 instanceof class_apa) {
         var3 = new File(var2, "DIM-1");
         var3.mkdirs();
         return new class_aov(var3);
      } else if(var1 instanceof class_apd) {
         var3 = new File(var2, "DIM1");
         var3.mkdirs();
         return new class_aov(var3);
      } else {
         return new class_aov(var2);
      }
   }

   public void a(class_avn var1, NBTTagCompound var2) {
      var1.e(19133);
      super.a(var1, var2);
   }

   public void a() {
      try {
         class_awb.a().b();
      } catch (InterruptedException var2) {
         var2.printStackTrace();
      }

      class_aou.a();
   }
}
