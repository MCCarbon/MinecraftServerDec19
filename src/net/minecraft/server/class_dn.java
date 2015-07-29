package net.minecraft.server;

import com.google.common.collect.Maps;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.class_dl;
import net.minecraft.server.class_dm;
import net.minecraft.server.class_dp;
import net.minecraft.server.class_dr;
import net.minecraft.server.class_ds;
import net.minecraft.server.class_dt;
import net.minecraft.server.class_du;
import net.minecraft.server.class_dv;
import net.minecraft.server.class_dw;
import net.minecraft.server.class_dz;
import net.minecraft.server.class_e;
import net.minecraft.server.class_ea;
import net.minecraft.server.class_eb;

public class class_dn extends class_eb {
   private Map b = Maps.newHashMap();

   void a(DataOutput var1) throws IOException {
      Iterator var2 = this.b.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         class_eb var4 = (class_eb)this.b.get(var3);
         a(var3, var4, var1);
      }

      var1.writeByte(0);
   }

   void a(DataInput var1, int var2, class_dw var3) throws IOException {
      var3.a(384L);
      if(var2 > 512) {
         throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
      } else {
         this.b.clear();

         byte var4;
         while((var4 = a(var1, var3)) != 0) {
            String var5 = b(var1, var3);
            var3.a((long)(224 + 16 * var5.length()));
            class_eb var6 = a(var4, var5, var1, var2 + 1, var3);
            if(this.b.put(var5, var6) != null) {
               var3.a(288L);
            }
         }

      }
   }

   public Set c() {
      return this.b.keySet();
   }

   public byte a() {
      return (byte)10;
   }

   public void a(String var1, class_eb var2) {
      this.b.put(var1, var2);
   }

   public void a(String var1, byte var2) {
      this.b.put(var1, new class_dm(var2));
   }

   public void a(String var1, short var2) {
      this.b.put(var1, new class_dz(var2));
   }

   public void a(String var1, int var2) {
      this.b.put(var1, new class_dt(var2));
   }

   public void a(String var1, long var2) {
      this.b.put(var1, new class_dv(var2));
   }

   public void a(String var1, UUID var2) {
      this.a(var1 + "Most", var2.getMostSignificantBits());
      this.a(var1 + "Least", var2.getLeastSignificantBits());
   }

   public UUID a(String var1) {
      return this.b(var1 + "Most", 99) && this.b(var1 + "Least", 99)?new UUID(this.h(var1 + "Most"), this.h(var1 + "Least")):null;
   }

   public void a(String var1, float var2) {
      this.b.put(var1, new class_dr(var2));
   }

   public void a(String var1, double var2) {
      this.b.put(var1, new class_dp(var2));
   }

   public void a(String var1, String var2) {
      this.b.put(var1, new class_ea(var2));
   }

   public void a(String var1, byte[] var2) {
      this.b.put(var1, new class_dl(var2));
   }

   public void a(String var1, int[] var2) {
      this.b.put(var1, new class_ds(var2));
   }

   public void a(String var1, boolean var2) {
      this.a(var1, (byte)(var2?1:0));
   }

   public class_eb b(String var1) {
      return (class_eb)this.b.get(var1);
   }

   public byte c(String var1) {
      class_eb var2 = (class_eb)this.b.get(var1);
      return var2 != null?var2.a():0;
   }

   public boolean d(String var1) {
      return this.b.containsKey(var1);
   }

   public boolean b(String var1, int var2) {
      byte var3 = this.c(var1);
      if(var3 == var2) {
         return true;
      } else if(var2 != 99) {
         if(var3 > 0) {
            ;
         }

         return false;
      } else {
         return var3 == 1 || var3 == 2 || var3 == 3 || var3 == 4 || var3 == 5 || var3 == 6;
      }
   }

   public byte e(String var1) {
      try {
         return !this.b(var1, 99)?0:((class_eb.class_a_in_class_eb)this.b.get(var1)).f();
      } catch (ClassCastException var3) {
         return (byte)0;
      }
   }

   public short f(String var1) {
      try {
         return !this.b(var1, 99)?0:((class_eb.class_a_in_class_eb)this.b.get(var1)).e();
      } catch (ClassCastException var3) {
         return (short)0;
      }
   }

   public int g(String var1) {
      try {
         return !this.b(var1, 99)?0:((class_eb.class_a_in_class_eb)this.b.get(var1)).d();
      } catch (ClassCastException var3) {
         return 0;
      }
   }

   public long h(String var1) {
      try {
         return !this.b(var1, 99)?0L:((class_eb.class_a_in_class_eb)this.b.get(var1)).c();
      } catch (ClassCastException var3) {
         return 0L;
      }
   }

   public float i(String var1) {
      try {
         return !this.b(var1, 99)?0.0F:((class_eb.class_a_in_class_eb)this.b.get(var1)).h();
      } catch (ClassCastException var3) {
         return 0.0F;
      }
   }

   public double j(String var1) {
      try {
         return !this.b(var1, 99)?0.0D:((class_eb.class_a_in_class_eb)this.b.get(var1)).g();
      } catch (ClassCastException var3) {
         return 0.0D;
      }
   }

   public String k(String var1) {
      try {
         return !this.b(var1, 8)?"":((class_eb)this.b.get(var1)).a_();
      } catch (ClassCastException var3) {
         return "";
      }
   }

   public byte[] l(String var1) {
      try {
         return !this.b(var1, 7)?new byte[0]:((class_dl)this.b.get(var1)).c();
      } catch (ClassCastException var3) {
         throw new class_e(this.a((String)var1, 7, (ClassCastException)var3));
      }
   }

   public int[] m(String var1) {
      try {
         return !this.b(var1, 11)?new int[0]:((class_ds)this.b.get(var1)).c();
      } catch (ClassCastException var3) {
         throw new class_e(this.a((String)var1, 11, (ClassCastException)var3));
      }
   }

   public class_dn n(String var1) {
      try {
         return !this.b(var1, 10)?new class_dn():(class_dn)this.b.get(var1);
      } catch (ClassCastException var3) {
         throw new class_e(this.a((String)var1, 10, (ClassCastException)var3));
      }
   }

   public class_du c(String var1, int var2) {
      try {
         if(this.c(var1) != 9) {
            return new class_du();
         } else {
            class_du var3 = (class_du)this.b.get(var1);
            return var3.c() > 0 && var3.f() != var2?new class_du():var3;
         }
      } catch (ClassCastException var4) {
         throw new class_e(this.a((String)var1, 9, (ClassCastException)var4));
      }
   }

   public boolean o(String var1) {
      return this.e(var1) != 0;
   }

   public void p(String var1) {
      this.b.remove(var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("{");

      Entry var3;
      for(Iterator var2 = this.b.entrySet().iterator(); var2.hasNext(); var1.append((String)var3.getKey()).append(':').append(var3.getValue())) {
         var3 = (Entry)var2.next();
         if(var1.length() != 1) {
            var1.append(',');
         }
      }

      return var1.append('}').toString();
   }

   public boolean c_() {
      return this.b.isEmpty();
   }

   private class_b a(final String var1, final int var2, ClassCastException var3) {
      class_b var4 = class_b.a(var3, "Reading NBT data");
      class_c var5 = var4.a("Corrupt NBT tag", 1);
      var5.a("Tag type found", new Callable() {
         public String a() throws Exception {
            return class_eb.a[((class_eb)class_dn.this.b.get(var1)).a()];
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var5.a("Tag type expected", new Callable() {
         public String a() throws Exception {
            return class_eb.a[var2];
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var5.a((String)"Tag name", (Object)var1);
      return var4;
   }

   public class_eb b() {
      class_dn var1 = new class_dn();
      Iterator var2 = this.b.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.a(var3, ((class_eb)this.b.get(var3)).b());
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         class_dn var2 = (class_dn)var1;
         return this.b.entrySet().equals(var2.b.entrySet());
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.b.hashCode();
   }

   private static void a(String var0, class_eb var1, DataOutput var2) throws IOException {
      var2.writeByte(var1.a());
      if(var1.a() != 0) {
         var2.writeUTF(var0);
         var1.a(var2);
      }
   }

   private static byte a(DataInput var0, class_dw var1) throws IOException {
      return var0.readByte();
   }

   private static String b(DataInput var0, class_dw var1) throws IOException {
      return var0.readUTF();
   }

   static class_eb a(byte var0, String var1, DataInput var2, int var3, class_dw var4) throws IOException {
      class_eb var5 = class_eb.a(var0);

      try {
         var5.a(var2, var3, var4);
         return var5;
      } catch (IOException var9) {
         class_b var7 = class_b.a(var9, "Loading NBT data");
         class_c var8 = var7.a("NBT Tag");
         var8.a((String)"Tag name", (Object)var1);
         var8.a((String)"Tag type", (Object)Byte.valueOf(var0));
         throw new class_e(var7);
      }
   }

   public void a(class_dn var1) {
      Iterator var2 = var1.b.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         class_eb var4 = (class_eb)var1.b.get(var3);
         if(var4.a() == 10) {
            if(this.b(var3, 10)) {
               class_dn var5 = this.n(var3);
               var5.a((class_dn)var4);
            } else {
               this.a(var3, var4.b());
            }
         } else {
            this.a(var3, var4.b());
         }
      }

   }
}
