package com.github.dayzminecraft.dayzscala.common.block

import net.minecraft.block.BlockPane
import com.github.dayzminecraft.dayzscala.DayZ
import net.minecraft.block.material.Material

class BlockFenceDayZ(blockId: Int, texture: String, material: Material) extends BlockPane(blockId, DayZ.meta.modId + ":" + texture.substring(texture.indexOf(".") + 1), DayZ.meta.modId + ":" + texture.substring(texture.indexOf(".") + 1), material, false) {
  setCreativeTab(DayZ.creativeTab)
}