package com.algo.functions

import java.awt.geom.Line2D
import java.awt.image.BufferedImage
import java.awt.{Color, Graphics2D}

import com.algo.utils.StdDraw

/**
  * Plot a tree fractal.
  */
object Tree {
  val size: (Int, Int) = (500, 500)
  // create an image
  val canvas = new BufferedImage(size._1, size._2, BufferedImage.TYPE_INT_RGB)
  // get Graphics2D for the image
  val g: Graphics2D = canvas.createGraphics()

  def tree(n:Int, x:Double, y:Double, a:Double, branchRadius:Double):Unit = {
    val bendAngle = Math.toRadians(15)
    val branchAngle = Math.toRadians(37)
    val branchRatio = 0.65

    val cx:Double = x+Math.cos(a)*branchRadius
    val cy:Double = y+Math.sin(a)*branchRadius

    g.setStroke(new StdDraw().setPenRadius(0.001*Math.pow(n.toDouble, 1.2)))
    g.draw(new Line2D.Double(x, y, cx, cy))

    if(n==0) return

    tree(n - 1, cx, cy, a + bendAngle - branchAngle, branchRadius * branchRatio)
    tree(n - 1, cx, cy, a + bendAngle + branchAngle, branchRadius * branchRatio)
    tree(n - 1, cx, cy, a + bendAngle, branchRadius * (1 - branchRatio))


  }

  def initGraphic(): Unit = {
    // clear background
    g.setColor(Color.WHITE)
    g.fillRect(0, 0, canvas.getWidth, canvas.getHeight)
    // enable anti-aliased rendering (prettier lines and circles)
    // Comment it out to see what this does!
    g.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
      java.awt.RenderingHints.VALUE_ANTIALIAS_ON)

    g.setColor(Color.BLACK) // same as Color.BLUE
  }

  def destroyGraphic():Unit = {
    // done with drawing
    g.dispose()
    // write image to a file
    javax.imageio.ImageIO.write(canvas, "png", new java.io.File("/home/sardor/drawingTree.png"))
    ()
  }

}