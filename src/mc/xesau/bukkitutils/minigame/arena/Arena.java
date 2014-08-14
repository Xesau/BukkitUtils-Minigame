package mc.xesau.bukkitutils.minigame.arena;

import java.util.ArrayList;

import javax.annotation.Nonnull;

import mc.xesau.bukkitutils.minigame.eventreason.ArenaJoinReason;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaLeaveReason;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaStartReason;
import mc.xesau.bukkitutils.minigame.eventreason.ArenaStopReason;

import org.bukkit.entity.Player;

public interface Arena {

	public String getName();
	public ArenaRegion getRegion();
	
	public int getMaxPlayers();
	public int getMinPlayers();
	
	public void setMaxPlayers( @Nonnull int max );
	public void setMinPlayers( @Nonnull int min );
	
	public boolean start( @Nonnull ArenaStartReason reason );
	public boolean stop( @Nonnull ArenaStopReason reason );
	
	public boolean joinPlayer( @Nonnull Player p, @Nonnull ArenaJoinReason reason );
	public boolean leavePlayer( @Nonnull Player p, @Nonnull ArenaLeaveReason reason );
	
	public ArenaStatus getStatus();
	
	public ArrayList< Player > getIngamePlayers();
	
}
