package kevinkong
import robocode.*
import java.awt.Color

enum class WallSide {
    NORTH, SOUTH, EAST, WEST
}

class Konginator : Robot() {

//    var isScanning: Boolean = false
    private var didReachWall: Boolean = false
    private var didFindEnemy: Boolean = false
    var robotHitByBullet: String? = null

    override fun run() {
        setAllColors(Color.YELLOW)
        while(!didFindEnemy) {
            scanForEnemy()
        }
    }

    private fun scanForEnemy(defaultScanAngle: Double = 270.0) {
        while (!didReachWall) {
            back(200.0)
            turnLeft(90.0)
            back(200.0)
            turnRight(90.0)
        }
        while (didReachWall) {
            if (this.heading <= 180) {
                val delta = 90 - this.heading
                turnLeft(delta)
            } else {
                val delta = 360 - this.heading
                turnRight(delta)
            }
            ahead(150.0)
            turnGunLeft(360.0)
            back(150.0)
        }

    }

    private fun turnToHeading(heading: Double) {
        if (this.heading <= 180) {
            val oppSide = this.heading + 180.0
            if (heading < oppSide) {
                val delta = heading - this.heading
                turnRight(delta)
            } else {
                val delta = (360.0 - heading)
                turnLeft(delta)
            }
        } else {
            val oppSide = this.heading - 180.0
            if (heading < oppSide) {
                val delta = 360.0 - this.heading + oppSide
                turnRight(delta)
            } else {
                val delta = this.heading + heading
                turnLeft(delta)
            }
        }
    }

    private fun killEnemy(enemyHeading: Double, power: Double) {
        didFindEnemy = true
        turnToHeading(enemyHeading)
        fire(power)
    }

//    override fun onRobotDeath(event: RobotDeathEvent?) {
//        if (event == null) return
//        super.onRobotDeath(event)
//        if (robotHitByBullet == event.name) {
//            scanForEnemy()
//        }
//    }

    override fun onScannedRobot(event: ScannedRobotEvent?) {
        super.onScannedRobot(event)
        if (event == null) return
        var power = 10.0
        if (event.distance < 100) {
            power = 50.0
        }
        fire(power)
    }

    override fun onBulletHit(event: BulletHitEvent?) {
        super.onBulletHit(event)
        if (event == null) return

    }

    override fun onHitRobot(event: HitRobotEvent?) {
        if (event == null) return
        super.onHitRobot(event)
        robotHitByBullet = event.name
        if (event.bearing <= 180) {
//            back(100.0)

            killEnemy(event.bearing, 50.0)
        } else {
//            ahead(100.0)
            killEnemy(event.bearing, 50.0)
        }
    }

    override fun onHitWall(event: HitWallEvent?) {
        super.onHitWall(event)
        didReachWall = true
    }

    override fun onHitByBullet(event: HitByBulletEvent?) {
        super.onHitByBullet(event)
        if (event == null) return
        val delta = event.heading - this.heading
        turnLeft(delta)
        ahead(100.0)
        turnRight(-delta)
        back(100.0)
    }
}
