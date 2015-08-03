package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_adi;
import net.minecraft.server.EnchantmentManager;
import net.minecraft.server.class_adl;
import net.minecraft.server.class_adz;
import net.minecraft.server.class_aea;
import net.minecraft.server.class_aeb;
import net.minecraft.server.World;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.StatisticList;
import net.minecraft.server.MathHelper;
import net.minecraft.server.Tuple;
import net.minecraft.server.class_on;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_ow;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.class_po;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityExperienceOrb;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_rb;
import net.minecraft.server.class_rj;
import net.minecraft.server.class_ro;
import net.minecraft.server.class_rp;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_rs;
import net.minecraft.server.class_rt;
import net.minecraft.server.class_rv;
import net.minecraft.server.class_ry;
import net.minecraft.server.class_sd;
import net.minecraft.server.class_sf;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sl;
import net.minecraft.server.class_sq;
import net.minecraft.server.class_ss;
import net.minecraft.server.class_st;
import net.minecraft.server.class_tf;
import net.minecraft.server.class_tp;
import net.minecraft.server.class_vi;
import net.minecraft.server.EntityItem;
import net.minecraft.server.class_wd;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_wq;
import net.minecraft.server.class_wr;
import net.minecraft.server.class_wu;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EnumColor;

public class class_wv extends class_po implements class_adz, class_wu {
   private static final int bt = class_qi.a(class_wv.class);
   private int bu;
   private boolean bv;
   private boolean bw;
   class_tp bs;
   private EntityHuman bx;
   private class_aeb by;
   private int bz;
   private boolean bA;
   private boolean bB;
   private int bC;
   private String bD;
   private int bE;
   private int bF;
   private boolean bG;
   private boolean bH;
   private class_ow bI;
   private static final class_wv.class_f_in_class_wv[][][][] bJ;

   public class_wv(World var1) {
      this(var1, 0);
   }

   public class_wv(World var1, int var2) {
      super(var1);
      this.bI = new class_ow("Items", false, 8);
      this.m(var2);
      this.a(0.6F, 1.8F);
      ((class_tf)this.u()).b(true);
      ((class_tf)this.u()).a(true);
      this.i.a(0, new class_rj(this));
      this.i.a(1, new class_rb(this, class_wr.class, 8.0F, 0.6D, 0.6D));
      this.i.a(1, new class_ss(this));
      this.i.a(1, new class_rs(this));
      this.i.a(2, new class_rv(this));
      this.i.a(3, new class_sl(this));
      this.i.a(4, new class_sd(this, true));
      this.i.a(5, new class_ry(this, 0.6D));
      this.i.a(6, new class_rt(this));
      this.i.a(7, new class_sq(this));
      this.i.a(9, new class_rp(this, EntityHuman.class, 3.0F, 1.0F));
      this.i.a(9, new class_st(this));
      this.i.a(9, new class_si(this, 0.6D));
      this.i.a(10, new class_rr(this, class_qb.class, 8.0F));
      this.j(true);
   }

   private void cK() {
      if(!this.bH) {
         this.bH = true;
         if(this.j_()) {
            this.i.a(8, new class_sf(this, 0.32D));
         } else if(this.cA() == 0) {
            this.i.a(6, new class_ro(this, 0.6D));
         }

      }
   }

