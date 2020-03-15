package tv.mapper.embellishcraft.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class ChairBlock extends Block implements IWaterLoggable
{
    // Need to figure a way to rotate VoxelShapes because this is just stupid
    private static final VoxelShape SOUTH_LEFT_FRONT_LEG = Block.makeCuboidShape(11.0D, 0.0D, 11.0D, 13.0D, 7.0D, 13.0D);
    private static final VoxelShape SOUTH_RIGHT_FRONT_LEG = Block.makeCuboidShape(3.0D, 0.0D, 11.0D, 5.0D, 7.0D, 13.0D);
    private static final VoxelShape SOUTH_LEFT_BACK_LEG = Block.makeCuboidShape(11.0D, 0.0D, 2.0D, 13.0D, 16.0D, 4.0D);
    private static final VoxelShape SOUTH_RIGHT_BACK_LEG = Block.makeCuboidShape(3.0D, 0.0D, 2.0D, 5.0D, 16.0D, 4.0D);
    private static final VoxelShape SOUTH_SIT = Block.makeCuboidShape(3.0D, 7.0D, 4.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape SOUTH_BACK = Block.makeCuboidShape(5.0D, 12.0D, 3.0D, 11.0D, 14.0D, 4.0D);
    private static final VoxelShape SOUTH_CHAIR_AABB = VoxelShapes.or(SOUTH_LEFT_FRONT_LEG,
        VoxelShapes.or(SOUTH_RIGHT_FRONT_LEG, VoxelShapes.or(SOUTH_LEFT_BACK_LEG, VoxelShapes.or(SOUTH_SIT, VoxelShapes.or(SOUTH_BACK, SOUTH_RIGHT_BACK_LEG)))));

    private static final VoxelShape SOUTH_COL_BACK = Block.makeCuboidShape(3.0D, 0.0D, 2.0D, 13.0D, 16.0D, 4.0D);
    private static final VoxelShape SOUTH_COL_SIT = Block.makeCuboidShape(3.0D, 0.0D, 4.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape SOUTH_COL = VoxelShapes.or(SOUTH_COL_BACK, SOUTH_COL_SIT);

    private static final VoxelShape WEST_LEFT_FRONT_LEG = Block.makeCuboidShape(3.0D, 0.0D, 11.0D, 5.0D, 7.0D, 13.0D);
    private static final VoxelShape WEST_RIGHT_FRONT_LEG = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 5.0D, 7.0D, 5.0D);
    private static final VoxelShape WEST_LEFT_BACK_LEG = Block.makeCuboidShape(12.0D, 0.0D, 11.0D, 14.0D, 16.0D, 13.0D);
    private static final VoxelShape WEST_RIGHT_BACK_LEG = Block.makeCuboidShape(12.0D, 0.0D, 3.0D, 14.0D, 16.0D, 5.0D);
    private static final VoxelShape WEST_SIT = Block.makeCuboidShape(3.0D, 7.0D, 3.0D, 12.0D, 8.0D, 13.0D);
    private static final VoxelShape WEST_BACK = Block.makeCuboidShape(12.0D, 12.0D, 5.0D, 13.0D, 14.0D, 11.0D);
    private static final VoxelShape WEST_CHAIR_AABB = VoxelShapes.or(WEST_LEFT_FRONT_LEG,
        VoxelShapes.or(WEST_RIGHT_FRONT_LEG, VoxelShapes.or(WEST_LEFT_BACK_LEG, VoxelShapes.or(WEST_SIT, VoxelShapes.or(WEST_BACK, WEST_RIGHT_BACK_LEG)))));

    private static final VoxelShape WEST_COL_BACK = Block.makeCuboidShape(12.0D, 0.0D, 3.0D, 14.0D, 16.0D, 13.0D);
    private static final VoxelShape WEST_COL_SIT = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 12.0D, 8.0D, 13.0D);
    private static final VoxelShape WEST_COL = VoxelShapes.or(WEST_COL_BACK, WEST_COL_SIT);

    private static final VoxelShape NORTH_LEFT_FRONT_LEG = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 5.0D, 7.0D, 5.0D);
    private static final VoxelShape NORTH_RIGHT_FRONT_LEG = Block.makeCuboidShape(11.0D, 0.0D, 3.0D, 13.0D, 7.0D, 5.0D);
    private static final VoxelShape NORTH_LEFT_BACK_LEG = Block.makeCuboidShape(3.0D, 0.0D, 12.0D, 5.0D, 16.0D, 14.0D);
    private static final VoxelShape NORTH_RIGHT_BACK_LEG = Block.makeCuboidShape(11.0D, 0.0D, 12.0D, 13.0D, 16.0D, 14.0D);
    private static final VoxelShape NORTH_SIT = Block.makeCuboidShape(3.0D, 7.0D, 3.0D, 13.0D, 8.0D, 12.0D);
    private static final VoxelShape NORTH_BACK = Block.makeCuboidShape(5.0D, 12.0D, 12.0D, 11.0D, 14.0D, 13.0D);
    private static final VoxelShape NORTH_CHAIR_AABB = VoxelShapes.or(NORTH_LEFT_FRONT_LEG,
        VoxelShapes.or(NORTH_RIGHT_FRONT_LEG, VoxelShapes.or(NORTH_LEFT_BACK_LEG, VoxelShapes.or(NORTH_SIT, VoxelShapes.or(NORTH_BACK, NORTH_RIGHT_BACK_LEG)))));

    private static final VoxelShape NORTH_COL_BACK = Block.makeCuboidShape(3.0D, 0.0D, 12.0D, 13.0D, 16.0D, 14.0D);
    private static final VoxelShape NORTH_COL_SIT = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 12.0D);
    private static final VoxelShape NORTH_COL = VoxelShapes.or(NORTH_COL_BACK, NORTH_COL_SIT);

    private static final VoxelShape EAST_LEFT_FRONT_LEG = Block.makeCuboidShape(11.0D, 0.0D, 3.0D, 13.0D, 7.0D, 5.0D);
    private static final VoxelShape EAST_RIGHT_FRONT_LEG = Block.makeCuboidShape(11.0D, 0.0D, 11.0D, 13.0D, 7.0D, 13.0D);
    private static final VoxelShape EAST_LEFT_BACK_LEG = Block.makeCuboidShape(2.0D, 0.0D, 3.0D, 4.0D, 16.0D, 5.0D);
    private static final VoxelShape EAST_RIGHT_BACK_LEG = Block.makeCuboidShape(2.0D, 0.0D, 11.0D, 4.0D, 16.0D, 13.0D);
    private static final VoxelShape EAST_SIT = Block.makeCuboidShape(4.0D, 7.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape EAST_BACK = Block.makeCuboidShape(3.0D, 12.0D, 5.0D, 4.0D, 14.0D, 11.0D);
    private static final VoxelShape EAST_CHAIR_AABB = VoxelShapes.or(EAST_LEFT_FRONT_LEG,
        VoxelShapes.or(EAST_RIGHT_FRONT_LEG, VoxelShapes.or(EAST_LEFT_BACK_LEG, VoxelShapes.or(EAST_SIT, VoxelShapes.or(EAST_BACK, EAST_RIGHT_BACK_LEG)))));

    private static final VoxelShape EAST_COL_BACK = Block.makeCuboidShape(2.0D, 0.0D, 3.0D, 4.0D, 16.0D, 13.0D);
    private static final VoxelShape EAST_COL_SIT = Block.makeCuboidShape(4.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape EAST_COL = VoxelShapes.or(EAST_COL_BACK, EAST_COL_SIT);

    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected ToolType toolType = null;

    public ChairBlock(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    public ChairBlock(Properties properties, ToolType toolType)
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
        this.toolType = toolType;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        switch((Direction)state.get(FACING))
        {
            case NORTH:
                return NORTH_CHAIR_AABB;
            case SOUTH:
                return SOUTH_CHAIR_AABB;
            case WEST:
                return WEST_CHAIR_AABB;
            case EAST:
                return EAST_CHAIR_AABB;
            default:
                return SOUTH_CHAIR_AABB;
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        switch((Direction)state.get(FACING))
        {
            case NORTH:
                return NORTH_COL;
            case SOUTH:
                return SOUTH_COL;
            case WEST:
                return WEST_COL;
            case EAST:
                return EAST_COL;
            default:
                return SOUTH_COL;
        }
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
    {
        return hasEnoughSolidSide(worldIn, pos.down(), Direction.UP);
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state)
    {
        if(toolType != null)
            return this.toolType;
        else
            return super.getHarvestTool(state);
    }

    @SuppressWarnings("deprecation")
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        if(stateIn.get(WATERLOGGED))
        {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        if(facing == Direction.DOWN && !this.isValidPosition(stateIn, worldIn, currentPos))
            return Blocks.AIR.getDefaultState();

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);

        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER)));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, WATERLOGGED);
    }

    @SuppressWarnings("deprecation")
    public IFluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }
}