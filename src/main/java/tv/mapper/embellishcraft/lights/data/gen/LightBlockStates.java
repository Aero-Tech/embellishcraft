package tv.mapper.embellishcraft.lights.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.embellishcraft.core.data.gen.ECBlockStates;
import tv.mapper.embellishcraft.lights.world.level.block.InitLightBlocks;
import tv.mapper.embellishcraft.lights.world.level.block.LampBlock;

import java.util.Objects;

public class LightBlockStates extends ECBlockStates
{
    public LightBlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper)
    {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        for(int j = 0; j < DyeColor.values().length; j++)
        {
            tableLampBlock(InitLightBlocks.TABLE_LAMP_BLOCKS.get(DyeColor.byId(j)).get());
            tableLampBlock(InitLightBlocks.MANUAL_TABLE_LAMP_BLOCKS.get(DyeColor.byId(j)).get());
        }
    }

    private void tableLampBlock(LampBlock block)
    {
        String name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        getVariantBuilder(block).partialState().with(LampBlock.LIT, true).modelForState().modelFile(new UncheckedModelFile(mod_id + ":block/" + name + "_on")).addModel().partialState().with(LampBlock.LIT, false).modelForState().modelFile(new UncheckedModelFile(mod_id + ":block/" + name)).addModel();
    }
}