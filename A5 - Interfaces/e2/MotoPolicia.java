package aula5.e2;

public class MotoPolicia extends Moto implements Policia
{
	private String id;
	private Tipo t;
	
	public MotoPolicia(int ano, int rodas, int cc, int pow, int speed, double consumo, double comb, String capacete, String mark, String stamp, String cor, Tipo t, String id)
	{
		super(ano, rodas, cc, pow, speed, consumo, comb, capacete, mark, stamp, cor);
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
		MotoPolicia other = (MotoPolicia) obj;
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
