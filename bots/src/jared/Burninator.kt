package jared

import robocode.*

class Burninator : AdvancedRobot() {
    var right = true;

    override fun run() {
        setTurnRight(360.0)
        while (true) {
            ahead(10.0)
        }
    }

    fun initiateTurn() {
        right = !right
        if (right) setTurnRight(360.0)
        else setTurnLeft(360.0)
    }

    override fun onHitByBullet(event: HitByBulletEvent?) {
        if (event == null) return

        stop()
        setTurnRight(90.0)
        ahead(300.0)
        initiateTurn()
    }

    override fun onScannedRobot(event: ScannedRobotEvent?) {
        if (event == null) return
        System.out.println("ScannedRobotEvent(distance:" + event.distance + ")")
        if(event.distance < 75) {
            stop()
            back(150.0)
            initiateTurn()
            return
        }

        if(event.distance < 300) {
            val power = if (others > 1) Rules.MAX_BULLET_POWER / 1.25 else Rules.MAX_BULLET_POWER;
            fire(power)
            initiateTurn()
            return
        }

        stop()
        ahead(50.0)
        initiateTurn()
    }
}
