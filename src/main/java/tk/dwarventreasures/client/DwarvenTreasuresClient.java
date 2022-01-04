package tk.dwarventreasures.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.BiomeKeys;
import tk.dwarventreasures.client.network.packet.SpawnFlameParticlesPacket;
import tk.dwarventreasures.client.network.packet.SpawnSnowParticlesPacket;
import tk.dwarventreasures.common.registry.DTObjects;

//@SuppressWarnings("UnstableApiUsage")
public class DwarvenTreasuresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), DTObjects.EMPTY_COPPER_GOBLET, DTObjects.EMPTY_GOLDEN_GOBLET, DTObjects.EMPTY_DEBRIS_GOBLET, DTObjects.EMPTY_NETHERITE_GOBLET, DTObjects.EMPTY_MITHRIL_GOBLET, DTObjects.EMPTY_SILVER_GOBLET, DTObjects.EMPTY_OCEANIC_GOLD_GOBLET);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> tintIndex == 1 ? BuiltinRegistries.BIOME.get(BiomeKeys.OCEAN).getWaterColor() : 0xFFFFFFFF , DTObjects.COPPER_GOBLET_OF_WATER, DTObjects.GOLDEN_GOBLET_OF_WATER, DTObjects.DEBRIS_GOBLET_OF_WATER, DTObjects.NETHERITE_GOBLET_OF_WATER, DTObjects.MITHRIL_GOBLET_OF_WATER, DTObjects.SILVER_GOBLET_OF_WATER, DTObjects.OCEANIC_GOLD_GOBLET_OF_WATER);
//        EntityModelLayerRegistry.registerModelLayer(MithrilArmorRenderer.MITHRIL_ARMOR_MODEL_LAYER, MithrilArmorModel::getModelData);
  //      ArmorRenderer.register(new MithrilArmorRenderer(new Identifier(DwarvenTreasures.MODID, "textures/entity/armor/mithril.png")), DTObjects.MITHRIL_HELMET, DTObjects.MITHRIL_CHESTPLATE, DTObjects.MITHRIL_LEGGINGS, DTObjects.MITHRIL_BOOTS);
        ClientPlayNetworking.registerGlobalReceiver(SpawnSnowParticlesPacket.ID, SpawnSnowParticlesPacket::handle);
        ClientPlayNetworking.registerGlobalReceiver(SpawnFlameParticlesPacket.ID, SpawnFlameParticlesPacket::handle);

    }
}
