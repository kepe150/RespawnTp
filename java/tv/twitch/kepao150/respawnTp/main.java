package tv.twitch.kepao150.respawnTp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tv.twitch.kepao150.respawnTp.commands.rtpReload;
import tv.twitch.kepao150.respawnTp.commands.setrespawntp;
import tv.twitch.kepao150.respawnTp.events.event_spawn;


public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getServer().getPluginManager().registerEvents(new event_spawn(), this);
        this.getCommand("setrespawntp").setExecutor(new setrespawntp());
        this.getCommand("rtpreload").setExecutor(new rtpReload());




    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
