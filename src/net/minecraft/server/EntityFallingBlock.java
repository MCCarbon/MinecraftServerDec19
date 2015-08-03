package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.class_aga;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IContainer;
import net.minecraft.server.BlockFalling;
import net.minecraft.server.TileEntity;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.class_c;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTag;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;

public class EntityFallingBlock extends Entity {
   private IBlockData d;
   public int a;
   public boolean b = true;
   private boolean e;
   private boolean f;
   private int g = 40;
   private float h = 2.0F;
   public NBTTagCompound c;

   public EntityFallingBlock(World var1) {
      super(var1);
   }

   public EntityFallingBlock(World var1, double var2, double var4, double var6, IBlockData var8) {
      super(var1);
      this.d = var8;
      this.k = true;
      this.a(0.98F, 0.98F);
      this.b(var2, var4, var6);
      this.v = 0.0D;
      this.motY = 0.0D;
      this.x = 0.0D;
      this.p = var2;
      this.q = var4;
      this.r = var6;
   }

   protected boolean s_() {
      return false;
   }

   protected void h() {
   }

   public boolean ad() {
      return !this.I;
   }

   public void t_() {
      Block var1 = this.d.getBlock();
      if(var1.getMaterial() == Material.AIR) {
         this.J();
      } else {
         this.p = this.s;
         this.q = this.t;
         this.r = this.u;
         BlockPosition var2;
         if(this.a++ == 0) {
            var2 = new BlockPosition(this);
            if(this.o.getType(var2).getBlock() == var1) {
               this.o.setAir(var2);
            } else if(!this.o.isClientSide) {
               this.J();
               return;
            }
         }

         this.motY -= 0.03999999910593033D;
         this.d(this.v, this.motY, this.x);
         this.v *= 0.9800000190734863D;
         this.motY *= 0.9800000190734863D;
         this.x *= 0.9800000190734863D;
         if(!this.o.isClientSide) {
            var2 = new BlockPosition(this);
            if(this.C) {
               this.v *= 0.699999988079071D;
               this.x *= 0.699999988079071D;
               this.motY *= -0.5D;
               if(this.o.getType(var2).getBlock() != Blocks.PISTON_EXTENSION) {
                  this.J();
                  if(!this.e) {
                     if(this.o.a(var1, var2, true, EnumDirection.UP, (Entity)null, (ItemStack)null) && !BlockFalling.canFall(this.o, var2.down()) && this.o.setTypeAndData((BlockPosition)var2, (IBlockData)this.d, 3)) {
                        if(var1 instanceof BlockFalling) {
                           ((BlockFalling)var1).a_(this.o, var2);
                        }

                        if(this.c != null && var1 instanceof IContainer) {
                           TileEntity var3 = this.o.getTileEntity(var2);
                           if(var3 != null) {
                              NBTTagCompound var4 = new NBTTagCompound();
                              var3.write(var4);
                              Iterator var5 = this.c.getKeys().iterator();

                              while(var5.hasNext()) {
                                 String var6 = (String)var5.next();
                                 NBTTag var7 = this.c.getTag(var6);
                                 if(!var6.equals("DIAMOND_SHOVEL") && !var6.equals("DIAMOND_PICKAXE") && !var6.equals("DIAMOND_AXE")) {
                                    var4.put(var6, var7.clone());
                                 }
                              }

                              var3.read(var4);
                              var3.update();
                           }
                        }
                     } else if(this.b && this.o.R().b("doEntityDrops")) {
                        this.a(new ItemStack(var1, 1, var1.getDropData(this.d)), 0.0F);
                     }
                  }
               }
            } else if(this.a > 100 && !this.o.isClientSide && (var2.getY() < 1 || var2.getY() > 256) || this.a > 600) {
               if(this.b && this.o.R().b("doEntityDrops")) {
                  this.a(new ItemStack(var1, 1, var1.getDropData(this.d)), 0.0F);
               }

               this.J();
            }
         }

      }
   }

   public void e(float var1, float var2) {
      Block var3 = this.d.getBlock();
      if(this.f) {
         int var4 = MathHelper.ceil(var1 - 1.0F);
         if(var4 > 0) {
            ArrayList var5 = Lists.newArrayList((Iterable)this.o.getEntities((Entity)this, (AxisAlignedBB)this.aT()));
            boolean var6 = var3 == Blocks.ANVIL;
            class_pc var7 = var6?class_pc.n:class_pc.o;
            Iterator var8 = var5.iterator();

            while(var8.hasNext()) {
               Entity var9 = (Entity)var8.next();
               var9.damageEntity(var7, (float)Math.min(MathHelper.floor((float)var4 * this.h), this.g));
            }

            if(var6 && (double)this.random.nextFloat() < 0.05000000074505806D + (double)var4 * 0.05D) {
               int var10 = ((Integer)this.d.get(class_aga.b)).intValue();
               ++var10;
               if(var10 > 2) {
                  this.e = true;
               } else {
                  this.d = this.d.set(class_aga.b, Integer.valueOf(var10));
               }
            }
         }
      }

   }

   protected void write(NBTTagCompound var1) {
      Block var2 = this.d != null?this.d.getBlock():Blocks.AIR;
      MinecraftKey var3 = (MinecraftKey)Block.BLOCK_REGISTRY.getKey(var2);
      var1.put("Block", var3 == null?"":var3.toString());
      var1.put("Data", (byte)var2.toLegacyData(this.d));
      var1.put("Time", (byte)this.a);
      var1.put("DropItem", this.b);
      var1.put("HurtEntities", this.f);
      var1.put("FallHurtAmount", this.h);
      var1.put("FallHurtMax", this.g);
      if(this.c != null) {
         var1.put((String)"TileEntityData", (NBTTag)this.c);
      }

   }

   protected void read(NBTTagCompound var1) {
      int var2 = var1.getByte("Data") & 255;
      if(var1.hasOfType("Block", 8)) {
         this.d = Block.getByName(var1.getString("Block")).fromLegacyData(var2);
      } else if(var1.hasOfType("TileID", 99)) {
         this.d = Block.getById(var1.getInt("TileID")).fromLegacyData(var2);
      } else {
         this.d = Block.getById(var1.getByte("Tile") & 255).fromLegacyData(var2);
      }

      this.a = var1.getByte("Time") & 255;
      Block var3 = this.d.getBlock();
      if(var1.hasOfType("HurtEntities", 99)) {
         this.f = var1.getBoolean("HurtEntities");
         this.h = var1.getFloat("FallHurtAmount");
         this.g = var1.getInt("FallHurtMax");
      } else if(var3 == Blocks.ANVIL) {
         this.f = true;
      }

      if(var1.hasOfType("DropItem", 99)) {
         this.b = var1.getBoolean("DropItem");
      }

      if(var1.hasOfType("TileEntityData", 10)) {
         this.c = var1.getCompound("TileEntityData");
      }

      if(var3 == null || var3.getMaterial() == Material.AIR) {
         this.d = Blocks.SAND.getBlockData();
      }

   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public void a(class_c var1) {
      super.a(var1);
      if(this.d != null) {
         Block var2 = this.d.getBlock();
         var1.a((String)"Immitating block ID", (Object)Integer.valueOf(Block.getId(var2)));
         var1.a((String)"Immitating block data", (Object)Integer.valueOf(var2.toLegacyData(this.d)));
      }

   }

   public IBlockData l() {
      return this.d;
   }
}
