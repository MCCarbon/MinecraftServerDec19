package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_i;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_m;
import net.minecraft.server.class_ms;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.StatisticList;

public class class_p extends class_i {
   public String c() {
      return "achievement";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.achievement.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 2) {
         throw new class_cf("commands.achievement.usage", new Object[0]);
      } else {
         final class_my var3 = StatisticList.a(var2[1]);
         if(var3 == null && !var2[1].equals("*")) {
            throw new class_bz("commands.achievement.unknownAchievement", new Object[]{var2[1]});
         } else {
            final EntityPlayer var4 = var2.length >= 3?a(var1, var2[2]):b(var1);
            boolean var5 = var2[0].equalsIgnoreCase("give");
            boolean var6 = var2[0].equalsIgnoreCase("take");
            if(var5 || var6) {
               if(var3 == null) {
                  Iterator var14;
                  class_ms var15;
                  if(var5) {
                     var14 = class_mt.e.iterator();

                     while(var14.hasNext()) {
                        var15 = (class_ms)var14.next();
                        var4.b((class_my)var15);
                     }

                     a(var1, this, "commands.achievement.give.success.all", new Object[]{var4.getName()});
                  } else if(var6) {
                     var14 = Lists.reverse(class_mt.e).iterator();

                     while(var14.hasNext()) {
                        var15 = (class_ms)var14.next();
                        var4.a((class_my)var15);
                     }

                     a(var1, this, "commands.achievement.take.success.all", new Object[]{var4.getName()});
                  }

               } else {
                  if(var3 instanceof class_ms) {
                     class_ms var7 = (class_ms)var3;
                     ArrayList var8;
                     if(var5) {
                        if(var4.A().a((class_ms)var7)) {
                           throw new class_bz("commands.achievement.alreadyHave", new Object[]{var4.getName(), var3.j()});
                        }

                        for(var8 = Lists.newArrayList(); var7.c != null && !var4.A().a((class_ms)var7.c); var7 = var7.c) {
                           var8.add(var7.c);
                        }

                        Iterator var9 = Lists.reverse(var8).iterator();

                        while(var9.hasNext()) {
                           class_ms var10 = (class_ms)var9.next();
                           var4.b((class_my)var10);
                        }
                     } else if(var6) {
                        if(!var4.A().a((class_ms)var7)) {
                           throw new class_bz("commands.achievement.dontHave", new Object[]{var4.getName(), var3.j()});
                        }

                        var8 = Lists.newArrayList((Iterator)Iterators.filter(class_mt.e.iterator(), new Predicate() {
                           public boolean a(class_ms var1) {
                              return var4.A().a((class_ms)var1) && var1 != var3;
                           }

                           // $FF: synthetic method
                           public boolean apply(Object var1) {
                              return this.a((class_ms)var1);
                           }
                        }));
                        ArrayList var16 = Lists.newArrayList((Iterable)var8);
                        Iterator var17 = var8.iterator();

                        label118:
                        while(true) {
                           class_ms var11;
                           class_ms var12;
                           boolean var13;
                           do {
                              if(!var17.hasNext()) {
                                 var17 = var16.iterator();

                                 while(var17.hasNext()) {
                                    var11 = (class_ms)var17.next();
                                    var4.a((class_my)var11);
                                 }
                                 break label118;
                              }

                              var11 = (class_ms)var17.next();
                              var12 = var11;

                              for(var13 = false; var12 != null; var12 = var12.c) {
                                 if(var12 == var3) {
                                    var13 = true;
                                 }
                              }
                           } while(var13);

                           for(var12 = var11; var12 != null; var12 = var12.c) {
                              var16.remove(var11);
                           }
                        }
                     }
                  }

                  if(var5) {
                     var4.b((class_my)var3);
                     a(var1, this, "commands.achievement.give.success.one", new Object[]{var4.getName(), var3.j()});
                  } else if(var6) {
                     var4.a(var3);
                     a(var1, this, "commands.achievement.take.success.one", new Object[]{var3.j(), var4.getName()});
                  }

               }
            }
         }
      }
   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      if(var2.length == 1) {
         return a(var2, new String[]{"give", "take"});
      } else if(var2.length != 2) {
         return var2.length == 3?a(var2, MinecraftServer.N().K()):null;
      } else {
         ArrayList var4 = Lists.newArrayList();
         Iterator var5 = StatisticList.b.iterator();

         while(var5.hasNext()) {
            class_my var6 = (class_my)var5.next();
            var4.add(var6.e);
         }

         return a(var2, var4);
      }
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 2;
   }
}
