package angela

import robocode.*

class Angelabot : Robot() {
    override fun run() {
        while (true) {
            ahead(100.0)
            turnRight(45.0)
            turnGunLeft(360.0)
        }
    }

    override fun onScannedRobot(event: ScannedRobotEvent?) {
        fire(100.0)
    }
}
