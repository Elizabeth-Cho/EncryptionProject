import java.util.Scanner;

public final class RunClass
{
	private static final int EXIT = 0;
	private static final int STOP = -1;
	private static final int CONTINUE = 1;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int lContinue = CONTINUE;
		while (lContinue == 1)
		{
			System.out.println("Press 1 to start.");
			System.out.println("Press 2 to exit");
			String input = in.nextLine();
			if (input.equals("1"))
			{
				secondLoop();
			}
			else if (input.equals("2"))
			{
				System.exit(EXIT);
			}
			else
			{
				System.out.println("Invalid choice.");
			}
		}
	}
	
	private static void secondLoop()
	{
		Scanner in = new Scanner(System.in);
		int lContinue = CONTINUE;
		while (lContinue == CONTINUE)
		{
			System.out.println("Enter the alphabet. ");
			String nAlpha = in.nextLine().toLowerCase();
			Alphabet alpha = new Alphabet(nAlpha);
			System.out.println("Enter the key." );
			String nKey = in.nextLine().toLowerCase();
			try
			{
				Key key = new Key(nKey, alpha);
				Cipher cipher = new Cipher(key);
				System.out.println("Enter the message.");
				String nMsg = in.nextLine().toLowerCase();
				int checkValidInput = CONTINUE;
				boolean encrypted = false;
				while (checkValidInput == CONTINUE)
				{
					System.out.println("Is the message encrypted?");
					String nEncrypt = in.nextLine().toLowerCase();
					if (nEncrypt.equals("y"))
					{
						encrypted = true;
						checkValidInput = STOP;
					}
					else if (nEncrypt.equals("n"))
					{
						checkValidInput = STOP;
					}
					else
					{
						System.out.println("Enter Y or N.");
					}
				}
				Message message = new Message(encrypted, nMsg);
				thirdLoop(message);
			}
			catch (InvalidFormatException e)
			{
				System.out.println(e.getMessage());
				if (e.getMessage().equals("Character not in alphabet"))
				{
					System.out.println("Message contains characters not in alphabet.");
				}
				else
				{
					System.out.println("Key contains characters not in alphabet");
				}
			}
			lContinue = STOP;
		}
	}
	
	private static void thirdLoop(Message nMsg)
	{
		Scanner in = new Scanner(System.in);
		int lContinue = CONTINUE;
		while (lContinue == CONTINUE)
		{
			System.out.println("Press 1 for encrypted message.");
			System.out.println("Press 2 for decrypted message.");
			System.out.println("Press 3 to exit.");
			String nChoice = in.nextLine();
			if (nChoice.equals("1"))
			{
				System.out.println("Encrypted message: " + nMsg.getMessage());
			}
			else if(nChoice.equals("2"))
			{
				System.out.println("Decrypted message: " + nMsg.getMessage());
			}
			else if (nChoice.equals("3"))
			{
				return;
			}
			else
			{
				System.out.println("Invalid input.");
			}
		}
	}
}
