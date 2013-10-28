package com.github.dayzminecraft.dayzscala.common.misc

import cpw.mods.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.common.Configuration
import java.io.File
import com.github.dayzminecraft.dayzscala.common.block.Blocks

object Config {
  def init(event: FMLPreInitializationEvent) {
    val config: Configuration = new Configuration(new File(event.getModConfigurationDirectory, "DayZ Config.cfg"))
    config.load
    Blocks.blockConfig(config)
    //Items.itemConfig(config)
    //Biomes.biomeConfig(config)
    //WorldTypes.worldTypeConfig(config)
    //Effect.effectConfig(config)
    debug = config.get(Configuration.CATEGORY_GENERAL, "debug", false, "Should DayZ log extra information?").getBoolean(false)
    structureGenerationChance = config.get(Configuration.CATEGORY_GENERAL, "structureGenerationChance", 5, "1 in x chance to generate a structure in a given chunk").getInt(5)
    canSpawnZombiesInDefaultWorld = config.get(Configuration.CATEGORY_GENERAL, "canSpawnZombiesInDefaultWorld", false, "Should DayZ zombies generate in the surface world?").getBoolean(false)
    config.save
  }

  var maxThirst: Int = 24000
  var debug: Boolean = false
  var structureGenerationChance: Int = 5
  var canSpawnZombiesInDefaultWorld: Boolean = false
  var useThirstChat: Boolean = false
}
