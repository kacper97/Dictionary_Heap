package controllers;

import java.io.File;
import java.util.Scanner;

import utils.CSVLoader;
import utils.In;
import models.Pair;
import models.MaxHeap;

public class Exec {
	private Scanner input;
	private CSVLoader csv;
	private MaxHeap<Pair> pairs;
	
	public Exec()
	{
		input = new Scanner(System.in);
		csv = new CSVLoader();
		pairs = csv.loadSpanishWords("Data/SpanishWords.txt");
	}

	public static void main(String[] args) 
	{
		Exec app = new Exec();
		app.runMain();
	}
	
	private int mainMenu(){
		System.out.println(" Translator");
		System.out.println(" 1) Add a pairing to Heap");
		System.out.println(" 2) Get Translation");
		System.out.println(" 3) Save List");
		System.out.println(" 4) Read in");
		System.out.println(" 0) Exit");
        int option = input.nextInt();
        return option;
    }
	
	private void runMain()
	{
		int option = mainMenu();
		while (option !=0)
		{
			switch (option)
			{
			case 1: addPairing();
				break;
			//case 2: getTranslation();
			//	break;
			case 3: saveToFile();
				break;
			case 4: pairs=readIn();
				break;
			default: System.out.println(" Enter a valid option");
			break;
			}
			option = mainMenu();
		}
	}
			private MaxHeap<Pair> readIn() {
		// TODO Auto-generated method stub
			
					File pairFile = new File("SpanishWords.txt");
					In inPairs = new In(pairFile);
					
					String delims = "    "; // splits it using a space
					MaxHeap<Pair> pairs = new MaxHeap<Pair>();
					while(!inPairs.isEmpty())
					{
						String pair = inPairs.readLine();
						String[] pairTokens = pair.split(delims);
						if (pairTokens.length == 2)
						{
							String spanish = pairTokens[0];
							String english = pairTokens[1];
							
							pairs.add(new Pair(spanish, english));
						}
					}
					System.out.println(pairs);
					return pairs;
			
	}

			private void saveToFile() {
		// TODO Auto-generated method stub
		
	}

		/*	
			// this method searches through the heap.
			private void getTranslation() {
				// TODO Auto-generated method stub
				System.out.println("Enter a Spanish word to search for");
				String spanishWord = input.nextLine();
				//if (spanishWord == null) {
				//System.out.println("Could not find the translation!");
				// else {
					//System.out.println(spanishWord.toString());
			//	System.out.println(Pair.toString());
			 * 
				}			
				}
			}
			*/
			
			private void addPairing() {
		// TODO Auto-generated method stub
		System.out.println("Please enter Spanish: ");
		System.out.println("--->");
		String spanish = input.nextLine();
		spanish = input.nextLine(); 
		System.out.println("Please enter English: ");
		String english = input.next();
		Pair pair = new Pair(spanish, english);
		pairs.add(pair);
		System.out.println(pair.toString());
	}
			
		
}