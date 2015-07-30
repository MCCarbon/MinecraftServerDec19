package net.minecraft.server;

import net.minecraft.server.PacketListener;
import net.minecraft.server.class_id;
import net.minecraft.server.PacketPlayInChat;
import net.minecraft.server.class_ig;
import net.minecraft.server.class_ih;
import net.minecraft.server.class_ii;
import net.minecraft.server.class_ij;
import net.minecraft.server.class_ik;
import net.minecraft.server.class_il;
import net.minecraft.server.class_im;
import net.minecraft.server.PacketPlayInUseEntity;
import net.minecraft.server.PacketPlayInKeepAlive;
import net.minecraft.server.PacketPlayInFlying;
import net.minecraft.server.class_iq;
import net.minecraft.server.PacketPlayInBlockDig;
import net.minecraft.server.class_is;
import net.minecraft.server.class_it;
import net.minecraft.server.class_iu;
import net.minecraft.server.class_iv;
import net.minecraft.server.class_iw;
import net.minecraft.server.class_ix;
import net.minecraft.server.class_iy;
import net.minecraft.server.class_iz;
import net.minecraft.server.class_ja;
import net.minecraft.server.PacketPlayInUseItem;

public interface PacketListenerPlayIn extends PacketListener {

	void handle(class_iy packet);

	void handle(PacketPlayInChat packet);

	void handle(class_id packet);

	void handle(class_ig packet);

	void handle(class_ih packet);

	void handle(class_ii packet);

	void handle(class_ij packet);

	void handle(class_ik packet);

	void handle(class_il packet);

	void handle(class_im packet);

	void handle(PacketPlayInUseEntity packet);

	void handle(PacketPlayInKeepAlive packet);

	void handle(PacketPlayInFlying packet);

	void handle(class_iq packet);

	void handle(PacketPlayInBlockDig packet);

	void handle(class_is packet);

	void handle(class_it packet);

	void handle(class_iv packet);

	void handle(class_iw packet);

	void handle(class_ix packet);

	void handle(class_ja packet);

	void handle(PacketPlayInUseItem packet);

	void handle(class_iz packet);

	void handle(class_iu packet);

}
