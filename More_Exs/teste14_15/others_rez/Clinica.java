package teste;
import java.util.*;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.io.Serializable;


public class Clinica implements Serializable{
	private static final long serialVersionUID = 75264722956L; 
	private String nome;
	private ListaGeneric<Mobiliario> mobiliario = new ListaGeneric<>();
	
	public Clinica(String n) {
		nome = n;
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public ListaGeneric<Mobiliario> getMobiliario() {
		return mobiliario;
	}
	
	public boolean addMobiliario(Mobiliario m) {
		if(mobiliario.contains(m))
			return false;
		mobiliario.addElem(m);
		return true;
	}
	
	public boolean removeMobiliario(Mobiliario m) {
		if(!mobiliario.contains(m))
			return false;
		mobiliario.removeElem(m);
		return true;
	}
	
	public List<Transporte> listTransportes() {
		List<Mobiliario> tmp = new LinkedList<>();
		List<Mobiliario> mob = mobiliario.toList();
		for(Mobiliario m: mob) {
			if(m instanceof Transporte) {
				tmp.add(m);
			}
		}
			
		List<Transporte> transp = new LinkedList<>();
		tmp.forEach(m -> transp.add((Transporte)m));
		return transp;
	}
	
	
	public MyRangeIterator<Mobiliario> iterator() {
		return new ListaIterator();
	}
	private class ListaIterator implements MyRangeIterator<Mobiliario>{
		int i;
		
		public ListaIterator() {
			i=0;
		}
		
		public boolean hasNext() {
			if(i < mobiliario.totalElem())
				return true;
			return false;
		}
		
		public Mobiliario next() {
			if(hasNext()) {
				Mobiliario m = mobiliario.get(i);
				i++;
				return m;
			}
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void saveClinica(String file) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(this);
		out.close();
		FileWriter outp = new FileWriter(new File("smth.txt"));
		outp.write(this.toString());
		outp.close();
		
		List<String> ls = Files.readAllLines(Paths.get("C:/Users/amargs/Dropbox/NucleoCoro/Casamentos/Cartões_Casamentos.docx"));
		ls.stream().map(e -> e.split("[_=.]")).flatMap(Arrays::stream).collect(Collectors.toList());
		ls.forEach(f -> System.out.println(f));
		ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("great.txt"));
		fout.writeObject(ls);
		fout.close();

	}
	
	public Clinica rescueClinica(String file) throws IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		return (Clinica)in.readObject();
	}


	@Override
	public String toString() {
		return "Clinica [nome=" + nome + ", mobiliario=" + mobiliario + "]";
	}
	

}
