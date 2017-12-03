package com.algo.functions

import scala.annotation.tailrec

/**
  * The greatest common divisor of two given numbers
  */
object Euclid {

  @tailrec
  def gcd(p: Int, q: Int):Int ={
    if(q==0) p
    else gcd(q, p%q)
  }
}
