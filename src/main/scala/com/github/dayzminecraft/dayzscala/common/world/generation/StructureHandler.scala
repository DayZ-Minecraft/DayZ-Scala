package com.github.dayzminecraft.dayzscala.common.world.generation

import net.minecraft.world.World
import java.util.Random
import com.github.dayzminecraft.dayzscala.common.world.generation.structures.{StructureHouse, StructureFort, IStructure}

object StructureHandler {
  val structures: List[IStructure] = List()

  def generateStructure(world: World, rand: Random, xCoord: Int, yCoord: Int, zCoord: Int): Boolean = {
    structures(rand.nextInt(structures.size)).generate(world, rand, xCoord, yCoord, zCoord)
    return true
  }

  def addStructure(structure: IStructure) {
    structures :+ structure
  }

  def addDefaultStructures {
    addStructure(StructureFort)
    addStructure(StructureHouse)
  }
}
