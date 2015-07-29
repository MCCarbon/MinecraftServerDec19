package net.minecraft.server;

import com.google.common.base.Function;
import net.minecraft.server.class_aas;
import net.minecraft.server.Block;
import net.minecraft.server.class_zg;

public class class_aba extends class_zg {
   protected final Block b;
   protected final Function c;

   public class_aba(Block var1, Block var2, Function var3) {
      super(var1);
      this.b = var2;
      this.c = var3;
      this.e(0);
      this.a(true);
   }

   public class_aba(Block var1, Block var2, final String[] var3) {
      this(var1, var2, new Function() {
         public String a(class_aas var1) {
            int var2 = var1.i();
            if(var2 < 0 || var2 >= var3.length) {
               var2 = 0;
            }

            return var3[var2];
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      });
   }

   public int a(int var1) {
      return var1;
   }

   public String e_(class_aas var1) {
      return super.a() + "." + (String)this.c.apply(var1);
   }
}
