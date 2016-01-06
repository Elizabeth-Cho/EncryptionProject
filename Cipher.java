import java.util.HashMap;

public class Cipher
{
	private Key key;
	private Alphabet alphabet;
	private HashMap <Character, Character> dCipher;
	private HashMap <Character, Character> eCipher;
	
	public Cipher(Key nKey) throws InvalidFormatException
	{
		key = nKey;
		dCipher = new HashMap <Character, Character>();
		eCipher = new HashMap <Character, Character>();
		try
		{
			this.setCipher();
		}
		catch (InvalidFormatException e)
		{
			throw new InvalidFormatException("Cipher");
		}
	}
	
	
	public void setCipher() throws InvalidFormatException
	{
		try
		{
			for (int i = 0; i < this.getKeyCipher().length(); i++)
			{
				this.eCipher.put(Character.valueOf((alphabet.toStringAlpha().charAt(i))),
						Character.valueOf(this.getKeyCipher().charAt(i)));
	            this.dCipher.put(Character.valueOf(this.getKeyCipher().charAt(i)),
	                    Character.valueOf(alphabet.toStringAlpha().charAt(i)));
	        }
		}
		catch (InvalidFormatException e)
		{
			throw new InvalidFormatException("Cipher");
		}
	}
	
	private String getKeyCipher() throws InvalidFormatException
	{
		Key kCipher = new Key(this.getKeyString() + this.getAlpha(), alphabet);
		return kCipher.toString();
	}
	
	private String getAlpha()
	{
		return this.key.getAlphabet().toString();
	}
	private String getKeyString()
	{
        return this.key.getString();
    }
	
	private String getAlphabetString()
	{
        return alphabet.getAlphabet().toString();
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
			throw new InvalidFormatException("Cipher");
		}
	}
}
