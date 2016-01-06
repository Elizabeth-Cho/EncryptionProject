import java.util.HashMap;

public class Cipher
{
	private Key key;
	private Alphabet alphabet;
	private HashMap <Character, Character> dCipher;
	private HashMap <Character, Character> eCipher;
	
	public Cipher(Key nKey) throws InvalidFormatException
	{
		dCipher = new HashMap <Character, Character>();
		eCipher = new HashMap <Character, Character>();
		try
		{
			this.setCipher();
		}
		catch (InvalidFormatException e)
		{
			throw new InvalidFormatException("Characters not in alphabet");
		}
	}
	
	public void setCipher() throws InvalidFormatException
	{
		try
		{
			for (int i = 0; i < key.toString().length(); i++)
			{
				this.eCipher.put(Character.valueOf((alphabet.toStringAlpha().charAt(i))),
						Character.valueOf(this.getKeyCipher().charAt(i)));
	            this.dCipher.put(Character.valueOf(this.getKeyCipher().charAt(i)),
	                    Character.valueOf(alphabet.toStringAlpha().charAt(i)));
	        }
		}
		catch (InvalidFormatException e)
		{
			throw new InvalidFormatException("Characters not in alphabet");
		}
	}
	
	private String getKeyCipher() throws InvalidFormatException
	{
		Key kCipher = new Key(key.toString(), alphabet);
		return kCipher.toString();
	}
	
	public char getConversion(char c, boolean encrypt) throws InvalidFormatException
	{
		try
		{
			if (encrypt)
			{
				return this.eCipher.get(Character.valueOf(c));
			}
			else
			{
				return this.dCipher.get(Character.valueOf(c));
			}
		}
		catch (NullPointerException e)
		{
			throw new InvalidFormatException("Characters not in alphabet");
		}
	}
	/*private String removeDuplicatesCipher()
	{
		HashMap<Character, Integer> mapping = new HashMap<Character, Integer>();
		for (int i = 0; i < cipher.length(); i++)
		{
			mapping.put(Character.valueOf(cipher.charAt(i)), Integer.valueOf(0));
		}
		for (int i = 0; i < cipher.length(); i++)
		{
			int intConversion = mapping.get(Character.valueOf(cipher.charAt(i)));
			intConversion++;
			Integer newValue = Integer.valueOf(intConversion);
			mapping.put(Character.valueOf(cipher.charAt(i)), newValue);
		}
		for (int i = 0; i < cipher.length(); i++)
		{
			if (mapping.get(Character.valueOf(cipher.charAt(i))) > 1)
			{
				int intConversion = mapping.get(Character.valueOf(cipher.charAt(i))).intValue();
				intConversion--;
				Integer newValue = Integer.valueOf(intConversion);
				mapping.put(Character.valueOf(cipher.charAt(i)), newValue);
				cipher = cipher.substring(0, i) + cipher.substring(i + 1);
			}
		}
		return cipher;
	}*/
}
