package com.github.dayzminecraft.dayzscala.common

import net.minecraft.network.packet.{Packet, Packet250CustomPayload}
import cpw.mods.fml.common.network.{Player, PacketDispatcher}
import net.minecraft.entity.player.EntityPlayer
import cpw.mods.fml.common.event._
import net.minecraft.network.INetworkManager
import com.github.dayzminecraft.dayzscala.DayZ
import java.io.File
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraftforge.common.MinecraftForge

class CommonProxy {
  def preInit(e: FMLPreInitializationEvent) = {
    DayZ.playerDataLocation = new File(e.getSuggestedConfigurationFile, "/PlayerData")
    DayZ.playerDataLocation.mkdirs
    MinecraftForge.EVENT_BUS.register(CommonEvents)
  }

  def init(e: FMLInitializationEvent) = {
    GameRegistry.registerPlayerTracker(new CommonPlayerHandler)
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
    PacketDispatcher.sendPacketToAllPlayers(packet)
  }

  def sendPacketToPlayer(packet: Packet, player: EntityPlayer) = {
    PacketDispatcher.sendPacketToPlayer(packet, player.asInstanceOf[Player])
  }
}
