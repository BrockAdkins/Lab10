package SearchSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		
		List<String> ignoreAll= Arrays.asList("and","it", "a", "on", "in", "the");
		String words = null;
		int cont = 0;
		
		
		ArrayList <String> al1 = new ArrayList<String>();
		ArrayList <String> al2 = new ArrayList<String>();
		ArrayList <String> coyotetop10 = new ArrayList<String>();
		ArrayList <String> bvtop10 = new ArrayList<String>();
		

		DecimalFormat df = new DecimalFormat("0.0000");

		
		File myFile = new File("./src/Coyote.txt");
		
		Scanner myFileScanner = new Scanner(myFile);
		
		while(myFileScanner.hasNextLine())
		{
			String line  = myFileScanner.nextLine();
			
			
			while(myFileScanner.hasNext()) {
				words = myFileScanner.next().trim();
				words = words.replaceAll("\\W", "");
		        words = words.toLowerCase();
		        
		        if(ignoreAll.contains(words)){
	                 continue;

	            }
		        else {
		        	al1.add(words);
		        	//System.out.println(al1);
		        	
		        	
		        }
		        	
				
			}
			
			
		}
		//System.out.println(al1);
		
		String[] coyote = new String[al1.size()];
		
		for (int i = 0; i < al1.size(); i++) {
			coyote[i] = al1.get(i);
			
		}
		

		
		//Sorting.insertionSort(coyote);
		Sorting.selectionSort(coyote);
		//System.out.println(Arrays.toString(coyote));
		
		System.out.println("Top 10 Words in the Coyote.txt Document:");
		int count = 1;
		for (int j = 0; j < coyote.length; j++) {
			if (j == 0) {
				count = 1;
			}
			if (j >1) {
				if (coyote[j].equals(coyote[j-1])) {

					//System.out.println(coyote[j] + ": " + count);
					count += 1;

					if (count >= 11 && !coyote[j].equals(coyote[j+1])) {
						double percentage = ((double)count/coyote.length)*100;
						

						System.out.println(coyote[j] + ": " + count + " times (" + df.format(percentage) + "% of all words)");
						coyotetop10.add(coyote[j]);
					}
				}
				else {
					count = 1;
				}
			}

		}		
		
		File myFile2 = new File("./src/CoyoteAndTheBitterrootValley.txt");
		
		Scanner myFileScanner2 = new Scanner(myFile2);
		
		while(myFileScanner2.hasNextLine())
		{
			String line  = myFileScanner2.nextLine();
			
			
			while(myFileScanner2.hasNext()) {
				words = myFileScanner2.next().trim();
				words = words.replaceAll("\\W", "");
		        words = words.toLowerCase();
		        
		        if(ignoreAll.contains(words)){
	                 continue;

	            }
		        else {
		        	al2.add(words);
		        	//System.out.println(al1);
		        	
		        	
		        }
		        	
				
			}
			
			
		}
		//System.out.println(al1);
		
		String[] bv = new String[al2.size()];
		
		for (int i = 0; i < al2.size(); i++) {
			bv[i] = al2.get(i);
			
		}
		

		
		//Sorting.insertionSort(coyote);
		Sorting.selectionSort(bv);
		//System.out.println(Arrays.toString(coyote));
		
		System.out.println("\nTop 10 Words in the CoyoteAndTheBitterrootValley.txt Document:");
		count = 1;
		for (int j = 0; j < bv.length; j++) {
			if (j == 0) {
				count = 1;
			}
			if (j >1) {
				if (bv[j].equals(bv[j-1])) {

					//System.out.println(coyote[j] + ": " + count);
					count += 1;

					if (count >= 13 && !bv[j].equals(bv[j+1])) {
						double percentage = ((double)count/bv.length)*100;
						

						System.out.println(bv[j] + ": " + count + " times (" + df.format(percentage) + "% of all words)");
						bvtop10.add(bv[j]);
					}
				}
				else {
					count = 1;
				}
			}
			
		}
		System.out.println("\nShared Top Ten Words");
		for (int k = 0; k<coyotetop10.size(); k++) {
			for(int l = 0; l<bvtop10.size(); l++) {
				if (bvtop10.get(l).equals(coyotetop10.get(k))) {
					System.out.println(coyotetop10.get(k));
				}
			}
			
		}
		while (cont >=0) {
			System.out.println("What word would you like to search for?");
			Scanner scan = new Scanner(System.in);
			String wordSearch = scan.nextLine();
			wordSearch = wordSearch.toLowerCase();
			int numWords = 0;
			for (int m = 0; m < coyote.length; m++) {
				if (wordSearch.equals(coyote[m])) {
					numWords +=1;
				}
			}
			System.out.println(wordSearch + " was used " + numWords + " times in the Coyote.txt document");
			numWords = 0;
			for (int n = 0; n < bv.length; n++) {
				if (wordSearch.equals(bv[n])) {
					numWords +=1;
				}
			}
			System.out.println(wordSearch + " was used " + numWords + " times in the CoyoteAndTheBitterrootValley.txt document");
			cont +=1;
		}
	}

}
