package com.github.dayzminecraft.dayzscala.common.world.biomes

import net.minecraft.world.biome.{SpawnListEntry, BiomeGenBase}
import net.minecraft.entity.passive._

class BiomePlains(id: Int) extends BiomeGenBase(id: Int) {
  setColor(747097)
  setBiomeName("Plains")
  temperature = BiomeGenBase.forest.temperature
  rainfall = BiomeGenBase.forest.rainfall
  minHeight = 0.1F
  maxHeight = 0.1F
  spawnableMonsterList.clear
  spawnableCreatureList.clear
  spawnableWaterCreatureList.clear
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntitySheep], 4, 4, 4))
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntityPig], 4, 4, 4))
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntityCow], 4, 4, 4))
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntityChicken], 4, 4, 4))
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntityWolf], 4, 4, 4))
  theBiomeDecorator.biome.color = 1456435
  theBiomeDecorator.flowersPerChunk = 4
  theBiomeDecorator.deadBushPerChunk = 4
  theBiomeDecorator.treesPerChunk = -999
  theBiomeDecorator.grassPerChunk = 20
}

