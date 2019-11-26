package Hash;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class TestFile {

	@Test
	void test() {
		HashComparator<String> scomp = new StringComparator();
		LPHash<String, String> ht = new LPHash<String, String>(101, scomp);
		assertEquals(ht.size().intValue(), 0); assertEquals(ht.isEmpty(), true);
	}

}
