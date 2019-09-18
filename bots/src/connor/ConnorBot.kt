package connor

import robocode.*
import java.awt.Color

class ConnorBot: AdvancedRobot() {
  override fun run() {
    setAllColors(Color.BLACK)
    //setTurnRight(10000.0)
    while (true) {
      ahead(200.0)

      turnGunRight(20.0)
      turnRadarRight(20.0)
    }
  }

  override fun onScannedRobot(event: ScannedRobotEvent?) {
    if (event == null) {
      return
    }

    stop()

    val bearingDelta = this.gunHeading - event.bearingRadians
    if (bearingDelta > 0 ){
      turnGunLeftRadians(bearingDelta)
    } else {
      turnGunRightRadians(bearingDelta)
    }
    fire(5.0)

    resume()
  }

  override fun onHitWall(event: HitWallEvent?) {
    setTurnRightRadians(2.0)
  }

  override fun onHitByBullet(event: HitByBulletEvent?) {
    super.onHitByBullet(event)

    if (event == null) {
      return
    }
    val bearingDelta = this.headingRadians - event.bearingRadians

    if (bearingDelta > 0) {
      turnGunLeft(bearingDelta)
    } else {
      turnGunRight(bearingDelta)
    }

    fire(5.0)

  }
}

