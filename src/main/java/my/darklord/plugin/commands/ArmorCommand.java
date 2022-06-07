package my.darklord.plugin.commands;

import my.darklord.api.command.DefaultCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ArmorCommand extends DefaultCommand {

    protected ArmorCommand(JavaPlugin plugin) {
        super(plugin, "a", "empty", "empty");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (sender instanceof Player player) {
            ArmorStand armorstand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
            armorstand.setCustomNameVisible(true);
        }
        return false;
    }
}
