package tv.twitch.kepao150.respawnTp.events;


import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;
import tv.twitch.kepao150.respawnTp.main;


import java.util.Objects;

import static org.bukkit.Bukkit.getServer;


public class event_spawn implements Listener{

    @EventHandler
    public void respawnevent(PlayerRespawnEvent pr){
        Player player = pr.getPlayer();
        Plugin plugin = main.getPlugin(main.class);
        FileConfiguration config = plugin.getConfig();

        double x = config.getDouble("location.x");
        double y = config.getDouble("location.y");
        double z = config.getDouble("location.z");
        float pitch = (float) config.getDouble("location.pitch");
        float yaw = (float) config.getDouble("location.yaw");
        World world = getServer().getWorld(Objects.requireNonNull(config.getString("location.world")));

        if (!pr.isBedSpawn()){
            pr.setRespawnLocation(new Location(world, x, y, z, yaw, pitch));


        }

        if (config.getBoolean("messages.enabled-msg")){
            player.sendMessage(config.getString("messages.respawn-msg"));
        }

        if (config.getBoolean("messages.enable-title")){
            String title = config.getString("messages.respawnTitle.title");
            String subTittle = config.getString("messages.respawnTitle.sub-title");
            int fade = config.getInt("messagesrespawnTitle.fadeIn");
            int stay = config.getInt("messages.respawnTitle.stay");
            int fadeOut = config.getInt("messages.respawnTitle.fadeOut");

            player.sendTitle(title, subTittle, fade, stay, fadeOut);
        }




    }
}
