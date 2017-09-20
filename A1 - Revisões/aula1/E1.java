package aula1;

import java.util.*;

import static java.lang.System.*;

public class E1 
{
	 public static void main(String args[]) 
     {
             String inpt;
             String S = "";
             Scanner k = new Scanner(in);
             out.print("String: ");
             inpt = k.nextLine();
             char tmp = ' ';
             
             digits(inpt);
             bigL(inpt);
             smallL(inpt);
             
             String words[] = inpt.split(" ");
             
             out.printf("A string tem %d %s.\n", words.length, words.length == 1 ? "palavra" : "palavras");
             out.printf("String lida: %s\n", inpt);
             
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
             
             k.close();
     }

	 public static void digits(String inpt)
	 {
		 int digs = 0;
		 for (int i = 0; i < inpt.length(); i++) 
		 {
			 if (Character.isDigit(inpt.charAt(i))) {
				digs++;
			 }
		 }
		 
		 if (digs >= 0)
			 out.printf("A string tem %d %s.\n", digs, digs == 1 ? "caracter numérico" : "caracteres numéricos");
		 else
			 out.printf("A string não tem caracteres numéricos.\n");
	 }

	 public static void bigL(String inpt)
	 {
		 boolean allBig = true;
		 for (int i = 0; i < inpt.length() && allBig; i++)
		 {
			 if(Character.isLowerCase(inpt.charAt(i)))
			 {
				 allBig = false;
			 }
		 }
		 
		 if (allBig) 
			 out.printf("A string tem apenas letras maiúsculas.\n");
		 else
			 out.printf("A string não tem apenas letras maiúsculas.\n");
	 }

	 public static void smallL(String inpt)
	 {
		 boolean allSmall = true;
		 for (int i = 0; i < inpt.length() && allSmall; i++)
		 {
			 if	(Character.isUpperCase(inpt.charAt(i)))
				 allSmall = false;
		 }
		 
		 if	(allSmall)
			 out.printf("A string é composta apena por letras minúsculas.\n");
		 else
			 out.printf("A string não é composta apenas por letras minúsculas.\n");
	 } 
}