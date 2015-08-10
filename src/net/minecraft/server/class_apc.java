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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_apc {
   private static final Logger a = LogManager.getLogger();
   private static final Predicate b;
   private final class_le c;
   private final WorldServer d;
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

   public class_apc(WorldServer var1, NBTTagCompound var2) {
      this.c = new class_le(new ChatMessage("entity.EnderDragon.name", new Object[0]), class_oh.class_a_in_class_oh.a, class_oh.class_b_in_class_oh.a, false, true);
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

            var1 = this.d.getEntities((Class)EntityEnderDragon.class, (Predicate)IEntitySelector.IS_ALIVE);
            if(!var1.isEmpty()) {
               EntityEnderDragon var2 = (EntityEnderDragon)var1.get(0);
               this.m = var2.getUniqueId();
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
               var1 = this.d.getEntities((Class)EntityEnderDragon.class, (Predicate)IEntitySelector.IS_ALIVE);
               if(!var1.isEmpty()) {
                  this.m = ((EntityEnderDragon)var1.get(0)).getUniqueId();
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
            Chunk var3 = this.d.getChunkAt(var1, var2);
            Iterator var4 = var3.r().values().iterator();

            while(var4.hasNext()) {
               TileEntity var5 = (TileEntity)var4.next();
               if(var5 instanceof TileEntityEnderPortal) {
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
            Chunk var3 = this.d.getChunkAt(var1, var2);
            Iterator var4 = var3.r().values().iterator();

            while(var4.hasNext()) {
               TileEntity var5 = (TileEntity)var4.next();
               if(var5 instanceof TileEntityEnderPortal) {
                  class_anp.class_b_in_class_anp var6 = this.f.a(this.d, var5.getPosition());
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
            this.d.getChunkAt(var1, var2);
         }
      }

   }

   private void i() {
      HashSet var1 = Sets.newHashSet();
      Iterator var2 = this.d.getPlayers(EntityPlayer.class, b).iterator();

      while(var2.hasNext()) {
         EntityPlayer var3 = (EntityPlayer)var2.next();
         this.c.a(var3);
         var1.add(var3);
      }

      HashSet var5 = Sets.newHashSet((Iterable)this.c.c());
      var5.removeAll(var1);
      Iterator var6 = var5.iterator();

      while(var6.hasNext()) {
         EntityPlayer var4 = (EntityPlayer)var6.next();
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
         this.h += this.d.getEntities((Class)EntityEnderCrystal.class, (AxisAlignedBB)var4.f()).size();
      }

      a.debug("Found {} end crystals still alive", new Object[]{Integer.valueOf(this.h)});
   }

   public void a(EntityEnderDragon var1) {
      if(var1.getUniqueId().equals(this.m)) {
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
      (new class_aqi()).generate(this.d, new Random(), var1);
   }

   private void a(boolean var1) {
      class_aqk var2 = new class_aqk(var1);

      BlockPosition var3;
      for(var3 = this.d.r(class_aqk.a).down(); this.d.getType(var3).getBlock() == Blocks.BEDROCK && var3.getY() > this.d.G(); var3 = var3.down()) {
         ;
      }

      var2.generate(this.d, new Random(), var3);
   }

   private void l() {
      this.d.f(new BlockPosition(0, 128, 0));
      EntityEnderDragon var1 = new EntityEnderDragon(this.d);
      var1.b(0.0D, 128.0D, 0.0D, this.d.random.nextFloat() * 360.0F, 0.0F);
      this.d.addEntity((Entity)var1);
      this.m = var1.getUniqueId();
   }

   public void b(EntityEnderDragon var1) {
      if(var1.getUniqueId().equals(this.m)) {
         this.c.a(var1.getHealth() / var1.getMaxHealth());
         this.g = 0;
      }

   }

   public int c() {
      return this.h;
   }

   public void a(EntityEnderCrystal var1, DamageSource var2) {
      this.j();
      Entity var3 = this.d.getEntityByUUID(this.m);
      if(var3 instanceof EntityEnderDragon) {
         ((EntityEnderDragon)var3).a(new BlockPosition(var1), var2);
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
                        this.d.setTypeUpdate((BlockPosition)var5.d(), (IBlockData)Blocks.END_STONE.getBlockData());
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
      b = Predicates.and(IEntitySelector.IS_ALIVE, IEntitySelector.a(0.0D, 128.0D, 0.0D, 192.0D));
   }
}
