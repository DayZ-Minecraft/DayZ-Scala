package com.github.dayzminecraft.dayzscala.common.block

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import com.github.dayzminecraft.dayzscala.DayZ
import net.minecraft.client.renderer.texture.IconRegister

class BlockMod(blockId: Int, material: Material) extends Block(blockId, material) {
  setCreativeTab(DayZ.creativeTab)

  override def registerIcons(register: IconRegister) {
    blockIcon = register.registerIcon(DayZ.meta.modId + ":" + getUnlocalizedName.substring(getUnlocalizedName.indexOf(".") + 1))
  }
}