package aula5.e3;

import java.io.*;
import java.util.*;
import aula1.e2.*;

public class Nokia implements AgendaInterface
{
	public void saveAgenda(File file, Contacto[] contactos) throws IOException
	{
		PrintWriter printer = new PrintWriter(file);
		printer.println("Nokia");
		for (Contacto contacto : contactos)
		{
			printer.println(contacto.getName());
			printer.println(contacto.getNumb());
			printer.println(contacto.getDateOfBirth());
		}
		printer.close();
	}
	
	public ArrayList<Contacto> loadAgenda(Scanner file) throws IOException
	{
		ArrayList<Contacto> l = new ArrayList<Contacto>();
		String nome;
		int numb;
		String data[];
		while (file.hasNextLine())
		{
			nome = file.nextLine();
			numb = Integer.parseInt(file.nextLine());
			data = file.nextLine().split("/");
			l.add(new Contacto(nome, numb, new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]))));
			if (file.hasNext())
				file.nextLine();
		}
		return l;
	}
}
