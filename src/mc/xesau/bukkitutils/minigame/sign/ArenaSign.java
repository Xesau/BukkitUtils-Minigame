package mc.xesau.bukkitutils.minigame.sign;

import org.bukkit.Location;
import org.bukkit.block.Sign;

public interface ArenaSign {

	public Location getLocation();
	public Sign getSign();
	public SignFormat getSignFormat();
	
	public void setSign( Sign block );
	public void update();
	
}
