package net.minecraft.server;

import java.util.List;

import net.minecraft.server.BiomeBase.BiomeMeta;
import net.minecraft.server.World;
import net.minecraft.server.Chunk;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.IProgressUpdate;
import net.minecraft.server.EnumCreatureType;

public interface IChunkProvider {

	boolean isChunkLoaded(int var1, int var2);

	Chunk getOrCreateChunk(int var1, int var2);

	Chunk getChunkAt(BlockPosition var1);

	void getChunkAt(IChunkProvider var1, int var2, int var3);

	boolean a(IChunkProvider var1, Chunk var2, int var3, int var4);

	boolean saveChunks(boolean var1, IProgressUpdate var2);

	boolean unloadChunks();

	boolean canSave();

	String getName();

	List<BiomeMeta> getMobsFor(EnumCreatureType var1, BlockPosition var2);

	BlockPosition findNearestMapFeature(World var1, String var2, BlockPosition var3);

	int getLoadedChunks();

	void recreateStructures(Chunk var1, int var2, int var3);

	void c();

}
