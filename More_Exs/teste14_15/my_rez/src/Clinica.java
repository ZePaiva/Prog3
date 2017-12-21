import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Clinica implements Serializable
{
	private static final int serialUID = 2;
	private String nome;
	private ListaGeneric<Mobiliario> mobilia;

	public Clinica(String nome)
	{
		this.nome = nome;
		mobilia = new ListaGeneric<>();
	}

	public boolean addMobiliario(Mobiliario mob)
	{
		if (mobilia.contains(mob))
			return false;
		else
			return mobilia.addElem(mob);
	}

	public boolean removeMobiliario(Mobiliario mob)
	{
		return mobilia.removeElem(mob);
	}

	public List<Transporte> listTransportes()
	{
		List<Mobiliario> lista = new ArrayList<>();
		for (Mobiliario mob : mobilia.toList())
		{
			if (mob instanceof Transporte)
				lista.add(mob);
		}

		List<Transporte> transports = new ArrayList<>();
		lista.forEach(f -> transports.add((Transporte)f));
		return transports;
	}

	public MyRangeIterator<Mobiliario> iterator()
	{
		return new ListaIterator();
	}

	private class ListaIterator implements MyRangeIterator<Mobiliario>
	{
		int i;
		Mobiliario tmp;
		public ListaIterator() {i=0;}

		@Override
		public boolean hasNext()
		{
			if (i < mobilia.totalElem())
				return true;
			else
				return false;
		}

		@Override
		public Mobiliario next()
		{
			if (hasNext())
			{
				tmp = mobilia.get(i);
				i++;
				return tmp;
			}
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public void saveClinica(String filename) throws IOException
	{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
		out.writeObject(this);
		out.close();
	}

	public Clinica rescueClinica(String filename) throws IOException, ClassNotFoundException
	{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		return (Clinica) in.readObject();
	}

}