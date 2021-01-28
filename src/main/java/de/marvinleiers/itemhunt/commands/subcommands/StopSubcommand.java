package de.marvinleiers.itemhunt.commands.subcommands;

import de.marvinleiers.itemhunt.utils.ItemHuntUtils;
import de.marvinleiers.marvinplugin.commands.Subcommand;
import org.bukkit.entity.Player;

public class StopSubcommand extends Subcommand
{
    @Override
    public String getName()
    {
        return "stop";
    }

    @Override
    public String getDescription()
    {
        return "Stops ItemHunt";
    }

    @Override
    public String getSyntax()
    {
        return "/itemhunt stop";
    }

    @Override
    public String getPermission()
    {
        return "itemhunt.stop";
    }

    @Override
    public void execute(Player player, String[] strings)
    {
        ItemHuntUtils.stop();
    }
}
