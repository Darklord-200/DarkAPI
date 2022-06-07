package my.darklord.plugin.commands;

import my.darklord.api.command.DefaultCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class VanishCommand extends DefaultCommand {

    ArrayList<Player> vanishList = new ArrayList<>();

    protected VanishCommand(JavaPlugin plugin) {
        super(plugin, "vanish", "empty", "empty");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (sender instanceof Player player && args.length <= 1) {
            if (args[0].equalsIgnoreCase("off")) {
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.showPlayer(plugin, player);
                }
            }
            if (args[0].equalsIgnoreCase("on")) {
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.hidePlayer(plugin, player);
                }
            }
            if (vanishList.contains(player)) {
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.showPlayer(plugin, player);
                }
            }
            if (args[0].equalsIgnoreCase("on")) {
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.hidePlayer(plugin, player);
                }
            }
        }

        return false;
    }
}
