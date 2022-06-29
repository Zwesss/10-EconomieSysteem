package dev.tim.economietutorial.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ShopMenu {

    public ShopMenu(Player player){

        Inventory inv = Bukkit.createInventory(player, 27, ChatColor.BLUE.toString() + ChatColor.BOLD + "SHOP");

        ItemStack wood = new ItemStack(Material.OAK_PLANKS, 1);
        ItemMeta woodMeta = wood.getItemMeta();
        woodMeta.setDisplayName(ChatColor.GOLD + "Hout planken");
        woodMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "10 EURO",
                ChatColor.GRAY + "Klik om te kopen!"
        ));
        wood.setItemMeta(woodMeta);
        inv.setItem(11, wood);

        ItemStack stone = new ItemStack(Material.STONE, 1);
        ItemMeta stoneMeta = stone.getItemMeta();
        stoneMeta.setDisplayName(ChatColor.RED + "Steen");
        stoneMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "20 EURO",
                ChatColor.GRAY + "Klik om te kopen!"
        ));
        stone.setItemMeta(stoneMeta);
        inv.setItem(15, stone);

        player.openInventory(inv);

    }

}
