package tv.twitch.kepao150.respawnTp.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import tv.twitch.kepao150.respawnTp.main;

import java.util.Objects;

public class setrespawntp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Plugin plugin = main.getPlugin(main.class);
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            Location loc = player.getLocation();

            plugin.getConfig().set("location.enabled", true);
            plugin.getConfig().set("location.world", Objects.requireNonNull(loc.getWorld()).getName());
            plugin.getConfig().set("location.x", (double) loc.getBlockX() + 0.500);
            plugin.getConfig().set("location.y", (double) loc.getBlockY());
            plugin.getConfig().set("location.z", (double) loc.getBlockZ() + 0.500);


            plugin.getConfig().set("location.picth", (double) loc.getPitch());
            plugin.getConfig().set("location.yaw", (double) loc.getYaw());

            plugin.saveConfig();

            player.sendMessage("§6location defined as: x: "+loc.getBlockX()+" y: "+loc.getBlockY()+" z: "+loc.getBlockZ()+" world: "+loc.getWorld().getName());
            return true;
        }

        return false;
    }
}
