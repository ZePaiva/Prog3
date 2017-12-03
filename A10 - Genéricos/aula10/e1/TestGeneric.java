package aula10.e1;

import aula3.e2.*;
import aula1.e2.*;
import java.util.*;

public class TestGeneric
{
	public static void main(String[] args) 
	{
		VetorGeneric<Pessoa> vp = new VetorGeneric<Pessoa>();
		for (int i=0; i<10; i++)
			vp.addElem(new Pessoa("Bebé no Vector "+i,
					1000+i, Data.today()));
		
		Iterator<Pessoa> vec = vp.iterator();
		printSet(vp.iterator());
		
		ListGeneric<Pessoa> lp = new ListGeneric<Pessoa>();
		while ( vec.hasNext() )
			lp.addElem( vec.next() );
		
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		ListGeneric<Figura> figList = new ListGeneric<Figura>();
		figList.addElem(new Circulo (1,3, 1));
		figList.addElem(new Quadrado(3,4, 2));		
		figList.addElem(new Retangulo(1,2, 2,5));
		
		printSet(figList.iterator());
		
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));

		// Partindo do principio que Quadrado extends Rectangulo:
		ListGeneric<Retangulo> quadList = new ListGeneric<Retangulo>();
		quadList.addElem(new Quadrado(3,4, 2));
		quadList.addElem(new Retangulo(1,2, 2,5));
		System.out.println("Soma da Area de Lista de Quadrados: " +
		sumArea(quadList));


	}
	
	public static double sumArea(ListGeneric<? extends Figura> list)
	{
		double sum = 0;
		for (Figura fig : list)
		{
			sum += fig.area();
			System.out.println(fig);
		}
		
		return sum;
	}
	
	public static <T> void printSet(Iterator<T> iter)
	{
		while(iter.hasNext())
			System.out.println(iter.next());
	}
}
