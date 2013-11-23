package com.github.dayzminecraft.dayzscala.client

import net.minecraft.network.packet.{Packet, Packet250CustomPayload}
import cpw.mods.fml.common.network.{Player, PacketDispatcher}
import com.github.dayzminecraft.dayzscala.common.CommonProxy
import cpw.mods.fml.common.event._
import net.minecraft.network.INetworkManager
import net.minecraft.entity.player.EntityPlayer

class ClientProxy extends CommonProxy {
  override def preInit(e: FMLPreInitializationEvent) = {
    super.preInit(e)
  }

  override def init(e: FMLInitializationEvent) = {
    super.init(e)
  }

  override def postInit(e: FMLPostInitializationEvent) = {
    super.postInit(e)
  }

  override def serverStarting(e: FMLServerStartingEvent) = {
    super.serverStarting(e)
  }

  override def serverStopping(e: FMLServerStoppingEvent) = {
    super.serverStopping(e)
  }

  override def packetReceived(manager: INetworkManager, packet: Packet250CustomPayload, player: Player) = {
  }

  override def sendPacketToPlayer(packet: Packet, player: EntityPlayer) = {
  }

  override def sendPacket(packet: Packet) = {
  }

  def handleClientThirst(percent: Int) = {
  }
}

