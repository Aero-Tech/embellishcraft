package tv.mapper.embellishcraft.furniture.world.level.block;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tv.mapper.embellishcraft.furniture.world.level.block.entity.CrateTileEntity;
import tv.mapper.mapperbase.world.level.block.ToolManager;
import tv.mapper.mapperbase.world.level.block.ToolTiers;
import tv.mapper.mapperbase.world.level.block.ToolTypes;

public class CrateBlock extends BaseEntityBlock implements ToolManager
{
    protected ToolTiers tier;
    protected ToolTypes tool;
    public static final ResourceLocation CONTENTS = new ResourceLocation("contents");

    public CrateBlock(Properties properties, ToolTypes tool)
    {
        super(properties);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
    }

    public CrateBlock(Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(properties);
        this.tool = tool;
        this.tier = tier;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result)
    {
        if(!world.isClientSide)
        {
            BlockEntity tileEntity = world.getBlockEntity(pos);
            if(tileEntity instanceof CrateTileEntity)
            {
                MenuProvider inamedcontainerprovider = this.getMenuProvider(state, world, pos);

                if(inamedcontainerprovider != null)
                {
                    player.openMenu(inamedcontainerprovider);
                    world.playSound(null, pos, SoundEvents.WOODEN_DOOR_OPEN, SoundSource.BLOCKS, 1.0F, (float)(0.75f + Math.random() * (1.25f - 0.75f)));
                }
            }
            else
            {
                throw new IllegalStateException("Attempted to open a crate while it was not one!");
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.SUCCESS;
    }

    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer)
    {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);

        if(blockEntity instanceof CrateTileEntity)
        {
            CrateTileEntity crateBlockEntity = (CrateTileEntity)blockEntity;
            if(!pLevel.isClientSide && pPlayer.isCreative() && !crateBlockEntity.isEmpty())
            {
                ItemStack itemstack = new ItemStack(this.asBlock());
                blockEntity.saveToItem(itemstack);
                if(crateBlockEntity.hasCustomName())
                {
                    itemstack.setHoverName(crateBlockEntity.getCustomName());
                }

                ItemEntity itementity = new ItemEntity(pLevel, (double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D, itemstack);
                itementity.setDefaultPickUpDelay();
                pLevel.addFreshEntity(itementity);
            }
            else
            {
                crateBlockEntity.unpackLootTable(pPlayer);
            }
        }

        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        CompoundTag compoundnbt = stack.getTagElement("BlockEntityTag");
        if(compoundnbt != null)
        {
            if(compoundnbt.contains("LootTable", 8))
            {
                tooltip.add(Component.literal("???????"));
            }

            if(compoundnbt.contains("Items", 9))
            {
                NonNullList<ItemStack> nonnulllist = NonNullList.withSize(27, ItemStack.EMPTY);
                ContainerHelper.loadAllItems(compoundnbt, nonnulllist);
                int i = 0;
                int j = 0;

                for(ItemStack itemstack : nonnulllist)
                {
                    if(!itemstack.isEmpty())
                    {
                        ++j;
                        if(i <= 4)
                        {
                            ++i;
                            MutableComponent itextcomponent = itemstack.getHoverName().copy();
                            itextcomponent.append(" x").append(String.valueOf(itemstack.getCount()));
                            tooltip.add(itextcomponent);
                        }
                    }
                }

                if(j - i > 0)
                {
                    tooltip.add((Component.translatable("container.shulkerBox.more", j - i)).withStyle(ChatFormatting.ITALIC));
                }
            }
        }

    }

    @SuppressWarnings("deprecation")
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder)
    {
        BlockEntity tileentity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if(tileentity instanceof CrateTileEntity)
        {
            CrateTileEntity crate = (CrateTileEntity)tileentity;
            builder = builder.withDynamicDrop(CONTENTS, (p_220168_1_, p_220168_2_) ->
            {
                for(int i = 0; i < crate.getContainerSize(); ++i)
                {
                    p_220168_2_.accept(crate.getItem(i));
                }

            });
        }

        return super.getDrops(state, builder);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if(state.getBlock() != newState.getBlock())
        {
            BlockEntity tileentity = worldIn.getBlockEntity(pos);
            if(tileentity instanceof CrateTileEntity)
            {
                worldIn.updateNeighbourForOutputSignal(pos, state.getBlock());
            }

            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_)
    {
        return new CrateTileEntity(p_153215_, p_153216_);
    }

    @Override
    public ToolTiers getTier()
    {
        return this.tier;
    }

    @Override
    public ToolTypes getTool()
    {
        return this.tool;
    }
}