package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.server.class_ms;
import net.minecraft.server.class_my;
import net.minecraft.server.class_na;
import net.minecraft.server.class_nb;
import net.minecraft.server.class_xa;

public class class_nd {
   protected final Map a = Maps.newConcurrentMap();

   public boolean a(class_ms var1) {
      return this.a((class_my)var1) > 0;
   }

   public boolean b(class_ms var1) {
      return var1.c == null || this.a(var1.c);
   }

   public void b(class_xa var1, class_my var2, int var3) {
      if(!var2.d() || this.b((class_ms)var2)) {
         this.a(var1, var2, this.a(var2) + var3);
      }
   }

   public void a(class_xa var1, class_my var2, int var3) {
      class_na var4 = (class_na)this.a.get(var2);
      if(var4 == null) {
         var4 = new class_na();
         this.a.put(var2, var4);
      }

      var4.a(var3);
   }

   public int a(class_my var1) {
      class_na var2 = (class_na)this.a.get(var1);
      return var2 == null?0:var2.a();
   }

   public class_nb b(class_my var1) {
      class_na var2 = (class_na)this.a.get(var1);
      return var2 != null?var2.b():null;
   }

   public class_nb a(class_my var1, class_nb var2) {
      class_na var3 = (class_na)this.a.get(var1);
      if(var3 == null) {
         var3 = new class_na();
         this.a.put(var1, var3);
      }

      var3.a(var2);
      return var2;
   }
}
