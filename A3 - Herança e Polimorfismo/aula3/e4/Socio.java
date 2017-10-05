package aula3.e4;

public class Socio {
	private static int seqSoc = 1;
	private final int nSoc;
	private final int nCC;
	private final int maxLoans;
	private final String nome;
	private final Data dateOfBirth;
	private final Data insc;
	private int loans;
	
	public Socio(Data data, Data data2, String n, int cc, int loans)
	{
		nSoc = seqSoc++;
		insc = data;
		nome = n;
		nCC = cc;
		dateOfBirth = data2;
		maxLoans = loans;
		this.loans = 0;
	}

	public int getnSoc() 
	{
		return nSoc;
	}

	public int getnCC()
	{
		return nCC;
	}

	public String getNome() 
	{
		return nome;
	}

	public Data getDateOfBirth() 
	{
		return dateOfBirth;
	}

	public Data getInsc() 
	{
		return insc;
	}	
	
	public boolean newLoan()
	{
		if (loans < maxLoans)
		{
			loans++;
			return true;
		}	
		return false;
	}
	
	public int loanAmount()
	{
		return loans;
	}
	
	public void clearLoan()
	{
		loans--;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + nSoc;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		if (nSoc != other.nSoc)
			return false;
		if (nome == null)
		{
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Socio [nSoc=" + nSoc + ", nCC=" + nCC + ", nome=" + nome + ", loans=" + loans + "]";
	}
	
	
}
