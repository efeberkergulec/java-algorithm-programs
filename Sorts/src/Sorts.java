//-----------------------------------------------------
// Author: Efe Berk ERGÜLEÇ
// Description: This class defines a sorting class
//-----------------------------------------------------
import java.util.*;
import edu.princeton.cs.algs4.*;

public class Sorts implements Iterable
{
	private Node first, last;
	int count = 0;
	
	private class Node
	{
		int item;
		Node next;
		Node prev;
	}
	
	//--------------------------------------------------------
	// Summary: Adds item to linked-list.
	// Precondition: item is an integer.
	// Postcondition: Element with parameter item will be added.
	//--------------------------------------------------------
	public void add(int item)
	{	
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) 
		{
			first = last;
			first.prev = null;
		}
		else if(count == 1)
		{
			first.next = last;
			last.prev = first;
		}
		else
		{
			oldlast.next = last;
			last.prev = oldlast;
		}
		count++;
	}
	
	//--------------------------------------------------------
	// Summary: Selection sort
	// Precondition: parameter is a linked-list
	// Postcondition: Sorts with selection sort algorithm.
	//--------------------------------------------------------
	public static void selectionSort(Sorts linkedList)
	{
		for(Node i = linkedList.first; i != null; i = i.next)
		{
			Node min = i;
			for(Node j = i.next; j != null; j = j.next) 
			{
				if(less(j, min))	
				{
					min = j;
				}
			}
			swap(linkedList, i, min);
		}
		linkedList.printAll();
	}
	
	//--------------------------------------------------------
	// Summary: Insertion sort
	// Precondition: parameter is a linked-list
	// Postcondition: Sorts with insertion sort algorithm.
	//--------------------------------------------------------
	public static void insertionSort(Sorts linkedList)
	{
		for(Node i = linkedList.first; i != null; i = i.next)
		{
			for(Node j = i; j.prev != null; j = j.prev)
				if(less(j, j.prev))	swap(linkedList,j,j.prev);
		}
		linkedList.printAll();
	}
	
	//--------------------------------------------------------
	// Summary: Shell sort
	// Precondition: parameter is a linked-list
	// Postcondition: Sorts with shell sort algorithm.
	//--------------------------------------------------------
	public static void shellSort(Sorts linkedList)
	{
		int N = linkedList.size();
		int h = 1;
		while(h < N/3)	h = 2 * h + 1;
		while(h >= 1)
		{
			Node current = linkedList.first;
			Node current2 = linkedList.first;
			
			while(current != null)
			{
				findNode(linkedList,current,current2,h);
				if(current2 == null) 
				{
					break;
				}
				else
				{
					if(less(current2,current)) 
					{
						exch(linkedList,current.item,current2.item);
						findNode(linkedList,current,current2,h);
					}
				}
				current2 = current2.next;
				current = current.next;
			}
			h = h / 2;
		}
		linkedList.printAll();
	}
	
	
	private static void findNode(Sorts linkedList, Node current, Node current2, int h) 
	{
		Node tempNode = linkedList.first;
		while(tempNode != null) // for ile yap
		{
			if(compareTo(tempNode.item,current.item) == 0)
			{
				current2 = tempNode;
			}
			tempNode =  tempNode.next;
		}
		for(int i = 0; i < h; i++)
		{
			if(current2.prev == null)
			{
				current2 = null;
				break;
			}
			else
				current2 = current2.prev;
		}
		
	}

	//--------------------------------------------------------
	// Summary: Bubble sort
	// Precondition: parameter is a linked-list
	// Postcondition: Sorts with bubble sort algorithm.
	//--------------------------------------------------------
	public static void bubbleSort(Sorts linkedList)
	{
		int count = 0;
		int N = linkedList.size();
		
		while(count < N)
		{
			for(Node i = linkedList.first; i.next != null; i = i.next)
			{
				Node j = i.next;
				if(less(j,i)) {	swap(linkedList,i,j);}
			}
			count++;
		}
		linkedList.printAll();
	}

	//--------------------------------------------------------
	// Summary: Shuffle
	// Precondition: parameter is a linked-list
	// Postcondition: Shuffles the linked-list.
	//--------------------------------------------------------
	public static void shuffle(Sorts linkedList)
	{
		for(int i = 0; i < linkedList.size();i++)
		{
			int r = StdRandom.uniform(i + 1);
			exch(linkedList, i, r);
		}
		linkedList.printAll();
	}
	
	//--------------------------------------------------------
	// Summary: Change the values.
	// Precondition: There exists a linked-list and 2 integer values.
	// Postcondition: The value of the variable is set.
	//--------------------------------------------------------
	private static void exch(Sorts linkedList, int i, int r) {
		int count1 = 0,count2 = 0;
		Node tempNode1 = linkedList.first, tempNode2 = linkedList.first;
		while(count1 < i)
		{
			tempNode1 = tempNode1.next;
			count1++;
		}
		while(count2 < r)
		{
			tempNode2 = tempNode2.next;
			count2++;
		}
		swap(linkedList, tempNode1, tempNode2);
	}

	//--------------------------------------------------------
	// Summary: Controls if the linked list is empty or not
	// Postcondition: Returns true if it's empty. True else.
	//--------------------------------------------------------
	private boolean isEmpty() 
	{
		return count == 0;
	}
	
	//--------------------------------------------------------
	// Summary: Controls x < y
	// Postcondition: Returns true if x < y. True else.
	//--------------------------------------------------------
	private static boolean less(Node x, Node y)
	{
		return x.item < y.item;
	}
	
	//--------------------------------------------------------
	// Summary: Change the values.
	// Precondition: There exists a linked-list and 2 node values.
	// Postcondition: The value of the variable is set.
	//--------------------------------------------------------
	private static void swap(Sorts linkedList, Node domain, Node min)
	{
		int temp = domain.item;
		domain.item = min.item;
		min.item = temp;		
	}
	
	//--------------------------------------------------------
	// Summary: Compares the values.
	// Postcondition: Returns true if item1 > item2. False else.
	//--------------------------------------------------------
	public static int compareTo(int item1, int item2)
	{
		return item1 - item2;
	}
	
	//--------------------------------------------------------
	// Summary: Calculates size.
	// Postcondition: Returns size of the linked list.
	//--------------------------------------------------------
	public int size() 
	{
		return count;
	}
	
	//--------------------------------------------------------
	// Summary: Prints all values.
	//--------------------------------------------------------
	public void printAll()
	{
		SortingIterator itr = new SortingIterator();
		while(itr.hasNext())
		{
			StdOut.println(itr.next());
		}
			
	}

	//--------------------------------------------------------
	// Summary: Iterator class. I took it from lecture book.
	//--------------------------------------------------------
	@Override
	public Iterator iterator() 
	{	return new SortingIterator();	}
	
	private class SortingIterator implements Iterator
	{
		private Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Integer next() {
			Integer num = current.item;
			current = current.next;
			return num;
		}
		
	}	
}
