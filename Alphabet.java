import java.util.HashMap;

public class Alphabet
{
	private String alphabet;
	
	public Alphabet(String nAlphabet)
	{
		this.alphabet = nAlphabet;
		this.removeDuplicatesAlphabet();
	}
	
	private void removeDuplicatesAlphabet()
	{
		HashMap<Character, Integer> mapping = new HashMap<Character, Integer>();
		int i = 0;
		while (i < this.alphabet.length())
		{
			if(!mapping.containsKey(Character.valueOf(alphabet.charAt(i))))
			{
				mapping.put(Character.valueOf(this.alphabet.charAt(i)), Integer.valueOf(0));
				i++;
			}
			else
			{
				this.alphabet = this.alphabet.substring(0, i) + this.alphabet.substring(i + 1);
			}
		}
	}
	
	public String toStringAlpha()
	{
		return this.alphabet.toString();
	}
}
