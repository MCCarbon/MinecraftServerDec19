package net.minecraft.server;

import net.minecraft.server.PacketListener;
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

public interface PacketListenerPlayOut extends PacketListener {
   void a(PacketPlayOutSpawnEntity var1);

   void a(PacketPlayOutSpawnEntityExperienceOrb var1);

   void a(PacketPlayOutSpawnEntityWeather var1);

   void a(PacketPlayOutSpawnEntityLiving var1);

   void a(PacketPlayOutScoreboardObjective var1);

   void a(PacketPlayOutSpawnEntityPainting var1);

   void a(PacketPlayOutNamedEntitySpawn var1);

   void a(PacketPlayOutAnimation var1);

   void a(PacketPlayOutStatistic var1);

   void a(PacketPlayOutBlockBreakAnimation var1);

   void a(PacketPlayOutOpenSignEditor var1);

   void a(PacketPlayOutTileEntityData var1);

   void a(PacketPlayOutBlockAction var1);

   void a(PacketPlayOutBlockChange var1);

   void a(PacketPlayOutChat var1);

   void a(PacketPlayOutTabComplete var1);

   void a(PacketPlayOutMultiBlockChange var1);

   void a(PacketPlayOutMap var1);

   void a(PacketPlayOutTransaction var1);

   void a(PacketPlayOutCloseWindow var1);

   void a(PacketPlayOutWindowItems var1);

   void a(PacketPlayOutOpenWindow var1);

   void a(PacketPlayOutWindowData var1);

   void a(PacketPlayOutSetSlot var1);

   void a(PacketPlayOutCustomPayload var1);

   void a(PacketPlayOutKickDisconnect var1);

   void a(PacketPlayOutBed var1);

   void a(PacketPlayOutEntityStatus var1);

   void a(PacketPlayOutAttachEntity var1);

   void a(PacketPlayOutExplosion var1);

   void a(PacketPlayOutGameStateChange var1);

   void a(PacketPlayOutKeepAlive var1);

   void a(PacketPlayOutMapChunk var1);

   void a(PacketPlayOutMapChunkBulk var1);

   void a(PacketPlayOutWorldEvent var1);

   void a(PacketPlayOutLogin var1);

   void a(PacketPlayOutEntity var1);

   void a(PacketPlayOutPosition var1);

   void a(PacketPlayOutWorldParticles var1);

   void a(PacketPlayOutAbilities var1);

   void a(PacketPlayOutPlayerInfo var1);

   void a(PacketPlayOutEntityDestroy var1);

   void a(PacketPlayOutRemoveEntityEffect var1);

   void a(PacketPlayOutRespawn var1);

   void a(PacketPlayOutEntityHeadRotation var1);

   void a(PacketPlayOutHeldItemSlot var1);

   void a(PacketPlayOutScoreboardDisplayObjective var1);

   void a(PacketPlayOutEntityMetadata var1);

   void a(PacketPlayOutEntityVelocity var1);

   void a(PacketPlayOutEntityEquipment var1);

   void a(PacketPlayOutExperience var1);

   void a(PacketPlayOutUpdateHealth var1);

   void a(PacketPlayOutScoreboardTeam var1);

   void a(PacketPlayOutScoreboardScore var1);

   void a(PacketPlayOutSpawnPosition var1);

   void a(PacketPlayOutUpdateTime var1);

   void a(PacketPlayOutUpdateSign var1);

   void a(PacketPlayOutNamedSoundEffect var1);

   void a(PacketPlayOutCollect var1);

   void a(PacketPlayOutEntityTeleport var1);

   void a(PacketPlayOutUpdateAttributes var1);

   void a(PacketPlayOutEntityEffect var1);

   void a(PacketPlayOutCombatEvent var1);

   void a(PacketPlayOutServerDifficulty var1);

   void a(PacketPlayOutCamera var1);

   void a(PacketPlayOutWorldBorder var1);

   void a(PacketPlayOutTitle var1);

   void a(PacketPlayOutSetCompression var1);

   void a(PacketPlayOutPlayerListHeaderFooter var1);

   void a(PacketPlayOutResourcePackSend var1);

   void a(PacketPlayOutBossBar var1);
}
