import java.util.HashMap;

public class Key
{
	private String keyphrase;
	private Alphabet alphabet;
	
	public Key(String nKeyphrase, Alphabet nAlphabet) throws InvalidFormatException
	{
		try
		{
			keyphrase = this.removeDuplicates(nKeyphrase);
			alphabet = nAlphabet;
		}
		catch (InvalidFormatException e)
		{
			throw new InvalidFormatException("Character not in alphabet");
		}
	}
	
	public String toString()
	{
		return this.keyphrase;
	}
	
	public Alphabet getAlphabet()
	{
		return this.alphabet;
	}
	
	public void setAlphabet(Alphabet nAlpha)
	{
		this.alphabet = nAlpha;
	}
	
	public String stringAlpha()
	{
		return this.alphabet.toString();
	}
	
	public void setKey(String nKeyphrase) throws InvalidFormatException
	{
		try
		{
			this.removeDuplicates(nKeyphrase);
		}
		catch (InvalidFormatException e)
		{
			throw new InvalidFormatException("Character not in alphabet");
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
				throw new InvalidFormatException("Character not in alphabet");
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
	
}
