package de.marvinleiers.itemhunt.listeners;

import de.marvinleiers.itemhunt.ItemHunt;
import de.marvinleiers.marvinplugin.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class CollectListener implements Listener
{
    @EventHandler
    public void onItemCollect(PlayerPickupItemEvent event)
    {
        if (event.getItem().getItemStack().getType() == ItemHunt.getPlayerMaterials(event.getPlayer()))
        {
            Bukkit.broadcastMessage(Messages.get("item-found", event.getPlayer().getName()));
            ItemHunt.setPlayerMaterial(event.getPlayer(), null);
        }
    }

    @EventHandler
    public void onItemCollect(InventoryClickEvent event)
    {
        Player player = (Player) event.getWhoClicked();

        try
        {
            if (event.getCurrentItem().getType() == ItemHunt.getPlayerMaterials(player))
            {
                Bukkit.broadcastMessage(Messages.get("item-found", player.getName()));
                ItemHunt.setPlayerMaterial(player, null);
            }
        }
        catch (Exception ignored) {}
    }
}
