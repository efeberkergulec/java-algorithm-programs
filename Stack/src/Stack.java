import java.util.Iterator;
//----------------------------------------------------- 
// Author: Efe Berk ERGÜLEÇ 
// ID: 24191130360 
// Assignment: 1 
// Question: 2 
// Description: This class defines a String Stack which
// uses linked list implementation
//----------------------------------------------------- 
public class Stack implements Iterable
// Summary: It is the Stack class which includes the methods 
{
	private Node first = null;	// It's the domain Node.
	private Node last;			// It keeps the last Node(which implements first).
	public int element = 0;		// It keeps number of elements in list.
	private String next;
	
	private class Node
	//-------------------------------------------------------- 
	// Summary: Defines Nodes
	// Precondition: Enters as a Node
	// Postcondition: Keeps String value item and points next
	// Node
	//-------------------------------------------------------- 
	{
		String item;
		Node next;
	}
	public void push(String item)
	//-------------------------------------------------------- 
	// Summary: Adds new element to Stack
	// Precondition: item is a String which will be added to 
	// Stack
	// Postcondition: It will add item to first place
	//-------------------------------------------------------- 
	{
		if(element == 0)
		{
			first = new Node();
			first.item = item;
			last = first;
			element++;
		}
		else if(element < Integer.MAX_VALUE)
		{
			Node oldfirst = first;
			first = new Node();
			first.item = item;
			first.next = oldfirst;
			
			Node tempNode = first;
			int count = 1;
			element++;
			while(count < element)
			{
				tempNode = tempNode.next;
				count++;
			}
			last = tempNode;
			last.next = first;
		}
	}
	public String pop()
	//-------------------------------------------------------- 
	// Summary: Removes element from Stack
	// Precondition: no precondition
	// Postcondition: It will remove item at first place
	//-------------------------------------------------------- 
	{
		String item = first.item;
		first = first.next;
		last.next = first;
		element--;
		return item;
	}
	public boolean isEmpty()
	//-------------------------------------------------------- 
	// Summary: Controls if the Stack is empty
	// Precondition: no precondition
	// Postcondition: Returns true if Stack is empty. Else false
	//-------------------------------------------------------- 
	{
		return first == null;
	}
	public int size()
	//-------------------------------------------------------- 
	// Summary: Calculates size of stack
	// Precondition: Element is an int which saves range
	// Postcondition: Returns value of element
	//-------------------------------------------------------- 
	{
		return element;
	}
	public void print()
	//-------------------------------------------------------- 
	// Summary: Prints elements of the Stack
	// Precondition: Iterator is the main precondition
	// Postcondition: It prints data with methods of 
	// LinkedListIterator which authored by me
	//-------------------------------------------------------- 
	{
		LinkedListIterator it = new LinkedListIterator();
		int count = 0;
		while(it.hasNext()) {
			if(count == element)
				break;
			System.out.println("|----" + it.next() + "----|");
			count++;
		}
	}
	public static Stack reverse(Stack q)
	//-------------------------------------------------------- 
	// Summary: It reverses the stack
	// Precondition: q is a Stack which will be reversed.
	// Postcondition: q becomes rev Stack but Stack features 
	// doesn't change.
	//-------------------------------------------------------- 
	{
		int length = q.size();
		
		Stack rev = new Stack();
		String s;
		for(int i = 0; i < length; i++)
		{
			s = q.pop();
			rev.push(s);
		}
		return rev;
	}
	public static Node determineOrder(Stack q, String param)
	//-------------------------------------------------------- 
	// Summary: It chooses order to print values
	// Precondition: q is the Stack which order will change 
	// and param is the input which determines the order of 
	// Stack
	// Postcondition: The method will take an input and scan
	// the Stack and assign it the first node value if there 
	// is a value equal to the input parameter.
	//-------------------------------------------------------- 
	{
		Node detNode = q.first;
		int count = 0;
		int length = q.size();
		while(count < length)
		{
			detNode = detNode.next;
			if(detNode.item.equalsIgnoreCase(param))
			{
				q.first = detNode;
				break;
			}
		}
		return detNode;
	}
	public Iterator iterator() 
	// Summary: Iterates the values
	{	return new LinkedListIterator();	}
	
	private class LinkedListIterator implements Iterator  
	// Summary: Stack class uses this class to write data
	{	
		private Node current = first;	
		@Override
		public boolean hasNext() 
		//-------------------------------------------------------- 
		// Summary: Controls value is empty or not
		// Precondition: no precondition
		// Postcondition: Returns true if there is no value. Else
		// false.
		//-------------------------------------------------------- 
		{
			return current != null;
		}
		@Override
		public String next() 
		//-------------------------------------------------------- 
		// Summary: Writes next item
		// Precondition: Stack data
		// Postcondition: Returns item which keeps data from Stack
		//-------------------------------------------------------- 
		{
			String item = current.item;
			current = current.next;
			return item;
		}
	}
}
