package SeccionB;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Employee
{   //remuneracion mensual unificada
    private final float rmu = (float) 386.0;
    //salario del employee
    private float salary;
    private String currency;
    //porcentaje de bonus
    private float bonusPercentage;    
    //variable de tipo employeeType
    private EmployeeType employeeType;  
    private LocalDate currentDate;

    public Employee(float salary, String currency, 
            float bonusPercentage, EmployeeType employeeType,
            LocalDate currentDate) {
this.salary = salary;
this.currency = currency;
this.bonusPercentage = bonusPercentage;
this.employeeType = employeeType;
this.currentDate = currentDate != null ? currentDate : LocalDate.now();  // Usar la fecha actual por defecto
}
    
    public void setDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }
    
    //calcula el salario dependiendo del tipo de trabajador 
    //y entrega el décimo correspondiente cada 2 meses
    public float cs() {
        float salario = 0;
        // Obtiene el mes en forma de entero
        int month = currentDate.getMonthValue();  // Usamos la fecha proporcionada

        // Si la moneda es USD, se considera todo el salario,
        // caso contrario se resta 5% por cambio de moneda
        if (currency.equals("USD")) {
            salario = salary;
        } else {
            salario = salary * 0.95f;
        }

        switch (employeeType) {
            case Worker:
                // Si el mes es impar entonces le entrega 
                // el décimo junto con su salario
                return month % 2 == 0 ? salario : salario + rmu / 12 * 2;
            case Supervisor:
                float valueS = salario + (bonusPercentage * 0.35f);
                // Si el mes es impar entonces le entrega 
                // el décimo junto con su salario y un bono
                return month % 2 == 0 ? valueS : valueS + rmu / 12 * 2;
            case Manager:
                float valueM = salario + (bonusPercentage * 0.7f);
                // Si el mes es impar entonces le entrega 
                // el décimo junto con su salario y un bono
                return month % 2 == 0 ? valueM : valueM + rmu / 12 * 2;
        }
        return 0.0f;
    }
    //calcula el bono de fin de año
    public float CalculateYearBonus() {
        float salario = 0;
        // Si la moneda es USD, se considera todo el salario,
        // caso contrario se resta 5% por cambio de moneda
        if(currency == "USD"){salario = salary; }
        else{salario = (float) (salary * 0.95);}
        switch (employeeType) {
            case Worker:
                return rmu;
            case Supervisor:
                return salario + rmu * 0.5F;
            case Manager:
                return salario + rmu * 1.0F;
        }
        return 0.0F;
    }
}
