import java.util.Scanner;
//----------------------------------------------------- 
//Author: Efe Berk ERGÜLEÇ 
//ID: 24191130360 
//Assignment: 1 
//Question: 2 
//Description: It's the test class for my Stack list 
//implementation
//----------------------------------------------------- 
public class TestForStack 
{
	public static void main(String[] args) {
		Stack a = new Stack();
		
		a.push("1");
		a.push("2");
		a.push("3");
		a.push("7");
		a.push("8");
		a.push("9");
		a.pop();
		System.out.println("------------------------------------");
		a.push("10");
		a.print();
		System.out.println("------------------------------------");
		a.pop();
		a.pop();
		a.pop();
		a.print();
		System.out.println("------------------------------------");
		a.push("4");
		a.push("5");
		a.push("6");
		a.push("7");
		a.print();
		System.out.println("------------------------------------");
		Scanner keyb = new Scanner(System.in);
		System.out.println("Please enter a number between 1 and " + a.size() + ":");
		String num = keyb.next();	// You can enter any number between 1 and N. It will work.
		System.out.println("------------------------------------");
		Stack b = Stack.reverse(a);
		Stack.determineOrder(b,num);
		b.print();
		System.out.println("------------------------------------");
		
		keyb.close();
	}	
}
