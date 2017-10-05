package aula3.e3;

import aula1.e2.*;

public class TesteE3
{

	public static void main(String[] args) throws IllegalAccessException
	{
		try
		{
			Pessoa p1 = new Pessoa("c1", 1, new Data(1, 1, 1));
			Condutor c1 = new Condutor("A", "c1", 1, new Data(1, 1, 1));
			Condutor c2 = new Condutor("B", "c2", 1, new Data(1, 1, 1));
			Condutor c3 = new Condutor("C", "c3", 1, new Data(1, 1, 1));
			Condutor c4 = new Condutor("D", "c4", 1, new Data(1, 1, 1));
			Condutor c5 = new Condutor("A", p1);
			Condutor c6 = new Condutor(c2);
			Condutor c7 = null;
			
			System.out.println("\nTestes dos condutores:");
			System.out.println("c1 equals to p1? -> " + c1.equals(p1)); // False
			System.out.println("c1 equals to c3? -> " + c1.equals(c3)); // False
			System.out.println("c1 equals to c7? -> " + c1.equals(c7)); // False
			System.out.println("c1 equals to c5? -> " + c1.equals(c5)); // True
			System.out.println("c2 equals to c6? -> " + c2.equals(c6)); // True
			
			Motociclo v1 = new Motociclo("A", 22, 1, 1, 1);
			Motociclo v2 = new Motociclo(v1);
			Ligeiro l1 = new Ligeiro("B", 22, 1, 1, 1);
			Ligeiro l2 = new Ligeiro("B", 22, 1, 1, 2);
			PesadoMercadorias pm = new PesadoMercadorias("C", 22, 1, 1, 1);
			PesadoPassageiros pp = new PesadoPassageiros("D", 22, 1, 1, 1);
			
			System.out.println("\nTestes dos veiculos:");
			System.out.println("v1 equals to v2? -> " + v1.equals(v2)); // True
			System.out.println("l1 equals to l2? -> " + l1.equals(l2)); // False
			System.out.println("pp equals to pm? -> " + pp.equals(pm)); // False
			
			System.out.println("\nTestes dos condutores e veiculos:");
			System.out.println("c1 can drive v1? -> " + v2.canDrive(c1)); // True
			System.out.println("c1 can drive l2? -> " + l2.canDrive(c1)); // False
			System.out.println("c4 can drive pp? -> " + pp.canDrive(c4)); // True
			System.out.println("c4 can drive pm? -> " + pm.canDrive(c4)); // True
			System.out.println("c3 can drive l2? -> " + l2.canDrive(c1)); // False
		}
		catch (IllegalAccessException e)
		{
			System.out.println("Não pode conduzir.");
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Carta inválida.");
		}
	}
}
