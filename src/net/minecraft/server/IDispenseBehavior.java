package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.ISourceBlock;

public interface IDispenseBehavior {

	IDispenseBehavior NONE = new IDispenseBehavior() {
		public ItemStack a(ISourceBlock sourceblock, ItemStack itemstack) {
			return itemstack;
		}
	};

	ItemStack a(ISourceBlock sourceblock, ItemStack itemstack);

}
