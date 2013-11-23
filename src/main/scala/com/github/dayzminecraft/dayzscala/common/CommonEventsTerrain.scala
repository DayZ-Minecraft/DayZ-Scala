package com.github.dayzminecraft.dayzscala.common

import net.minecraftforge.event.terraingen.{WorldTypeEvent, PopulateChunkEvent}
import net.minecraftforge.event.Event.Result
import net.minecraftforge.event.ForgeSubscribe
import dayz.common.world.WorldTypes
import dayz.common.world.genlayer.GenLayerDayZ

object CommonEventsTerrain {
  @ForgeSubscribe def initBiomeGens(event: WorldTypeEvent.InitBiomeGens) {
    if (event.worldType.isInstanceOf[WorldTypes]) {
      event.newBiomeGens = GenLayerDayZ.getGenLayers(event.seed, event.worldType.asInstanceOf[WorldTypes])
    }
  }

  @ForgeSubscribe def populateChunk(event: PopulateChunkEvent.Populate) {
    if (event.world.getWorldInfo.getTerrainType.isInstanceOf[WorldTypes]) {
      if (event.`type` == PopulateChunkEvent.Populate.EventType.LAKE) {
        event.setResult(Result.DENY)
      }
      if (event.`type` == PopulateChunkEvent.Populate.EventType.LAVA) {
        event.setResult(Result.DENY)
      }
      if (event.`type` == PopulateChunkEvent.Populate.EventType.DUNGEON) {
        event.setResult(Result.DENY)
      }
    } /* TODO
    if (event.world.getWorldInfo.getTerrainType.isInstanceOf[WorldTypes] &&
      event.world.rand.nextInt(Config.structureGenerationChance) == 0) {
      for (i <- 0 until 12) {
        val x = event.chunkX * 16 + event.rand.nextInt(16) + 8
        val y = event.rand.nextInt(128)
        val z = event.chunkZ * 16 + event.rand.nextInt(16) + 8
        StructureHandler.generateStructure(event.world, event.rand, x, y, z)
      }
    } */
  }
}