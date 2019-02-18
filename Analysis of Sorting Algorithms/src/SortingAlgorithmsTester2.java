import edu.princeton.cs.algs4.*;
//-----------------------------------------------------
// Title: Sorting Algorithms Tester
// Author: Efe Berk ERGÜLEÇ
// ID: 24191130360
// Assignment: 3
// Description: This class tests the orders of sort3 and sort4
//-----------------------------------------------------
public class SortingAlgorithmsTester2 {
	public static void main(String[] args) {
		int[] orders = {1000,2000,4000,8000,16000,32000,64000,128000,256000,512000,1024000,2048000,4096000,8192000,16384000,32768000};
		
		StdOut.println("------------------------------------------------------------------------------------");
		StdOut.printf("|||||||||||");
		StdOut.printf("|    ASCENDING ORDER    ");
		StdOut.printf("|    DESCENDING ORDER   ");
		StdOut.printf("|        SHUFFLE        |\n");
		StdOut.println("------------------------------------------------------------------------------------");
		StdOut.printf("|   INDEX  ");
		for(int k = 1; k < 4; k++)
			for(int l = 3;l < 5; l++)
				StdOut.printf("|   SORT %d  ",l);
		
		StdOut.println("|\n------------------------------------------------------------------------------------");
		
		for (int j = 0; j < orders.length; j++) {
			int sd = orders[j];
			long[] arr = new long[orders[j]];
			long ef = 10000000000L;
			long id = 24191130360L;
			arr[0] = id;
			
			for (int i = 1; i < orders[j]; i++) {
				arr[i] = ef;
				ef += (90000000000L) / orders[j];
			}
			
			sort(arr);
			
			/* for (int i = 0; i < arr.length; i++) {
				StdOut.printf(arr[i] + "->");
			}
			StdOut.println(); */
			
			StdOut.printf("| %8d ",orders[j]);

			Stopwatch s03 = new Stopwatch(); //These are stopwatches. I created them to estimate times.
			SortingAlgorithms.sort3(arr, id);
			StdOut.printf("| %9.5f ",s03.elapsedTime());

			Stopwatch s04 = new Stopwatch();
			SortingAlgorithms.sort4(arr, id);
			StdOut.printf("| %9.5f ",s04.elapsedTime());

			long[] arr1 = new long[orders[j]];
			
			for (int i = 0; i < orders[j]; i++) {
				arr1[i] = arr[sd-1-i];
			}

			/* for (int i = 0; i < arr.length; i++) {
				StdOut.printf(arr1[i] + "->");
			}
			StdOut.println(); */
			
			arr = arr1;

			Stopwatch s13 = new Stopwatch();
			SortingAlgorithms.sort3(arr1, id);
			StdOut.printf("| %9.5f ",s13.elapsedTime());

			arr1 = arr;

			Stopwatch s14 = new Stopwatch();
			SortingAlgorithms.sort4(arr1, id);
			StdOut.printf("| %9.5f ",s14.elapsedTime());

			long[] arr2 = new long[orders[j]];

			for (int i = 0; i < orders[j]; i++)
			{
				int r = StdRandom.uniform(i + 1);
				exch(arr, i, r);
			}
			
			arr2 = arr;
			
			/* for (int i = 0; i < arr.length; i++) {
				StdOut.printf(arr2[i] + "->");
			}
			StdOut.println(); */
			
			Stopwatch s23 = new Stopwatch();
			SortingAlgorithms.sort3(arr2, id);
			StdOut.printf("| %9.5f ",s23.elapsedTime());

			arr2 = arr;

			Stopwatch s24 = new Stopwatch();
			SortingAlgorithms.sort4(arr2, id);
			StdOut.printf("| %9.5f ",s24.elapsedTime());
			
			StdOut.printf("|\n");
		}
		StdOut.println("------------------------------------------------------------------------------------\n");
	}

	/*
	 * I TOOK ALL METHODS AT BELOW FROM ALGORITHM BOOK
	 */
	
	public static void sort(long[] a)
    {
		for (int i = 0; i < a.length; i++)
		{
			int r = StdRandom.uniform(i + 1);
			exch(a, i, r);
		}         
       sort(a, 0, a.length - 1);
    }
	
    private static void sort(long[] a, int lo, int hi)
    {
       if (hi <= lo) return;
       int j = partition(a, lo, hi);  
       sort(a, lo, j-1);              
       sort(a, j+1, hi);              
    }
    
    private static int partition(long[] a, int lo, int hi) 
	{ 
		int i = lo, j = hi + 1; 
		long v = a[lo]; 
		while (true) 
		{ 
			while (a[++i] < v)
				if (i == hi)
					break;
			while (v < a[--j])
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	private static void exch(long[] arr, int i, int r) {
		long temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;
	}
}