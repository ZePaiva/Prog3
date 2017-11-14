package aula9.e2;

public class Topping
implements Gelado
{
	private Gelado gel;
	private String top;
	
	public Topping(Gelado a, String fl)
	{
		gel = a;
		top = fl;
	}

	@Override
	public String getFlavour()
	{
		return gel.getFlavour();
	}

	@Override
	public void base(int arg)
	{
		gel.base(arg);
		System.out.printf(" com %s", top);
	}	
}
