package Hash;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class DictionaryTests
{ @Test
	public void test()
{
	IDictionary<String, String> d = new Dict<String, String>();
assertEquals(d.isEmpty(), true);
d.insert("Marco", "Morazan");
d.insert("James", "Kirk");
d.insert("Kathryn", "Janeway");
d.insert("B'Elanna", "Torres");
assertEquals(d.isEmpty(), false);
assertEquals(d.size().intValue(), 4);
assertEquals(d.findElement("Marco"), "Morazan");
assertEquals(d.findElement("B'Elanna"), "Torres");
assertEquals(d.findElement("Josie"), null);
d.delete("Marco");
assertEquals(d.findElement("Marco"), null);
assertEquals(d.size().intValue(), 3);


Iterator<String> klooper = d.keys();
Iterator<String> elooper = d.elements();
String res = "";
while (klooper.hasNext())
{ res = res + " " + klooper.next() + " " + elooper.next(); }
assertEquals(res, " James Kirk Kathryn Janeway B'Elanna Torres");
}
}