package com.github.dayzminecraft.dayzscala.common.network

import cpw.mods.fml.common.network.{Player, IPacketHandler}
import net.minecraft.network.INetworkManager
import net.minecraft.network.packet.Packet250CustomPayload
import com.github.dayzminecraft.dayzscala.DayZ

class PacketReceiver extends IPacketHandler {
  override def onPacketData(manager: INetworkManager, packet: Packet250CustomPayload, player: Player) {
    DayZ.proxy.packetReceived(manager, packet, player)
  }
}