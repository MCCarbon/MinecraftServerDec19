package net.minecraft.server;

import java.util.Iterator;

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
		if (MinecraftServer.P().ag()) {
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

		class_i.a(this);
	}

	@Override
	public void a(ICommandListener var1, class_k var2, int var3, String var4, Object... var5) {
		boolean var6 = true;
		MinecraftServer var7 = MinecraftServer.P();
		if (!var1.s_()) {
			var6 = false;
		}

		class_fb var8 = new class_fb("chat.type.admin", new Object[] { var1.e_(), new class_fb(var4, var5) });
		var8.b().a(EnumChatFormat.GRAY);
		var8.b().b(Boolean.valueOf(true));
		if (var6) {
			Iterator var9 = var7.ar().v().iterator();

			label85: while (true) {
				class_yu var10;
				boolean var11;
				boolean var12;
				do {
					do {
						do {
							do {
								if (!var9.hasNext()) {
									break label85;
								}

								var10 = (class_yu) var9.next();
							} while (var10 == var1);
						} while (!var7.ar().h(var10.cl()));
					} while (!var2.a(var1));

					var11 = (var1 instanceof MinecraftServer) && MinecraftServer.P().r();
					var12 = (var1 instanceof class_mq) && MinecraftServer.P().q();
				} while (!var11 && !var12 && ((var1 instanceof class_mq) || (var1 instanceof MinecraftServer)));

				var10.a(var8);
			}
		}

		if ((var1 != var7) && var7.d[0].S().b("logAdminCommands")) {
			var7.a(var8);
		}

		boolean var13 = var7.d[0].S().b("sendCommandFeedback");
		if (var1 instanceof class_age) {
			var13 = ((class_age) var1).m();
		}

		if ((((var3 & 1) != 1) && var13) || (var1 instanceof MinecraftServer)) {
			var1.a(new class_fb(var4, var5));
		}

	}
}
