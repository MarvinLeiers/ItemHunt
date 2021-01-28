package de.marvinleiers.itemhunt.utils;

import de.marvinleiers.itemhunt.ItemHunt;
import de.marvinleiers.marvinplugin.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class ItemHuntUtils
{
    private static final Random random = new Random();

    public static void stop()
    {
        ItemHunt.getPlayerMaterials().clear();

        Bukkit.broadcastMessage(Messages.get("item-hunt-stopped"));
    }

    public static void start()
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for (Player all : Bukkit.getOnlinePlayers())
                {
                    ItemStack item = new ItemStack(ItemHunt.getMaterials().get(random.nextInt(ItemHunt.getMaterials().size())));
                    all.sendMessage(Messages.get("item-hunt-message", ItemHuntUtils.beautifyName(item.getType().name())));
                    ItemHunt.setPlayerMaterial(all, item.getType());

                    if (all.getInventory().contains(item.getType()))
                    {
                        Bukkit.broadcastMessage(Messages.get("item-found", all.getName()));
                        ItemHunt.setPlayerMaterial(all, null);
                    }
                }
            }
        }.runTask(ItemHunt.getInstance());

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for (Player player : ItemHunt.getPlayerMaterials().keySet())
                {
                    if (ItemHunt.getPlayerMaterials(player) != null)
                    {
                        Bukkit.broadcastMessage(Messages.get("failed-to-obtain-item", player.getName()));
                        player.setGameMode(GameMode.SPECTATOR);
                    }
                }
            }
        }.runTaskLater(ItemHunt.getInstance(), 20 * 60 * 5);
    }

    public static String beautifyName(String str)
    {
        str = str.toLowerCase().replace("_", " ");
        String name = "";

        for (String word : str.split(" "))
        {
            name += word.substring(0, 1).toUpperCase() + word.substring(1) + " ";
        }

        return name.trim();
    }
}
