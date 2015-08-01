package net.minecraft.server;


public class TileEntityFlowerPot extends TileEntity {

	private Item a;
	private int f;

	public TileEntityFlowerPot() {
	}

	public TileEntityFlowerPot(Item var1, int var2) {
		a = var1;
		f = var2;
	}

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		MinecraftKey var2 = Item.ITEM_REGISTRY.getKey(a);
		var1.put("Item", var2 == null ? "" : var2.toString());
		var1.put("Data", f);
	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		if (var1.hasOfType("Item", 8)) {
			a = Item.getByName(var1.getString("Item"));
		} else {
			a = Item.getById(var1.getInt("Item"));
		}

		f = var1.getInt("Data");
	}

	@Override
	public Packet<? extends PacketListener> getUpdatePacket() {
		NBTTagCompound var1 = new NBTTagCompound();
		write(var1);
		var1.remove("Item");
		var1.put("Item", Item.getId(a));
		return new PacketPlayOutTileEntityData(position, 5, var1);
	}

	public void a(Item var1, int var2) {
		a = var1;
		f = var2;
	}

	public Item b() {
		return a;
	}

	public int c() {
		return f;
	}

}
