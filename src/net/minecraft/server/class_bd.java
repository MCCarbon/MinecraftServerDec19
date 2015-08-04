package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.EnumChatFormat;
import net.minecraft.server.class_aa;
import net.minecraft.server.class_ab;
import net.minecraft.server.class_ac;
import net.minecraft.server.class_ad;
import net.minecraft.server.class_ae;
import net.minecraft.server.class_aed;
import net.minecraft.server.class_af;
import net.minecraft.server.class_ag;
import net.minecraft.server.class_ah;
import net.minecraft.server.class_ai;
import net.minecraft.server.class_aj;
import net.minecraft.server.class_ak;
import net.minecraft.server.class_al;
import net.minecraft.server.class_am;
import net.minecraft.server.class_an;
import net.minecraft.server.class_ao;
import net.minecraft.server.class_ap;
import net.minecraft.server.class_aq;
import net.minecraft.server.class_ar;
import net.minecraft.server.class_as;
import net.minecraft.server.class_at;
import net.minecraft.server.class_au;
import net.minecraft.server.class_av;
import net.minecraft.server.class_aw;
import net.minecraft.server.class_ax;
import net.minecraft.server.class_ay;
import net.minecraft.server.class_az;
import net.minecraft.server.class_ba;
import net.minecraft.server.class_bb;
import net.minecraft.server.class_bc;
import net.minecraft.server.class_be;
import net.minecraft.server.class_bf;
import net.minecraft.server.class_bg;
import net.minecraft.server.class_bh;
import net.minecraft.server.class_bi;
import net.minecraft.server.class_bj;
import net.minecraft.server.class_bk;
import net.minecraft.server.class_bl;
import net.minecraft.server.class_bm;
import net.minecraft.server.class_bn;
import net.minecraft.server.class_bp;
import net.minecraft.server.class_bq;
import net.minecraft.server.class_br;
import net.minecraft.server.class_bs;
import net.minecraft.server.class_bt;
import net.minecraft.server.class_bu;
import net.minecraft.server.class_bv;
import net.minecraft.server.class_bw;
import net.minecraft.server.class_bx;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.class_h;
import net.minecraft.server.class_i;
import net.minecraft.server.class_j;
import net.minecraft.server.class_k;
import net.minecraft.server.class_m;
import net.minecraft.server.class_ml;
import net.minecraft.server.class_p;
import net.minecraft.server.class_q;
import net.minecraft.server.class_r;
import net.minecraft.server.class_s;
import net.minecraft.server.class_t;
import net.minecraft.server.class_u;
import net.minecraft.server.class_v;
import net.minecraft.server.class_w;
import net.minecraft.server.class_x;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.class_y;
import net.minecraft.server.class_z;

public class class_bd extends class_j implements class_h {
   public class_bd() {
      this.a(new class_br());
      this.a(new class_ah());
      this.a(new class_ag());
      this.a(new class_y());
      this.a(new class_am());
      this.a(new class_bt());
      this.a(new class_bv());
      this.a(new class_ae());
      this.a(new class_bn());
      this.a(new class_aj());
      this.a(new class_ax());
      this.a(new class_bk());
      this.a(new class_z());
      this.a(new class_ab());
      this.a(new class_au());
      this.a(new class_aa());
      this.a(new class_bi());
      this.a(new class_ak());
      this.a(new class_x());
      this.a(new class_ap());
      this.a(new class_bb());
      this.a(new class_bh());
      this.a(new class_bf());
      this.a(new class_ai());
      this.a(new class_t());
      this.a(new class_bq());
      this.a(new class_bj());
      this.a(new class_av());
      this.a(new class_bc());
      this.a(new class_ad());
      this.a(new class_bu());
      this.a(new class_p());
      this.a(new class_bm());
      this.a(new class_be());
      this.a(new class_af());
      this.a(new class_u());
      this.a(new class_v());
      this.a(new class_s());
      this.a(new class_bp());
      this.a(new class_aq());
      this.a(new class_bx());
      this.a(new class_bs());
      this.a(new class_ac());
      if(MinecraftServer.N().ae()) {
         this.a(new class_ar());
         this.a(new class_w());
         this.a(new class_bl());
         this.a(new class_ay());
         this.a(new class_az());
         this.a(new class_ba());
         this.a(new class_q());
         this.a(new class_as());
         this.a(new class_r());
         this.a(new class_an());
         this.a(new class_at());
         this.a(new class_al());
         this.a(new class_ao());
         this.a(new class_bw());
         this.a(new class_bg());
      } else {
         this.a(new class_aw());
      }

      class_i.a((class_h)this);
   }

   public void a(class_m var1, class_k var2, int var3, String var4, Object... var5) {
      boolean var6 = true;
      MinecraftServer var7 = MinecraftServer.N();
      if(!var1.u_()) {
         var6 = false;
      }

      ChatMessage var8 = new ChatMessage("chat.type.admin", new Object[]{var1.getName(), new ChatMessage(var4, var5)});
      var8.getChatModifier().a(EnumChatFormat.GRAY);
      var8.getChatModifier().b(Boolean.valueOf(true));
      if(var6) {
         Iterator var9 = var7.getPlayerList().v().iterator();

         label85:
         while(true) {
            EntityHuman var10;
            boolean var11;
            boolean var12;
            do {
               do {
                  do {
                     do {
                        if(!var9.hasNext()) {
                           break label85;
                        }

                        var10 = (EntityHuman)var9.next();
                     } while(var10 == var1);
                  } while(!var7.getPlayerList().h(var10.cf()));
               } while(!var2.a(var1));

               var11 = var1 instanceof MinecraftServer && MinecraftServer.N().r();
               var12 = var1 instanceof class_ml && MinecraftServer.N().q();
            } while(!var11 && !var12 && (var1 instanceof class_ml || var1 instanceof MinecraftServer));

            var10.a((IChatBaseComponent)var8);
         }
      }

      if(var1 != var7 && var7.d[0].R().b("logAdminCommands")) {
         var7.a((IChatBaseComponent)var8);
      }

      boolean var13 = var7.d[0].R().b("sendCommandFeedback");
      if(var1 instanceof class_aed) {
         var13 = ((class_aed)var1).m();
      }

      if((var3 & 1) != 1 && var13 || var1 instanceof MinecraftServer) {
         var1.a(new ChatMessage(var4, var5));
      }

   }
}
