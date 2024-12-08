import java.util.Stack;

public class CommandLineCalculator {

    // Method to check precedence of operators
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    // Method to apply the operator on two operands
    private static double applyOperator(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b != 0) {
                    return a / b;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                return 0;
        }
    }

    // Method to evaluate the expression
    public static double evaluate(String expression) {
        // Stack for numbers
        Stack<Double> values = new Stack<>();
        // Stack for operators
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            // Skip spaces
            if (currentChar == ' ') {
                continue;
            }

            // If the current character is a number, push it to the value stack
            if (Character.isDigit(currentChar)) {
                StringBuilder value = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    value.append(expression.charAt(i));
                    i++;
                }
                values.push(Double.parseDouble(value.toString()));
                i--; // To correct the extra increment in the loop
            }
            // If the current character is '(', push it to the operator stack
            else if (currentChar == '(') {
                operators.push(currentChar);
            }
            // If the current character is ')', solve the expression until '('
            else if (currentChar == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(values.pop(), values.pop(), operators.pop()));
                }
                operators.pop(); // Pop '('
            }
            // If the current character is an operator
            else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(currentChar)) {
                    values.push(applyOperator(values.pop(), values.pop(), operators.pop()));
                }
                operators.push(currentChar);
            }
        }

        // Apply remaining operators
        while (!operators.isEmpty()) {
            values.push(applyOperator(values.pop(), values.pop(), operators.pop()));
        }

        return values.pop();
    }

    // Main method for testing
    public static void main(String[] args) {
        String[] expressions = {
                "5 + 3 * 2",          // Example 1
                "(5 + 3) * 2",        // Example 2
                "10 + 2 * (3 + 4)"    // Example 3
        };

        // Evaluate and display the result for each expression
        for (String expression : expressions) {
            try {
                double result = evaluate(expression);
                System.out.println("Expression: " + expression + " = " + result);
            } catch (Exception e) {
                System.out.println("Error in expression: " + expression + " -> " + e.getMessage());
            }
        }
    }
}
