package aula12.e3.plugins;

import aula1.e2.Data;
import aula12.e3.Contacto;
import aula12.e3.Plugin;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSV implements Plugin {
	@Override
	public ArrayList<Contacto> loadFile(Scanner file) throws IOException {
		ArrayList<Contacto> contacts = new ArrayList<>();
		String linha[];
		int numb;
		String data[];
		while (file.hasNextLine())
		{
			linha = file.nextLine().split("\t");
			numb = Integer.parseInt(linha[1]);
			data = linha[2].split("/");
			contacts.add(new Contacto(linha[0], 0, new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])), numb));
		}
		return contacts;
	}

	@Override
	public void saveFile(String file, List<Contacto> contactos) throws FileNotFoundException {
		PrintStream fix = new PrintStream(file);
		fix.println("CSV");
		contactos.parallelStream()
				.forEach(f -> fix.printf("%s\t%s\t%s\n", f.getName(), f.getNumb(), f.getDateOfBirth()));
	}
}
