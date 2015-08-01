package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.EnumDirection;

public class BlockStateDirection extends BlockStateEnum<EnumDirection> {

	protected BlockStateDirection(String name, Collection<EnumDirection> collection) {
		super(name, EnumDirection.class, collection);
	}

	public static BlockStateDirection of(String name) {
		return of(name, Predicates.alwaysTrue());
	}

	public static BlockStateDirection of(String name, Predicate<? super EnumDirection> filter) {
		return of(name, Collections2.filter(Lists.newArrayList(EnumDirection.values()), filter));
	}

	public static BlockStateDirection of(String name, Collection<EnumDirection> collection) {
		return new BlockStateDirection(name, collection);
	}

}
