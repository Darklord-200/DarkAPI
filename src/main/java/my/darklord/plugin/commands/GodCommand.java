package my.darklord.plugin.commands;

import my.darklord.api.command.DefaultCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GodCommand extends DefaultCommand {
    protected GodCommand(JavaPlugin plugin) {
        super(plugin, "god", "empty", "empty", new ArrayList<>());
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (player.isInvulnerable()) {
                player.setInvulnerable(true);
                player.sendMessage("You are now invulnerable");
            }
            else {
                player.setInvulnerable(false);
                player.sendMessage("You are no longer invulnerable");
            }
            return true;
        }
        return false;
    }
}
