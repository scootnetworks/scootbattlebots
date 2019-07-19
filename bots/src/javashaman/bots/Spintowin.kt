package javashaman.bots
import robocode.*

class Spintowin : Robot() {
    override fun run() {
        while (true) {
            turnGunRight(5.0)
        }
    }

    override fun onScannedRobot(event: ScannedRobotEvent?) {
        val botDistance = event?.distance ?: 10000.0
        if (botDistance < 1000.0) {
            fire(400.0 / botDistance)
        }
    }
}
