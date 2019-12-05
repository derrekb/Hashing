package Olatunde_Emmanuel_Beeck_Derrek_Bland_Elijah_Navas_Edwin;
/**
 * Abstract Class for Double Hashing & Linear Probing
 */
import java.util.Iterator;
import java.util.ArrayList;

public abstract class AHash<K,E> implements IDictionary<K,E> {

	protected int collisions = 0;
	private Item<K, E> AVAILABLE = new Item<K, E>(null, null); 
	// deleted cell item
	protected int n;
	// number of elements in the hash table
	protected int N; 
	//size of the array
	protected ArrayList<Item<K, E>> A;
	protected HashComparator<K> h; 
	// provides hashIndex and Equals
	

	public AHash(int s, HashComparator<K> hc){
			n = 0; 
			h = hc; 
			N = s;
			int i = 0;
			A = new ArrayList<Item<K, E>> (s);
			/* Processing vector interval [0..s-1]
			* INV: 0 <= i <= s-1 && A[0..i] == null */
			while (i <= s - 1)	{
				A.add(i, null);
				i = i + 1;		}
			collisions = 0;		}
		
		//Auxiliary methods
			
	protected boolean available(int i){ 
		return(A.get(i) == AVAILABLE); 		}
	
	protected boolean empty(int i){
		return(A.get(i) == null);		}
	
	protected K key(int i){
		return(A.get(i).getKey());		}
	
	protected E elem(int i){
		return(A.get(i).getElem());	}
	
	protected abstract int find(K k);
	
	public int collisions() {return collisions;}
	
	public Integer size() {return(n);}
	
	public Boolean isEmpty() {return(n == 0);}	
	
	public Iterator<E> elements(){
		Iterator<Item<K, E>> htlooper = A.iterator();
		ArrayList<E> elems = new ArrayList<E>();
		Item<K, E> k;
		while (htlooper.hasNext()){
			k = htlooper.next();
			if ((k != null) && (k != AVAILABLE)){
				elems.add(k.getElem()); }	}
		return (elems.iterator());		}
	
	public Iterator<K> keys(){
		Iterator<Item<K, E>> htlooper = A.iterator();
		ArrayList<K> keys = new ArrayList<K>();
		Item<K, E> k;
		while (htlooper.hasNext()){
			k = htlooper.next();
			if ((k != null) && (k != AVAILABLE)){
				keys.add(k.getKey()); }		}
		return (keys.iterator());		}
		
	public E findElement(K k)	{
		int i = find(k);
		if (i < 0) { return(null); }
		else { return(elem(i)); }	}
		
	public void delete(K k)	{
		int i = find(k);
		if (i > -1)	{
			A.set(i, AVAILABLE);
			n = n - 1;		}}

}




