package utils;
//CSV LOADER FILE THAT I HAVE USED IN A PREVIOUS ASSIGMENT YET NOT IMPLEMENTED
import java.io.File;

import models.MaxHeap;
import models.Pair;
public class CSVLoader {
	
	public MaxHeap<Pair> loadSpanishWords(String filename)
	{
		File pairFile = new File(filename);
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

}