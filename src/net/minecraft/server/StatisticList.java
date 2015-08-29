package net.minecraft.server;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class StatisticList {
	protected static final Map a = Maps.newHashMap();
	public static final List b = Lists.newArrayList();
	public static final List c = Lists.newArrayList();
	public static final List d = Lists.newArrayList();
	public static final List e = Lists.newArrayList();
	public static final class_nd f = (new class_na("stat.leaveGame", new class_fb("stat.leaveGame", new Object[0]))).i().h();
	public static final class_nd g;
	public static final class_nd h;
	public static final class_nd i;
	public static final class_nd j;
	public static final class_nd k;
	public static final class_nd l;
	public static final class_nd m;
	public static final class_nd n;
	public static final class_nd o;
	public static final class_nd p;
	public static final class_nd q;
	public static final class_nd r;
	public static final class_nd s;
	public static final class_nd t;
	public static final class_nd u;
	public static final class_nd v;
	public static final class_nd w;
	public static final class_nd x;
	public static final class_nd y;
	public static final class_nd z;
	public static final class_nd A;
	public static final class_nd B;
	public static final class_nd C;
	public static final class_nd D;
	public static final class_nd E;
	public static final class_nd F;
	public static final class_nd G;
	public static final class_nd H;
	public static final class_nd I;
	public static final class_nd J;
	public static final class_nd K;
	public static final class_nd L;
	public static final class_nd M;
	public static final class_nd N;
	public static final class_nd O;
	public static final class_nd P;
	public static final class_nd Q;
	public static final class_nd R;
	public static final class_nd S;
	public static final class_nd T;
	public static final class_nd U;
	public static final class_nd V;
	public static final class_nd W;
	public static final class_nd X;
	public static final class_nd Y;
	public static final class_nd Z;
	public static final class_nd aa;
	public static final class_nd ab;
	private static final class_nd[] ac;
	private static final class_nd[] ad;
	private static final class_nd[] ae;
	private static final class_nd[] af;
	private static final class_nd[] ag;
	private static final class_nd[] ah;

	public static class_nd a(int var0) {
		return ac[var0];
	}

	public static class_nd b(int var0) {
		return ad[var0];
	}

	public static class_nd c(int var0) {
		return ae[var0];
	}

	public static class_nd d(int var0) {
		return af[var0];
	}

	public static class_nd e(int var0) {
		return ag[var0];
	}

	public static class_nd f(int var0) {
		return ah[var0];
	}

	public static void a() {
		c();
		d();
		e();
		b();
		f();
		class_my.a();
		EntityTypes.a();
	}

	private static void b() {
		HashSet var0 = Sets.newHashSet();
		Iterator var1 = class_aet.a().b().iterator();

		while (var1.hasNext()) {
			class_aes var2 = (class_aes) var1.next();
			if (var2.b() != null) {
				var0.add(var2.b().b());
			}
		}

		var1 = class_aen.a().b().values().iterator();

		while (var1.hasNext()) {
			class_aco var5 = (class_aco) var1.next();
			var0.add(var5.b());
		}

		var1 = var0.iterator();

		while (var1.hasNext()) {
			Item var6 = (Item) var1.next();
			if (var6 != null) {
				int var3 = Item.b(var6);
				String var4 = a(var6);
				if (var4 != null) {
					ad[var3] = (new class_nb("stat.craftItem.", var4, new class_fb("stat.craftItem", new Object[] { (new class_aco(var6)).B() }), var6)).h();
				}
			}
		}

		a(ad);
	}

	private static void c() {
		Iterator var0 = Block.c.iterator();

		while (var0.hasNext()) {
			Block var1 = (Block) var0.next();
			Item var2 = Item.a(var1);
			if (var2 != null) {
				int var3 = Block.a(var1);
				String var4 = a(var2);
				if ((var4 != null) && var1.L()) {
					ac[var3] = (new class_nb("stat.mineBlock.", var4, new class_fb("stat.mineBlock", new Object[] { (new class_aco(var1)).B() }), var2)).h();
					e.add(ac[var3]);
				}
			}
		}

		a(ac);
	}

	private static void d() {
		Iterator var0 = Item.e.iterator();

		while (var0.hasNext()) {
			Item var1 = (Item) var0.next();
			if (var1 != null) {
				int var2 = Item.b(var1);
				String var3 = a(var1);
				if (var3 != null) {
					ae[var2] = (new class_nb("stat.useItem.", var3, new class_fb("stat.useItem", new Object[] { (new class_aco(var1)).B() }), var1)).h();
					if (!(var1 instanceof class_abb)) {
						d.add(ae[var2]);
					}
				}
			}
		}

		a(ae);
	}

	private static void e() {
		Iterator var0 = Item.e.iterator();

		while (var0.hasNext()) {
			Item var1 = (Item) var0.next();
			if (var1 != null) {
				int var2 = Item.b(var1);
				String var3 = a(var1);
				if ((var3 != null) && var1.m()) {
					af[var2] = (new class_nb("stat.breakItem.", var3, new class_fb("stat.breakItem", new Object[] { (new class_aco(var1)).B() }), var1)).h();
				}
			}
		}

		a(af);
	}

	private static void f() {
		Iterator var0 = Item.e.iterator();

		while (var0.hasNext()) {
			Item var1 = (Item) var0.next();
			if (var1 != null) {
				int var2 = Item.b(var1);
				String var3 = a(var1);
				if (var3 != null) {
					ag[var2] = (new class_nb("stat.pickup.", var3, new class_fb("stat.pickup", new Object[] { (new class_aco(var1)).B() }), var1)).h();
					ah[var2] = (new class_nb("stat.drop.", var3, new class_fb("stat.drop", new Object[] { (new class_aco(var1)).B() }), var1)).h();
				}
			}
		}

		a(af);
	}

	private static String a(Item var0) {
		class_ke var1 = (class_ke) Item.e.b(var0);
		return var1 != null ? var1.toString().replace(':', '.') : null;
	}

	private static void a(class_nd[] var0) {
		a(var0, Blocks.WATER, Blocks.FLOWING_WATER);
		a(var0, Blocks.LAVA, Blocks.FLOWING_LAVA);
		a(var0, Blocks.LIT_PUMPKIN, Blocks.PUMPKIN);
		a(var0, Blocks.LIT_FURNACE, Blocks.FURNACE);
		a(var0, Blocks.LIT_REDSTONE_TORCH, Blocks.REDSTONE_ORE);
		a(var0, Blocks.POWERED_REPEATER, Blocks.UNPOWERED_REPEATER);
		a(var0, Blocks.POWERED_COMPARATOR, Blocks.UNPOWERED_COMPARATOR);
		a(var0, Blocks.REDSTONE_TORCH, Blocks.UNLIN_REDSTONE_TORCH);
		a(var0, Blocks.LIT_REDSTONE_LAMP, Blocks.REDSTONE_LAMP);
		a(var0, Blocks.DOUBLE_SANDSTONE_SLAB, Blocks.STONE_SLAB);
		a(var0, Blocks.DOUBLE_WOODEN_SLAB, Blocks.WOODEN_SLAB);
		a(var0, Blocks.DOUBLE_STONE_SLAB2, Blocks.STONE_SLAB2);
		a(var0, Blocks.GRASS, Blocks.DIRT);
		a(var0, Blocks.FARMLAND, Blocks.DIRT);
	}

	private static void a(class_nd[] var0, Block var1, Block var2) {
		int var3 = Block.a(var1);
		int var4 = Block.a(var2);
		if ((var0[var3] != null) && (var0[var4] == null)) {
			var0[var4] = var0[var3];
		} else {
			b.remove(var0[var3]);
			e.remove(var0[var3]);
			c.remove(var0[var3]);
			var0[var3] = var0[var4];
		}
	}

	public static class_nd a(EntityTypes.class_a_in_class_qz var0) {
		return var0.a == null ? null : (new class_nd("stat.killEntity." + var0.a, new class_fb("stat.entityKill", new Object[] { new class_fb("entity." + var0.a + ".name", new Object[0]) }))).h();
	}

	public static class_nd b(EntityTypes.class_a_in_class_qz var0) {
		return var0.a == null ? null : (new class_nd("stat.entityKilledBy." + var0.a, new class_fb("stat.entityKilledBy", new Object[] { new class_fb("entity." + var0.a + ".name", new Object[0]) }))).h();
	}

	public static class_nd a(String var0) {
		return (class_nd) a.get(var0);
	}

	static {
		g = (new class_na("stat.playOneMinute", new class_fb("stat.playOneMinute", new Object[0]), class_nd.h)).i().h();
		h = (new class_na("stat.timeSinceDeath", new class_fb("stat.timeSinceDeath", new Object[0]), class_nd.h)).i().h();
		i = (new class_na("stat.sneakTime", new class_fb("stat.sneakTime", new Object[0]), class_nd.h)).i().h();
		j = (new class_na("stat.walkOneCm", new class_fb("stat.walkOneCm", new Object[0]), class_nd.i)).i().h();
		k = (new class_na("stat.crouchOneCm", new class_fb("stat.crouchOneCm", new Object[0]), class_nd.i)).i().h();
		l = (new class_na("stat.sprintOneCm", new class_fb("stat.sprintOneCm", new Object[0]), class_nd.i)).i().h();
		m = (new class_na("stat.swimOneCm", new class_fb("stat.swimOneCm", new Object[0]), class_nd.i)).i().h();
		n = (new class_na("stat.fallOneCm", new class_fb("stat.fallOneCm", new Object[0]), class_nd.i)).i().h();
		o = (new class_na("stat.climbOneCm", new class_fb("stat.climbOneCm", new Object[0]), class_nd.i)).i().h();
		p = (new class_na("stat.flyOneCm", new class_fb("stat.flyOneCm", new Object[0]), class_nd.i)).i().h();
		q = (new class_na("stat.diveOneCm", new class_fb("stat.diveOneCm", new Object[0]), class_nd.i)).i().h();
		r = (new class_na("stat.minecartOneCm", new class_fb("stat.minecartOneCm", new Object[0]), class_nd.i)).i().h();
		s = (new class_na("stat.boatOneCm", new class_fb("stat.boatOneCm", new Object[0]), class_nd.i)).i().h();
		t = (new class_na("stat.pigOneCm", new class_fb("stat.pigOneCm", new Object[0]), class_nd.i)).i().h();
		u = (new class_na("stat.horseOneCm", new class_fb("stat.horseOneCm", new Object[0]), class_nd.i)).i().h();
		v = (new class_na("stat.jump", new class_fb("stat.jump", new Object[0]))).i().h();
		w = (new class_na("stat.drop", new class_fb("stat.drop", new Object[0]))).i().h();
		x = (new class_na("stat.damageDealt", new class_fb("stat.damageDealt", new Object[0]), class_nd.j)).h();
		y = (new class_na("stat.damageTaken", new class_fb("stat.damageTaken", new Object[0]), class_nd.j)).h();
		z = (new class_na("stat.deaths", new class_fb("stat.deaths", new Object[0]))).h();
		A = (new class_na("stat.mobKills", new class_fb("stat.mobKills", new Object[0]))).h();
		B = (new class_na("stat.animalsBred", new class_fb("stat.animalsBred", new Object[0]))).h();
		C = (new class_na("stat.playerKills", new class_fb("stat.playerKills", new Object[0]))).h();
		D = (new class_na("stat.fishCaught", new class_fb("stat.fishCaught", new Object[0]))).h();
		E = (new class_na("stat.junkFished", new class_fb("stat.junkFished", new Object[0]))).h();
		F = (new class_na("stat.treasureFished", new class_fb("stat.treasureFished", new Object[0]))).h();
		G = (new class_na("stat.talkedToVillager", new class_fb("stat.talkedToVillager", new Object[0]))).h();
		H = (new class_na("stat.tradedWithVillager", new class_fb("stat.tradedWithVillager", new Object[0]))).h();
		I = (new class_na("stat.cakeSlicesEaten", new class_fb("stat.cakeSlicesEaten", new Object[0]))).h();
		J = (new class_na("stat.cauldronFilled", new class_fb("stat.cauldronFilled", new Object[0]))).h();
		K = (new class_na("stat.cauldronUsed", new class_fb("stat.cauldronUsed", new Object[0]))).h();
		L = (new class_na("stat.armorCleaned", new class_fb("stat.armorCleaned", new Object[0]))).h();
		M = (new class_na("stat.bannerCleaned", new class_fb("stat.bannerCleaned", new Object[0]))).h();
		N = (new class_na("stat.brewingstandInteraction", new class_fb("stat.brewingstandInteraction", new Object[0]))).h();
		O = (new class_na("stat.beaconInteraction", new class_fb("stat.beaconInteraction", new Object[0]))).h();
		P = (new class_na("stat.dropperInspected", new class_fb("stat.dropperInspected", new Object[0]))).h();
		Q = (new class_na("stat.hopperInspected", new class_fb("stat.hopperInspected", new Object[0]))).h();
		R = (new class_na("stat.dispenserInspected", new class_fb("stat.dispenserInspected", new Object[0]))).h();
		S = (new class_na("stat.noteblockPlayed", new class_fb("stat.noteblockPlayed", new Object[0]))).h();
		T = (new class_na("stat.noteblockTuned", new class_fb("stat.noteblockTuned", new Object[0]))).h();
		U = (new class_na("stat.flowerPotted", new class_fb("stat.flowerPotted", new Object[0]))).h();
		V = (new class_na("stat.trappedChestTriggered", new class_fb("stat.trappedChestTriggered", new Object[0]))).h();
		W = (new class_na("stat.enderchestOpened", new class_fb("stat.enderchestOpened", new Object[0]))).h();
		X = (new class_na("stat.itemEnchanted", new class_fb("stat.itemEnchanted", new Object[0]))).h();
		Y = (new class_na("stat.recordPlayed", new class_fb("stat.recordPlayed", new Object[0]))).h();
		Z = (new class_na("stat.furnaceInteraction", new class_fb("stat.furnaceInteraction", new Object[0]))).h();
		aa = (new class_na("stat.craftingTableInteraction", new class_fb("stat.workbenchInteraction", new Object[0]))).h();
		ab = (new class_na("stat.chestOpened", new class_fb("stat.chestOpened", new Object[0]))).h();
		ac = new class_nd[4096];
		ad = new class_nd[32000];
		ae = new class_nd[32000];
		af = new class_nd[32000];
		ag = new class_nd[32000];
		ah = new class_nd[32000];
	}
}
