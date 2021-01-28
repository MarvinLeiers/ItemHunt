package de.marvinleiers.itemhunt.commands.subcommands;

import de.marvinleiers.itemhunt.utils.ItemHuntUtils;
import de.marvinleiers.marvinplugin.commands.Subcommand;
import org.bukkit.entity.Player;

public class RestartSubcommand extends Subcommand
{
    @Override
    public String getName()
    {
        return "restart";
    }

    @Override
    public String getDescription()
    {
        return "Restart ItemHunt";
    }

    @Override
    public String getSyntax()
    {
        return "/itemhunt restart";
    }

    @Override
    public String getPermission()
    {
        return "itemhunt.restart";
    }

    @Override
    public void execute(Player player, String[] strings)
    {
        ItemHuntUtils.start();
    }
}
