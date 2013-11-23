package com.github.dayzminecraft.dayzscala

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.network.NetworkMod

@Mod(modid = "DayZ-Scala", name = "DayZ", modLanguage = "scala")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
object DayZ {
  @Mod.Instance("dayzscala") var INSTANCE: DayZ.type = null

  def uselessMethod() {
    System.out.println("This is pretty useless...")
  }
}