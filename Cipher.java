import java.util.HashMap;

public class Cipher
{
	private Key key;
	private Alphabet alphabet;
	private String cipher;
	private String nKey;
	private String nAlpha;
	
	public Cipher(String nKey, String nAlpha)
	{
		nKey = key.toString();
		nAlpha = alphabet.toStringAlpha();
	}
	
	public void setCipher()
	{
		cipher = nKey + nAlpha;
		this.removeDuplicatesCipher();
	}
	
	private String removeDuplicatesCipher()
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
	}
}
