package com.github.dayzminecraft.dayzscala.client

import net.minecraft.network.packet.{Packet, Packet250CustomPayload}
import cpw.mods.fml.common.network.{Player, PacketDispatcher}
import com.github.dayzminecraft.dayzscala.common.CommonProxy
import cpw.mods.fml.common.event._
import net.minecraft.network.INetworkManager
import net.minecraft.entity.player.EntityPlayer
import java.io.{ByteArrayInputStream, DataInputStream}
import com.github.dayzminecraft.dayzscala.common.misc.Config
import cpw.mods.fml.client.FMLClientHandler
import net.minecraft.util.ChatMessageComponent

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
    packet.channel match {
      case "dayz-thirst" => handleClientThirst(new DataInputStream(new ByteArrayInputStream(packet.data)).readInt())
    }
  }

  override def sendPacketToPlayer(packet: Packet, player: EntityPlayer) = {
    PacketDispatcher.sendPacketToPlayer(packet, player.asInstanceOf[Player])
  }

  override def sendPacket(packet: Packet) = {
    PacketDispatcher.sendPacketToServer(packet)
  }

  def handleClientThirst(percent: Int) = {
    if (Config.useThirstChat) {
      FMLClientHandler.instance().getClient.thePlayer.sendChatMessage(ChatMessageComponent.createFromTranslationKey("thirst.warning." + percent.toString + "percent").toString)
    }
  }
}

