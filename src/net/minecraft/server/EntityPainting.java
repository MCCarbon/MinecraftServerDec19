package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;

public class EntityPainting extends class_uz {
   public EntityPainting.class_a_in_class_vc c;

   public EntityPainting(World var1) {
      super(var1);
   }

   public EntityPainting(World var1, BlockPosition var2, EnumDirection var3) {
      super(var1, var2);
      ArrayList var4 = Lists.newArrayList();
      EntityPainting.class_a_in_class_vc[] var5 = EntityPainting.class_a_in_class_vc.values();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         EntityPainting.class_a_in_class_vc var8 = var5[var7];
         this.c = var8;
         this.a(var3);
         if(this.j()) {
            var4.add(var8);
         }
      }

      if(!var4.isEmpty()) {
         this.c = (EntityPainting.class_a_in_class_vc)var4.get(this.random.nextInt(var4.size()));
      }

      this.a(var3);
   }

   public void write(NBTTagCompound var1) {
      var1.put("Motive", this.c.B);
      super.write(var1);
   }

   public void read(NBTTagCompound var1) {
      String var2 = var1.getString("Motive");
      EntityPainting.class_a_in_class_vc[] var3 = EntityPainting.class_a_in_class_vc.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EntityPainting.class_a_in_class_vc var6 = var3[var5];
         if(var6.B.equals(var2)) {
            this.c = var6;
         }
      }

      if(this.c == null) {
         this.c = EntityPainting.class_a_in_class_vc.a;
      }

      super.read(var1);
   }

   public int l() {
      return this.c.C;
   }

   public int m() {
      return this.c.D;
   }

   public void b(Entity var1) {
      if(this.world.R().getBooleanValue("doEntityDrops")) {
         if(var1 instanceof EntityHuman) {
            EntityHuman var2 = (EntityHuman)var1;
            if(var2.abilities.instabuild) {
               return;
            }
         }

         this.a(new ItemStack(Items.PAINTING), 0.0F);
      }
   }

   public void b(double var1, double var3, double var5, float var7, float var8) {
      BlockPosition var9 = this.a.add(var1 - this.locX, var3 - this.locY, var5 - this.locZ);
      this.setPosition((double)var9.getX(), (double)var9.getY(), (double)var9.getZ());
   }

   public static enum class_a_in_class_vc {
      a("Kebab", 16, 16, 0, 0),
      b("Aztec", 16, 16, 16, 0),
      c("Alban", 16, 16, 32, 0),
      d("Aztec2", 16, 16, 48, 0),
      e("Bomb", 16, 16, 64, 0),
      f("Plant", 16, 16, 80, 0),
      g("Wasteland", 16, 16, 96, 0),
      h("Pool", 32, 16, 0, 32),
      i("Courbet", 32, 16, 32, 32),
      j("Sea", 32, 16, 64, 32),
      k("Sunset", 32, 16, 96, 32),
      l("Creebet", 32, 16, 128, 32),
      m("Wanderer", 16, 32, 0, 64),
      n("Graham", 16, 32, 16, 64),
      o("Match", 32, 32, 0, 128),
      p("Bust", 32, 32, 32, 128),
      q("Stage", 32, 32, 64, 128),
      r("Void", 32, 32, 96, 128),
      s("SkullAndRoses", 32, 32, 128, 128),
      t("Wither", 32, 32, 160, 128),
      u("Fighters", 64, 32, 0, 96),
      v("Pointer", 64, 64, 0, 192),
      w("Pigscene", 64, 64, 64, 192),
      x("BurningSkull", 64, 64, 128, 192),
      y("Skeleton", 64, 48, 192, 64),
      z("DonkeyKong", 64, 48, 192, 112);

      public static final int A;
      public final String B;
      public final int C;
      public final int D;
      public final int E;
      public final int F;

      private class_a_in_class_vc(String var3, int var4, int var5, int var6, int var7) {
         this.B = var3;
         this.C = var4;
         this.D = var5;
         this.E = var6;
         this.F = var7;
      }

      static {
         A = "SkullAndRoses".length();
      }
   }
}
