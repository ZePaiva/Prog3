package aula9.e2;

public class GeladoSimples 
implements Gelado
{
	private String flavour;
	private int bases;
	
	public GeladoSimples(String flavour)
	{
		this.flavour = flavour;
	}
	
	@Override
	public void base(int arg)
	{
		bases = arg;
		System.out.printf("\n%d %s de gelado de %s", bases, bases == 1 ? "bola" : "bolas" , flavour);
	}

	public String getFlavour()
	{
		return flavour;
	}
}
