package tk.dwarventreasures.client.network.packet;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import tk.dwarventreasures.common.DwarvenTreasures;

public class SpawnSnowParticlesPacket {

    public static final Identifier ID = new Identifier(DwarvenTreasures.MODID, "spawn_snow_particles");

    public static void send(PlayerEntity player, Entity entity) {
        final PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(entity.getId());
        ServerPlayNetworking.send((ServerPlayerEntity) player, ID, buf);
    }

    public static void handle(MinecraftClient client, ClientPlayNetworkHandler network, PacketByteBuf buf, PacketSender sender) {
        final int id = buf.readInt();
        client.execute(() -> {
            final ClientWorld world = client.world;
            if (world != null) {
                final Entity entity = world.getEntityById(id);
                if (entity != null) {
                    for (int i = 0; i < 16; i++) {
                        world.addParticle(ParticleTypes.SNOWFLAKE, entity.getParticleX(1), entity.getRandomBodyY(), entity.getParticleZ(1), 0.02, 0.02, 0.02);
                    }
                }
            }
        });
    }
}
