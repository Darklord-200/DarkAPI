package my.darklord.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class VanishManager {

    ArrayList<Player> vanishList = new ArrayList<>();

    public void hideFromAll(JavaPlugin plugin, Player player) {
        for (Player target : Bukkit.getOnlinePlayers()) {
            target.hidePlayer(plugin, player);
        }
    }
    public void showToAll(JavaPlugin plugin, Player player) {
        for (Player target : Bukkit.getOnlinePlayers()) {
            target.showPlayer(plugin, player);
        }
    }
}
