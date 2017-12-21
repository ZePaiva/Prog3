import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tasquinha extends Tenda
{
	private String menu[];

	public Tasquinha(int numero, String nome, String menu[])
	{
		super(numero, nome);
		this.menu = menu;
	}

	public Tasquinha(int numero, String nome)
	{
		this(numero, nome, new String[10]);
	}

	public String[] getMenu()
	{
		return menu;
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
		Tasquinha tasquinha = (Tasquinha) o;
		return Objects.equals(menu, tasquinha.menu);
	}

	@Override
	public int hashCode()
	{

		return Objects.hash(super.hashCode(), menu);
	}

	private String printMenu()
	{
		int i = 1;
		String ret = "";
		for (String a : menu)
		{
			if(i == menu.length)
				ret += a;
			else
				ret += a + ", ";
			i++;
		}

		return ret;
	}

	@Override
	public String toString()
	{
		return "Tasquinha [menu=" + printMenu() + "], toString()=" + super.toString() + "]";
	}
}