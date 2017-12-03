package aula10.e2;

import aula3.e2.*;
import java.util.*;

public class Teste {
	public static void main(String[] args) { 
		BinarySearchTree<Figura> bst = new BinarySearchTree<Figura>(); 
		
		bst.insert(new Circulo (1,3, 1));
		bst.insert(new Circulo (1,5, 1));
		bst.insert(new Quadrado(3,4, 2));
		bst.insert(new Retangulo(1,2, 2,5));
		
		Iterator<Figura> it = bst.iterator();
		printSet(it);
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(bst.iterator()));
	}
	
	private static <T> double sumArea(Iterator<T> it) {
		double sum = 0;
		try{
			while(it.hasNext()){
				sum += ((Figura)(it.next())).area();
			}
		}catch(ClassCastException e){
			e.printStackTrace();
		}
		return sum;
	}

	private static <T> void printSet(Iterator<T> iterator) {
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}