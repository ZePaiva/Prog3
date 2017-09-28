package aula2.e1;

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
}
