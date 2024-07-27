package me.streakstudios.flyCraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlyTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("fly")) {
            if (args.length == 1) {
                List<String> subcommands = Arrays.asList("reload", "help");
                List<String> suggestions = new ArrayList<>();
                for (String subcommand : subcommands) {
                    if (subcommand.toLowerCase().startsWith(args[0].toLowerCase())) {
                        suggestions.add(subcommand);
                    }
                }
                return suggestions;
            }
        }
        return null;
    }
}
