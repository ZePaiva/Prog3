package aula4.e3;

import aula1.e2.*;

public class Funcionario extends Socio
{
  private final int nFunc;
  private final int nFisc;

  public Funcionario(Data data, Data data2, String n, int c, int nfu, int nfi, int l)
  {
	  super(data, data2, n, c, l);
	  nFunc = nfu;
	  nFisc = nfi;
  }

  public int getFuncNumb()
  {
    return nFunc;
  }

  public int getFiscNumb()
  {
    return nFisc;
  }
  
  @Override
  public String toString()
  {
	  return " Sócio nº: " + super.getnSoc() + " -> Funcionário nº: " + nFunc + ", Nome: " + super.getNome();
  }

@Override
public int hashCode()
{
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + nFisc;
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
	Funcionario other = (Funcionario) obj;
	if (nFisc != other.nFisc)
		return false;
	if (nFunc != other.nFunc)
		return false;
	return true;
}
  
  
}
