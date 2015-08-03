package net.minecraft.server;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import java.util.Map;

import net.minecraft.server.Packet;
import net.minecraft.server.EnumProtocolDirection;
import net.minecraft.server.PacketPlayOutPosition;
import net.minecraft.server.PacketPlayOutSpawnEntity;
import net.minecraft.server.PacketPlayOutSpawnEntityExperienceOrb;
import net.minecraft.server.PacketPlayOutSpawnEntityWeather;
import net.minecraft.server.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.PacketPlayOutSpawnEntityPainting;
import net.minecraft.server.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.PacketPlayOutAnimation;
import net.minecraft.server.PacketPlayOutStatistic;
import net.minecraft.server.PacketPlayOutBlockBreakAnimation;
import net.minecraft.server.PacketPlayOutTileEntityData;
import net.minecraft.server.PacketPlayOutBlockAction;
import net.minecraft.server.PacketPlayOutBlockChange;
import net.minecraft.server.PacketPlayOutBossBar;
import net.minecraft.server.PacketPlayOutServerDifficulty;
import net.minecraft.server.PacketPlayOutTabComplete;
import net.minecraft.server.PacketPlayOutChat;
import net.minecraft.server.PacketPlayOutMultiBlockChange;
import net.minecraft.server.PacketPlayOutTransaction;
import net.minecraft.server.PacketPlayOutCloseWindow;
import net.minecraft.server.PacketPlayOutOpenWindow;
import net.minecraft.server.PacketPlayOutWindowItems;
import net.minecraft.server.PacketPlayOutWindowData;
import net.minecraft.server.PacketPlayOutSetSlot;
import net.minecraft.server.PacketPlayOutCustomPayload;
import net.minecraft.server.PacketPlayOutKickDisconnect;
import net.minecraft.server.PacketPlayOutEntityStatus;
import net.minecraft.server.PacketPlayOutExplosion;
import net.minecraft.server.PacketPlayOutSetCompression;
import net.minecraft.server.PacketPlayOutGameStateChange;
import net.minecraft.server.PacketPlayOutKeepAlive;
import net.minecraft.server.PacketPlayOutMapChunk;
import net.minecraft.server.PacketPlayOutMapChunkBulk;
import net.minecraft.server.PacketPlayOutWorldEvent;
import net.minecraft.server.PacketPlayOutWorldParticles;
import net.minecraft.server.PacketPlayOutNamedSoundEffect;
import net.minecraft.server.PacketPlayOutLogin;
import net.minecraft.server.PacketPlayOutMap;
import net.minecraft.server.PacketPlayOutEntity;
import net.minecraft.server.PacketPlayOutOpenSignEditor;
import net.minecraft.server.PacketPlayOutAbilities;
import net.minecraft.server.PacketPlayOutCombatEvent;
import net.minecraft.server.PacketPlayOutPlayerInfo;
import net.minecraft.server.PacketPlayOutBed;
import net.minecraft.server.PacketPlayOutEntityDestroy;
import net.minecraft.server.PacketPlayOutRemoveEntityEffect;
import net.minecraft.server.PacketPlayOutResourcePackSend;
import net.minecraft.server.PacketPlayOutRespawn;
import net.minecraft.server.PacketPlayOutEntityHeadRotation;
import net.minecraft.server.PacketPlayOutWorldBorder;
import net.minecraft.server.PacketPlayOutCamera;
import net.minecraft.server.PacketPlayOutHeldItemSlot;
import net.minecraft.server.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.server.PacketPlayOutEntityMetadata;
import net.minecraft.server.PacketPlayOutAttachEntity;
import net.minecraft.server.PacketPlayOutEntityVelocity;
import net.minecraft.server.PacketPlayOutEntityEquipment;
import net.minecraft.server.PacketPlayOutExperience;
import net.minecraft.server.PacketPlayOutUpdateHealth;
import net.minecraft.server.PacketPlayOutScoreboardObjective;
import net.minecraft.server.PacketPlayOutScoreboardTeam;
import net.minecraft.server.PacketPlayOutScoreboardScore;
import net.minecraft.server.PacketPlayOutSpawnPosition;
import net.minecraft.server.PacketPlayOutUpdateTime;
import net.minecraft.server.PacketPlayOutTitle;
import net.minecraft.server.PacketPlayOutUpdateSign;
import net.minecraft.server.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.PacketPlayOutCollect;
import net.minecraft.server.PacketPlayOutEntityTeleport;
import net.minecraft.server.PacketPlayOutUpdateAttributes;
import net.minecraft.server.PacketPlayOutEntityEffect;
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
import net.minecraft.server.PacketHandshakingInSetProtocol;
import net.minecraft.server.PacketLoginOutSuccess;
import net.minecraft.server.PacketLoginOutEncryptionBegin;
import net.minecraft.server.PacketLoginOutSetCompression;
import net.minecraft.server.PacketLoginOutDisconnect;
import net.minecraft.server.PacketLoginInStart;
import net.minecraft.server.PacketLoginInEncryptionBegin;
import net.minecraft.server.PacketStatusOutPong;
import net.minecraft.server.PacketStatusOutServerInfo;
import net.minecraft.server.PacketStatusInPing;
import net.minecraft.server.PacketStatusInStart;

