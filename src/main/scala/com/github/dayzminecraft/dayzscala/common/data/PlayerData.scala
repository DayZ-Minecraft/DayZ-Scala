package com.github.dayzminecraft.dayzscala.common.data

import net.minecraft.entity.player.EntityPlayer
import com.google.gson.Gson
import java.io._
import java.util.HashMap
import com.github.dayzminecraft.dayzscala.DayZ

class PlayerData(entityPlayer: EntityPlayer) {
  private var data: HashMap[String, AnyRef] = null

  data = new HashMap[String, AnyRef]
  data.put("username", entityPlayer.username)

  def save: Boolean = {
    var dataToSave: HashMap[String, AnyRef] = data
    if (this != null && dataToSave != null) {
      val gson: Gson = new Gson
      try {
        val bw: BufferedWriter = new BufferedWriter(new FileWriter(new File(DayZ.playerDataLocation, dataToSave.get("username") + ".json")))
        bw.write(gson.toJson(dataToSave))
        bw.flush
        bw.close
        dataToSave = null
        return true
      }
      catch {
        case e: IOException => {
          e.printStackTrace
          dataToSave = null
          return false
        }
      }
    }
    else {
      return false
    }
  }

  def load: Boolean = {
    if (this != null && data != null) {
      val playerFile: File = new File(DayZ.playerDataLocation, data.get("username") + ".json")
      if (!playerFile.exists) {
        return false
      }
      val gson: Gson = new Gson()
      var loadedData: HashMap[String, Object] = null
      try {
        loadedData = gson.fromJson(new BufferedReader(new FileReader(playerFile)), classOf[HashMap[String, Object]])
      }

      catch {
        case e: FileNotFoundException => {
          e.printStackTrace
        }
      }
      if (loadedData != null) {
        import scala.collection.JavaConversions._
        for (key <- loadedData.keySet) {
          data.put(key, loadedData.get(key))
        }
        return true
      }
      else {
        return false
      }
    }
    else {
      return false
    }
  }

  final def getData(key: String): Object = {
    return data.get(key)
  }

  def setData(key: String, value: Object): PlayerData = {
    return this
  }

  def getDataMap: HashMap[String, Object] = {
    return data
  }

  def createData(data: HashMap[String, Object]): Boolean = {
    if (this != null && this.data != null) {
      if (data != null) {
        import scala.collection.JavaConversions._
        for (key <- data.keySet) {
          this.data.put(key, data.get(key))
        }
        return true
      }
      else {
        return false
      }
    }
    else {
      return false
    }
  }

  def getPlayer: EntityPlayer = {
    return entityPlayer
  }
}


