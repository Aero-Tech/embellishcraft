package tv.mapper.embellishcraft.core.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tv.mapper.embellishcraft.industrial.world.level.block.InitIndustrialBlocks;
import tv.mapper.mapperbase.world.item.BaseItems;

@Mod.EventBusSubscriber
public class BoltEvent
{
    @SubscribeEvent
    public static void onRightClickBlock(RightClickBlock event)
    {
        Player player = event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        Block block = world.getBlockState(pos).getBlock();
        Block newBlock = Blocks.AIR;

        if(player.getMainHandItem().getItem() == BaseItems.BOLT.get())
        {
            if(block == InitIndustrialBlocks.IRON_BEAM.get())
            {
                newBlock = InitIndustrialBlocks.BOLTED_IRON_BEAM.get();
            }
            else if(block == InitIndustrialBlocks.STEEL_BEAM.get())
            {
                newBlock = InitIndustrialBlocks.BOLTED_STEEL_BEAM.get();
            }

            if(newBlock != Blocks.AIR)
            {
                BlockState state = world.getBlockState(pos);
                Axis AXIS = state.getValue(BlockStateProperties.AXIS);

                ItemStack stack = ItemStack.EMPTY;
                if(player.getMainHandItem().getItem() == BaseItems.BOLT.get())
                    stack = player.getMainHandItem();

                world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(BlockStateProperties.AXIS, AXIS));

                if(!world.isClientSide)
                    world.playSound(null, pos, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, SoundSource.BLOCKS, 0.25F, 2.0F);

                if(!player.isCreative())
                    stack.setCount(stack.getCount() - 1);
            }
        }
        else if(player.getMainHandItem().getItem() == BaseItems.FLATTER_HAMMER.get())
        {
            if(block == InitIndustrialBlocks.BOLTED_IRON_BEAM.get())
            {
                newBlock = InitIndustrialBlocks.IRON_BEAM.get();
            }
            else if(block == InitIndustrialBlocks.BOLTED_STEEL_BEAM.get())
            {
                newBlock = InitIndustrialBlocks.STEEL_BEAM.get();
            }

            if(newBlock != Blocks.AIR)
            {
                BlockState state = world.getBlockState(pos);
                Axis AXIS = state.getValue(BlockStateProperties.AXIS);

                ItemStack stack = ItemStack.EMPTY;
                if(player.getMainHandItem().getItem() == BaseItems.FLATTER_HAMMER.get())
                    stack = player.getMainHandItem();

                world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(BlockStateProperties.AXIS, AXIS));

                if(!world.isClientSide)
                    world.playSound(null, pos, SoundEvents.LANTERN_HIT, SoundSource.BLOCKS, 1.0F, 0.25F);

                if(!player.isCreative())
                {
                    ItemStack drop = new ItemStack(BaseItems.BOLT.get());
                    Containers.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), drop);
                    stack.hurtAndBreak(1, player, (p_220039_0_) ->
                    {
                        p_220039_0_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                    });
                }
            }
        }
    }
}