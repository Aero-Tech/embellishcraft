package tv.mapper.embellishcraft.furniture.world.level.block;

import java.util.stream.IntStream;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import tv.mapper.embellishcraft.furniture.world.entity.SitEntity;
import tv.mapper.mapperbase.world.level.block.CustomBlock;
import tv.mapper.mapperbase.world.level.block.ToolTiers;
import tv.mapper.mapperbase.world.level.block.ToolTypes;

public class CouchBlock extends CustomBlock implements SimpleWaterloggedBlock, SitBlock
{
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    public static final EnumProperty<StairsShape> SHAPE = BlockStateProperties.STAIRS_SHAPE;
    public static final BooleanProperty LEFT_END = BooleanProperty.create("left_end");
    public static final BooleanProperty RIGHT_END = BooleanProperty.create("right_end");

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape SLAB_BOTTOM = Block.box(0.0D, 3.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    protected static final VoxelShape NWU_CORNER = Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D);
    protected static final VoxelShape SWU_CORNER = Block.box(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D);
    protected static final VoxelShape NEU_CORNER = Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    protected static final VoxelShape SEU_CORNER = Block.box(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D);

    protected static final VoxelShape[] SLAB_BOTTOM_SHAPES = makeShapes(SLAB_BOTTOM, NWU_CORNER, NEU_CORNER, SWU_CORNER, SEU_CORNER);

    private static final int[] SHAPE_BY_STATE = new int[] {12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8};

    private static VoxelShape[] makeShapes(VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner)
    {
        return IntStream.range(0, 16).mapToObj((p_199780_5_) ->
        {
            return combineShapes(p_199780_5_, slabShape, nwCorner, neCorner, swCorner, seCorner);
        }).toArray((p_199778_0_) ->
        {
            return new VoxelShape[p_199778_0_];
        });
    }

    /**
     * combines the shapes according to the mode set in the bitfield
     */
    private static VoxelShape combineShapes(int bitfield, VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner)
    {
        VoxelShape voxelshape = slabShape;
        if((bitfield & 1) != 0)
        {
            voxelshape = Shapes.or(slabShape, nwCorner);
        }

        if((bitfield & 2) != 0)
        {
            voxelshape = Shapes.or(voxelshape, neCorner);
        }

        if((bitfield & 4) != 0)
        {
            voxelshape = Shapes.or(voxelshape, swCorner);
        }

        if((bitfield & 8) != 0)
        {
            voxelshape = Shapes.or(voxelshape, seCorner);
        }

        return voxelshape;
    }

