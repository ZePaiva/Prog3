package aula4.e3;

import static java.lang.System.*;
import java.util.*;
import java.time.*;
import aula1.e2.*;


public class VideoClube {
	private ListSocios lista;
	private MovieList listaFilmes;
	private Loans listaEmprestimos;
	private Scanner k;
	private ArrayList<Integer> delSocs;
	private int delIndSoc;
	private int maxLoans;
	
	public VideoClube(int l)
	{
		lista = new ListSocios();
		listaFilmes = new MovieList();
		listaEmprestimos = new Loans();
		k = new Scanner(in);
		delSocs = new ArrayList<Integer>();
		delIndSoc= 0;
		maxLoans = l;
	}
	public void addsoc()
	{
		out.print("Nome do sócio: ");
		String nm = k.nextLine();
		  
		out.print("Data de Nascimento (dd/mm/yyyy): ");
		String data = k.nextLine();
		String dof[] = data.split("/");
		if (dof.length < 3)
		{
			out.println("Falta um dado na data");
			return;
		}
		int dOf[] = {Integer.parseInt(dof[0]), Integer.parseInt(dof[1]), Integer.parseInt(dof[2])};
		 
		out.print("Data de inscrição (dd/mm/yyyy): ");
		data = k.nextLine();
		String doi[] = data.split("/");
		if (doi.length < 3)
		{
			out.println("Falta um dado na data");
			return;
		}
		int dOi[] = {Integer.parseInt(doi[0]), Integer.parseInt(doi[1]), Integer.parseInt(doi[2])};
		  
		out.print("Número do cartão de cidadão: ");
		int cc = k.nextInt();
		  
		int alORfu;
		do {
			out.print("Aluno(0) ou Funcionário(1): ");
			alORfu = k.nextInt();
		} while (alORfu != 0 && alORfu != 1);
		  
		if (alORfu == 1)
		{
			out.printf("Número fiscal: ");
			int nFisc = k.nextInt();
			out.printf("Número de funcionário: ");
			int nFunc = k.nextInt();
			k.nextLine();
				  
			lista.putSoc(new Funcionario(new Data(dOi[0], dOi[1], dOi[2]), new Data(dOf[0], dOf[1], dOf[2]), nm, cc, nFunc, nFisc, maxLoans));
		}
		else
		{
			k.nextLine();
			out.printf("Curso: ");
			String course = k.nextLine();
			out.printf("Número mecanográfico: ");
			int nmec = k.nextInt();
			k.nextLine();
				  
			lista.putSoc(new Aluno(new Data(dOi[0], dOi[1], dOi[2]), new Data(dOf[0], dOf[1], dOf[2]), nm, course, cc, nmec, maxLoans));
		}
		
		out.println("Sócio adicionado com sucesso.\n");
	}
	public void remsoc()
	{
		out.printf("Número de Sócio: ");
		int ns = k.nextInt();
		k.nextLine();
	
		lista.remSoc(ns);
		delSocs.add(delIndSoc++, ns);
		out.printf("Membro removido com sucesso\n");	
	}
	
