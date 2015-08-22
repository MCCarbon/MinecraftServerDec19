package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class EntityTypes {
	private static final Logger b = LogManager.getLogger();
	private static final Map c = Maps.newHashMap();
	private static final Map d = Maps.newHashMap();
	private static final Map e = Maps.newHashMap();
	private static final Map f = Maps.newHashMap();
	private static final Map g = Maps.newHashMap();
	public static final Map a = Maps.newLinkedHashMap();

	private static void a(Class var0, String var1, int var2) {
		if (c.containsKey(var1)) {
			throw new IllegalArgumentException("ID is already registered: " + var1);
		} else if (e.containsKey(Integer.valueOf(var2))) {
			throw new IllegalArgumentException("ID is already registered: " + var2);
		} else if (var2 == 0) {
			throw new IllegalArgumentException("Cannot register to reserved id: " + var2);
		} else if (var0 == null) {
			throw new IllegalArgumentException("Cannot register null clazz for id: " + var2);
		} else {
			c.put(var1, var0);
			d.put(var0, var1);
			e.put(Integer.valueOf(var2), var0);
			f.put(var0, Integer.valueOf(var2));
			g.put(var1, Integer.valueOf(var2));
		}
	}

	private static void a(Class var0, String var1, int var2, int var3, int var4) {
		a(var0, var1, var2);
		a.put(var1, new EntityTypes.class_a_in_class_qz(var1, var3, var4));
	}

	public static Entity a(String var0, class_ago var1) {
		Entity var2 = null;

		try {
			Class var3 = (Class) c.get(var0);
			if (var3 != null) {
				var2 = (Entity) var3.getConstructor(new Class[] { class_ago.class }).newInstance(new Object[] { var1 });
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		return var2;
	}

	public static Entity a(class_dn var0, class_ago var1) {
		Entity var2 = null;

		try {
			Class var3 = (Class) c.get(var0.l("id"));
			if (var3 != null) {
				var2 = (Entity) var3.getConstructor(new Class[] { class_ago.class }).newInstance(new Object[] { var1 });
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		if (var2 != null) {
			var2.f(var0);
		} else {
			b.warn("Skipping Entity with id " + var0.l("id"));
		}

		return var2;
	}

	public static Entity a(int var0, class_ago var1) {
		Entity var2 = null;

		try {
			Class var3 = a(var0);
			if (var3 != null) {
				var2 = (Entity) var3.getConstructor(new Class[] { class_ago.class }).newInstance(new Object[] { var1 });
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		if (var2 == null) {
			b.warn("Skipping Entity with id " + var0);
		}

		return var2;
	}

	public static Entity b(String var0, class_ago var1) {
		return a(a(var0), var1);
	}

	public static int a(Entity var0) {
		Integer var1 = (Integer) f.get(var0.getClass());
		return var1 == null ? 0 : var1.intValue();
	}

	public static Class a(int var0) {
		return (Class) e.get(Integer.valueOf(var0));
	}

	public static String b(Entity var0) {
		return a(var0.getClass());
	}

	public static String a(Class var0) {
		return (String) d.get(var0);
	}

	public static int a(String var0) {
		Integer var1 = (Integer) g.get(var0);
		return var1 == null ? 90 : var1.intValue();
	}

	public static void a() {
	}

	public static List b() {
		Set var0 = c.keySet();
		ArrayList var1 = Lists.newArrayList();
		Iterator var2 = var0.iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			Class var4 = (Class) c.get(var3);
			if ((var4.getModifiers() & 1024) != 1024) {
				var1.add(var3);
			}
		}

		var1.add("LightningBolt");
		return var1;
	}

	public static boolean a(Entity var0, String var1) {
		String var2 = b(var0);
		if ((var2 == null) && (var0 instanceof class_yu)) {
			var2 = "Player";
		} else if ((var2 == null) && (var0 instanceof class_xc)) {
			var2 = "LightningBolt";
		}

		return var1.equals(var2);
	}

	public static boolean b(String var0) {
		return "Player".equals(var0) || b().contains(var0);
	}

	static {
		a(class_xg.class, "Item", 1);
		a(class_rd.class, "XPOrb", 2);
		a(class_qv.class, "AreaEffectCloud", 3);
		a(class_zk.class, "ThrownEgg", 7);
		a(class_wv.class, "LeashKnot", 8);
		a(class_ww.class, "Painting", 9);
		a(class_yx.class, "Arrow", 10);
		a(class_zh.class, "Snowball", 11);
		a(class_zc.class, "Fireball", 12);
		a(class_zg.class, "SmallFireball", 13);
		a(class_zl.class, "ThrownEnderpearl", 14);
		a(class_yz.class, "EyeOfEnderSignal", 15);
		a(class_zn.class, "ThrownPotion", 16);
		a(class_zm.class, "ThrownExpBottle", 17);
		a(class_wu.class, "ItemFrame", 18);
		a(class_zp.class, "WitherSkull", 19);
		a(class_xq.class, "PrimedTnt", 20);
		a(class_xf.class, "FallingSand", 21);
		a(class_zb.class, "FireworksRocketEntity", 22);
		a(class_zo.class, "TippedArrow", 23);
		a(class_zi.class, "SpectralArrow", 24);
		a(class_zf.class, "ShulkerBullet", 25);
		a(class_yy.class, "DragonFireball", 26);
		a(class_ws.class, "ArmorStand", 30);
		a(class_xe.class, "Boat", 41);
		a(class_xn.class, class_xh.class_a_in_class_xh.a.b(), 42);
		a(class_xi.class, class_xh.class_a_in_class_xh.b.b(), 43);
		a(class_xl.class, class_xh.class_a_in_class_xh.c.b(), 44);
		a(class_xp.class, class_xh.class_a_in_class_xh.d.b(), 45);
		a(class_xm.class, class_xh.class_a_in_class_xh.f.b(), 46);
		a(class_xo.class, class_xh.class_a_in_class_xh.e.b(), 47);
		a(class_xj.class, class_xh.class_a_in_class_xh.g.b(), 40);
		a(class_rh.class, "Mob", 48);
		a(class_yc.class, "Monster", 49);
		a(class_xu.class, "Creeper", 50, 894731, 0);
		a(class_yh.class, "Skeleton", 51, 12698049, 4802889);
		a(class_yj.class, "Spider", 52, 3419431, 11013646);
		a(class_xz.class, "Giant", 53);
		a(class_yl.class, "Zombie", 54, '?', 7969893);
		a(class_yi.class, "Slime", 55, 5349438, 8306542);
		a(class_xy.class, "Ghast", 56, 16382457, 12369084);
		a(class_yd.class, "PigZombie", 57, 15373203, 5009705);
		a(class_xv.class, "Enderman", 58, 1447446, 0);
		a(class_xt.class, "CaveSpider", 59, 803406, 11013646);
		a(class_yg.class, "Silverfish", 60, 7237230, 3158064);
		a(class_xs.class, "Blaze", 61, 16167425, 16775294);
		a(class_yb.class, "LavaSlime", 62, 3407872, 16579584);
		a(class_vx.class, "EnderDragon", 63);
		a(class_wq.class, "WitherBoss", 64);
		a(class_va.class, "Bat", 65, 4996656, 986895);
		a(class_yk.class, "Witch", 66, 3407872, 5349438);
		a(class_xw.class, "Endermite", 67, 1447446, 7237230);
		a(class_ya.class, "Guardian", 68, 5931634, 15826224);
		a(class_vm.class, "Shulker", 69, 9725844, 5060690);
		a(class_vj.class, "Pig", 90, 15771042, 14377823);
		a(class_vl.class, "Sheep", 91, 15198183, 16758197);
		a(class_ve.class, "Cow", 92, 4470310, 10592673);
		a(class_vd.class, "Chicken", 93, 10592673, 16711680);
		a(class_vo.class, "Squid", 94, 2243405, 7375001);
		a(class_vr.class, "Wolf", 95, 14144467, 13545366);
		a(class_vh.class, "MushroomCow", 96, 10489616, 12040119);
		a(class_vn.class, "SnowMan", 97);
		a(class_vi.class, "Ozelot", 98, 15720061, 5653556);
		a(class_vp.class, "VillagerGolem", 99);
		a(class_vf.class, "EntityHorse", 100, 12623485, 15656192);
		a(class_vk.class, "Rabbit", 101, 10051392, 7555121);
		a(class_yp.class, "Villager", 120, 5651507, 12422002);
		a(class_vw.class, "EnderCrystal", 200);
	}

	public static class class_a_in_class_qz {
		public final String a;
		public final int b;
		public final int c;
		public final class_nd d;
		public final class_nd e;

		public class_a_in_class_qz(String var1, int var2, int var3) {
			a = var1;
			b = var2;
			c = var3;
			d = class_nh.a(this);
			e = class_nh.b(this);
		}
	}
}
