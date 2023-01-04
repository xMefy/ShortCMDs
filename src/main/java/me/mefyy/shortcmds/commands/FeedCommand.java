package me.mefyy.shortcmds.commands;

import me.mefyy.shortcmds.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {

            if(player.hasPermission("shortcmds.feed")) {

                player.setFoodLevel(20);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Feed-Message")));

            } else if(!(player.hasPermission("shortcmds.feed"))){

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Feed-No-Permission")));

            } else {

                String playerName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if (target == null){

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Feed-Player-Offline")));

                } else {

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Successfully-Fed-Player")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Successfully-Got-Fed")));

                }

            }

        }

        return true;
    }
}
