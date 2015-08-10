package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_lb {
   private static final Logger a = LogManager.getLogger();
   private final WorldServer b;
   private Set c = Sets.newHashSet();
   private IntHashMap d = new IntHashMap();
   private int e;

   public class_lb(WorldServer var1) {
      this.b = var1;
      this.e = var1.s().getPlayerList().d();
   }

   public void a(Entity var1) {
      if(var1 instanceof EntityPlayer) {
         this.a(var1, 512, 2);
         EntityPlayer var2 = (EntityPlayer)var1;
         Iterator var3 = this.c.iterator();

         while(var3.hasNext()) {
            class_lj var4 = (class_lj)var3.next();
            if(var4.a != var2) {
               var4.b(var2);
            }
         }
      } else if(var1 instanceof class_ve) {
         this.a(var1, 64, 5, true);
      } else if(var1 instanceof EntityArrow) {
         this.a(var1, 64, 20, false);
      } else if(var1 instanceof EntitySmallFireball) {
         this.a(var1, 64, 10, false);
      } else if(var1 instanceof EntityFireball) {
         this.a(var1, 64, 10, false);
      } else if(var1 instanceof EntitySnowball) {
         this.a(var1, 64, 10, true);
      } else if(var1 instanceof EntityEnderpearl) {
         this.a(var1, 64, 10, true);
      } else if(var1 instanceof EntityEnderSignal) {
         this.a(var1, 64, 4, true);
      } else if(var1 instanceof EntityEgg) {
         this.a(var1, 64, 10, true);
      } else if(var1 instanceof EntityPotion) {
         this.a(var1, 64, 10, true);
      } else if(var1 instanceof EntityThrownExpBottle) {
         this.a(var1, 64, 10, true);
      } else if(var1 instanceof EntityFireworks) {
         this.a(var1, 64, 10, true);
      } else if(var1 instanceof EntityItem) {
         this.a(var1, 64, 20, true);
      } else if(var1 instanceof EntityMinecartAbstract) {
         this.a(var1, 80, 3, true);
      } else if(var1 instanceof EntityBoat) {
         this.a(var1, 80, 3, true);
      } else if(var1 instanceof EntitySquid) {
         this.a(var1, 64, 3, true);
      } else if(var1 instanceof EntityWither) {
         this.a(var1, 80, 3, false);
      } else if(var1 instanceof EntityShulkerBullet) {
         this.a(var1, 80, 3, true);
      } else if(var1 instanceof EntityBat) {
         this.a(var1, 80, 3, false);
      } else if(var1 instanceof EntityEnderDragon) {
         this.a(var1, 160, 3, true);
      } else if(var1 instanceof class_pp) {
         this.a(var1, 80, 3, true);
      } else if(var1 instanceof EntityTNTPrimed) {
         this.a(var1, 160, 10, true);
      } else if(var1 instanceof EntityFallingBlock) {
         this.a(var1, 160, 20, true);
      } else if(var1 instanceof class_uz) {
         this.a(var1, 160, Integer.MAX_VALUE, false);
      } else if(var1 instanceof EntityArmorStand) {
         this.a(var1, 160, 3, true);
      } else if(var1 instanceof EntityExperienceOrb) {
         this.a(var1, 160, 20, true);
      } else if(var1 instanceof EntityEnderCrystal) {
         this.a(var1, 256, Integer.MAX_VALUE, false);
      }

   }

   public void a(Entity var1, int var2, int var3) {
      this.a(var1, var2, var3, false);
   }

   public void a(Entity var1, int var2, final int var3, boolean var4) {
      if(var2 > this.e) {
         var2 = this.e;
      }

      try {
         if(this.d.b(var1.getId())) {
            throw new IllegalStateException("Entity is already tracked!");
         }

         class_lj var5 = new class_lj(var1, var2, var3, var4);
         this.c.add(var5);
         this.d.a(var1.getId(), var5);
         var5.b(this.b.players);
      } catch (Throwable var11) {
         class_b var6 = class_b.a(var11, "Adding entity to track");
         class_c var7 = var6.a("Entity To Track");
         var7.a((String)"Tracking range", (Object)(var2 + " blocks"));
         var7.a("Update interval", new Callable() {
            public String a() throws Exception {
               String var1 = "Once per " + var3 + " ticks";
               if(var3 == Integer.MAX_VALUE) {
                  var1 = "Maximum (" + var1 + ")";
               }

               return var1;
            }

            // $FF: synthetic method
            public Object call() throws Exception {
               return this.a();
            }
         });
         var1.a(var7);
         class_c var8 = var6.a("Entity That Is Already Tracked");
         ((class_lj)this.d.a(var1.getId())).a.a(var8);

         try {
            throw new class_e(var6);
         } catch (class_e var10) {
            a.error((String)"\"Silently\" catching entity tracking error.", (Throwable)var10);
         }
      }

   }

   public void b(Entity var1) {
      if(var1 instanceof EntityPlayer) {
         EntityPlayer var2 = (EntityPlayer)var1;
         Iterator var3 = this.c.iterator();

         while(var3.hasNext()) {
            class_lj var4 = (class_lj)var3.next();
            var4.a(var2);
         }
      }

      class_lj var5 = (class_lj)this.d.d(var1.getId());
      if(var5 != null) {
         this.c.remove(var5);
         var5.a();
      }

   }

   public void a() {
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         class_lj var3 = (class_lj)var2.next();
         var3.a(this.b.players);
         if(var3.n && var3.a instanceof EntityPlayer) {
            var1.add((EntityPlayer)var3.a);
         }
      }

      for(int var6 = 0; var6 < var1.size(); ++var6) {
         EntityPlayer var7 = (EntityPlayer)var1.get(var6);
         Iterator var4 = this.c.iterator();

         while(var4.hasNext()) {
            class_lj var5 = (class_lj)var4.next();
            if(var5.a != var7) {
               var5.b(var7);
            }
         }
      }

   }

   public void a(EntityPlayer var1) {
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         class_lj var3 = (class_lj)var2.next();
         if(var3.a == var1) {
            var3.b(this.b.players);
         } else {
            var3.b(var1);
         }
      }

   }

   public void a(Entity var1, Packet var2) {
      class_lj var3 = (class_lj)this.d.a(var1.getId());
      if(var3 != null) {
         var3.a(var2);
      }

   }

   public void b(Entity var1, Packet var2) {
      class_lj var3 = (class_lj)this.d.a(var1.getId());
      if(var3 != null) {
         var3.b(var2);
      }

   }

   public void b(EntityPlayer var1) {
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         class_lj var3 = (class_lj)var2.next();
         var3.d(var1);
      }

   }

   public void a(EntityPlayer var1, Chunk var2) {
      Iterator var3 = this.c.iterator();

      while(var3.hasNext()) {
         class_lj var4 = (class_lj)var3.next();
         if(var4.a != var1 && var4.a.ae == var2.a && var4.a.ag == var2.b) {
            var4.b(var1);
         }
      }

   }
}
