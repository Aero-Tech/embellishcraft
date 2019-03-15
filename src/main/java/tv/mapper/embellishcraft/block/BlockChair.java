package tv.mapper.embellishcraft.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import tv.mapper.embellishcraft.entity.EntityChair;

public class BlockChair extends Block
{
    protected static final VoxelShape CHAIR_AABB = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 18.0D, 14.0D);
    public static final DirectionProperty FACING = DirectionProperty.create("facing", EnumFacing.Plane.HORIZONTAL);

    public BlockChair(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.NORTH));
    }

    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return CHAIR_AABB;
    }

    public VoxelShape getCollisionShape(IBlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return CHAIR_AABB;
    }

    public boolean isSolid(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        List<EntityChair> chairs = world.getEntitiesWithinAABB(EntityChair.class, new AxisAlignedBB(pos, pos.add(1, 1, 1)));
        if(chairs.isEmpty())
        {
            EntityChair chair = new EntityChair(world, pos);
            world.spawnEntity(chair);
            player.startRiding(chair);
        }
        return true;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public IBlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().with(FACING, EnumFacing.byHorizontalIndex(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.get(FACING)).getHorizontalIndex();
    }

    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder)
    {
        builder.add(FACING);
    }
}
