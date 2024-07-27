package me.streakstudios.flyCraft.commands;

import me.streakstudios.flyCraft.FlyCraft;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FlyReloadCommand implements CommandExecutor {

    private final FlyCraft plugin;

    public FlyReloadCommand(FlyCraft plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("fly.reload")) {
            plugin.reloadFlyConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getReloadMessage()));
        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
        }
        return true;
    }
}
