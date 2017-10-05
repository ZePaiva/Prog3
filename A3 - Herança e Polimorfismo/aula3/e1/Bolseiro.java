package aula3.e1;

import java.util.Calendar;

import aula1.e2.Data;

public class Bolseiro extends Estudante
{
	private int bolsa;
	
	public Bolseiro(String nome, int bi, Data dOb, Data insc)
	{
		super(nome, bi, dOb, insc);
		bolsa = 0;
	}
	
	public Bolseiro(String nome, int bi, Data dOb)
	{
		this(nome, bi, dOb, new Data(Calendar.DAY_OF_MONTH, Calendar.MONTH+1, Calendar.YEAR));
	}
	
	public void setBolsa(int b)
	{
		bolsa = b;
	}
	
	public int bolsa()
	{
		return bolsa;
	}
	
	@Override
	public String toString()
	{
		return super.getName() + ", BI: " + super.getCC() + ", Nasc. Data:" + super.getDateOfBirth() +
				", NMec: " + super.nMec() + ", inscrito em Data: " + super.inscriprion() + ", Bolsa: " + bolsa;
	}
}