package views;

import java.util.ArrayList;

import models.Employee;
import models.Restapi;

public class MainConsole {
    Restapi restapi;
    public MainConsole(Restapi restapi) {
        this.restapi = restapi;
        this.start();
    }
    public void start() {
        ArrayList<Employee> employees = this.restapi.getEmployees();
        for(Employee employee: employees) {
            System.out.printf("%10.10s %12s %6d %,6.2f\n",
             employee.city,
             employee.address,
             employee.size,
             employee.price
             );
        }
    }
    
}
