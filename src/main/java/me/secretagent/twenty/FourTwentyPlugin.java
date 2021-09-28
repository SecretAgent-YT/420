package me.secretagent.twenty;

import me.secretagent.twenty.listeners.BlazeKilledListener;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class FourTwentyPlugin extends JavaPlugin {

    public HashMap<String, Integer> blazeKills = new HashMap<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new BlazeKilledListener(this), this);
    }

    @Override
    public void onDisable() {
        saveToConfig();
    }

    public void addKill(Player player) {
        if (!blazeKills.containsKey(player.getUniqueId().toString())) {
            blazeKills.put(player.getUniqueId().toString(), 0);
        }
        blazeKills.put(player.getUniqueId().toString(), blazeKills.get(player.getUniqueId().toString()) + 1);
    }

    private void saveToConfig() {
        for (String string : blazeKills.keySet()) {
            getConfig().set(string, blazeKills.get(string));
        }
        saveConfig();
    }

}
