//-----------------------------------------------------
// Author: Efe Berk ERGÜLEÇ
// ID: 24191130360
// Assignment: 2
// Question: 1
// Description: Test class for sorting algorithms.
//-----------------------------------------------------
import java.util.*;
import edu.princeton.cs.algs4.*;

public class Test {
	public static void main(String[] args) 
	{
		Scanner keyb = new Scanner(System.in);
		Sorts linkedList = new Sorts();
		
		for (int i = 0; i < 10; i++) // Adds all numbers
		{
			Random rand = new Random();
			int number = rand.nextInt(101);
			
			linkedList.add(number);
		}
		
		linkedList.printAll();
		
		StdOut.println(
				"--------------------\n" +
				"|1- Produce numbers|\n" + 
				"|2- Selection sort |\n" + 
				"|3- Insertion sort |\n" + 
				"|4- Shell sort     |\n" + 
				"|5- Bubble Sort    |\n" + 
				"|6- Shuffle	   |\n" +
				"--------------------");
		
		StdOut.println("Welcome to sorting simulator! Please select one of the operations above:");
		int inp = keyb.nextInt();
		
		StdOut.println();
		
		if(inp == 1) // Standard print
		{
			linkedList.printAll();
		}
		else if(inp == 2) // Selection Sort
		{
			Sorts.selectionSort(linkedList);
		}
		else if(inp == 3) // Insertion Sort
		{
			Sorts.insertionSort(linkedList);
		}
		else if(inp == 4) // Shell Sort
		{
			Sorts.shellSort(linkedList);
		}
		else if(inp == 5) // Bubble Sort
		{
			Sorts.bubbleSort(linkedList);
		}
		else if(inp == 6) // Shuffle
		{
			Sorts.shuffle(linkedList);
		}
		else
		{
			StdOut.println("There isn't any option like that. Please try again!");
		}
		keyb.close();
	}

}
