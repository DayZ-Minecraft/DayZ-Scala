package com.github.dayzminecraft.dayzscala.common

import cpw.mods.fml.common.IPlayerTracker
import net.minecraft.entity.player.EntityPlayer
import com.github.dayzminecraft.dayzscala.common.data.PlayerData
import com.github.dayzminecraft.dayzscala.DayZ

class CommonPlayerHandler extends IPlayerTracker {
  override def onPlayerLogin(entityPlayer: EntityPlayer) {
    val player: PlayerData = new PlayerData(entityPlayer)

    if (!player.load) {
      player.save
    }

    DayZ.players.put(entityPlayer.username, player)
  }

  override def onPlayerLogout(entityPlayer: EntityPlayer) {
    val player: PlayerData = DayZ.players.get(entityPlayer.username)

    if (player.save) {
      DayZ.players.remove(entityPlayer.username)
    }
  }

  override def onPlayerChangedDimension(player: EntityPlayer) {

  }

  override def onPlayerRespawn(player: EntityPlayer) {

  }
}
