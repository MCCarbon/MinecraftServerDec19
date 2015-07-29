package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import net.minecraft.server.class_db;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_dd implements class_db {
   private static final Logger a = LogManager.getLogger();
   protected final Map c = this.b();
   private Object[] b;

   protected Map b() {
      return Maps.newHashMap();
   }

   public Object c(Object var1) {
      return this.c.get(var1);
   }

   public void a(Object var1, Object var2) {
      Validate.notNull(var1);
      Validate.notNull(var2);
      this.b = null;
      if(this.c.containsKey(var1)) {
         a.debug("Adding duplicate key \'" + var1 + "\' to registry");
      }

      this.c.put(var1, var2);
   }

   public Set c() {
      return Collections.unmodifiableSet(this.c.keySet());
   }

   public Object a(Random var1) {
      if(this.b == null) {
         Collection var2 = this.c.values();
         if(var2.isEmpty()) {
            return null;
         }

         this.b = var2.toArray(new Object[var2.size()]);
      }

      return this.b[var1.nextInt(this.b.length)];
   }

   public boolean d(Object var1) {
      return this.c.containsKey(var1);
   }

   public Iterator iterator() {
      return this.c.values().iterator();
   }
}
