package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class class_nm implements Map {
   private final Map a = Maps.newLinkedHashMap();

   public int size() {
      return this.a.size();
   }

   public boolean isEmpty() {
      return this.a.isEmpty();
   }

   public boolean containsKey(Object var1) {
      return this.a.containsKey(var1.toString().toLowerCase());
   }

   public boolean containsValue(Object var1) {
      return this.a.containsKey(var1);
   }

   public Object get(Object var1) {
      return this.a.get(var1.toString().toLowerCase());
   }

   public Object a(String var1, Object var2) {
      return this.a.put(var1.toLowerCase(), var2);
   }

   public Object remove(Object var1) {
      return this.a.remove(var1.toString().toLowerCase());
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.a((String)var3.getKey(), var3.getValue());
      }

   }

   public void clear() {
      this.a.clear();
   }

   public Set keySet() {
      return this.a.keySet();
   }

   public Collection values() {
      return this.a.values();
   }

   public Set entrySet() {
      return this.a.entrySet();
   }

   // $FF: synthetic method
   public Object put(Object var1, Object var2) {
      return this.a((String)var1, var2);
   }
}
