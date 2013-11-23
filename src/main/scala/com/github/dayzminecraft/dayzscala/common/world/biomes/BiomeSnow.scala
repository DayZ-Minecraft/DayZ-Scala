package com.github.dayzminecraft.dayzscala.common.world.biomes

import net.minecraft.world.biome.{SpawnListEntry, BiomeGenBase}
import net.minecraft.entity.passive._
import java.util.Random
import net.minecraft.world.gen.feature.{WorldGenTaiga2, WorldGenTaiga1, WorldGenerator}
import java.util

class BiomeSnow(id: Int) extends BiomeGenBase(id: Int) {
  setColor(747097)
  temperature = BiomeGenBase.icePlains.temperature
  rainfall = BiomeGenBase.icePlains.rainfall
  spawnableMonsterList.clear
  spawnableCreatureList.clear
  spawnableWaterCreatureList.clear
  spawnableCreatureList = new util.ArrayList[SpawnListEntry]()
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntitySheep], 4, 4, 4))
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntityPig], 4, 4, 4))
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntityCow], 4, 4, 4))
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntityChicken], 4, 4, 4))
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntityWolf], 4, 4, 4))
  theBiomeDecorator.treesPerChunk = 2
  theBiomeDecorator.biome.color = 1456435
  theBiomeDecorator.flowersPerChunk = 0
  theBiomeDecorator.grassPerChunk = 4
  theBiomeDecorator.deadBushPerChunk = 0

  override def getRandomWorldGenForTrees(rand: Random): WorldGenerator = {
    return if (rand.nextInt(3) == 0) new WorldGenTaiga1 else new WorldGenTaiga2(false)
  }
}