package com.github.dayzminecraft.dayzscala.common.entity

import net.minecraft.entity.monster.EntityMob
import net.minecraft.entity.player.{EntityPlayer, EntityPlayerMP}
import net.minecraft.entity.passive.EntityVillager
import scala.Predef.{String, classOf}
import net.minecraft.entity.Entity
import net.minecraft.util.DamageSource
import net.minecraft.world.World
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.entity.ai._

class EntityCrawler(world: World) extends EntityMob(world: World) {
  setHealth(12F)
  val moveSpeed: Float = 0.3F
  getNavigator.setBreakDoors(true)
  tasks.addTask(0, new EntityAISwimming(this))
  tasks.addTask(1, new AIBreakDoors(this))
  tasks.addTask(2, new EntityAIAttackOnCollide(this, classOf[EntityPlayerMP], moveSpeed, false))
  tasks.addTask(3, new EntityAIAttackOnCollide(this, classOf[EntityPlayer], moveSpeed, false))
  tasks.addTask(4, new EntityAIAttackOnCollide(this, classOf[EntityVillager], moveSpeed, true))
  tasks.addTask(5, new EntityAIMoveThroughVillage(this, moveSpeed, false))
  tasks.addTask(6, new EntityAIWander(this, moveSpeed))
  tasks.addTask(7, new EntityAIWatchClosest(this, classOf[EntityPlayer], 8F))
  tasks.addTask(8, new EntityAILookIdle(this))
  targetTasks.addTask(9, new EntityAIHurtByTarget(this, false))
  targetTasks.addTask(10, new EntityAINearestAttackableTarget(this, classOf[EntityPlayerMP], 0, true))
  targetTasks.addTask(11, new EntityAINearestAttackableTarget(this, classOf[EntityPlayer], 0, true))
  targetTasks.addTask(12, new EntityAINearestAttackableTarget(this, classOf[EntityVillager], 0, false))

  protected override def canDespawn: Boolean = {
    return false
  }

  protected override def isAIEnabled: Boolean = {
    return true
  }

  protected override def getLivingSound: String = {
    return "mob.zombie.say"
  }

  protected override def getHurtSound: String = {
    return "mob.zombie.hurt"
  }

  protected override def getDeathSound: String = {
    return "mob.zombie.death"
  }

  protected override def findPlayerToAttack: Entity = {
    val entityplayer: EntityPlayer = worldObj.getClosestVulnerablePlayerToEntity(this, 16D)
    if (entityplayer != null && canEntityBeSeen(entityplayer)) {
      return entityplayer
    }
    else {
      return null
    }
  }

  override def attackEntityFrom(damageSource: DamageSource, damage: Float): Boolean = {
    if (super.attackEntityFrom(damageSource, damage)) {
      val entity: Entity = damageSource.getEntity
      if (riddenByEntity.equals(entity) || ridingEntity.equals(entity)) {
        return true
      }
      if (entity ne this) {
        entityToAttack = entity
      }
      return true
    }
    else {
      return false
    }
  }

  protected override def attackEntity(entity: Entity, distanceToEntity: Float) {
    if (attackTime <= 0 && distanceToEntity < 2.0F && entity.boundingBox.maxY > boundingBox.minY && entity.boundingBox.minY < boundingBox.maxY) {
      attackTime = 20
      attackEntityAsMob(entity)
    }
  }

  override def getBlockPathWeight(xCoord: Int, yCoord: Int, zCoord: Int): Float = {
    return 0.5F - worldObj.getLightBrightness(xCoord, yCoord, zCoord)
  }

  override def writeEntityToNBT(tagCompound: NBTTagCompound) {
    super.writeEntityToNBT(tagCompound)
  }
}