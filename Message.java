
public class Message
{
	private boolean encrypt;
	private String message;
	private String eMsg;
	private String dMsg;
	
	public Message (boolean isEncrypt, String nMsg) throws InvalidFormatException
	{
		encrypt = isEncrypt;
		message = nMsg;
		if (this.encrypt)
		{
			eMsg = nMsg;
		}
		else
		{
			dMsg = nMsg;
		}
	}
	public boolean getEncrypt()
	{
		return encrypt;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	private void encryptDecrypt() throws InvalidFormatException
	{
	    String nMsg = "";
	    try {
	        for (int i = 0; i < this.getMessage().length(); i++)
	        {
	            if (String.valueOf(this.getMessage().charAt(i)).equals(" "))
	            {
	                nMsg = nMsg + " ";
	            }
	            else
	            {
	                nMsg = this.cipher.getConversion(this.getMessage().charAt(i), this.isEncrypted);
	            }
	        }
	        }
	    catch (InvalidFormatException e)
	    {
	        throw new InvalidFormatException("Character not in alphabet");
	    }
	}
}
