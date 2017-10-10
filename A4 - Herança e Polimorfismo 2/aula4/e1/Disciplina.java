package aula4.e1;

import aula3.e1.*;
import java.util.*;
import static java.lang.System.*;

public class Disciplina
{
	private String nome;
	private String area;
	private int ects;
	private Professor responsavel;
	private ArrayList<Estudante> alunos;
	private int inscritos;
	
	public Disciplina(String nd, String area, int ects, Professor resp)
	{
		nome = nd;
		this.area = area;
		this.ects = ects;
		responsavel = resp;
		alunos = new ArrayList<Estudante>();
		inscritos = 0;
	}
	
	public boolean addAluno(Estudante e)
	{
		if (contains(e)) {
			out.println("O aluno já se encontra inscrito.");
			return false;
		}
		alunos.add(e);
		inscritos++;
		return true;
	}
	
	private boolean contains(Estudante e)
	{
		return 	alunos.contains(e);
	}
	
	private int contains(int nmec)
	{
		int i;
		for (i = 0; i < inscritos; i++)
			if(alunos.get(i).nMec() == nmec)
				break;
		return i;
	}
	
	public boolean delAluno(int nmec)
	{
		int al = contains(nmec);
		if (al == inscritos)
			return false;
		else
		{
			alunos.remove(al);
			inscritos--;
			return true;
		}
	}
	
	
	public boolean alunoInscrito(int nmec)
	{
		return contains(nmec) != inscritos ? true : false;
	}
	
	public int numAlunos()
	{
		return inscritos;
	}

	public Estudante[] getAlunos()
	{
		return alunos.toArray(new Estudante[0]);
	}
	
	public Estudante[] getAlunos(String tipo)
	{
		ArrayList<Estudante> tipos = new ArrayList<>();
		for(Estudante estud : alunos)
			if (((estud.getClass()).toString()).contains(tipo))
				tipos.add(estud);
		return tipos.toArray(new Estudante[0]);
	}
	
	@Override
	public String toString()
	{
		return "Disciplina:" + nome + " ( " + ects + " ECTS) da area de " + area + "\nResponsável: " + responsavel
				+ "\nExistem " + inscritos + " alunos inscritos.";
	}
}