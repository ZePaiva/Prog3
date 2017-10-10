package aula4.e1;

import aula1.e2.*;

public class Professor extends Pessoa
{
	private static int funcs = 0;
	private int nFunc;
	private Data dataAdmissao;
	
	public Professor(String nome, int cc, Data dOb, Data adm)
	{
		super(nome, cc, dOb);
		dataAdmissao = adm;
		nFunc = ++funcs;
	}
	
	public Professor(String nome, int cc, Data dOb)
	{
		this(nome, cc, dOb, new Data());
	}
	
	public static int getFuncs()
	{
		return funcs;
	}

	public int getnFunc()
	{
		return nFunc;
	}

	public Data getDataAdmissao()
	{
		return dataAdmissao;
	}

	@Override
	public String toString()
	{
		return "PROFESSOR: " + super.getName() + ", BI: " + super.getCC() + ", Nascido na Data: " + super.getDateOfBirth() + 
				", NMec: " + nFunc + ", Admitido em Data: " + dataAdmissao;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
		result = prime * result + nFunc;
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (dataAdmissao == null)
		{
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
			return false;
		if (nFunc != other.nFunc)
			return false;
		return true;
	}
	
}
