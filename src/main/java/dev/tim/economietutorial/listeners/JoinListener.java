package dev.tim.economietutorial.listeners;

import dev.tim.economietutorial.EconomieTutorial;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private EconomieTutorial main;

    public JoinListener(EconomieTutorial main){
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        String uuid = player.getUniqueId().toString();

        if(!main.getConfig().contains(uuid)){
            main.getConfig().set(uuid, 100);
            main.saveConfig();
        }
    }
}
