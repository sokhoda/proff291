package SpringHibernateTransaction.view;

import SpringHibernateTransaction.domain.Employee;
import SpringHibernateTransaction.service.EmployeeServiceDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by lenchi on 21.02.16.
 */
public class View {
    private String departmentID;
    private Integer employeeSalary;
    private EmployeeServiceDAO employeeService;


    public void main() throws IOException {
        System.out.println("Enter Department ID:\n");
        departmentID = getDepartment();

        employeeSalary = employeeService.getSalaryForEmployee(departmentID);


    }

    private String getDepartment() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
