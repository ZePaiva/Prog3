package aula1.e2;

import java.util.*;
import static java.lang.System.*;

public class Lista 
{
	private int size = 0;
	private static final Scanner k = new Scanner(in);
	private Pessoa lista[];
		
	public Lista(int size)
	{
		lista = new Pessoa[size];
	}
	
	public int getListSize() 
	{
		return size;
	}

	public void addP()
	{
		if (size >= 9)
		{
			out.printf("Não consegue adicionar mais ninguém à lista, por favor remova alguém antes de adicionar.\n");
			return;
		}
		try
		{
			out.print("Nome:");
			String nome = k.nextLine();
			out.print("CC: ");
			String c = k.nextLine();
			int cc = Integer.parseInt(c); 
			out.print("Data (dd/mm/yyyy): ");
			String data = k.nextLine();
			String date[] = data.split("/");
			int dat[] = new int[3];
			for	(int i = 0; i < 3; i++)
			{
				dat[i] = Integer.parseInt(date[i]);
			}
			lista[size] = new Pessoa(nome, cc, new Data(dat[0], dat[1], dat[2]));
			out.printf("Pessoa adicionada com sucesso.\n");
			size++;
		}
		catch (NumberFormatException e)
		{
			out.printf("Colocadas letras onde deviam de estar números");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			out.printf("Data inválida");
		}
		catch (RuntimeException e)
		{
			out.printf("Data inválida");
		}
	}

	public void delP()
	{
		out.print("Nome da pessoa a retirar: ");
		String nome = k.nextLine();
		int address = search(nome);
		
		if (address != -1)
		{
			lista[address] = null;
			while (address < lista.length-1)
			{
				lista[address] = lista[address+1];
				address++;
			}
			size--;
			out.printf("Pessoa removida com sucesso.\n");
		}
		else
		{
			out.print("A pessoa que procura não existe.\n");
		}
	}
	
	public int search(String nome)
	{
		for (int i = 0; i < size; i++)
		{
			if ((lista[i].getName()).equals(nome))
			{
				return i;
			}
		}
		
		return -1;
	}

	public void print()
	{
		out.printf("Lista das pessoas:\n\n");
		for (int i = 0; i < size; i++)
		{
			out.printf("#%d : %s\n", i+1, lista[i].toString());
		}
	}
	
	public void sortN()
	{
		boolean trade = false;
		Pessoa tmp;
		do
		{
			trade = false;
			for (int i = 0; i < size-1; i++)
			{
				if(lista[i].CompareToNome(lista[i+1]) > 0)
				{
					tmp = lista[i];
					lista[i] = lista[i+1];
					lista[i+1] = tmp;
					trade = true;
				}
			}
		} while (trade);
	}
	
	public void sortCC()
	{
		boolean trade = false;
		Pessoa tmp;
		do
		{
			trade = false;
			for (int i = 0; i < size-1; i++)
			{
				if(lista[i].CompareToCC(lista[i+1]) < 0)
				{
					tmp = lista[i];
					lista[i] = lista[i+1];
					lista[i+1] = tmp;
					trade = true;
				}
			}
		} while (trade);
	}
}