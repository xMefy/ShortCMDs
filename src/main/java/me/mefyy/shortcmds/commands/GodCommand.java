package me.mefyy.shortcmds.commands;

import me.mefyy.shortcmds.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if(player.hasPermission("shortcmds.god")) {

                if (player.isInvulnerable()){

                    player.setInvulnerable(false);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("GodMode-Disabled")));
                } else {
                    player.setInvulnerable(true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("GodMode-Enabled")));
                    }
            } else if(!(player.hasPermission("shortcmds.god"))){

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("GodMode-No-Permission")));

        } else {

                String playerName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if (target == null){

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("GodMode-Player-Offline")));

                } else {

                    if (player.isInvulnerable()){

                        target.setInvulnerable(false);
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Successfully-Got-Disabled-GodMode")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Successfully-Disabled-GodMode-Player")));

                    } else {

                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Successfully-GodMode-Player")));
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Successfully-Got-GodMode")));

                    }

                }

            }

        }

        return true;
    }
}
