package net.minecraft.server;


public class PersistentStructure extends PersistentBase {

	private NBTTagCompound b = new NBTTagCompound();

	public PersistentStructure(String var1) {
		super(var1);
	}

	@Override
	public void a(NBTTagCompound var1) {
		this.b = var1.getCompound("Features");
	}

	@Override
	public void b(NBTTagCompound var1) {
		var1.put("Features", this.b);
	}

	public void a(NBTTagCompound var1, int var2, int var3) {
		this.b.put(b(var2, var3), var1);
	}

	public static String b(int var0, int var1) {
		return "[" + var0 + "," + var1 + "]";
	}

	public NBTTagCompound a() {
		return this.b;
	}

}
