package my.darklord.api.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class ToggleCommand extends DefaultCommand {

    ArrayList<Player> statusList = new ArrayList<>();

    protected ToggleCommand(JavaPlugin plugin, @NotNull String name, @NotNull String description, @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(plugin, name, description, usageMessage, aliases);
    }

    protected ToggleCommand(JavaPlugin plugin, @NotNull String name, @NotNull String description, @NotNull String usageMessage) {
        super(plugin, name, description, usageMessage);
    }

    abstract boolean executeOff(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args);

    abstract boolean executeOn(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args);

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("off")) {
                    if (statusList.contains(player)) {
                        if (executeOff(sender, commandLabel, args)) {
                            statusList.remove(player);
                            return true;
                        }
                    }
                    player.sendMessage("it is already off");
                    return true;
                }
                if (args[0].equalsIgnoreCase("on")) {
                    if (!statusList.contains(player)) {
                        if (executeOn(sender, commandLabel, args)) {
                            statusList.add(player);
                            return true;
                        }
                    }
                    player.sendMessage("it is already on");
                    return true;
                }
            }
            if (statusList.contains(player)) {
                if (executeOff(sender, commandLabel, args)) {
                    statusList.remove(player);
                    return true;
                }
            } else {
                if (executeOn(sender, commandLabel, args)) {
                    statusList.add(player);
                    return false;
                }
            }
        }

        return false;
    }
}

