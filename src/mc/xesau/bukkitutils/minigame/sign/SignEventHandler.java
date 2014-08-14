package mc.xesau.bukkitutils.minigame.sign;

import mc.xesau.bukkitutils.minigame.BukkitUtilsMinigame;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignEventHandler implements Listener {

	@EventHandler
	public void onPlayerClick( PlayerInteractEvent e )
	{
		if( e.getAction() == Action.RIGHT_CLICK_BLOCK )
		{
			if( e.getClickedBlock().getType() == Material.SIGN_POST ||
				e.getClickedBlock().getType() == Material.WALL_SIGN )
			{
				if( BukkitUtilsMinigame.hasSign( e.getClickedBlock().getLocation() ) )
				{
					
				}
			}
		}
	}
	
}
