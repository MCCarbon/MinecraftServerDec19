package net.minecraft.server;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_cs;

public class class_ct implements class_cs {
   private final IdentityHashMap a = new IdentityHashMap(512);
   private final List b = Lists.newArrayList();

   public void a(Object var1, int var2) {
      this.a.put(var1, Integer.valueOf(var2));

      while(this.b.size() <= var2) {
         this.b.add((Object)null);
      }

      this.b.set(var2, var1);
   }

   public int a(Object var1) {
      Integer var2 = (Integer)this.a.get(var1);
      return var2 == null?-1:var2.intValue();
   }

   public final Object a(int var1) {
      return var1 >= 0 && var1 < this.b.size()?this.b.get(var1):null;
   }

   public Iterator iterator() {
      return Iterators.filter(this.b.iterator(), Predicates.notNull());
   }
}
