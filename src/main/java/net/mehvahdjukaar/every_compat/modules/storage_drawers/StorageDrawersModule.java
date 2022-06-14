package net.mehvahdjukaar.every_compat.modules.storage_drawers;

import com.jaquadro.minecraft.storagedrawers.block.BlockStandardDrawers;
import com.jaquadro.minecraft.storagedrawers.block.BlockTrim;
import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntityDrawers;
import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntityDrawersStandard;
import com.jaquadro.minecraft.storagedrawers.client.renderer.TileEntityDrawersRenderer;
import com.jaquadro.minecraft.storagedrawers.core.ModBlocks;
import com.jaquadro.minecraft.storagedrawers.core.ModItemGroup;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.selene.block_set.wood.WoodType;
import net.mehvahdjukaar.selene.client.asset_generators.textures.Palette;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.EntityRenderersEvent;
import org.jetbrains.annotations.NotNull;


public class StorageDrawersModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, BlockStandardDrawers> FULL_DRAWERS_1;
    public final SimpleEntrySet<WoodType, BlockStandardDrawers> FULL_DRAWERS_2;
    public final SimpleEntrySet<WoodType, BlockStandardDrawers> FULL_DRAWERS_4;
    public final SimpleEntrySet<WoodType, BlockStandardDrawers> HALF_DRAWERS_1;
    public final SimpleEntrySet<WoodType, BlockStandardDrawers> HALF_DRAWERS_2;
    public final SimpleEntrySet<WoodType, BlockStandardDrawers> HALF_DRAWERS_4;
    public final SimpleEntrySet<WoodType, BlockTrim> TRIMS;

    public StorageDrawersModule(String modId) {
        super(modId, "sd");

        FULL_DRAWERS_1 = SimpleEntrySet.builder("full_drawers_1",
                        ModBlocks.OAK_FULL_DRAWERS_1, () -> WoodType.OAK_WOOD_TYPE,
                        w -> new CompatStandardDrawers(1, false, BlockBehaviour.Properties.copy(w.planks)
                                .strength(3.0F, 5.0F).sound(SoundType.WOOD).isSuffocating(StorageDrawersModule::isSuffocating)
                                .isRedstoneConductor(StorageDrawersModule::isSuffocating)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(modRes("drawers"), Registry.BLOCK_REGISTRY)
                .addTag(modRes("drawers"), Registry.ITEM_REGISTRY)
                .setTab(ModItemGroup.STORAGE_DRAWERS)
                .defaultRecipe()
                .addTile(CompatStandardDrawersEntity1::new)
                .createPaletteFromOak(this::drawersPalette)
                .setRenderType(()-> RenderType::cutout)
                .addTexture(modRes("blocks/drawers_oak_front_1"))
                .addTexture(modRes("blocks/drawers_oak_side"))
                .addTexture(modRes("blocks/drawers_oak_sort"))
                .addTexture(modRes("blocks/drawers_oak_trim"))
                .build();

        this.addEntry(FULL_DRAWERS_1);

        FULL_DRAWERS_2 = SimpleEntrySet.builder("full_drawers_2",
                        ModBlocks.OAK_FULL_DRAWERS_2, () -> WoodType.OAK_WOOD_TYPE,
                        w -> new CompatStandardDrawers(2, false, BlockBehaviour.Properties.copy(w.planks)
                                .strength(3.0F, 5.0F).sound(SoundType.WOOD).isSuffocating(StorageDrawersModule::isSuffocating)
                                .isRedstoneConductor(StorageDrawersModule::isSuffocating)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(modRes("drawers"), Registry.BLOCK_REGISTRY)
                .addTag(modRes("drawers"), Registry.ITEM_REGISTRY)
                .setTab(ModItemGroup.STORAGE_DRAWERS)
                .defaultRecipe()
                .addTile(CompatStandardDrawersEntity2::new)
                .createPaletteFromOak(this::drawersPalette)
                .setRenderType(()-> RenderType::cutout)
                .addTexture(modRes("blocks/drawers_oak_front_2"))
                .addTexture(modRes("blocks/drawers_oak_side"))
                .addTexture(modRes("blocks/drawers_oak_sort"))
                .addTexture(modRes("blocks/drawers_oak_trim"))
                .build();

        this.addEntry(FULL_DRAWERS_2);

        FULL_DRAWERS_4 = SimpleEntrySet.builder("full_drawers_4",
                        ModBlocks.OAK_FULL_DRAWERS_4, () -> WoodType.OAK_WOOD_TYPE,
                        w -> new CompatStandardDrawers(4, false, BlockBehaviour.Properties.copy(w.planks)
                                .strength(3.0F, 5.0F).sound(SoundType.WOOD).isSuffocating(StorageDrawersModule::isSuffocating)
                                .isRedstoneConductor(StorageDrawersModule::isSuffocating)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(modRes("drawers"), Registry.BLOCK_REGISTRY)
                .addTag(modRes("drawers"), Registry.ITEM_REGISTRY)
                .setTab(ModItemGroup.STORAGE_DRAWERS)
                .defaultRecipe()
                .addTile(CompatStandardDrawersEntity4::new)
                .createPaletteFromOak(this::drawersPalette)
                .setRenderType(()-> RenderType::cutout)
                .addTexture(modRes("blocks/drawers_oak_front_4"))
                .addTexture(modRes("blocks/drawers_oak_side"))
                .addTexture(modRes("blocks/drawers_oak_sort"))
                .addTexture(modRes("blocks/drawers_oak_trim"))
                .build();

        this.addEntry(FULL_DRAWERS_4);

        HALF_DRAWERS_1 = SimpleEntrySet.builder("half_drawers_1",
                        ModBlocks.OAK_HALF_DRAWERS_1, () -> WoodType.OAK_WOOD_TYPE,
                        w -> new CompatStandardDrawers(1, true, BlockBehaviour.Properties.copy(w.planks)
                                .strength(3.0F, 5.0F).sound(SoundType.WOOD).isSuffocating(StorageDrawersModule::isSuffocating)
                                .isRedstoneConductor(StorageDrawersModule::isSuffocating)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(modRes("drawers"), Registry.BLOCK_REGISTRY)
                .addTag(modRes("drawers"), Registry.ITEM_REGISTRY)
                .setTab(ModItemGroup.STORAGE_DRAWERS)
                .defaultRecipe()
                .addTile(CompatStandardDrawersEntity1::new)
                .createPaletteFromOak(this::drawersPalette)
                .setRenderType(()-> RenderType::cutout)
                .addTexture(modRes("blocks/drawers_oak_front_1"))
                .addTexture(modRes("blocks/drawers_oak_side"))
                .addTexture(modRes("blocks/drawers_oak_side_h"))
                .addTexture(modRes("blocks/drawers_oak_side_v"))
                .addTexture(modRes("blocks/drawers_oak_sort"))
                .addTexture(modRes("blocks/drawers_oak_trim"))
                .build();

        this.addEntry(HALF_DRAWERS_1);

        HALF_DRAWERS_2 = SimpleEntrySet.builder("half_drawers_2",
                        ModBlocks.OAK_HALF_DRAWERS_2, () -> WoodType.OAK_WOOD_TYPE,
                        w -> new CompatStandardDrawers(2, true, BlockBehaviour.Properties.copy(w.planks)
                                .strength(3.0F, 5.0F).sound(SoundType.WOOD).isSuffocating(StorageDrawersModule::isSuffocating)
                                .isRedstoneConductor(StorageDrawersModule::isSuffocating)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(modRes("drawers"), Registry.BLOCK_REGISTRY)
                .addTag(modRes("drawers"), Registry.ITEM_REGISTRY)
                .setTab(ModItemGroup.STORAGE_DRAWERS)
                .defaultRecipe()
                .addTile(CompatStandardDrawersEntity2::new)
                .createPaletteFromOak(this::drawersPalette)
                .setRenderType(()-> RenderType::cutout)
                .addTexture(modRes("blocks/drawers_oak_front_2"))
                .addTexture(modRes("blocks/drawers_oak_side"))
                .addTexture(modRes("blocks/drawers_oak_side_h"))
                .addTexture(modRes("blocks/drawers_oak_side_v"))
                .addTexture(modRes("blocks/drawers_oak_sort"))
                .addTexture(modRes("blocks/drawers_oak_trim"))
                .build();

        this.addEntry(HALF_DRAWERS_2);

        HALF_DRAWERS_4 = SimpleEntrySet.builder("half_drawers_4",
                        ModBlocks.OAK_HALF_DRAWERS_4, () -> WoodType.OAK_WOOD_TYPE,
                        w -> new CompatStandardDrawers(4, true, BlockBehaviour.Properties.copy(w.planks)
                                .strength(3.0F, 5.0F).sound(SoundType.WOOD).isSuffocating(StorageDrawersModule::isSuffocating)
                                .isRedstoneConductor(StorageDrawersModule::isSuffocating)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(modRes("drawers"), Registry.BLOCK_REGISTRY)
                .addTag(modRes("drawers"), Registry.ITEM_REGISTRY)
                .setTab(ModItemGroup.STORAGE_DRAWERS)
                .defaultRecipe()
                .addTile(CompatStandardDrawersEntity4::new)
                .createPaletteFromOak(this::drawersPalette)
                .setRenderType(()-> RenderType::cutout)
                .addTexture(modRes("blocks/drawers_oak_front_4"))
                .addTexture(modRes("blocks/drawers_oak_side"))
                .addTexture(modRes("blocks/drawers_oak_side_h"))
                .addTexture(modRes("blocks/drawers_oak_side_v"))
                .addTexture(modRes("blocks/drawers_oak_sort"))
                .addTexture(modRes("blocks/drawers_oak_trim"))
                .build();

        this.addEntry(HALF_DRAWERS_4);

        TRIMS = SimpleEntrySet.builder("trim",
                        ModBlocks.OAK_TRIM, () -> WoodType.OAK_WOOD_TYPE,
                        w -> new BlockTrim(BlockBehaviour.Properties.copy(w.planks).sound(SoundType.WOOD).strength(5.0F)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .setTab(ModItemGroup.STORAGE_DRAWERS)
                .defaultRecipe()
                .createPaletteFromOak(this::trimPalette)
                .addTexture(modRes("blocks/drawers_oak_trim"))
                .build();

        this.addEntry(TRIMS);
    }

    private void drawersPalette(Palette p) {
        p.remove(p.getLightest());
        p.increaseInner();
        p.increaseInner();
        p.increaseInner();
        p.increaseUp();
    }

    private void trimPalette(Palette p) {
        p.remove(p.getLightest());
        p.increaseInner();
        p.increaseUp();
    }

    private static boolean isSuffocating(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    @Override
    public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer((BlockEntityType<TileEntityDrawersStandard.Slot1>) (FULL_DRAWERS_1.getTileHolder().tile), TileEntityDrawersRenderer::new);
        event.registerBlockEntityRenderer((BlockEntityType<TileEntityDrawersStandard.Slot2>) (FULL_DRAWERS_2.getTileHolder().tile), TileEntityDrawersRenderer::new);
        event.registerBlockEntityRenderer((BlockEntityType<TileEntityDrawersStandard.Slot4>) (FULL_DRAWERS_4.getTileHolder().tile), TileEntityDrawersRenderer::new);
        event.registerBlockEntityRenderer((BlockEntityType<TileEntityDrawersStandard.Slot1>) (HALF_DRAWERS_1.getTileHolder().tile), TileEntityDrawersRenderer::new);
        event.registerBlockEntityRenderer((BlockEntityType<TileEntityDrawersStandard.Slot2>) (HALF_DRAWERS_2.getTileHolder().tile), TileEntityDrawersRenderer::new);
        event.registerBlockEntityRenderer((BlockEntityType<TileEntityDrawersStandard.Slot4>) (HALF_DRAWERS_4.getTileHolder().tile), TileEntityDrawersRenderer::new);
    }

    private class CompatStandardDrawers extends BlockStandardDrawers {
        public CompatStandardDrawers(int drawerCount, boolean halfDepth, Properties properties) {
            super(drawerCount, halfDepth, properties);
        }

        public TileEntityDrawers newBlockEntity(BlockPos pos, BlockState state) {
            return switch (this.getDrawerCount()) {
                case 1 -> new CompatStandardDrawersEntity1(pos, state);
                case 2 -> new CompatStandardDrawersEntity2(pos, state);
                case 4 -> new CompatStandardDrawersEntity4(pos, state);
                default -> null;
            };
        }
    }

    class CompatStandardDrawersEntity1 extends TileEntityDrawersStandard.Slot1 {

        public CompatStandardDrawersEntity1(BlockPos pos, BlockState state) {
            super(pos, state);
        }

        @Override
        public @NotNull BlockEntityType<?> getType() {
            return FULL_DRAWERS_1.getTileHolder().tile;
        }
    }

    class CompatStandardDrawersEntity2 extends TileEntityDrawersStandard.Slot2 {

        public CompatStandardDrawersEntity2(BlockPos pos, BlockState state) {
            super(pos, state);
        }

        @Override
        public @NotNull BlockEntityType<?> getType() {
            return FULL_DRAWERS_2.getTileHolder().tile;
        }
    }

    class CompatStandardDrawersEntity4 extends TileEntityDrawersStandard.Slot4 {

        public CompatStandardDrawersEntity4(BlockPos pos, BlockState state) {
            super(pos, state);
        }

        @Override
        public @NotNull BlockEntityType<?> getType() {
            return FULL_DRAWERS_4.getTileHolder().tile;
        }
    }
}
