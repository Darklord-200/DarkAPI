package my.darklord.plugin;

import my.darklord.plugin.commands.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DarkAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        CommandManager.createCommands(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
