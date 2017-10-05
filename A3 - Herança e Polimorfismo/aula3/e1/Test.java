package aula3.e1;

import aula1.e2.*;

public class Test
{
	
	public Test()
	{
		Estudante est = new Estudante("Andreia", 9855678, new Data(18, 7, 1974));
		Bolseiro bls = new Bolseiro("Maria", 8976543, new Data(11, 5, 1976));
		bls.setBolsa(745);
	
		System.out.println("Estudante: " + est.getName());
		System.out.println(est);
		System.out.println("Bolseiro: " + bls.getName() + ", NMec: " + bls. nMec()	+ ", Bolsa:" + bls.bolsa());
		System.out.println(bls);
		 
	}
}