package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.server.class_asb;
import net.minecraft.server.class_ask;
import net.minecraft.server.class_aso;
import net.minecraft.server.MathHelper;

public class class_arz extends class_ask {
   private double d = 0.004D;

   public class_arz() {
   }

   public String a() {
      return "Mineshaft";
   }

   public class_arz(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).equals("chance")) {
            this.d = MathHelper.parseDoubleWithDef((String)var3.getValue(), this.d);
         }
      }

   }

   protected boolean a(int var1, int var2) {
      return this.b.nextDouble() < this.d && this.b.nextInt(80) < Math.max(Math.abs(var1), Math.abs(var2));
   }

   protected class_aso b(int var1, int var2) {
      return new class_asb(this.c, this.b, var1, var2);
   }
}
