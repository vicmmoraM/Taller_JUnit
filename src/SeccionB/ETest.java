package SeccionB;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class ETest {
	@Test
	public void testCsWorkerInOddMonthUSD() {
		// Escenario: Trabajador en mes impar con moneda USD
        Employee employee = new Employee(1000.0f, "USD", 0.0f, EmployeeType.Worker);
        float expected = 1000.0f + (386.0f / 12 * 2);
        assertEquals(expected, employee.cs(), 0.01);
	}
	
	
	@Test
    public void testCsWorkerInEvenMonthNonUSD() {
        // Escenario: Trabajador en mes par con moneda no USD
        Employee employee = new Employee(1000.0f, "EUR", 0.0f, EmployeeType.Worker);
        float expected = 1000.0f * 0.95f;
        assertEquals(expected, employee.cs(), 0.01);
    }
	
	@Test
    public void testCsSupervisorInOddMonthWithBonus() {
        // Escenario: Supervisor en mes impar con bono
        Employee employee = new Employee(1500.0f, "USD", 0.1f, EmployeeType.Supervisor);
        float bonus = 0.1f * 0.35f;
        float expected = 1500.0f + bonus + (386.0f / 12 * 2);
        assertEquals(expected, employee.cs(), 0.01);
    }
	
	@Test
    public void testCsManagerInEvenMonthNonUSD() {
        // Escenario: Gerente en mes par con moneda no USD
        Employee employee = new Employee(2000.0f, "GBP", 0.2f, EmployeeType.Manager);
        float salaryAfterCurrencyAdjustment = 2000.0f * 0.95f;
        float bonus = 0.2f * 0.7f;
        float expected = salaryAfterCurrencyAdjustment + bonus;
        assertEquals(expected, employee.cs(), 0.01);
    }
	
	@Test
    public void testCalculateYearBonusWorker() {
        // Escenario: Bono anual para un trabajador
        Employee employee = new Employee(1200.0f, "USD", 0.0f, EmployeeType.Worker);
        assertEquals(386.0f, employee.CalculateYearBonus(), 0.01);
    }
	
	@Test
    public void testCalculateYearBonusSupervisorNonUSD() {
        // Escenario: Bono anual para un supervisor con moneda no USD
        Employee employee = new Employee(1800.0f, "JPY", 0.0f, EmployeeType.Supervisor);
        float salaryAfterCurrencyAdjustment = 1800.0f * 0.95f;
        float expected = salaryAfterCurrencyAdjustment + (386.0f * 0.5f);
        assertEquals(expected, employee.CalculateYearBonus(), 0.01);
    }
	
	@Test
    public void testCalculateYearBonusManager() {
        // Escenario: Bono anual para un gerente
        Employee employee = new Employee(2500.0f, "USD", 0.0f, EmployeeType.Manager);
        float expected = 2500.0f + 386.0f;
        assertEquals(expected, employee.CalculateYearBonus(), 0.01);
    }
}
