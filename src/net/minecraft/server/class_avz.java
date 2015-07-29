package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.server.class_avd;
import net.minecraft.server.class_avo;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dx;
import net.minecraft.server.class_dz;
import net.minecraft.server.class_eb;

public class class_avz {
   private class_avo b;
   protected Map a = Maps.newHashMap();
   private List c = Lists.newArrayList();
   private Map d = Maps.newHashMap();

   public class_avz(class_avo var1) {
      this.b = var1;
      this.b();
   }

   public class_avd a(Class var1, String var2) {
      class_avd var3 = (class_avd)this.a.get(var2);
      if(var3 != null) {
         return var3;
      } else {
         if(this.b != null) {
            try {
               File var4 = this.b.a(var2);
               if(var4 != null && var4.exists()) {
                  try {
                     var3 = (class_avd)var1.getConstructor(new Class[]{String.class}).newInstance(new Object[]{var2});
                  } catch (Exception var7) {
                     throw new RuntimeException("Failed to instantiate " + var1.toString(), var7);
                  }

                  FileInputStream var5 = new FileInputStream(var4);
                  class_dn var6 = class_dx.a((InputStream)var5);
                  var5.close();
                  var3.a(var6.n("data"));
               }
            } catch (Exception var8) {
               var8.printStackTrace();
            }
         }

         if(var3 != null) {
            this.a.put(var2, var3);
            this.c.add(var3);
         }

         return var3;
      }
   }

   public void a(String var1, class_avd var2) {
      if(this.a.containsKey(var1)) {
         this.c.remove(this.a.remove(var1));
      }

      this.a.put(var1, var2);
      this.c.add(var2);
   }

   public void a() {
      for(int var1 = 0; var1 < this.c.size(); ++var1) {
         class_avd var2 = (class_avd)this.c.get(var1);
         if(var2.d()) {
            this.a(var2);
            var2.a(false);
         }
      }

   }

   private void a(class_avd var1) {
      if(this.b != null) {
         try {
            File var2 = this.b.a(var1.a);
            if(var2 != null) {
               class_dn var3 = new class_dn();
               var1.b(var3);
               class_dn var4 = new class_dn();
               var4.a((String)"data", (class_eb)var3);
               FileOutputStream var5 = new FileOutputStream(var2);
               class_dx.a((class_dn)var4, (OutputStream)var5);
               var5.close();
            }
         } catch (Exception var6) {
            var6.printStackTrace();
         }

      }
   }

   private void b() {
      try {
         this.d.clear();
         if(this.b == null) {
            return;
         }

         File var1 = this.b.a("idcounts");
         if(var1 != null && var1.exists()) {
            DataInputStream var2 = new DataInputStream(new FileInputStream(var1));
            class_dn var3 = class_dx.a(var2);
            var2.close();
            Iterator var4 = var3.c().iterator();

            while(var4.hasNext()) {
               String var5 = (String)var4.next();
               class_eb var6 = var3.b(var5);
               if(var6 instanceof class_dz) {
                  class_dz var7 = (class_dz)var6;
                  short var9 = var7.e();
                  this.d.put(var5, Short.valueOf(var9));
               }
            }
         }
      } catch (Exception var10) {
         var10.printStackTrace();
      }

   }

   public int a(String var1) {
      Short var2 = (Short)this.d.get(var1);
      if(var2 == null) {
         var2 = Short.valueOf((short)0);
      } else {
         var2 = Short.valueOf((short)(var2.shortValue() + 1));
      }

      this.d.put(var1, var2);
      if(this.b == null) {
         return var2.shortValue();
      } else {
         try {
            File var3 = this.b.a("idcounts");
            if(var3 != null) {
               class_dn var4 = new class_dn();
               Iterator var5 = this.d.keySet().iterator();

               while(var5.hasNext()) {
                  String var6 = (String)var5.next();
                  short var7 = ((Short)this.d.get(var6)).shortValue();
                  var4.a(var6, var7);
               }

               DataOutputStream var9 = new DataOutputStream(new FileOutputStream(var3));
               class_dx.a((class_dn)var4, (DataOutput)var9);
               var9.close();
            }
         } catch (Exception var8) {
            var8.printStackTrace();
         }

         return var2.shortValue();
      }
   }
}
