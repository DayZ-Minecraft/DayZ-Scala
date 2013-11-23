package com.github.dayzminecraft.dayzscala.common.world.biomes

import net.minecraft.world.biome.{SpawnListEntry, BiomeGenBase}
import net.minecraft.entity.passive._
import net.minecraft.world.gen.feature.{WorldGenTaiga2, WorldGenTaiga1, WorldGenerator}
import java.util.Random

class BiomeForest(id: Int) extends BiomeGenBase(id: Int) {
  setColor(747097)
  setBiomeName("Forest")
  temperature = BiomeGenBase.forest.temperature
  rainfall = BiomeGenBase.forest.rainfall
  minHeight = 0.1F
  maxHeight = 0.2F
  spawnableMonsterList.clear
  spawnableCreatureList.clear
  spawnableWaterCreatureList.clear
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntitySheep], 4, 4, 4))
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntityPig], 4, 4, 4))
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntityCow], 4, 4, 4))
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntityChicken], 4, 4, 4))
  spawnableCreatureList.asInstanceOf[java.util.ArrayList[SpawnListEntry]].add(new SpawnListEntry(classOf[EntityWolf], 4, 4, 4))
  theBiomeDecorator.treesPerChunk = 7
  theBiomeDecorator.biome.color = 1456435
  theBiomeDecorator.flowersPerChunk = 4
  theBiomeDecorator.grassPerChunk = 10
  theBiomeDecorator.deadBushPerChunk = 4

  override def getRandomWorldGenForTrees(rand: Random): WorldGenerator = {
    return if (rand.nextInt(3) == 0) new WorldGenTaiga1 else new WorldGenTaiga2(false)
  }
}

