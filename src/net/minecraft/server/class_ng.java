package net.minecraft.server;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class class_ng extends AbstractSet {
   private static final Set a = Sets.newHashSet();
   private final Map b = Maps.newHashMap();
   private final Set c = Sets.newIdentityHashSet();
   private final Class d;
   private final List e = Lists.newArrayList();

   public class_ng(Class var1) {
      this.d = var1;
      this.c.add(var1);
      this.b.put(var1, this.e);
      Iterator var2 = a.iterator();

      while(var2.hasNext()) {
         Class var3 = (Class)var2.next();
         this.a(var3);
      }

   }

   protected void a(Class var1) {
      a.add(var1);
      Iterator var2 = this.e.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         if(var1.isAssignableFrom(var3.getClass())) {
            this.a(var3, var1);
         }
      }

      this.c.add(var1);
   }

   protected Class b(Class var1) {
      if(this.d.isAssignableFrom(var1)) {
         if(!this.c.contains(var1)) {
            this.a(var1);
         }

         return var1;
      } else {
         throw new IllegalArgumentException("Don\'t know how to search for " + var1);
      }
   }

   public boolean add(Object var1) {
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         Class var3 = (Class)var2.next();
         if(var3.isAssignableFrom(var1.getClass())) {
            this.a(var1, var3);
         }
      }

      return true;
   }

   private void a(Object var1, Class var2) {
      List var3 = (List)this.b.get(var2);
      if(var3 == null) {
         this.b.put(var2, Lists.newArrayList(new Object[]{var1}));
      } else {
         var3.add(var1);
      }

   }

   public boolean remove(Object var1) {
      Object var2 = var1;
      boolean var3 = false;
      Iterator var4 = this.c.iterator();

      while(var4.hasNext()) {
         Class var5 = (Class)var4.next();
         if(var5.isAssignableFrom(var2.getClass())) {
            List var6 = (List)this.b.get(var5);
            if(var6 != null && var6.remove(var2)) {
               var3 = true;
            }
         }
      }

      return var3;
   }

   public boolean contains(Object var1) {
      return Iterators.contains(this.c(var1.getClass()).iterator(), var1);
   }

   public Iterable c(final Class var1) {
      return new Iterable() {
         public Iterator iterator() {
            List var1x = (List)class_ng.this.b.get(class_ng.this.b(var1));
            if(var1x == null) {
               return Iterators.emptyIterator();
            } else {
               Iterator var2 = var1x.iterator();
               return Iterators.filter(var2, var1);
            }
         }
      };
   }

   public Iterator iterator() {
      return this.e.isEmpty()?Iterators.emptyIterator():Iterators.unmodifiableIterator(this.e.iterator());
   }

   public int size() {
      return this.e.size();
   }
}
