package com.github.dayzminecraft.dayzscala.common.block

import com.github.dayzminecraft.dayzscala.DayZ
import net.minecraft.block.BlockChest

class BlockChestDayZ(blockId: Int, isTrapped: Int) extends BlockChest(blockId, isTrapped) {
  setBlockUnbreakable()
  setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 0.875F, 0.9375F)
  setCreativeTab(DayZ.creativeTab)
}