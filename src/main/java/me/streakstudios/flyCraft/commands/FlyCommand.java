package me.streakstudios.flyCraft.commands;

import me.streakstudios.flyCraft.FlyCraft;
import me.streakstudios.flyCraft.commands.FlyListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    private final FlyCraft plugin;

    public FlyCommand(FlyCraft plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("fly.use")) {
                    boolean flying = player.getAllowFlight();
                    player.setAllowFlight(!flying);
                    if (!flying) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getEnableMessage()));
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getDisableMessage()));
                    }

                    // Add player to the no-fall-damage set if disabling fly mode
                    if (flying) {
                        FlyListener.noFallDamagePlayers.add(player.getUniqueId());
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "&7[&bFlyCraft&7] &cYou do not have permission to use this command.");
                }
            } else {
                sender.sendMessage("This command can only be used by players.");
            }
            return true;
        }

        if (args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "reload":
                    if (sender.hasPermission("fly.reload")) {
                        plugin.reloadFlyConfig();
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getReloadMessage()));
                    } else {
                        sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                    }
                    return true;

                case "help":
                    sender.sendMessage(ChatColor.DARK_AQUA + "FlyCraft Plugin Help:");
                    sender.sendMessage(ChatColor.AQUA + "/fly" + ChatColor.WHITE + " - Toggle fly mode");
                    sender.sendMessage(ChatColor.AQUA + "/fly reload" + ChatColor.WHITE + " - Reload FlyCraft configuration");
                    sender.sendMessage(ChatColor.AQUA + "/fly help" + ChatColor.WHITE + " - Show this help message");
                    return true;

                default:
                    sender.sendMessage(ChatColor.RED + "Invalid subcommand. Use /fly help for a list of commands.");
                    return false;
            }
        }

        sender.sendMessage(ChatColor.RED + "Invalid usage. Use /fly help for a list of commands.");
        return false;
    }
}
