package aula3.e1;

import aula1.e2.*;
import java.util.*;

public class Estudante extends Pessoa
{
	private static int totalDeAlunos = 100;
	private int nmec;
	private Data inscricao;
	
	public Estudante(String nome, int bi, Data dOb, Data insc)
	{
		super(nome, bi, dOb);
		nmec = totalDeAlunos++;
		inscricao = insc;
	}
	
	public Estudante(String nome, int bi, Data dOb)
	{
		this(nome, bi, dOb, new Data(Calendar.DAY_OF_MONTH, Calendar.MONTH+1, Calendar.YEAR));
	}
	
	public int nMec()
	{
		return nmec;
	}
	
	public Data inscriprion()
	{
		return inscricao;
	}
	
	@Override
	public String toString()
	{
		return super.getName() + ", BI: " + super.getCC() + ", Nasc.Data:" + super.getDateOfBirth() +
				", NMec: " + nmec + ", inscrito em Data: " + inscricao.toString();
	}
}
