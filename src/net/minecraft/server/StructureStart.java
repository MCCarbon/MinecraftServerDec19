package net.minecraft.server;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import net.minecraft.server.class_aeh;
import net.minecraft.server.World;
import net.minecraft.server.StructureBoundingBox;
import net.minecraft.server.WorldGenFactory;
import net.minecraft.server.StructurePiece;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;

public abstract class StructureStart {
	protected List<StructurePiece> a = new LinkedList<StructurePiece>();
	protected StructureBoundingBox b;
	private int c;
	private int d;

	public StructureStart() {
	}

	public StructureStart(int var1, int var2) {
		this.c = var1;
		this.d = var2;
	}

	public StructureBoundingBox b() {
		return this.b;
	}

	public List<StructurePiece> c() {
		return this.a;
	}

	public void a(World var1, Random var2, StructureBoundingBox var3) {
		Iterator<StructurePiece> var4 = this.a.iterator();

		while (var4.hasNext()) {
			StructurePiece var5 = (StructurePiece) var4.next();
			if (var5.c().a(var3) && !var5.a(var1, var2, var3)) {
				var4.remove();
			}
		}

	}

	protected void d() {
		this.b = StructureBoundingBox.createMax();
		Iterator<StructurePiece> var1 = this.a.iterator();

		while (var1.hasNext()) {
			StructurePiece var2 = (StructurePiece) var1.next();
			this.b.b(var2.c());
		}

	}

	public NBTTagCompound a(int var1, int var2) {
		NBTTagCompound var3 = new NBTTagCompound();
		var3.put("id", WorldGenFactory.a(this));
		var3.put("ChunkX", var1);
		var3.put("ChunkZ", var2);
		var3.put((String) "BB", (NBTTag) this.b.toNBT());
		NBTTagList var4 = new NBTTagList();
		Iterator<StructurePiece> var5 = this.a.iterator();

		while (var5.hasNext()) {
			StructurePiece var6 = (StructurePiece) var5.next();
			var4.add((NBTTag) var6.b());
		}

		var3.put((String) "Children", (NBTTag) var4);
		this.a(var3);
		return var3;
	}

	public void a(NBTTagCompound var1) {
	}

	public void a(World var1, NBTTagCompound var2) {
		this.c = var2.getInt("ChunkX");
		this.d = var2.getInt("ChunkZ");
		if (var2.has("BB")) {
			this.b = new StructureBoundingBox(var2.getIntArray("BB"));
		}

		NBTTagList var3 = var2.getList("Children", 10);

		for (int var4 = 0; var4 < var3.getSize(); ++var4) {
			this.a.add(WorldGenFactory.b(var3.getCompound(var4), var1));
		}

		this.b(var2);
	}

	public void b(NBTTagCompound var1) {
	}

	protected void a(World var1, Random var2, int var3) {
		int var4 = var1.G() - var3;
		int var5 = this.b.getYLength() + 1;
		if (var5 < var4) {
			var5 += var2.nextInt(var4 - var5);
		}

		int var6 = var5 - this.b.maxY;
		this.b.a(0, var6, 0);
		Iterator<StructurePiece> var7 = this.a.iterator();

		while (var7.hasNext()) {
			StructurePiece var8 = (StructurePiece) var7.next();
			var8.a(0, var6, 0);
		}

	}

	protected void a(World var1, Random var2, int var3, int var4) {
		int var5 = var4 - var3 + 1 - this.b.getYLength();
		boolean var6 = true;
		int var10;
		if (var5 > 1) {
			var10 = var3 + var2.nextInt(var5);
		} else {
			var10 = var3;
		}

		int var7 = var10 - this.b.minY;
		this.b.a(0, var7, 0);
		Iterator<StructurePiece> var8 = this.a.iterator();

		while (var8.hasNext()) {
			StructurePiece var9 = (StructurePiece) var8.next();
			var9.a(0, var7, 0);
		}

	}

	public boolean a() {
		return true;
	}

	public boolean a(class_aeh var1) {
		return true;
	}

	public void b(class_aeh var1) {
	}

	public int e() {
		return this.c;
	}

	public int f() {
		return this.d;
	}

}
