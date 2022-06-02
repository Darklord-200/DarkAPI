import org.bukkit.plugin.java.JavaPlugin;

public class CommandManager {

    JavaPlugin plugin;

    public CommandManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void createDefaultCommand(String commandName, String commandDescription, String commandUsage) {
        new DefaultCommand(this.plugin, commandName, commandDescription, commandUsage);
    }
}
