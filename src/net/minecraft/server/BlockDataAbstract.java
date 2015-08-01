package net.minecraft.server;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.IBlockState;

public abstract class BlockDataAbstract implements IBlockData {
   private static final Joiner a = Joiner.on(',');
   private static final Function b = new Function() {
      public String a(Entry var1) {
         if(var1 == null) {
            return "<NULL>";
         } else {
            IBlockState var2 = (IBlockState)var1.getKey();
            return var2.getName() + "=" + var2.getValueName((Comparable)var1.getValue());
         }
      }

      // $FF: synthetic method
      public Object apply(Object var1) {
         return this.a((Entry)var1);
      }
   };

   public IBlockData a(IBlockState var1) {
      return this.set(var1, (Comparable)a(var1.getValues(), this.get(var1)));
   }

   protected static Object a(Collection var0, Object var1) {
      Iterator var2 = var0.iterator();

      do {
         if(!var2.hasNext()) {
            return var2.next();
         }
      } while(!var2.next().equals(var1));

      if(var2.hasNext()) {
         return var2.next();
      } else {
         return var0.iterator().next();
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(Block.BLOCK_REGISTRY.getKey(this.getBlock()));
      if(!this.getStatesAndValues().isEmpty()) {
         var1.append("[");
         a.appendTo(var1, Iterables.transform(this.getStatesAndValues().entrySet(), b));
         var1.append("]");
      }

      return var1.toString();
   }
}