	public void searchMov()
	{
		out.printf("Id do vídeo: ");
		int vID = k.nextInt();
		k.nextLine();
		listaFilmes.movie(vID);
	}  
	public void listVid()
	{
		
		out.printf("Número de sócio: ");
		int soc = k.nextInt();
		k.nextLine();
		
		try
		{
			Socio tmp = lista.getSoc(soc);
			int idade = (Year.now().getValue()) - (tmp.getDateOfBirth()).getYear();
			int m = Calendar.getInstance().get(Calendar.MONTH) + 1 - (tmp.getDateOfBirth()).getMonth();
			int d = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - (tmp.getDateOfBirth()).getDay();
			if (m < 0 || d < 0)
			{
				idade--;
			}
			listaFilmes.movieDisplay(idade);
		}
		catch(NullPointerException e)
		{
			out.println("Sócio não existente");
		}
	}  
	public void putVid()
	{
		out.printf("\nTítulo: ");
		String title = k.nextLine();
		String cat, age;
		do {
			out.printf("Categoria (Ação, Comédia, Drama, Infantil): ");
			cat = k.nextLine();
		} while(!cat.equals("Ação") && !cat.equals("Comédia") && !cat.equals("Infantil") && !cat.equals("Drama"));
		do {
			out.printf("Faixa etária (ALL, M6, M12, M16, M18): ");
			age = k.nextLine();
		} while(!age.equals("ALL") && !age.equals("M6") && !age.equals("M12") && !age.equals("M16") && !age.equals("M18"));

		listaFilmes.addMovie(new Movie(title, cat, age));
		out.println("Filme adicionado com sucesso.\n");
	}
	public void remVid()
	{
		out.print("Id do Vídeo: ");
		int vID = k.nextInt();
		k.nextLine();
		listaFilmes.delMovie(vID);
		out.println("Vídeo removido com sucesso.\n");
	}
	public void canVid()
	{
		out.print("Id do vídeo: "); 
		int vID = k.nextInt();
		k.nextLine();
		listaFilmes.movieDisponivel(vID);
	}
	public void loanVid()
	{
		out.printf("Id do vídeo a levantar: ");
		int vID = k.nextInt();
		Movie tmp = listaFilmes.getMovieById(vID);
		
		out.printf("Id de sócio: ");
		int socID = k.nextInt();
		k.nextLine();
		
		out.printf("Data de emprestimo(dd/mm/yyyy): ");
		String dat = k.nextLine();
		String data[] = dat.split("/");
		if(data.length < 3)
		{
			out.println("Faltam dados na data.");
			return;
		}
		
		Socio tmpf = lista.getSoc(socID);
		if (tmpf.newLoan())
			listaEmprestimos.newLoan(new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])), tmpf, tmp);
		else 
		{
			out.printf("Já atingiu o limite de emprétimos.\n");
			return;
		}
		out.println("Emprétimo feito com sucesso.\n");
	}
	public void retVideo()
	{
		out.printf("Id do vídeo a depositar: ");
		int vID = k.nextInt();		
		Movie tmp;
		try
		{
			tmp = listaFilmes.getMovieById(vID);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			out.println("Nenhum filme com esse ID.\n");
			return;
		}
		
		out.printf("Id de sócio: ");
		int socID = k.nextInt();
		k.nextLine();
		
		out.printf("Data de entrega(dd/mm/yyyy): ");
		String dat = k.nextLine();
		String data[] = dat.split("/");
		if (data.length < 3)
		{
			out.println("Falta um dado na data.\n");
			return;
		}
			
		int rating;
		do
		{
			out.printf("Rating (1-10): ");
			rating = k.nextInt();
		}while (rating < 1 || rating > 10);
		Socio tmpf = lista.getSoc(socID);
		tmpf.clearLoan();
		listaEmprestimos.returnMovie(new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])), tmpf, tmp, rating); 
		
		out.println("Entrega de filme com sucesso.\n");
	}
	public void checkReq()
	{
		out.printf("Id do video: ");
		int vID = k.nextInt();
		k.nextLine();
		try
		{		  
			int socios = lista.lastSocNumb();
			int users[] =listaEmprestimos.getMovieHistory(socios, vID, delSocs);
			
			if (users.length == 0)
			{
				out.printf("Nenhum utilizador viu o filme %s.\n\n",(listaFilmes.getMovieById(vID)).getTitle());
				return;
			}
			out.printf("Utilizadores que viram o filme %s:\n", (listaFilmes.getMovieById(vID)).getTitle());
			for (socios = 0; socios < users.length; socios++)
			{
				if(lista.hasSoc(users[socios]))
				{
					out.println(lista.getSoc(users[socios]));
				}
			}
			out.println();
		}
		catch (IndexOutOfBoundsException e) 
		{
			out.println("Filme não existente.");
		}
	}
	
	public void showAll()
	{
		listaFilmes.movieDisplay(18);
	}
	
	public void showRated()
	{
		listaFilmes.showRated();
	}
	
	public void checkSocHist()
	{
		out.printf("Id do sócio: ");
		int soc = k.nextInt();
		
		try
		{
			int[] movieIDs = listaEmprestimos.getSocHistory(soc, listaFilmes.movieAmount());
			if (movieIDs.length == 0)
			{
				out.printf("Sócio com id %d não requesitou nenhum filme.\n", soc);
				return;
			}
			
			out.printf("O sócio %d requesitou %s: \n", soc, movieIDs.length == 1 ? "o seguinte filme" : "os seguintes filmes");
			for(int i = 0; i < movieIDs.length; i++)
			{
				if (listaFilmes.getMovieById(movieIDs[i]) != null)
					out.print(listaFilmes.getMovieById(movieIDs[i]));
			}
			
		}
		catch (IndexOutOfBoundsException e)
		{
			out.println("Sócio não encontrado.\n");
		}
		k.nextLine();
	}
}