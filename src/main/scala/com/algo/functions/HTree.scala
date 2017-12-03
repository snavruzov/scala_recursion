package com.algo.functions

import java.awt.geom.{Line2D}
import java.awt._
import java.awt.image.BufferedImage

/**
  * Created by sardor on 12/2/17.
  */
object HTree {

  val size: (Int, Int) = (500, 500)
  // create an image
  val canvas = new BufferedImage(size._1, size._2, BufferedImage.TYPE_INT_RGB)
  // get Graphics2D for the image
  val g: Graphics2D = canvas.createGraphics()

  def draw(n: Int, x: Double, y: Double, size: Double): Unit = {
    if (n == 0) return
    drawH(x, y, size, n)

    val x0: Double = x - size / 2
    val x1: Double = x + size / 2
    val y0: Double = y - size / 2
    val y1: Double = y + size / 2

    // recursively draw 4 half-size H-trees of order n-1
    draw(n - 1, x0, y0, size / 2); // lower left  H-tree
    draw(n - 1, x0, y1, size / 2); // upper left  H-tree
    draw(n - 1, x1, y0, size / 2); // lower right H-tree
    draw(n - 1, x1, y1, size / 2); // upper right H-tree

  }

  private def drawH(x: Double, y: Double, size: Double, n: Int): Unit = {

    val x0: Double = x - size / 2
    val x1: Double = x + size / 2
    val y0: Double = y - size / 2
    val y1: Double = y + size / 2

    // draw a line
    g.draw(new Line2D.Double(x0, y0, x0, y1))
    g.draw(new Line2D.Double(x1, y0, x1, y1))
    g.draw(new Line2D.Double(x0, y, x1, y))
    ()
  }

  def initGraphic(): Unit = {
    // clear background
    g.setColor(Color.WHITE)
    g.fillRect(0, 0, canvas.getWidth, canvas.getHeight)

    // enable anti-aliased rendering (prettier lines and circles)
    // Comment it out to see what this does!
    g.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
      java.awt.RenderingHints.VALUE_ANTIALIAS_ON)

    g.setStroke(new BasicStroke()) // reset to default
    g.setColor(Color.BLACK) // same as Color.BLUE
  }

  def destroyGraphic():Unit = {
    // done with drawing
    g.dispose()
    // write image to a file
    javax.imageio.ImageIO.write(canvas, "png", new java.io.File("/home/sardor/drawing.png"))
    ()
  }


}
