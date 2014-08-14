package mc.xesau.bukkitutils.minigame.sign;

import mc.xesau.bukkitutils.minigame.arena.Arena;

import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public interface ArenaSign {

	public Location getLocation();
	public Sign getSign();
	
	public SignFormat getSignFormat();
	public void setSignFormat( SignFormat format );
	
	public void update();
	
	public void onClick( Player p );
	public void onCreate( Player p, Sign s );
	
	public Arena getArena();
	public Plugin getPlugin();
	
}
