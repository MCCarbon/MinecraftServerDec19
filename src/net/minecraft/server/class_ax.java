package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cb;
import net.minecraft.server.class_cf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_ec;
import net.minecraft.server.class_ed;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_xa;

public class class_ax extends class_i {
   private static final Map a = Maps.newHashMap();

   public String c() {
      return "replaceitem";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.replaceitem.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 1) {
         throw new class_cf("commands.replaceitem.usage", new Object[0]);
      } else {
         boolean var3;
         if(var2[0].equals("entity")) {
            var3 = false;
         } else {
            if(!var2[0].equals("block")) {
               throw new class_cf("commands.replaceitem.usage", new Object[0]);
            }

            var3 = true;
         }

         byte var4;
         if(var3) {
            if(var2.length < 6) {
               throw new class_cf("commands.replaceitem.block.usage", new Object[0]);
            }

            var4 = 4;
         } else {
            if(var2.length < 4) {
               throw new class_cf("commands.replaceitem.entity.usage", new Object[0]);
            }

            var4 = 2;
         }

         int var16 = var4 + 1;
         int var5 = this.e(var2[var4]);

         Item var6;
         try {
            var6 = f(var1, var2[var16]);
         } catch (class_cb var15) {
            if(Block.getByName(var2[var16]) != Blocks.AIR) {
               throw var15;
            }

            var6 = null;
         }

         ++var16;
         int var7 = var2.length > var16?a(var2[var16++], 1, 64):1;
         int var8 = var2.length > var16?a(var2[var16++]):0;
         class_aas var9 = new class_aas(var6, var7, var8);
         if(var2.length > var16) {
            String var10 = a(var1, var2, var16).c();

            try {
               var9.d(class_ed.a(var10));
            } catch (class_ec var14) {
               throw new class_bz("commands.replaceitem.tagError", new Object[]{var14.getMessage()});
            }
         }

         if(var9.b() == null) {
            var9 = null;
         }

         if(var3) {
            var1.a(class_n.class_a_in_class_n.d, 0);
            class_cj var18 = a(var1, var2, 1, false);
            World var11 = var1.e();
            class_amg var12 = var11.s(var18);
            if(var12 == null || !(var12 instanceof class_oj)) {
               throw new class_bz("commands.replaceitem.noContainer", new Object[]{Integer.valueOf(var18.n()), Integer.valueOf(var18.o()), Integer.valueOf(var18.p())});
            }

            class_oj var13 = (class_oj)var12;
            if(var5 >= 0 && var5 < var13.o_()) {
               var13.a(var5, var9);
            }
         } else {
            class_pr var17 = b(var1, var2[1]);
            var1.a(class_n.class_a_in_class_n.d, 0);
            if(var17 instanceof class_xa) {
               ((class_xa)var17).bq.b();
            }

            if(!var17.c(var5, var9)) {
               throw new class_bz("commands.replaceitem.failed", new Object[]{Integer.valueOf(var5), Integer.valueOf(var7), var9 == null?"Air":var9.B()});
            }

            if(var17 instanceof class_xa) {
               ((class_xa)var17).bq.b();
            }
         }

         var1.a(class_n.class_a_in_class_n.d, var7);
         a(var1, this, "commands.replaceitem.success", new Object[]{Integer.valueOf(var5), Integer.valueOf(var7), var9 == null?"Air":var9.B()});
      }
   }

   private int e(String var1) throws class_bz {
      if(!a.containsKey(var1)) {
         throw new class_bz("commands.generic.parameter.invalid", new Object[]{var1});
      } else {
         return ((Integer)a.get(var1)).intValue();
      }
   }

   public List a(class_m var1, String[] var2, class_cj var3) {
      return var2.length == 1?a(var2, new String[]{"entity", "block"}):(var2.length == 2 && var2[0].equals("entity")?a(var2, this.d()):(var2.length >= 2 && var2.length <= 4 && var2[0].equals("block")?a(var2, 1, var3):(var2.length == 3 && var2[0].equals("entity") || var2.length == 5 && var2[0].equals("block")?a(var2, a.keySet()):((var2.length != 4 || !var2[0].equals("entity")) && (var2.length != 6 || !var2[0].equals("block"))?null:a(var2, Item.ITEM_REGISTRY.getKeys())))));
   }

   protected String[] d() {
      return MinecraftServer.N().K();
   }

   public boolean b(String[] var1, int var2) {
      return var1.length > 0 && var1[0].equals("entity") && var2 == 1;
   }

   static {
      int var0;
      for(var0 = 0; var0 < 54; ++var0) {
         a.put("slot.container." + var0, Integer.valueOf(var0));
      }

      for(var0 = 0; var0 < 9; ++var0) {
         a.put("slot.hotbar." + var0, Integer.valueOf(var0));
      }

      for(var0 = 0; var0 < 27; ++var0) {
         a.put("slot.inventory." + var0, Integer.valueOf(9 + var0));
      }

      for(var0 = 0; var0 < 27; ++var0) {
         a.put("slot.enderchest." + var0, Integer.valueOf(200 + var0));
      }

      for(var0 = 0; var0 < 8; ++var0) {
         a.put("slot.villager." + var0, Integer.valueOf(300 + var0));
      }

      for(var0 = 0; var0 < 15; ++var0) {
         a.put("slot.horse." + var0, Integer.valueOf(500 + var0));
      }

      a.put("slot.weapon", Integer.valueOf(98));
      a.put("slot.weapon.mainhand", Integer.valueOf(98));
      a.put("slot.weapon.offhand", Integer.valueOf(99));
      a.put("slot.armor.head", Integer.valueOf(98 + class_pw.f.b()));
      a.put("slot.armor.chest", Integer.valueOf(98 + class_pw.e.b()));
      a.put("slot.armor.legs", Integer.valueOf(98 + class_pw.d.b()));
      a.put("slot.armor.feet", Integer.valueOf(98 + class_pw.c.b()));
      a.put("slot.horse.saddle", Integer.valueOf(400));
      a.put("slot.horse.armor", Integer.valueOf(401));
      a.put("slot.horse.chest", Integer.valueOf(499));
   }
}
