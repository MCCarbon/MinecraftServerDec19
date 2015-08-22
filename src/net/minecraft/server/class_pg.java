package net.minecraft.server;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;

public class class_pg implements class_oq {
	private static final Logger a = LogManager.getLogger();
	private static final Map b = Maps.newHashMap();

	private static String a(String var0) {
		return (String) b.get((new class_ke(var0)).toString());
	}

	@Override
	public class_dn a(class_on var1, class_dn var2, int var3) {
		if (!var2.b("tag", 10)) {
			return var2;
		} else {
			class_dn var4 = var2.o("tag");
			if (var4.b("BlockEntityTag", 10)) {
				class_dn var5 = var4.o("BlockEntityTag");
				String var6 = var2.l("id");
				String var7 = a(var6);
				boolean var8;
				if (var7 == null) {
					a.warn("Unable to resolve BlockEntity for ItemInstance: {}", new Object[] { var6 });
					var8 = false;
				} else {
					var8 = !var5.e("id");
					var5.a("id", var7);
				}

				var1.a(class_om.d, var5, var3);
				if (var8) {
					var5.q("id");
				}
			}

			return var2;
		}
	}

	static {
		Map var0 = b;
		var0.put("minecraft:furnace", "Furnace");
		var0.put("minecraft:lit_furnace", "Furnace");
		var0.put("minecraft:chest", "Chest");
		var0.put("minecraft:trapped_chest", "Chest");
		var0.put("minecraft:ender_chest", "EnderChest");
		var0.put("minecraft:jukebox", "RecordPlayer");
		var0.put("minecraft:dispenser", "Trap");
		var0.put("minecraft:dropper", "Dropper");
		var0.put("minecraft:sign", "Sign");
		var0.put("minecraft:mob_spawner", "MobSpawner");
		var0.put("minecraft:noteblock", "Music");
		var0.put("minecraft:brewing_stand", "Cauldron");
		var0.put("minecraft:enhanting_table", "EnchantTable");
		var0.put("minecraft:command_block", "CommandBlock");
		var0.put("minecraft:beacon", "Beacon");
		var0.put("minecraft:skull", "Skull");
		var0.put("minecraft:daylight_detector", "DLDetector");
		var0.put("minecraft:hopper", "Hopper");
		var0.put("minecraft:banner", "Banner");
		var0.put("minecraft:flower_pot", "FlowerPot");
		var0.put("minecraft:repeating_command_block", "CommandBlock");
		var0.put("minecraft:chain_command_block", "CommandBlock");
		var0.put("minecraft:standing_sign", "Sign");
		var0.put("minecraft:wall_sign", "Sign");
		var0.put("minecraft:piston_head", "Piston");
		var0.put("minecraft:daylight_detector_inverted", "DLDetector");
		var0.put("minecraft:unpowered_comparator", "Comparator");
		var0.put("minecraft:powered_comparator", "Comparator");
		var0.put("minecraft:wall_banner", "Banner");
		var0.put("minecraft:standing_banner", "Banner");
		var0.put("minecraft:structure_block", "Structure");
		var0.put("minecraft:end_portal", "Airportal");
		var0.put("minecraft:end_gateway", "EndGateway");
	}
}
