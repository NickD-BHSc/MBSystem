package comp3350.mbs.objects;

import junit.framework.TestCase;
import org.junit.Test;



public class SnackTest extends TestCase {

	public SnackTest( String arg0) {
		super( arg0);
	}

	@Test
	public void testSnack1() {
		Snack snack;

		System.out.println("\nStarting testSnack1");
		snack = new Snack(0, 0,0,0,0,0,0,0,0,0,0,0);
		assertNotNull(snack);
		assertEquals(0.0,snack.getHotdogPrice());
		assertEquals(0.0, snack.getHotdogQuantity());

		assertEquals(0.0,snack.getPardonQuantity());
		assertEquals(0.0, snack.getPopcornPrice());

		assertEquals(0.0,snack.getFriesPrice());
		assertEquals(0.0, snack.getFriesQuantity());

		assertEquals(0.0,snack.getDrinkPrice());
		assertEquals(0.0, snack.getDrinkQuantity());

		assertEquals(0.0,snack.getNoodlePrice());
		assertEquals(0.0, snack.getNoodleQuantity());

		assertEquals(0.0,snack.getChipsQuantity());
		assertEquals(0.0, snack.getChipsPrice());

		System.out.println("Finished testSnack1");
	}//end testTicket1
}
