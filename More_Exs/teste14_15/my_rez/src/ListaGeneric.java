import java.io.Serializable;
import java.util.*;

public class ListaGeneric<T> implements Serializable
{
	private List<T> lista = new ArrayList<>();
	private static final int serialversionUID = 3;


	public boolean addElem(T elem)
	{
		if (elem == null)
			return false;
		lista.add(elem);
		return true;
	}

	public boolean removeElem(T elem)
	{
		if (elem == null)
			return false;
		if (lista.contains(elem))
		{
			lista.remove(elem);
			return true;
		}
		return false;
	}

	public T get(int i)
	{
		return lista.get(i);
	}

	public boolean contains(T elem)
	{
		if (elem == null)
			return false;
		if (lista.contains(elem))
			return true;
		return false;
	}

	public int totalElem()
	{
		return lista.size();
	}

	public List<T> toList()
	{
		List<T> tmp = new LinkedList<>();
		for (int i=0; i<totalElem(); i++)
			tmp.add(lista.get(i));
		return tmp;
	}

	public MyRangeIterator iterator()
	{
		return new MyRangeIterator();
	}

	private class MyRangeIterator implements Iterator<T>
	{
		private int i;
		MyRangeIterator()
		{
			i = 0;
		}

		public boolean hasNext()
		{
			return (i < totalElem());
		}

		public T next()
		{
			if (hasNext())
			{
				T elem = lista.get(i);
				i++;
				return elem;
			}
			throw new IndexOutOfBoundsException("Não há próximo elemento.");
		}

		public void remove()
		{
			throw new UnsupportedOperationException ("Operação não suportada.");
		}
	}

	@Override
	public String toString()
	{
		return "ListaGeneric [lista=" + lista + "]";
	}
}