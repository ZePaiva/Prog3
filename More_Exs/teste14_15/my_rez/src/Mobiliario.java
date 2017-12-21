import java.io.Serializable;
import java.util.Objects;

public class Mobiliario implements Serializable
{
	private static final int serialversionUID = 3;
	private String nome;
	private int id;
	private TipoCadeira material;

	enum TipoCadeira
	{
		Madeira, Plastico, Metal, Sintetico
	}


	public Mobiliario(String nome, int id, TipoCadeira material)
	{
		this.nome = nome;
		this.id = id;
		this.material = material;
	}

	public String getNome()
	{
		return nome;
	}

	public int getId()
	{
		return id;
	}

	public TipoCadeira getMaterial()
	{
		return material;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Mobiliario that = (Mobiliario) o;
		return id == that.id && Objects.equals(nome, that.nome) && material == that.material;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(nome, id, material);
	}

	@Override
	public String toString()
	{
		return "Mobiliario{" + "nome='" + nome + '\'' + ", id=" + id + ", material=" + material + '}';
	}
}