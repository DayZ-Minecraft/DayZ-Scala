package dayz.common.world;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.common.Configuration;

public class WorldTypes extends WorldType {
  private static int DAYZ_ID = 12;
  public static WorldTypes DAYZ;
  private static int SNOW_ID = 13;
  public static WorldTypes SNOW;

  public WorldTypes(int id, String worldName) {
    super(id, worldName, 0);
  }

  public static void loadWorldTypes() {
    DAYZ = (new WorldTypes(DAYZ_ID, "DAYZBASE"));
    SNOW = (new WorldTypes(SNOW_ID, "DAYZSNOW"));
  }

  public static void worldTypeConfig(Configuration config) {
    DAYZ_ID = config.get("worldtype", "dayzId", 12).getInt();
    SNOW_ID = config.get("worldtype", "snowId", 13).getInt();
  }

  public BiomeGenBase[] setMajorBiomes() {
    if (this == DAYZ) {
      return new BiomeGenBase[] {Biomes.biomeForest};
    } else if (this == SNOW) {
      return new BiomeGenBase[] {Biomes.biomeSnowPlains};
    }
    return null;
  }

  public BiomeGenBase setMinorBiomes(BiomeGenBase biome, GenLayer genLayer) {
    if (this == DAYZ) {
      return Biomes.biomePlains;
    } else if (this == SNOW) {
      return Biomes.biomeSnowMountains;
    }
    return null;
  }

  public BiomeGenBase setOceanBiomes(BiomeGenBase biome, GenLayer genLayer) {
    return null;
  }

  public BiomeGenBase setRiverBiomes(BiomeGenBase biome, GenLayer genLayer) {
    if (this == DAYZ) {
      return Biomes.biomeRiver;
    } else if (this == SNOW) {
      return Biomes.biomeRiver;
    }
    return null;
  }

  public BiomeGenBase setBorderBiomes(BiomeGenBase biome1, BiomeGenBase biome2, GenLayer genLayer) {
    return null;
  }

  public BiomeGenBase setMiscellaneousBiomes(GenLayer genLayer) {
    return null;
  }

  @Override
  public int getSpawnFuzz() {
    return 100;
  }
}