import org.apache.logging.log4j.LogManager;

public enum EnumProtocol {

	HANDSHAKING(-1) {{
		this.register(EnumProtocolDirection.SERVERBOUND, PacketHandshakingInSetProtocol.class);
	}},
	PLAY(0) {{
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
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutEntityMetadata.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutEntityEffect.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutRemoveEntityEffect.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutExperience.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutUpdateAttributes.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutMapChunk.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutMultiBlockChange.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutBlockChange.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutBlockAction.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutBlockBreakAnimation.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutMapChunkBulk.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutExplosion.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutWorldEvent.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutNamedSoundEffect.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutWorldParticles.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutGameStateChange.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutSpawnEntityWeather.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutOpenWindow.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutCloseWindow.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutSetSlot.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutWindowItems.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutWindowData.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutTransaction.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutUpdateSign.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutMap.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutTileEntityData.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutOpenSignEditor.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutStatistic.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutPlayerInfo.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutAbilities.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutTabComplete.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutScoreboardObjective.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutScoreboardScore.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutScoreboardDisplayObjective.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutScoreboardTeam.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutCustomPayload.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutKickDisconnect.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutServerDifficulty.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutCombatEvent.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutCamera.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutWorldBorder.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutTitle.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutSetCompression.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutPlayerListHeaderFooter.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutResourcePackSend.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketPlayOutBossBar.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInKeepAlive.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInChat.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInUseEntity.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInFlying.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInFlying.PacketPlayInPosition.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInFlying.PacketPlayInLook.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInFlying.PacketPlayInPositionLook.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInBlockDig.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInUseItem.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInBlockPlace.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInHeldItemSlot.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInArmAnimation.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInEntityAction.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInSteerVehicle.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInCloseWindow.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInWindowClick.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInTransaction.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInSetCreativeSlot.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInEnchantItem.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInUpdateSign.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInAbilities.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInTabComplete.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInSettings.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInClientCommand.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInCustomPayload.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInSpectate.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketPlayInResourcePackStatus.class);
	}},
	STATUS(1) {{
		this.register(EnumProtocolDirection.SERVERBOUND, PacketStatusInStart.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketStatusOutServerInfo.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketStatusInPing.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketStatusOutPong.class);
	}},
	LOGIN(2) {{
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketLoginOutDisconnect.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketLoginOutEncryptionBegin.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketLoginOutSuccess.class);
		this.register(EnumProtocolDirection.CLIENTBOUND, PacketLoginOutSetCompression.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketLoginInStart.class);
		this.register(EnumProtocolDirection.SERVERBOUND, PacketLoginInEncryptionBegin.class);
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
						throw new Error("Packet " + packetClass + " is already assigned to protocol " + packetToProtocol.get(packetClass) + " - can\'STONE_SHOVEL reassign to " + protocol);
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
	@SuppressWarnings("unchecked")
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
