package tv.mapper.embellishcraft.lights.world.level.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import tv.mapper.mapperbase.world.level.block.CustomBlock;
import tv.mapper.mapperbase.world.level.block.ToolTiers;
import tv.mapper.mapperbase.world.level.block.ToolTypes;

public class LampBlock extends CustomBlock implements SimpleWaterloggedBlock
{
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public boolean isManual = false;

    private static final VoxelShape BASE = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 3.0D, 10.0D);
    private static final VoxelShape ROD = Block.box(7.0D, 3.0D, 7.0D, 9.0D, 4.0D, 9.0D);
    private static final VoxelShape LAMP1 = Block.box(4.0D, 4.0D, 4.0D, 12.0D, 7.0D, 12.0D);
    private static final VoxelShape LAMP2 = Block.box(5.0D, 7.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private static final VoxelShape LAMP3 = Block.box(6.0D, 10.0D, 6.0D, 10.0D, 13.0D, 10.0D);
    private static final VoxelShape LAMP = Shapes.or(BASE, Shapes.or(ROD, Shapes.or(LAMP1, Shapes.or(LAMP2, LAMP3))));

    private static final VoxelShape LAMP_COL = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 13.0D, 12.0D);

    public LampBlock(Properties properties, ToolTypes tool, boolean isManual)
    {
        super(properties, tool);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false).setValue(WATERLOGGED, Boolean.valueOf(false)));
        this.isManual = isManual;
    }

    public LampBlock(Properties properties, ToolTypes tool, ToolTiers tier, boolean isManual)
    {
        super(properties, tool, tier);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false).setValue(WATERLOGGED, Boolean.valueOf(false)));
        this.isManual = isManual;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
    {
        return LAMP;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
    {
        return LAMP_COL;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos)
    {
        return canSupportCenter(worldIn, pos.below(), Direction.UP);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result)
    {
        if(!world.isClientSide && this.isManual)
        {
            BlockState blockstate = this.setLit(state, world, pos);
            float f = blockstate.getValue(LIT) ? 1.5F : 0.7F;
            world.playSound((Player)null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 0.3F, f);
            return InteractionResult.CONSUME;
        }
        else
            return InteractionResult.SUCCESS;
    }

    public BlockState setLit(BlockState state, Level world, BlockPos pos)
    {
        state = state.cycle(LIT);
        world.setBlock(pos, state, 3);
        return state;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockPos blockpos = context.getClickedPos();
        FluidState FluidState = context.getLevel().getFluidState(blockpos);

        return this.defaultBlockState().setValue(LIT, Boolean.valueOf(context.getLevel().hasNeighborSignal(context.getClickedPos()))).setValue(WATERLOGGED, Boolean.valueOf(FluidState.getType() == Fluids.WATER));
    }

    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        if(stateIn.getValue(WATERLOGGED))
        {
            worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }

        if(facing == Direction.DOWN && !this.canSurvive(stateIn, worldIn, currentPos))
            return Blocks.AIR.defaultBlockState();

        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos)
    {
        return state.getValue(LIT) ? super.getLightEmission(state, world, pos) : 0;
    }

    @Override
    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving)
    {
        if(!worldIn.isClientSide && !isManual)
        {
            if(state.getValue(LIT) != worldIn.hasNeighborSignal(pos))
            {
                worldIn.setBlock(pos, state.cycle(LIT), 2);
            }
        }
    }

   /* @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random)
    {
        if(!worldIn.isClientSide)
        {
            if(state.getValue(LIT) && !worldIn.hasNeighborSignal(pos))
            {
                worldIn.setBlock(pos, state.cycle(LIT), 2);
            }
        }
    }*/

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(LIT, WATERLOGGED);
    }

    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
}