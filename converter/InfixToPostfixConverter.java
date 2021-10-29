//package assignment7.converter;

/*
 *
 * Name: InfixToPostfixConverter.java
 * Purpose: Converts Infix Expressions into Postfix Expressions
 * Author: grivera64
 *
 */

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfixConverter {

    /* A helper method that checks if the provided character was one of the valid operators */
    public static boolean isOperator(char c) {

        /* If the above code doesn't work, comment it out and uncomment the code below */
        switch (c) {

            case '^':
            case '*':
            case '/':
            case '%':
            case '+':
            case '-':
                return true;
            default:
                return false;

        }

    }

    /* A helper method to calculate precedence levels of an operator */
    public static int calculatePrecedenceLevel(char operator) {

        /* If the above code doesn't work, comment it out and uncomment the code below */
        switch (operator) {

            case '^':
                return 3;
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                throw new IllegalArgumentException("Argument must be a valid operator");

        }

    }

    /* A helper method that determines whether if operator1 has lower precedence under operator2 */
    public static boolean precedence(char operator1, char operator2) {

        /* Local variables */
        int precedence1, precedence2;

        precedence1 = calculatePrecedenceLevel(operator1);          // Additional method for calculating
        precedence2 = calculatePrecedenceLevel(operator2);          // Precedence Level

        return precedence1 <= precedence2;

    }

    /* This method converts a provided infix (assuming it is valid) into its corresponding postfix */
    public static String convertToPostfix(String infix) {

        /* Local Variables */
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        /* Initialize the stack and append to infix */
        stack.push('(');
        infix += ')';

        /* Main Algorithm */
        for (char currentCharacter : infix.toCharArray()) {

            if (stack.isEmpty()) {

                break;

            }

            if (Character.isDigit(currentCharacter)) {

                postfix.append(currentCharacter);

            } else if (currentCharacter == '(') {

                stack.push(currentCharacter);

            } else if (isOperator(currentCharacter)) {

                while (isOperator(stack.peek()) && !precedence(stack.peek(), currentCharacter)) {

                    postfix.append(stack.pop());

                }

                stack.push(currentCharacter);

            } else if (currentCharacter == ')') {

                while (stack.peek() != '(') {

                    postfix.append(stack.pop());

                }

                stack.pop();

            }

        }

        return postfix.toString();

    }

    public static void main(String[] args) {

        /* Local Variables */
        Scanner keyboard = new Scanner(System.in);
        String infix, postfix;

        System.out.println("Please enter an infix expression:");
        infix = keyboard.nextLine();
        postfix = convertToPostfix(infix);

        System.out.println();
        System.out.printf("The original infix expression is:\n%s\n", infix);
        System.out.printf("The expression in postfix notation is:\n%s\n", postfix);

    }

}
