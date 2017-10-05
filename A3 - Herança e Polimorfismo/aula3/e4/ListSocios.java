package aula3.e4;

import java.util.*;

public class ListSocios {
	private Hashtable<Integer, Aluno> listaAl;
	private Hashtable<Integer, Funcionario> listFunc;
	
	public ListSocios()
	{
		listaAl = new Hashtable<Integer, Aluno>();
		listFunc = new Hashtable<Integer, Funcionario>();
	}
	
	public void putFunc(Funcionario s)
	{
		listFunc.put(s.getnSoc(), s);
	}
	
	public void putAluno(Aluno s)
	{
		listaAl.put(s.getnSoc(), s);
	}
	
	public boolean remSoc(int s)
	{
		if (listaAl.contains(s))
		{
			listaAl.remove(s);
			return true;
		}
		else if (listaAl.contains(s))
		{
			listFunc.remove(s);
			return true;
		}
		else
			return false;
	}
	
	public Funcionario getFunc(int s)
	{
		return listFunc.get(s);
	}
	
	public Aluno getAluno(int s)
	{
		return listaAl.get(s);
	}
	
	public boolean temAluno(int s)
	{
		return listaAl.contains(s);
	}
	
	public boolean temFunc(int s)
	{
		return listFunc.contains(s);
	}
	
	public int lastSocNumb()
	{
		return listaAl.size() + listFunc.size();
	}
	
	public boolean containsAlunSoc(int s)
	{
		return listaAl.containsKey(s);
	}
	
	public boolean containsFunSoc(int s)
	{
		return listFunc.containsKey(s);
	}
}
