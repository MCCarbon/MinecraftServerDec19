package net.minecraft.server;

import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.class_my;
import net.minecraft.server.class_nc;

public class class_fr implements class_ff {
   private Map a;

   public class_fr() {
   }

   public class_fr(Map var1) {
      this.a = var1;
   }

   public void a(class_fj var1) {
      var1.a(this);
   }

   public void a(class_em var1) throws IOException {
      int var2 = var1.e();
      this.a = Maps.newHashMap();

      for(int var3 = 0; var3 < var2; ++var3) {
         class_my var4 = class_nc.a(var1.c(32767));
         int var5 = var1.e();
         if(var4 != null) {
            this.a.put(var4, Integer.valueOf(var5));
         }
      }

   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a.size());
      Iterator var2 = this.a.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.a(((class_my)var3.getKey()).e);
         var1.b(((Integer)var3.getValue()).intValue());
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_fj)var1);
   }
}
