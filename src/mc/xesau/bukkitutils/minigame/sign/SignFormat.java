package mc.xesau.bukkitutils.minigame.sign;

import javax.annotation.Nonnull;

public class SignFormat {

	private String line1;
	private String line2;
	private String line3;
	private String line4;
	
	public void setLine( @Nonnull int index, @Nonnull String text )
	{
		if( index == 1 )
			line1 = text;
		
		else if( index == 2 )
			line2 = text;
		
		else if( index == 3 )
			line3 = text;
		
		else if( index == 4 )
			line4 = text;
				
	}
	
	public String getLine( @Nonnull int index )
	{
		if( index == 1 )
			return line1;

		else if( index == 2 )
			return line2;
		
		else if( index == 3 )
			return line3;
		
		else if( index == 4 )
			return line4;
		
		return null;
	}
}
