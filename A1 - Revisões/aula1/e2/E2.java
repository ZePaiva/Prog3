package aula1.e2;

import java.util.*;
import static java.lang.System.*;

public class E2 
{
	
	static final Scanner k = new Scanner(in);
	static Lista lista = new Lista(9);
	
	public static void main(String[] args) 
	{
		int x = -1;
		
		do 
		{
			menu();
			try 
			{
				x = Integer.parseInt(k.nextLine());
			} 
			catch (NumberFormatException e)
			{
				out.printf("Não é uma opção válida, tente outra vez.\n");
			}
			finally
			{
				switch(x)
				{
					case 0:
						out.printf("Adeus\n");
						break;
					case 1:
						lista.addP();
						break;
					case 2:
						lista.delP();
						break;
					case 3:
						lista.print();
						break;
					case 4:
						lista.sortCC();
						break;
					case 5:
						lista.sortN();
						break;
					default:
						break;	
				}
			}
		}while (x != 0);
	}
	
	public static void menu()
	{
		int size = lista.getListSize();
		out.print("\n\n\n");
		out.printf("|+++++++++++++++++++++++++++++++++++++++++++++++++|\n");
		out.printf("|                         Menu                    |\n");
		out.printf("|+++++++++++++++++++++++++++++++++++++++++++++++++|\n");
		out.printf("|+++++++++++++++++++++++++++++++++++++++++++++++++|\n");
		out.printf("|    1   -> Adicionar pessoa à lista (%d pessoas)  |\n", size);
		out.printf("|+++++++++++++++++++++++++++++++++++++++++++++++++|\n");
		out.printf("|    2   -> Retirar pessoa à lista (%d pessoas)    |\n", size);
		out.printf("|+++++++++++++++++++++++++++++++++++++++++++++++++|\n");
		out.printf("|    3   -> Mostrar a lista de pessoas            |\n");
		out.printf("|+++++++++++++++++++++++++++++++++++++++++++++++++|\n");
		out.printf("|    4   -> Organizar por número de CC            |\n");
		out.printf("|+++++++++++++++++++++++++++++++++++++++++++++++++|\n");
		out.printf("|    5   -> Organizar pelo nome                   |\n");
		out.printf("|+++++++++++++++++++++++++++++++++++++++++++++++++|\n");
		out.printf("|    0   -> Sair do programa                      |\n");
		out.printf("|+++++++++++++++++++++++++++++++++++++++++++++++++|\n");
		out.printf("\n\nOpção: ");
	}
}