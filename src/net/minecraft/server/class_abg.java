package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_abf;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aiy;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_abg extends Item {
   private static final Map b = Maps.newHashMap();
   public final String a;

   protected class_abg(String var1) {
      this.a = var1;
      this.h = 1;
      this.a(CreativeTab.f);
      b.put("records." + var1, this);
   }

   public class_oq a(class_aas var1, class_xa var2, World var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      IBlockData var10 = var3.p(var4);
      if(var10.getBlock() == Blocks.JUKEBOX && !((Boolean)var10.get(class_aiy.a)).booleanValue()) {
         if(var3.D) {
            return class_oq.a;
         } else {
            ((class_aiy)Blocks.JUKEBOX).a(var3, var4, var10, var1);
            var3.a((class_xa)null, 1005, var4, Item.getId((Item)this));
            --var1.b;
            var2.b(class_nc.X);
            return class_oq.a;
         }
      } else {
         return class_oq.b;
      }
   }

   public class_abf g(class_aas var1) {
      return class_abf.c;
   }
}
