package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;
	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
	/*	head = null;
		tail = null;
		size = 0;*/
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;

		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
	/*	if(element==null)
		{
			throw new NullPointerException();
			
		}
		
		LLNode<E> new_node = new LLNode<E>(element); 
	    
	    LLNode<E> last = head; */
	    /* used in step 5*/
	  
	    /* 3. This new node is going to be the last node, so 
	     * make next of it as NULL*/
	   // new_node.next = null; 
	  
	    /* 4. If the Linked List is empty, then make the new 
	     * node as head */
	  /*  if (head == null) { 
	        new_node.prev = null; 
	        head = new_node;      
	    } 
	    else
	    {
	    /* 5. Else traverse till the last node */
	   /* while (last.next != null) 
	        last = last.next; 
	  
	    /* 6. Change the next of last node */
	   // last.next = new_node; 
	  
	    /* 7. Make last node as previous of new node */
	  /*  new_node.prev = last; 
	    
	    }
	    this.size++;
        
        return true;*/
		if (element == null) {
			throw new NullPointerException();
		}
        LLNode<E> n = new LLNode<E>(element);
        tail.prev.next = n;
        n.prev = tail.prev;
        n.next = tail;
        tail.prev = n;
        size++;
		return true;

				
}



	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		/*if(index<0||index> this.size-1)
		{
			throw new IndexOutOfBoundsException();
		
		}
		else if(head==null)
			
			throw new IndexOutOfBoundsException();
		
		else
		{
			LLNode<E> current = head;
		  for (int i = 0; i <index; i++)
		  {
		      current = current.next;
		      
		  }
		
		return current.data;
		}*/
		
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> n = head;
		for (int i = 0; i <= index; i++) {
			n = n.next;
		}
		return n.data;

	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		/*if (index < 0 || index > this.size-1) 
			throw new IndexOutOfBoundsException();
		LLNode<E> newNode = new LLNode<E>(element);
		if (head == null) {		// list is empty, index must be 0
			 newNode.prev = null; 
		     head = newNode; 
		}
		if (index == 0) {			// insert before head
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			newNode.prev=null;
		}
		else if (index == this.size) { 	// insert after tail
			/*newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;*/
		//	add(element);
		//}
		/*else {					// general case
			LLNode<E> current = head;
			for (int i = 1; i <index; i++) 
				current = current.next;
			// nodeRef now points to the node before the insert point
			// see course notes for pictures!
			newNode.next = current.next;
			current.next = newNode;
			newNode.prev = current;
			newNode.next.prev = newNode;
		}
		this.size++;*/
		if (element == null) {
			throw new NullPointerException();
		}
		if ((index < 0 || index >= size)&& size != 0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> prev = head;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		LLNode<E> node = new LLNode<E>(element);
	
		node.next = prev.next;
		prev.next = node;
		node.next.prev = node;
		node.prev = prev;
		size++;

			
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		
		 /*LLNode<E> last = head;  
		    while (last.next != null) 
		    {
		        last = last.next; 
		        this.size++;
		    }
		    return this.size; */
		return this.size;
	        
		  
		
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method

		/*if (index < 0 || index > this.size-1) 
			throw new IndexOutOfBoundsException();
		
				LLNode<E> tmp = head;
		for (int i = 0; i < index; i++)
		{
		tmp = tmp.next;
		}
		if (tmp.prev != null)
		{
		tmp.prev.next = tmp.next;
		}
		else
		{
			head = tmp.next;

		}
		if (tmp.next != null)
		{
			tmp.next.prev = tmp.prev;

		}
		this.size--;
		return tmp.data;*/
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> n = head;
		for (int i = 0; i <= index; i++) {
			n = n.next;
		}
		n.prev.next = n.next;
		n.next.prev = n.prev;
		size--;
		return n.data;

	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set (int index, E element )
	{
		// TODO: Implement this method
		
		//remove(index);
		//add(index, element );
		
		//return get(index) ; 
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> n = head;
		for (int i = 0; i <= index; i++) {
			n = n.next;
		}
		n.data = element;
		return element;

	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode()
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}


	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
