package mc.xesau.bukkitutils.minigame.event;

import mc.xesau.bukkitutils.minigame.arena.Arena;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaStopReason;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ArenaStopEvent extends Event implements Cancellable, ArenaEvent {

	private HandlerList handlers = new HandlerList();
	private Arena arena;
	private ArenaStopReason reason;
	
	public ArenaStopEvent( Arena arena, ArenaStopReason reason )
	{
		this.arena = arena;
		this.reason = reason;
	}
	
	public Arena getArena()
	{
		return arena;
	}
	
	public ArenaStopReason getReason()
	{
		return reason;
	}
	
	private boolean cancel = false;

	@Override
	public boolean isCancelled() {
		return cancel;
	}

	@Override
	public void setCancelled( boolean cancel ) {
		this.cancel = cancel;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
}
