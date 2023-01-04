package me.mefyy.shortcmds.commands;

import me.mefyy.shortcmds.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SurvivalCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("shortcmds.gms")) {

                player.setGameMode(GameMode.getByValue(0));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Survival-Message")));

            } else if (!(player.hasPermission("shortcmds.gms"))){

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Survival-No-Permission")));

            } else {

                String playerName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if (target == null){

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Survival-Player-Offline")));

                } else {

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Successfully-Survival-Player")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("Successfully-Got-Survival")));

                }

            }

            }
        return true;
        }
    }