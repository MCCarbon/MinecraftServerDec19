package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Vec3D;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.class_l;
import net.minecraft.server.ICommandListener;
import net.minecraft.server.CommandObjectiveExecutor;
import net.minecraft.server.Entity;

public class CommandExecute extends CommandAbstract {
   public String getCommand() {
      return "execute";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.execute.usage";
   }

   public void execute(final ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length < 5) {
         throw new class_cf("commands.execute.usage", new Object[0]);
      } else {
         final Entity var3 = a(var1, var2[0], Entity.class);
         final double var4 = b(var3.locX, var2[1], false);
         final double var6 = b(var3.locY, var2[2], false);
         final double var8 = b(var3.locZ, var2[3], false);
         final BlockPosition var10 = new BlockPosition(var4, var6, var8);
         byte var11 = 4;
         if("detect".equals(var2[4]) && var2.length > 10) {
            World var12 = var3.e();
            double var13 = b(var4, var2[5], false);
            double var15 = b(var6, var2[6], false);
            double var17 = b(var8, var2[7], false);
            Block var19 = g(var1, var2[8]);
            int var20 = a(var2[9], -1, 15);
            BlockPosition var21 = new BlockPosition(var13, var15, var17);
            IBlockData var22 = var12.getType(var21);
            if(var22.getBlock() != var19 || var20 >= 0 && var22.getBlock().toLegacyData(var22) != var20) {
               throw new class_bz("commands.execute.failed", new Object[]{"detect", var3.getName()});
            }

            var11 = 10;
         }

         String var24 = a(var2, var11);
         ICommandListener var14 = new ICommandListener() {
            public String getName() {
               return var3.getName();
            }

            public IChatBaseComponent getScoreboardDisplayName() {
               return var3.getScoreboardDisplayName();
            }

            public void sendMessage(IChatBaseComponent var1x) {
               var1.sendMessage(var1x);
            }

            public boolean a(int var1x, String var2) {
               return var1.a(var1x, var2);
            }

            public BlockPosition c() {
               return var10;
            }

            public Vec3D d() {
               return new Vec3D(var4, var6, var8);
            }

            public World e() {
               return var3.world;
            }

            public Entity f() {
               return var3;
            }

            public boolean u_() {
               MinecraftServer var1x = MinecraftServer.getServer();
               return var1x == null || var1x.d[0].R().getBooleanValue("commandBlockOutput");
            }

            public void a(CommandObjectiveExecutor.class_a_in_class_n var1x, int var2) {
               var3.a(var1x, var2);
            }
         };
         class_l var25 = MinecraftServer.getServer().P();

         try {
            int var16 = var25.a(var14, var24);
            if(var16 < 1) {
               throw new class_bz("commands.execute.allInvocationsFailed", new Object[]{var24});
            }
         } catch (Throwable var23) {
            throw new class_bz("commands.execute.failed", new Object[]{var24, var3.getName()});
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, MinecraftServer.getServer().getPlayers()):(var2.length > 1 && var2.length <= 4?a(var2, 1, var3):(var2.length > 5 && var2.length <= 8 && "detect".equals(var2[4])?a(var2, 5, var3):(var2.length == 9 && "detect".equals(var2[4])?a(var2, Block.BLOCK_REGISTRY.getKeys()):null)));
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 0;
   }
}
