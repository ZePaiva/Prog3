package aula1;

import static java.lang.System.*;
import java.util.*;

public class E1 
{
	public static void main(String args[]) 
	{
		String inpt;
		String S = "";
		Scanner k = new Scanner(in);
		out.print("Word: ");
		inpt = k.nextLine();
		char tmp = ' ';
		
		for(int i = 0; i < inpt.length(); i++)
		{
			if(i % 2 == 0)
			{
				tmp = inpt.charAt(i);
			}
			else
			{
				S += Character.toString(inpt.charAt(i))+Character.toString(tmp);
				tmp = ' ';
			}
		}
		if(tmp != ' ')
		{
			S += tmp;
		}
		
		out.printf("swapped: %s\n", S);
	}
}