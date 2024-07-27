package me.streakstudios.flyCraft;

import me.streakstudios.flyCraft.commands.FlyListener;
import me.streakstudios.flyCraft.commands.FlyTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

public class FlyCraft extends JavaPlugin {

    private String reloadMessage;
    private String enableMessage;
    private String disableMessage;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        reloadFlyConfig();
        getCommand("fly").setExecutor(new me.streakstudios.flyCraft.commands.FlyCommand(this));
        getCommand("fly").setTabCompleter(new FlyTabCompleter());

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new FlyListener(), this);
    }

    public void reloadFlyConfig() {
        reloadConfig();
        reloadMessage = getConfig().getString("reload-message", "&7[&bFlyCraft&7] &aFlyCraft configuration reloaded.");
        enableMessage = getConfig().getString("enable-message", "&7[&bFlyCraft&7] &aFly mode enabled.");
        disableMessage = getConfig().getString("disable-message", "&7[&bFlyCraft&7] &cFly mode disabled.");
    }

    public String getReloadMessage() {
        return reloadMessage;
    }

    public String getEnableMessage() {
        return enableMessage;
    }

    public String getDisableMessage() {
        return disableMessage;
    }
}
