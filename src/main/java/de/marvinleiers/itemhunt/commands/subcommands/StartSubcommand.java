package de.marvinleiers.itemhunt.commands.subcommands;

import de.marvinleiers.itemhunt.utils.ItemHuntUtils;
import de.marvinleiers.marvinplugin.commands.Subcommand;
import org.bukkit.entity.Player;

public class StartSubcommand extends Subcommand
{
    @Override
    public String getName()
    {
        return "start";
    }

    @Override
    public String getDescription()
    {
        return "Start ItemHunt";
    }

    @Override
    public String getSyntax()
    {
        return "/itemhunt start";
    }

    @Override
    public String getPermission()
    {
        return "itemhunt.start";
    }

    @Override
    public void execute(Player player, String[] strings)
    {
        ItemHuntUtils.start();
    }
}
