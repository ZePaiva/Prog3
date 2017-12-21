import java.util.Objects;

public class Visitante
{
	private static int num = 1;
	private int numero;
	private String entrada;

	public Visitante(String entrada)
	{
		this.entrada = entrada;
		numero = num++;
	}

	public int getNum()
	{
		return numero;
	}

	public String getEntrada()
	{
		return entrada;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Visitante visitante = (Visitante) o;
		return numero == visitante.numero && Objects.equals(entrada, visitante.entrada);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(numero, entrada);
	}

	@Override
	public String toString()
	{
		return "Visitante\t[num=" + numero + ", entrada=" + entrada + "]";
	}
}