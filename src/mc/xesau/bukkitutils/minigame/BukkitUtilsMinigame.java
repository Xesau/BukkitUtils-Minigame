package mc.xesau.bukkitutils.minigame;

import java.util.HashMap;
import java.util.UUID;

import javax.annotation.Nonnull;

import mc.xesau.bukkitutils.BukkitUtils;
import mc.xesau.bukkitutils.minigame.arena.Arena;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaLeaveReason;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitUtilsMinigame extends JavaPlugin {

	public static HashMap< UUID, Arena > playerArenas = new HashMap< UUID, Arena >();
	
	public void onEnable()
	{
		BukkitUtils.hook( this );
	}
	
	public static void setPlayerArena( @Nonnull Player p, Arena a )
	{
		if( a != null )
		{
			playerArenas.put( p.getUniqueId(), a );
		}
		else
		{
			playerArenas.remove( p.getUniqueId() );
		}
	}
	
	public static Arena getPlayerArena( @Nonnull Player p )
	{
		if( playerArenas.containsKey( p.getUniqueId() ) )
			return playerArenas.get( p.getUniqueId() );
		
		return null;
	}
	
	public static boolean isInArena( @Nonnull Player p )
	{
		return playerArenas.containsKey( p.getUniqueId() );
	}

	public static void leaveArena( @Nonnull Player p, @Nonnull ArenaLeaveReason reason ) {
		if( isInArena( p ) )
			getPlayerArena( p ).leavePlayer( p, reason );
	}
	
}
