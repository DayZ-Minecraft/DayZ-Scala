package com.github.dayzminecraft.dayzscala.common

import cpw.mods.fml.common.IPlayerTracker
import net.minecraft.entity.player.EntityPlayer

class CommonPlayerHandler extends IPlayerTracker {
  override def onPlayerLogin(entityPlayer: EntityPlayer) {
  }

  override def onPlayerLogout(entityPlayer: EntityPlayer) {
  }

  override def onPlayerChangedDimension(player: EntityPlayer) {
  }

  override def onPlayerRespawn(player: EntityPlayer) {
  }
}
