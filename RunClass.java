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
	
	private static void secondLoop() throws InvalidFormatException
	{
		Scanner in = new Scanner(System.in);
		int lContinue = CONTINUE;
		while (lContinue == CONTINUE)
		{
			System.out.println("Input alphabet: ");
			String nAlpha = in.nextLine().toLowerCase();
			Alphabet alphabet = new Alphabet(nAlpha);
			System.out.println("Input keyphrase: ");
			String nKey = in.nextLine().toLowerCase();
			try
			{
				Cipher cipher = new Cipher(nKey, nAlpha);
				System.out.println("Input message: ");
				String nMsg = in.nextLine().toLowerCase();
				int validInput = CONTINUE;
				boolean encrypt = false;
				while (validInput == CONTINUE)
				{
					System.out.println("Encrypted? ");
					String isEncrypt = in.nextLine().toLowerCase();
					if(isEncrypt.equals("y"))
					{
						encrypt = true;
						validInput = STOP;
					}
					else if(isEncrypt.equals("n"))
					{
						validInput = STOP;
					}
					else
					{
						System.out.println("Invalid input.");
					}
				}
				Message message = new Message(encrypt, nMsg);
				thirdLoop(message);
			}
			catch (InvalidFormatException e)
			{
				if (e.getMessage().equals("Message"))
				{
					System.out.println("Characters not in alphabet.");
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
