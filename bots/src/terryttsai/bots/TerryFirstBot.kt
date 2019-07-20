package terryttsai.bots

import robocode.AdvancedRobot
import robocode.ScannedRobotEvent
import java.awt.Color

class TerryFirstBot : AdvancedRobot() {
    override fun run() {
        setAllColors(Color.RED)
        setTurnRight(10000.0)
        while (true) {
            ahead(200.0)
            turnGunRight(20.0)
        }
    }

    override fun onScannedRobot(event: ScannedRobotEvent?) {
        fire(5.0)
    }
}
