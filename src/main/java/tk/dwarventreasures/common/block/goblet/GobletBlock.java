package tk.dwarventreasures.common.block.goblet;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class GobletBlock extends Block {

    private static final VoxelShape GOBLET_SHAPE = VoxelShapes.union(createCuboidShape(6.1, 3.1, 9.9,  9.9, 5.6, 10), createCuboidShape(9.9, 3.1, 6.1, 10, 5.6, 9.9), createCuboidShape(6.1, 3.1, 6, 9.9, 5.6, 6.1), createCuboidShape(6, 3.1, 6.1, 6.1, 5.6, 9.9), createCuboidShape(6.1, 3, 6.1, 9.9, 3.1, 9.9), createCuboidShape(7.75, 0.25, 7.75, 8.25, 2.8, 8.25), createCuboidShape(7,0,7,9,0.25, 9));

    public GobletBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return GOBLET_SHAPE;
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        return true;
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return canPlaceGoblet(world.getBlockState(pos)) && Blocks.TORCH.canPlaceAt(state, world, pos);
    }

    protected boolean canPlaceGoblet(BlockState state) {
        return (!state.getFluidState().isIn(FluidTags.WATER)) && (!state.getFluidState().isIn(FluidTags.LAVA));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !this.canPlaceAt(state, world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

}
