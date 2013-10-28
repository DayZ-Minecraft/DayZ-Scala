package com.github.dayzminecraft.dayzscala.common.block

import net.minecraft.util.{AxisAlignedBB, DamageSource}
import net.minecraft.world.World
import net.minecraft.entity.Entity
import net.minecraft.block.material.Material

class BlockNails(blockId: Int) extends BlockMod(blockId, material = Material.circuits) {
  override def onEntityCollidedWithBlock(world: World, xCoord: Int, yCoord: Int, zCoord: Int, entity: Entity) {
    entity.attackEntityFrom(DamageSource.generic, 6)
    world.playSoundEffect(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, "random.break", 0.3F, 0.6F)
    world.setBlock(xCoord, yCoord, zCoord, 0)
  }

  override def getCollisionBoundingBoxFromPool(world: World, xCoord: Int, yCoord: Int, zCoord: Int): AxisAlignedBB = {
    return null
  }

  override def isOpaqueCube: Boolean = {
    return false
  }

  override def renderAsNormalBlock: Boolean = {
    return false
  }

  override def getRenderType: Int = {
    return 6
  }
}