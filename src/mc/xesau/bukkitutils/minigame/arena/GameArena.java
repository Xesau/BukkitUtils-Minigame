package mc.xesau.bukkitutils.minigame.arena;

import java.util.ArrayList;
import java.util.UUID;

import mc.xesau.bukkitutils.UUIDManager;
import mc.xesau.bukkitutils.minigame.BukkitUtilsMinigame;
import mc.xesau.bukkitutils.minigame.event.ArenaJoinEvent;
import mc.xesau.bukkitutils.minigame.event.ArenaStopEvent;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaJoinReason;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaLeaveReason;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaStartReason;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaStopReason;
import mc.xesau.bukkitutils.player.InventoryData;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GameArena implements Arena {

	private String arenaName;
	
	private ArenaRegion region;
	
	private int maxPlayers;
	private int minPlayers;
	
	private ArenaStatus status;
	
	private ArrayList< Player > ingamePlayers;
	private UUIDManager< InventoryData > inventories;
	
	@Override
	public String getName()
	{
		return arenaName;
	}
	
	public void setName( String name )
	{
		this.arenaName = name;
	}

	@Override
	public ArenaRegion getRegion()
	{
		return region;
	}

	@Override
	public int getMaxPlayers()
	{
		return this.maxPlayers;
	}

	@Override
	public int getMinPlayers()
	{
		return this.minPlayers;
	}

	@Override
	public void setMaxPlayers(int max)
	{
		this.maxPlayers = max;
	}

	@Override
	public void setMinPlayers(int min)
	{
		this.minPlayers = min;
	}

	@Override
	public boolean start(ArenaStartReason reason)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stop(ArenaStopReason reason)
	{
		if( getStatus() == ArenaStatus.INGAME )
		{
			ArenaStopEvent stopEvent = new ArenaStopEvent( this, reason );
			
			Bukkit.getServer().getPluginManager().callEvent( stopEvent );
			
			if( !stopEvent.isCancelled() )
			{
				status = ArenaStatus.RESETTING;
				
				reward();
				
				for( Player p : ingamePlayers )
				{
					leavePlayer( p, ArenaLeaveReason.ENDGAME );
				}
				
				status = ArenaStatus.LOBBY;
				
				return true;
			}
		}
		
		return false;
	}
	
	public void reward() {}

	@Override
	public boolean joinPlayer(Player p, ArenaJoinReason reason)
	{
		if( !BukkitUtilsMinigame.isInArena( p ) )
		{
			ArenaJoinEvent joinEvent = new ArenaJoinEvent( p, this, reason );
		
			Bukkit.getServer().getPluginManager().callEvent( joinEvent );
			
			if( !joinEvent.isCancelled() )
			{
				inventories.put( p.getUniqueId(), new InventoryData( p ) );
				return true;
			}
		}
		return false;
		
	}

	@Override
	public boolean leavePlayer(Player p, ArenaLeaveReason reason)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArenaStatus getStatus()
	{
		return status;
	}

	@Override
	public ArrayList< Player > getIngamePlayers()
	{
		return ingamePlayers;
	}
	
	public InventoryData getInventoryData( UUID uuid )
	{
		return inventories.get( uuid );
	}
	
	public InventoryData getInventoryData( Player p )
	{
		return inventories.get( p.getUniqueId() );
	}

}
