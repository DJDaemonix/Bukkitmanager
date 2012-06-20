package org.efreak1996.Bukkitmanager.Logger.Block;

import java.io.File;
import java.util.Date;
import java.util.HashMap;

import org.bukkit.block.Block;
import org.efreak1996.Bukkitmanager.Logger.BmLoggerConfiguration;


public class BlockPistonRetractHandler extends BmBlockHandler {

	public BlockPistonRetractHandler(BlockPistonRetractLogger arg1logger) {
		super(new File("Block" + File.separator + "BlockPistonRetract.log"), arg1logger, BmLoggerConfiguration.get("Block.BlockPistonRetract.File"), BmLoggerConfiguration.get("Block.BlockPistonRetract.Database"));
	}
	
	public String logFile(HashMap<String, Object> values) {
		String msg = io.translate("Logger.Block.BlockPistonRetract");
		return msg;
	}

	@Override
	public void logDb(HashMap<String, Object> values) {
		db.log("Log_BlockPistonRetractEvent", "time, block, cancelled", "'" + new Date().toGMTString() +  "', '" + (Block) values.get("Block") + "', '" + (Boolean) values.get("Cancelled") + "'");		
	}
}