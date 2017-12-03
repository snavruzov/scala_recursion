package com.algo.functions


/******************************************************************************
  *
  *  Reads a long type command-line argument n, and prints n! = 1 * 2 * ... * n
  *  to standard output.
  *
  *  % Factorial 0
  *  1
  *
  *  % Factorial 1
  *  1
  *
  *  % Factorial 5
  *  120
  *
  *  % Factorial 12
  *  479001600
  *
  *  % Factorial 20
  *  2432902008176640000
  *
  *  % Factorial -10
  *  java.lang.RuntimeException: Underflow error in factorial
  *
  *  % Factorial 21
  *  java.lang.RuntimeException: Overflow error in factorial
  *
  *
  *  Remarks
  *  -------
  *   - Would overflow a long if n > 20
  *   - Need to use extended precision arithmetic to handle bigger factorials
  *
  ******************************************************************************/

object Factorial {

  @throws(classOf[RuntimeException])
  def factorial(n: Long):Long = n match {
    case x if x<0 => throw new RuntimeException("Underflow error in factorial")
    case x if x>20 => throw new RuntimeException("Overflow error in factorial")
    case x if x==0 => 1
    case _ => n*factorial(n-1)
  }
}

