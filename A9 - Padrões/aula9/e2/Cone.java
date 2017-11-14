package aula9.e2;

public class Cone
implements Gelado
{
	private Gelado gel;
	private int bases;
	
	public Cone(Gelado a)
	{
		gel = a;
	}
	
	@Override
	public String getFlavour()
	{
		return gel.getFlavour();
	}

	@Override
	public void base(int arg)
	{
		bases = arg;
		System.out.printf("\n%d %s de gelado de %s em cone", bases, bases == 1 ? "bola" : "bolas" , gel.getFlavour());
	}
}
