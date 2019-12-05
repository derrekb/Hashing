package Olatunde_Emmanuel_Beeck_Derrek_Bland_Elijah_Navas_Edwin;

import java.util.Iterator;

public interface IAHash<K,E> {
	// Purpose: To determine the number of elements in this Hash_Table
	public Integer size();
	// Purpose: To determine if this Hash_Table is empty
	public Boolean isEmpty();
	// Purpose: To return an iterator for this Hash_Table's elements
	public Iterator<E> elements();
	// Purpose: To return an iterator for this Hash_Table's keys
	public Iterator<K> keys();
	// Purpose: To return element associated with the given key
	public E findElement(K k);
	// Purpose: To insert a pair for the given key and element
	// Effect: A new pair is added to this Hash_Table & size is increased by one
	public void insert(K k, E e);
	// Purpose: To delete the given key and element from this Hash_Table
	public void delete(K k); 
	//Purpose: To determine the number of collisions for this Hash_Table
	public int collisions();
	

		}