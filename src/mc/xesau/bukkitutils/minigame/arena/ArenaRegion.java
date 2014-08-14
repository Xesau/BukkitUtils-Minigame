package mc.xesau.bukkitutils.minigame.arena;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class ArenaRegion {

	private Location point1;
	private Location point2;
	
	/**
	 * Constructor for MapRegion
	 * 
	 * @param point1 the first point of the region
	 * @param point2 the second point of the region
	 * @throws IllegalArgumentException when the points aren't in the same world
	 */
	public ArenaRegion( String world, double x1, double y1, double z1, double x2, double y2, double z2)
	{
		
		point1 = new Location( Bukkit.getServer().getWorld( world ), Math.max(x1, x2), Math.max(y1, y2), Math.max(z1, z2) );
		point2 = new Location( Bukkit.getServer().getWorld( world ), Math.min(x1, x2), Math.min(y1, y2), Math.min(z1, z2) );
	}
	
	/**
	 * Check if the location is inside the region
	 * 
	 * @param check the location
	 * @return whether the Location is in the region
	 */
	public boolean isInside( Location check )
	{
		if( check.getX() >= point1.getX() &&
			check.getX() <= point2.getX() &&
			
			check.getY() >= point1.getY() &&
			check.getY() <= point2.getY() &&
			
			check.getZ() >= point1.getZ() &&
			check.getZ() <= point2.getZ() &&
			
			check.getWorld().getName() == point1.getWorld().getName() )
			return true;
		return false;
	}
	
	/**
	 * Get the first point of the region
	 * 
	 * @return the first point
	 */
	public Location getFirstPoint()
	{
		return point1;
	}
	
	/**
	 * Get the second point of the region
	 * @return the second point
	 */
	public Location getSecondPoint()
	{
		return point2;
	}
	
	/**
	 * Set the first point of the region
	 * 
	 * @param firstPoint the first point
	 */
	public void setFirstPoint( Location firstPoint )
	{
		this.point1 = firstPoint;
	}
	
	/**
	 * Set the second point of the region
	 * 
	 * @param secondPoint the second point
	 */
	public void setSecondPoint( Location secondPoint )
	{
		this.point2 = secondPoint;
	}
	
}
