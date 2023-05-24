package tv.mapper.embellishcraft.furniture.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.embellishcraft.core.ECConstants;

public class InitFurnitureEntities
{
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ECConstants.MODID);

    public static final RegistryObject<EntityType<SitEntity>> SIT = ENTITIES.register("sit", () -> EntityType.Builder.<SitEntity>of((type, world) -> new SitEntity(world), MobCategory.MISC).sized(0.0F, 0.0F).setCustomClientFactory((spawnEntity, world) -> new SitEntity(world)).build("sit"));

    public static void init()
    {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
