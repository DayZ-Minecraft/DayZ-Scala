package com.github.dayzminecraft.dayzscala.common.misc

import net.minecraft.util.DamageSource

object DamageType {
  final val bleeding: DamageType = new DamageType("bleedOut").setDamageBypassesArmor.asInstanceOf[DamageType]
  final val infection: DamageType = new DamageType("zombieInfection").setDamageBypassesArmor.asInstanceOf[DamageType]
  final val dehydration: DamageType = new DamageType("dehydration").setDamageBypassesArmor.asInstanceOf[DamageType]

  class DamageType(damageType: String) extends DamageSource(damageType: String) {
    override def setDamageBypassesArmor: DamageSource = {
      return super.setDamageBypassesArmor
    }

    override def setDamageAllowedInCreativeMode: DamageSource = {
      return super.setDamageAllowedInCreativeMode
    }

    override def setFireDamage: DamageSource = {
      return super.setFireDamage
    }
  }

}

