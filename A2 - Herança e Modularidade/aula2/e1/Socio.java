package aula2.e1;

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
}
