package net.minecraft.server;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import java.util.Map;

import net.minecraft.server.Packet;
import net.minecraft.server.EnumProtocolDirection;
import net.minecraft.server.class_fi;
import net.minecraft.server.class_fk;
import net.minecraft.server.class_fl;
import net.minecraft.server.class_fm;
import net.minecraft.server.class_fn;
import net.minecraft.server.class_fo;
import net.minecraft.server.class_fp;
import net.minecraft.server.class_fq;
import net.minecraft.server.class_fr;
import net.minecraft.server.class_fs;
import net.minecraft.server.class_ft;
import net.minecraft.server.class_fu;
import net.minecraft.server.class_fv;
import net.minecraft.server.class_fw;
import net.minecraft.server.class_fx;
import net.minecraft.server.class_fy;
import net.minecraft.server.PacketPlayOutChat;
import net.minecraft.server.class_ga;
import net.minecraft.server.class_gb;
import net.minecraft.server.class_gc;
import net.minecraft.server.class_gd;
import net.minecraft.server.class_ge;
import net.minecraft.server.class_gf;
import net.minecraft.server.class_gg;
import net.minecraft.server.class_gh;
import net.minecraft.server.class_gi;
import net.minecraft.server.class_gj;
import net.minecraft.server.class_gk;
import net.minecraft.server.class_gl;
import net.minecraft.server.class_gm;
import net.minecraft.server.PacketPlayOutKeepAlive;
import net.minecraft.server.class_go;
import net.minecraft.server.class_gp;
import net.minecraft.server.class_gq;
import net.minecraft.server.class_gr;
import net.minecraft.server.class_gs;
import net.minecraft.server.PacketPlayOutLogin;
import net.minecraft.server.class_gu;
import net.minecraft.server.class_gv;
import net.minecraft.server.class_gw;
import net.minecraft.server.class_gx;
import net.minecraft.server.class_gy;
import net.minecraft.server.class_gz;
import net.minecraft.server.class_ha;
import net.minecraft.server.class_hb;
import net.minecraft.server.class_hc;
import net.minecraft.server.class_hd;
import net.minecraft.server.class_he;
import net.minecraft.server.class_hf;
import net.minecraft.server.class_hg;
import net.minecraft.server.class_hh;
import net.minecraft.server.class_hi;
import net.minecraft.server.class_hj;
import net.minecraft.server.class_hk;
import net.minecraft.server.class_hl;
import net.minecraft.server.class_hm;
import net.minecraft.server.class_hn;
import net.minecraft.server.class_ho;
import net.minecraft.server.class_hp;
import net.minecraft.server.class_hq;
import net.minecraft.server.class_hr;
import net.minecraft.server.class_hs;
import net.minecraft.server.class_ht;
import net.minecraft.server.class_hu;
import net.minecraft.server.class_hv;
import net.minecraft.server.class_hw;
import net.minecraft.server.class_hx;
import net.minecraft.server.class_hy;
import net.minecraft.server.class_hz;
import net.minecraft.server.class_ia;
import net.minecraft.server.class_ib;
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
import net.minecraft.server.PacketHandshakingInSetProtocol;
import net.minecraft.server.class_jh;
import net.minecraft.server.class_ji;
import net.minecraft.server.class_jj;
import net.minecraft.server.class_jk;
import net.minecraft.server.class_jm;
import net.minecraft.server.class_jn;
import net.minecraft.server.class_jr;
import net.minecraft.server.class_js;
import net.minecraft.server.class_jv;
import net.minecraft.server.class_jw;

import org.apache.logging.log4j.LogManager;

public enum EnumProtocol {

