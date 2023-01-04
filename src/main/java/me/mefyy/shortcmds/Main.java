package me.mefyy.shortcmds;

import me.mefyy.shortcmds.commands.CreativeCommand;
import me.mefyy.shortcmds.commands.FeedCommand;
import me.mefyy.shortcmds.commands.GodCommand;
import me.mefyy.shortcmds.commands.SurvivalCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getLogger().info("ShortCMDs is enabled.");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("gmc").setExecutor(new CreativeCommand());
        getCommand("gms").setExecutor(new SurvivalCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());

    }

    @Override
    public void onDisable() {

        getLogger().info("ShortCMDs is disabled.");

    }

    public void onReload(){

        getLogger().info("ShortCMDs is reloading.");

        onDisable();
        onEnable();
    }
}
