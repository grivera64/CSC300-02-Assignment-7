//package assignment7.evaluation;

/*
 *
 * Name: PostfixEvaluator.java
 * Purpose:
 * Author: grivera64
 * Date:
 *
 */

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator {

    /* A helper method that performs operations based on given arguments */
    public static int calculate(int operand1, char operator, int operand2) {

        /* If the above code doesn't work, comment it out and uncomment the code below */
        switch (operator) {

            case '^':
                return (int) Math.pow(operand1, operand2);
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '%':
                return operand1 % operand2;
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            default:
                throw new IllegalArgumentException("Argument must be a valid operator!");

        }

    }

    /* Helper method that prints out the contents of any Stack */
    public static void printStack(Stack<Integer> stack) {

        for (Integer i : stack) {

            System.out.printf("%s\n", i);

        }

        System.out.println();

    }

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

    /* This method returns the result of a postfix expression */
    public static int evaluatePostfixExpression(String postfix) {

        /* Local Variables */
        Stack<Integer> stack = new Stack<>();
        int x, y, result;

        postfix += ')';

        for (char currentCharacter : postfix.toCharArray()) {

            if (currentCharacter == ')') {

                break;

            }

            if (Character.isDigit(currentCharacter)) {

                stack.push(Character.digit(currentCharacter, 10));
                printStack(stack);

            } else if (isOperator(currentCharacter)) {

                x = stack.pop();
                printStack(stack);

                y = stack.pop();
                printStack(stack);

                result = calculate(y, currentCharacter, x);
                stack.push(result);
                printStack(stack);

            }

        }

        return stack.pop();

    }

    public static void main(String[] args) {

        /* Local variables */
        Scanner keyboard = new Scanner(System.in);
        String postfix;
        int evaluation;

        /* Calculate a Postfix expression */
        System.out.println("Please enter a postfix expression:");
        postfix = keyboard.nextLine();

        System.out.println();
        System.out.printf("The original postfix expression is:\n%s\n", postfix);

        evaluation = evaluatePostfixExpression(postfix);
        System.out.printf("The evaluation of the expression is: %d\n", evaluation);

    }

}
