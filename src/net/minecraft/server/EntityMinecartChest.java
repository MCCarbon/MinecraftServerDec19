package net.minecraft.server;


public class EntityMinecartChest extends class_xk {
	public EntityMinecartChest(class_ago var1) {
		super(var1);
	}

	public EntityMinecartChest(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	public void a(class_qi var1) {
		super.a(var1);
		if (o.S().b("doEntityDrops")) {
			this.a(Item.a(Blocks.CHEST), 1, 0.0F);
		}

	}

	@Override
	public int n_() {
		return 27;
	}

	@Override
	public EntityMinecartAbstract.EnumMinecartType s() {
		return EntityMinecartAbstract.EnumMinecartType.CHEST;
	}

	@Override
	public class_apn u() {
		return Blocks.CHEST.getBlockData().a(BlockChest.a, class_cq.c);
	}

	@Override
	public int w() {
		return 8;
	}

	@Override
	public String k() {
		return "minecraft:chest";
	}

	@Override
	public class_zu a(class_yt var1, class_yu var2) {
		return new class_aaa(var1, this, var2);
	}
}
