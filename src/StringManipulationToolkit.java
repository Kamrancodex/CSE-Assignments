import java.util.Scanner;

public class StringManipulationToolkit {

    // Method to reverse a string
    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String input) {
        String reversed = reverseString(input);
        return input.equalsIgnoreCase(reversed); // Ignore case for palindrome check
    }

    // Method to count vowels and consonants
    public static int[] countVowelsAndConsonants(String input) {
        int vowels = 0, consonants = 0;
        input = input.toLowerCase();

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return new int[]{vowels, consonants};
    }

    // Menu-driven program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("\n--- String Manipulation Toolkit ---");
            System.out.println("1. Reverse a String");
            System.out.println("2. Convert to Uppercase");
            System.out.println("3. Convert to Lowercase");
            System.out.println("4. Check Palindrome");
            System.out.println("5. Count Vowels and Consonants");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // Read user's choice
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 6.");
                scanner.next(); // Clear invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline character

            switch (choice) {
                case 1:
                    // Reverse string
                    System.out.print("Enter a string to reverse: ");
                    String strToReverse = scanner.nextLine();
                    System.out.println("Reversed String: " + reverseString(strToReverse));
                    break;

                case 2:
                    // Convert to uppercase
                    System.out.print("Enter a string to convert to uppercase: ");
                    String strToUpper = scanner.nextLine();
                    System.out.println("Uppercase: " + strToUpper.toUpperCase());
                    break;

                case 3:
                    // Convert to lowercase
                    System.out.print("Enter a string to convert to lowercase: ");
                    String strToLower = scanner.nextLine();
                    System.out.println("Lowercase: " + strToLower.toLowerCase());
                    break;

                case 4:
                    // Check palindrome
                    System.out.print("Enter a string to check palindrome: ");
                    String strToCheck = scanner.nextLine();
                    if (isPalindrome(strToCheck)) {
                        System.out.println("The string is a palindrome.");
                    } else {
                        System.out.println("The string is NOT a palindrome.");
                    }
                    break;

                case 5:
                    // Count vowels and consonants
                    System.out.print("Enter a string to count vowels and consonants: ");
                    String strToCount = scanner.nextLine();
                    int[] counts = countVowelsAndConsonants(strToCount);
                    System.out.println("Vowels: " + counts[0]);
                    System.out.println("Consonants: " + counts[1]);
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    // Handle invalid input
                    System.out.println("Invalid choice. Please select a number between 1 and 6.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
