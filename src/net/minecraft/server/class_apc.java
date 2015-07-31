package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.server.World;
import net.minecraft.server.class_afx;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_anb;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_ano;
import net.minecraft.server.class_anp;
import net.minecraft.server.class_anq;
import net.minecraft.server.class_ans;
import net.minecraft.server.class_aok;
import net.minecraft.server.class_aqi;
import net.minecraft.server.class_aqk;
import net.minecraft.server.class_ari;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagInt;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_le;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_oh;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pv;
import net.minecraft.server.class_uq;
import net.minecraft.server.class_ur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_apc {
   private static final Logger a = LogManager.getLogger();
   private static final Predicate b;
   private final class_le c;
   private final class_lg d;
   private final List e;
   private final class_anp f;
   private int g;
   private int h;
   private int i;
   private int j;
   private boolean k;
   private boolean l;
   private UUID m;
   private boolean n;

   public class_apc(class_lg var1, NBTTagCompound var2) {
      this.c = new class_le(new class_fb("entity.EnderDragon.name", new Object[0]), class_oh.class_a_in_class_oh.a, class_oh.class_b_in_class_oh.a, false, true);
      this.e = Lists.newArrayList();
      this.g = 0;
      this.h = 0;
      this.i = 0;
      this.j = 0;
      this.k = false;
      this.l = false;
      this.m = null;
      this.n = false;
      this.d = var1;
      if(var2.hasOfType("DragonKilled", 1)) {
         this.m = var2.getUUID("DragonUUID");
         this.k = var2.getBoolean("DragonKilled");
         this.l = var2.getBoolean("PreviouslyKilled");
      } else {
         this.n = true;
         this.k = true;
         this.l = true;
      }

      if(var2.hasOfType("Gateways", 9)) {
         NBTTagList var3 = var2.getList("Gateways", 3);

         for(int var4 = 0; var4 < var3.getSize(); ++var4) {
            this.e.add(Integer.valueOf(var3.getInt(var4)));
         }
      } else {
         this.e.addAll(ContiguousSet.create(Range.closedOpen(Integer.valueOf(0), Integer.valueOf(20)), DiscreteDomain.integers()));
         Collections.shuffle(this.e, new Random(var1.K()));
      }

      this.f = class_anq.a().a(new String[]{"       ", "       ", "       ", "   #   ", "       ", "       ", "       "}).a(new String[]{"       ", "       ", "       ", "   #   ", "       ", "       ", "       "}).a(new String[]{"       ", "       ", "       ", "   #   ", "       ", "       ", "       "}).a(new String[]{"  ###  ", " #   # ", "#     #", "#  #  #", "#     #", " #   # ", "  ###  "}).a(new String[]{"       ", "  ###  ", " ##### ", " ##### ", " ##### ", "  ###  ", "       "}).a('#', class_ano.a(class_ans.a(Blocks.BEDROCK))).b();
   }

   public NBTTagCompound a() {
      NBTTagCompound var1 = new NBTTagCompound();
      if(this.m != null) {
         var1.put("DragonUUID", this.m);
      }

      var1.put("DragonKilled", this.k);
      var1.put("PreviouslyKilled", this.l);
      NBTTagList var2 = new NBTTagList();
      Iterator var3 = this.e.iterator();

      while(var3.hasNext()) {
         int var4 = ((Integer)var3.next()).intValue();
         var2.add((NBTTag)(new NBTTagInt(var4)));
      }

      var1.put((String)"Gateways", (NBTTag)var2);
      return var1;
   }

   public void b() {
      this.c.c(!this.k);
      if(++this.j >= 20) {
         this.i();
         this.j = 0;
      }

      if(!this.c.c().isEmpty()) {
         List var1;
         if(this.n) {
            a.info("Scanning for legacy world dragon fight...");
            this.h();
            this.n = false;
            if(this.f()) {
               a.info("Found that the dragon has been killed in this world already.");
               this.l = true;
            } else {
               a.info("Found that the dragon has not yet been killed in this world.");
               this.l = false;
            }

            var1 = this.d.a((Class)class_ur.class, (Predicate)class_pv.a);
            if(!var1.isEmpty()) {
               class_ur var2 = (class_ur)var1.get(0);
               this.m = var2.aM();
               a.info("Found that there\'s a dragon still alive (" + var2 + ")");
               this.k = false;
            } else {
               this.k = true;
            }

            if(!this.l && this.k) {
               this.k = false;
            }
         }

         if(!this.k) {
            if(this.m == null || ++this.g >= 1200) {
               this.h();
               var1 = this.d.a((Class)class_ur.class, (Predicate)class_pv.a);
               if(!var1.isEmpty()) {
                  this.m = ((class_ur)var1.get(0)).aM();
               } else {
                  this.l();
               }

               this.g = 0;
            }

            if(++this.i >= 100) {
               this.j();
               this.i = 0;
            }
         }
      }

   }

   private boolean f() {
      for(int var1 = 0; var1 < 8; ++var1) {
         for(int var2 = 0; var2 < 8; ++var2) {
            class_aok var3 = this.d.a(var1, var2);
            Iterator var4 = var3.r().values().iterator();

            while(var4.hasNext()) {
               class_amg var5 = (class_amg)var4.next();
               if(var5 instanceof class_anb) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private class_anp.class_b_in_class_anp g() {
      for(int var1 = 0; var1 < 8; ++var1) {
         for(int var2 = 0; var2 < 8; ++var2) {
            class_aok var3 = this.d.a(var1, var2);
            Iterator var4 = var3.r().values().iterator();

            while(var4.hasNext()) {
               class_amg var5 = (class_amg)var4.next();
               if(var5 instanceof class_anb) {
                  class_anp.class_b_in_class_anp var6 = this.f.a(this.d, var5.v());
                  if(var6 != null) {
                     return var6;
                  }
               }
            }
         }
      }

      return null;
   }

   private void h() {
      for(int var1 = 0; var1 < 8; ++var1) {
         for(int var2 = 0; var2 < 8; ++var2) {
            this.d.a(var1, var2);
         }
      }

   }

   private void i() {
      HashSet var1 = Sets.newHashSet();
      Iterator var2 = this.d.b(class_lh.class, b).iterator();

      while(var2.hasNext()) {
         class_lh var3 = (class_lh)var2.next();
         this.c.a(var3);
         var1.add(var3);
      }

      HashSet var5 = Sets.newHashSet((Iterable)this.c.c());
      var5.removeAll(var1);
      Iterator var6 = var5.iterator();

      while(var6.hasNext()) {
         class_lh var4 = (class_lh)var6.next();
         this.c.b(var4);
      }

   }

   private void j() {
      this.i = 0;
      this.h = 0;
      class_ari.class_a_in_class_ari[] var1 = class_afx.a((World)this.d);
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         class_ari.class_a_in_class_ari var4 = var1[var3];
         this.h += this.d.a((Class)class_uq.class, (class_awf)var4.f()).size();
      }

      a.debug("Found {} end crystals still alive", new Object[]{Integer.valueOf(this.h)});
   }

   public void a(class_ur var1) {
      if(var1.aM().equals(this.m)) {
         this.l = true;
         this.k = true;
         this.c.a(0.0F);
         this.c.c(false);
         this.a(true);
         this.k();
      }

   }

   private void k() {
      if(!this.e.isEmpty()) {
         int var1 = ((Integer)this.e.remove(this.e.size() - 1)).intValue();
         int var2 = (int)(96.0D * Math.cos(2.0D * (-3.141592653589793D + 0.15707963267948966D * (double)var1)));
         int var3 = (int)(96.0D * Math.sin(2.0D * (-3.141592653589793D + 0.15707963267948966D * (double)var1)));
         this.a(new BlockPosition(var2, 75, var3));
      }
   }

   private void a(BlockPosition var1) {
      this.d.b(3000, var1, 0);
      (new class_aqi()).b(this.d, new Random(), var1);
   }

   private void a(boolean var1) {
      class_aqk var2 = new class_aqk(var1);

      BlockPosition var3;
      for(var3 = this.d.r(class_aqk.a).shiftDown(); this.d.p(var3).getBlock() == Blocks.BEDROCK && var3.getY() > this.d.G(); var3 = var3.shiftDown()) {
         ;
      }

      var2.b(this.d, new Random(), var3);
   }

   private void l() {
      this.d.f(new BlockPosition(0, 128, 0));
      class_ur var1 = new class_ur(this.d);
      var1.b(0.0D, 128.0D, 0.0D, this.d.s.nextFloat() * 360.0F, 0.0F);
      this.d.a((class_pr)var1);
      this.m = var1.aM();
   }

   public void b(class_ur var1) {
      if(var1.aM().equals(this.m)) {
         this.c.a(var1.bo() / var1.bv());
         this.g = 0;
      }

   }

   public int c() {
      return this.h;
   }

   public void a(class_uq var1, class_pc var2) {
      this.j();
      class_pr var3 = this.d.a(this.m);
      if(var3 instanceof class_ur) {
         ((class_ur)var3).a(new BlockPosition(var1), var2);
      }

   }

   public boolean d() {
      return this.l;
   }

   public void e() {
      if(this.k) {
         for(class_anp.class_b_in_class_anp var1 = this.g(); var1 != null; var1 = this.g()) {
            for(int var2 = 0; var2 < this.f.c(); ++var2) {
               for(int var3 = 0; var3 < this.f.b(); ++var3) {
                  for(int var4 = 0; var4 < this.f.a(); ++var4) {
                     class_ano var5 = var1.a(var2, var3, var4);
                     if(var5.a().getBlock() == Blocks.BEDROCK || var5.a().getBlock() == Blocks.END_PORTAL) {
                        this.d.a((BlockPosition)var5.d(), (IBlockData)Blocks.END_STONE.getBlockData());
                     }
                  }
               }
            }
         }

         this.l();
         this.a(false);
      }

   }

   static {
      b = Predicates.and(class_pv.a, class_pv.a(0.0D, 128.0D, 0.0D, 192.0D));
   }
}
