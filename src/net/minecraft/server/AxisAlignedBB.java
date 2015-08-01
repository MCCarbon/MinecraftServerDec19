package net.minecraft.server;

import net.minecraft.server.MovingObjectPosition;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;

public class AxisAlignedBB {

	public final double xMin;
	public final double yMin;
	public final double zMin;
	public final double xMax;
	public final double yMax;
	public final double zMax;

	public AxisAlignedBB(double var1, double var3, double var5, double var7, double var9, double var11) {
		this.xMin = Math.min(var1, var7);
		this.yMin = Math.min(var3, var9);
		this.zMin = Math.min(var5, var11);
		this.xMax = Math.max(var1, var7);
		this.yMax = Math.max(var3, var9);
		this.zMax = Math.max(var5, var11);
	}

	public AxisAlignedBB(BlockPosition var1) {
		this.xMin = (double) var1.getX();
		this.yMin = (double) var1.getY();
		this.zMin = (double) var1.getZ();
		this.xMax = (double) (var1.getX() + 1);
		this.yMax = (double) (var1.getY() + 1);
		this.zMax = (double) (var1.getZ() + 1);
	}

	public AxisAlignedBB(BlockPosition var1, BlockPosition var2) {
		this.xMin = (double) var1.getX();
		this.yMin = (double) var1.getY();
		this.zMin = (double) var1.getZ();
		this.xMax = (double) var2.getX();
		this.yMax = (double) var2.getY();
		this.zMax = (double) var2.getZ();
	}

	public AxisAlignedBB add(double x, double y, double z) {
		double xMin = this.xMin;
		double yMin = this.yMin;
		double zMin = this.zMin;
		double xMax = this.xMax;
		double yMax = this.yMax;
		double zMax = this.zMax;
		if (x < 0.0D) {
			xMin += x;
		} else if (x > 0.0D) {
			xMax += x;
		}

		if (y < 0.0D) {
			yMin += y;
		} else if (y > 0.0D) {
			yMax += y;
		}

		if (z < 0.0D) {
			zMin += z;
		} else if (z > 0.0D) {
			zMax += z;
		}

		return new AxisAlignedBB(xMin, yMin, zMin, xMax, yMax, zMax);
	}

	public AxisAlignedBB grow(double x, double y, double z) {
		double xMin = this.xMin - x;
		double yMin = this.yMin - y;
		double zMin = this.zMin - z;
		double xMax = this.xMax + x;
		double yMax = this.yMax + y;
		double zMax = this.zMax + z;
		return new AxisAlignedBB(xMin, yMin, zMin, xMax, yMax, zMax);
	}

	public AxisAlignedBB a(AxisAlignedBB var1) {
		double var2 = Math.min(this.xMin, var1.xMin);
		double var4 = Math.min(this.yMin, var1.yMin);
		double var6 = Math.min(this.zMin, var1.zMin);
		double var8 = Math.max(this.xMax, var1.xMax);
		double var10 = Math.max(this.yMax, var1.yMax);
		double var12 = Math.max(this.zMax, var1.zMax);
		return new AxisAlignedBB(var2, var4, var6, var8, var10, var12);
	}

	public static AxisAlignedBB a(double var0, double var2, double var4, double var6, double var8, double var10) {
		double var12 = Math.min(var0, var6);
		double var14 = Math.min(var2, var8);
		double var16 = Math.min(var4, var10);
		double var18 = Math.max(var0, var6);
		double var20 = Math.max(var2, var8);
		double var22 = Math.max(var4, var10);
		return new AxisAlignedBB(var12, var14, var16, var18, var20, var22);
	}

	public AxisAlignedBB c(double var1, double var3, double var5) {
		return new AxisAlignedBB(this.xMin + var1, this.yMin + var3, this.zMin + var5, this.xMax + var1, this.yMax + var3, this.zMax + var5);
	}

	public double a(AxisAlignedBB var1, double var2) {
		if (var1.yMax > this.yMin && var1.yMin < this.yMax && var1.zMax > this.zMin && var1.zMin < this.zMax) {
			double var4;
			if (var2 > 0.0D && var1.xMax <= this.xMin) {
				var4 = this.xMin - var1.xMax;
				if (var4 < var2) {
					var2 = var4;
				}
			} else if (var2 < 0.0D && var1.xMin >= this.xMax) {
				var4 = this.xMax - var1.xMin;
				if (var4 > var2) {
					var2 = var4;
				}
			}

			return var2;
		} else {
			return var2;
		}
	}

	public double b(AxisAlignedBB var1, double var2) {
		if (var1.xMax > this.xMin && var1.xMin < this.xMax && var1.zMax > this.zMin && var1.zMin < this.zMax) {
			double var4;
			if (var2 > 0.0D && var1.yMax <= this.yMin) {
				var4 = this.yMin - var1.yMax;
				if (var4 < var2) {
					var2 = var4;
				}
			} else if (var2 < 0.0D && var1.yMin >= this.yMax) {
				var4 = this.yMax - var1.yMin;
				if (var4 > var2) {
					var2 = var4;
				}
			}

			return var2;
		} else {
			return var2;
		}
	}

