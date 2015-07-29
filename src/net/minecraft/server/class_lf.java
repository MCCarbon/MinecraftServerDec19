package net.minecraft.server;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.server.class_aeh;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aeo;
import net.minecraft.server.class_aoh;
import net.minecraft.server.class_aoj;
import net.minecraft.server.class_aok;
import net.minecraft.server.class_aop;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_e;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_ns;
import net.minecraft.server.class_nw;
import net.minecraft.server.class_qc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_lf implements class_aoh {
   private static final Logger b = LogManager.getLogger();
   private Set c = Collections.newSetFromMap(new ConcurrentHashMap());
   private class_aok d;
   private class_aoh e;
   private class_aop f;
   public boolean a = true;
   private class_ns g = new class_ns();
   private List h = Lists.newArrayList();
   private class_lg i;

   public class_lf(class_lg var1, class_aop var2, class_aoh var3) {
      this.d = new class_aoj(var1, 0, 0);
      this.i = var1;
      this.f = var2;
      this.e = var3;
   }

   public boolean a(int var1, int var2) {
      return this.g.b(class_aeh.a(var1, var2));
   }

   public List a() {
      return this.h;
   }

   public void b(int var1, int var2) {
      if(this.i.t.c(var1, var2)) {
         this.c.add(Long.valueOf(class_aeh.a(var1, var2)));
      }

   }

   public void b() {
      Iterator var1 = this.h.iterator();

      while(var1.hasNext()) {
         class_aok var2 = (class_aok)var1.next();
         this.b(var2.a, var2.b);
      }

   }

   public class_aok c(int var1, int var2) {
      long var3 = class_aeh.a(var1, var2);
      this.c.remove(Long.valueOf(var3));
      class_aok var5 = (class_aok)this.g.a(var3);
      if(var5 == null) {
         var5 = this.e(var1, var2);
         if(var5 == null) {
            if(this.e == null) {
               var5 = this.d;
            } else {
               try {
                  var5 = this.e.d(var1, var2);
               } catch (Throwable var9) {
                  class_b var7 = class_b.a(var9, "Exception generating new chunk");
                  class_c var8 = var7.a("Chunk to be generated");
                  var8.a((String)"Location", (Object)String.format("%d,%d", new Object[]{Integer.valueOf(var1), Integer.valueOf(var2)}));
                  var8.a((String)"Position hash", (Object)Long.valueOf(var3));
                  var8.a((String)"Generator", (Object)this.e.f());
                  throw new class_e(var7);
               }
            }
         }

         this.g.a(var3, var5);
         this.h.add(var5);
         var5.c();
         var5.a(this, this, var1, var2);
      }

      return var5;
   }

   public class_aok d(int var1, int var2) {
      class_aok var3 = (class_aok)this.g.a(class_aeh.a(var1, var2));
      return var3 == null?(!this.i.ae() && !this.a?this.d:this.c(var1, var2)):var3;
   }

   private class_aok e(int var1, int var2) {
      if(this.f == null) {
         return null;
      } else {
         try {
            class_aok var3 = this.f.a(this.i, var1, var2);
            if(var3 != null) {
               var3.b(this.i.L());
               if(this.e != null) {
                  this.e.a(var3, var1, var2);
               }
            }

            return var3;
         } catch (Exception var4) {
            b.error((String)"Couldn\'t load chunk", (Throwable)var4);
            return null;
         }
      }
   }

   private void a(class_aok var1) {
      if(this.f != null) {
         try {
            this.f.b(this.i, var1);
         } catch (Exception var3) {
            b.error((String)"Couldn\'t save entities", (Throwable)var3);
         }

      }
   }

   private void b(class_aok var1) {
      if(this.f != null) {
         try {
            var1.b(this.i.L());
            this.f.a(this.i, var1);
         } catch (IOException var3) {
            b.error((String)"Couldn\'t save chunk", (Throwable)var3);
         } catch (class_aeo var4) {
            b.error((String)"Couldn\'t save chunk; already in use by another instance of Minecraft?", (Throwable)var4);
         }

      }
   }

   public void a(class_aoh var1, int var2, int var3) {
      class_aok var4 = this.d(var2, var3);
      if(!var4.t()) {
         var4.n();
         if(this.e != null) {
            this.e.a(var1, var2, var3);
            var4.e();
         }
      }

   }

   public boolean a(class_aoh var1, class_aok var2, int var3, int var4) {
      if(this.e != null && this.e.a(var1, var2, var3, var4)) {
         class_aok var5 = this.d(var3, var4);
         var5.e();
         return true;
      } else {
         return false;
      }
   }

   public boolean a(boolean var1, class_nw var2) {
      int var3 = 0;
      ArrayList var4 = Lists.newArrayList((Iterable)this.h);

      for(int var5 = 0; var5 < var4.size(); ++var5) {
         class_aok var6 = (class_aok)var4.get(var5);
         if(var1) {
            this.a(var6);
         }

         if(var6.a(var1)) {
            this.b(var6);
            var6.f(false);
            ++var3;
            if(var3 == 24 && !var1) {
               return false;
            }
         }
      }

      return true;
   }

   public void c() {
      if(this.f != null) {
         this.f.b();
      }

   }

   public boolean d() {
      if(!this.i.c) {
         for(int var1 = 0; var1 < 100; ++var1) {
            if(!this.c.isEmpty()) {
               Long var2 = (Long)this.c.iterator().next();
               class_aok var3 = (class_aok)this.g.a(var2.longValue());
               if(var3 != null) {
                  var3.d();
                  this.b(var3);
                  this.a(var3);
                  this.g.d(var2.longValue());
                  this.h.remove(var3);
               }

               this.c.remove(var2);
            }
         }

         if(this.f != null) {
            this.f.a();
         }
      }

      return this.e.d();
   }

   public boolean e() {
      return !this.i.c;
   }

   public String f() {
      return "ServerChunkCache: " + this.g.a() + " Drop: " + this.c.size();
   }

   public List a(class_qc var1, class_cj var2) {
      return this.e.a(var1, var2);
   }

   public class_cj a(class_aen var1, String var2, class_cj var3) {
      return this.e.a(var1, var2, var3);
   }

   public int g() {
      return this.g.a();
   }

   public void a(class_aok var1, int var2, int var3) {
   }

   public class_aok a(class_cj var1) {
      return this.d(var1.n() >> 4, var1.p() >> 4);
   }
}
