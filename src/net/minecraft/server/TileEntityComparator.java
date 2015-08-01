package net.minecraft.server;


public class TileEntityComparator extends TileEntity {

	private int a;

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("OutputSignal", a);
	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		a = var1.getInt("OutputSignal");
	}

	public int b() {
		return a;
	}

	public void a(int var1) {
		a = var1;
	}

}
