


import java.util.ArrayList;

import general.definition.*;


public class Main {

	public static void main(String []args) {



		int sizeTab = 5000000;

		int [] tab;

		tab = new int[sizeTab];

		for (int i = 0; i < sizeTab; i++) {
			tab[i] = (int) (Math.random() * 21);
		}
	


		/*

		// BenchMarking for insert

		System.out.println("N\tList\tData");


		for (int i = 10000; i < sizeTab; i += 10000) {

			Data<Integer> aData = new Data<Integer>();
			ArrayList<Integer> aList = new ArrayList<Integer>();

			System.out.print(i + "\t");

			long start = System.nanoTime();

			for (int j = 0; j < i; j++) {
				aList.add(tab[j]);
			}

			long end = System.nanoTime();

			System.out.print(((end - start)/(10^9)) + "\t");

			start = System.nanoTime();

			for (int j = 0; j < i; j++) {
				aData.insert(tab[j]);
			}
			
			end = System.nanoTime();
			System.out.println(((end - start)/(10^9)));
		}

		 */






		/*
		// BenchMarking for removeAll

		System.out.println("N\tList\tData");


		for (int i = 10000; i < sizeTab; i += 10000) {

			Data<Integer> aData = new Data<Integer>();
			ArrayList<Integer> aList = new ArrayList<Integer>();

			System.out.print(i + "\t");

			for (int j = 0; j < i; j++) {
				aList.add(tab[j]);
				aData.insert(tab[j]);
			}

			ArrayList<Integer> lista = new ArrayList<Integer>();

			lista.add(tab[(int)(Math.random() * i + 1)]);

			long start = System.nanoTime();
			aList.removeAll(lista);
			long end = System.nanoTime();

			System.out.print(((end - start)/(10^9)) + "\t");



			start = System.nanoTime();		
			aData.removeAll(lista.get(0));
			end = System.nanoTime();

			System.out.println(((end - start)/(10^9)));
		}
		 */

		// BenchMarking for remove

		System.out.println("N\tList\tData");


		for (int i = 10000; i < sizeTab; i += 10000) {

			Data<Integer> aData = new Data<Integer>();
			ArrayList<Integer> aList = new ArrayList<Integer>();

			System.out.print(i + "\t");

			for (int j = 0; j < i; j++) {
				aList.add(tab[j]);
				aData.insert(tab[j]);
			}

			ArrayList<Integer> lista = new ArrayList<Integer>();

			lista.add(tab[(int)(Math.random() * i + 1)]);

			long start = System.nanoTime();
			aList.remove(lista.get(0));
			long end = System.nanoTime();

			System.out.print(((end - start)/(10^9)) + "\t");



			start = System.nanoTime();		
			aData.remove(lista.get(0));
			end = System.nanoTime();

			System.out.println(((end - start)/(10^9)));
		}


	}


}
