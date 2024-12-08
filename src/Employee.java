// Employee Salary Management System
public class Employee {
    // Attributes
    private String name;
    private int id;
    private double basicSalary;
    private double grossSalary;

    // Constructor
    public Employee(String name, int id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
        this.grossSalary = 0; // Initialized, calculated later
    }

    // Method to calculate gross salary
    public void calculateGrossSalary(double hraPercentage, double allowances) {
        double hra = (hraPercentage / 100) * basicSalary;
        this.grossSalary = basicSalary + hra + allowances;
    }

    // Method to apply bonus and update salary
    public void applyBonus(double bonus) {
        this.grossSalary += bonus;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("-----------------------------");
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Create employee objects
        Employee emp1 = new Employee("Alice", 101, 50000);
        Employee emp2 = new Employee("Bob", 102, 45000);
        Employee emp3 = new Employee("Charlie", 103, 55000);

        // Calculate gross salary for each employee
        emp1.calculateGrossSalary(20, 5000); // 20% HRA and 5000 allowances
        emp2.calculateGrossSalary(15, 4000); // 15% HRA and 4000 allowances
        emp3.calculateGrossSalary(25, 6000); // 25% HRA and 6000 allowances

        // Apply bonus for each employee
        emp1.applyBonus(3000); // 3000 bonus
        emp2.applyBonus(2000); // 2000 bonus
        emp3.applyBonus(4000); // 4000 bonus

        // Display details for each employee
        System.out.println("Employee Salary Details:");
        System.out.println("-----------------------------");
        emp1.displayDetails();
        emp2.displayDetails();
        emp3.displayDetails();
    }
}
