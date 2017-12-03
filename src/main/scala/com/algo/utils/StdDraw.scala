package com.algo.utils

import java.awt.BasicStroke

/**
  * Created by sardor on 12/2/17.
  */
class StdDraw {
  private val DEFAULT_SIZE:Int = 512

  def setPenRadius(radius: Double):BasicStroke = {
    val scaledPenRadius: Float = (radius*DEFAULT_SIZE).toFloat
    new BasicStroke(scaledPenRadius, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)
  }
}