   protected void n() {
      if(this.cA() == 0) {
         this.i.a(8, new class_ro(this, 0.6D));
      }

      super.n();
   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.d).a(0.5D);
   }

   protected void cc() {
      if(--this.bu <= 0) {
         BlockPosition var1 = new BlockPosition(this);
         this.o.af().a(var1);
         this.bu = 70 + this.V.nextInt(50);
         this.bs = this.o.af().a(var1, 32);
         if(this.bs == null) {
            this.cy();
         } else {
            BlockPosition var2 = this.bs.a();
            this.a(var2, (int)((float)this.bs.b() * 1.0F));
            if(this.bG) {
               this.bG = false;
               this.bs.b(5);
            }
         }
      }

      if(!this.cD() && this.bz > 0) {
         --this.bz;
         if(this.bz <= 0) {
            if(this.bA) {
               Iterator var3 = this.by.iterator();

               while(var3.hasNext()) {
                  class_aea var4 = (class_aea)var3.next();
                  if(var4.h()) {
                     var4.a(this.V.nextInt(6) + this.V.nextInt(6) + 2);
                  }
               }

               this.cL();
               this.bA = false;
               if(this.bs != null && this.bD != null) {
                  this.o.a((Entity)this, (byte)14);
                  this.bs.a(this.bD, 1);
               }
            }

            this.c(new class_pl(class_pm.j, 200, 0));
         }
      }

      super.cc();
   }

   public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
      boolean var4 = var3 != null && var3.getItem() == Items.bM;
      if(!var4 && this.ai() && !this.cD() && !this.j_()) {
         if(!this.o.isClientSide && (this.by == null || !this.by.isEmpty())) {
            this.a(var1);
            var1.a((class_adz)this);
         }

         var1.b(StatisticList.F);
         return true;
      } else {
         return super.a(var1, var2, var3);
      }
   }

   protected void h() {
      super.h();
      this.ac.a(bt, Integer.valueOf(0));
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.put("Profession", this.cA());
      var1.put("Riches", this.bC);
      var1.put("Career", this.bE);
      var1.put("CareerLevel", this.bF);
      var1.put("Willing", this.bB);
      if(this.by != null) {
         var1.put((String)"Offers", (NBTTag)this.by.a());
      }

      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.bI.getSize(); ++var3) {
         ItemStack var4 = this.bI.getItem(var3);
         if(var4 != null) {
            var2.add((NBTTag)var4.write(new NBTTagCompound()));
         }
      }

      var1.put((String)"Inventory", (NBTTag)var2);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.m(var1.getInt("Profession"));
      this.bC = var1.getInt("Riches");
      this.bE = var1.getInt("Career");
      this.bF = var1.getInt("CareerLevel");
      this.bB = var1.getBoolean("Willing");
      if(var1.hasOfType("Offers", 10)) {
         NBTTagCompound var2 = var1.getCompound("Offers");
         this.by = new class_aeb(var2);
      }

      NBTTagList var5 = var1.getList("Inventory", 10);

      for(int var3 = 0; var3 < var5.getSize(); ++var3) {
         ItemStack var4 = ItemStack.a(var5.getCompound(var3));
         if(var4 != null) {
            this.bI.a(var4);
         }
      }

      this.j(true);
      this.cK();
   }

   protected boolean E() {
      return false;
   }

   protected String C() {
      return this.cD()?"mob.villager.haggle":"mob.villager.idle";
   }

   protected String bp() {
      return "mob.villager.hit";
   }

   protected String bq() {
      return "mob.villager.death";
   }

   public void m(int var1) {
      this.ac.b(bt, Integer.valueOf(var1));
   }

   public int cA() {
      return Math.max(this.ac.c(bt) % 5, 0);
   }

   public boolean cB() {
      return this.bv;
   }

   public void m(boolean var1) {
      this.bv = var1;
   }

   public void n(boolean var1) {
      this.bw = var1;
   }

   public boolean cC() {
      return this.bw;
   }

   public void b(EntityLiving var1) {
      super.b(var1);
      if(this.bs != null && var1 != null) {
         this.bs.a(var1);
         if(var1 instanceof EntityHuman) {
            byte var2 = -1;
            if(this.j_()) {
               var2 = -3;
            }

            this.bs.a(var1.getName(), var2);
            if(this.ai()) {
               this.o.a((Entity)this, (byte)13);
            }
         }
      }

   }

   public void a(class_pc var1) {
      if(this.bs != null) {
         Entity var2 = var1.j();
         if(var2 != null) {
            if(var2 instanceof EntityHuman) {
               this.bs.a(var2.getName(), -2);
            } else if(var2 instanceof class_wd) {
               this.bs.h();
            }
         } else {
            EntityHuman var3 = this.o.a(this, 16.0D);
            if(var3 != null) {
               this.bs.h();
            }
         }
      }

      super.a((class_pc)var1);
   }

   public void a(EntityHuman var1) {
      this.bx = var1;
   }

   public EntityHuman v_() {
      return this.bx;
   }

   public boolean cD() {
      return this.bx != null;
   }

   public boolean o(boolean var1) {
      if(!this.bB && var1 && this.cG()) {
         boolean var2 = false;

         for(int var3 = 0; var3 < this.bI.getSize(); ++var3) {
            ItemStack var4 = this.bI.getItem(var3);
            if(var4 != null) {
               if(var4.getItem() == Items.R && var4.count >= 3) {
                  var2 = true;
                  this.bI.splitStack(var3, 3);
               } else if((var4.getItem() == Items.bV || var4.getItem() == Items.bU) && var4.count >= 12) {
                  var2 = true;
                  this.bI.splitStack(var3, 12);
               }
            }

            if(var2) {
               this.o.a((Entity)this, (byte)18);
               this.bB = true;
               break;
            }
         }
      }

      return this.bB;
   }

   public void p(boolean var1) {
      this.bB = var1;
   }

   public void a(class_aea var1) {
      var1.g();
      this.a_ = -this.y();
      this.a("mob.villager.yes", this.bC(), this.bD());
      int var2 = 3 + this.V.nextInt(4);
      if(var1.e() == 1 || this.V.nextInt(5) == 0) {
         this.bz = 40;
         this.bA = true;
         this.bB = true;
         if(this.bx != null) {
            this.bD = this.bx.getName();
         } else {
            this.bD = null;
         }

         var2 += 5;
      }

      if(var1.a().getItem() == Items.bR) {
         this.bC += var1.a().count;
      }

      if(var1.j()) {
         this.o.addEntity((Entity)(new EntityExperienceOrb(this.o, this.s, this.t + 0.5D, this.u, var2)));
      }

   }

   public void a_(ItemStack var1) {
      if(!this.o.isClientSide && this.a_ > -this.y() + 20) {
         this.a_ = -this.y();
         if(var1 != null) {
            this.a("mob.villager.yes", this.bC(), this.bD());
         } else {
            this.a("mob.villager.no", this.bC(), this.bD());
         }
      }

   }

   public class_aeb a_(EntityHuman var1) {
      if(this.by == null) {
         this.cL();
      }

      return this.by;
   }

   private void cL() {
      class_wv.class_f_in_class_wv[][][] var1 = bJ[this.cA()];
      if(this.bE != 0 && this.bF != 0) {
         ++this.bF;
      } else {
         this.bE = this.V.nextInt(var1.length) + 1;
         this.bF = 1;
      }

      if(this.by == null) {
         this.by = new class_aeb();
      }

      int var2 = this.bE - 1;
      int var3 = this.bF - 1;
      class_wv.class_f_in_class_wv[][] var4 = var1[var2];
      if(var3 >= 0 && var3 < var4.length) {
         class_wv.class_f_in_class_wv[] var5 = var4[var3];
         class_wv.class_f_in_class_wv[] var6 = var5;
         int var7 = var5.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            class_wv.class_f_in_class_wv var9 = var6[var8];
            var9.a(this.by, this.V);
         }
      }

   }

   public IChatBaseComponent getScoreboardDisplayName() {
      String var1 = this.aO();
      if(var1 != null && !var1.isEmpty()) {
         ChatComponentText var4 = new ChatComponentText(var1);
         var4.b().a(this.aS());
         var4.b().a(this.aM().toString());
         return var4;
      } else {
         if(this.by == null) {
            this.cL();
         }

         String var2 = null;
         switch(this.cA()) {
         case 0:
            if(this.bE == 1) {
               var2 = "farmer";
            } else if(this.bE == 2) {
               var2 = "fisherman";
            } else if(this.bE == 3) {
               var2 = "shepherd";
            } else if(this.bE == 4) {
               var2 = "fletcher";
            }
            break;
         case 1:
            var2 = "librarian";
            break;
         case 2:
            var2 = "cleric";
            break;
         case 3:
            if(this.bE == 1) {
               var2 = "armor";
            } else if(this.bE == 2) {
               var2 = "weapon";
            } else if(this.bE == 3) {
               var2 = "tool";
            }
            break;
         case 4:
            if(this.bE == 1) {
               var2 = "butcher";
            } else if(this.bE == 2) {
               var2 = "leather";
            }
         }

         if(var2 != null) {
            ChatMessage var3 = new ChatMessage("entity.Villager." + var2, new Object[0]);
            var3.b().a(this.aS());
            var3.b().a(this.aM().toString());
            return var3;
         } else {
            return super.getScoreboardDisplayName();
         }
      }
   }

   public float aU() {
      float var1 = 1.62F;
      if(this.j_()) {
         var1 = (float)((double)var1 - 0.81D);
      }

      return var1;
   }

   public class_qd a(class_on var1, class_qd var2) {
      var2 = super.a(var1, var2);
      this.m(this.o.random.nextInt(5));
      this.cK();
      return var2;
   }

   public void cE() {
      this.bG = true;
   }

   public class_wv b(class_po var1) {
      class_wv var2 = new class_wv(this.o);
      var2.a(this.o.E(new BlockPosition(var2)), (class_qd)null);
      return var2;
   }

   public boolean cp() {
      return false;
   }

   public void a(class_vi var1) {
      if(!this.o.isClientSide && !this.I) {
         class_wq var2 = new class_wq(this.o);
         var2.b(this.s, this.t, this.u, this.y, this.z);
         var2.a(this.o.E(new BlockPosition(var2)), (class_qd)null);
         var2.k(this.cs());
         if(this.hasCustomName()) {
            var2.a(this.aO());
            var2.g(this.aP());
         }

         this.o.addEntity((Entity)var2);
         this.J();
      }
   }

   public class_ow cF() {
      return this.bI;
   }

   protected void a(EntityItem var1) {
      ItemStack var2 = var1.l();
      Item var3 = var2.getItem();
      if(this.a(var3)) {
         ItemStack var4 = this.bI.a(var2);
         if(var4 == null) {
            var1.J();
         } else {
            var2.count = var4.count;
         }
      }

   }

   private boolean a(Item var1) {
      return var1 == Items.R || var1 == Items.bV || var1 == Items.bU || var1 == Items.Q || var1 == Items.P;
   }

   public boolean cG() {
      return this.n(1);
   }

   public boolean cH() {
      return this.n(2);
   }

   public boolean cI() {
      boolean var1 = this.cA() == 0;
      return var1?!this.n(5):!this.n(1);
   }

   private boolean n(int var1) {
      boolean var2 = this.cA() == 0;

      for(int var3 = 0; var3 < this.bI.getSize(); ++var3) {
         ItemStack var4 = this.bI.getItem(var3);
         if(var4 != null) {
            if(var4.getItem() == Items.R && var4.count >= 3 * var1 || var4.getItem() == Items.bV && var4.count >= 12 * var1 || var4.getItem() == Items.bU && var4.count >= 12 * var1) {
               return true;
            }

            if(var2 && var4.getItem() == Items.Q && var4.count >= 9 * var1) {
               return true;
            }
         }
      }

      return false;
   }

   public boolean cJ() {
      for(int var1 = 0; var1 < this.bI.getSize(); ++var1) {
         ItemStack var2 = this.bI.getItem(var1);
         if(var2 != null && (var2.getItem() == Items.P || var2.getItem() == Items.bV || var2.getItem() == Items.bU)) {
            return true;
         }
      }

      return false;
   }

   public boolean c(int var1, ItemStack var2) {
      if(super.c(var1, var2)) {
         return true;
      } else {
         int var3 = var1 - 300;
         if(var3 >= 0 && var3 < this.bI.getSize()) {
            this.bI.setItem(var3, var2);
            return true;
         } else {
            return false;
         }
      }
   }

   // $FF: synthetic method
   public class_po a(class_po var1) {
      return this.b(var1);
   }

   static {
      bJ = new class_wv.class_f_in_class_wv[][][][]{{{{new class_wv.class_a_in_class_wv(Items.Q, new class_wv.class_g_in_class_wv(18, 22)), new class_wv.class_a_in_class_wv(Items.bV, new class_wv.class_g_in_class_wv(15, 19)), new class_wv.class_a_in_class_wv(Items.bU, new class_wv.class_g_in_class_wv(15, 19)), new class_wv.class_e_in_class_wv(Items.R, new class_wv.class_g_in_class_wv(-4, -2))}, {new class_wv.class_a_in_class_wv(Item.getItemOf(BlockStainedGlassPane.PUMPKIN), new class_wv.class_g_in_class_wv(8, 13)), new class_wv.class_e_in_class_wv(Items.cd, new class_wv.class_g_in_class_wv(-3, -2))}, {new class_wv.class_a_in_class_wv(Item.getItemOf(BlockStainedGlassPane.MELON_BLOCK), new class_wv.class_g_in_class_wv(7, 12)), new class_wv.class_e_in_class_wv(Items.APPLE, new class_wv.class_g_in_class_wv(-5, -7))}, {new class_wv.class_e_in_class_wv(Items.be, new class_wv.class_g_in_class_wv(-6, -10)), new class_wv.class_e_in_class_wv(Items.bb, new class_wv.class_g_in_class_wv(1, 1))}}, {{new class_wv.class_a_in_class_wv(Items.H, new class_wv.class_g_in_class_wv(15, 20)), new class_wv.class_a_in_class_wv(Items.COAL, new class_wv.class_g_in_class_wv(16, 24)), new class_wv.class_d_in_class_wv(Items.aW, new class_wv.class_g_in_class_wv(6, 6), Items.aX, new class_wv.class_g_in_class_wv(6, 6))}, {new class_wv.class_c_in_class_wv(Items.aT, new class_wv.class_g_in_class_wv(7, 8))}}, {{new class_wv.class_a_in_class_wv(Item.getItemOf(BlockStainedGlassPane.WOOL), new class_wv.class_g_in_class_wv(16, 22)), new class_wv.class_e_in_class_wv(Items.bg, new class_wv.class_g_in_class_wv(3, 4))}, {new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL)), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 1), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 2), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 3), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 4), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 5), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 6), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 7), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 8), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 9), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 10), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 11), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 12), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 13), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 14), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new ItemStack(Item.getItemOf(BlockStainedGlassPane.WOOL), 1, 15), new class_wv.class_g_in_class_wv(1, 2))}}, {{new class_wv.class_a_in_class_wv(Items.H, new class_wv.class_g_in_class_wv(15, 20)), new class_wv.class_e_in_class_wv(Items.ARROW, new class_wv.class_g_in_class_wv(-12, -8))}, {new class_wv.class_e_in_class_wv(Items.BOW, new class_wv.class_g_in_class_wv(2, 3)), new class_wv.class_d_in_class_wv(Item.getItemOf(BlockStainedGlassPane.GRAVEL), new class_wv.class_g_in_class_wv(10, 10), Items.am, new class_wv.class_g_in_class_wv(6, 10))}}}, {{{new class_wv.class_a_in_class_wv(Items.aM, new class_wv.class_g_in_class_wv(24, 36)), new class_wv.class_b_in_class_wv()}, {new class_wv.class_a_in_class_wv(Items.aN, new class_wv.class_g_in_class_wv(8, 10)), new class_wv.class_e_in_class_wv(Items.aS, new class_wv.class_g_in_class_wv(10, 12)), new class_wv.class_e_in_class_wv(Item.getItemOf(BlockStainedGlassPane.BOOKSHELF), new class_wv.class_g_in_class_wv(3, 4))}, {new class_wv.class_a_in_class_wv(Items.bQ, new class_wv.class_g_in_class_wv(2, 2)), new class_wv.class_e_in_class_wv(Items.aU, new class_wv.class_g_in_class_wv(10, 12)), new class_wv.class_e_in_class_wv(Item.getItemOf(BlockStainedGlassPane.GLASS), new class_wv.class_g_in_class_wv(-5, -3))}, {new class_wv.class_b_in_class_wv()}, {new class_wv.class_b_in_class_wv()}, {new class_wv.class_e_in_class_wv(Items.cr, new class_wv.class_g_in_class_wv(20, 22))}}}, {{{new class_wv.class_a_in_class_wv(Items.bv, new class_wv.class_g_in_class_wv(36, 40)), new class_wv.class_a_in_class_wv(Items.GOLD_INGOT, new class_wv.class_g_in_class_wv(8, 10))}, {new class_wv.class_e_in_class_wv(Items.aE, new class_wv.class_g_in_class_wv(-4, -1)), new class_wv.class_e_in_class_wv(new ItemStack(Items.aY, 1, EnumColor.l.b()), new class_wv.class_g_in_class_wv(-2, -1))}, {new class_wv.class_e_in_class_wv(Items.bK, new class_wv.class_g_in_class_wv(7, 11)), new class_wv.class_e_in_class_wv(Item.getItemOf(BlockStainedGlassPane.GLOWSTONE), new class_wv.class_g_in_class_wv(-3, -1))}, {new class_wv.class_e_in_class_wv(Items.bN, new class_wv.class_g_in_class_wv(3, 11))}}}, {{{new class_wv.class_a_in_class_wv(Items.COAL, new class_wv.class_g_in_class_wv(16, 24)), new class_wv.class_e_in_class_wv(Items.aa, new class_wv.class_g_in_class_wv(4, 6))}, {new class_wv.class_a_in_class_wv(Items.IRON_INGOT, new class_wv.class_g_in_class_wv(7, 9)), new class_wv.class_e_in_class_wv(Items.ab, new class_wv.class_g_in_class_wv(10, 14))}, {new class_wv.class_a_in_class_wv(Items.DIAMOND, new class_wv.class_g_in_class_wv(3, 4)), new class_wv.class_c_in_class_wv(Items.af, new class_wv.class_g_in_class_wv(16, 19))}, {new class_wv.class_e_in_class_wv(Items.Z, new class_wv.class_g_in_class_wv(5, 7)), new class_wv.class_e_in_class_wv(Items.Y, new class_wv.class_g_in_class_wv(9, 11)), new class_wv.class_e_in_class_wv(Items.W, new class_wv.class_g_in_class_wv(5, 7)), new class_wv.class_e_in_class_wv(Items.X, new class_wv.class_g_in_class_wv(11, 15))}}, {{new class_wv.class_a_in_class_wv(Items.COAL, new class_wv.class_g_in_class_wv(16, 24)), new class_wv.class_e_in_class_wv(Items.IRON_AXE, new class_wv.class_g_in_class_wv(6, 8))}, {new class_wv.class_a_in_class_wv(Items.IRON_INGOT, new class_wv.class_g_in_class_wv(7, 9)), new class_wv.class_c_in_class_wv(Items.IRON_SWORD, new class_wv.class_g_in_class_wv(9, 10))}, {new class_wv.class_a_in_class_wv(Items.DIAMOND, new class_wv.class_g_in_class_wv(3, 4)), new class_wv.class_c_in_class_wv(Items.DIAMOND_SWORD, new class_wv.class_g_in_class_wv(12, 15)), new class_wv.class_c_in_class_wv(Items.DIAMOND_AXE, new class_wv.class_g_in_class_wv(9, 12))}}, {{new class_wv.class_a_in_class_wv(Items.COAL, new class_wv.class_g_in_class_wv(16, 24)), new class_wv.class_c_in_class_wv(Items.IRON_SHOVEL, new class_wv.class_g_in_class_wv(5, 7))}, {new class_wv.class_a_in_class_wv(Items.IRON_INGOT, new class_wv.class_g_in_class_wv(7, 9)), new class_wv.class_c_in_class_wv(Items.IRON_PICKAXE, new class_wv.class_g_in_class_wv(9, 11))}, {new class_wv.class_a_in_class_wv(Items.DIAMOND, new class_wv.class_g_in_class_wv(3, 4)), new class_wv.class_c_in_class_wv(Items.DIAMOND_PICKAXE, new class_wv.class_g_in_class_wv(12, 15))}}}, {{{new class_wv.class_a_in_class_wv(Items.an, new class_wv.class_g_in_class_wv(14, 18)), new class_wv.class_a_in_class_wv(Items.bm, new class_wv.class_g_in_class_wv(14, 18))}, {new class_wv.class_a_in_class_wv(Items.COAL, new class_wv.class_g_in_class_wv(16, 24)), new class_wv.class_e_in_class_wv(Items.ao, new class_wv.class_g_in_class_wv(-7, -5)), new class_wv.class_e_in_class_wv(Items.bn, new class_wv.class_g_in_class_wv(-8, -6))}}, {{new class_wv.class_a_in_class_wv(Items.aH, new class_wv.class_g_in_class_wv(9, 12)), new class_wv.class_e_in_class_wv(Items.U, new class_wv.class_g_in_class_wv(2, 4))}, {new class_wv.class_c_in_class_wv(Items.T, new class_wv.class_g_in_class_wv(7, 12))}, {new class_wv.class_e_in_class_wv(Items.aC, new class_wv.class_g_in_class_wv(8, 10))}}}};
   }

   static class class_d_in_class_wv implements class_wv.class_f_in_class_wv {
      public ItemStack a;
      public class_wv.class_g_in_class_wv b;
      public ItemStack c;
      public class_wv.class_g_in_class_wv d;

      public class_d_in_class_wv(Item var1, class_wv.class_g_in_class_wv var2, Item var3, class_wv.class_g_in_class_wv var4) {
         this.a = new ItemStack(var1);
         this.b = var2;
         this.c = new ItemStack(var3);
         this.d = var4;
      }

      public void a(class_aeb var1, Random var2) {
         int var3 = 1;
         if(this.b != null) {
            var3 = this.b.a(var2);
         }

         int var4 = 1;
         if(this.d != null) {
            var4 = this.d.a(var2);
         }

         var1.add(new class_aea(new ItemStack(this.a.getItem(), var3, this.a.i()), new ItemStack(Items.bR), new ItemStack(this.c.getItem(), var4, this.c.i())));
      }
   }

   static class class_b_in_class_wv implements class_wv.class_f_in_class_wv {
      public void a(class_aeb var1, Random var2) {
         class_adi var3 = (class_adi)class_adi.b.get(var2);
         int var4 = MathHelper.getRandomIntInRange(var2, var3.d(), var3.b());
         ItemStack var5 = Items.cg.a(new class_adl(var3, var4));
         int var6 = 2 + var2.nextInt(5 + var4 * 10) + 3 * var4;
         if(var6 > 64) {
            var6 = 64;
         }

         var1.add(new class_aea(new ItemStack(Items.aN), new ItemStack(Items.bR, var6), var5));
      }
   }

   static class class_c_in_class_wv implements class_wv.class_f_in_class_wv {
      public ItemStack a;
      public class_wv.class_g_in_class_wv b;

      public class_c_in_class_wv(Item var1, class_wv.class_g_in_class_wv var2) {
         this.a = new ItemStack(var1);
         this.b = var2;
      }

      public void a(class_aeb var1, Random var2) {
         int var3 = 1;
         if(this.b != null) {
            var3 = this.b.a(var2);
         }

         ItemStack var4 = new ItemStack(Items.bR, var3, 0);
         ItemStack var5 = new ItemStack(this.a.getItem(), 1, this.a.i());
         var5 = EnchantmentManager.a(var2, var5, 5 + var2.nextInt(15));
         var1.add(new class_aea(var4, var5));
      }
   }

   static class class_e_in_class_wv implements class_wv.class_f_in_class_wv {
      public ItemStack a;
      public class_wv.class_g_in_class_wv b;

      public class_e_in_class_wv(Item var1, class_wv.class_g_in_class_wv var2) {
         this.a = new ItemStack(var1);
         this.b = var2;
      }

      public class_e_in_class_wv(ItemStack var1, class_wv.class_g_in_class_wv var2) {
         this.a = var1;
         this.b = var2;
      }

      public void a(class_aeb var1, Random var2) {
         int var3 = 1;
         if(this.b != null) {
            var3 = this.b.a(var2);
         }

         ItemStack var4;
         ItemStack var5;
         if(var3 < 0) {
            var4 = new ItemStack(Items.bR);
            var5 = new ItemStack(this.a.getItem(), -var3, this.a.i());
         } else {
            var4 = new ItemStack(Items.bR, var3, 0);
            var5 = new ItemStack(this.a.getItem(), 1, this.a.i());
         }

         var1.add(new class_aea(var4, var5));
      }
   }

   static class class_a_in_class_wv implements class_wv.class_f_in_class_wv {
      public Item a;
      public class_wv.class_g_in_class_wv b;

      public class_a_in_class_wv(Item var1, class_wv.class_g_in_class_wv var2) {
         this.a = var1;
         this.b = var2;
      }

      public void a(class_aeb var1, Random var2) {
         int var3 = 1;
         if(this.b != null) {
            var3 = this.b.a(var2);
         }

         var1.add(new class_aea(new ItemStack(this.a, var3, 0), Items.bR));
      }
   }

   interface class_f_in_class_wv {
      void a(class_aeb var1, Random var2);
   }

   static class class_g_in_class_wv extends Tuple {
      public class_g_in_class_wv(int var1, int var2) {
         super(Integer.valueOf(var1), Integer.valueOf(var2));
      }

      public int a(Random var1) {
         return ((Integer)this.getObject1()).intValue() >= ((Integer)this.getObject2()).intValue()?((Integer)this.getObject1()).intValue():((Integer)this.getObject1()).intValue() + var1.nextInt(((Integer)this.getObject2()).intValue() - ((Integer)this.getObject1()).intValue() + 1);
      }
   }
}
