package net.minecraft.server;

import java.util.List;

public interface ICommand extends Comparable {
	String getCommand();

	String c(ICommandListener var1);

	List b();

	void execute(ICommandListener var1, String[] var2) throws class_bz;

	boolean canUse(ICommandListener var1);

	List tabComplete(ICommandListener var1, String[] var2, class_cj var3);

	boolean isListStart(String[] var1, int var2);
}
