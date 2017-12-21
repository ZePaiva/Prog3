import java.util.*;

public class Feira
{
	private String nome;
	private String address;
	private Set<Tenda> tendas;
	private List<Visitante> visitors;

	public Feira(String nome, String address)
	{
		this.nome = nome;
		this.address = address;
		tendas = new HashSet<>();
		visitors = new ArrayList<>();
	}

	public boolean add(Tenda t)
	{
		return tendas.add(t);
	}

	public boolean add(Visitante v)
	{
		return visitors.add(v);
	}

	public String getProductsFrom(Tasquinha pst1)
	{
		String toRet = "[";
		int i = 1;
		for(String comida : pst1.getMenu())
		{
			if (i == pst1.getMenu().length)
				toRet += comida + "]";
			else
				toRet += comida + ", ";
			i++;
		}
		return toRet;
	}

	public List<Bebida> getBeerByType(Bebida.TIPO tipo)
	{
		List<Taberna> tabs = new ArrayList<>();
		for (Tenda t : tendas)
			if (t.getClass().getSimpleName().equals("Taberna"))
				tabs.add((Taberna)t);

		List<Bebida> bebidas = new ArrayList<>();
		List<Bebida> aid;
		for(Taberna t : tabs)
		{
			aid = t.getLista();
			for (Bebida b : aid)
				if (b.getTipo() == tipo)
					bebidas.add(b);
		}

		return bebidas;
	}

	public String getNome()
	{
		return nome;
	}

	public String getAddress()
	{
		return address;
	}

	public Set<Tenda> getTendas()
	{
		return tendas;
	}

	public List<Visitante> getVisitors()
	{
		return visitors;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Feira feira = (Feira) o;
		return Objects.equals(nome, feira.nome) && Objects.equals(address, feira.address) && Objects.equals(tendas, feira.tendas) && Objects.equals(visitors, feira.visitors);
	}

	@Override
	public int hashCode()
	{

		return Objects.hash(nome, address, tendas, visitors);
	}

	@Override
	public String toString()
	{
		return "Feira " + nome + '\n' +
						"Tendas:\n" + tendas.toString() + '\n' +
						"Visitantes:\n" + visitors.toString() + '\n';
	}

	public int totalExpositores(String tipo)
	{
		int i = 0;
		for (Tenda t : tendas)
			if(t.getClass().getSimpleName().equals(tipo))
				i++;

		return i;
	}
}