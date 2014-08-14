package mc.xesau.bukkitutils.minigame.event;

import mc.xesau.bukkitutils.minigame.BukkitUtilsMinigame;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaLeaveReason;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerEventHandler implements Listener {

	@EventHandler( ignoreCancelled = true )
	public void onPlayerLeave( PlayerQuitEvent e )
	{
		BukkitUtilsMinigame.leaveArena( e.getPlayer (), ArenaLeaveReason.DISCONNECT );
	}
	
	@EventHandler( ignoreCancelled = true )
	public void onPlayerLeave( PlayerKickEvent e )
	{
		BukkitUtilsMinigame.leaveArena( e.getPlayer(), ArenaLeaveReason.DISCONNECT );
	}
	
	@EventHandler( priority = EventPriority.LOWEST, ignoreCancelled = true )
	public void onPlayerCommand( PlayerCommandPreprocessEvent e )
	{
		if( e.getMessage().toLowerCase( ).startsWith( "/leave" ) )
		{
			BukkitUtilsMinigame.leaveArena( e.getPlayer(), ArenaLeaveReason.COMMAND );
		}
	}
}