	HANDSHAKING(-1) {{
		this.register(EnumProtocolDirection.SERVERBOUND, PacketHandshakingInSetProtocol.class);
	}},
	PLAY(0) {{
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutKeepAlive.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutLogin.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutChat.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hu.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hn.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_ht.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hp.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_he.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fi.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hi.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_ha.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fq.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fp.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hy.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fk.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fn.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fo.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fl.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hm.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hb.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gv.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gv.class_a_in_class_gv.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gv.class_c_in_class_gv.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gv.class_b_in_class_gv.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hz.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hf.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gj.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hl.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hk.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_ib.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hc.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_ho.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_ia.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_go.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_ga.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fv.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fu.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fs.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gp.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gk.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gq.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gs.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gr.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gm.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fm.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gd.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gc.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gg.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_ge.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gf.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gb.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hw.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gu.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_ft.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gw.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fr.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gz.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gx.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fy.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hq.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hs.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hj.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hr.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gh.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gi.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fx.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gy.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hh.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hg.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hv.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_gl.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hx.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_hd.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_fw.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInKeepAlive.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInChat.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInUseEntity.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInFlying.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInFlying.PacketPlayInPosition.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInFlying.PacketPlayInLook.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInFlying.PacketPlayInPositionLook.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInBlockDig.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInUseItem.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_ja.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_iv.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_iy.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_is.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_it.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_il.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_ik.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_ii.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_iw.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_ij.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_ix.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_iq.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_id.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_ih.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_ig.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_im.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_iz.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_iu.class);
	}},
	STATUS(1) {{
		this.register(EnumProtocolDirection.SERVERBOUND, class_jw.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_js.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_jv.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_jr.class);
	}},
	LOGIN(2) {{
		this.register(EnumProtocolDirection.CLIENTBOUND, class_jk.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_ji.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_jh.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, class_jj.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_jm.class);
		this.register(EnumProtocolDirection.SERVERBOUND, class_jn.class);
	}};

	private static int min_protocol_id = -1;
	private static int max_protocol_id = 2;
	private static final EnumProtocol[] protocols = new EnumProtocol[max_protocol_id - min_protocol_id + 1];
	private static final Map<Class<? extends Packet<? extends PacketListener>>, EnumProtocol> packetToProtocol = Maps.newHashMap();

	static {
		for (EnumProtocol protocol : values()) {
			int id = protocol.getId();
			if (id < min_protocol_id || id > max_protocol_id) {
				throw new Error("Invalid protocol ID " + Integer.toString(id));
			}

			protocols[id - min_protocol_id] = protocol;

			for (EnumProtocolDirection protocolDirection : protocol.directionToIdPacketMap.keySet()) {
				for (Class<? extends Packet<? extends PacketListener>> packetClass : protocol.directionToIdPacketMap.get(protocolDirection).values()) {
					if (packetToProtocol.containsKey(packetClass) && packetToProtocol.get(packetClass) != protocol) {
						throw new Error("Packet " + packetClass + " is already assigned to protocol " + packetToProtocol.get(packetClass) + " - can\'t reassign to " + protocol);
					}

					try {
						packetClass.newInstance();
					} catch (Throwable t) {
						throw new Error("Packet " + packetClass + " fails instantiation checks! " + packetClass);
					}

					packetToProtocol.put(packetClass, protocol);
				}
			}
		}
	}

	public static EnumProtocol getById(int id) {
		return id >= min_protocol_id && id <= max_protocol_id ? protocols[id - min_protocol_id] : null;
	}

	public static EnumProtocol getForPacket(Packet<?> packet) {
		return (EnumProtocol) packetToProtocol.get(packet.getClass());
	}

	private final int id;
	private final Map<EnumProtocolDirection, BiMap<Integer, Class<? extends Packet<? extends PacketListener>>>> directionToIdPacketMap = Maps.newEnumMap(EnumProtocolDirection.class);

	EnumProtocol(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	//TODO: Packet<? extends PacketListener>
	protected EnumProtocol register(EnumProtocolDirection direction, Class<? extends Packet> packetClass) {
		BiMap<Integer, Class<? extends Packet<? extends PacketListener>>> idPacketMap = this.directionToIdPacketMap.get(direction);
		if (idPacketMap == null) {
			idPacketMap = HashBiMap.create();
			this.directionToIdPacketMap.put(direction, idPacketMap);
		}

		if (idPacketMap.containsValue(packetClass)) {
			String errorMsg = direction + " packet " + packetClass + " is already known to ID " + idPacketMap.inverse().get(packetClass);
			LogManager.getLogger().fatal(errorMsg);
			throw new IllegalArgumentException(errorMsg);
		} else {
			idPacketMap.put(idPacketMap.size(), (Class<? extends Packet<? extends PacketListener>>) packetClass);
			return this;
		}
	}

	public Integer getPacketId(EnumProtocolDirection direction, Packet<? extends PacketListener> packet) {
		return this.directionToIdPacketMap.get(direction).inverse().get(packet.getClass());
	}

	public Packet<? extends PacketListener> getPacket(EnumProtocolDirection direction, int packetId) throws IllegalAccessException, InstantiationException {
		Class<? extends Packet<? extends PacketListener>> packetClass = this.directionToIdPacketMap.get(direction).get(packetId);
		return packetClass == null ? null : packetClass.newInstance();
	}

}
