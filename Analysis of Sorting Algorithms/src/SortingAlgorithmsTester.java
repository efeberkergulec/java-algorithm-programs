import edu.princeton.cs.algs4.*;
//-----------------------------------------------------
// Title: Sorting Algorithms Tester
// Description: This class tests the orders of all sorts
//-----------------------------------------------------
public class SortingAlgorithmsTester {
	public static void main(String[] args) {
		// int[] orders = { 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000, 100000, 200000 };
		int[] orders = {1000,2000,4000,8000,16000,32000,64000,128000,256000,512000};
		// int[] orders = {5};
		
		StdOut.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		StdOut.printf("||||||||||");
		StdOut.printf("|  		        ASCENDING ORDER   	    	      ");
		StdOut.printf("|  		     DESCENDING ORDER  	                  ");
		StdOut.printf("|  		             SHUFFLE  		              |\n");
		StdOut.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		StdOut.printf("|  INDEX  ");
		for(int k = 1; k < 4; k++)
			for(int l = 1;l < 6; l++)
				StdOut.printf("|   SORT %d  ",l);
		
		StdOut.println("|\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		for (int j = 0; j < orders.length; j++) {
			int sd = orders[j];
			long[] arr = new long[orders[j]];
			long ef = 10000000000L;
			long id = 24191130360L;
			arr[0] = id;
			
			for (int i = 1; i < orders[j]; i++) 
			{ // It instantiates array indexes
				arr[i] = ef;
				ef += (90000000000L) / orders[j];
			}
			
			sort(arr); // I did this sort because I need to place arr[0] into true index
			
			/* for (int i = 0; i < arr.length; i++) 
			{
				StdOut.printf(arr[i] + "->");
			}
			StdOut.println(); */ // This loop prints array by ascending order
			
			StdOut.printf("| %7d ",orders[j]);

			Stopwatch s01 = new Stopwatch(); //These are stopwatches. I created them to estimate times.
			SortingAlgorithms.sort1(arr, id);
			StdOut.printf("| %9.5f ",s01.elapsedTime());

			Stopwatch s02 = new Stopwatch();
			SortingAlgorithms.sort2(arr, id);
			StdOut.printf("| %9.5f ",s02.elapsedTime());

			Stopwatch s03 = new Stopwatch();
			SortingAlgorithms.sort3(arr, id);
			StdOut.printf("| %9.5f ",s03.elapsedTime());

			Stopwatch s04 = new Stopwatch();
			SortingAlgorithms.sort4(arr, id);
			StdOut.printf("| %9.5f ",s04.elapsedTime());

			Stopwatch s05 = new Stopwatch();
			SortingAlgorithms.sort5(arr, id);
			StdOut.printf("| %9.5f ",s05.elapsedTime());
			
			long[] arr1 = new long[orders[j]];
			
			for (int i = 0; i < orders[j]; i++) 
			{ // It instantiates array indexes from ascending to descending
				arr1[i] = arr[sd-1-i];
			}

			/* for (int i = 0; i < arr.length; i++) 
			{
				StdOut.printf(arr1[i] + "->");
			}
			StdOut.println(); */ // This loop prints array by descending order
			
			arr = arr1;
			
			Stopwatch s11 = new Stopwatch();
			SortingAlgorithms.sort1(arr1, id);
			StdOut.printf("| %9.5f ",s11.elapsedTime());

			arr1 = arr;
			
			Stopwatch s12 = new Stopwatch();
			SortingAlgorithms.sort2(arr1, id);
			StdOut.printf("| %9.5f ",s12.elapsedTime());

			arr1 = arr;

			Stopwatch s13 = new Stopwatch();
			SortingAlgorithms.sort3(arr1, id);
			StdOut.printf("| %9.5f ",s13.elapsedTime());

			arr1 = arr;

			Stopwatch s14 = new Stopwatch();
			SortingAlgorithms.sort4(arr1, id);
			StdOut.printf("| %9.5f ",s14.elapsedTime());

			arr1 = arr;

			Stopwatch s15 = new Stopwatch();
			SortingAlgorithms.sort5(arr1, id);
			StdOut.printf("| %9.5f ",s15.elapsedTime());

			long[] arr2 = new long[orders[j]];

			for (int i = 0; i < orders[j]; i++)
			{ // I took this method for shuffling arrays
				int r = StdRandom.uniform(i + 1);
				exch(arr, i, r);
			}
			
			arr2 = arr;
			
			/* for (int i = 0; i < arr.length; i++) {
				StdOut.printf(arr2[i] + "->");
			}
			StdOut.println(); */ // Prints array by random indexes
			
			Stopwatch s21 = new Stopwatch();
			SortingAlgorithms.sort1(arr2, id);
			StdOut.printf("| %9.5f ",s21.elapsedTime());

			arr2 = arr;

			Stopwatch s22 = new Stopwatch();
			SortingAlgorithms.sort2(arr2, id);
			StdOut.printf("| %9.5f ",s22.elapsedTime());

			arr2 = arr;

			Stopwatch s23 = new Stopwatch();
			SortingAlgorithms.sort3(arr2, id);
			StdOut.printf("| %9.5f ",s23.elapsedTime());

			arr2 = arr;

			Stopwatch s24 = new Stopwatch();
			SortingAlgorithms.sort4(arr2, id);
			StdOut.printf("| %9.5f ",s24.elapsedTime());

			arr2 = arr;

			Stopwatch s25 = new Stopwatch();
			SortingAlgorithms.sort5(arr2, id);
			StdOut.printf("| %9.5f ",s25.elapsedTime());

			StdOut.printf("|\n");
		}
		StdOut.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	}

	private static void sort(long[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++)
		{
			int min = i;
			for (int j = i+1; j < N; j++)
				if (a[j] < a[min])
					min = j;
			exch(a, i, min);
		}
	}

	private static void exch(long[] arr, int i, int r) {
		long temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;
	}
}
