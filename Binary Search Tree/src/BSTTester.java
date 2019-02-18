import edu.princeton.cs.algs4.*;
//-----------------------------------------------------
// Author: Efe Berk ERGÜLEÇ
// Description: This class defines a BST
//-----------------------------------------------------

public class BSTTester 
{
	public int N = 1;
	public static int LEN = 65538;
	
	public static void main(String[] args) 
	{
		// My array implementations written below.
		String [] names = { "AHMET EFE", "ALI ARDA", "ALPEREN", "ARDA", "ATAHAN", "AYCEM", "BASAKO", "BASAKS", "BENGISU",
				"BERKE", "CIHAD", "EDIPCAN", "EGEMEN", "ENES", "EREN", "ESIN", "EYLUL ALEYNA", "FATMA OZGE", "GULFEM",
				"KEMAL MERT", "MEHMET CEM", "MERT", "MERVE", "MINA EKIN", "MUSTAFA MERT", "ONUR", "SERTAC", "SINAN" };
		
		int [] ages = {23, 24, 19, 23, 22, 21, 20, 18, 22, 23, 19, 20, 20, 21, 23, 18, 24, 19, 19, 20, 20, 18, 23, 24, 21, 24, 23, 21};
		
		String rootName = "EFE BERK";
		int rootAge = 23;
		
		String[] bstNames = new String[LEN]; // I created both of them like that because my
		int [] bstAges = new int[LEN];		 // tree can have both best and worst case.
		
		int count = 0;
		
		bstNames[count] = null; // I arrange 0th element to empty in both arrays
		bstAges[count] = 0;     // because we can't control BST if we don't do that.
		
		count++;
		
		bstNames[count] = rootName; // Root of my String BST.
		bstAges[count] = rootAge;   // Root of my Integer BST.
		
		for (int i = 0; i < names.length; i++)
		{ // I took this method froml our book for shuffling arrays
			int r = StdRandom.uniform(i + 1);
			exch(names, i, r);
			exch(ages, i, r);
		}
		
		StdOut.println("----------------------");
		
		for(int i = 0;i < ages.length; i++) // Prints all names and their ages after shuffling.
			StdOut.printf("%-8s\t%-3d\n", names[i], ages[i]);
		
		for (int i = 0; i < names.length; i++) // Puts all names and their ages to BST.
		{
			put(bstNames, names[i], bstAges, ages[i]);
		}
		
		StdOut.println("----------------------");
		
		// PRINT BST
		print(bstNames, bstAges, 1);
		
		StdOut.println("----------------------");
		
		// GET ELEMENT
		int r = StdRandom.uniform(ages.length);
		int value = get(bstNames, bstAges, names[r]);
		StdOut.printf("Age of %s is %d.\n", names[r], value);
		
		StdOut.println("----------------------");
		
		// DELETE ELEMENT
		r = StdRandom.uniform(ages.length);
		delete(bstNames, bstAges, names[r]);
		StdOut.println(names[r] + " deleted.");
		
		StdOut.println("----------------------");
		
		print(bstNames, bstAges, 1);
		
		StdOut.println("----------------------");
	}
	// Puts my values in String and Integer array.
	public static void put(String [] bstN, String name, int [] bstA, int a)
	{
		int i = 1;
		while(i < LEN)
		{
			if(bstN[i] == null)
			{
				bstN[i] = name;
				bstA[i] = a;
				break;
			}
			else if(less(name, bstN[i]))	i = 2 * i;
			else if(less(bstN[i], name))	i = 2 * i + 1;
		}
	}
	// Gets value in BST.
	public static int get(String [] nameArr, int [] ageArr, String name)
	{
		String nameRoot = name;
		int val = 0;
		int N = 1;
		while(N < LEN)
		{
			if(nameRoot.compareTo(nameArr[N]) == 0)
			{
				val = ageArr[N];
				return val;
			}
			else if(nameRoot.compareTo(nameArr[N]) > 0)
				N = 2*N + 1;
			else
				N = 2 * N;
		}
		return val;
	}
	// Deletes value in BST.
	public static void delete(String [] nameArr, int [] ageArr, String name)
	{
		String nameRoot = name;
		int N = 1;
		boolean isFound = true;
		while(isFound)
		{
			if(nameRoot.compareTo(nameArr[N]) == 0)
			{
				nameRoot = name;
				nameArr[N] = null;
				isFound = false;
			}
			else if(nameRoot.compareTo(nameArr[N]) > 0)
				N = 2*N + 1;
			else
				N *= 2;
		}
		int index = ((2 * N) + 1);
		restore(nameArr, ageArr, index);
	}
	// Finds minimum value in restricted area.
	private static void findMin(String[] nameArr, int rootN, int N) 
	{
		if(nameArr[2 * N] == null)
		{
			while(rootN < N) // Changes values.
			{
				exch(nameArr, N, N / 2);
				N = N / 2;
			}
		}
		else
			findMin(nameArr, rootN, (2 * N));
	}
	// Restores whole BST
	private static void restore(String[] nameArr, int[] ageArr, int N) 
	{
		int index = ((2 * N) + 1);
		nameArr[N / 2] = nameArr[N];
		ageArr[N / 2] = ageArr[N];
		nameArr[N] = null;
		ageArr[N] = 0;
		// If both of leaves exists.
		if(nameArr[2 * N] != null && nameArr[(2 * N) + 1] != null)
		{
			restore(nameArr, ageArr, ((2 * N) + 1)); 
		}	
		// If (2 * N) exists.
		else if(nameArr[2 * N] != null && nameArr[(2 * N) + 1] == null)
		{	
			findMin(nameArr, index, index);
			restore(nameArr, ageArr, (2 * N));	
		}
		// If ((2 * N) + 1) exists.
		else if(nameArr[2 * N] == null && nameArr[(2 * N) + 1] != null)
		{	
			restore(nameArr, ageArr, ((2 * N) + 1));	
		}
	}
	//Prints all 
	public static void print(String [] nameArr, int [] numArr, int num)
	{
		if(nameArr[num] == null)	return;
		print(nameArr, numArr, 2 * num);
		StdOut.printf("%-13s ==> %4d\n",nameArr[num], numArr[num]);
		print(nameArr, numArr, ((2 * num) + 1));
	}
	// I took this methods from our lecture book for using in my
	// method definitions.
	private static boolean less(String name, String str) 
	{
		return name.compareTo(str) < 0;
	}
	private static void exch(String[] names, int i, int r) 
	{
		String temp = names[i];
		names[i] = names[r];
		names[r] = temp;
	}
	private static void exch(int[] ages, int i, int r) 
	{
		int temp = ages[i];
		ages[i] = ages[r];
		ages[r] = temp;
	}
}
