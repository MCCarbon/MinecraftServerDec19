package net.minecraft.server;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.server.class_cs;
import net.minecraft.server.class_ct;
import net.minecraft.server.class_dd;

public class class_cx extends class_dd implements class_cs {
   protected final class_ct a = new class_ct();
   protected final Map b;

   public class_cx() {
      this.b = ((BiMap)this.c).inverse();
   }

   public void a(int var1, Object var2, Object var3) {
      this.a.a(var3, var1);
      this.a(var2, var3);
   }

   protected Map b() {
      return HashBiMap.create();
   }

   public Object c(Object var1) {
      return super.c(var1);
   }

   public Object b(Object var1) {
      return this.b.get(var1);
   }

   public boolean d(Object var1) {
      return super.d(var1);
   }

   public int a(Object var1) {
      return this.a.a(var1);
   }

   public Object a(int var1) {
      return this.a.a(var1);
   }

   public Iterator iterator() {
      return this.a.iterator();
   }
}
