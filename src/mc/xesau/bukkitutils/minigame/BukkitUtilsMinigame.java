package mc.xesau.bukkitutils.minigame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.annotation.Nonnull;

import mc.xesau.bukkitutils.BukkitUtils;
import mc.xesau.bukkitutils.LocationUtils;
import mc.xesau.bukkitutils.minigame.arena.Arena;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaLeaveReason;
import mc.xesau.bukkitutils.minigame.sign.ArenaSign;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitUtilsMinigame extends JavaPlugin {

	public static HashMap< UUID, Arena > playerArenas = new HashMap< UUID, Arena >();
	public static ArrayList< ArenaSign > signs = new ArrayList< ArenaSign >();
	
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
	
	public static void updateSigns()
	{
		for( ArenaSign s : signs )
		{
			s.update();
		}
	}
	
	public void updateSigns( Arena a )
	{
		for( ArenaSign s : signs )
		{
			if( s.getArena().equals( a ) ) 
			{
				s.update();
			}
		}
	}
	
	public void updateSigns( Plugin p )
	{
		for( ArenaSign s : signs )
		{
			if( s.getPlugin().equals( p ) )
			{
				s.update();
			}
		}
	}

	public static boolean hasSign( Location location )
	{
		for( ArenaSign s : signs )
		{
			if( LocationUtils.isSame( s.getLocation(), location ) )
				return true;
		}
		
		return false;
	}

	public static ArenaSign getSign( Location location ) {
		for( ArenaSign s : signs )
			if( LocationUtils.isSame( s.getLocation(), location ) )
				return s;
		return null;
	}
	
}
