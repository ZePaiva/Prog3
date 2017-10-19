package aula5.e2;

public class CarroPolicia extends Automovel implements Policia
{
	private Tipo t;
	private String id;
	
	public CarroPolicia(String mark, String cor, int ano, int cc, int pow, int maxSpeed, double comb, double consumo, String matricula, int lot, Tipo t, String id)
	{
		super(mark, cor, ano, cc, pow, maxSpeed, comb, consumo, matricula, lot);
		this.t = t;
		this.id = id;
	}
	
	public String getID()
	{
		return id;
	}
	
	public Tipo getTipo()
	{
		return t;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((t == null) ? 0 : t.hashCode());
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
		CarroPolicia other = (CarroPolicia) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (t != other.t)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Veículo de Policia:" + id;
	}
	
	

}
