package my.darklord.plugin.commands;

import org.bukkit.plugin.java.JavaPlugin;

public class CommandManager {
    public static void createCommands(JavaPlugin plugin) {
        new FlyCommand(plugin);
        new GodCommand(plugin);
        new VanishCommand(plugin);
    }
}
