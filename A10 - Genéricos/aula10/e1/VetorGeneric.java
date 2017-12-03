package aula10.e1;

import java.util.*;

import aula1.e2.Pessoa;
import aula9.e3.VetorPessoas.VetorIterator;

public class VetorGeneric <T>
implements Iterable<T>
{
	private T vetor[];
	private int size;
	
	public VetorGeneric()
	{
		vetor = (T[]) new Object[1];
		size = 0;
	}
	
	public boolean totalElem()
	{
		return vetor.length == size;
	}
	
	private void extendArray()
	{
		T tmp[] = (T[]) new Object[vetor.length * 2];
		System.arraycopy(vetor, 0, tmp, 0, vetor.length);
		vetor = tmp;
	}
	
	public boolean addElem(T elem)
	{
		try
		{
			if (totalElem())
			{
				extendArray();
				vetor[size++] = elem;
			}
			else
				vetor[size++] = elem;
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public boolean removeElem(T elem)
	{
		boolean found = false;
		for (int i = 0; i < size; i++)
		{
			if (found)
				vetor[i] = vetor[i+1];
			else if (elem.equals(vetor[i]))
			{
				vetor[i] = vetor[i+1];
				found = true;
			}
		}
		
		return found;
	}
	
	public class VetorIterator
	implements Iterator<T>
	{

		private int index;
		
		public VetorIterator()
		{
			index = 0;
		}
		
		@Override
		public void remove()
		{
			removeElem(vetor[index]);
		}
		
		@Override
		public boolean hasNext()
		{
			return index < size;
		}

		@Override
		public T next()
		{
			return vetor[index++];
		}	
	}
	
	public Iterator<T> iterator()
	{
		return this.new VetorIterator();
	}
}
