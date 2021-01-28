package de.marvinleiers.itemhunt.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener
{
    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        event.getPlayer().setGameMode(GameMode.SURVIVAL);
    }
}
