package com.github.dayzminecraft.dayzscala.common.block

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.block.material.Material
import net.minecraft.block.Block
import net.minecraft.item.{Item, ItemStack}
import net.minecraftforge.common.Configuration

object Blocks {
  def loadBlocks {
    barbedWire = new BlockBarbedWire(barbedWireId).setUnlocalizedName("barbedWire").setHardness(3F).setResistance(2F)
    GameRegistry.registerBlock(barbedWire, "barbedWire")
    chestLoot = new BlockChestDayZ(chestLootId, 0).setUnlocalizedName("chestLoot")
    GameRegistry.registerBlock(chestLoot, "chestLoot")
    chainFence = new BlockFenceDayZ(chainFenceId, "chainFence", Material.iron).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("chainFence")
    GameRegistry.registerBlock(chainFence, "chainFence")
    sandbagBlock = new BlockMod(sandbagBlockId, Material.clay).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("sandbagBlock")
    GameRegistry.registerBlock(sandbagBlock, "sandbagBlock")
    nailBlock = new BlockNails(nailBlockId).setUnlocalizedName("nailBlock").setHardness(1F).setResistance(1F)
    GameRegistry.registerBlock(nailBlock, "nailBlock")
    GameRegistry.addRecipe(new ItemStack(nailBlock, 8), Array[AnyRef]("#", "#", Character.valueOf('#'), Item.ingotIron))
  }

  def blockConfig(config: Configuration) {
    barbedWireId = config.get(Configuration.CATEGORY_BLOCK, "barbedwireID", 160, "Barbed Wire Block ID").getInt
    chestLootId = config.get(Configuration.CATEGORY_BLOCK, "dayzchestallID", 161, "All Item Chest Block ID").getInt
    chainFenceId = config.get(Configuration.CATEGORY_BLOCK, "chainlinkfenceID", 164, "Chainlink Fence Block ID").getInt
    sandbagBlockId = config.get(Configuration.CATEGORY_BLOCK, "sandbagblockID", 165, "Sandbag Block ID").getInt
    nailBlockId = config.get(Configuration.CATEGORY_BLOCK, "nailsID", 166, "Nail Block ID").getInt
  }

  var barbedWire: Block = null
  private var barbedWireId: Int = 0
  var chestLoot: Block = null
  private var chestLootId: Int = 0
  var chainFence: Block = null
  private var chainFenceId: Int = 0
  var sandbagBlock: Block = null
  private var sandbagBlockId: Int = 0
  var nailBlock: Block = null
  private var nailBlockId: Int = 0
}
