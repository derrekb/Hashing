package Olatunde_Emmanuel_Beeck_Derrek_Bland_Elijah_Navas_Edwin;
/**
 * JUunit Test for Hashing
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import org.junit.jupiter.api.Test;

class HashingTest {

	@Test
	void Dictionary() {
		IDictionary<String, String> d = new Dict<String, String>();
		assertEquals(d.isEmpty(), true);
		d.insert("Marco", "Morazan");
		d.insert("James", "Kirk");
		d.insert("Kathryn", "Janeway");
		d.insert("Marco", "Morazan");
		d.insert("B'Elanna", "Torres");
		
		assertEquals(d.isEmpty(), false);
		assertEquals(d.size().intValue(), 5);
		assertEquals(d.findElement("Marco"), "Morazan");
		assertEquals(d.findElement("B'Elanna"), "Torres");
		assertEquals(d.findElement("Josie"), null);
		d.delete("James");
		assertEquals(d.findElement("James"), null);
		assertEquals(d.size().intValue(), 4);
		
		Iterator<String> klooper = d.keys();
		Iterator<String> elooper = d.elements();
		String res = "";
		
		while(klooper.hasNext()) {
			res = res + " "+ klooper.next() + " " + elooper.next();}
		assertEquals(res, " Marco Morazan Kathryn Janeway Marco Morazan B'Elanna Torres");
	}
	
	
	@Test
	void LinearProbing() {
		HashComparator<String> scomp = new StringComparator();
		LPHash<String, String> ht = new LPHash<String,String>(101,scomp);
		
		assertEquals(ht.size().intValue(), 0);
		assertEquals(ht.isEmpty(),true);
		assertEquals(ht.findElement("Marco"), null);
		ht.insert("Marco", "Morazan");
		ht.insert("Nick", "Olsen");
		ht.insert("Jean Luc", "Picard");
		ht.insert("Kathryn", "Janeway");
		assertEquals(ht.size().intValue(), 4);
		assertEquals(ht.isEmpty(), false);
		assertEquals(ht.findElement("Marco"), "Morazan");
		assertEquals(ht.findElement("Cathryn"), null);
		assertEquals(ht.findElement("Kathryn"), "Janeway");
		ht.delete("Kathryn");
		assertEquals(ht.findElement("Kathryn"), null);
		
		Iterator<String> kklooper = ht.keys();
		Iterator<String> eelooper = ht.elements();
		String rres = "";
		
		while(kklooper.hasNext()) {
			rres=rres + " " + kklooper.next() + " " + eelooper.next();
		}
		assertEquals(rres, " Jean Luc Picard Nick Olsen Marco Morazan");
	}

	@Test
	void DoubleHashing() {
		HashComparator<String> scomp1 = new StringComparator();
		DHash<String, String> ht1 = new DHash<String,String>(101,scomp1);
		
		assertEquals(ht1.size().intValue(), 0);
		assertEquals(ht1.isEmpty(),true);
		assertEquals(ht1.findElement("Marco"), null);
		ht1.insert("Marco", "Morazan");
		ht1.insert("Nick", "Olsen");
		ht1.insert("Jean Luc", "Picard");
		ht1.insert("Kathryn", "Janeway");
		assertEquals(ht1.size().intValue(), 4);
		assertEquals(ht1.isEmpty(), false);
		assertEquals(ht1.findElement("Marco"), "Morazan");
		assertEquals(ht1.findElement("Cathryn"), null);
		assertEquals(ht1.findElement("Kathryn"), "Janeway");
		ht1.delete("Kathryn");
		assertEquals(ht1.findElement("Kathryn"), null);
		
		Iterator<String> kklooper1 = ht1.keys();
		Iterator<String> eelooper1 = ht1.elements();
		String rres1 = "";
		
		while(kklooper1.hasNext()) {
			rres1=rres1 + " " + kklooper1.next() + " " + eelooper1.next();
		} 
		assertEquals(rres1, " Jean Luc Picard Nick Olsen Marco Morazan");
	}		
	}
