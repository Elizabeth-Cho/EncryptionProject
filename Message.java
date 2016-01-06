
public class Message
{
	private boolean encrypt;
	private String eMsg;
	private String dMsg;
	private Cipher cipher;
	
	public Message (boolean isEncrypt, String nMsg) throws InvalidFormatException
	{
		encrypt = isEncrypt;
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
		if (this.encrypt)
		{
			return eMsg;
		}
		else
		{
			return dMsg;
		}
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
	                nMsg = nMsg + this.cipher.getConversion(this.getMessage().charAt(i), this.encrypt);
	            }
	        }
	        }
	    catch (InvalidFormatException e)
	    {
	        throw new InvalidFormatException("Message");
	    }
	    if (encrypt)
	    {
	    	this.dMsg = nMsg;
	    }
	    else
	    {
	    	this.eMsg = nMsg;
	    }
	}
}
