import java.util.Scanner;

public class TemperatureConverter {

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Celsius to Kelvin
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Method to convert Fahrenheit to Kelvin
    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }

    // Method to convert Kelvin to Celsius
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Method to convert Kelvin to Fahrenheit
    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display the menu
            System.out.println("\n--- Temperature Converter ---");
            System.out.println("1. Convert Celsius to Fahrenheit and Kelvin");
            System.out.println("2. Convert Fahrenheit to Celsius and Kelvin");
            System.out.println("3. Convert Kelvin to Celsius and Fahrenheit");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Validate input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Celsius to Fahrenheit and Kelvin
                    System.out.print("Enter temperature in Celsius: ");
                    double celsius = scanner.nextDouble();
                    System.out.println("Fahrenheit: " + celsiusToFahrenheit(celsius));
                    System.out.println("Kelvin: " + celsiusToKelvin(celsius));
                    break;

                case 2:
                    // Fahrenheit to Celsius and Kelvin
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double fahrenheit = scanner.nextDouble();
                    System.out.println("Celsius: " + fahrenheitToCelsius(fahrenheit));
                    System.out.println("Kelvin: " + fahrenheitToKelvin(fahrenheit));
                    break;

                case 3:
                    // Kelvin to Celsius and Fahrenheit
                    System.out.print("Enter temperature in Kelvin: ");
                    double kelvin = scanner.nextDouble();
                    if (kelvin < 0) {
                        System.out.println("Invalid input. Kelvin cannot be negative.");
                    } else {
                        System.out.println("Celsius: " + kelvinToCelsius(kelvin));
                        System.out.println("Fahrenheit: " + kelvinToFahrenheit(kelvin));
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
