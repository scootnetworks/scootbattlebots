package craig

import robocode.*


class BotTracker {
    var nearestBotName: String? = null
    var nearestBotDistance: Double = 1000.00

    fun handleBotScanned(event: ScannedRobotEvent?) {

        event?.let {
            if (it.distance.compareTo(nearestBotDistance) <= 0) {
                nearestBotName = it.name
                nearestBotDistance = it.distance
            }
        }
    }
}

class CraigBot : Robot() {

    private val mPositionTracker: PositionTracker = PositionTracker()
    private val mBotTracker: BotTracker = BotTracker()


    override fun run() {
        while (true) {

            // check for nearest bot

            if (mBotTracker.nearestBotName == null) {
                println("We are not tracking the nearest bot... spin!");
                turnGunRight(360.0)
            }
            //println("tracking bot with name ${mBotTracker.nearestBotName} at scannedHeading ${mBotTracker.scannedHeading}");


            //grab my

            println("start ahead");
            ahead(100.0)

            println("start turnGunRight");
            turnGunRight(360.0)

            println("start back");
            back(100.0)
            turnRight(100.0)
        }
    }


    override fun onBulletMissed(event: BulletMissedEvent?) {
        super.onBulletMissed(event)
        println("MISSED ME");

    }

    override fun onHitWall(event: HitWallEvent?) {
        super.onHitWall(event)
        mPositionTracker.onHitWall(event)
    }

    override fun onRobotDeath(event: RobotDeathEvent?) {
        super.onRobotDeath(event)
        // tell the tracker
    }

    override fun onScannedRobot(event: ScannedRobotEvent?) {
        mBotTracker.handleBotScanned(event)
        fire(50.0)
    }
}


class PositionTracker {

    private var currentDegrees = 0;

    public fun onHitWall(event: HitWallEvent?) {
        println("hit wall... rotating 180 degrees")
        currentDegrees += 180 % 360
    }

}