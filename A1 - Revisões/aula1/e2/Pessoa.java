package aula1.e2;

public class Pessoa {

	private int cc;
	private String nome;
	private Data dataNasc;
	
	public Pessoa(String n, int c, Data d)
	{
		cc= c;
		nome = n;
		dataNasc = d;
	}
	
	@Override
	public String toString() 
	{
		return "cc=" + cc + ", nome=" + nome + ", dataNasc=" + dataNasc;
	}

	public String getName()
	{
		return nome;
	}
	
	public int getCC()
	{
		return cc;
	}
	
	public Data getDateOfBirth()
	{
		return dataNasc;
	}

	public int CompareToCC(Pessoa toCompare)
	{
		if(toCompare.cc < this.cc)
			return -1;
		else if (toCompare.cc == this.cc)
			return 0;
		else
			return 1;
	}

	public int CompareToNome(Pessoa toCompare)
	{
		return (this.nome).compareTo(toCompare.nome);
	}
}