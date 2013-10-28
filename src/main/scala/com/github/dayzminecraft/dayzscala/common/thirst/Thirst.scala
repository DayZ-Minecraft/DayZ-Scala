package com.github.dayzminecraft.dayzscala.common.thirst

import net.minecraft.entity.player.EntityPlayer
import cpw.mods.fml.common.FMLCommonHandler
import com.github.dayzminecraft.dayzscala.common.misc.Config
import com.github.dayzminecraft.dayzscala.DayZ
import net.minecraft.network.packet.Packet250CustomPayload
import java.io.{DataOutputStream, ByteArrayOutputStream}
import com.github.dayzminecraft.dayzscala.common.misc.DamageType

class Thirst {
  def this(startingLevel: Int) {
    this()
    level = startingLevel
  }

  var level: Int = 0

  def onUpdate(entityPlayer: EntityPlayer) {
    level += 1
    if (entityPlayer == null || entityPlayer.isDead || entityPlayer.capabilities.isCreativeMode) {
      return
    }
    else if (level == Config.maxThirst - (Config.maxThirst / 10)) {
      val bos: ByteArrayOutputStream = new ByteArrayOutputStream(8)
      val outputStream: DataOutputStream = new DataOutputStream(bos)
      outputStream.writeInt(10)
      DayZ.proxy.sendPacketToPlayer(new Packet250CustomPayload("dayz-thirst", bos.toByteArray), entityPlayer)
      level += 1
    }
    else if (level == Config.maxThirst - (Config.maxThirst / 5)) {
      val bos: ByteArrayOutputStream = new ByteArrayOutputStream(8)
      val outputStream: DataOutputStream = new DataOutputStream(bos)
      outputStream.writeInt(20)
      DayZ.proxy.sendPacketToPlayer(new Packet250CustomPayload("dayz-thirst", bos.toByteArray), entityPlayer)
      level += 1
    }
    else if (level == Config.maxThirst - (Config.maxThirst / 2)) {
      val bos: ByteArrayOutputStream = new ByteArrayOutputStream(8)
      val outputStream: DataOutputStream = new DataOutputStream(bos)
      outputStream.writeInt(50)
      DayZ.proxy.sendPacketToPlayer(new Packet250CustomPayload("dayz-thirst", bos.toByteArray), entityPlayer)
      level += 1
    }
    else if (level >= Config.maxThirst && FMLCommonHandler.instance.getMinecraftServerInstance.getTickCounter % 40 == 0) {
      entityPlayer.attackEntityFrom(DamageType.dehydration, 1)
    }
    else if (entityPlayer.isSprinting || entityPlayer.isAirBorne) {
      level += 2
    }
    else {
      level += 1
    }
  }
}

