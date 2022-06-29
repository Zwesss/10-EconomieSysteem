package dev.tim.economietutorial.listeners;

import dev.tim.economietutorial.EconomieTutorial;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    private EconomieTutorial main;

    public BlockBreakListener(EconomieTutorial main){
        this.main = main;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Player player = e.getPlayer();
        String uuid = player.getUniqueId().toString();
        int euro = main.getConfig().getInt(uuid);

        if(e.getBlock().getType().equals(Material.DIAMOND_ORE)){

            main.getConfig().set(uuid, euro + 50);
            main.saveConfig();
            player.sendMessage(ChatColor.GREEN + "+50 EURO!");

        }

    }

}
