package tv.mapper.embellishcraft.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import tv.mapper.mapperbase.data.gen.BaseItemModels;

public class ECItemModels extends BaseItemModels
{

    public ECItemModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper)
    {
        super(generator, modid, existingFileHelper);
    }

    @Override
    public String getName()
    {
        return "EmbellishCraft Item Models";
    }

    @Override
    protected void registerModels()
    {
        registerStone("basalt");
        registerStone("slate");
        registerStone("marble");
        registerStone("gneiss");
        registerStone("jade");
        registerStone("larvikite");

        registerMcStone("andesite");
        registerMcStone("diorite");
        registerMcStone("granite");

        registerSandstone("sandstone");
        registerSandstone("red_sandstone");
    }

    private void registerStone(String name)
    {
        registerBlockBasics(name, true, true, true, true, true, false);
        getBuilder(name + "_button").parent(new UncheckedModelFile(modid + ":block/" + name + "_button_inventory"));
        registerBlockBasics(name + "_cobblestone", true, true, true, true, true, false);
        registerBlockBasics("smooth_" + name, true, true, true, true, true, false);
        registerBlockBasics("polished_" + name, true, true, true, true, true, false);
        registerBlockBasics(name + "_paving", true, true, true, true, true, false);
        registerBlockBasics(name + "_tiles", true, true, true, true, true, false);
        registerBlockBasics(name + "_bricks", true, true, true, true, true, false);
        registerBlockBasics(name + "_large_bricks", true, true, true, true, true, false);
        registerBlockBasics(name + "_ornament", true, false, false, false, true, false);
    }

    private void registerMcStone(String name)
    {
        registerBlockBasics("smooth_" + name, true, true, true, true, true, false);
        getBuilder(name + "_button").parent(new UncheckedModelFile(modid + ":block/" + name + "_button_inventory"));
        registerBlockBasics(name + "_paving", true, true, true, true, true, false);
        registerBlockBasics(name + "_tiles", true, true, true, true, true, false);
        registerBlockBasics(name + "_bricks", true, true, true, true, true, false);
        registerBlockBasics(name + "_large_bricks", true, true, true, true, true, false);
        registerBlockBasics(name + "_ornament", true, false, false, false, true, false);
    }

    private void registerSandstone(String name)
    {
        getBuilder(name + "_button").parent(new UncheckedModelFile(modid + ":block/" + name + "_button_inventory"));
        registerBlockBasics("smooth_" + name, false, false, false, true, true, false);
        registerBlockBasics("polished_" + name, true, true, true, true, true, false);
        registerBlockBasics(name + "_paving", true, true, true, true, true, false);
        registerBlockBasics(name + "_tiles", true, true, true, true, true, false);
        registerBlockBasics(name + "_bricks", true, true, true, true, true, false);
        registerBlockBasics(name + "_large_bricks", true, true, true, true, true, false);
    }
}
