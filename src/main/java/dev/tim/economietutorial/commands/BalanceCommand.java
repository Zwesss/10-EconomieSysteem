package dev.tim.economietutorial.commands;

import dev.tim.economietutorial.EconomieTutorial;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {

    private EconomieTutorial main;

    public BalanceCommand(EconomieTutorial main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            String uuid = player.getUniqueId().toString();
            int euro = main.getConfig().getInt(uuid);

            player.sendMessage(ChatColor.YELLOW + "Je hebt " + ChatColor.GREEN + euro + ChatColor.YELLOW + " euro!");

        }

        return true;
    }
}
