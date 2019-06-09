package tv.mapper.embellishcraft.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

public class BlockUpDown extends Block
{
    public static final BooleanProperty UPSIDE_DOWN = BooleanProperty.create("upside_down");

    public BlockUpDown(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(UPSIDE_DOWN, Boolean.valueOf(false)));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(UPSIDE_DOWN);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockState state = this.getDefaultState().with(UPSIDE_DOWN, false);
        Direction facing = context.getFace();
        return facing != Direction.DOWN && (facing == Direction.UP || !((double)context.func_221532_j().getY() > 0.5D)) ? state : state.with(UPSIDE_DOWN, Boolean.valueOf(true));
    }

}
