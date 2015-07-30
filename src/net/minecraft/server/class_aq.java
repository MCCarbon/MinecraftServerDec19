package net.minecraft.server;

import com.google.gson.JsonParseException;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cc;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_ev;
import net.minecraft.server.class_i;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_m;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class class_aq extends class_i {
   public String c() {
      return "tellraw";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.tellraw.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 2) {
         throw new class_cf("commands.tellraw.usage", new Object[0]);
      } else {
         class_lh var3 = a(var1, var2[0]);
         String var4 = a(var2, 1);

         try {
            IChatBaseComponent var5 = IChatBaseComponent.class_a_in_class_eu.a(var4);
            var3.a((IChatBaseComponent)class_ev.a(var1, var5, var3));
         } catch (JsonParseException var7) {
        	 throw class_aq.a(var7);
         }
      }
   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, MinecraftServer.N().K()):null;
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }
}
