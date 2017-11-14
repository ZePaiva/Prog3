package aula9.e3;

import java.util.*;
import aula1.e2.*;

public class VetorPessoas
{
	private Pessoa vetor[];
	private int size;
	
	public VetorPessoas()
	{
		vetor = new Pessoa[1];
		size = 0;
	}
	
	private boolean full()
	{
		return size == vetor.length;
	}
	
	public boolean addPessoa(Pessoa p)
	{
		try
		{
			if (full())
			{
				extendArray();
				vetor[size++] = p;
			}
			else
				vetor[size++] = p;
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	private void extendArray()
	{
		Pessoa tmp[] = new Pessoa[vetor.length * 2];
		System.arraycopy(vetor, 0, tmp, 0, vetor.length);
		vetor = tmp;
	}
	
	public boolean removePessoa(Pessoa p)
	{
		boolean found = false;
		for (int i = 0; i < size; i++)
		{
			if (found)
				vetor[i] = vetor[i+1];
			else if (p.equals(vetor[i]))
			{
				vetor[i] = vetor[i+1];
				found = true;
			}
		}
		
		return found;
	}
	
	public class VetorIterator
	implements Iterator<Pessoa>
	{

		private int index;
		
		public VetorIterator()
		{
			index = 0;
		}
		
		public void remove()
		{
			removePessoa(vetor[index]);
		}
		
		@Override
		public boolean hasNext()
		{
			return index < size;
		}

		@Override
		public Pessoa next()
		{
			return vetor[index++];
		}	
	}
	
	public Iterator<Pessoa> iterator()
	{
		return this.new VetorIterator();
	}
	
	
}
