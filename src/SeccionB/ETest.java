package SeccionB;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
public class ETest {
	@Test
    public void testCsWorkerInOddMonthUSD() {
        
        LocalDate mockedDate = LocalDate.of(2025, 1, 1);  
        Employee employee = new Employee(1000.0f, "USD", 0.0f, EmployeeType.Worker, mockedDate);
        float expected = 1000.0f + (386.0f / 12 * 2);
        assertEquals(expected, employee.cs(), 0.01);
    }

    @Test
    public void testCsWorkerInEvenMonthNonUSD() {
        LocalDate mockedDate = LocalDate.of(2025, 2, 1);  
        Employee employee = new Employee(1000.0f, "EUR", 0.0f, EmployeeType.Worker, mockedDate);
        float expected = 1000.0f * 0.95f;
        assertEquals(expected, employee.cs(), 0.01);
    }

    @Test
    public void testCsSupervisorInOddMonthWithBonus() {
        LocalDate mockedDate = LocalDate.of(2025, 1, 1); 
        Employee employee = new Employee(1500.0f, "USD", 0.1f, EmployeeType.Supervisor, mockedDate);
        float bonus = 0.1f * 0.35f;
        float expected = 1500.0f + bonus + (386.0f / 12 * 2);
        assertEquals(expected, employee.cs(), 0.01);
    }

    @Test
    public void testCsManagerInEvenMonthNonUSD() {
        LocalDate mockedDate = LocalDate.of(2025, 2, 1);  
        Employee employee = new Employee(2000.0f, "GBP", 0.2f, EmployeeType.Manager, mockedDate);
        float salaryAfterCurrencyAdjustment = 2000.0f * 0.95f;
        float bonus = 0.2f * 0.7f;
        float expected = salaryAfterCurrencyAdjustment + bonus;
        assertEquals(expected, employee.cs(), 0.01);
    }

    @Test
    public void testCalculateYearBonusWorker() {
        Employee employee = new Employee(1200.0f, "USD", 0.0f, EmployeeType.Worker, LocalDate.now());
        assertEquals(386.0f, employee.CalculateYearBonus(), 0.01);
    }

    @Test
    public void testCalculateYearBonusSupervisorNonUSD() {
        Employee employee = new Employee(1800.0f, "JPY", 0.0f, EmployeeType.Supervisor, LocalDate.now());
        float salaryAfterCurrencyAdjustment = 1800.0f * 0.95f;
        float expected = salaryAfterCurrencyAdjustment + (386.0f * 0.5f);
        assertEquals(expected, employee.CalculateYearBonus(), 0.01);
    }

    @Test
    public void testCalculateYearBonusManager() {
        Employee employee = new Employee(2500.0f, "USD", 0.0f, EmployeeType.Manager, LocalDate.now());
        float expected = 2500.0f + 386.0f;
        assertEquals(expected, employee.CalculateYearBonus(), 0.01);
    }
}
