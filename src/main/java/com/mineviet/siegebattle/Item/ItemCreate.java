package com.mineviet.siegebattle.Item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ItemCreate {

    private ItemStack lobbyLocation;
    private ItemStack cornerLocation;
    private ItemStack deathLocation;
    private ItemStack setWorld;
    private ItemStack teamLocation;
    private ItemStack bauVatLocation;
    private ItemStack doneItem;

    public void init() {
        lobbyLocation = new ItemStack(Material.BLAZE_ROD);
        cornerLocation = new ItemStack(Material.GOLDEN_AXE);
        deathLocation = new ItemStack(Material.RED_WOOL);
        setWorld = new ItemStack(Material.STICK);
        teamLocation = new ItemStack(Material.DIAMOND_AXE);
        bauVatLocation = new ItemStack(Material.GOLD_BLOCK);
        doneItem = new ItemStack(Material.ANVIL);
    }

    public ItemStack giveItem(ItemID itemID) {
        switch (itemID) {
            case DONE_ITEM:
                ItemMeta meta = doneItem.getItemMeta();
                if (meta == null) return null;
                meta.setDisplayName(itemID.getName());
                doneItem.setItemMeta(meta);
                return doneItem;
            case SET_WORLD:
                ItemMeta meta1 = setWorld.getItemMeta();
                if (meta1 == null) return null;
                meta1.setDisplayName(itemID.getName());
                setWorld.setItemMeta(meta1);
                return setWorld;
            case SET_CORNER:
                ItemMeta meta2 = cornerLocation.getItemMeta();
                if (meta2 == null) return null;
                meta2.setDisplayName(itemID.getName());
                cornerLocation.setItemMeta(meta2);
                return cornerLocation;
            case DEATH_LOCATION:
                ItemMeta meta3 = deathLocation.getItemMeta();
                if (meta3 == null) return null;
                meta3.setDisplayName(itemID.getName());
                deathLocation.setItemMeta(meta3);
                return deathLocation;
            case LOBBY_LOCATION:
                ItemMeta meta4 = lobbyLocation.getItemMeta();
                if (meta4 == null) return null;
                meta4.setDisplayName(itemID.getName());
                lobbyLocation.setItemMeta(meta4);
                return lobbyLocation;
            case SPAWN_LOCATION:
                ItemMeta meta5 = teamLocation.getItemMeta();
                if (meta5 == null) return null;
                meta5.setDisplayName(itemID.getName());
                teamLocation.setItemMeta(meta5);
                return teamLocation;
            case BAUVAT_LOCATION:
                ItemMeta meta6 = bauVatLocation.getItemMeta();
                if (meta6 == null) return null;
                meta6.setDisplayName(itemID.getName());
                bauVatLocation.setItemMeta(meta6);
                return bauVatLocation;
        }
        return null;
    }


}
