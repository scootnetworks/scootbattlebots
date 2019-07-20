package javashaman.bots
import robocode.*

class Spintowin : Robot() {
    override fun run() {
        while (true) {
            turnGunRight(5.0)
            val randomValues = List(6) { Random.nextDouble(0, 100) }

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
        val botDistance = event?.distance ?: 10000.0
        if (botDistance < 1000.0) {
            fire(1000.0 / botDistance)
        }
    }
}