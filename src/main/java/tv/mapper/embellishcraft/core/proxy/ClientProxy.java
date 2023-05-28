package tv.mapper.embellishcraft.core.proxy;

import java.util.function.Predicate;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.embellishcraft.furniture.client.gui.screens.inventory.CrateScreen;
import tv.mapper.embellishcraft.furniture.client.renderer.SitRenderer;
import tv.mapper.embellishcraft.furniture.world.entity.InitFurnitureEntities;
import tv.mapper.embellishcraft.furniture.world.inventory.ModContainers;
import tv.mapper.embellishcraft.furniture.world.level.block.InitFurnitureBlocks;

public class ClientProxy implements IProxy
{
    @Override
    public void setup(FMLCommonSetupEvent event)
    {
        // ClientRegistry.bindTileEntitySpecialRenderer(CustomChestTileEntity.class, new CustomChestTileEntityRenderer<>());
        // ClientRegistry.bindTileEntitySpecialRenderer(VerticalChestTileEntity.class, new VerticalChestTileEntityRenderer<>());
        // ClientRegistry.bindTileEntitySpecialRenderer(CustomBedTileEntity.class, new CustomBedTileEntityRenderer<>());

        // MenuScreens.register(ModContainers.VERTICAL_9X1.get(), VerticalChestScreen::new);
        // MenuScreens.register(ModContainers.VERTICAL_9X2.get(), VerticalChestScreen::new);
        // MenuScreens.register(ModContainers.VERTICAL_9X3.get(), VerticalChestScreen::new);
        // MenuScreens.register(ModContainers.VERTICAL_9X4.get(), VerticalChestScreen::new);
        // MenuScreens.register(ModContainers.VERTICAL_9X5.get(), VerticalChestScreen::new);
        // MenuScreens.register(ModContainers.VERTICAL_9X6.get(), VerticalChestScreen::new);
        MenuScreens.register(ModContainers.CRATE_4X4.get(), CrateScreen::new);
        MenuScreens.register(ModContainers.CRATE_4X8.get(), CrateScreen::new);

        EntityRenderers.register(InitFurnitureEntities.SIT.get(), SitRenderer::new);

        /*Predicate<RenderType> cutoutPredicate = renderType -> renderType == RenderType.cutout();

        for(RegistryObject<? extends Block> object : InitFurnitureBlocks.CUTOUT_BLOCKS)
            ItemBlockRenderTypes.setRenderLayer(object.get(), cutoutPredicate);*/
    }

    // @Override
    // public Level getClientWorld()
    // {
    // return Minecraft.getInstance().level;
    // }
    //
    // @Override
    // public Player getClientPlayer()
    // {
    // return Minecraft.getInstance().player;
    // }
}