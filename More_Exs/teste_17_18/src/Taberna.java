import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;

public class Taberna extends Tenda
{
	private List<Bebida> bebidas;

	public Taberna(int numero, String nome, List<Bebida> bebidas)
	{
		super(numero, nome);
		this.bebidas = bebidas;
	}

	public Taberna(int numero, String nome)
	{
		super(numero, nome);
		this.bebidas = new ArrayList<>();
	}

	@Override
	public List<String> opcoes()
	{
		List<String> drinks = new ArrayList<>();
		bebidas.stream().map(f -> f.getNome()).forEach(drinks::add);
		return drinks;
	}

	public boolean add(Bebida b)
	{
		return bebidas.add(b);
	}

	public List<Bebida> getLista()
	{
		return bebidas;
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
		Taberna taberna = (Taberna) o;
		return Objects.equals(bebidas, taberna.bebidas);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(super.hashCode(), bebidas);
	}

	private String printDrinks()
	{
		String toRet = "";
		int i = 1;
		for (Bebida b : bebidas)
		{
			if (i == bebidas.size())
				toRet += b.toString();
			else
				toRet += b.toString() + ", ";
			i++;
		}

		return toRet;
	}

	@Override
	public String toString()
	{
		return "Taberna [bebidas=" + printDrinks() + "], toString()=" + super.toString() + "]";
	}
}
