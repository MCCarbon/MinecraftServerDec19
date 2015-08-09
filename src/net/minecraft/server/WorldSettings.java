package net.minecraft.server;

import net.minecraft.server.WorldType;
import net.minecraft.server.WorldData;
import net.minecraft.server.PlayerAbilities;

public final class WorldSettings {
	private final long a;
	private final WorldSettings.EnumGameMode b;
	private final boolean c;
	private final boolean d;
	private final WorldType e;
	private boolean f;
	private boolean g;
	private String h;

	public WorldSettings(long var1, WorldSettings.EnumGameMode var3, boolean var4, boolean var5, WorldType var6) {
		this.h = "";
		this.a = var1;
		this.b = var3;
		this.c = var4;
		this.d = var5;
		this.e = var6;
	}

	public WorldSettings(WorldData var1) {
		this(var1.b(), var1.r(), var1.s(), var1.t(), var1.u());
	}

	public WorldSettings a() {
		this.g = true;
		return this;
	}

	public WorldSettings a(String var1) {
		this.h = var1;
		return this;
	}

	public boolean c() {
		return this.g;
	}

	public long d() {
		return this.a;
	}

	public WorldSettings.EnumGameMode e() {
		return this.b;
	}

	public boolean f() {
		return this.d;
	}

	public boolean g() {
		return this.c;
	}

	public WorldType h() {
		return this.e;
	}

	public boolean i() {
		return this.f;
	}

	public static WorldSettings.EnumGameMode a(int var0) {
		return WorldSettings.EnumGameMode.getById(var0);
	}

	public String j() {
		return this.h;
	}

	public static enum EnumGameMode {

		NOT_SET(-1, ""), SURVIVAL(0, "survival"), CREATIVE(1, "creative"), ADVENTURE(2, "adventure"), SPECTATOR(3, "spectator");

		public static WorldSettings.EnumGameMode getById(int id) {
			for (EnumGameMode mode : values()) {
				if (mode.id == id) {
					return mode;
				}
			}
			return SURVIVAL;
		}

		int id;
		String name;

		private EnumGameMode(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return this.id;
		}

		public String getName() {
			return this.name;
		}

		public void setAbilities(PlayerAbilities abilities) {
			if (this == CREATIVE) {
				abilities.mayfly = true;
				abilities.instabuild = true;
				abilities.invulnerable = true;
			} else if (this == SPECTATOR) {
				abilities.mayfly = true;
				abilities.instabuild = false;
				abilities.invulnerable = true;
				abilities.flying = true;
			} else {
				abilities.mayfly = false;
				abilities.instabuild = false;
				abilities.invulnerable = false;
				abilities.flying = false;
			}

			abilities.mayBuild = !this.isAdventureOrSpectator();
		}

		public boolean isAdventureOrSpectator() {
			return this == ADVENTURE || this == SPECTATOR;
		}

		public boolean isCreative() {
			return this == CREATIVE;
		}

		public boolean isSurvivalOrAdventure() {
			return this == SURVIVAL || this == ADVENTURE;
		}

	}
}
