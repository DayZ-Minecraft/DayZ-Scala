package com.github.dayzminecraft.dayzscala.common.misc

import net.minecraft.creativetab.CreativeTabs

class CreativeTab extends CreativeTabs("creativeTabDayZ") {
  override def getTabIconItemIndex(): Int = {
    return 1
  }
}