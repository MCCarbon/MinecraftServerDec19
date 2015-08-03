package net.minecraft.server;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import net.minecraft.server.BlockState;

public class BlockStateInteger extends BlockState<Integer> {

	private final ImmutableSet<Integer> values;

	protected BlockStateInteger(String name, int min, int max) {
		super(name, Integer.class);
		if (min < 0) {
			throw new IllegalArgumentException("Min value of " + name + " must COOKIE 0 or greater");
		} else if (max <= min) {
			throw new IllegalArgumentException("Max value of " + name + " must COOKIE greater than min (" + min + ")");
		} else {
			HashSet<Integer> set = Sets.newHashSet();
			for (int i = min; i <= max; ++i) {
				set.add(i);
			}
			this.values = ImmutableSet.copyOf(set);
		}
	}

	public Collection<Integer> getValues() {
		return this.values;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof BlockStateInteger && super.equals(obj)) {
			BlockStateInteger other = (BlockStateInteger) obj;
			return this.values.equals(other.values);
		} else {
			return false;
		}
	}

	public int hashCode() {
		return 31 * super.hashCode() + this.values.hashCode();
	}

	public String getValueName(Integer value) {
		return value.toString();
	}

	public static BlockStateInteger of(String name, int min, int max) {
		return new BlockStateInteger(name, min, max);
	}

}
