//-----------------------------------------------------
// Author: Efe Berk ERGÜLEÇ
// Description: This class is the tester class of RBT. 
//-----------------------------------------------------
import edu.princeton.cs.algs4.*;
import java.util.*;

public class RBTTester 
{
	public static void main(String[] args)
	{
		In csv = new In("starbucks.csv"); // Opens file
		int hash = 0;
		String str = "";
		String has = "";
		RBT<Integer, String> rbt = new RBT<Integer, String>(); // RBT variable
		Scanner keyboard = new Scanner(System.in);
		Out outp = new Out("output.csv"); // Converted file which I will use
		outp.printf("%20s ","latlon");
		outp.printf(";");
		outp.printf("%4s\n","city");
		
		while (csv.hasNextLine()) // Putting data to output.
        {
           String line = csv.readLine();
           String[] tokens = line.split(",");
           
           int len = tokens[2].indexOf(' ');
           if(len != -1 && tokens[2].charAt(0) == 'S')	
           {
               String val = tokens[0] + "," + tokens[1];
        	   str = tokens[2].substring(len, tokens[2].length());
        	   outp.printf("%s;%s\n", val, str);
//        	   StdOut.printf("%s %s\n", val, str);
           }
		}

		In csvO = new In("output.csv"); // I am using my output file there.
		
		while(csvO.hasNextLine())
		{
			String line = csvO.readLine();
			String[] tokens = line.split(";");
			String srr = tokens[1].substring(1, tokens[1].length());
			hash = hashCode(srr);
			rbt.put(hash, tokens[0]);
			//StdOut.printf("%s %s\n", tokens[0],hash);
		}
		StdOut.println("--------------------");
		StdOut.println("Please enter a city:");
		StdOut.println("--------------------");
		String inp = keyboard.nextLine();
		StdOut.println("--------------------");
		printAll(inp,rbt);
		
		keyboard.close();
	}
	// My method for printing all values. 
	private static void printAll(String inp, RBT<Integer, String> rbt) 
	{
		int hash2 = hashCode(inp);
		rbt.get(hash2);
	}
	// Horner's Method(I changed it a little bit)
	private static int hashCode(String str)
	{
		int hash = 0, len = str.length();
		char [] strm = new char[len];
		
		for(int i = 0; i < len; i++) // I'm doing this loop because I want 
			strm[i] = str.charAt(i); // to apply rules of Horner's Method
		
		for(int i = 0; i < len; i++)	
			hash = strm[i] + (31 * hash);
		return hash;
	}
}
