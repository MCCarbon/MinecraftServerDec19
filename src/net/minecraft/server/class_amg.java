package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.concurrent.Callable;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aiy;
import net.minecraft.server.class_ame;
import net.minecraft.server.class_amf;
import net.minecraft.server.class_amh;
import net.minecraft.server.class_ami;
import net.minecraft.server.class_amj;
import net.minecraft.server.class_amk;
import net.minecraft.server.class_aml;
import net.minecraft.server.class_amm;
import net.minecraft.server.class_amn;
import net.minecraft.server.class_amo;
import net.minecraft.server.class_amp;
import net.minecraft.server.class_amq;
import net.minecraft.server.class_amr;
import net.minecraft.server.class_amt;
import net.minecraft.server.class_amv;
import net.minecraft.server.class_amw;
import net.minecraft.server.class_amx;
import net.minecraft.server.class_amy;
import net.minecraft.server.class_amz;
import net.minecraft.server.class_ana;
import net.minecraft.server.class_anb;
import net.minecraft.server.class_ang;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_c;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.Packet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class class_amg {
   private static final Logger a = LogManager.getLogger();
   private static Map f = Maps.newHashMap();
   private static Map g = Maps.newHashMap();
   protected World b;
   protected BlockPosition c;
   protected boolean d;
   private int h;
   protected Block e;

   public class_amg() {
      this.c = BlockPosition.ZERO;
      this.h = -1;
   }

   private static void a(Class var0, String var1) {
      if(f.containsKey(var1)) {
         throw new IllegalArgumentException("Duplicate id: " + var1);
      } else {
         f.put(var1, var0);
         g.put(var0, var1);
      }
   }

   public World z() {
      return this.b;
   }

   public void a(World var1) {
      this.b = var1;
   }

   public boolean t() {
      return this.b != null;
   }

   public void a(NBTTagCompound var1) {
      this.c = new BlockPosition(var1.getInt("x"), var1.getInt("y"), var1.getInt("z"));
   }

   public void b(NBTTagCompound var1) {
      String var2 = (String)g.get(this.getClass());
      if(var2 == null) {
         throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
      } else {
         var1.put("id", var2);
         var1.put("x", this.c.getX());
         var1.put("y", this.c.getY());
         var1.put("z", this.c.getZ());
      }
   }

   public static class_amg c(NBTTagCompound var0) {
      class_amg var1 = null;

      try {
         Class var2 = (Class)f.get(var0.getString("id"));
         if(var2 != null) {
            var1 = (class_amg)var2.newInstance();
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      if(var1 != null) {
         var1.a(var0);
      } else {
         a.warn("Skipping BlockEntity with id " + var0.getString("id"));
      }

      return var1;
   }

   public int u() {
      if(this.h == -1) {
         IBlockData var1 = this.b.p(this.c);
         this.h = var1.getBlock().toLegacyData(var1);
      }

      return this.h;
   }

   public void p_() {
      if(this.b != null) {
         IBlockData var1 = this.b.p(this.c);
         this.h = var1.getBlock().toLegacyData(var1);
         this.b.b(this.c, this);
         if(this.w() != Blocks.AIR) {
            this.b.e(this.c, this.w());
         }
      }

   }

   public BlockPosition v() {
      return this.c;
   }

   public Block w() {
      if(this.e == null) {
         this.e = this.b.p(this.c).getBlock();
      }

      return this.e;
   }

   public Packet z_() {
      return null;
   }

   public boolean x() {
      return this.d;
   }

   public void y() {
      this.d = true;
   }

   public void D() {
      this.d = false;
   }

   public boolean c(int var1, int var2) {
      return false;
   }

   public void E() {
      this.e = null;
      this.h = -1;
   }

   public void a(class_c var1) {
      var1.a("Name", new Callable() {
         public String a() throws Exception {
            return (String)class_amg.g.get(class_amg.this.getClass()) + " // " + class_amg.this.getClass().getCanonicalName();
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      if(this.b != null) {
         class_c.a(var1, this.c, this.w(), this.u());
         var1.a("Actual block type", new Callable() {
            public String a() throws Exception {
               int var1 = Block.getId(class_amg.this.b.p(class_amg.this.c).getBlock());

               try {
                  return String.format("ID #%d (%s // %s)", new Object[]{Integer.valueOf(var1), Block.getById(var1).getInternalName(), Block.getById(var1).getClass().getCanonicalName()});
               } catch (Throwable var3) {
                  return "ID #" + var1;
               }
            }

            // $FF: synthetic method
            public Object call() throws Exception {
               return this.a();
            }
         });
         var1.a("Actual block data value", new Callable() {
            public String a() throws Exception {
               IBlockData var1 = class_amg.this.b.p(class_amg.this.c);
               int var2 = var1.getBlock().toLegacyData(var1);
               if(var2 < 0) {
                  return "Unknown? (Got " + var2 + ")";
               } else {
                  String var3 = String.format("%4s", new Object[]{Integer.toBinaryString(var2)}).replace(" ", "0");
                  return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[]{Integer.valueOf(var2), var3});
               }
            }

            // $FF: synthetic method
            public Object call() throws Exception {
               return this.a();
            }
         });
      }
   }

   public void a(BlockPosition var1) {
      if(var1 instanceof BlockPosition.MutableBlockPosition) {
         a.warn((String)"Tried to assign a mutable BlockPos to a block entity...", (Throwable)(new Error()));
         var1 = new BlockPosition(var1);
      }

      this.c = var1;
   }

   public boolean F() {
      return false;
   }

   static {
      a(class_amr.class, "Furnace");
      a(class_ami.class, "Chest");
      a(class_amp.class, "EnderChest");
      a(class_aiy.class_a_in_class_aiy.class, "RecordPlayer");
      a(class_amm.class, "Trap");
      a(class_amn.class, "Dropper");
      a(class_amx.class, "Sign");
      a(class_amv.class, "MobSpawner");
      a(class_amw.class, "Music");
      a(class_ang.class, "Piston");
      a(class_amh.class, "Cauldron");
      a(class_amo.class, "EnchantTable");
      a(class_anb.class, "Airportal");
      a(class_amj.class, "Control");
      a(class_amf.class, "Beacon");
      a(class_amy.class, "Skull");
      a(class_aml.class, "DLDetector");
      a(class_amt.class, "Hopper");
      a(class_amk.class, "Comparator");
      a(class_amq.class, "FlowerPot");
      a(class_ame.class, "Banner");
      a(class_amz.class, "Structure");
      a(class_ana.class, "EndGateway");
   }
}
