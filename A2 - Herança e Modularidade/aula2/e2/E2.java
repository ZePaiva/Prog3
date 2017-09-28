package aula2.e2;

import static java.lang.System.*;

public class E2 
{
	public static void main(String[] args) 
	{
		try
		{
			for (int i = 0; i < args.length; i++)
			{
				out.printf("Jogo 1 (%s):\n\n", args[i]);
				LetterSoup jogo = new LetterSoup(args[i]);
				jogo.jogar();
				jogo.fim();
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			out.println("No foram colocados argumentos.\n");
		}
	}
}