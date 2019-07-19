package jamesco.bots
import robocode.*

class Jamesbot : Robot() {
    override fun run() {
        while (true) {
            ahead(100.0)
            turnGunRight(360.0)
            back(100.0)
        }
    }

    override fun onScannedRobot(event: ScannedRobotEvent?) {
        fire(50.0)
    }
}
