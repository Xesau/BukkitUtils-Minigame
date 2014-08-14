package mc.xesau.bukkitutils.minigame.event;

import mc.xesau.bukkitutils.minigame.arena.Arena;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaJoinReason;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ArenaJoinEvent extends Event implements Cancellable, ArenaEvent, PlayerEvent {

	private static final HandlerList handlers = new HandlerList();
	private boolean cancel = false;
	private Player player;
	private Arena arena;
	private ArenaJoinReason reason;
	
	public ArenaJoinEvent( Player player, Arena arena, ArenaJoinReason reason )
	{
		this.player = player;
		this.arena = arena;
		this.reason = reason;
	}
	
	@Override
	public HandlerList getHandlers()
	{
		return handlers;
	}
	
	public ArenaJoinReason getReason()
	{
		return reason;
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

	@Override
	public Arena getArena()
	{
		return arena;
	}

	@Override
	public Player getPlayer()
	{
		return player;
	}
	
}
