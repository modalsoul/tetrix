import org.specs2._

class StageSpec extends Specification { def is =                              s2"""
  This is a specification to check Stage

  Moving to the left the current piece should
    change the blocks in the view.                                            $left1

  Moving to the right the current piece should
    change the blocks in the view.                                            $right1
                                                                              
  Moving to the left the current piece should
    change the blocks in the view                                             $left1
    as long as it doesn't hit the wall.                                       $leftWall1

  Rotating the current piece should
  	change the blocks in the view.											  $rotate1
                                                                              """

	import jp.modal.soul.tetrix._
	def stage = new Stage((10,20))
	def left1 = stage.moveLeft().view.blocks map {_.pos} must contain(allOf((0,0),(3,17),(4,17),(5,17),(4,18))).inOrder
	def right1 = stage.moveRight().view.blocks map {_.pos} must contain(allOf((0,0),(5,17),(6,17),(7,17),(6,18))).inOrder

	def leftWall1 = stage.moveLeft().moveLeft().moveLeft().moveLeft().moveLeft().
		view.blocks map {_.pos} must contain(allOf((0,0),(0,17),(1,17),(2,17),(1,18))).inOrder

	def rotate1 = stage.rotateCW().blocks map {_.pos} must contain(exactly(
			(0,0), (5,18), (5,17), (5,16), (6,17)
		)).inOrder
}