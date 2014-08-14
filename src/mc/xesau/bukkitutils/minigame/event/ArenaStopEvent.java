package mc.xesau.bukkitutils.minigame.event;

import mc.xesau.bukkitutils.minigame.arena.Arena;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaStopReason;

import org.bukkit.event.Cancellable;

public class ArenaStopEvent implements Cancellable {

	public ArenaStopEvent( Arena arena, ArenaStopReason reason )
	{
		this.arena = arena;
		this.reason = reason;
	}
	
	private Arena arena;
	private ArenaStopReason reason;
	
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
	
}
