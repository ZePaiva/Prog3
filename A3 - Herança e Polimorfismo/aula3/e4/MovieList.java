package aula3.e4;

import java.util.*;
import static java.lang.System.*;

public class MovieList
{
  private ArrayList<Movie> lista;
  
  public MovieList()
  {
    lista = new ArrayList<Movie>();
  }

  public void addMovie(Movie m)
  {
	lista.add(m.getId()-1, m);
  }
  
  public void delMovie(int in)
  {
	  try
	  {
		  lista.set(in-1, null);
	  }
	  catch(IndexOutOfBoundsException e)
	  {
		  out.printf("Nenhum filme para remover.\n");
	  }
  }

  public void movie(int id)
  {
	  Movie tmp;
	  try
	  {
		tmp = lista.get(id-1);  
		out.printf(tmp.toString());
	  }
	  catch (IndexOutOfBoundsException e)
	  {
		  out.print("Filme não existente\n");
	  }
  }
  
  public void movieDisponivel(int id)
  {
	  Movie tmp;
	  try
	  {
		  tmp = lista.get(id-1);
		  if (tmp.available())
			  out.printf("Filme disponível.\n");
		  else
			  out.printf("Filme não disponível.\n");
	  }
	  catch(IndexOutOfBoundsException e)
	  {
		  out.println("Filme não existente.");
	  }
  }
  
  public void movieDisplay(int age) 
  {
	  if (age >= 18)
	  {
		  out.println("Vídeos disponíveis: \n");
		  displayCat("ALL");
		  displayCat("M6");
		  displayCat("M12");
		  displayCat("M16");
		  displayCat("M18");
	  }
	  else if (age >= 16 && age < 18)
	  {
		  out.println("Vídeos disponíveis: \n");
		  displayCat("ALL");
		  displayCat("M6");
		  displayCat("M12");
		  displayCat("M16");
	  }
	  else if (age >= 12 && age < 16)
	  {
		  out.println("Vídeos disponíveis: \n");
		  displayCat("ALL");
		  displayCat("M6");
		  displayCat("M12");
	  }
	  else if (age >= 6 && age < 12) {
		  out.println("Vídeos disponíveis: \n");
		  displayCat("ALL");
		  displayCat("M6");
	  }
	  else
	  {
		  out.println("Vídeos disponíveis: \n");
		  displayCat("ALL");
	  }
  }
  
  private void displayCat(String age)
  {
	  out.printf("Categoria %s:\n", age);
	  Movie tmp;
	  for(int i = 0; i < lista.size(); i++)
	  {
		  try
		  {
			  tmp = lista.get(i);
			  if((tmp.getIdade()).equals(age))
				  out.print(tmp.toString());
		  }
		  catch (NullPointerException e)
		  {
			  ;
		  }
	  }
	  out.println();
  }

  public void replaceVid(Movie novo)
  {
	  lista.remove(novo.getId());
	  lista.add(novo.getId(), novo);
  }

  public Movie getMovieById(int id)
  {
	  return lista.get(id-1);
  }
  
  public int movieAmount()
  {
	  return lista.size();
  }
  
  public void showRated()
  {
	  Movie[] tmp = new Movie[lista.size()];
	  tmp = lista.toArray(tmp);
	  
	  boolean swap = true;
	  int i;
	  Movie temp;
	  do
	  {
		  swap = false;
		  for (i = 0; i < tmp.length - 1; i++)
		  {
			  if (tmp[i].compareTo(tmp[i+1]) < 0) 
			  {
				temp = tmp[i];
				tmp[i] = tmp[i+1];
				tmp[i+1] = temp;
				swap = false;
			  }
		  }
	  } while(swap);
	  
	  for(i = 0; i < tmp.length; i++)
	  {
		  out.println(tmp[i].toString());
	  }
  }
}