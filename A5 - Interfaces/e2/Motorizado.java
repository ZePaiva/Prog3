package aula5.e2;

public class Motorizado extends Veiculo
{
	private int ano;
	private int cc;
	private int pow;
	private int maxSpeed;
	private double comb;
	private double consumo;
	private String matricula;
	
	public Motorizado(int rodas, String mark, String cor, int ano, int cc, int pow, int maxSpeed, double comb, double consumo, String matricula)
	{
		super(rodas, mark, cor);
		this.ano = ano;
		this.cc = cc;
		this.pow = pow;
		this.maxSpeed = maxSpeed;
		this.comb = comb;
		this.consumo = consumo;
		this.matricula= matricula;
	}

	public int getAno()
	{
		return ano;
	}

	public int getCc()
	{
		return cc;
	}

	public int getPotencia()
	{
		return pow;
	}

	public int getMaxSpeed()
	{
		return maxSpeed;
	}

	public double getCombustivel()
	{
		return comb;
	}

	public double getConsumo()
	{
		return consumo;
	}

	public String getMatricula()
	{
		return matricula;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ano;
		result = prime * result + cc;
		long temp;
		temp = Double.doubleToLongBits(comb);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(consumo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + maxSpeed;
		result = prime * result + pow;
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
		Motorizado other = (Motorizado) obj;
		if (ano != other.ano)
			return false;
		if (cc != other.cc)
			return false;
		if (Double.doubleToLongBits(comb) != Double.doubleToLongBits(other.comb))
			return false;
		if (Double.doubleToLongBits(consumo) != Double.doubleToLongBits(other.consumo))
			return false;
		if (matricula == null)
		{
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (maxSpeed != other.maxSpeed)
			return false;
		if (pow != other.pow)
			return false;
		return true;
	}
	
	
}
