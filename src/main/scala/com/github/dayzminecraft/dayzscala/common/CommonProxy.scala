package com.github.dayzminecraft.dayzscala.common

import net.minecraft.network.packet.{Packet, Packet250CustomPayload}
import cpw.mods.fml.common.network.{Player, PacketDispatcher}
import net.minecraft.entity.player.EntityPlayer
import cpw.mods.fml.common.event._
import net.minecraft.network.INetworkManager
import net.minecraftforge.common.MinecraftForge
import dayz.common.world.WorldTypes

class CommonProxy {
  def preInit(e: FMLPreInitializationEvent) = {
    MinecraftForge.EVENT_BUS.register(CommonEvents)
    MinecraftForge.TERRAIN_GEN_BUS.register(CommonEventsTerrain)
  }

  def init(e: FMLInitializationEvent) = {
    WorldTypes.loadWorldTypes()
  }

  def postInit(e: FMLPostInitializationEvent) = {

  }

  def serverStarting(e: FMLServerStartingEvent) = {

  }

  def serverStopping(e: FMLServerStoppingEvent) = {

  }

  def packetReceived(manager: INetworkManager, packet: Packet250CustomPayload, player: Player) = {

  }

  def sendPacket(packet: Packet) = {

  }

  def sendPacketToPlayer(packet: Packet, player: EntityPlayer) = {

  }
}
