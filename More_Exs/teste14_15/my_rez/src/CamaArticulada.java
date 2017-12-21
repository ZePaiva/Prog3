import java.io.Serializable;
import java.util.Objects;

public class CamaArticulada extends Cama implements Transporte,
                                                    Serializable
{
	private static final int serialversionUID = 3;
	private TipoTransporte transporte;

	public CamaArticulada(String nome, int id, TipoCadeira material, double comp, double larg, boolean colchao, boolean transporte)
	{
		super(nome, id, material, comp, larg, colchao);
		if (transporte)
			this.transporte = TipoTransporte.MobilidadeReduzida;
		else
			this.transporte = null;
	}

	@Override
	public TipoTransporte getTipo()
	{
		return transporte;
	}

	@Override
	public void setTipo(TipoTransporte tipo)
	{
		if (transporte != null)
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
		CamaArticulada that = (CamaArticulada) o;
		return transporte == that.transporte;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(super.hashCode(), transporte);
	}

	@Override
	public String toString()
	{
		return "CamaArticulada{" + "transporte=" + transporte + '}';
	}
}