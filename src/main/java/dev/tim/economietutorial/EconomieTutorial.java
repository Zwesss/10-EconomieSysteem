package dev.tim.economietutorial;

import dev.tim.economietutorial.commands.BalanceCommand;
import dev.tim.economietutorial.commands.ShopCommand;
import dev.tim.economietutorial.listeners.BlockBreakListener;
import dev.tim.economietutorial.listeners.JoinListener;
import dev.tim.economietutorial.listeners.MenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class EconomieTutorial extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);
        getServer().getPluginManager().registerEvents(new MenuListener(this), this);

        getCommand("balance").setExecutor(new BalanceCommand(this));
        getCommand("shop").setExecutor(new ShopCommand());

        getConfig().options().copyDefaults(true);
        saveConfig();

    }

}
