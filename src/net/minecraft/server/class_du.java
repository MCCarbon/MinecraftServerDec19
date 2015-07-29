package net.minecraft.server;

import com.google.common.collect.Lists;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dp;
import net.minecraft.server.class_dq;
import net.minecraft.server.class_dr;
import net.minecraft.server.class_ds;
import net.minecraft.server.class_dt;
import net.minecraft.server.class_dw;
import net.minecraft.server.class_eb;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_du extends class_eb {
   private static final Logger b = LogManager.getLogger();
   private List c = Lists.newArrayList();
   private byte d = 0;

   void a(DataOutput var1) throws IOException {
      if(!this.c.isEmpty()) {
         this.d = ((class_eb)this.c.get(0)).a();
      } else {
         this.d = 0;
      }

      var1.writeByte(this.d);
      var1.writeInt(this.c.size());

      for(int var2 = 0; var2 < this.c.size(); ++var2) {
         ((class_eb)this.c.get(var2)).a(var1);
      }

   }

   void a(DataInput var1, int var2, class_dw var3) throws IOException {
      var3.a(296L);
      if(var2 > 512) {
         throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
      } else {
         this.d = var1.readByte();
         int var4 = var1.readInt();
         if(this.d == 0 && var4 > 0) {
            throw new RuntimeException("Missing type on ListTag");
         } else {
            var3.a(32L * (long)var4);
            this.c = Lists.newArrayListWithCapacity(var4);

            for(int var5 = 0; var5 < var4; ++var5) {
               class_eb var6 = class_eb.a(this.d);
               var6.a(var1, var2 + 1, var3);
               this.c.add(var6);
            }

         }
      }
   }

   public byte a() {
      return (byte)9;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("[");

      for(int var2 = 0; var2 < this.c.size(); ++var2) {
         if(var2 != 0) {
            var1.append(',');
         }

         var1.append(var2).append(':').append(this.c.get(var2));
      }

      return var1.append(']').toString();
   }

   public void a(class_eb var1) {
      if(var1.a() == 0) {
         b.warn("Invalid TagEnd added to ListTag");
      } else {
         if(this.d == 0) {
            this.d = var1.a();
         } else if(this.d != var1.a()) {
            b.warn("Adding mismatching tag types to tag list");
            return;
         }

         this.c.add(var1);
      }
   }

   public void a(int var1, class_eb var2) {
      if(var2.a() == 0) {
         b.warn("Invalid TagEnd added to ListTag");
      } else if(var1 >= 0 && var1 < this.c.size()) {
         if(this.d == 0) {
            this.d = var2.a();
         } else if(this.d != var2.a()) {
            b.warn("Adding mismatching tag types to tag list");
            return;
         }

         this.c.set(var1, var2);
      } else {
         b.warn("index out of bounds to set tag in tag list");
      }
   }

   public class_eb a(int var1) {
      return (class_eb)this.c.remove(var1);
   }

   public boolean c_() {
      return this.c.isEmpty();
   }

   public class_dn b(int var1) {
      if(var1 >= 0 && var1 < this.c.size()) {
         class_eb var2 = (class_eb)this.c.get(var1);
         return var2.a() == 10?(class_dn)var2:new class_dn();
      } else {
         return new class_dn();
      }
   }

   public int c(int var1) {
      if(var1 >= 0 && var1 < this.c.size()) {
         class_eb var2 = (class_eb)this.c.get(var1);
         return var2.a() == 3?((class_dt)var2).d():0;
      } else {
         return 0;
      }
   }

   public int[] d(int var1) {
      if(var1 >= 0 && var1 < this.c.size()) {
         class_eb var2 = (class_eb)this.c.get(var1);
         return var2.a() == 11?((class_ds)var2).c():new int[0];
      } else {
         return new int[0];
      }
   }

   public double e(int var1) {
      if(var1 >= 0 && var1 < this.c.size()) {
         class_eb var2 = (class_eb)this.c.get(var1);
         return var2.a() == 6?((class_dp)var2).g():0.0D;
      } else {
         return 0.0D;
      }
   }

   public float f(int var1) {
      if(var1 >= 0 && var1 < this.c.size()) {
         class_eb var2 = (class_eb)this.c.get(var1);
         return var2.a() == 5?((class_dr)var2).h():0.0F;
      } else {
         return 0.0F;
      }
   }

   public String g(int var1) {
      if(var1 >= 0 && var1 < this.c.size()) {
         class_eb var2 = (class_eb)this.c.get(var1);
         return var2.a() == 8?var2.a_():var2.toString();
      } else {
         return "";
      }
   }

   public class_eb h(int var1) {
      return (class_eb)(var1 >= 0 && var1 < this.c.size()?(class_eb)this.c.get(var1):new class_dq());
   }

   public int c() {
      return this.c.size();
   }

   public class_eb b() {
      class_du var1 = new class_du();
      var1.d = this.d;
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         class_eb var3 = (class_eb)var2.next();
         class_eb var4 = var3.b();
         var1.c.add(var4);
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         class_du var2 = (class_du)var1;
         if(this.d == var2.d) {
            return this.c.equals(var2.c);
         }
      }

      return false;
   }

   public int hashCode() {
      return super.hashCode() ^ this.c.hashCode();
   }

   public int f() {
      return this.d;
   }
}
