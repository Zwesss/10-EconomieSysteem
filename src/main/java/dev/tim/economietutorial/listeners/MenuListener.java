package dev.tim.economietutorial.listeners;

import dev.tim.economietutorial.EconomieTutorial;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuListener implements Listener {

    private EconomieTutorial main;

    public MenuListener(EconomieTutorial main){
        this.main = main;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        String uuid = player.getUniqueId().toString();
        int euro = main.getConfig().getInt(uuid);

        if(e.getView().getTitle().equals(ChatColor.BLUE.toString() + ChatColor.BOLD + "SHOP")){
            e.setCancelled(true);

            switch (e.getRawSlot()){
                case 11: // wood 10 euro
                    if(euro >= 10){
                        main.getConfig().set(uuid, euro - 10);
                        main.saveConfig();
                        player.getInventory().addItem(new ItemStack(Material.OAK_PLANKS, 1));
                        player.sendMessage(ChatColor.GREEN + "Item succesvol gekocht!");
                    } else {
                        player.sendMessage(ChatColor.RED + "Je hebt niet genoeg geld om dit te kopen!");
                    }
                    break;
                case 15: // stone 20 euro
                    if(euro >= 20){
                        main.getConfig().set(uuid, euro - 20);
                        main.saveConfig();
                        player.getInventory().addItem(new ItemStack(Material.STONE, 1));
                        player.sendMessage(ChatColor.GREEN + "Item succesvol gekocht!");
                    } else {
                        player.sendMessage(ChatColor.RED + "Je hebt niet genoeg geld om dit te kopen!");
                    }
                    break;
                default:
                    return;
            }

            player.closeInventory();

        }

    }

}
