package mypackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class multiplytest {

	@Test
	public void test() {
		junittest test = new junittest();
		int output = test.multiply(5, 2);
		
		assertEquals(10, output);
	}

}
