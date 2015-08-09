package net.minecraft.server;

import net.minecraft.server.ICommand;
import net.minecraft.server.ICommandListener;

public interface ICommandDispatcher {
   void a(ICommandListener icommandlistener, ICommand icommand, int i, String s, Object... aobject);
}
