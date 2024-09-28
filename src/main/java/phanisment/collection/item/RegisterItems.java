package phanisment.collection.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import phanisment.collection.Weapons;

public class RegisterItems {
	public static final Item HELLFIRE_TALON = registerItem("hellfire_talon", new Item(new FabricItemSettings()));
	
	private static void addToItemsGroup(FabricItemGroupEntries item) {
		item.add(HELLFIRE_TALON);
	}
	
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(Weapons.MOD_ID, name), item);
	}
	
	public static void register() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(RegisterItems::addToItemsGroup);
	}
}