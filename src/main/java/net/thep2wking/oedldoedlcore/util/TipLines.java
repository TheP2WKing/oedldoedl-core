package net.thep2wking.oedldoedlcore.util;

public enum TipLines
{
	DISABLED(0),
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5);
	
	public int lines;

	private TipLines(int lines) 
	{
		this.lines = lines;
	}
}