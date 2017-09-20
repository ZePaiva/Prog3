package aula1.e3;

public class Ponto {
	private double x;
	private double y;
	
	public Ponto(double a, double b)
	{
		x = a;
		y = b;
	}

	public double getX() 
	{
		return x;
	}

	public double getY() 
	{
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public double dist(Ponto toKnow)
	{
		return Math.sqrt(Math.pow(this.x-toKnow.x, 2) + Math.pow(this.y - toKnow.y, 2));
	}
	
}