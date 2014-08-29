package mc.xesau.bukkitutils.minigame.event;

import mc.xesau.bukkitutils.minigame.arena.Arena;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaLeaveReason;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ArenaLeaveEvent extends Event implements Cancellable {
	
	private HandlerList handlers = new HandlerList();
	private Arena arena;
	private ArenaLeaveReason reason;
	private boolean cancel = false;
	
	public ArenaLeaveEvent( Arena arena, ArenaLeaveReason reason )
	{
		this.arena = arena;
		this.reason = reason;
	}
	
	@Override
	public HandlerList getHandlers()
	{
		return handlers;
	}
	
	public Arena getArena()
	{
		return arena;
	}
	
	public ArenaLeaveReason getReason()
	{
		return reason;
	}

	@Override
	public boolean isCancelled() {
		return cancel;
	}

	@Override
	public void setCancelled( boolean cancel ) {
		this.cancel = cancel;
	}
	
	
}