	public double c(AxisAlignedBB var1, double var2) {
		if (var1.xMax > this.xMin && var1.xMin < this.xMax && var1.yMax > this.yMin && var1.yMin < this.yMax) {
			double var4;
			if (var2 > 0.0D && var1.zMax <= this.zMin) {
				var4 = this.zMin - var1.zMax;
				if (var4 < var2) {
					var2 = var4;
				}
			} else if (var2 < 0.0D && var1.zMin >= this.zMax) {
				var4 = this.zMax - var1.zMin;
				if (var4 > var2) {
					var2 = var4;
				}
			}

			return var2;
		} else {
			return var2;
		}
	}

	public boolean isInside(AxisAlignedBB var1) {
		return var1.xMax > this.xMin && var1.xMin < this.xMax ? (var1.yMax > this.yMin && var1.yMin < this.yMax ? var1.zMax > this.zMin && var1.zMin < this.zMax : false) : false;
	}

	public boolean a(Vec3D var1) {
		return var1.x > this.xMin && var1.x < this.xMax ? (var1.y > this.yMin && var1.y < this.yMax ? var1.z > this.zMin && var1.z < this.zMax : false) : false;
	}

	public double a() {
		double var1 = this.xMax - this.xMin;
		double var3 = this.yMax - this.yMin;
		double var5 = this.zMax - this.zMin;
		return (var1 + var3 + var5) / 3.0D;
	}

	public AxisAlignedBB d(double var1, double var3, double var5) {
		double var7 = this.xMin + var1;
		double var9 = this.yMin + var3;
		double var11 = this.zMin + var5;
		double var13 = this.xMax - var1;
		double var15 = this.yMax - var3;
		double var17 = this.zMax - var5;
		return new AxisAlignedBB(var7, var9, var11, var13, var15, var17);
	}

	public MovingObjectPosition a(Vec3D var1, Vec3D var2) {
		Vec3D var3 = var1.getIntermediateWithXValue(var2, this.xMin);
		Vec3D var4 = var1.getIntermediateWithXValue(var2, this.xMax);
		Vec3D var5 = var1.getIntermediateWithYValue(var2, this.yMin);
		Vec3D var6 = var1.getIntermediateWithYValue(var2, this.yMax);
		Vec3D var7 = var1.getIntermediateWithZValue(var2, this.zMin);
		Vec3D var8 = var1.getIntermediateWithZValue(var2, this.zMax);
		if (!this.b(var3)) {
			var3 = null;
		}

		if (!this.b(var4)) {
			var4 = null;
		}

		if (!this.c(var5)) {
			var5 = null;
		}

		if (!this.c(var6)) {
			var6 = null;
		}

		if (!this.d(var7)) {
			var7 = null;
		}

		if (!this.d(var8)) {
			var8 = null;
		}

		Vec3D var9 = null;
		if (var3 != null) {
			var9 = var3;
		}

		if (var4 != null && (var9 == null || var1.distanceSquared(var4) < var1.distanceSquared(var9))) {
			var9 = var4;
		}

		if (var5 != null && (var9 == null || var1.distanceSquared(var5) < var1.distanceSquared(var9))) {
			var9 = var5;
		}

		if (var6 != null && (var9 == null || var1.distanceSquared(var6) < var1.distanceSquared(var9))) {
			var9 = var6;
		}

		if (var7 != null && (var9 == null || var1.distanceSquared(var7) < var1.distanceSquared(var9))) {
			var9 = var7;
		}

		if (var8 != null && (var9 == null || var1.distanceSquared(var8) < var1.distanceSquared(var9))) {
			var9 = var8;
		}

		if (var9 == null) {
			return null;
		} else {
			EnumDirection var10 = null;
			if (var9 == var3) {
				var10 = EnumDirection.WEST;
			} else if (var9 == var4) {
				var10 = EnumDirection.EAST;
			} else if (var9 == var5) {
				var10 = EnumDirection.DOWN;
			} else if (var9 == var6) {
				var10 = EnumDirection.UP;
			} else if (var9 == var7) {
				var10 = EnumDirection.NORTH;
			} else {
				var10 = EnumDirection.SOUTH;
			}

			return new MovingObjectPosition(var9, var10);
		}
	}

	private boolean b(Vec3D var1) {
		return var1 == null ? false : var1.y >= this.yMin && var1.y <= this.yMax && var1.z >= this.zMin && var1.z <= this.zMax;
	}

	private boolean c(Vec3D var1) {
		return var1 == null ? false : var1.x >= this.xMin && var1.x <= this.xMax && var1.z >= this.zMin && var1.z <= this.zMax;
	}

	private boolean d(Vec3D var1) {
		return var1 == null ? false : var1.x >= this.xMin && var1.x <= this.xMax && var1.y >= this.yMin && var1.y <= this.yMax;
	}

	public String toString() {
		return "box[" + this.xMin + ", " + this.yMin + ", " + this.zMin + " -> " + this.xMax + ", " + this.yMax + ", " + this.zMax + "]";
	}

}
