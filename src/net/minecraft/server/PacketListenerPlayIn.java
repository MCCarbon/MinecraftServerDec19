package net.minecraft.server;

import net.minecraft.server.PacketListener;
import net.minecraft.server.PacketPlayInTabComplete;
import net.minecraft.server.PacketPlayInChat;
import net.minecraft.server.PacketPlayInClientCommand;
import net.minecraft.server.PacketPlayInSettings;
import net.minecraft.server.PacketPlayInTransaction;
import net.minecraft.server.PacketPlayInEnchantItem;
import net.minecraft.server.PacketPlayInWindowClick;
import net.minecraft.server.PacketPlayInCloseWindow;
import net.minecraft.server.PacketPlayInCustomPayload;
import net.minecraft.server.PacketPlayInUseEntity;
import net.minecraft.server.PacketPlayInKeepAlive;
import net.minecraft.server.PacketPlayInFlying;
import net.minecraft.server.PacketPlayInAbilities;
import net.minecraft.server.PacketPlayInBlockDig;
import net.minecraft.server.PacketPlayInEntityAction;
import net.minecraft.server.PacketPlayInSteerVehicle;
import net.minecraft.server.PacketPlayInResourcePackStatus;
import net.minecraft.server.PacketPlayInHeldItemSlot;
import net.minecraft.server.PacketPlayInSetCreativeSlot;
import net.minecraft.server.PacketPlayInUpdateSign;
import net.minecraft.server.PacketPlayInArmAnimation;
import net.minecraft.server.PacketPlayInSpectate;
import net.minecraft.server.PacketPlayInBlockPlace;
import net.minecraft.server.PacketPlayInUseItem;

public interface PacketListenerPlayIn extends PacketListener {

	void handle(PacketPlayInArmAnimation packet);

	void handle(PacketPlayInChat packet);

	void handle(PacketPlayInTabComplete packet);

	void handle(PacketPlayInClientCommand packet);

	void handle(PacketPlayInSettings packet);

	void handle(PacketPlayInTransaction packet);

	void handle(PacketPlayInEnchantItem packet);

	void handle(PacketPlayInWindowClick packet);

	void handle(PacketPlayInCloseWindow packet);

	void handle(PacketPlayInCustomPayload packet);

	void handle(PacketPlayInUseEntity packet);

	void handle(PacketPlayInKeepAlive packet);

	void handle(PacketPlayInFlying packet);

	void handle(PacketPlayInAbilities packet);

	void handle(PacketPlayInBlockDig packet);

	void handle(PacketPlayInEntityAction packet);

	void handle(PacketPlayInSteerVehicle packet);

	void handle(PacketPlayInHeldItemSlot packet);

	void handle(PacketPlayInSetCreativeSlot packet);

	void handle(PacketPlayInUpdateSign packet);

	void handle(PacketPlayInBlockPlace packet);

	void handle(PacketPlayInUseItem packet);

	void handle(PacketPlayInSpectate packet);

	void handle(PacketPlayInResourcePackStatus packet);

}
