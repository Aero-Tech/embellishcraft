package tv.mapper.embellishcraft.init;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import tv.mapper.embellishcraft.EmbellishCraft;
import tv.mapper.embellishcraft.entity.EntityChair;

public class ModEntities
{
    public static final EntityType<EntityChair> TYPE_CHAIR = null;

    @Mod.EventBusSubscriber(modid = EmbellishCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {

        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
        {
            IForgeRegistry<EntityType<?>> entityRegistry = event.getRegistry();

            entityRegistry.register(EntityType.Builder.create(EntityChair::new, EntityClassification.MISC).size(0.0001F, 0.0001F).build(EmbellishCraft.MODID + ":entity_sit").setRegistryName(EmbellishCraft.MODID + ":entity_sit"));
        }
    }
}