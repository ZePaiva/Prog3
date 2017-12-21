package aula12.e3.plugins;

import aula1.e2.Data;
import aula12.e3.Contacto;
import aula12.e3.Plugin;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nokia implements Plugin {
	@Override
	public ArrayList<Contacto> loadFile(Scanner file) throws IOException {
		ArrayList<Contacto> contactos = new ArrayList<>();
		int i = 0;
		String linha;
		String nome = "nome";
		int num = 0;
		String dof[];
		while (file.hasNextLine())
		{
			linha = file.nextLine();
			switch (i % 4) {
				case 0:
					nome = linha;
					break;
				case 1:
					num = Integer.parseInt(linha);
					break;
				case 2:
					dof = linha.split("/");
					contactos.add(new Contacto(nome, 0, new Data(Integer.parseInt(dof[0]), Integer.parseInt(dof[1]), Integer.parseInt(dof[2])), num));
					break;
				default:
					break;
			}
			i++;
		}

		return contactos;
	}

	@Override
	public void saveFile(String file, List<Contacto> contactos) throws FileNotFoundException {
		PrintStream fix = new PrintStream(file);
		fix.println("Nokia");
		contactos.stream()
				.forEach(f -> fix.printf("%s\n%s\n%s\n\n", f.getName(), f.getNumb(), f.getDateOfBirth()));
	}
}