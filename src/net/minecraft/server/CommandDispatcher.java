package net.minecraft.server;

import java.util.Iterator;

public class CommandDispatcher extends CommandHandler implements ICommandDispatcher {
	public CommandDispatcher() {
		this.a(new CommandTime());
		this.a(new CommandGamemode());
		this.a(new CommandDifficulty());
		this.a(new CommandGamemodeDefault());
		this.a(new CommandKill());
		this.a(new CommandToggleDownfall());
		this.a(new CommandWeather());
		this.a(new CommandXp());
		this.a(new CommandTp());
		this.a(new CommandGive());
		this.a(new CommandReplaceItem());
		this.a(new CommandStats());
		this.a(new CommandEffect());
		this.a(new CommandEnchant());
		this.a(new CommandParticle());
		this.a(new CommandMe());
		this.a(new CommandSeed());
		this.a(new CommandHelp());
		this.a(new CommandDebug());
		this.a(new CommandTell());
		this.a(new CommandSay());
		this.a(new CommandSpawnpoint());
		this.a(new CommandSetWorldSpawn());
		this.a(new CommandGamerule());
		this.a(new CommandClear());
		this.a(new CommandTestFor());
		this.a(new CommandSpreadPlayers());
		this.a(new CommandPlaySound());
		this.a(new CommandScoreboard());
		this.a(new CommandExecute());
		this.a(new CommandTrigger());
		this.a(new CommandAchievment());
		this.a(new CommandSummon());
		this.a(new CommandSetBlock());
		this.a(new class_af());
		this.a(new class_u());
		this.a(new CommandCompare());
		this.a(new CommandBlockData());
		this.a(new CommandTestForBlock());
		this.a(new CommandTellRaw());
		this.a(new CommandWorldBorder());
		this.a(new CommandTitle());
		this.a(new CommandEntityData());
		if (MinecraftServer.P().ag()) {
			this.a(new CommandOp());
			this.a(new CommandDeop());
			this.a(new CommandStop());
			this.a(new CommandSaveAll());
			this.a(new CommandSaveOff());
			this.a(new CommandSaveOn());
			this.a(new CommandBanIp());
			this.a(new CommandPardonIp());
			this.a(new CommandBan());
			this.a(new CommandBanList());
			this.a(new CommandPardon());
			this.a(new CommandKick());
			this.a(new CommandList());
			this.a(new CommandWhitelist());
			this.a(new CommandSetIdleTimeout());
		} else {
			this.a(new CommandPublish());
		}

		CommandAbstract.a(this);
	}

	@Override
	public void a(ICommandListener var1, ICommand var2, int var3, String var4, Object... var5) {
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
					} while (!var2.canUse(var1));

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
