package com.github.dayzminecraft.dayzscala.common.block

import net.minecraft.world.World
import net.minecraft.entity.Entity
import net.minecraft.util.{AxisAlignedBB, DamageSource}
import java.util.Random
import net.minecraft.block.material.Material

class BlockBarbedWire(blockId: Int) extends BlockMod(blockId: Int, material = Material.iron) {
  override def onEntityCollidedWithBlock(world: World, xCoord: Int, yCoord: Int, zCoord: Int, entity: Entity) {
    entity.attackEntityFrom(DamageSource.generic, 1)
    entity.setInWeb
  }

  override def isOpaqueCube: Boolean = {
    return false
  }

  override def getCollisionBoundingBoxFromPool(world: World, xCoord: Int, yCoord: Int, zCoord: Int): AxisAlignedBB = {
    return null
  }

  override def getRenderType: Int = {
    return 6
  }

  override def renderAsNormalBlock: Boolean = {
    return false
  }

  override def idDropped(metadata: Int, rand: Random, fortune: Int): Int = {
    return Blocks.barbedWire.blockID
  }
}