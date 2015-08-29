package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

public enum EnumProtocol {
	HANDSHAKING(-1) {
		{
			this.register(EnumProtocolDirection.SERVERBOUND, PacketHandshakingInSetProtocol.class);
		}
	},
	PLAY(0) {
		{
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutKeepAlive.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutLogin.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutChat.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutUpdateTime.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutEntityEquipment.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutSpawnPosition.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutUpdateHealth.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutRespawn.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutPosition.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutHeldItemSlot.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutBed.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutAnimation.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutNamedEntitySpawn.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutCollect.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutSpawnEntity.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutSpawnEntityLiving.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutSpawnEntityPainting.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutSpawnEntityExperienceOrb.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutEntityVelocity.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutEntityDestroy.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutEntity.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutEntity.PacketPlayOutRelEntityMove.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutEntity.PacketPlayOutEntityLook.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutEntity.PacketPlayOutRelEntityMoveLook.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutEntityTeleport.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutEntityHeadRotation.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutEntityStatus.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutAttachEntity.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_hl.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_ic.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_hd.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_hp.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_ib.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gp.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_ga.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_fv.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutBlockAction.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutBlockBreakAnimation.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gq.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gl.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gr.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gt.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gs.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gn.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutSpawnEntityWeather.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gd.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gc.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gg.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_ge.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gf.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gb.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_hx.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gv.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutTileEntityData.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutOpenSignEditor.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutStatistic.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_ha.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gy.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_fy.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutScoreboardObjective.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_ht.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_hk.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_hs.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gi.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gj.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_fx.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gz.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_hi.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_hh.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_hw.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gm.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_hy.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_he.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_fw.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_gh.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_ip.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_ig.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_io.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_iq.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_iq.class_a_in_class_iq.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_iq.class_c_in_class_iq.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_iq.class_b_in_class_iq.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_is.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_jc.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_jb.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_iw.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_iz.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_it.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_iu.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_im.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_il.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_ij.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_ix.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_ik.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_iy.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_ir.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_ie.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_ii.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_ih.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_in.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_ja.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_iv.class);
		}
	},
	STATUS(1) {
		{
			this.register(EnumProtocolDirection.SERVERBOUND, class_jx.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_jt.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_jw.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_js.class);
		}
	},
	LOGIN(2) {
		{
			this.register(EnumProtocolDirection.CLIENTBOUND, class_jl.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_jj.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_ji.class);
			this.register(EnumProtocolDirection.CLIENTBOUND, class_jk.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_jn.class);
			this.register(EnumProtocolDirection.SERVERBOUND, class_jo.class);
		}
	};

	private static int min_protocol_id;
	private static int max_protocol_id;
	private static final EnumProtocol[] protocols;
	private static final Map packetToProtocol;
	private final int id;
	private final Map idPacketMap;

	private EnumProtocol(int var3) {
		idPacketMap = Maps.newEnumMap(EnumProtocolDirection.class);
		id = var3;
	}

	protected EnumProtocol register(EnumProtocolDirection var1, Class var2) {
		Object var3 = idPacketMap.get(var1);
		if (var3 == null) {
			var3 = HashBiMap.create();
			idPacketMap.put(var1, var3);
		}

		if (((BiMap) var3).containsValue(var2)) {
			String var4 = var1 + " packet " + var2 + " is already known to ID " + ((BiMap) var3).inverse().get(var2);
			LogManager.getLogger().fatal(var4);
			throw new IllegalArgumentException(var4);
		} else {
			((BiMap) var3).put(Integer.valueOf(((BiMap) var3).size()), var2);
			return this;
		}
	}

	public Integer a(EnumProtocolDirection var1, Packet var2) {
		return (Integer) ((BiMap) idPacketMap.get(var1)).inverse().get(var2.getClass());
	}

	public Packet a(EnumProtocolDirection var1, int var2) throws IllegalAccessException, InstantiationException {
		Class var3 = (Class) ((BiMap) idPacketMap.get(var1)).get(Integer.valueOf(var2));
		return var3 == null ? null : (Packet) var3.newInstance();
	}

	public int a() {
		return id;
	}

	public static EnumProtocol a(int var0) {
		return (var0 >= min_protocol_id) && (var0 <= max_protocol_id) ? protocols[var0 - min_protocol_id] : null;
	}

	public static EnumProtocol a(Packet var0) {
		return (EnumProtocol) packetToProtocol.get(var0.getClass());
	}

	// $FF: synthetic method
	EnumProtocol(int var3, Object var4) {
		this(var3);
	}

	static {
		min_protocol_id = -1;
		max_protocol_id = 2;
		protocols = new EnumProtocol[(max_protocol_id - min_protocol_id) + 1];
		packetToProtocol = Maps.newHashMap();
		EnumProtocol[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			EnumProtocol var3 = var0[var2];
			int var4 = var3.a();
			if ((var4 < min_protocol_id) || (var4 > max_protocol_id)) {
				throw new Error("Invalid protocol ID " + Integer.toString(var4));
			}

			protocols[var4 - min_protocol_id] = var3;
			Iterator var5 = var3.idPacketMap.keySet().iterator();

			while (var5.hasNext()) {
				EnumProtocolDirection var6 = (EnumProtocolDirection) var5.next();

				Class var8;
				for (Iterator var7 = ((BiMap) var3.idPacketMap.get(var6)).values().iterator(); var7.hasNext(); packetToProtocol.put(var8, var3)) {
					var8 = (Class) var7.next();
					if (packetToProtocol.containsKey(var8) && (packetToProtocol.get(var8) != var3)) {
						throw new Error("Packet " + var8 + " is already assigned to protocol " + packetToProtocol.get(var8) + " - can\'t reassign to " + var3);
					}

					try {
						var8.newInstance();
					} catch (Throwable var10) {
						throw new Error("Packet " + var8 + " fails instantiation checks! " + var8);
					}
				}
			}
		}

	}
}
