package com.glzrob;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // -------------------- START ITEM REGISTRIES --------------------

    public static final Item SUSPICIOUS_SUBSTANCE = register(
        new Item(new Item.Settings()),
        "suspicious_substance"
    );

    // --------------------  END ITEM REGISTRIES  --------------------

    /**
     * Initialize the Mod Items. Create and add items to new ItemGroup
     */
    public static void initialize() {
        // Get the event for modifying entries in the ingredients group
        // And register an event handler that adds our suspicious item to the ingredients group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
            .register((itemGroup) -> itemGroup.add(ModItems.SUSPICIOUS_SUBSTANCE));
    }

    /**
     * Register an item
     *
     * @param item the item to be registered
     * @param id the id for that item
     */
    public static Item register(Item item, String id) {
        // Create item identifier
        Identifier itemID = Identifier.of(MyMod.MOD_ID, id);

        // Register the item
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the item
        return registeredItem;
    }

}
