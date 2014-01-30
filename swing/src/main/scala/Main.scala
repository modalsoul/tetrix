package jp.modal.soul.tetrix.swing

improt swing._
import event._

object Main extends SimpleSwingApplication {
	import event.Key._
	import java.awt.{Dimension, Graphics2D, Graphics, Image, Rectangle}
	import java.awt.{Color => AWTColor}

	val bluishGray = new AWTColor(48, 99, 99)
	val bluishSilver = new AWTColor(210, 255, 255)

	def onKeyPress(keyCode: Value) = keyCode match {
		case _ => 
	}

	def onPaint(g:Graphics2D) {

	}

	def top = new MainFrame {
		title = "tetrix"
		contents = mainPanel
	}
	
	def mainPanel = new Panel {
		preferredSize = new Dimension(700, 400)
		focusable = true
		listenTo(keys)
		reactions += {
			case KeyPressed(_, key, _, _) =>
				onKeyPress(key)
				repaint 
		}
		override def paint(g:Graphics2D) {
			g setColor bluishGray
			g fillRect (0, 0, size.width, size.height)
			onPaint(g)
		}
	}
}