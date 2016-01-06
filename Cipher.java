import java.util.HashMap;

public class Cipher implements CipherInterface
{
	private KeyInterface key;
	private HashMap <Character, Character> dCipher;
	private HashMap <Character, Character> eCipher;
	
	public Cipher(KeyInterface nKey) throws InvalidFormatException
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
			throw new InvalidFormatException("Cipher1");
		}
	}
	
	
	public void setCipher() throws InvalidFormatException
	{
		try
		{
			for (int i = 0; i < this.getKeyCipher().length(); i++)
			{
				this.eCipher.put(Character.valueOf((this.getAlphabetString().charAt(i))),
						Character.valueOf(this.getKeyCipher().charAt(i)));
	            this.dCipher.put(Character.valueOf(this.getKeyCipher().charAt(i)),
	                    Character.valueOf(this.getAlphabetString().charAt(i)));
	        }
		}
		catch (InvalidFormatException e)
		{
			throw new InvalidFormatException("Cipher2");
		}
	}
	
	private String getKeyCipher() throws InvalidFormatException
	{
		Key kCipher = new Key(this.getKeyString() + this.getAlpha(), this.getAlphabet());
		return kCipher.toString();
	}
	
	public void test()
	{
		this.getAlpha();
	}
	
	private String getAlpha()
	{
		return this.key.getAlphabet().toStringAlpha();
	}
	private String getKeyString()
	{
        return this.key.getString();
    }
	
	private String getAlphabetString()
	{
        return this.getAlphabet().toString();
    }
	
	private AlphabetInterface getAlphabet()
	{
		return this.key.getAlphabet();
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
			throw new InvalidFormatException("Cipher3");
		}
	}
}
