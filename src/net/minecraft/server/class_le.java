package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fw;
import net.minecraft.server.class_lh;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_oh;

public class class_le extends class_oh {
   private final Set g = Sets.newHashSet();
   private final Set h;
   private boolean i;

   public class_le(class_eu var1, class_oh.class_a_in_class_oh var2, class_oh.class_b_in_class_oh var3, boolean var4, boolean var5) {
      super(MathHelper.getRandomUUID(), var1, var2, var3, var4, var5);
      this.h = Collections.unmodifiableSet(this.g);
      this.i = true;
   }

   public void a(float var1) {
      if(var1 != this.b) {
         super.a(var1);
         this.a(class_fw.class_a_in_class_fw.c);
      }

   }

   private void a(class_fw.class_a_in_class_fw var1) {
      if(this.i) {
         class_fw var2 = new class_fw(var1, this);
         Iterator var3 = this.g.iterator();

         while(var3.hasNext()) {
            class_lh var4 = (class_lh)var3.next();
            var4.a.a((class_ff)var2);
         }
      }

   }

   public void a(class_lh var1) {
      if(this.g.add(var1) && this.i) {
         var1.a.a((class_ff)(new class_fw(class_fw.class_a_in_class_fw.a, this)));
      }

   }

   public void b(class_lh var1) {
      if(this.g.remove(var1) && this.i) {
         var1.a.a((class_ff)(new class_fw(class_fw.class_a_in_class_fw.b, this)));
      }

   }

   public void c(boolean var1) {
      if(var1 != this.i) {
         this.i = var1;
         Iterator var2 = this.g.iterator();

         while(var2.hasNext()) {
            class_lh var3 = (class_lh)var2.next();
            var3.a.a((class_ff)(new class_fw(var1?class_fw.class_a_in_class_fw.a:class_fw.class_a_in_class_fw.b, this)));
         }
      }

   }

   public Collection c() {
      return this.h;
   }
}