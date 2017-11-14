package aula9.e3;

import java.util.*;
import aula1.e2.*;

public class ListaPessoas
{
	private List<Pessoa> lista;
	
	public ListaPessoas()
	{
		lista = new LinkedList<Pessoa>();
	}
	
	public boolean addPessoa(Pessoa p)
	{
		return lista.add(p);
	}
	
	public boolean removePessoa(Pessoa p)
	{
		return lista.remove(p);
	}
	
	public int totalPessoas()
	{
		return lista.size();
	}
	
	public Iterator<Pessoa> iterator()
	{
		return lista.iterator();
	}
}
