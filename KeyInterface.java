public interface KeyInterface
{
	String getString();
	AlphabetInterface getAlphabet();
	void setAlphabet(Alphabet nAlpha);
	void setKey(String nKeyphrase) throws InvalidFormatException;
	String removeDuplicates(String s) throws InvalidFormatException;
}
