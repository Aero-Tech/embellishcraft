package tv.mapper.embellishcraft.furniture.world.inventory;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.embellishcraft.core.ECConstants;

public class ModContainers
{
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ECConstants.MODID);

    // public static final RegistryObject<MenuType<VerticalChestContainer>> VERTICAL_9X1 = CONTAINERS.register("vertical_9x1", () -> new MenuType<>(VerticalChestContainer::createGeneric9X1));
    // public static final RegistryObject<MenuType<VerticalChestContainer>> VERTICAL_9X2 = CONTAINERS.register("vertical_9x2", () -> new MenuType<>(VerticalChestContainer::createGeneric9X2));
    // public static final RegistryObject<MenuType<VerticalChestContainer>> VERTICAL_9X3 = CONTAINERS.register("vertical_9x3", () -> new MenuType<>(VerticalChestContainer::createGeneric9X3));
    // public static final RegistryObject<MenuType<VerticalChestContainer>> VERTICAL_9X4 = CONTAINERS.register("vertical_9x4", () -> new MenuType<>(VerticalChestContainer::createGeneric9X4));
    // public static final RegistryObject<MenuType<VerticalChestContainer>> VERTICAL_9X5 = CONTAINERS.register("vertical_9x5", () -> new MenuType<>(VerticalChestContainer::createGeneric9X5));
    // public static final RegistryObject<MenuType<VerticalChestContainer>> VERTICAL_9X6 = CONTAINERS.register("vertical_9x6", () -> new MenuType<>(VerticalChestContainer::createGeneric9X6));

    public static final RegistryObject<MenuType<CrateContainer>> CRATE_4X4 = CONTAINERS.register("crate_4x4", () -> new MenuType<>(CrateContainer::createCrate4X4));
    public static final RegistryObject<MenuType<CrateContainer>> CRATE_4X8 = CONTAINERS.register("crate_4x8", () -> new MenuType<>(CrateContainer::createCrate4X8));
}