package my.darklord.api.command;

import my.darklord.plugin.DarkAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class DefaultCommand extends Command {

    public JavaPlugin plugin;

    protected DefaultCommand(JavaPlugin plugin, @NotNull String name, @NotNull String description, @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(name, description, usageMessage, aliases);
        this.plugin = plugin;
        try {
            Field commandField = plugin.getServer().getClass().getDeclaredField("commandMap");
            commandField.setAccessible(true);
            CommandMap commandMap = (CommandMap) commandField.get(plugin.getServer());
            commandMap.register(name, this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    protected DefaultCommand(JavaPlugin plugin, @NotNull String name, @NotNull String description, @NotNull String usageMessage) {
        super(name, description, usageMessage, new ArrayList<>());
        this.plugin = plugin;
        try {
            Field commandField = plugin.getServer().getClass().getDeclaredField("commandMap");
            commandField.setAccessible(true);
            CommandMap commandMap = (CommandMap) commandField.get(plugin.getServer());
            commandMap.register(name, this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

