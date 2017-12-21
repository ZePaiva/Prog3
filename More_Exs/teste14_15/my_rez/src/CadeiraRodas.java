import java.io.Serializable;
import java.util.Objects;

public class CadeiraRodas extends Cadeira implements Transporte,
                                                     Serializable
{
	private static final int serialversionUID = 3;
	private int rodas;
	private TipoTransporte transporte;

	public CadeiraRodas(String nome, int id, Mobiliario.TipoCadeira material, TipoCadeira tipo, double altura, int apoios, int rodas, boolean eletrica)
	{
		super(nome, id, material, tipo, altura, apoios);
		this.rodas = rodas;
		if (eletrica)
			transporte = TipoTransporte.MobilidadeReduzida;
		else
			transporte = TipoTransporte.Manual;
	}

	public int getRodas()
	{
		return rodas;
	}

	@Override
	public TipoTransporte getTipo()
	{
		return transporte;
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
		CadeiraRodas that = (CadeiraRodas) o;
		return rodas == that.rodas && transporte == that.transporte;
	}

	@Override
	public int hashCode()
	{
	return Objects.hash(super.hashCode(), rodas, transporte);
	}

	@Override
	public void setTipo(TipoTransporte tipo)
	{
		if (transporte != null)
			transporte = tipo;
	}
}
