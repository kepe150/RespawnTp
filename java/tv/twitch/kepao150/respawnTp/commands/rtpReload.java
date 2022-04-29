package tv.twitch.kepao150.respawnTp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import tv.twitch.kepao150.respawnTp.main;

public class rtpReload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Plugin plugin = main.getPlugin(main.class);
        plugin.reloadConfig();
        sender.sendMessage("§6Config reloaded!");
        return true;
    }
}
