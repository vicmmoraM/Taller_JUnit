package SeccionB;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
public class ETest {
	@Test
    public void testCsWorkerInOddMonthUSD() {
        // Mock de la fecha actual (mes impar)
        LocalDate mockedDate = LocalDate.of(2025, 1, 1);  // Fecha de enero (mes impar)

        // Crear el objeto Employee con los datos correspondientes
        Employee employee = new Employee(1000.0f, "USD", 0.0f, EmployeeType.Worker, mockedDate);

        // Calcular el salario esperado (con el décimo por mes impar)
        float expected = 1000.0f + (386.0f / 12 * 2);
        assertEquals(expected, employee.cs(), 0.01);
    }

    @Test
    public void testCsWorkerInEvenMonthNonUSD() {
        // Mock de la fecha actual (mes par)
        LocalDate mockedDate = LocalDate.of(2025, 2, 1);  // Fecha de febrero (mes par)

        // Crear el objeto Employee con los datos correspondientes
        Employee employee = new Employee(1000.0f, "EUR", 0.0f, EmployeeType.Worker, mockedDate);

        // Calcular el salario esperado (sin el décimo)
        float expected = 1000.0f * 0.95f;
        assertEquals(expected, employee.cs(), 0.01);
    }

    @Test
    public void testCsSupervisorInOddMonthWithBonus() {
        // Mock de la fecha actual (mes impar)
        LocalDate mockedDate = LocalDate.of(2025, 1, 1);  // Fecha de enero (mes impar)

        // Crear el objeto Employee con los datos correspondientes
        Employee employee = new Employee(1500.0f, "USD", 0.1f, EmployeeType.Supervisor, mockedDate);

        // Calcular el bono
        float bonus = 0.1f * 0.35f;
        // Calcular el salario esperado (con el décimo por mes impar)
        float expected = 1500.0f + bonus + (386.0f / 12 * 2);
        assertEquals(expected, employee.cs(), 0.01);
    }

    @Test
    public void testCsManagerInEvenMonthNonUSD() {
        // Mock de la fecha actual (mes par)
        LocalDate mockedDate = LocalDate.of(2025, 2, 1);  // Fecha de febrero (mes par)

        // Crear el objeto Employee con los datos correspondientes
        Employee employee = new Employee(2000.0f, "GBP", 0.2f, EmployeeType.Manager, mockedDate);

        // Calcular el salario esperado (sin el décimo por mes par)
        float salaryAfterCurrencyAdjustment = 2000.0f * 0.95f;
        float bonus = 0.2f * 0.7f;
        float expected = salaryAfterCurrencyAdjustment + bonus;
        assertEquals(expected, employee.cs(), 0.01);
    }

    @Test
    public void testCalculateYearBonusWorker() {
        // Crear el objeto Employee con los datos correspondientes
        Employee employee = new Employee(1200.0f, "USD", 0.0f, EmployeeType.Worker, LocalDate.now());

        // Verificar que el bono de fin de año sea correcto
        assertEquals(386.0f, employee.CalculateYearBonus(), 0.01);
    }

    @Test
    public void testCalculateYearBonusSupervisorNonUSD() {
        // Crear el objeto Employee con los datos correspondientes
        Employee employee = new Employee(1800.0f, "JPY", 0.0f, EmployeeType.Supervisor, LocalDate.now());

        // Calcular el salario esperado con ajuste de moneda
        float salaryAfterCurrencyAdjustment = 1800.0f * 0.95f;
        float expected = salaryAfterCurrencyAdjustment + (386.0f * 0.5f);
        assertEquals(expected, employee.CalculateYearBonus(), 0.01);
    }

    @Test
    public void testCalculateYearBonusManager() {
        // Crear el objeto Employee con los datos correspondientes
        Employee employee = new Employee(2500.0f, "USD", 0.0f, EmployeeType.Manager, LocalDate.now());

        // Calcular el bono de fin de año
        float expected = 2500.0f + 386.0f;
        assertEquals(expected, employee.CalculateYearBonus(), 0.01);
    }
}
