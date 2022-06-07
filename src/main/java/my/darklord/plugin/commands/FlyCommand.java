package my.darklord.plugin.commands;

import my.darklord.api.command.DefaultCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class FlyCommand extends DefaultCommand {
    protected FlyCommand(JavaPlugin plugin) {
        super(plugin, "fly", "empty", "empty");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (sender instanceof Player player) {
            player.setAllowFlight(!player.getAllowFlight());
        }
        return true;
    }
}
