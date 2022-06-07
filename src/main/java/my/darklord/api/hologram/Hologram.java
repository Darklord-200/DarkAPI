package my.darklord.api.hologram;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;

public class Hologram {

    World world;
    Location location;

    ArrayList<ArmorStand> armorStands = new ArrayList<ArmorStand>();

    public void addLine(World world, Location location, String line) {
        ArmorStand armorStand = (ArmorStand) world.spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setCustomNameVisible(true);
        armorStand.setCustomName(line);
        armorStands.add(armorStand);

    }
    public static void createHologram(World world, Location location, String text) {
        // world, location and text

    }
    
}
