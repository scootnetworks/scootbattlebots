package javashaman.bots
import robocode.*
import java.util.*

class Spintowin : Robot() {
    override fun run() {
        while (true) {
            turnGunRight(5.0)
            val randomValues = List(7) { Math.random()*50 }

            ahead(randomValues[0])
            turnGunRight(randomValues[1])
            ahead(randomValues[2])
            turnGunRight(randomValues[3])
            ahead(randomValues[4])
            turnGunRight(randomValues[5])
            ahead(randomValues[6])
        }
    }

    override fun onScannedRobot(event: ScannedRobotEvent?) {
        if (event == null) return
        val botDistance = event.distance
        if (botDistance < 400.0) {
            fire(400.0 / botDistance)
        }
    }
}