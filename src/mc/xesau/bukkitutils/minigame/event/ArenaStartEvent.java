package mc.xesau.bukkitutils.minigame.event;

import mc.xesau.bukkitutils.minigame.arena.Arena;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaStartReason;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ArenaStartEvent extends Event implements Cancellable, ArenaEvent {
	
	private HandlerList handlers = new HandlerList();
	private Arena arena;
	private boolean cancel = false;
	private ArenaStartReason reason;
	
	public ArenaStartEvent( Arena arena, ArenaStartReason reason )
	{
		this.arena = arena;
		this.reason = reason;
	}
	
	public ArenaStartReason getReason()
	{
		return reason;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	@Override
	public Arena getArena() {
		return arena;
	}

	
	@Override
	public boolean isCancelled()
	{
		return cancel;
	}
	
	@Override
	public void setCancelled( boolean cancel )
	{
		this.cancel = cancel;
	}
}

