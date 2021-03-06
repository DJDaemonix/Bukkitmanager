package org.efreak.bukkitmanager.logger.block;

import java.io.File;
import java.util.Date;
import java.util.HashMap;

import org.bukkit.block.Block;
import org.efreak.bukkitmanager.logger.LoggerConfiguration;


public class BlockPlaceHandler extends BlockHandler {

	public BlockPlaceHandler(BlockPlaceLogger arg1logger) {
		super(new File("Block" + File.separator + "BlockPlace.log"), arg1logger, LoggerConfiguration.get("Block.BlockPlace.File"), LoggerConfiguration.get("Block.BlockPlace.Database"));
	}
	
	public String logFile(HashMap<String, Object> values) {
		String msg = io.translate("Logger.Block.BlockPlace");
		return msg;
	}

	@Override
	public void logDb(HashMap<String, Object> values) {
		db.log("Log_BlockPlaceEvent", "time, block, cancelled", "'" + new Date().toGMTString() +  "', '" + (Block) values.get("Block") + "', '" + (Boolean) values.get("Cancelled") + "'");		
	}
}
