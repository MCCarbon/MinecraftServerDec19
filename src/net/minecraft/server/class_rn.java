package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MethodProfiler;
import net.minecraft.server.class_rm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_rn {
   private static final Logger a = LogManager.getLogger();
   private List b = Lists.newArrayList();
   private List c = Lists.newArrayList();
   private final MethodProfiler d;
   private int e;
   private int f = 3;

   public class_rn(MethodProfiler var1) {
      this.d = var1;
   }

   public void a(int var1, class_rm var2) {
      this.b.add(new class_rn.class_a_in_class_rn(var1, var2));
   }

   public void a(class_rm var1) {
      Iterator var2 = this.b.iterator();

      while(var2.hasNext()) {
         class_rn.class_a_in_class_rn var3 = (class_rn.class_a_in_class_rn)var2.next();
         class_rm var4 = var3.a;
         if(var4 == var1) {
            if(this.c.contains(var3)) {
               var4.d();
               this.c.remove(var3);
            }

            var2.remove();
         }
      }

   }

   public void a() {
      this.d.a("goalSetup");
      Iterator var1;
      class_rn.class_a_in_class_rn var2;
      if(this.e++ % this.f == 0) {
         var1 = this.b.iterator();

         label50:
         while(true) {
            while(true) {
               if(!var1.hasNext()) {
                  break label50;
               }

               var2 = (class_rn.class_a_in_class_rn)var1.next();
               boolean var3 = this.c.contains(var2);
               if(!var3) {
                  break;
               }

               if(!this.b(var2) || !this.a(var2)) {
                  var2.a.d();
                  this.c.remove(var2);
                  break;
               }
            }

            if(this.b(var2) && var2.a.a()) {
               var2.a.c();
               this.c.add(var2);
            }
         }
      } else {
         var1 = this.c.iterator();

         while(var1.hasNext()) {
            var2 = (class_rn.class_a_in_class_rn)var1.next();
            if(!this.a(var2)) {
               var2.a.d();
               var1.remove();
            }
         }
      }

      this.d.b();
      this.d.a("goalTick");
      var1 = this.c.iterator();

      while(var1.hasNext()) {
         var2 = (class_rn.class_a_in_class_rn)var1.next();
         var2.a.e();
      }

      this.d.b();
   }

   private boolean a(class_rn.class_a_in_class_rn var1) {
      boolean var2 = var1.a.b();
      return var2;
   }

   private boolean b(class_rn.class_a_in_class_rn var1) {
      Iterator var2 = this.b.iterator();

      while(var2.hasNext()) {
         class_rn.class_a_in_class_rn var3 = (class_rn.class_a_in_class_rn)var2.next();
         if(var3 != var1) {
            if(var1.b >= var3.b) {
               if(!this.a(var1, var3) && this.c.contains(var3)) {
                  return false;
               }
            } else if(!var3.a.i() && this.c.contains(var3)) {
               return false;
            }
         }
      }

      return true;
   }

   private boolean a(class_rn.class_a_in_class_rn var1, class_rn.class_a_in_class_rn var2) {
      return (var1.a.j() & var2.a.j()) == 0;
   }

   class class_a_in_class_rn {
      public class_rm a;
      public int b;

      public class_a_in_class_rn(int var2, class_rm var3) {
         this.b = var2;
         this.a = var3;
      }
   }
}
