package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_cy;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pd;
import net.minecraft.server.class_pe;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.Datawathcer;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_qm;
import net.minecraft.server.class_rj;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_ru;
import net.minecraft.server.class_sh;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sw;
import net.minecraft.server.class_sz;
import net.minecraft.server.class_wc;
import net.minecraft.server.class_wi;
import net.minecraft.server.class_wl;
import net.minecraft.server.EntityHuman;

public class class_wb extends class_wi {
   private static final UUID a = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
   private static final class_qm b;
   private static final Set c;
   private static final IBlockData bs;
   private static final int bt;
   private static final int bu;
   private static final int bv;
   private boolean bw;

   public class_wb(World var1) {
      super(var1);
      this.a(0.6F, 2.9F);
      this.S = 1.0F;
      this.i.a(0, new class_rj(this));
      this.i.a(2, new class_ru(this, 1.0D, false));
      this.i.a(7, new class_si(this, 1.0D));
      this.i.a(8, new class_rr(this, EntityHuman.class, 8.0F));
      this.i.a(8, new class_sh(this));
      this.i.a(10, new class_wb.class_a_in_class_wb(this));
      this.i.a(11, new class_wb.class_c_in_class_wb(this));
      this.bn.a(1, new class_sw(this, false, new Class[0]));
      this.bn.a(2, new class_wb.class_b_in_class_wb(this));
      this.bn.a(3, new class_sz(this, class_wc.class, 10, true, false, new Predicate() {
         public boolean a(class_wc var1) {
            return var1.n();
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_wc)var1);
         }
      }));
   }

   private boolean cH() {
      return this.cB() != bs;
   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.a).a(40.0D);
      this.a((class_qk)class_wl.d).a(0.30000001192092896D);
      this.a((class_qk)class_wl.e).a(7.0D);
      this.a((class_qk)class_wl.b).a(64.0D);
   }

   protected void h() {
      super.h();
      this.datawatcher.add(bt, new Short((short)0));
      this.datawatcher.add(bu, new Byte((byte)0));
      this.datawatcher.add(bv, new Byte((byte)0));
   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      IBlockData var2 = this.cB();
      var1.put("carried", (short)Block.getId(var2.getBlock()));
      var1.put("carriedData", (short)var2.getBlock().toLegacyData(var2));
   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      IBlockData var2;
      if(var1.hasOfType("carried", 8)) {
         var2 = Block.getByName(var1.getString("carried")).fromLegacyData(var1.getShort("carriedData") & '\uffff');
      } else {
         var2 = Block.getById(var1.getShort("carried")).fromLegacyData(var1.getShort("carriedData") & '\uffff');
      }

      this.a(var2);
   }

   private boolean a(EntityHuman var1) {
      ItemStack var2 = var1.inventory.b[3];
      if(var2 != null && var2.getItem() == Item.getItemOf(Blocks.PUMPKIN)) {
         return false;
      } else {
         Vec3D var3 = var1.d(1.0F).normalize();
         Vec3D var4 = new Vec3D(this.s - var1.s, this.aT().yMin + (double)(this.K / 2.0F) - (var1.t + (double)var1.aU()), this.u - var1.u);
         double var5 = var4.length();
         var4 = var4.normalize();
         double var7 = var3.dotProduct(var4);
         return var7 > 1.0D - 0.025D / var5?var1.t(this):false;
      }
   }

   public float aU() {
      return 2.55F;
   }

   public void m() {
      if(this.o.isClientSide) {
         for(int var1 = 0; var1 < 2; ++var1) {
            this.o.a(class_cy.y, this.s + (this.random.nextDouble() - 0.5D) * (double)this.J, this.t + this.random.nextDouble() * (double)this.K - 0.25D, this.u + (this.random.nextDouble() - 0.5D) * (double)this.J, (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D, new int[0]);
         }
      }

      this.bb = false;
      super.m();
   }

   protected void cc() {
      if(this.U()) {
         this.damageEntity(class_pc.f, 1.0F);
      }

      if(this.cD() && !this.bw && this.random.nextInt(100) == 0) {
         this.a(false);
      }

      if(this.o.x()) {
         float var1 = this.c(1.0F);
         if(var1 > 0.5F && this.o.i(new BlockPosition(this)) && this.random.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
            this.d((EntityLiving)null);
            this.a(false);
            this.bw = false;
            this.n();
         }
      }

      super.cc();
   }

   protected boolean n() {
      double var1 = this.s + (this.random.nextDouble() - 0.5D) * 64.0D;
      double var3 = this.t + (double)(this.random.nextInt(64) - 32);
      double var5 = this.u + (this.random.nextDouble() - 0.5D) * 64.0D;
      return a(this, var1, var3, var5);
   }

   protected boolean b(Entity var1) {
      Vec3D var2 = new Vec3D(this.s - var1.s, this.aT().yMin + (double)(this.K / 2.0F) - var1.t + (double)var1.aU(), this.u - var1.u);
      var2 = var2.normalize();
      double var3 = 16.0D;
      double var5 = this.s + (this.random.nextDouble() - 0.5D) * 8.0D - var2.x * var3;
      double var7 = this.t + (double)(this.random.nextInt(16) - 8) - var2.y * var3;
      double var9 = this.u + (this.random.nextDouble() - 0.5D) * 8.0D - var2.z * var3;
      return a(this, var5, var7, var9);
   }

   public static boolean a(EntityLiving var0, double var1, double var3, double var5) {
      double var7 = var0.s;
      double var9 = var0.t;
      double var11 = var0.u;
      var0.s = var1;
      var0.t = var3;
      var0.u = var5;
      boolean var13 = false;
      BlockPosition var14 = new BlockPosition(var0);
      World var15 = var0.o;
      Random var16 = var0.bd();
      if(var15.e(var14)) {
         boolean var17 = false;

         while(!var17 && var14.getY() > 0) {
            BlockPosition var18 = var14.down();
            Block var19 = var15.getType(var18).getBlock();
            if(var19.getMaterial().isSolid()) {
               var17 = true;
            } else {
               --var0.t;
               var14 = var18;
            }
         }

         if(var17) {
            var0.a(var0.s, var0.t, var0.u);
            if(var15.a((Entity)var0, (AxisAlignedBB)var0.aT()).isEmpty() && !var15.d(var0.aT())) {
               var13 = true;
            }
         }
      }

      if(!var13) {
         var0.a(var7, var9, var11);
         return false;
      } else {
         short var30 = 128;

         for(int var31 = 0; var31 < var30; ++var31) {
            double var32 = (double)var31 / ((double)var30 - 1.0D);
            float var21 = (var16.nextFloat() - 0.5F) * 0.2F;
            float var22 = (var16.nextFloat() - 0.5F) * 0.2F;
            float var23 = (var16.nextFloat() - 0.5F) * 0.2F;
            double var24 = var7 + (var0.s - var7) * var32 + (var16.nextDouble() - 0.5D) * (double)var0.J * 2.0D;
            double var26 = var9 + (var0.t - var9) * var32 + var16.nextDouble() * (double)var0.K;
            double var28 = var11 + (var0.u - var11) * var32 + (var16.nextDouble() - 0.5D) * (double)var0.J * 2.0D;
            var15.a(class_cy.y, var24, var26, var28, (double)var21, (double)var22, (double)var23, new int[0]);
         }

         var15.a(var7, var9, var11, "mob.endermen.portal", 1.0F, 1.0F);
         var0.a("mob.endermen.portal", 1.0F, 1.0F);
         return true;
      }
   }

   protected String C() {
      return this.cD()?"mob.endermen.scream":"mob.endermen.idle";
   }

   protected String bp() {
      return "mob.endermen.hit";
   }

   protected String bq() {
      return "mob.endermen.death";
   }

   protected Item D() {
      return Items.bw;
   }

   protected void b(boolean var1, int var2) {
      Item var3 = this.D();
      if(var3 != null) {
         int var4 = this.random.nextInt(2 + var2);

         for(int var5 = 0; var5 < var4; ++var5) {
            this.a(var3, 1);
         }
      }

      IBlockData var6 = this.cB();
      if(var6 != bs) {
         this.a(new ItemStack(var6.getBlock(), 1, var6.getBlock().toLegacyData(var6)), 0.0F);
      }

   }

   public void a(IBlockData var1) {
      this.datawatcher.update(bt, Short.valueOf((short)(Block.getCombinedId(var1) & '\uffff')));
   }

   public IBlockData cB() {
      return Block.getByCombinedId(this.datawatcher.getShort(bt) & '\uffff');
   }

   public boolean damageEntity(class_pc var1, float var2) {
      if(this.b((class_pc)var1)) {
         return false;
      } else {
         if(var1.j() == null || !(var1.j() instanceof class_wc)) {
            if(!this.o.isClientSide) {
               this.a(true);
            }

            if(var1 instanceof class_pd && var1.j() instanceof EntityHuman) {
               if(var1.j() instanceof EntityPlayer && ((EntityPlayer)var1.j()).playerInteractManager.d()) {
                  this.a(false);
               } else {
                  this.bw = true;
               }
            }

            if(var1 instanceof class_pe) {
               this.bw = false;

               for(int var4 = 0; var4 < 64; ++var4) {
                  if(this.n()) {
                     return true;
                  }
               }

               return false;
            }
         }

         boolean var3 = super.damageEntity(var1, var2);
         if(var1.e() && this.random.nextInt(10) != 0) {
            this.n();
         }

         return var3;
      }
   }

   public boolean cD() {
      return this.datawatcher.getByte(bv) > 0;
   }

   public void a(boolean var1) {
      this.datawatcher.update(bv, Byte.valueOf((byte)(var1?1:0)));
   }

   static {
      b = (new class_qm(a, "Attacking speed boost", 0.15000000596046448D, 0)).a(false);
      c = Sets.newIdentityHashSet();
      bs = Blocks.AIR.getBlockData();
      c.add(Blocks.GRASS);
      c.add(Blocks.DIRT);
      c.add(Blocks.SAND);
      c.add(Blocks.GRAVEL);
      c.add(Blocks.YELLOW_FLOWER);
      c.add(Blocks.RED_FLOWER);
      c.add(Blocks.BROWN_MUSHROOM);
      c.add(Blocks.RED_MUSHROOM);
      c.add(Blocks.TNT);
      c.add(Blocks.CACTUS);
      c.add(Blocks.CLAY);
      c.add(Blocks.PUMPKIN);
      c.add(Blocks.MELON_BLOCK);
      c.add(Blocks.MYCELIM);
      bt = Datawathcer.claimId(class_wb.class);
      bu = Datawathcer.claimId(class_wb.class);
      bv = Datawathcer.claimId(class_wb.class);
   }

   static class class_c_in_class_wb extends class_rm {
      private class_wb a;

      public class_c_in_class_wb(class_wb var1) {
         this.a = var1;
      }

      public boolean a() {
         return this.a.cH()?false:(!this.a.o.R().b("mobGriefing")?false:this.a.bd().nextInt(20) == 0);
      }

      public void e() {
         Random var1 = this.a.bd();
         World var2 = this.a.o;
         int var3 = MathHelper.floor(this.a.s - 2.0D + var1.nextDouble() * 4.0D);
         int var4 = MathHelper.floor(this.a.t + var1.nextDouble() * 3.0D);
         int var5 = MathHelper.floor(this.a.u - 2.0D + var1.nextDouble() * 4.0D);
         BlockPosition var6 = new BlockPosition(var3, var4, var5);
         IBlockData var7 = var2.getType(var6);
         Block var8 = var7.getBlock();
         if(class_wb.c.contains(var8)) {
            this.a.a(var7);
            var2.setTypeUpdate(var6, class_wb.bs);
         }

      }
   }

   static class class_a_in_class_wb extends class_rm {
      private class_wb a;

      public class_a_in_class_wb(class_wb var1) {
         this.a = var1;
      }

      public boolean a() {
         return !this.a.cH()?false:(!this.a.o.R().b("mobGriefing")?false:this.a.bd().nextInt(2000) == 0);
      }

      public void e() {
         Random var1 = this.a.bd();
         World var2 = this.a.o;
         int var3 = MathHelper.floor(this.a.s - 1.0D + var1.nextDouble() * 2.0D);
         int var4 = MathHelper.floor(this.a.t + var1.nextDouble() * 2.0D);
         int var5 = MathHelper.floor(this.a.u - 1.0D + var1.nextDouble() * 2.0D);
         BlockPosition var6 = new BlockPosition(var3, var4, var5);
         Block var7 = var2.getType(var6).getBlock();
         Block var8 = var2.getType(var6.down()).getBlock();
         if(this.a(var2, var6, this.a.cB().getBlock(), var7, var8)) {
            var2.setTypeAndData((BlockPosition)var6, (IBlockData)this.a.cB(), 3);
            this.a.a(class_wb.bs);
         }

      }

      private boolean a(World var1, BlockPosition var2, Block var3, Block var4, Block var5) {
         return !var3.canPlace(var1, var2)?false:(var4.getMaterial() != Material.AIR?false:(var5.getMaterial() == Material.AIR?false:var5.isFullCube()));
      }
   }

   static class class_b_in_class_wb extends class_sz {
      private EntityHuman g;
      private int h;
      private int i;
      private class_wb j;

      public class_b_in_class_wb(class_wb var1) {
         super(var1, EntityHuman.class, true);
         this.j = var1;
      }

      public boolean a() {
         double var1 = this.f();
         List var3 = this.e.o.a(EntityHuman.class, this.e.aT().grow(var1, 4.0D, var1), this.c);
         Collections.sort(var3, this.b);
         if(var3.isEmpty()) {
            return false;
         } else {
            this.g = (EntityHuman)var3.get(0);
            return true;
         }
      }

      public void c() {
         this.h = 5;
         this.i = 0;
      }

      public void d() {
         this.g = null;
         this.j.a(false);
         class_ql var1 = this.j.a((class_qk)class_wl.d);
         var1.c(class_wb.b);
         super.d();
      }

      public boolean b() {
         if(this.g != null) {
            if(!this.j.a(this.g)) {
               return false;
            } else {
               this.j.bw = true;
               this.j.a(this.g, 10.0F, 10.0F);
               return true;
            }
         } else {
            return super.b();
         }
      }

      public void e() {
         if(this.g != null) {
            if(--this.h <= 0) {
               this.d = this.g;
               this.g = null;
               super.c();
               this.j.a("mob.endermen.stare", 1.0F, 1.0F);
               this.j.a(true);
               class_ql var1 = this.j.a((class_qk)class_wl.d);
               var1.b(class_wb.b);
            }
         } else {
            if(this.d != null) {
               if(this.d instanceof EntityHuman && this.j.a((EntityHuman)this.d)) {
                  if(this.d.h(this.j) < 16.0D) {
                     this.j.n();
                  }

                  this.i = 0;
               } else if(this.d.h(this.j) > 256.0D && this.i++ >= 30 && this.j.b((Entity)this.d)) {
                  this.i = 0;
               }
            }

            super.e();
         }

      }
   }
}
