# scootbattlebots
Robocode Battle Bots, in Kotlin
-----

This repo is a robot battling game using [Robocode](https://robocode.sourceforge.io/).

Setup
---

- Install Intellij + JDK (if needed)
  - Download [IntelliJ Community](https://www.jetbrains.com/idea/download/#section=mac)
  - `brew tap adoptopenjdk/openjdk`
  - `brew cask install adoptopenjdk/openjdk/adoptopenjdk8`
  - Set up [jenv](https://developer.bring.com/blog/configuring-jenv-the-right-way/) for managing multiple JVM versions
  - `jenv add /path/to/jdk8` (should be `/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home`)

- Install Robocode
  - Download [latest](https://sourceforge.net/projects/robocode/files/robocode/) setup jar (not the testing jar)
  - Install to a directory of choice (I used `~/code/kotlin/robocode`)

- Clone this repo (you can create an IntelliJ project directly from the GitHub link)

- File > Project Structure > Modules on left side > Dependencies tab
  - Delete the default module by clicking the minus sign
  - Click the plus sign at the top to add a new module, Select `JVM`, and set the module name as 'bots'
  - On the Dependencies tab, click plus sign at bottom left, choose JARs and add  `<robocode install dir>/libs/robocode.jar`

- You should now be able to build the project
  - Build > Build Project or CMD + F9