    public CouchBlock(Properties properties, ToolTypes tool)
    {
        super(properties, tool);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SHAPE, StairsShape.STRAIGHT).setValue(LEFT_END, true).setValue(RIGHT_END, true).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public CouchBlock(Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(properties, tool, tier);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SHAPE, StairsShape.STRAIGHT).setValue(LEFT_END, true).setValue(RIGHT_END, true).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state)
    {
        return true;
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
    {
        return (SLAB_BOTTOM_SHAPES)[SHAPE_BY_STATE[this.getCouchShape(state)]];
    }

    private int getCouchShape(BlockState state)
    {
        return state.getValue(SHAPE).ordinal() * 4 + state.getValue(FACING).get2DDataValue();
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
    {
        return !level.isEmptyBlock(pos.below());
    }

    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockGetter iblockreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        FluidState ifluidstate = context.getLevel().getFluidState(blockpos);

        BlockState leftstate;
        BlockState rightstate;
        boolean leftend = true;
        boolean rightend = true;

        Direction facing = context.getHorizontalDirection();
        StairsShape shape = getShapeProperty(this.defaultBlockState().setValue(FACING, facing), context.getLevel(), blockpos);

        if(shape == StairsShape.STRAIGHT)
        {
            switch(facing)
            {
                case NORTH:
                    leftstate = iblockreader.getBlockState(blockpos.west());
                    rightstate = iblockreader.getBlockState(blockpos.east());
                    break;
                case SOUTH:
                    leftstate = iblockreader.getBlockState(blockpos.east());
                    rightstate = iblockreader.getBlockState(blockpos.west());
                    break;
                case EAST:
                    leftstate = iblockreader.getBlockState(blockpos.north());
                    rightstate = iblockreader.getBlockState(blockpos.south());
                    break;
                case WEST:
                    leftstate = iblockreader.getBlockState(blockpos.south());
                    rightstate = iblockreader.getBlockState(blockpos.north());
                    break;
                default:
                    leftstate = iblockreader.getBlockState(blockpos.west());
                    rightstate = iblockreader.getBlockState(blockpos.east());
            }

            if(leftstate.getBlock() instanceof CouchBlock)
                leftend = false;
            if(rightstate.getBlock() instanceof CouchBlock)
                rightend = false;
        }
        else
        {
            leftend = false;
            rightend = false;
        }

        return this.defaultBlockState().setValue(SHAPE, shape).setValue(FACING, facing).setValue(LEFT_END, leftend).setValue(RIGHT_END, rightend).setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER));
    }

    /**
     * Returns a stair shape property based on the surrounding stairs from the given blockstate and position
     */
    private static StairsShape getShapeProperty(BlockState state, BlockGetter worldIn, BlockPos pos)
    {
        Direction direction = state.getValue(FACING);
        BlockState blockstate = worldIn.getBlockState(pos.relative(direction));
        if(isCouchBlock(blockstate))
        {
            Direction direction1 = blockstate.getValue(FACING);
            if(direction1.getAxis() != state.getValue(FACING).getAxis() && isDifferentCouch(state, worldIn, pos, direction1.getOpposite()))
            {
                if(direction1 == direction.getCounterClockWise())
                {
                    return StairsShape.OUTER_LEFT;
                }

                return StairsShape.OUTER_RIGHT;
            }
        }

        BlockState blockstate1 = worldIn.getBlockState(pos.relative(direction.getOpposite()));
        if(isCouchBlock(blockstate1))
        {
            Direction direction2 = blockstate1.getValue(FACING);
            if(direction2.getAxis() != state.getValue(FACING).getAxis() && isDifferentCouch(state, worldIn, pos, direction2))
            {
                if(direction2 == direction.getCounterClockWise())
                {
                    return StairsShape.INNER_LEFT;
                }

                return StairsShape.INNER_RIGHT;
            }
        }
        return StairsShape.STRAIGHT;
    }

    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        BlockState leftstate;
        BlockState rightstate;
        boolean leftend;
        boolean rightend;

        StairsShape shape = stateIn.getValue(SHAPE);
        Direction direction = stateIn.getValue(FACING);

        if(facing.getAxis().isHorizontal())
            shape = getShapeProperty(stateIn, worldIn, currentPos);

        if(shape == StairsShape.STRAIGHT)
        {
            switch(direction)
            {
                case NORTH:
                    leftstate = worldIn.getBlockState(currentPos.west());
                    rightstate = worldIn.getBlockState(currentPos.east());
                    break;
                case SOUTH:
                    leftstate = worldIn.getBlockState(currentPos.east());
                    rightstate = worldIn.getBlockState(currentPos.west());
                    break;
                case EAST:
                    leftstate = worldIn.getBlockState(currentPos.north());
                    rightstate = worldIn.getBlockState(currentPos.south());
                    break;
                case WEST:
                    leftstate = worldIn.getBlockState(currentPos.south());
                    rightstate = worldIn.getBlockState(currentPos.north());
                    break;
                default:
                    leftstate = worldIn.getBlockState(currentPos.west());
                    rightstate = worldIn.getBlockState(currentPos.east());
            }

            if(leftstate.getBlock() instanceof CouchBlock)
                leftend = false;
            else
                leftend = true;

            if(rightstate.getBlock() instanceof CouchBlock)
                rightend = false;
            else
                rightend = true;
        }
        else
        {
            leftend = false;
            rightend = false;
        }

        if(stateIn.getValue(WATERLOGGED))
        {
            worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }

        if(facing == Direction.DOWN && !this.canSurvive(stateIn, worldIn, currentPos))
            return Blocks.AIR.defaultBlockState();

        return facing.getAxis().isHorizontal() ? stateIn.setValue(SHAPE, shape).setValue(LEFT_END, leftend).setValue(RIGHT_END, rightend) : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    private static boolean isDifferentCouch(BlockState state, BlockGetter worldIn, BlockPos pos, Direction face)
    {
        BlockState blockstate = worldIn.getBlockState(pos.relative(face));
        return !isCouchBlock(blockstate) || blockstate.getValue(FACING) != state.getValue(FACING);
    }

    public static boolean isCouchBlock(BlockState state)
    {
        return state.getBlock() instanceof CouchBlock;
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        Direction direction = state.getValue(FACING);
        StairsShape stairsshape = state.getValue(SHAPE);
        switch(mirrorIn)
        {
            case LEFT_RIGHT:
                if(direction.getAxis() == Direction.Axis.Z)
                {
                    switch(stairsshape)
                    {
                        case INNER_LEFT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT);
                        case INNER_RIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT);
                        case OUTER_LEFT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT);
                        case OUTER_RIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT);
                        default:
                            return state.rotate(Rotation.CLOCKWISE_180);
                    }
                }
                break;
            case FRONT_BACK:
                if(direction.getAxis() == Direction.Axis.X)
                {
                    switch(stairsshape)
                    {
                        case INNER_LEFT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT);
                        case INNER_RIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT);
                        case OUTER_LEFT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT);
                        case OUTER_RIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT);
                        case STRAIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180);
                    }
                }
            default:
                break;
        }

        return super.mirror(state, mirrorIn);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, SHAPE, LEFT_END, RIGHT_END, WATERLOGGED);
    }

    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result)
    {
        return SitEntity.create(level, pos, 0.55, 0.3, player, state.getValue(FACING), false);
    }
    
    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation)
    {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }
}
