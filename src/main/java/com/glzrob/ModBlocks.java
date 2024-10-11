package com.glzrob;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // -------------------- START ITEM REGISTRIES --------------------

    public static final Block CONDENSED_DIRT = register(
        new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRAVEL)),
        "condensed_dirt",
        true
    );

    // --------------------  END ITEM REGISTRIES  --------------------

    /**
     * Initialize the Mod Blocks.
     */
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ModItems.CUSTOM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlocks.CONDENSED_DIRT.asItem());
        });
    }

    /**
     * Register an block (and its item if needed)
     *
     * @param block the block to be registered
     * @param id the id for that item
     * @param shouldRegister the block's item is to be registered or not
     */
    public static Block register(Block block, String name, boolean shouldRegister) {
        // Register the block and its item
        Identifier id = Identifier.of(MyMod.MOD_ID, name);

        if (shouldRegister) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }
}
