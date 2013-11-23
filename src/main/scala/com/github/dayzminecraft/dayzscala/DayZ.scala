package com.github.dayzminecraft.dayzscala

import cpw.mods.fml.common.event._
import cpw.mods.fml.common.{ModMetadata, SidedProxy, Mod}
import com.github.dayzminecraft.dayzscala.common.CommonProxy
import cpw.mods.fml.common.network.NetworkMod

@Mod(modid = "DayZ-Scala", name = "DayZ", modLanguage = "scala")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
object DayZ {
  @SidedProxy(clientSide = "com.github.dayzminecraft.dayzscala.client.ClientProxy", serverSide = "com.github.dayzminecraft.dayzscala.common.CommonProxy")
  var proxy: CommonProxy = null

  @Mod.Instance("dayzscala") var INSTANCE: DayZ.type = null

  @Mod.Metadata var meta: ModMetadata = null


  @Mod.EventHandler def preInit(e: FMLPreInitializationEvent) {
    proxy.preInit(e)
  }

  @Mod.EventHandler def init(e: FMLInitializationEvent) {
    proxy.init(e)
  }

  @Mod.EventHandler def postInit(e: FMLPostInitializationEvent) {
    proxy.postInit(e)
  }

  @Mod.EventHandler def serverStarting(e: FMLServerStartingEvent) {
    proxy.serverStarting(e)
  }

  @Mod.EventHandler def serverStopping(e: FMLServerStoppingEvent) {
    proxy.serverStopping(e)
  }
}