package tv.mapper.embellishcraft.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
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
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;
import tv.mapper.mapperbase.block.CustomBlock;

public class LampBlock extends CustomBlock implements IWaterLoggable
{
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final VoxelShape BASE = Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 3.0D, 10.0D);
    private static final VoxelShape ROD = Block.makeCuboidShape(7.0D, 3.0D, 7.0D, 9.0D, 4.0D, 9.0D);
    private static final VoxelShape LAMP1 = Block.makeCuboidShape(4.0D, 4.0D, 4.0D, 12.0D, 7.0D, 12.0D);
    private static final VoxelShape LAMP2 = Block.makeCuboidShape(5.0D, 7.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private static final VoxelShape LAMP3 = Block.makeCuboidShape(6.0D, 10.0D, 6.0D, 10.0D, 13.0D, 10.0D);
    private static final VoxelShape LAMP = VoxelShapes.or(BASE, VoxelShapes.or(ROD, VoxelShapes.or(LAMP1, VoxelShapes.or(LAMP2, LAMP3))));

    private static final VoxelShape LAMP_COL = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 13.0D, 12.0D);

    public LampBlock(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(LIT, false).with(WATERLOGGED, Boolean.valueOf(false)));

    }

    public LampBlock(Properties properties, ToolType toolType)
    {
        super(properties);
        this.toolType = toolType;
        this.setDefaultState(this.stateContainer.getBaseState().with(LIT, false).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    // @Override
    // public boolean isSolid(BlockState state)
    // {
    // return false;
    // }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return LAMP;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return LAMP_COL;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
    {
        if(!worldIn.getBlockState(pos.down()).isSolid())
            return false;
        return true;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);

        return this.getDefaultState().with(LIT, Boolean.valueOf(context.getWorld().isBlockPowered(context.getPos()))).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
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

    @SuppressWarnings("deprecation")
    @Override
    public int getLightValue(BlockState state)
    {
        return state.get(LIT) ? super.getLightValue(state) : 0;
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving)
    {
        if(!worldIn.isRemote)
        {
            boolean flag = state.get(LIT);
            if(flag != worldIn.isBlockPowered(pos))
            {
                if(flag)
                {
                    worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
                }
                else
                {
                    worldIn.setBlockState(pos, state.cycle(LIT), 2);
                }
            }

        }
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random)
    {
        if(!worldIn.isRemote)
        {
            if(state.get(LIT) && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, state.cycle(LIT), 2);
            }

        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(LIT, WATERLOGGED);
    }

    @SuppressWarnings("deprecation")
    public IFluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }
}
