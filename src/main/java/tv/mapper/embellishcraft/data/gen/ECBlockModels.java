package tv.mapper.embellishcraft.data.gen;

import java.util.Arrays;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.data.ExistingFileHelper;
import tv.mapper.embellishcraft.ECConstants;
import tv.mapper.mapperbase.data.gen.BaseBlockModels;

public class ECBlockModels extends BaseBlockModels
{
    public ECBlockModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper)
    {
        super(generator, modid, existingFileHelper);
    }

    @Override
    public String getName()
    {
        return "EmbellishCraft Block Models";
    }

    @Override
    protected void registerModels()
    {
        for(int j = 0; j < Arrays.stream(DyeColor.values()).count(); j++)
        {
            buildTableLamp(DyeColor.byId(j).getSerializedName());
        }
    }

    protected void buildTableLamp(String color)
    {
        getBuilder(color + "_table_lamp").parent(getExistingFile(modLoc("block/table_lamp"))).texture("texture", new ResourceLocation(ECConstants.MODID, "block/" + color + "_table_lamp")).texture("particle", new ResourceLocation(ECConstants.MODID, "block/" + color + "_table_lamp"));
        getBuilder(color + "_table_lamp_on").parent(getExistingFile(modLoc("block/table_lamp"))).texture("texture", new ResourceLocation(ECConstants.MODID, "block/" + color + "_table_lamp_on")).texture("particle", new ResourceLocation(ECConstants.MODID, "block/" + color + "_table_lamp_on"));
        getBuilder(color + "_manual_table_lamp").parent(getExistingFile(modLoc("block/table_lamp"))).texture("texture", new ResourceLocation(ECConstants.MODID, "block/" + color + "_table_lamp")).texture("particle", new ResourceLocation(ECConstants.MODID, "block/" + color + "_table_lamp"));
        getBuilder(color + "_manual_table_lamp_on").parent(getExistingFile(modLoc("block/table_lamp"))).texture("texture", new ResourceLocation(ECConstants.MODID, "block/" + color + "_table_lamp_on")).texture("particle", new ResourceLocation(ECConstants.MODID, "block/" + color + "_table_lamp_on"));
    }
}