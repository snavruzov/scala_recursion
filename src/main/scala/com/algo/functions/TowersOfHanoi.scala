package com.algo.functions

/******************************************************************************
  *
  *  Solves the Towers of Hanoi problem on n discs. The discs are labeled
  *  in increasing order of size from 1 to n.
  *
  *  %  TowersOfHanoi 3
  *  1 left
  *  2 right
  *  1 left
  *  3 left
  *  1 left
  *  2 right
  *  1 left
  *
  ******************************************************************************/
object TowersOfHanoi {
  private var vector: Vector[String] = Vector.empty

  def moves(n:Int, left: Boolean): Vector[String] = {
    if(n==0) return vector
    moves(n-1, !left)
    if(left) vector = vector :+ s"$n moved to the LEFT"
    else vector = vector :+ s"$n moved to the RIGHT"
    moves(n-1, !left)
  }

}
