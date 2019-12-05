package Olatunde_Emmanuel_Beeck_Derrek_Bland_Elijah_Navas_Edwin;
/**
 *Class for Linear Probing Hashing
 * @param <K>
 * @param <E>
 */

public class LPHash<K, E> extends AHash<K,E>{
	
	public LPHash(int s, HashComparator<K> hc) {
		super(s, hc);			}
	
	public void insert(K k, E e){
		// Assumes this Hash-Table is not full
		int i = h.hashIndex(k) % N;
		int j = i;
		boolean done = false;
		while (!done)	{ 
			if (empty(j) || available(j)){
				A.set(j, new Item<K, E>(k, e));
				n = n + 1;
				done = true;		}
			else {
				j = (j + 1 ) % N;
				collisions++;	 }}}
		
	//Purpose: returns the index of the given key or -1 if there is no such key
	protected int find(K k) { 
		int i = (h.hashIndex(k) % N); 
		// division method compression map
		int j = i;
		int res = -1;
		boolean done = false; 
		// indicates that the search is done
		/*
		* Processing vector interval [0..n-1]
		* INV:
		* done ==> (empty(j) && res == -1) ||
		* (available(j) && j == i && res == -1) ||
		* (key(j) == k && res == j) ||
		* ( j == i && res = -1)
		* && !done ==> res == -1
		* && j in [0..n-1]
		* && [i%N..(j-1)%N] is processed
		* && -1 <= res <= n-1
		*/
		while (!done){ 
			if (empty(j)) {done = true;	}
			else if (available(j))	{ 
				j = (j + 1) % N;
				if (j == i) { done = true; } }
			else if (h.keyEqual(key(j), k))	{ 
				res = j;
				done = true; }
			else	{
				j = (j + 1) % N;
				if (j == i)	{ done = true; } }
			}
		return(res); }
	
}




