package com.algo

import com.algo.functions._

/**
  * Created by Sardor Navruzov on 12/2/17.
  */
object AlgorithmDemo extends App {

  val factorial = Factorial.factorial(5)
  println(s"Factorial of 5 is $factorial")

  val gcd = Euclid.gcd(12, 13)
  println(s"The greatest common division of 12 and 13 is $gcd")

  val hanoiTower = TowersOfHanoi.moves(3, left = true)
  println(s"Hanoi Tower's disk movements $hanoiTower")

  HTree.initGraphic()
  HTree.draw(n = 5, x = 250,y = 250,size = 250)
  HTree.destroyGraphic()

  Tree.initGraphic()
  Tree.tree(n=1, x=250, y=250, a=Math.PI / 2, branchRadius = -30)
  Tree.destroyGraphic()

}
