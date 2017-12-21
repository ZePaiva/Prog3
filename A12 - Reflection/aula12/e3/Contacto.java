package aula12.e3;

import aula1.e2.*;

public class Contacto
		extends Pessoa{
	private int numb;

	public Contacto(String nome, int cont, Data dof, int numb)
	{
		super(nome, cont, dof);
		this.numb = numb;
	}

	public int getNumb()
	{
		return numb;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numb;
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
		Contacto other = (Contacto) obj;
		if (numb != other.numb)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Contacto -> Nome: " + getName() + ", nº.: " + numb;
	}
}
