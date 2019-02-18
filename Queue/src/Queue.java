import java.util.Iterator;
//----------------------------------------------------- 
// Author: Efe Berk ERGÜLEÇ 
// Description: This class defines a String Queue which
// uses array implementation
//----------------------------------------------------- 
public class Queue implements Iterable
// Summary: It is the Queue class which includes the methods 
{
	private String[] a;		// Queue array
	private int head = 0;	// Keeps first element
	private int tail = 0;	// Keeps last element
	private int range = 0;	// Keeps element number

	public Queue(int cap) 
	//-------------------------------------------------------- 
	// Summary: Constructor to pick data from main
	// Precondition: cap is an int which determines the length
	// of array.
	// Postcondition: It creates new array with size cap
	//-------------------------------------------------------- 
	{
		a = new String[cap];
	}

	public void enqueue(String param) 
	//-------------------------------------------------------- 
	// Summary: Adds element to array Queue
	// Precondition: param is String value which will be added
	// Postcondition: param will write as the last element of
	// array
	//-------------------------------------------------------- 
	{
		if (tail == a.length)
		{
			rearrange();
			if(range == a.length)
				resize(2 * a.length);
		}
			
		a[tail++] = param;
		++range;
	}

	public String dequeue() 
	//-------------------------------------------------------- 
	// Summary: Removes element from array Queue
	// Precondition: no precondition
	// Postcondition: It will eliminate first non-null element
	// of array
	//-------------------------------------------------------- 
	{
		String item = a[head];
		a[head++] = null;
		--range;
		if (range == a.length / 4 && head != 0)
		{
			rearrange();
			if (range == a.length / 4 && head == 0)
				resize(a.length / 2);
		}
			
		return item;
	}

	public int size() 
	//-------------------------------------------------------- 
	// Summary: Keeps size of elements
	// Precondition: No precondition
	// Postcondition: Returns range
	//-------------------------------------------------------- 
	{
		return range;
	}

	public boolean isEmpty() 
	//-------------------------------------------------------- 
	// Summary: Controls if array is empty or not
	// Precondition: No precondition
	// Postcondition: returns range == 0 (if it is 0, it's empty)
	//-------------------------------------------------------- 
	{
		return range == 0;
	}

	public void resize(int max) 
	//-------------------------------------------------------- 
	// Summary: It changes size of array
	// Precondition: max is an integer
	// Postcondition: Size of array will change to max
	//-------------------------------------------------------- 
	{
		String[] temp = new String[max];
		for (int i = 0; i < range; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void rearrange() 
	//-------------------------------------------------------- 
	// Summary: Clears null value at the left side
	// Precondition: No precondition
	// Postcondition: It will shift elements
	//-------------------------------------------------------- 
	{
		String[] temp = new String[a.length];
		for (int i = 0; i < range; i++) {
			temp[i] = a[head++];
		}
		tail = range;
		head = 0;
		a = temp;
	}

	public void print() 
	//-------------------------------------------------------- 
	// Summary: Prints elements
	// Precondition: An array and iterator method
	// Postcondition: Prints all of the elements
	//-------------------------------------------------------- 
	{
		ArrayIterator it = new ArrayIterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

	@Override
	public Iterator iterator() {
	// Summary: Iterates elements. I took it's skeleton from book.
		return new ArrayIterator();
	}
	private class ArrayIterator implements Iterator
	// Precondition: An array
	{
		int count = 0;
		@Override
		public boolean hasNext() 
		//-------------------------------------------------------- 
		// Summary: It controls that iterator must prints a.length
		// line.
		// Precondition: An array
		// Postcondition: If size goes greater than length, stops 
		// iterator.
		//-------------------------------------------------------- 
		{
			return count < a.length;
		}

		@Override
		public Object next()
		//-------------------------------------------------------- 
		// Summary: Prints elements
		// Precondition: An array
		// Postcondition: Prints all of the elements
		//-------------------------------------------------------- 
		{
			return a[count++];
		}
		
	}
}
