package mc.xesau.bukkitutils.minigame.event;

import org.bukkit.event.Cancellable;

import mc.xesau.bukkitutils.minigame.arena.Arena;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaLeaveReason;

public class ArenaLeaveEvent implements Cancellable {

	public ArenaLeaveEvent( Arena arena, ArenaLeaveReason reason )
	{
		this.arena = arena;
		this.reason = reason;
	}
	
	private Arena arena;
	private ArenaLeaveReason reason;
	
	public Arena getArena()
	{
		return arena;
	}
	
	public ArenaLeaveReason getReason()
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
