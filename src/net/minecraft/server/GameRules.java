package net.minecraft.server;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class GameRules {

	private TreeMap<String, GameRuleValue> rules = new TreeMap<String, GameRuleValue>();

	public GameRules() {
		register("doFireTick", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
		register("mobGriefing", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
		register("keepInventory", "false", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
		register("doMobSpawning", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
		register("doMobLoot", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
		register("doTileDrops", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
		register("doEntityDrops", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
		register("commandBlockOutput", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
		register("naturalRegeneration", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
		register("doDaylightCycle", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
		register("logAdminCommands", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
		register("showDeathMessages", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
		register("randomTickSpeed", "3", GameRules.EnumGameRuleType.NUMERICAL_VALUE);
		register("sendCommandFeedback", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
		register("reducedDebugInfo", "false", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
	}

	public void register(String name, String value, EnumGameRuleType type) {
		rules.put(name, new GameRuleValue(value, type));
	}

	public void setValue(String name, String value) {
		GameRules.GameRuleValue var3 = rules.get(name);
		if (var3 != null) {
			var3.setValue(value);
		} else {
			register(name, value, GameRules.EnumGameRuleType.ANY_VALUE);
		}

	}

	public String getStringValue(String name) {
		GameRules.GameRuleValue var2 = rules.get(name);
		return var2 != null ? var2.getStringValue() : "";
	}

	public boolean getBooleanValue(String name) {
		GameRules.GameRuleValue var2 = rules.get(name);
		return var2 != null ? var2.getBooleanValue() : false;
	}

	public int getIntValue(String name) {
		GameRules.GameRuleValue var2 = rules.get(name);
		return var2 != null ? var2.getIntValue() : 0;
	}

	public NBTTagCompound a() {
		NBTTagCompound var1 = new NBTTagCompound();
		Iterator<String> var2 = rules.keySet().iterator();

		while (var2.hasNext()) {
			String var3 = var2.next();
			GameRules.GameRuleValue var4 = rules.get(var3);
			var1.put(var3, var4.getStringValue());
		}

		return var1;
	}

	public void a(NBTTagCompound var1) {
		Set<?> var2 = var1.getKeys();
		Iterator<?> var3 = var2.iterator();

		while (var3.hasNext()) {
			String var4 = (String) var3.next();
			String var6 = var1.getString(var4);
			setValue(var4, var6);
		}

	}

	public String[] getGameRules() {
		Set<String> var1 = rules.keySet();
		return var1.toArray(new String[var1.size()]);
	}

	public boolean hasGameRule(String name) {
		return rules.containsKey(name);
	}

	public boolean a(String var1, GameRules.EnumGameRuleType var2) {
		GameRules.GameRuleValue var3 = rules.get(var1);
		return (var3 != null) && ((var3.getType() == var2) || (var2 == GameRules.EnumGameRuleType.ANY_VALUE));
	}

	public static enum EnumGameRuleType {
		ANY_VALUE, BOOLEAN_VALUE, NUMERICAL_VALUE;
	}

	public static class GameRuleValue {
		private String stringvalue;
		private boolean booleanvalue;
		private int intvalue;
		private final EnumGameRuleType type;

		public GameRuleValue(String value, EnumGameRuleType type) {
			this.type = type;
			this.setValue(value);
		}

		public void setValue(String value) {
			stringvalue = value;
			booleanvalue = Boolean.parseBoolean(value);
			intvalue = booleanvalue ? 1 : 0;

			try {
				intvalue = Integer.parseInt(value);
			} catch (NumberFormatException e) {
			}
		}

		public String getStringValue() {
			return stringvalue;
		}

		public boolean getBooleanValue() {
			return booleanvalue;
		}

		public int getIntValue() {
			return intvalue;
		}

		public EnumGameRuleType getType() {
			return type;
		}
	}

}
