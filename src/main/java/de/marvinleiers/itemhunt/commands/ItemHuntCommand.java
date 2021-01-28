package de.marvinleiers.itemhunt.commands;

import de.marvinleiers.itemhunt.commands.subcommands.RestartSubcommand;
import de.marvinleiers.itemhunt.commands.subcommands.StartSubcommand;
import de.marvinleiers.itemhunt.commands.subcommands.StopSubcommand;
import de.marvinleiers.marvinplugin.commands.RootCommand;

public class ItemHuntCommand extends RootCommand
{
    public ItemHuntCommand()
    {
        super("itemhunt");

        addSubcommand(new StartSubcommand());
        addSubcommand(new StopSubcommand());
        addSubcommand(new RestartSubcommand());
    }
}
