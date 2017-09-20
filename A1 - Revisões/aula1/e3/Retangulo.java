package aula1.e3;

public class Retangulo {
	private Ponto centro;
	private double largura;
	private double comprimento;
	
	public Retangulo(double l, double c, Ponto cn)
	{
		centro = cn;
		largura = l;
		comprimento = c;
	}
	
	public Retangulo(double l, double c)
	{
		this(l, c, new Ponto(0.0, 0.0));
	}
	
	public Retangulo(Ponto c)
	{
		this(1, 2, c);
	}
	
	public Retangulo()
	{
		this(1, 2, new Ponto(0.0, 0.0));
	}
	
	public double getArea()
	{
		return largura*comprimento;
	}
	
	public double getLarg()
	{
		return largura;
	}
	
	public double getCompr()
	{
		return comprimento;
	}
	
	public Ponto getCentre()
	{
		return centro;
	}
	
	public double getSize()
	{
		return largura*2+comprimento*2;
	}
	
	@Override
	public String toString()
	{
		return "Retângulo com centro em " + centro.toString() + " largura de " + largura + " unidades e comprimento de " + comprimento + " unidades.\n";
	}
}
