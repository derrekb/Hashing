package Olatunde_Emmanuel_Beeck_Derrek_Bland_Elijah_Navas_Edwin;
/**
 * Class for Collision Comparer
 * Purpose: To compare the number of collisions produced when running Linear Probing
 * 			and double Hashing
  */
import java.util.Random;
public class CollisionComparer{
		
	//Purpose: To insert random strings into the Hash Table
	public static void keyinserter(AHash<String,String> X, AHash<String, String> Y,int n) {
		Random r = new Random();
        int i = 0;
        String rand;
        //INV: i= i + 1 && X[0...i-1] is processed with random strings
        	// && Y[0...i-1] is processed with random strings
        while(i < n) {
            rand = "" + (r.nextInt(10001)+1);
            //mutates rand to unique key of Stringed-digits from 1-10,000
            X.insert(rand, "element");
            //INV: X[0...i] is processed with random strings
            //&& Y[0...i-1] is processed with random strings
        	Y.insert(rand, "element");
        	//INV: X[0...i] is processed with random strings
        	// && Y[0...i] is processed with random strings
            i++;    
            //INV: i= i + 1 && X[0...i-1] is processed with random strings
        	// && Y[0...i-1] is processed with random strings
            
        }  }
	
	//Purpose: Console Print-out Formatting.
	public static String createLine(int item, String oldString) {
		return(oldString + String.format("%10d", item));	}
	
	public static void main(String[] args) {
		
		HashComparator<String> scomp = new StringComparator();
		String Item = String.format("%-12s", "# of Items: ");
		String Linear = String.format("%-12s", "\n"+"LinearProbing"+"\n"+"Collisions: ");
		String Double = String.format("%-12s", "\n"+"DoubleHashing"+"\n"+"Collisions: ");
		
		for(int i = 1000; i <=10000; i+=1000) {
			LPHash<String, String> LinearProbingHash = new LPHash<>(10007, scomp);
			DHash<String, String> DoubleHash = new DHash<>(10007, scomp);
			
			keyinserter(LinearProbingHash, DoubleHash, i); 
			int LinearH = LinearProbingHash.collisions();
			int DoubleH = DoubleHash.collisions();
									
			Item = createLine(i, Item);
			Linear = createLine(LinearH, Linear);
			Double = createLine(DoubleH, Double);	
			}
		
		System.out.println(Item);
		System.out.println(Linear);
		System.out.println(Double);
		
		
	}}
