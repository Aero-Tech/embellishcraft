package tv.mapper.embellishcraft.core.world.block.entity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.embellishcraft.EmbellishCraft;
import tv.mapper.embellishcraft.core.ECConstants;
import tv.mapper.embellishcraft.furniture.world.level.block.CrateBlock;
import tv.mapper.embellishcraft.furniture.world.level.block.CustomBedBlock;
import tv.mapper.embellishcraft.furniture.world.level.block.InitFurnitureBlocks;
import tv.mapper.embellishcraft.furniture.world.level.block.entity.CrateTileEntity;
import tv.mapper.embellishcraft.furniture.world.level.block.entity.CustomBedTileEntity;
import tv.mapper.embellishcraft.furniture.world.level.block.entity.CustomChestTileEntity;

@EventBusSubscriber(bus = Bus.MOD)
public class ModTileEntityTypes
{
    @ObjectHolder(registryName = "block_entity_type", value = "custom_chest")
    public static final BlockEntityType<CustomChestTileEntity> CUSTOM_CHEST = null;
    // @ObjectHolder(registryName = "block_entity_type", value = "vertical_chest")
    // public static final BlockEntityType<VerticalChestTileEntity> VERTICAL_CHEST = null;
    @ObjectHolder(registryName = "block_entity_type", value = "custom_bed")
    public static final BlockEntityType<CustomBedTileEntity> CUSTOM_BED = null;
    @ObjectHolder(registryName = "block_entity_type", value = "crate")
    public static final BlockEntityType<CrateTileEntity> CRATE = null;

    @SubscribeEvent
    public static void registerTileEntities(RegisterEvent event)
    {
        EmbellishCraft.LOGGER.info("1.3- EmbellishCraft: TE registering.");

        // List<Block> CHESTS = new ArrayList<>();
        List<Block> BEDS = new ArrayList<>();
        List<Block> CRATES = new ArrayList<>();

        // for(RegistryObject<CustomChestBlock> object : InitFurnitureBlocks.FANCY_CHESTS)
        // {
        // CHESTS.add(object.get());
        // }

        EmbellishCraft.LOGGER.info("EmbellishCraft: if this line crashes please report to https://github.com/MapperTV/embellishcraft/issues/19");
        for(RegistryObject<CustomBedBlock> object : InitFurnitureBlocks.FANCY_BEDS)
        {
            BEDS.add(object.get());
        }
        for(RegistryObject<CrateBlock> object : InitFurnitureBlocks.CRATES)
        {
            CRATES.add(object.get());
        }

        // event.getRegistry().register(BlockEntityType.Builder.of(CustomChestTileEntity::new, CHESTS.toArray(new
        // Block[InitFurnitureBlocks.FANCY_CHESTS.size()])).build(null).setRegistryName("custom_chest"));
        // event.getRegistry().register(BlockEntityType.Builder.of(VerticalChestTileEntity::new, InitFurnitureBlocks.LOCKER.get()).build(null).setRegistryName("vertical_chest"));
        event.register(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES,
                helper -> {
                    helper.register("custom_bed", BlockEntityType.Builder.of(CustomBedTileEntity::new, BEDS.toArray(new CustomBedBlock[InitFurnitureBlocks.FANCY_BEDS.size()])).build(null));
                    helper.register("crate", BlockEntityType.Builder.of(CustomBedTileEntity::new,CRATES.toArray(new Block[InitFurnitureBlocks.CRATES.size()])).build(null));
                });
    }
}