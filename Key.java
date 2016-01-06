import java.util.HashMap;

public class Key
{
	private String key;
	private Alphabet alpha;
	
	public Key(String nKeyphrase, Alphabet nAlphabet) throws InvalidFormatException
	{
		try
		{
			alpha = nAlphabet;
			key = this.removeDuplicates(nKeyphrase);
		}
		catch (InvalidFormatException e)
		{
			throw new InvalidFormatException("Key");
		}
	}
	
	public String getString()
	{
		return this.key;
	}
	
	public Alphabet getAlphabet()
	{
		return this.alpha;
	}
	
	public void setAlphabet(Alphabet nAlpha)
	{
		this.alpha = nAlpha;
	}
	
	public void setKey(String nKeyphrase) throws InvalidFormatException
	{
		try
		{
			this.removeDuplicates(nKeyphrase);
		}
		catch (InvalidFormatException e)
		{
			throw new InvalidFormatException("Key");
		}
				
	}
	public String removeDuplicates(String s) throws InvalidFormatException
	{
		HashMap<Character, Integer> mapping = new HashMap<Character, Integer>();
		for (int i = 0; i < stringAlpha().length(); i++)
		{
			mapping.put(Character.valueOf(stringAlpha().charAt(i)), Integer.valueOf(0));
		}
		for (int i = s.length() - 1; i >= 0; i--)
		{
			if (!mapping.containsKey(Character.valueOf(s.charAt(i))))
			{
				throw new InvalidFormatException("Key");
			}
			else
			{
				int intConversion = mapping.get(Character.valueOf(s.charAt(i))).intValue();
				intConversion++;
				Integer newValue = Integer.valueOf(intConversion);
				mapping.put(Character.valueOf(s.charAt(i)), newValue);
			}
		}
		for (int i = s.length() - 1; i >= 0; i--)
		{
			if (mapping.get(Character.valueOf(s.charAt(i))).intValue() > 1)
			{
				int intConversion = mapping.get(Character.valueOf(s.charAt(i))).intValue();
				intConversion--;
				Integer newValue = Integer.valueOf(intConversion);
				mapping.put(Character.valueOf(s.charAt(i)), newValue);
				s = s.substring(0, i) + s.substring(i + 1);
			}
		}
		return s;
	}
	
	public String stringAlpha()
	{
		return alpha.toStringAlpha();
	}
	
	
}
