package aula5.e2;

public class Automovel extends Motorizado
{

	private int lot;
	
	public Automovel(String mark, String cor, int ano, int cc, int pow, int maxSpeed, double comb, double consumo, String matricula, int lot)
	{
		super(4, mark, cor, ano, cc, pow, maxSpeed, comb, consumo, matricula);
		this.lot = lot;
	}

	public int getLot()
	{
		return lot;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + lot;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automovel other = (Automovel) obj;
		if (lot != other.lot)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Automovel -> lotação" + lot + ", matrícula: " + super.getMatricula() + ", ano: " + super.getAno() + ", marca: " + super.getMarca() + ", potência: " + super.getPotencia();
	}

	
	
}
