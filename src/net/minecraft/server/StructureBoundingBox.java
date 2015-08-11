package net.minecraft.server;

import com.google.common.base.Objects;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.BaseBlockPosition;
import net.minecraft.server.NBTTagIntArray;

public class StructureBoundingBox {

	public int minX;
	public int minY;
	public int minZ;
	public int maxX;
	public int maxY;
	public int maxZ;

	public StructureBoundingBox() {
	}

	public StructureBoundingBox(int[] coordArray) {
		if (coordArray.length == 6) {
			this.minX = coordArray[0];
			this.minY = coordArray[1];
			this.minZ = coordArray[2];
			this.maxX = coordArray[3];
			this.maxY = coordArray[4];
			this.maxZ = coordArray[5];
		}
	}

	public static StructureBoundingBox createMax() {
		return new StructureBoundingBox(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
	}

	public static StructureBoundingBox a(int x1, int y1, int z1, int x2, int y2, int z2, int x3, int y3, int z3, EnumDirection direction) {
		switch (direction) {
			case NORTH:
				return new StructureBoundingBox(x1 + x2, y1 + y2, z1 - z3 + 1 + z2, x1 + x3 - 1 + x2, y1 + y3 - 1 + y2, z1 + z2);
			case SOUTH:
				return new StructureBoundingBox(x1 + x2, y1 + y2, z1 + z2, x1 + x3 - 1 + x2, y1 + y3 - 1 + y2, z1 + z3 - 1 + z2);
			case WEST:
				return new StructureBoundingBox(x1 - z3 + 1 + z2, y1 + y2, z1 + x2, x1 + z2, y1 + y3 - 1 + y2, z1 + x3 - 1 + x2);
			case EAST:
				return new StructureBoundingBox(x1 + z2, y1 + y2, z1 + x2, x1 + z3 - 1 + z2, y1 + y3 - 1 + y2, z1 + x3 - 1 + x2);
			default:
				return new StructureBoundingBox(x1 + x2, y1 + y2, z1 + z2, x1 + x3 - 1 + x2, y1 + y3 - 1 + y2, z1 + z3 - 1 + z2);
		}
	}

	public static StructureBoundingBox create(int x1, int y1, int z1, int x2, int y2, int z2) {
		return new StructureBoundingBox(Math.min(x1, x2), Math.min(y1, y2), Math.min(z1, z2), Math.max(x1, x2), Math.max(y1, y2), Math.max(z1, z2));
	}

	public StructureBoundingBox(StructureBoundingBox var1) {
		this.minX = var1.minX;
		this.minY = var1.minY;
		this.minZ = var1.minZ;
		this.maxX = var1.maxX;
		this.maxY = var1.maxY;
		this.maxZ = var1.maxZ;
	}

	public StructureBoundingBox(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
	}

	public StructureBoundingBox(BaseBlockPosition min, BaseBlockPosition max) {
		this.minX = Math.min(min.getX(), max.getX());
		this.minY = Math.min(min.getY(), max.getY());
		this.minZ = Math.min(min.getZ(), max.getZ());
		this.maxX = Math.max(min.getX(), max.getX());
		this.maxY = Math.max(min.getY(), max.getY());
		this.maxZ = Math.max(min.getZ(), max.getZ());
	}

	public StructureBoundingBox(int minX, int minZ, int maxX, int maxZ) {
		this.minX = minX;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxZ = maxZ;
		this.minY = 1;
		this.maxY = 512;
	}

	public boolean a(StructureBoundingBox var1) {
		return this.maxX >= var1.minX && this.minX <= var1.maxX && this.maxZ >= var1.minZ && this.minZ <= var1.maxZ && this.maxY >= var1.minY && this.minY <= var1.maxY;
	}

	public boolean a(int var1, int var2, int var3, int var4) {
		return this.maxX >= var1 && this.minX <= var3 && this.maxZ >= var2 && this.minZ <= var4;
	}

	public void b(StructureBoundingBox var1) {
		this.minX = Math.min(this.minX, var1.minX);
		this.minY = Math.min(this.minY, var1.minY);
		this.minZ = Math.min(this.minZ, var1.minZ);
		this.maxX = Math.max(this.maxX, var1.maxX);
		this.maxY = Math.max(this.maxY, var1.maxY);
		this.maxZ = Math.max(this.maxZ, var1.maxZ);
	}

	public void a(int var1, int var2, int var3) {
		this.minX += var1;
		this.minY += var2;
		this.minZ += var3;
		this.maxX += var1;
		this.maxY += var2;
		this.maxZ += var3;
	}

	public boolean b(BaseBlockPosition var1) {
		return var1.getX() >= this.minX && var1.getX() <= this.maxX && var1.getZ() >= this.minZ && var1.getZ() <= this.maxZ && var1.getY() >= this.minY && var1.getY() <= this.maxY;
	}

	public BaseBlockPosition b() {
		return new BaseBlockPosition(this.maxX - this.minX, this.maxY - this.minY, this.maxZ - this.minZ);
	}

	public int getXLength() {
		return this.maxX - this.minX + 1;
	}

	public int getYLength() {
		return this.maxY - this.minY + 1;
	}

	public int getZLength() {
		return this.maxZ - this.minZ + 1;
	}

	public BaseBlockPosition getCenter() {
		return new BlockPosition(this.minX + (this.maxX - this.minX + 1) / 2, this.minY + (this.maxY - this.minY + 1) / 2, this.minZ + (this.maxZ - this.minZ + 1) / 2);
	}

	public String toString() {
		return Objects.toStringHelper((Object) this).add("x0", this.minX).add("y0", this.minY).add("z0", this.minZ).add("x1", this.maxX).add("y1", this.maxY).add("z1", this.maxZ).toString();
	}

	public NBTTagIntArray toNBT() {
		return new NBTTagIntArray(new int[] { this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ });
	}

}
