package SeccionA;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class CTest {
	@Test
	public void testFindMax() {
		//Con numeros positivos 
		assertEquals(4, Calculation.findMax(new int[]{1, 3, 4, 2}));
		//Con numeros negativos
        assertEquals(-1, Calculation.findMax(new int[]{-12, -1, -3, -4, -2}));
        //Con numeros negativos y positivos 
        assertEquals(15, Calculation.findMax(new int[]{0, 15, 10, 5, -5}));

    }
}