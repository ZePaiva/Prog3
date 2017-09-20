package aula1.e3;

import static java.lang.System.*;

public class E3 
{
	public static void main(String[] args) 
	{
		Circulo circus[] = new Circulo[5];
		Quadrado quads = new Quadrado(4, new Ponto(2, 3));
		Retangulo ret = new Retangulo(10, 12, new Ponto(0, 0));
		
		circus[0] = new Circulo(10, new Ponto(1,1));
		circus[1] = new Circulo(10);
		circus[2] = new Circulo(5, 5);
		circus[3] = new Circulo();
		circus[4] = new Circulo(10, 12, 11);
		
		out.println(quads.getArea());
		out.println(quads.getSize());
		out.println(ret.getArea());
		out.println(ret.getSize());
		out.println();
		
		for (int i = 0; i < 5; i++)
		{
			out.printf("Circulo #%d:\n", i+1);
			out.println(circus[i].getArea());
			out.println(circus[i].getSize());
			out.println(circus[i].getCentre().toString());
			out.println(circus[i].getRay());
			out.println(circus[i].interception(circus[3]));
			out.println(circus[i].equals(circus[1]));
			out.println(circus[i].toString());
		}	
	}
}