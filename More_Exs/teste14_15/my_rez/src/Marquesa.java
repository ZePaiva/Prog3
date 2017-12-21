import java.io.Serializable;
import java.util.Objects;

public class Marquesa extends Cama implements Serializable
{
	private boolean marquesa;
	private static final int serialversionUID = 3;

	public Marquesa(String nome, int id, TipoCadeira material, double comp, double larg, boolean colchao, boolean marquesa)
	{
		super(nome, id, material, comp, larg, colchao);
		this.marquesa = marquesa;
	}

	public boolean isMarquesa()
	{
		return marquesa;
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
		Marquesa marquesa1 = (Marquesa) o;
		return marquesa == marquesa1.marquesa;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(super.hashCode(), marquesa);
	}

	@Override
	public String toString()
	{
		return "Marquesa{" + "marquesa=" + marquesa + '}';
	}
}