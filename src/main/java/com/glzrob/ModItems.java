package com.glzrob;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {

    // -------------------- START ITEM REGISTRIES --------------------

    public static final Item SUSPICIOUS_SUBSTANCE = register(
        new Item(new Item.Settings()),
        "suspicious_substance"
    );

    public static final Item SUSPICIOUS_MINERAL = register(
        new Item(new Item.Settings()),
        "suspicious_mineral"
    );

    // --------------------  END ITEM REGISTRIES  --------------------

    public static final RegistryKey<ItemGroup> CUSTOM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MyMod.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
        .icon(() -> new ItemStack(ModItems.SUSPICIOUS_MINERAL))
        .displayName(Text.translatable("itemGroup.my-mod"))
        .build();


    /**
     * Initialize the Mod Items. Create and add items to new ItemGroup
     */
    public static void initialize() {
        // Get the event for modifying entries in the ingredients group
        // And register an event handler that adds our suspicious item to the ingredients group

        Registry.register(Registries.ITEM_GROUP, CUSTOM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.SUSPICIOUS_MINERAL);
            itemGroup.add(ModItems.SUSPICIOUS_SUBSTANCE);
        });

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
