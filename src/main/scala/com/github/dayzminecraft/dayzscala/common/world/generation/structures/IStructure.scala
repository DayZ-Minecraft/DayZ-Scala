package com.github.dayzminecraft.dayzscala.common.world.generation.structures

import net.minecraft.world.World
import java.util.Random

trait IStructure {
  def generate(world: World, rand: Random, xCoord: Int, yCoord: Int, zCoord: Int)
}
