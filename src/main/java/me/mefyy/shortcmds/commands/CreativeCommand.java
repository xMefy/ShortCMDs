package me.mefyy.shortcmds.commands;

import me.mefyy.shortcmds.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreativeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("shortcmds.gmc")) {

                player.setGameMode(GameMode.getByValue(1));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Creative-Message")));

            } else if(!(player.hasPermission("shortcmds.gmc"))) {

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Creative-No-Permission")));

                } else {

                String playerName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if (target == null){

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Creative-Player-Offline")));

                } else {

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Successfully-Creative-Player")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Successfully-Got-Creative")));

                }

            }

            }
        return true;
    }
}
