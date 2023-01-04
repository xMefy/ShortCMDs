package me.mefyy.shortcmds.commands;

import me.mefyy.shortcmds.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (sender instanceof Player){

          if(args[0] == "shortcmds") {

              player.sendMessage(ChatColor.YELLOW + "ShortCMDs 1.0.0 is running on this server");

          }
        } else if (player.hasPermission("shortcmds.reload")){

          if(args[1] == "reload") {

              Main reload = new Main();
              reload.onReload();
          }

        }

        return true;
    }
}