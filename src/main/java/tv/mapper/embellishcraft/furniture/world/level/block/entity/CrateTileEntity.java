package tv.mapper.embellishcraft.furniture.world.level.block.entity;

import java.util.stream.IntStream;

import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;
import tv.mapper.embellishcraft.core.world.block.entity.ModTileEntityTypes;
import tv.mapper.embellishcraft.furniture.world.inventory.CrateContainer;
import tv.mapper.embellishcraft.furniture.world.level.block.CrateBlock;

public class CrateTileEntity extends RandomizableContainerBlockEntity implements WorldlyContainer
{
    private static final int[] SLOTS = IntStream.range(0, 4 * 4).toArray();
    private NonNullList<ItemStack> crateContents = NonNullList.withSize(4 * 4, ItemStack.EMPTY);
    private LazyOptional<IItemHandlerModifiable> crateHandler = LazyOptional.of(this::createHandler);;

    public CrateTileEntity(BlockEntityType<?> typeIn, BlockPos p_155630_, BlockState p_155631_)
    {
        super(typeIn, p_155630_, p_155631_);
    }

    public CrateTileEntity(BlockPos p_155630_, BlockState p_155631_)
    {
        this(ModTileEntityTypes.CRATE, p_155630_, p_155631_);
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getContainerSize()
    {
        return 4 * 4;
    }

    public boolean isEmpty()
    {
        for(ItemStack itemstack : this.crateContents)
        {
            if(!itemstack.isEmpty())
            {
                return false;
            }
        }
        return true;
    }

    protected Component getDefaultName()
    {
        return Component.translatable("embellishcraft.container.wooden_crate");
    }

    // @Override
    // public void load(CompoundTag compound)
    // {
    // super.load(compound);
    // this.loadFromNbt(compound);
    // }

    // @Override
    // public CompoundTag save(CompoundTag compound)
    // {
    // super.save(compound);
    // return this.saveToNbt(compound);
    // }

    public void load(CompoundTag pTag)
    {
        super.load(pTag);
        this.loadFromTag(pTag);
    }

    protected void saveAdditional(CompoundTag pTag)
    {
        super.saveAdditional(pTag);
        if(!this.trySaveLootTable(pTag))
        {
            ContainerHelper.saveAllItems(pTag, this.crateContents, false);
        }

    }

    public void loadFromTag(CompoundTag pTag)
    {
        this.crateContents = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if(!this.tryLoadLootTable(pTag) && pTag.contains("Items", 9))
        {
            ContainerHelper.loadAllItems(pTag, this.crateContents);
        }

    }

    // public void loadFromNbt(CompoundTag compound)
    // {
    // this.crateContents = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
    // if(!this.tryLoadLootTable(compound) && compound.contains("Items", 9))
    // {
    // ContainerHelper.loadAllItems(compound, this.crateContents);
    // }
    // }
    //
    // public CompoundTag saveToNbt(CompoundTag compound)
    // {
    // if(!this.trySaveLootTable(compound))
    // {
    // ContainerHelper.saveAllItems(compound, this.crateContents, false);
    // }
    //
    // return compound;
    // }

    protected NonNullList<ItemStack> getItems()
    {
        return this.crateContents;
    }

    protected void setItems(NonNullList<ItemStack> itemsIn)
    {
        this.crateContents = itemsIn;
    }

    protected AbstractContainerMenu createMenu(int id, Inventory player)
    {
        return CrateContainer.createCrate4X4(id, player, this);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side)
    {
        if(!this.remove && cap == ForgeCapabilities.ITEM_HANDLER)
            return this.crateHandler.cast();

        return super.getCapability(cap, side);
    }

    private IItemHandlerModifiable createHandler()
    {
        return new InvWrapper(this)
        {
            @Override
            @Nonnull
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
            {
                if(Block.byItem(stack.getItem()) instanceof CrateBlock || Block.byItem(stack.getItem()) instanceof ShulkerBoxBlock)
                    return stack;

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    /**
     * invalidates a tile entity
     */
    @Override
    public void setRemoved()
    {
        super.setRemoved();
        if(crateHandler != null)
            crateHandler.invalidate();
    }

    @Override
    public int[] getSlotsForFace(Direction side)
    {
        return SLOTS;
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack itemStackIn, Direction direction)
    {
        if(Block.byItem(itemStackIn.getItem()) instanceof CrateBlock || Block.byItem(itemStackIn.getItem()) instanceof ShulkerBoxBlock)
            return false;
        else
            return true;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction)
    {
        return true;
    }
}