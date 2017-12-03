package aula11.e1;

import java.util.stream.*;
import java.util.Map.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import aula1.e2.*;
import aula3.e2.*;

public class MainCode
{
	public static void main(String[] args) 
		throws IOException {
		// 11.1.a)
		List<Pessoa> vp = new ArrayList<Pessoa>();
		for (int i=0; i<10; i++)
			vp.add(new Pessoa("Bebé no Vector "+i,
					1000+i, Data.today()));
		
		Iterator<Pessoa> vec = vp.iterator();
		printSet(vp.iterator());
		
		List<Pessoa> lp = new LinkedList<Pessoa>();
		while ( vec.hasNext() )
			lp.add( vec.next() );
		
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		List<Figura> figList = new LinkedList<Figura>();
		figList.add(new Circulo (1,3, 1));
		figList.add(new Quadrado(3,4, 2));		
		figList.add(new Retangulo(1,2, 2,5));
		
		printSet(figList.iterator());
		
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));

		// Partindo do principio que Quadrado extends Rectangulo:
		List<Retangulo> quadList = new LinkedList<Retangulo>();
		quadList.add(new Quadrado(3,4, 2));
		quadList.add(new Retangulo(1,2, 2,5));
		System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));

		// 11.1.b)
		HashSet<String> set = new HashSet<>();
		Path file = Paths.get("SampleTextFile_10kb.txt");
		System.out.println(file.toAbsolutePath().toString());
		List<String> linhas = Files.readAllLines(file);
		String line[];
		int total_words = 0;
		for(String linha : linhas)
		{
			line = linha.split(" ");
			for (String word : line) 
			{
				total_words++;
				if(!set.contains(word))
					set.add(word);
			}
		}
		
		System.out.println("Número Total de Palavras: " + total_words);
		System.out.println("Número de Diferentes Palavras: " + set.size());
		
		// 11.1.c)
		HashMap<String, Integer> set2 = new HashMap<>();
		linhas = Files.readAllLines(file);
		for(String linha : linhas)
		{
			line = linha.split(" ");
			for (String word : line) 
				if(!set2.containsKey(word))
					set2.put(word, 1);
				else
					set2.put(word, set2.get(word) + 1);
		}

		for(String key : set2.keySet())
			System.out.println(key + "\t" + set2.get(key));
		
		// 11.1.d)
		TreeMap<String, Integer> tree = new TreeMap<>(Comparator.naturalOrder());
		linhas = Files.readAllLines(file);
		for(String linha : linhas)
		{
			line = linha.split(" ");
			for (String word : line) 
				if(!tree.containsKey(word))
					tree.put(word, 1);
				else
					tree.put(word, tree.get(word) + 1);
		}

		for(String key : tree.keySet())
			System.out.println(key + "\t" + tree.get(key));

		
		// 11.1.e)
		// e)c)
		System.out.println(set2.keySet().stream().map(key -> key + "\t" + set2.get(key)).collect(Collectors.joining("\n")));
		
		// e)d)
		System.out.println(tree.keySet().stream().map(key -> key + "\t" + tree.get(key)).collect(Collectors.joining("\n")));
	}
	
	public static double sumArea(List<? extends Figura> list)
	{
		double sum = 0;
		for (Figura fig : list)
		{
			sum += fig.area();
			System.out.println(fig);
		}
		
		return sum;
	}
	
	public static <T> void printSet(Iterator<T> iter)
	{
		while(iter.hasNext())
			System.out.println(iter.next());
	}
}
