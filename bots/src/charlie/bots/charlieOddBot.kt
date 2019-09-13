package src.charlie.bots

import robocode.*
import java.util.*

class charlieOddBot : AdvancedRobot() {
    override fun run() {
        val randomTriple = List(3) { Random().nextDouble()*100 }
        setTurnLeft(12345.0)
        while (true) {
            ahead(100 * randomTriple[0])
            if (randomTriple[1].toInt() % 2 == 0) {
                turnGunRight(2 * randomTriple[2])
            } else {
                turnGunLeft(2 * randomTriple[2])
            }
        }
    }

    override fun onScannedRobot(event: ScannedRobotEvent?) {
        if (event != null) {
            fire(400 / event.distance)
        } else {
            fire(1.5)
        }
    }
}
