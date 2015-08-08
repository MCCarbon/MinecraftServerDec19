package net.minecraft.server;

import java.util.Random;

public class TileEntityEnchantTable extends TileEntity implements ITickAble, ITileEntityContainer {

	public int a;
	public float f;
	public float g;
	public float h;
	public float i;
	public float j;
	public float k;
	public float l;
	public float m;
	public float n;
	private static Random o = new Random();
	private String p;

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		if (hasCustomName()) {
			var1.put("CustomName", p);
		}

	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		if (var1.hasOfType("CustomName", 8)) {
			p = var1.getString("CustomName");
		}

	}

	@Override
	public void tick() {
		k = j;
		m = l;
		EntityHuman var1 = world.a(position.getX() + 0.5F, position.getY() + 0.5F, position.getZ() + 0.5F, 3.0D);
		if (var1 != null) {
			double var2 = var1.locX - (position.getX() + 0.5F);
			double var4 = var1.locZ - (position.getZ() + 0.5F);
			n = (float) MathHelper.b(var4, var2);
			j += 0.1F;
			if ((j < 0.5F) || (o.nextInt(40) == 0)) {
				float var6 = h;

				do {
					h += o.nextInt(4) - o.nextInt(4);
				} while (var6 == h);
			}
		} else {
			n += 0.02F;
			j -= 0.1F;
		}

		while (l >= 3.1415927F) {
			l -= 6.2831855F;
		}

		while (l < -3.1415927F) {
			l += 6.2831855F;
		}

		while (n >= 3.1415927F) {
			n -= 6.2831855F;
		}

		while (n < -3.1415927F) {
			n += 6.2831855F;
		}

		float var7;
		for (var7 = n - l; var7 >= 3.1415927F; var7 -= 6.2831855F) {
			;
		}

		while (var7 < -3.1415927F) {
			var7 += 6.2831855F;
		}

		l += var7 * 0.4F;
		j = MathHelper.clamp(j, 0.0F, 1.0F);
		++a;
		g = f;
		float var3 = (h - f) * 0.4F;
		float var8 = 0.2F;
		var3 = MathHelper.clamp(var3, -var8, var8);
		i += (var3 - i) * 0.9F;
		f += i;
	}

	@Override
	public String getName() {
		return hasCustomName() ? p : "container.enchant";
	}

	@Override
	public boolean hasCustomName() {
		return (p != null) && !p.isEmpty();
	}

	public void a(String var1) {
		p = var1;
	}

	@Override
	public IChatBaseComponent getScoreboardDisplayName() {
		return hasCustomName() ? new ChatComponentText(getName()) : new ChatMessage(getName(), new Object[0]);
	}

	@Override
	public Container createContainer(PlayerInventory var1, EntityHuman var2) {
		return new class_yj(var1, world, position);
	}

	@Override
	public String getContainerName() {
		return "minecraft:enchanting_table";
	}
}
