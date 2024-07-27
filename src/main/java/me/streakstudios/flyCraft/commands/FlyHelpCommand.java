package me.streakstudios.flyCraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FlyHelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.YELLOW + "FlyCraft Plugin Help:");
        sender.sendMessage(ChatColor.GOLD + "/fly" + ChatColor.WHITE + " - Toggle fly mode");
        sender.sendMessage(ChatColor.GOLD + "/fly reload" + ChatColor.WHITE + " - Reload FlyCraft configuration");
        sender.sendMessage(ChatColor.GOLD + "/fly help" + ChatColor.WHITE + " - Show this help message");
        return true;
    }
}
