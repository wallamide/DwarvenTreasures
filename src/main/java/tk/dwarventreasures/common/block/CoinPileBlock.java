package tk.dwarventreasures.common.block;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class CoinPileBlock extends FallingBlock {

    public static final int MAX_LAYERS = 8;
    public static final IntProperty COIN_PILE_LAYERS = Properties.LAYERS;
    private static final VoxelShape[] COIN_PILE_SHAPE = new VoxelShape[]{VoxelShapes.empty(), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public CoinPileBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(COIN_PILE_LAYERS, 1));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState bottom = world.getBlockState(pos.down());
        if (!bottom.isOf(Blocks.BARRIER) && !bottom.isOf(Blocks.HONEY_BLOCK)) {
            return Block.isFaceFullSquare(bottom.getCollisionShape(world, pos.down()), Direction.UP) || bottom.isOf(this) && bottom.get(COIN_PILE_LAYERS) == MAX_LAYERS;
        } else {
            return false;
        }
    }


    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        int layer = state.get(COIN_PILE_LAYERS);
        if (context.getStack().isOf(this.asItem()) && layer < 8) {
            if (context.canReplaceExisting()) {
                return context.getSide() == Direction.UP;
            } else {
                return true;
            }
        } else {
            return layer == 1;
        }
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
       final BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (blockState.isOf(this)) {
            int layer = blockState.get(COIN_PILE_LAYERS);
            return blockState.with(COIN_PILE_LAYERS, Math.min(8, layer + 1));
        } else {
            return super.getPlacementState(ctx);
        }
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return type == NavigationType.LAND && state.get(COIN_PILE_LAYERS) < 5;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COIN_PILE_SHAPE[state.get(COIN_PILE_LAYERS)];
    }
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COIN_PILE_SHAPE[state.get(COIN_PILE_LAYERS) - 1];
    }
    @Override
    public VoxelShape getSidesShape(BlockState state, BlockView world, BlockPos pos) {
        return COIN_PILE_SHAPE[state.get(COIN_PILE_LAYERS)];
    }
    @Override
    public VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COIN_PILE_SHAPE[state.get(COIN_PILE_LAYERS)];
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(COIN_PILE_LAYERS);
    }
}
