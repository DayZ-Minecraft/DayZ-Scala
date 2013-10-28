package com.github.dayzminecraft.dayzscala.common.effect

import net.minecraft.entity.player.EntityPlayer

class Effect(name: String, secondsRemaining: Int) {
  var timeRemaining = secondsRemaining;

  def onUpdate(entityPlayer: EntityPlayer) {

  }
}