package aula9.e3;

import java.util.*;
import aula1.e2.*;

public class TesteIterador
{
	public static void main(String[] args) 
	{
		VetorPessoas vp = new VetorPessoas();
		for (int i=0; i<10; i++)
			vp.addPessoa(new Pessoa("Bebe no Vector "+i,1000+i, Data.today()));
		
		Iterator vec = vp.iterator();
		while ( vec.hasNext() )
			System.out.println( vec.next() );
		
		ListaPessoas lp = new ListaPessoas();
		for (int i=0; i<10; i++)
			lp.addPessoa(new Pessoa("Bebe na Lista "+i,2000+i, Data.today()));
		
		Iterator lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
	}
}
