package aula1.e3;

public class Quadrado {
	private Ponto centro;
	private double lado;
	
	public Quadrado(double l, Ponto c)
	{
		lado = l;
		centro = c;
	}
	
	public Quadrado(double l)
	{
		this(l, new Ponto(0.0, 0.0));
	}
	
	public Quadrado()
	{
		this(1, new Ponto(0.0, 0.0));
	}
	
	public Quadrado(double l, double x, double y)
	{
		this(l, new Ponto(x, y));
	}
	
	public double getArea()
	{
		return lado*lado;
	}
	
	public Ponto getCentre()
	{
		return centro;
	}
	
	public double getSide()
	{
		return lado;
	}
	
	public double getSize()
	{
		return lado*4;
	}
	
	@Override
	public String toString()
	{
		return "Quadrado com centro em " + centro.toString() + " e lateral de " + lado + "unidades\n";
	}
}
