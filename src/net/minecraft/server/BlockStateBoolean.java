package net.minecraft.server;

import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import net.minecraft.server.BlockState;

public class BlockStateBoolean extends BlockState<Boolean> {

	private final ImmutableSet<Boolean> values = ImmutableSet.of(Boolean.valueOf(true), Boolean.valueOf(false));

	protected BlockStateBoolean(String var1) {
		super(var1, Boolean.class);
	}

	public Collection<Boolean> getValues() {
		return this.values;
	}

	public String getValueName(Boolean bool) {
		return bool.toString();
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof BlockStateBoolean && super.equals(obj)) {
			BlockStateBoolean other = (BlockStateBoolean) obj;
			return this.values.equals(other.values);
		} else {
			return false;
		}
	}

	public int hashCode() {
		return 31 * super.hashCode() + this.values.hashCode();
	}

	public static BlockStateBoolean of(String name) {
		return new BlockStateBoolean(name);
	}

}
