package net.mehvahdjukaar.every_compat.modules.heart_and_home;

import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;


public class HearthAndHomeModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> sandedWood;
    public final SimpleEntrySet<WoodType, Block> parquet;
    public final SimpleEntrySet<WoodType, Block> trim;

    public HearthAndHomeModule(String modId) {
        super(modId, "hnh");


        sandedWood = SimpleEntrySet.builder(WoodType.class, "sandedWood",
                        () -> getModBlock("oak_sanded_wood"), () -> WoodTypeRegistry.getValue(new ResourceLocation("oak")),
                        w -> new Block(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.PLANKS, Registries.BLOCK)
                .addTag(ItemTags.PLANKS, Registries.ITEM)
                .addTexture(modRes("block/oak_sanded_wood"))
                .defaultRecipe()
                .build();

        this.addEntry(sandedWood);

        parquet = SimpleEntrySet.builder(WoodType.class, "parquet",
                        () -> getModBlock("oak_parquet"), () -> WoodTypeRegistry.getValue(new ResourceLocation("oak")),
                        w -> new Block(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.PLANKS, Registries.BLOCK)
                .addTag(ItemTags.PLANKS, Registries.ITEM)
                .addTexture(modRes("block/oak_parquet"))
                .defaultRecipe()
                .build();

        this.addEntry(parquet);

        trim = SimpleEntrySet.builder(WoodType.class, "trim",
                        () -> getModBlock("oak_trim"), () -> WoodTypeRegistry.getValue(new ResourceLocation("oak")),
                        w -> new Block(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.PLANKS, Registries.BLOCK)
                .addTag(ItemTags.PLANKS, Registries.ITEM)
                .addTexture(modRes("block/oak_trim"))
                .defaultRecipe()
                .build();

        this.addEntry(trim);
    }
}