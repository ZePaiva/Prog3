package aula5.e3;

import java.io.*;
import java.util.*;
import aula1.e2.*;

public class CSV implements AgendaInterface
{
	public void saveAgenda(File file, Contacto[] contactos) throws IOException
	{
		PrintWriter printer = new PrintWriter(file);
		printer.println("CSV");
		for (Contacto contacto : contactos)
		{
			printer.print(contacto.getName() + "\t");
			printer.print(contacto.getNumb() + "\t");
			printer.println(contacto.getDateOfBirth());
		}
		printer.close();
	}
	
	public ArrayList<Contacto> loadAgenda(Scanner file) throws IOException
	{
		ArrayList<Contacto>l = new ArrayList<Contacto>();
		String linha[];
		int numb;
		String data[];
		while (file.hasNextLine())
		{
			linha = file.nextLine().split("\t");
			numb = Integer.parseInt(linha[1]);
			data = linha[2].split("/");
			l.add(new Contacto(linha[0], numb, new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]))));
		}
		return l;
	}
}
