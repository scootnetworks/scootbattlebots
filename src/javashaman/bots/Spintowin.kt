package javashaman.bots
import robocode.*

class Spintowin : Robot() {
    override fun run() {
        while (true) {
            turnGunRight(10)
        }
    }

    override fun onScannedRobot(event: ScannedRobotEvent?) {
        if (event.Distance < 100) {
            Fire(50);
        }
    }
}
