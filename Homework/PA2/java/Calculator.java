 /**
 * Emanuel Juarez
 * CS 240.01
 * Programming Assingment 2
 * 05/05/2016
 * COPYRIGHT: smanna@cpp.edu
 * CS 240 Spring 2016
 * Programming Assignment 2
 *
 * STUDENTS SHOULD COMPLETE THIS CODE.
 * You will upload this code to Blackboard.
 *
 * If you do not write enough comments, at least two points
 * will be deducted from your assignment. Also make sure you
 * follow the coding conventions.
 *
 *  Students need to implement a Calculator using the framework provided. Feel
 *  free to add your own fields and methods besides ones already provided. Please do not make
 *  any changes to the provided method signatures. If you do so, your code
 * cannot be run automatically, and you will not be graded.
 *
 *  ** YOUR RESULTS SHOULD BE ROUNDED TO THREE DECIMAL PLACES. IF YOU FAIL TO DO
 *  SO, YOU WILL BE PENALIZED BY 1 POINT.
 *  ** YOU SHOULD PROPOERLY COMMENT YOUR CODE, OTHERWISE YOU WILL BE PENALIZED
 *  BY 5 POINTS.
 *
 **/

import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Calculator
{
  //a stack for operators, operands, and the result from each popStackAndSolve
  private Stack<Double> operands;
  private Stack<Character> operators;
  private double result;
  

    //initializing the stacks and setting result to 0.
  public Calculator()
  {
    operators = new Stack<Character>();
    operands = new Stack<Double>();
    result = 0;
    // TODO (Student)
  }

  //Constructor with manual debug setting
  public Calculator(boolean DEBUG) {
    // TODO (Student): Optional
  }

  /** Returns true if the new character has precedence to be pushed on to the
  *   stack. Returns false if not.
  *   @param previous operator already on the stack
  *   @param newChar operator being added to the stack
  *   @return boolean of whether the operator has precedence
  */
  private boolean hasPrecedence(Character previous, Character newChar)
  {
    //if the previous has top precedence then the new doesn't
    if (previous == '*' || previous == '/')
      return false;
    //subtract previous first then new
    else if (previous == '-' && newChar == '-')
      return false;
    //subtract previous then add new
    else if (previous == '-' && newChar == '+')
      return false;
    else {
      return true;
    }
  }

  /** Pops two operands and one operator and performs the operation.
  *   @param operands stack of the operands
  *   @param operators stack of the operators
  *   @return answer to the operation
  */
  private double popStackAndSolve(Stack<Double> operands,Stack<Character>
                                  operators)
  {
    double operand1,operand2,answer;
    char operator;
    operand2 = operands.pop(); //pop the second first because stack ordering
    operand1 = operands.pop();
    operator = operators.pop();
    answer = calc(operand1,operand2,operator);
    return answer;
  }

  /** @param operand1 the first operand in the equation
  *   @param operand2 the second operand in the equation
  *   @param operator the operator to perform on the two operands
  *   @return the answer
  *    performs the arithmetic of the given operation
  */
  public double calc(double operand1, double operand2, char operator)
  {
    if (operator == '+')
      return operand1 + operand2;
    else if (operator == '-')
      return operand1 - operand2;
    else if (operator == '*')
      return operand1 * operand2;
    else if (operator == '/')
      return operand1 / operand2;
    else
      return 0;
  }

  /** Solves an infix equation and returns the answer as a Double. Limits to 3
  *   decimal places.
  *   @param equation infix String equation to be solved.
  *   @return double answer to equation
  */
  public Double solve(String equation)
  {
    //temporary string to holds digits that will be parsed to double
    String tempOperand = "";
    //character you are currently at, so you don't have to keep repeating equation.charAt[i]
    char currChar;
    //double that has been parsed from the string
    double parsedOperand;
    //traverse the string, if digit, append to tempstring
    //if operator, parse that temp string, and test conditions of operator precedence and stack
    for (int i = 0; i < equation.length(); i++)
    {
      currChar = equation.charAt(i);
      if (Character.isDigit(currChar) || currChar == '.')
      {
        tempOperand += currChar;
      }
      else if (isOperator(currChar))
      {
        if (!tempOperand.isEmpty())
        {
          parsedOperand = Double.parseDouble(tempOperand);
          operands.push(parsedOperand);
          tempOperand = "";
        }
        while (!operators.empty() && !hasPrecedence(operators.peek(), currChar))
        {
            result = popStackAndSolve(operands, operators);
            operands.push(result);
        }
        operators.push(currChar);
      }
      else if (currChar == '(')
        operators.push(currChar);
      else if (currChar == ')')
      {
        if (!tempOperand.isEmpty())
        {
          parsedOperand = Double.parseDouble(tempOperand);
          operands.push(parsedOperand);
          tempOperand = "";
        }
        while (operators.peek() != '(')
        {
          result = popStackAndSolve(operands, operators);
          operands.push(result);
        }
        operators.pop();
      }
    }
    //once for loop is completed, assure the temp string is also empty
    if (!tempOperand.isEmpty())
    {
      parsedOperand = Double.parseDouble(tempOperand);
      operands.push(parsedOperand);
      tempOperand = "";
    }
    //then, make sure the operator stack is empty
    while (!operators.empty())
    {
      result = popStackAndSolve(operands, operators);
      operands.push(result);
    }
    //finally, assure the double is in the proper format
    double answer = operands.pop();
    DecimalFormat formatter = new DecimalFormat("#.###");
    return Double.parseDouble(formatter.format(answer));
  }
  //method to simplify the operator check
  public boolean isOperator(char op)
  {
    if (op == '+' || op == '-' || op == '*' || op == '/')
      return true;
    else
      return false;
  }
}

  