package com.github.dayzminecraft.dayzscala.common.entity

import net.minecraft.entity.ai.EntityAIBreakDoor
import net.minecraft.entity.monster.EntityMob

class AIBreakDoors(entityLiving: EntityMob) extends EntityAIBreakDoor(entityLiving: EntityMob) {
  override def updateTask {
    super.updateTask
    if (theEntity.getRNG.nextInt(20) == 0) {
      theEntity.worldObj.playAuxSFX(1010, entityPosX, entityPosY, entityPosZ, 0)
    }
    breakingTime += 1
    val var1: Int = (breakingTime / 240.0F * 10.0F).asInstanceOf[Int]
    if (var1 != field_75358_j) {
      theEntity.worldObj.destroyBlockInWorldPartially(theEntity.entityId, entityPosX, entityPosY, entityPosZ, var1)
      field_75358_j = var1
    }
    if (breakingTime == 240) {
      targetDoor.onPoweredBlockChange(theEntity.worldObj, entityPosX, entityPosY, entityPosZ, true)
      theEntity.worldObj.playAuxSFX(1012, entityPosX, entityPosY, entityPosZ, 0)
      theEntity.worldObj.playAuxSFX(2001, entityPosX, entityPosY, entityPosZ, targetDoor.blockID)
    }
  }

  private var breakingTime: Int = 0
  private var field_75358_j: Int = -1
}

