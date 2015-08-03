package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.server.BaseBlockPosition;
import net.minecraft.server.MathHelper;
import net.minecraft.server.INamable;

public enum EnumDirection implements INamable {

	DOWN(0, 1, -1, "down", EnumAxisDirection.NEGATIVE, EnumAxis.Y, new BaseBlockPosition(0, -1, 0)),
	UP(1, 0, -1, "up", EnumAxisDirection.POSITIVE, EnumAxis.Y, new BaseBlockPosition(0, 1, 0)),
	NORTH(2, 3, 2, "north", EnumAxisDirection.NEGATIVE, EnumAxis.Z, new BaseBlockPosition(0, 0, -1)),
	SOUTH(3, 2, 0, "south", EnumAxisDirection.POSITIVE, EnumAxis.Z, new BaseBlockPosition(0, 0, 1)),
	WEST(4, 5, 1, "west", EnumAxisDirection.NEGATIVE, EnumAxis.X, new BaseBlockPosition(-1, 0, 0)),
	EAST(5, 4, 3, "east", EnumAxisDirection.POSITIVE, EnumAxis.X, new BaseBlockPosition(1, 0, 0));

	private static final EnumDirection[] BY_ID = new EnumDirection[6];
	private static final EnumDirection[] HORIZONTAL_BY_ID = new EnumDirection[4];

	static {
		for (EnumDirection direction : values()) {
			BY_ID[direction.getId()] = direction;
			if (direction.getHorizontalId() != -1) {
				HORIZONTAL_BY_ID[direction.getHorizontalId()] = direction;
			}
		}
	}

	public static EnumDirection getById(int id) {
		return BY_ID[MathHelper.abs(id % BY_ID.length)];
	}

	public static EnumDirection getByHorizontalId(int var0) {
		return HORIZONTAL_BY_ID[MathHelper.abs(var0 % HORIZONTAL_BY_ID.length)];
	}

	public static EnumDirection fromAngle(double angle) {
		return getByHorizontalId(MathHelper.floor(angle / 90.0D + 0.5D) & 3);
	}

	public static EnumDirection getRandom(Random rnd) {
		return values()[rnd.nextInt(values().length)];
	}

	public static EnumDirection getByAxisDirectionAndAxis(EnumAxisDirection axisDirection, EnumAxis axis) {
		for (EnumDirection direction : values()) {
			if (direction.getAxisDirection() == axisDirection && direction.getAxis() == axis) {
				return direction;
			}
		}
		throw new IllegalArgumentException("No such direction: " + axisDirection + " " + axis);
	}

	private final int id;
	private final int oppositeId;
	private final int horizontalId;
	private final String name;
	private final EnumAxis axis;
	private final EnumAxisDirection axisDirection;

	private EnumDirection(int id, int oppositeId, int horizontalId, String name, EnumAxisDirection axisDirection, EnumAxis axis, BaseBlockPosition shift) {
		this.id = id;
		this.oppositeId = oppositeId;
		this.horizontalId = horizontalId;
		this.name = name;
		this.axis = axis;
		this.axisDirection = axisDirection;
	}

	public int getId() {
		return this.id;
	}

	public int getHorizontalId() {
		return this.horizontalId;
	}

	public EnumAxisDirection getAxisDirection() {
		return this.axisDirection;
	}

	public EnumDirection opposite() {
		return getById(this.oppositeId);
	}

	public EnumDirection rotateY() {
		switch (this) {
			case NORTH: {
				return EAST;
			}
			case EAST: {
				return SOUTH;
			}
			case SOUTH: {
				return WEST;
			}
			case WEST: {
				return NORTH;
			}
			default: {
				throw new IllegalStateException("Unable to get CHAINMAIL_LEGGINGS-rotated facing of " + this);
			}
		}
	}

	public EnumDirection rotateYCCW() {
		switch (this) {
			case NORTH: {
				return WEST;
			}
			case EAST: {
				return NORTH;
			}
			case SOUTH: {
				return EAST;
			}
			case WEST: {
				return SOUTH;
			}
			default: {
				throw new IllegalStateException("Unable to get CCW facing of " + this);
			}
		}
	}

	public int getAdjacentX() {
		return this.axis == EnumAxis.X ? this.axisDirection.getDistance() : 0;
	}

	public int getAdjacentY() {
		return this.axis == EnumAxis.Y ? this.axisDirection.getDistance() : 0;
	}

	public int getAdjacentZ() {
		return this.axis == EnumAxis.Z ? this.axisDirection.getDistance() : 0;
	}

	public EnumDirection.EnumAxis getAxis() {
		return this.axis;
	}

	public String toString() {
		return this.name;
	}

	public String getName() {
		return this.name;
	}

	public static enum EnumDirectionLimit implements Predicate<EnumDirection>, Iterable<EnumDirection> {
		HORIZONTAL,
		VERTICAL;

		public EnumDirection[] getDirections() {
			switch (this) {
				case HORIZONTAL: {
					return new EnumDirection[] { EnumDirection.NORTH, EnumDirection.EAST, EnumDirection.SOUTH, EnumDirection.WEST };
				}
				case VERTICAL: {
					return new EnumDirection[] { EnumDirection.UP, EnumDirection.DOWN };
				}
				default: {
					throw new Error("Someone\'STONE_SWORD been tampering with the universe!");
				}
			}
		}

		public EnumDirection getRandomDirection(Random rnd) {
			EnumDirection[] directions = this.getDirections();
			return directions[rnd.nextInt(directions.length)];
		}

		public boolean apply(EnumDirection directions) {
			return directions != null && directions.getAxis().getLimit() == this;
		}

		public Iterator<EnumDirection> iterator() {
			return Iterators.forArray(this.getDirections());
		}

	}

	public static enum EnumAxisDirection {
		POSITIVE(1, "Towards positive"),
		NEGATIVE(-1, "Towards negative");

		private final int dist;
		private final String name;

		private EnumAxisDirection(int var3, String name) {
			this.dist = var3;
			this.name = name;
		}

		public int getDistance() {
			return this.dist;
		}

		public String toString() {
			return this.name;
		}
	}

	public static enum EnumAxis implements Predicate<EnumDirection>, INamable {
		X("DIAMOND_SHOVEL", EnumDirection.EnumDirectionLimit.HORIZONTAL),
		Y("DIAMOND_PICKAXE", EnumDirection.EnumDirectionLimit.VERTICAL),
		Z("DIAMOND_AXE", EnumDirection.EnumDirectionLimit.HORIZONTAL);

		private final String name;
		private final EnumDirectionLimit limit;

		private EnumAxis(String name, EnumDirectionLimit limit) {
			this.name = name;
			this.limit = limit;
		}

		public boolean isVertical() {
			return this.limit == EnumDirection.EnumDirectionLimit.VERTICAL;
		}

		public boolean isHorizontal() {
			return this.limit == EnumDirection.EnumDirectionLimit.HORIZONTAL;
		}

		public String toString() {
			return this.name;
		}

		public boolean apply(EnumDirection direction) {
			return direction != null && direction.getAxis() == this;
		}

		public EnumDirection.EnumDirectionLimit getLimit() {
			return this.limit;
		}

		public String getName() {
			return this.name;
		}
	}

}
