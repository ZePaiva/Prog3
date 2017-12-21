import java.io.Serializable;
import java.util.Objects;

public class Cama extends Mobiliario implements Serializable
{
	private static final int serialversionUID = 3;
	private double comp;
	private double larg;
	private boolean colchao;

	public Cama(String nome, int id, TipoCadeira material, double comp, double larg, boolean colchao)
	{
		super(nome, id, material);
		this.comp = comp;
		this.larg = larg;
		this.colchao = colchao;
	}

	public double getComp()
	{
		return comp;
	}

	public double getLarg()
	{
		return larg;
	}

	public boolean isColchao()
	{
		return colchao;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Cama cama = (Cama) o;
		return Double.compare(cama.comp, comp) == 0 && Double.compare(cama.larg, larg) == 0 && colchao == cama.colchao;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(super.hashCode(), comp, larg, colchao);
	}

	@Override
	public String toString()
	{
		return "Cama{" + "comp=" + comp + ", larg=" + larg + ", colchao=" + colchao + '}';
	}
}