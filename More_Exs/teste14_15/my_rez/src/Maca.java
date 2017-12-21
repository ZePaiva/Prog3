import java.util.Objects;

public class Maca extends Marquesa implements Transporte
{
	private TipoTransporte transporte = TipoTransporte.Urgente;
	private int grades;

	public Maca(String nome, int id, TipoCadeira material, double comp, double larg, boolean colchao, int grades)
	{
		super(nome, id, material, comp, larg, colchao, false);
		this.transporte = transporte;
		this.grades = grades;
	}

	public int getGrades()
	{
		return grades;
	}

	@Override
	public TipoTransporte getTipo()
	{
		return transporte;
	}

	@Override
	public void setTipo(TipoTransporte tipo)
	{
		transporte = tipo;
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
		Maca maca = (Maca) o;
		return grades == maca.grades && transporte == maca.transporte;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(super.hashCode(), transporte, grades);
	}

	@Override
	public String toString()
	{
		return "Maca{" + "transporte=" + transporte + ", grades=" + grades + '}';
	}
}