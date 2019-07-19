package javashaman.bots
import robocode.*

class Spintowin : Robot() {
    override fun run() {
        while (true) {
            turnGunRight(10.0)
        }
    }

    override fun onScannedRobot(event: ScannedRobotEvent?) {
        val botDistance = event?.distance ?: 10000.0
        if (botDistance < 100.0) {
            fire(50.0)
        }
    }
}
