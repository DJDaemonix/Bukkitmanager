package org.efreak1996.Bukkitmanager.Commands.Autosave;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

import org.efreak1996.Bukkitmanager.ThreadManager;
import org.efreak1996.Bukkitmanager.ThreadType;
import org.efreak1996.Bukkitmanager.Commands.Command;
import org.efreak1996.Bukkitmanager.Commands.CommandCategory;

public class AutosaveRestartCmd extends Command {

	private static ThreadManager func;
	
	public AutosaveRestartCmd() {
		super("restart", "Autosave.Restart", new ArrayList<String>(), CommandCategory.AUTOSAVE);
		func = new ThreadManager();
	}

	@Override
	public boolean execute(CommandSender sender, String[] args, Integer length) {
		if (args.length < (1 + length)) io.sendFewArgs(sender, "/bm autosave restart");
		else if (args.length > (1 + length)) io.sendManyArgs(sender, "/bm autosave restart");
		else {
			if (has(sender, "bm.autosave.restart")) {
				io.sendTranslation(sender, "Command.Autosave.Restart");
				func.stopThread(ThreadType.AUTOSAVE);
				func.startThread(ThreadType.AUTOSAVE);
			}
		}
		return true;
	}
}
