import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class to represent an employee
class Employee {
    private String name;
    private int id;
    private double basicSalary;
    private double allowances;
    private double deductions;

    public Employee(String name, int id, double basicSalary, double allowances, double deductions) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.deductions = deductions;
    }

    public double calculateNetSalary() {
        return basicSalary + allowances - deductions;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Allowances: " + allowances);
        System.out.println("Deductions: " + deductions);
        System.out.println("Net Salary: " + calculateNetSalary());
        System.out.println("-----------------------------");
    }
}

// PayrollSystem class to manage employees
class PayrollSystem {
    private List<Employee> employees;

    public PayrollSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayAllEmployees() {
        for (Employee employee : employees) {
            employee.displayEmployeeInfo();
        }
    }
}

// Main class to run the payroll system
public class EmployeePayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();

        while (true) {
            System.out.println("Employee Payroll System");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Basic Salary: ");
                    double basicSalary = scanner.nextDouble();
                    System.out.print("Enter Allowances: ");
                    double allowances = scanner.nextDouble();
                    System.out.print("Enter Deductions: ");
                    double deductions = scanner.nextDouble();

                    Employee employee = new Employee(name, id, basicSalary, allowances, deductions);
                    payrollSystem.addEmployee(employee);
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    System.out.println("Displaying All Employees:");
                    payrollSystem.displayAllEmployees();
                    break;

                case 3:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}