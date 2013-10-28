package com.github.dayzminecraft.dayzscala.common.item

import net.minecraft.item.{ItemStack, Item}
import com.github.dayzminecraft.dayzscala.DayZ
import net.minecraft.client.renderer.texture.IconRegister
import net.minecraft.util.Icon
import net.minecraft.entity.player.EntityPlayer
import scala.collection.mutable.ListBuffer

class ItemMod(id: Int) extends Item(id: Int) {
  var subNames: List[String] = new ListBuffer[String].toList

  maxStackSize = 1;
  setCreativeTab(DayZ.creativeTab)

  override def registerIcons(register: IconRegister) {
    itemIcon = register.registerIcon(DayZ.meta.modId + ":" + getUnlocalizedName.substring(getUnlocalizedName.indexOf(".") + 1))
  }

  override def getIcon(stack: ItemStack, pass: Int): Icon = {
    return itemIcon
  }

  def addInformation(itemStack: ItemStack, entityPlayer: EntityPlayer, informationList: List[_], advancedItemTooltips: Boolean) {
    if (subNames == null) {
      return
    }
    for (string <- subNames) {
      informationList.addString(new StringBuilder(string))
    }
  }

  def subNames(strings: String*): Item = {
    for (string <- strings) {
      subNames.addString(new StringBuilder(string))
    }
    return this
  }
}