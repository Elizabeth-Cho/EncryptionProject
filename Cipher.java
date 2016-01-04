import java.awt.RenderingHints.Key;
import java.util.HashMap;

public class Cipher
{
	private Key key;
	private Alphabet alpha;
	private String cipher;
	
	public Cipher(String nKey, String nAlpha)
	{
		nKey = key.toString();
		nAlpha = alpha.toStringAlpha();
		cipher = nKey + nAlpha;
	}
	private String removeDuplicatesCipher() throws InvalidFormatException
	{
		HashMap<Character, Integer> mapping = new HashMap<Character, Integer>();
		int i = 0;
		for(i = 0; i < cipher.length(); i++)
		{
			mapping.put(Character.valueOf(Character.valueOf(cipher.charAt(i))), Integer.valueOf(0));
		}
		for (i = 0; i < cipher.length(); i++)
		{
			if (!mapping.containsKey(Character.valueOf(cipher.charAt(i))))
			{
				throw new InvalidFormatException;
			}
			else
			{
				int intConversion = mapping.get(Character.valueOf(cipher.charAt(i)));
				intConversion++;
				Integer newValue = Integer.valueOf(intConversion);
				mapping.put(Character.valueOf(cipher.charAt(i)), newValue);
			}
		}
		for (i = 0; i < cipher.length(); i++)
		{
			if (mapping.get(Character.valueOf(cipher.charAt(i))) > 1)
			{
				int intConversion = mapping.get(Character.valueOf(cipher.charAt(i)));
				intConversion--;
				Integer newValue = Integer.valueOf(intConversion);
				mapping.put(Character.valueOf(cipher.charAt(i)), newValue);
				cipher = cipher.substring(0, i) + cipher.substring(i+1);
			}
		}
		
		return cipher;
	}
	
	public String encrypt()
	{
		
	}
	
	public String decrypt()
	{
		
	}
}
