//----------------------------------------------------- 
// Author: Efe Berk ERGÜLEÇ 
// ID: 24191130360 
// Assignment: 1 
// Question: 1 
// Description: It's the test class for my Queue array 
// implementation
//----------------------------------------------------- 
public class mainForQueue 
{
	public static void main(String[] args) 
	{
		Queue q = new Queue(8);
		q.enqueue("x");
		q.enqueue("a");
		q.enqueue("b");
		q.enqueue("c");
		q.enqueue("d");
		q.enqueue("e");
		q.enqueue("f");
		q.dequeue();
		q.print();
		System.out.println("---------------------------------------");
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		System.out.println("---------------------------------------");
		q.enqueue("g");
		q.enqueue("h");
		q.print();
		System.out.println("---------------------------------------");
		q.enqueue("i");
		q.print();
		System.out.println("---------------------------------------");
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		System.out.println("---------------------------------------");
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.print();
		System.out.println("---------------------------------------");
	}
}
