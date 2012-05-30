package com.efreak1996.BukkitManager.Logger.Block;

import java.util.HashMap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockIgniteEvent;

public class BlockIgniteLogger extends BmBlockLogger {
	
	public BlockIgniteLogger() {
		super("BlockIgnite");
	}	

	@EventHandler(priority = EventPriority.MONITOR)
	public void onBlockIgnite(BlockIgniteEvent event) {
		HashMap<String, Object> values = new HashMap<String, Object>();
		values.put("EventName", event.getEventName());
		values.put("Block", event.getBlock());
		values.put("Cancelled", event.isCancelled());
		values.put("IgniteCause", event.getCause());
		values.put("Player", event.getPlayer());
		info(values);
	}
	
	@Override
	public void setupLogger() {
		initialize(new BlockIgniteHandler(this));
		fileLogging = handler.fileLogging;
		dbLogging = handler.dbLogging;
	}
}
