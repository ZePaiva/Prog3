import java.util.List;
import java.util.Objects;

public class Tenda implements Vendedor
{
	private int numero;
	private String nome;

	public Tenda(int numero, String nome)
	{
		this.numero = numero;
		this.nome = nome;
	}

	public int getNumero()
	{
		return numero;
	}

	public String getNome()
	{
		return nome;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Tenda tenda = (Tenda) o;
		return numero == tenda.numero && Objects.equals(nome, tenda.nome);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(numero, nome);
	}

	@Override
	public String toString()
	{
		return "Tenda[num=" + numero + ", nome=" + nome +"]";
	}

	@Override
	public List<String> opcoes()
	{
		return null;
	}
}