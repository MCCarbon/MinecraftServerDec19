package net.minecraft.server;

import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_my;
import net.minecraft.server.class_mz;
import net.minecraft.server.StatisticList;

public class class_mv extends class_my {
   public class_mv(String var1, IChatBaseComponent var2, class_mz var3) {
      super(var1, var2, var3);
   }

   public class_mv(String var1, IChatBaseComponent var2) {
      super(var1, var2);
   }

   public class_my h() {
      super.h();
      StatisticList.c.add(this);
      return this;
   }
}
