package tv.mapper.embellishcraft.core.data.gen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.functions.SetContainerContents;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.embellishcraft.core.ECConstants;
import tv.mapper.embellishcraft.core.world.block.entity.ModTileEntityTypes;
import tv.mapper.embellishcraft.furniture.world.level.block.CrateBlock;
import tv.mapper.embellishcraft.furniture.world.level.block.CustomBedBlock;
import tv.mapper.embellishcraft.furniture.world.level.block.PlateBlock;
import tv.mapper.mapperbase.data.gen.BaseLootTableProvider;

import java.util.Objects;

public class ECLootTables extends BaseLootTableProvider
{
    public ECLootTables(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    public void addStandardTable(Block block)
    {
        if(block instanceof SlabBlock)
            lootTables.put(block, createSlabTable(ECConstants.MODID, block));
        else if(block instanceof CustomBedBlock)
            lootTables.put(block, createBedTable(ECConstants.MODID, block));
        else if(block instanceof DoorBlock)
            lootTables.put(block, createDoorTable(ECConstants.MODID, block));
        else if(block instanceof CrateBlock)
            lootTables.put(block, createCrateTable(ECConstants.MODID, block));
        else if(block instanceof ChestBlock)
            lootTables.put(block, createChestTable(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).toString(), block));
        else if(block instanceof PlateBlock)
            lootTables.put(block, createPlateTable(ECConstants.MODID, block));
        else
            lootTables.put(block, createStandardTable(ECConstants.MODID, block));
    }

    protected LootTable.Builder createPlateTable(String modid, Block block)
    {
        String name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        LootPool.Builder builder = LootPool.lootPool().name(name).setRolls(ConstantValue.exactly(1)).add(withExplosionDecay(block, LootItem.lootTableItem(block).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PlateBlock.PLATES, 2)))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PlateBlock.PLATES, 3)))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PlateBlock.PLATES, 4)))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(5)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PlateBlock.PLATES, 5)))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PlateBlock.PLATES, 6)))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(7)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PlateBlock.PLATES, 7)))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(8)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PlateBlock.PLATES, 8))))));
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createCrateTable(String modid, Block block)
    {
        String name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        LootPool.Builder builder = LootPool.lootPool().name(name).setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(block).apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY)).apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY).copy("Lock", "BlockEntityTag.Lock").copy("LootTable", "BlockEntityTag.LootTable").copy("LootTableSeed", "BlockEntityTag.LootTableSeed")).apply(SetContainerContents.setContents(ModTileEntityTypes.CRATE).withEntry(DynamicLoot.dynamicEntry(CrateBlock.CONTENTS))));
        return LootTable.lootTable().withPool(builder);
    }

    @Override
    protected void addTables()
    {}
}