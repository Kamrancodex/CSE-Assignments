import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManagementSystem {

    // Define Student class
    static class Student {
        private String name;
        private int id;
        private ArrayList<Double> grades;

        // Constructor
        public Student(String name, int id) {
            this.name = name;
            this.id = id;
            this.grades = new ArrayList<>();
        }

        // Method to add a grade
        public void addGrade(double grade) {
            if (grade >= 0 && grade <= 100) {
                grades.add(grade);
            } else {
                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
            }
        }

        // Method to calculate the average grade
        public double calculateAverageGrade() {
            if (grades.isEmpty()) {
                return 0.0;
            }
            double total = 0.0;
            for (double grade : grades) {
                total += grade;
            }
            return total / grades.size();
        }

        // Method to find the highest grade
        public double findHighestGrade() {
            if (grades.isEmpty()) {
                return 0.0;
            }
            double highest = grades.get(0);
            for (double grade : grades) {
                if (grade > highest) {
                    highest = grade;
                }
            }
            return highest;
        }

        // Method to find the lowest grade
        public double findLowestGrade() {
            if (grades.isEmpty()) {
                return 0.0;
            }
            double lowest = grades.get(0);
            for (double grade : grades) {
                if (grade < lowest) {
                    lowest = grade;
                }
            }
            return lowest;
        }

        // Method to display the grade report
        public void displayGradeReport() {
            System.out.println("Grade Report for Student:");
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Grades: " + grades);
            System.out.println("Average Grade: " + calculateAverageGrade());
            System.out.println("Highest Grade: " + findHighestGrade());
            System.out.println("Lowest Grade: " + findLowestGrade());
            System.out.println("-----------------------------");
        }
    }

    // Main method to test the system
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            // Display menu
            System.out.println("\n--- Student Grade Management System ---");
            System.out.println("1. Add a new student");
            System.out.println("2. Add grades for a student");
            System.out.println("3. Display grade report for a student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    // Add a new student
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear newline
                    students.add(new Student(name, id));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    // Add grades for a student
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Clear newline
                    Student foundStudent = null;

                    // Find the student by ID
                    for (Student student : students) {
                        if (student.id == studentId) {
                            foundStudent = student;
                            break;
                        }
                    }

                    if (foundStudent == null) {
                        System.out.println("Student with ID " + studentId + " not found.");
                    } else {
                        System.out.print("Enter grades (separated by spaces): ");
                        String[] gradesInput = scanner.nextLine().split(" ");
                        for (String gradeStr : gradesInput) {
                            try {
                                double grade = Double.parseDouble(gradeStr);
                                foundStudent.addGrade(grade);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid grade input: " + gradeStr);
                            }
                        }
                        System.out.println("Grades added successfully!");
                    }
                    break;

                case 3:
                    // Display grade report for a student
                    System.out.print("Enter student ID: ");
                    int reportId = scanner.nextInt();
                    scanner.nextLine(); // Clear newline
                    Student reportStudent = null;

                    // Find the student by ID
                    for (Student student : students) {
                        if (student.id == reportId) {
                            reportStudent = student;
                            break;
                        }
                    }

                    if (reportStudent == null) {
                        System.out.println("Student with ID " + reportId + " not found.");
                    } else {
                        reportStudent.displayGradeReport();
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    // Invalid input
                    System.out.println("Invalid choice. Please select a number between 1 and 4.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
