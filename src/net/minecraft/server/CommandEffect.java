package net.minecraft.server;

import java.util.List;

public class CommandEffect extends CommandAbstract {
   public String getCommand() {
      return "effect";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.effect.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length < 2) {
         throw new class_cf("commands.effect.usage", new Object[0]);
      } else {
         EntityLiving var3 = (EntityLiving)a(var1, var2[0], EntityLiving.class);
         if(var2[1].equals("clear")) {
            if(var3.getEffects().isEmpty()) {
               throw new class_bz("commands.effect.failure.notActive.all", new Object[]{var3.getName()});
            } else {
               var3.bl();
               a(var1, this, "commands.effect.success.removed.all", new Object[]{var3.getName()});
            }
         } else {
            MobEffectType var4;
            try {
               var4 = MobEffectType.getById(a(var2[1], 1));
            } catch (class_cb var10) {
               var4 = MobEffectType.getByName(var2[1]);
            }

            if(var4 == null) {
               throw new class_cb("commands.effect.notFound", new Object[]{var2[1]});
            } else {
               int var5 = 600;
               int var6 = 30;
               int var7 = 0;
               if(var2.length >= 3) {
                  var6 = a(var2[2], 0, 1000000);
                  if(var4.b()) {
                     var5 = var6;
                  } else {
                     var5 = var6 * 20;
                  }
               } else if(var4.b()) {
                  var5 = 1;
               }

               if(var2.length >= 4) {
                  var7 = a(var2[3], 0, 255);
               }

               boolean var8 = true;
               if(var2.length >= 5 && "true".equalsIgnoreCase(var2[4])) {
                  var8 = false;
               }

               if(var6 > 0) {
                  MobEffect var9 = new MobEffect(var4, var5, var7, false, var8);
                  var3.addEffect(var9);
                  a(var1, this, "commands.effect.success", new Object[]{new ChatMessage(var9.getName(), new Object[0]), Integer.valueOf(MobEffectType.getId(var4)), Integer.valueOf(var7), var3.getName(), Integer.valueOf(var6)});
               } else if(var3.hasEffect(var4)) {
                  var3.d(var4);
                  a(var1, this, "commands.effect.success.removed", new Object[]{new ChatMessage(var4.getName(), new Object[0]), var3.getName()});
               } else {
                  throw new class_bz("commands.effect.failure.notActive", new Object[]{new ChatMessage(var4.getName(), new Object[0]), var3.getName()});
               }
            }
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, this.d()):(var2.length == 2?a(var2, MobEffectType.REGISTRY.getKeys()):(var2.length == 5?a(var2, new String[]{"true", "false"}):null));
   }

   protected String[] d() {
      return MinecraftServer.N().getPlayers();
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 0;
   }
}
