package de.marvinleiers.itemhunt;

import de.marvinleiers.customconfig.CustomConfig;
import de.marvinleiers.itemhunt.commands.ItemHuntCommand;
import de.marvinleiers.itemhunt.listeners.CollectListener;
import de.marvinleiers.itemhunt.listeners.QuitListener;
import de.marvinleiers.marvinplugin.MarvinPlugin;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ItemHunt extends MarvinPlugin
{
    private static final HashMap<Player, Material> playerMaterials = new HashMap<Player, Material>();
    private static final ArrayList<Material> materials = new ArrayList<>();
    private static List<String> forbiddenMaterials;
    private static CustomConfig customConfig;

    @Override
    public void onEnable()
    {
        super.onEnable();

        customConfig = new CustomConfig(this.getDataFolder().getPath() + "/config.yml");
        forbiddenMaterials = customConfig.getConfig().getStringList("forbidden-materials");


        add("item-hunt-message", "&7Your item is &e<v>");
        add("item-found", "&a<v> &7has obtained their item!");
        add("failed-to-obtain-item", "&c<v> &7failed to obtain their item in time!");
        add("item-hunt-stopped", "&7ItemHunt has been &cstopped");

        new ItemHuntCommand();

        this.getServer().getPluginManager().registerEvents(new QuitListener(), this);
        this.getServer().getPluginManager().registerEvents(new CollectListener(), this);

        this.loadItems();
    }

    private void loadItems()
    {
        for (Material material : Material.values())
        {
            String name = material.name();

            if ((material.isItem() || material.isEdible() || material.isInteractable()) &&
                    !forbiddenMaterials.contains(name) && !name.contains("WALL") && !name.contains("ATTACHED") &&
                    !name.contains("SPAWN"))
            {
                materials.add(material);
            }
        }
    }

    public static ArrayList<Material> getMaterials()
    {
        return materials;
    }

    public static Material getPlayerMaterials(Player player)
    {
        return playerMaterials.get(player);
    }

    public static void setPlayerMaterial(Player player, Material material)
    {
        playerMaterials.put(player, material);
    }

    public static HashMap<Player, Material> getPlayerMaterials()
    {
        return playerMaterials;
    }
}
