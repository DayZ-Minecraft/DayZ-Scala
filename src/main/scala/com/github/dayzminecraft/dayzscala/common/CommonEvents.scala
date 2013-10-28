package com.github.dayzminecraft.dayzscala.common

import net.minecraftforge.event.ForgeSubscribe
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent
import net.minecraft.entity.player.EntityPlayer
import cpw.mods.fml.common.FMLCommonHandler
import com.github.dayzminecraft.dayzscala.common.data.PlayerData
import com.github.dayzminecraft.dayzscala.DayZ
import com.github.dayzminecraft.dayzscala.common.effect.Effect
import com.github.dayzminecraft.dayzscala.common.thirst.Thirst

object CommonEvents {
  @ForgeSubscribe def livingUpdate(e: LivingUpdateEvent) {
    if (FMLCommonHandler.instance().getEffectiveSide.isServer && e.entityLiving.isInstanceOf[EntityPlayer]) {
      handleThirst(e)
      handleEffects(e)
    }
  }

  def handleThirst(e: LivingUpdateEvent) {
    val player = e.entityLiving.asInstanceOf[EntityPlayer]
    val data: PlayerData = DayZ.players.get(player.username)
    val thirst: Thirst = data.getData("thirst").asInstanceOf[Thirst]
    thirst.onUpdate(player)
    DayZ.players.put(player.username, data.setData("thirst", thirst))
  }

  def handleEffects(e: LivingUpdateEvent) {
    val player = e.entityLiving.asInstanceOf[EntityPlayer]
    val data: PlayerData = DayZ.players.get(player.username)
    val effects: Array[Effect] = data.getData("effects").asInstanceOf[Array[Effect]]
    for (effect <- effects) {
      effect.onUpdate(player)
    }
  }
}