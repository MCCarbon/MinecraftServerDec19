package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.EnumDirection;

public class class_anx extends BlockStateEnum {
   protected class_anx(String var1, Collection var2) {
      super(var1, EnumDirection.class, var2);
   }

   public static class_anx a(String var0) {
      return a(var0, Predicates.alwaysTrue());
   }

   public static class_anx a(String var0, Predicate var1) {
      return a(var0, Collections2.filter(Lists.newArrayList((Object[])EnumDirection.values()), var1));
   }

   public static class_anx a(String var0, Collection var1) {
      return new class_anx(var0, var1);
   }
}
