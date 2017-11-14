package aula9.e2;

public class Copo
implements Gelado
{
	private Gelado gel;
	private int bases;
	
	public Copo(Gelado a)
	{
		gel = a;
	}
	
	@Override
	public void base(int arg)
	{
		bases = arg;
		System.out.printf("\n%d %s de gelado de %s em copo", bases, bases == 1 ? "bola" : "bolas" , gel.getFlavour());
	}

	@Override
	public String getFlavour()
	{
		return gel.getFlavour();
	}
}
