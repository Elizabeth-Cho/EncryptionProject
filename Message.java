
public class Message implements MessageInterface
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
		this.encryptDecrypt();
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
	
	public void setEncrypt(boolean isEncrypt)
	{
		encrypt = isEncrypt;
	}
	
	public void encryptDecrypt() throws InvalidFormatException
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
	                System.out.println(this.getMessage().charAt(i));
	                System.out.println(this.encrypt);
	                System.out.println(this.cipher.getConversion(this.getMessage().charAt(i), this.encrypt));
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
