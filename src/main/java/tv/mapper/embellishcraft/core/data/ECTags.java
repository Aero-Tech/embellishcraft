package tv.mapper.embellishcraft.core.data;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import tv.mapper.embellishcraft.core.ECConstants;

public class ECTags
{
    public static class Blocks
    {
        public static final TagKey<Block> DOORS = tag("doors");
        public static final TagKey<Block> WOODEN_DOORS = tag("wooden_doors");
        public static final TagKey<Block> WOODEN_CRATES = tag("wooden_crates");
        public static final TagKey<Block> BEAMS = tag("beams");
        public static final TagKey<Block> DUCTS = tag("ducts");
        public static final TagKey<Block> STEEL_DOORS = tag("steel_doors");
        public static final TagKey<Block> FANCY_BEDS = tag("fancy_beds");
        public static final TagKey<Block> SUSPENDED_STAIRS = tag("suspended_stairs");
        public static final TagKey<Block> COUCHES = tag("couches");

        private static TagKey<Block> tag(String name)
        {
            return BlockTags.create(new ResourceLocation(ECConstants.MODID, name));
        }
    }

    public static class Items
    {
        public static final TagKey<Item> DOORS = tag("doors");
        public static final TagKey<Item> WOODEN_DOORS = tag("wooden_doors");
        public static final TagKey<Item> WOODEN_CRATES = tag("wooden_crates");
        public static final TagKey<Item> BEAMS = tag("beams");
        public static final TagKey<Item> DUCTS = tag("ducts");
        public static final TagKey<Item> STEEL_DOORS = tag("steel_doors");
        public static final TagKey<Item> FANCY_BEDS = tag("fancy_beds");
        public static final TagKey<Item> SUSPENDED_STAIRS = tag("suspended_stairs");
        public static final TagKey<Item> COUCHES = tag("couches");

        private static TagKey<Item> tag(String name)
        {
            return ItemTags.create(new ResourceLocation(ECConstants.MODID, name));
        }
    }

    public static class ForgeBlocks
    {
        public static final TagKey<Block> CHAIRS = tag("chairs");
        public static final TagKey<Block> TABLES = tag("tables");
        public static final TagKey<Block> CRATES = tag("crates");

        private static TagKey<Block> tag(String name)
        {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class ForgeItems
    {
        public static final TagKey<Item> CHAIRS = tag("chairs");
        public static final TagKey<Item> TABLES = tag("tables");
        public static final TagKey<Item> CRATES = tag("crates");

        private static TagKey<Item> tag(String name)
        {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}