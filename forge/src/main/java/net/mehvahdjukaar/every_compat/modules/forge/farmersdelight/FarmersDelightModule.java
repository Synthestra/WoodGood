package net.mehvahdjukaar.every_compat.modules.forge.farmersdelight;

import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.resources.textures.Palette;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

public class FarmersDelightModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> cabinets;

    public FarmersDelightModule(String modId) {
        super(modId, "fd");

        cabinets = SimpleEntrySet.builder(WoodType.class, "cabinet",
                        () -> getModBlock("oak_cabinet"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new CabinetBlock(Utils.copyPropertySafe(w.planks)))
                .addTag(modRes("cabinets"), Registries.BLOCK)
                .addTag(modRes("cabinets"), Registries.ITEM)
                .addTag(modRes("cabinets/wooden"), Registries.ITEM)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .defaultRecipe()
                .addTile(ModBlockEntityTypes.CABINET)
                .setTab(ModCreativeTabs.TAB_FARMERS_DELIGHT::get)
                .createPaletteFromOak(Palette::increaseDown)
                .addTexture(EveryCompat.res("block/oak_cabinet_front"))
                .addTexture(EveryCompat.res("block/oak_cabinet_side"))
                .addTexture(EveryCompat.res("block/oak_cabinet_top"))
                .addTextureM(EveryCompat.res("block/oak_cabinet_front_open"), EveryCompat.res("block/oak_cabinet_front_open_m"))
                .build();

        this.addEntry(cabinets);
    }

}
