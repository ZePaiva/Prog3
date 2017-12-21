import java.util.Objects;

public class Bebida
{
	enum TIPO
	{
		VINHO, CERVEJA, COLA, SUMO, AGUA;
	}

	private String nome;
	private double teorAlc;
	private TIPO tipo;

	public Bebida(String nome, double teorAlc, TIPO tipo)
	{
		this.nome = nome;
		this.teorAlc = teorAlc;
		this.tipo = tipo;
	}

	public String getNome()
	{
		return nome;
	}

	public double getTeorAlc()
	{
		return teorAlc;
	}

	public TIPO getTipo()
	{
		return tipo;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Bebida bebida = (Bebida) o;
		return Double.compare(bebida.teorAlc, teorAlc) == 0 && Objects.equals(nome, bebida.nome) && tipo == bebida.tipo;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(nome, teorAlc, tipo);
	}

	@Override
	public String toString()
	{
		return "Bebida "+ nome + "[teorAlc " + teorAlc + "]";
	}
}